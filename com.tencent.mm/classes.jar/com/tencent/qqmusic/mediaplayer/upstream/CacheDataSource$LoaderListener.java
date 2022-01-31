package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    //   2: ldc 33
    //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 41
    //   9: ldc 43
    //   11: iload_1
    //   12: invokestatic 49	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   15: invokevirtual 53	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 58	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iload_1
    //   22: ifne +46 -> 68
    //   25: aload_0
    //   26: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
    //   29: invokestatic 62	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$200	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Z
    //   32: ifne +13 -> 45
    //   35: aload_0
    //   36: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
    //   39: invokestatic 66	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$300	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   42: invokevirtual 71	com/tencent/qqmusic/mediaplayer/DataRangeTracker:abandonLock	()V
    //   45: ldc 33
    //   47: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_2
    //   54: aload_0
    //   55: new 76	java/io/IOException
    //   58: dup
    //   59: ldc 78
    //   61: aload_2
    //   62: invokespecial 81	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: invokevirtual 85	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:onLoadError	(Ljava/io/IOException;)V
    //   68: aload_0
    //   69: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
    //   72: invokestatic 66	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$300	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   75: invokevirtual 71	com/tencent/qqmusic/mediaplayer/DataRangeTracker:abandonLock	()V
    //   78: ldc 33
    //   80: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -33 -> 50
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	LoaderListener
    //   0	91	1	paramBoolean	boolean
    //   53	9	2	localIllegalStateException	java.lang.IllegalStateException
    //   86	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	45	53	java/lang/IllegalStateException
    //   2	21	86	finally
    //   25	45	86	finally
    //   45	50	86	finally
    //   54	68	86	finally
    //   68	83	86	finally
  }
  
  public void onLoadCompleted()
  {
    AppMethodBeat.i(104518);
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$602(this.this$0, true);
    CacheDataSource.access$300(this.this$0).abandonLock();
    if (CacheDataSource.access$700(this.this$0) != null) {
      CacheDataSource.access$700(this.this$0).onStreamingFinished();
    }
    AppMethodBeat.o(104518);
  }
  
  public void onLoadError(IOException paramIOException)
  {
    AppMethodBeat.i(104520);
    Logger.e("CacheDataSource", "[onLoadError] enter.", paramIOException);
    if (this.loadedPosition == -9223372036854775808L) {}
    for (long l1 = 0L;; l1 = this.loadedPosition)
    {
      this.this$0.pendingRestartPositionByte = this.loadedPosition;
      if (CacheDataSource.access$700(this.this$0) == null) {
        break label139;
      }
      long l2 = CacheDataSource.access$700(this.this$0).onStreamingError(paramIOException);
      if (l2 < 0L) {
        break;
      }
      CacheDataSource.access$900(this.this$0, l1, l2);
      this.this$0.pendingRestartPositionByte = -9223372036854775808L;
      AppMethodBeat.o(104520);
      return;
    }
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$300(this.this$0).abandonLock();
    AppMethodBeat.o(104520);
    return;
    label139:
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$300(this.this$0).abandonLock();
    AppMethodBeat.o(104520);
  }
  
  public void onLoadProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(104519);
    this.loadedPosition = paramLong2;
    CacheDataSource.access$300(this.this$0).addRange(paramLong1, paramLong2);
    if (CacheDataSource.access$700(this.this$0) != null) {
      CacheDataSource.access$700(this.this$0).onUpStreamTransfer(paramLong2, CacheDataSource.access$800(this.this$0).getUpstreamSize());
    }
    AppMethodBeat.o(104519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.LoaderListener
 * JD-Core Version:    0.7.0.1
 */