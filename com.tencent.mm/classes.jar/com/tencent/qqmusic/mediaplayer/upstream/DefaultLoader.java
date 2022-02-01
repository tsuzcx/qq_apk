package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  protected DefaultLoader(Looper paramLooper, UriLoader paramUriLoader, final Loader.Listener paramListener)
  {
    this.uriLoader = paramUriLoader;
    this.eventHandler = new Handler(paramLooper, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(76497);
        if (paramListener == null)
        {
          AppMethodBeat.o(76497);
          return false;
        }
        switch (paramAnonymousMessage.what)
        {
        case 1: 
        default: 
          DefaultLoader.access$002(DefaultLoader.this, false);
          Logger.i("DefaultLoader", "[handleMessage] loading = false");
          switch (paramAnonymousMessage.what)
          {
          default: 
            AppMethodBeat.o(76497);
            return false;
          }
          break;
        }
        paramListener.onLoadProgress(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
        AppMethodBeat.o(76497);
        return true;
        paramListener.onLoadError((IOException)paramAnonymousMessage.obj);
        AppMethodBeat.o(76497);
        return true;
        paramListener.onLoadCompleted();
        AppMethodBeat.o(76497);
        return true;
        paramListener.onLoadCancelled(DefaultLoader.this.shutdown);
        AppMethodBeat.o(76497);
        return true;
      }
    });
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
    if (this.uriLoader.isLoading()) {}
    while ((this.isLoading) && (!this.shutdown)) {
      return true;
    }
    return false;
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
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:shutdown	Z
    //   4: ifne +32 -> 36
    //   7: aload_0
    //   8: getfield 85	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:chunks	Ljava/util/concurrent/BlockingQueue;
    //   11: invokeinterface 254 1 0
    //   16: checkcast 53	com/tencent/qqmusic/mediaplayer/upstream/Chunk
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 58	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:END_OF_QUEUE	Lcom/tencent/qqmusic/mediaplayer/upstream/Chunk;
    //   24: aload_1
    //   25: if_acmpne +93 -> 118
    //   28: ldc 27
    //   30: ldc_w 256
    //   33: invokestatic 159	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: ldc 27
    //   38: new 123	java/lang/StringBuilder
    //   41: dup
    //   42: ldc_w 258
    //   45: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 62	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:cancelled	Z
    //   52: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: ldc 170
    //   57: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 92	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:shutdown	Z
    //   64: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   67: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 159	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 104	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:upstream	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   77: ifnull +12 -> 89
    //   80: aload_0
    //   81: getfield 104	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:upstream	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   84: invokeinterface 244 1 0
    //   89: aload_0
    //   90: getfield 100	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:cacheSink	Lcom/tencent/qqmusic/mediaplayer/downstream/IDataSink;
    //   93: ifnull +12 -> 105
    //   96: aload_0
    //   97: getfield 100	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:cacheSink	Lcom/tencent/qqmusic/mediaplayer/downstream/IDataSink;
    //   100: invokeinterface 245 1 0
    //   105: return
    //   106: astore_1
    //   107: ldc 27
    //   109: ldc_w 260
    //   112: invokestatic 263	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto -79 -> 36
    //   118: aload_0
    //   119: aload_1
    //   120: invokespecial 265	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:loadChunk	(Lcom/tencent/qqmusic/mediaplayer/upstream/Chunk;)Z
    //   123: ifeq +42 -> 165
    //   126: aload_0
    //   127: getfield 78	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:eventHandler	Landroid/os/Handler;
    //   130: iconst_3
    //   131: invokevirtual 268	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   134: invokevirtual 219	android/os/Message:sendToTarget	()V
    //   137: goto -137 -> 0
    //   140: astore_1
    //   141: ldc 27
    //   143: ldc_w 270
    //   146: aload_1
    //   147: invokestatic 274	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_0
    //   151: getfield 78	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:eventHandler	Landroid/os/Handler;
    //   154: iconst_4
    //   155: aload_1
    //   156: invokevirtual 277	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   159: invokevirtual 219	android/os/Message:sendToTarget	()V
    //   162: goto -162 -> 0
    //   165: aload_0
    //   166: getfield 78	com/tencent/qqmusic/mediaplayer/upstream/DefaultLoader:eventHandler	Landroid/os/Handler;
    //   169: iconst_5
    //   170: invokevirtual 268	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   173: invokevirtual 219	android/os/Message:sendToTarget	()V
    //   176: goto -176 -> 0
    //   179: astore_1
    //   180: ldc 27
    //   182: ldc_w 279
    //   185: invokestatic 263	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: goto -99 -> 89
    //   191: astore_1
    //   192: ldc 27
    //   194: ldc_w 281
    //   197: invokestatic 263	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	DefaultLoader
    //   19	6	1	localChunk	Chunk
    //   106	14	1	localInterruptedException	java.lang.InterruptedException
    //   140	16	1	localIOException1	IOException
    //   179	1	1	localIOException2	IOException
    //   191	1	1	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   7	20	106	java/lang/InterruptedException
    //   118	137	140	java/io/IOException
    //   165	176	140	java/io/IOException
    //   73	89	179	java/io/IOException
    //   89	105	191	java/io/IOException
  }
  
  public void shutdown()
  {
    Logger.i("DefaultLoader", "[shutdown] enter");
    this.shutdown = true;
    this.chunks.offer(this.END_OF_QUEUE);
    cancelLoading();
    Logger.i("DefaultLoader", "[shutdown] exit");
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
      this.uriLoader.startLoading(0, TimeUnit.MILLISECONDS, new UriLoader.Callback()
      {
        public void onCancelled()
        {
          AppMethodBeat.i(76523);
          DefaultLoader.this.eventHandler.obtainMessage(5).sendToTarget();
          AppMethodBeat.o(76523);
        }
        
        public void onFailed(Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(76522);
          DefaultLoader.this.eventHandler.obtainMessage(4, new IOException("failed to load uri", paramAnonymousThrowable)).sendToTarget();
          AppMethodBeat.o(76522);
        }
        
        public void onSucceed(StreamingRequest paramAnonymousStreamingRequest)
        {
          AppMethodBeat.i(76521);
          Logger.i("DefaultLoader", "[startLoading] uriLoader.startLoading onSucceed");
          IDataSource localIDataSource = DefaultLoader.this.createUpStream(paramAnonymousStreamingRequest);
          try
          {
            localIDataSource.open();
            DefaultLoader.access$202(DefaultLoader.this, localIDataSource.getSize());
            paramAnonymousStreamingRequest = DefaultLoader.this.createCacheSink(paramAnonymousStreamingRequest);
          }
          catch (IOException localIOException1)
          {
            try
            {
              paramAnonymousStreamingRequest.open();
              DefaultLoader.access$402(DefaultLoader.this, paramAnonymousStreamingRequest);
              DefaultLoader.access$502(DefaultLoader.this, localIDataSource);
              DefaultLoader.this.start();
              AppMethodBeat.o(76521);
              return;
              localIOException1 = localIOException1;
              DefaultLoader.this.eventHandler.obtainMessage(4, localIOException1).sendToTarget();
            }
            catch (IOException localIOException2)
            {
              for (;;)
              {
                DefaultLoader.this.eventHandler.obtainMessage(4, localIOException2).sendToTarget();
              }
            }
          }
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
 * JD-Core Version:    0.7.0.1
 */