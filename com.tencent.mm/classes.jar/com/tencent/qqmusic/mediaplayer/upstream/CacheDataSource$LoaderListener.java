package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class CacheDataSource$LoaderListener
  implements Loader.Listener
{
  private long loadedPosition = -9223372036854775808L;
  
  private CacheDataSource$LoaderListener(CacheDataSource paramCacheDataSource) {}
  
  /* Error */
  public void onLoadCancelled(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: new 36	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 38
    //   10: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 45	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 55	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iload_1
    //   24: ifne +41 -> 65
    //   27: aload_0
    //   28: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
    //   31: invokestatic 59	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$200	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Z
    //   34: ifne +13 -> 47
    //   37: aload_0
    //   38: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
    //   41: invokestatic 63	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$300	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   44: invokevirtual 68	com/tencent/qqmusic/mediaplayer/DataRangeTracker:abandonLock	()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_2
    //   51: aload_0
    //   52: new 70	java/io/IOException
    //   55: dup
    //   56: ldc 72
    //   58: aload_2
    //   59: invokespecial 75	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: invokevirtual 79	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:onLoadError	(Ljava/io/IOException;)V
    //   65: aload_0
    //   66: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
    //   69: invokestatic 63	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$300	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   72: invokevirtual 68	com/tencent/qqmusic/mediaplayer/DataRangeTracker:abandonLock	()V
    //   75: goto -28 -> 47
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	LoaderListener
    //   0	83	1	paramBoolean	boolean
    //   50	9	2	localIllegalStateException	java.lang.IllegalStateException
    //   78	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	47	50	java/lang/IllegalStateException
    //   2	23	78	finally
    //   27	47	78	finally
    //   51	65	78	finally
    //   65	75	78	finally
  }
  
  public void onLoadCompleted()
  {
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$602(this.this$0, true);
    CacheDataSource.access$300(this.this$0).abandonLock();
    if (CacheDataSource.access$700(this.this$0) != null) {
      CacheDataSource.access$700(this.this$0).onStreamingFinished();
    }
  }
  
  public void onLoadError(IOException paramIOException)
  {
    Logger.e("CacheDataSource", "[onLoadError] enter.", paramIOException);
    if (this.loadedPosition == -9223372036854775808L) {}
    for (long l1 = 0L;; l1 = this.loadedPosition)
    {
      this.this$0.pendingRestartPositionByte = this.loadedPosition;
      if (CacheDataSource.access$700(this.this$0) == null) {
        break label124;
      }
      long l2 = CacheDataSource.access$700(this.this$0).onStreamingError(paramIOException);
      if (l2 < 0L) {
        break;
      }
      CacheDataSource.access$900(this.this$0, l1, l2);
      this.this$0.pendingRestartPositionByte = -9223372036854775808L;
      return;
    }
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$300(this.this$0).abandonLock();
    return;
    label124:
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$300(this.this$0).abandonLock();
  }
  
  public void onLoadProgress(long paramLong1, long paramLong2)
  {
    this.loadedPosition = paramLong2;
    CacheDataSource.access$300(this.this$0).addRange(paramLong1, paramLong2);
    if (CacheDataSource.access$700(this.this$0) != null) {
      CacheDataSource.access$700(this.this$0).onUpStreamTransfer(paramLong2, CacheDataSource.access$800(this.this$0).getUpstreamSize());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.LoaderListener
 * JD-Core Version:    0.7.0.1
 */