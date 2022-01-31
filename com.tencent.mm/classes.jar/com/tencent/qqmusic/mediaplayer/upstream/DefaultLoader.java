package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class DefaultLoader
  extends Thread
  implements Loader
{
  private static final int MSG_LOAD_CANCELLED = 5;
  private static final int MSG_LOAD_COMPLETED = 3;
  private static final int MSG_LOAD_ERROR = 4;
  private static final int MSG_LOAD_PROGRESS = 2;
  private static final int MSG_LOAD_STARTED = 1;
  private static final int SIZE_UNSET = -1;
  private static final String TAG = "DefaultLoader";
  private final Chunk END_OF_QUEUE = new Chunk(0, 0L, 0L);
  private IDataSink cacheSink;
  private volatile boolean cancelled = false;
  private final BlockingQueue<Chunk> chunks;
  private final Handler eventHandler;
  private volatile boolean isLoading = false;
  private volatile boolean shutdown;
  private IDataSource upstream;
  private long upstreamSize = -1L;
  private final UriLoader uriLoader;
  
  protected DefaultLoader(Looper paramLooper, UriLoader paramUriLoader, Loader.Listener paramListener)
  {
    this.uriLoader = paramUriLoader;
    this.eventHandler = new Handler(paramLooper, new DefaultLoader.1(this, paramListener));
    this.chunks = new LinkedBlockingQueue(1);
  }
  
  private boolean loadChunk(Chunk paramChunk)
  {
    if ((this.upstream == null) || (this.cacheSink == null)) {
      throw new IllegalStateException("loader must be prepared first!");
    }
    long l2 = paramChunk.start;
    long l3 = paramChunk.size;
    Logger.d("DefaultLoader", "[loadChunk] enter. startPosition: " + l2 + ", chunkSize: " + l3);
    paramChunk = new byte[paramChunk.bufferSize];
    int j;
    int k;
    label94:
    long l1;
    int i;
    if (l3 == -1L)
    {
      j = 1;
      if (j == 0) {
        break label203;
      }
      k = paramChunk.length;
      l1 = 0L;
      i = 0;
    }
    label398:
    label400:
    for (;;)
    {
      long l4 = l2 + l1;
      for (;;)
      {
        int m;
        try
        {
          m = this.upstream.readAt(l4, paramChunk, 0, k);
          if (m != -1) {
            break label236;
          }
          Logger.i("DefaultLoader", "[loadChunk] read EOF.");
          Logger.d("DefaultLoader", "[loadChunk] exit. startPosition: " + l2 + ", loadedBytes: " + l1 + ", this.cancelled: " + this.cancelled + ", shutdown: " + this.shutdown);
          if (i != 0) {
            break label398;
          }
          return true;
        }
        catch (IOException paramChunk)
        {
          throw new IOException(new SourceReadException(paramChunk, ""));
        }
        j = 0;
        break;
        label203:
        k = (int)Math.min(paramChunk.length, l3);
        break label94;
        label236:
        if (m == 0)
        {
          Logger.d("DefaultLoader", "[loadChunk] read none.");
        }
        else
        {
          if (m < 0) {
            throw new IOException(new SourceReadException("read error: ".concat(String.valueOf(m)), ""));
          }
          for (;;)
          {
            try
            {
              i = this.cacheSink.write(l4, paramChunk, 0, m);
              long l5 = i;
              l1 = m + l1;
              this.eventHandler.removeMessages(2);
              this.eventHandler.obtainMessage(2, (int)l2, (int)(l5 + l4 - 1L)).sendToTarget();
              if ((this.cancelled) || (this.shutdown))
              {
                i = 1;
                if (i == 0) {
                  if ((j != 0) || (l1 < l3)) {
                    break label400;
                  }
                }
              }
            }
            catch (IOException paramChunk)
            {
              throw new IOException(new SinkWriteException(paramChunk));
            }
            i = 0;
          }
        }
      }
      return false;
    }
  }
  
  public void cancelLoading()
  {
    Logger.i("DefaultLoader", "[cancelLoading] cancel");
    this.uriLoader.cancelLoading();
    this.cancelled = true;
  }
  
  protected abstract IDataSink createCacheSink(StreamingRequest paramStreamingRequest);
  
  protected abstract IDataSource createUpStream(StreamingRequest paramStreamingRequest);
  
  public long getUpstreamSize()
  {
    return this.upstreamSize;
  }
  
  public boolean isLoading()
  {
    if (this.uriLoader.isLoading()) {
      return true;
    }
    return this.isLoading;
  }
  
  public void prepare()
  {
    if (this.upstream != null) {
      this.upstream.close();
    }
    if (this.cacheSink != null) {
      this.cacheSink.close();
    }
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.shutdown) {}
      try
      {
        Chunk localChunk = (Chunk)this.chunks.take();
        if (this.END_OF_QUEUE == localChunk)
        {
          Logger.i("DefaultLoader", "[run] end of queue!");
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.w("DefaultLoader", "[run] interrupted when taking chunk");
        return;
      }
      try
      {
        if (!loadChunk(localInterruptedException)) {
          break label93;
        }
        this.eventHandler.obtainMessage(3).sendToTarget();
      }
      catch (IOException localIOException)
      {
        Logger.e("DefaultLoader", "[run] got error!", localIOException);
        this.eventHandler.obtainMessage(4, localIOException).sendToTarget();
      }
      continue;
      label93:
      this.eventHandler.obtainMessage(5).sendToTarget();
    }
  }
  
  public void shutdown()
  {
    this.shutdown = true;
    this.chunks.offer(this.END_OF_QUEUE);
    join();
    try
    {
      if (this.upstream != null) {
        this.upstream.close();
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          if (this.cacheSink != null) {
            this.cacheSink.close();
          }
          return;
        }
        catch (IOException localIOException2)
        {
          Logger.w("DefaultLoader", "[shutdown] failed to close cacheSink");
        }
        localIOException1 = localIOException1;
        Logger.w("DefaultLoader", "[shutdown] failed to close upstream");
      }
    }
  }
  
  public void startLoading(Chunk paramChunk)
  {
    Logger.i("DefaultLoader", "[startLoading] chunk: ".concat(String.valueOf(paramChunk)));
    this.chunks.clear();
    if (!this.chunks.offer(paramChunk)) {
      throw new IllegalStateException("exceeds maximum of queue!");
    }
    this.isLoading = true;
    Logger.i("DefaultLoader", "[handleMessage] loading = true");
    this.cancelled = false;
    if (getState() == Thread.State.NEW) {
      this.uriLoader.startLoading(0, TimeUnit.MILLISECONDS, new DefaultLoader.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
 * JD-Core Version:    0.7.0.1
 */