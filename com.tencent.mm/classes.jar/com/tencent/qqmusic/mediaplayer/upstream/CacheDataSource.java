package com.tencent.qqmusic.mediaplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.perf.Collectable;
import com.tencent.qqmusic.mediaplayer.perf.ErrorUploadCollector;
import com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CacheDataSource
  implements Collectable, IDataSource
{
  private static final int CHUNK_LOAD_BUFFER_SIZE = 8192;
  private static final int DISCONTINUITY_THRESHOLD = 8192;
  static final long NO_RESET_PENDING = -9223372036854775808L;
  private static final int PROFILE_ending = 10;
  private static final int PROFILE_isCached = 8;
  private static final int PROFILE_lock = 5;
  private static final int PROFILE_onBufferEnd = 7;
  private static final int PROFILE_onBufferStarted = 4;
  private static final int PROFILE_onBytesTransferred = 9;
  private static final int PROFILE_onBytesTransferring = 3;
  private static final int PROFILE_onReadContinuity = 1;
  private static final int PROFILE_onReadDiscontinuity = 2;
  private static final int PROFILE_readAt = 6;
  private static final int PROFILE_total = 0;
  private static final int READ_WAIT_TIMEOUT = 30000;
  private static final String TAG = "CacheDataSource";
  private static final String[] profiles = { "total", "onReadContinuity", "onReadDiscontinuity", "onBytesTransferring", "onBufferStarted", "lock", "readAt", "onBufferEnd", "isCached", "onBytesTransferred", "ending" };
  private final IDataSource cacheSource;
  private final DataRangeTracker cachedDataTracker;
  private long[] costs = new long[profiles.length];
  private long currentLoadStartPosition = -9223372036854775808L;
  private Chunk currentLoadingChunk;
  private CacheDataSource.Listener listener;
  private boolean loadFinished;
  private final Loader loader;
  private long nextContinuousPosition;
  private boolean opened;
  protected long pendingRestartPositionByte;
  protected long pendingStartPositionByte;
  private TimerTask pendingTask;
  private Timer restartHandler;
  
  public CacheDataSource(IDataSource paramIDataSource1, IDataSource paramIDataSource2, IDataSink paramIDataSink, Looper paramLooper)
  {
    this(paramIDataSource2, new CacheDataSource.1(paramLooper, paramIDataSource1, paramIDataSink));
  }
  
  public CacheDataSource(IDataSource paramIDataSource, Loader.Factory paramFactory)
  {
    this.cacheSource = paramIDataSource;
    this.cachedDataTracker = new DataRangeTracker();
    this.opened = false;
    this.loadFinished = false;
    this.loader = paramFactory.createLoader(new CacheDataSource.LoaderListener(this, null));
  }
  
  private void clearState()
  {
    this.loadFinished = false;
  }
  
  private boolean isCached(long paramLong, int paramInt)
  {
    long l2 = this.loader.getUpstreamSize();
    long l1 = paramLong;
    int i = paramInt;
    if (l2 > 0L)
    {
      l1 = paramLong;
      i = paramInt;
      if (paramInt + paramLong > l2 - 1L)
      {
        paramInt = (int)(l2 - paramLong - 1L);
        l1 = paramLong;
        i = paramInt;
        if (paramInt < 0)
        {
          l1 = paramLong + paramInt;
          i = 0;
        }
      }
    }
    return this.cachedDataTracker.isCached(l1, i);
  }
  
  private void onReadContinuity(long paramLong) {}
  
  private void onReadDiscontinuity(long paramLong, boolean paramBoolean)
  {
    if (paramLong == this.currentLoadStartPosition)
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] same same position as current load. skip.");
      return;
    }
    long l = paramLong - this.currentLoadStartPosition;
    if ((l >= 0L) && (l < 8192L))
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] position diff is too small(" + l + "). skip.");
      return;
    }
    synchronized (this.cachedDataTracker)
    {
      paramLong = Math.max(paramLong, this.cachedDataTracker.findStart(paramLong));
      if (this.currentLoadStartPosition == paramLong)
      {
        Logger.i("CacheDataSource", "[onReadDiscontinuity] loadStartPosition is the same as current load. skip.");
        return;
      }
    }
    l = paramLong - this.currentLoadStartPosition;
    if ((l >= 0L) && (l < 8192L))
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] loadStartPosition diff is too small(" + l + "). skip.");
      return;
    }
    if (paramLong == getSize())
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] no need to load from end. skip.");
      return;
    }
    ??? = this.currentLoadingChunk;
    if ((paramBoolean) && (??? != null) && (((Chunk)???).contains(paramLong)))
    {
      Logger.i("CacheDataSource", String.format("[onReadDiscontinuity] position is cached and loadStartPosition(%d) is under loading(%s). skip.", new Object[] { Long.valueOf(paramLong), ??? }));
      return;
    }
    restartLoading(paramLong);
  }
  
  private void reportProfiling() {}
  
  /* Error */
  private void restartLoading(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 50
    //   4: new 199	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 257
    //   11: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: lload_1
    //   15: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   18: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 195	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: lload_1
    //   26: putfield 259	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:pendingStartPositionByte	J
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 131	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loadFinished	Z
    //   34: aload_0
    //   35: getfield 142	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loader	Lcom/tencent/qqmusic/mediaplayer/upstream/Loader;
    //   38: invokeinterface 262 1 0
    //   43: ifeq +22 -> 65
    //   46: aload_0
    //   47: getfield 127	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cachedDataTracker	Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   50: invokevirtual 265	com/tencent/qqmusic/mediaplayer/DataRangeTracker:block	()V
    //   53: aload_0
    //   54: getfield 142	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loader	Lcom/tencent/qqmusic/mediaplayer/upstream/Loader;
    //   57: invokeinterface 268 1 0
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload_0
    //   66: invokespecial 270	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:clearState	()V
    //   69: aload_0
    //   70: invokespecial 154	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:startLoadingIfNeeded	()Z
    //   73: pop
    //   74: goto -12 -> 62
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	CacheDataSource
    //   0	82	1	paramLong	long
    //   77	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	62	77	finally
    //   65	74	77	finally
  }
  
  @SuppressLint({"DefaultLocale"})
  private void scheduleRestart(long paramLong1, long paramLong2)
  {
    try
    {
      Logger.i("CacheDataSource", String.format("[scheduleRestart] position: %d, delay: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      if (this.restartHandler == null) {
        this.restartHandler = new Timer("CacheDataSource.Restart");
      }
      if (this.pendingTask != null)
      {
        this.pendingTask.cancel();
        this.restartHandler.purge();
      }
      this.pendingTask = new CacheDataSource.2(this, paramLong1);
      this.restartHandler.schedule(this.pendingTask, paramLong2);
      return;
    }
    finally {}
  }
  
  private boolean startLoadingIfNeeded()
  {
    for (;;)
    {
      long l;
      try
      {
        boolean bool = this.loadFinished;
        if (bool)
        {
          bool = false;
          return bool;
        }
        l = this.pendingStartPositionByte;
        this.pendingStartPositionByte = -9223372036854775808L;
        if (!this.opened)
        {
          if (l == -9223372036854775808L)
          {
            Logger.i("CacheDataSource", "[startLoadingIfNeeded] start a fresh load");
            localChunk1 = new Chunk(8192, 0L, -1L);
            this.currentLoadingChunk = localChunk1;
            this.currentLoadStartPosition = localChunk1.start;
            this.cachedDataTracker.unblock();
            this.loader.startLoading(localChunk1);
            bool = true;
            continue;
          }
          Logger.i("CacheDataSource", "[startLoadingIfNeeded] start a pending load: " + l);
          Chunk localChunk1 = new Chunk(8192, l, -1L);
          continue;
        }
        if (l != -9223372036854775808L) {
          break label173;
        }
      }
      finally {}
      throw new IllegalStateException("pendingStartPositionByte must be set!");
      label173:
      Logger.i("CacheDataSource", "[startLoadingIfNeeded] restart a pending load: " + l);
      Chunk localChunk2 = new Chunk(8192, l, -1L);
    }
  }
  
  public void accept(ErrorUploadCollector paramErrorUploadCollector) {}
  
  public void accept(PlayerInfoCollector paramPlayerInfoCollector)
  {
    int k = 1;
    int i = 1;
    long l = 0L;
    while (i < profiles.length)
    {
      l += this.costs[i];
      i += 1;
    }
    double d = (this.costs[0] - l) / this.costs.length;
    long[] arrayOfLong = new long[this.costs.length];
    System.arraycopy(this.costs, 0, arrayOfLong, 0, this.costs.length);
    i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfLong.length) {
        break;
      }
      arrayOfLong[i] = Math.max(arrayOfLong[i] - d, 0L);
      i += 1;
    }
    while (j < profiles.length)
    {
      paramPlayerInfoCollector.putLong("CacheDataSource." + profiles[j], arrayOfLong[j] / 1000000L);
      j += 1;
    }
  }
  
  public void close()
  {
    Logger.i("CacheDataSource", "[close] enter.");
    if (!this.opened) {
      return;
    }
    this.cachedDataTracker.abandonLock();
    try
    {
      this.loader.shutdown();
      label32:
      this.cacheSource.close();
      if (this.listener != null) {
        this.listener.onTransferEnd();
      }
      reportProfiling();
      this.opened = false;
      Logger.i("CacheDataSource", "[close] exit");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label32;
    }
  }
  
  /* Error */
  public boolean continueLoadIfNeeded()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 129	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:opened	Z
    //   8: ifne +17 -> 25
    //   11: ldc 50
    //   13: ldc_w 370
    //   16: invokestatic 373	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iload_2
    //   20: istore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: iload_2
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 375	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:pendingRestartPositionByte	J
    //   31: ldc2_w 21
    //   34: lcmp
    //   35: ifeq -14 -> 21
    //   38: iload_2
    //   39: istore_1
    //   40: aload_0
    //   41: getfield 131	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loadFinished	Z
    //   44: ifne -23 -> 21
    //   47: aload_0
    //   48: getfield 375	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:pendingRestartPositionByte	J
    //   51: lstore_3
    //   52: aload_0
    //   53: ldc2_w 21
    //   56: putfield 375	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:pendingRestartPositionByte	J
    //   59: aload_0
    //   60: lload_3
    //   61: lconst_0
    //   62: invokespecial 176	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:scheduleRestart	(JJ)V
    //   65: ldc 50
    //   67: new 199	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 377
    //   74: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: lload_3
    //   78: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 195	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iconst_1
    //   88: istore_1
    //   89: goto -68 -> 21
    //   92: astore 5
    //   94: aload_0
    //   95: monitorexit
    //   96: aload 5
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	CacheDataSource
    //   20	69	1	bool1	boolean
    //   1	38	2	bool2	boolean
    //   51	27	3	l	long
    //   92	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	19	92	finally
    //   27	38	92	finally
    //   40	87	92	finally
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return FormatDetector.getAudioFormat(this, false);
  }
  
  protected long getBufferTimeout(long paramLong, int paramInt)
  {
    return 30000L;
  }
  
  public Loader getLoader()
  {
    return this.loader;
  }
  
  public long getSize()
  {
    return this.loader.getUpstreamSize();
  }
  
  public boolean isCacheFileComplete()
  {
    long l = this.cachedDataTracker.getContinuousEnd();
    return (l != -1L) && (l == this.loader.getUpstreamSize() - 1L);
  }
  
  public void open()
  {
    Logger.i("CacheDataSource", "[open] enter.");
    if (this.opened) {
      return;
    }
    this.nextContinuousPosition = 0L;
    this.pendingRestartPositionByte = -9223372036854775808L;
    this.cacheSource.open();
    this.loader.prepare();
    startLoadingIfNeeded();
    if (this.listener != null) {
      this.listener.onTransferStart();
    }
    this.opened = true;
    Logger.i("CacheDataSource", "[open] exit");
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = -1;
    if (paramLong < 0L) {
      try
      {
        Logger.e("CacheDataSource", "[readAt] invalid position: " + paramLong);
        throw new IOException("invalid position: " + paramLong);
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte = paramArrayOfByte;
        Logger.e("CacheDataSource", "[readAt] error occurred: " + paramLong, paramArrayOfByte);
        throw paramArrayOfByte;
      }
      finally {}
    }
    boolean bool = isCached(paramLong, paramInt2);
    if (paramLong == this.nextContinuousPosition)
    {
      onReadContinuity(paramLong);
      if (this.listener != null) {
        this.listener.onBytesTransferring(paramLong, paramInt2);
      }
      if (bool) {
        paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, 0, paramInt2);
      }
      if (paramInt1 >= 0) {
        break label418;
      }
      if (this.loader.isLoading()) {
        break label319;
      }
      paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, 0, paramInt2);
      Logger.e("CacheDataSource", "[readAt] load not started: " + paramLong + ", size: " + paramInt2 + ", read: " + paramInt1);
      label226:
      if (paramInt1 <= 0) {
        break label430;
      }
      this.nextContinuousPosition = (paramInt1 + paramLong);
      break label421;
    }
    for (;;)
    {
      for (;;)
      {
        if (this.listener == null) {
          break label427;
        }
        if (i != 0)
        {
          this.listener.onBytesTransferError(paramLong, paramInt2, paramInt1);
          return paramInt1;
          Logger.i("CacheDataSource", "[readAt] onReadDiscontinuity. expected: " + this.nextContinuousPosition + ", actual: " + paramLong);
          onReadDiscontinuity(paramLong, bool);
          break;
          label319:
          if (this.listener != null) {
            this.listener.onBufferStarted(paramLong);
          }
          try
          {
            this.cachedDataTracker.lock(paramLong, paramInt2, getBufferTimeout(paramLong, paramInt2));
            if (this.listener != null) {
              this.listener.onBufferEnded();
            }
            paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, 0, paramInt2);
          }
          catch (InterruptedException paramArrayOfByte)
          {
            throw new IOException("interrupted!", paramArrayOfByte);
          }
        }
      }
      this.listener.onBytesTransferred(paramLong, paramInt1);
      return paramInt1;
      label418:
      break label226;
      label421:
      label427:
      label430:
      do
      {
        i = 0;
        break;
        return paramInt1;
        if (paramInt1 < 0)
        {
          i = 1;
          break;
        }
      } while (paramInt2 == 0);
      int i = 1;
    }
  }
  
  public void setListener(CacheDataSource.Listener paramListener)
  {
    this.listener = paramListener;
  }
  
  public boolean wait(int paramInt, long paramLong)
  {
    return this.cachedDataTracker.lock(0L, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource
 * JD-Core Version:    0.7.0.1
 */