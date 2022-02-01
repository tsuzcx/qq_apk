package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import h.a.a.a.a.a.a.a.a.a.a.a;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/DownloaderTPAssetResourceLoader;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "(Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;)V", "requestCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "getContentType", "", "fileId", "", "fileKey", "getDataFilePath", "getDataTotalSize", "", "onReadData", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "Companion", "plugin-thumbplayer_release"})
public final class e
  extends a
{
  public static final e.a MPV;
  private final i KHu;
  private final AtomicInteger MPU;
  
  static
  {
    AppMethodBeat.i(191974);
    MPV = new e.a((byte)0);
    AppMethodBeat.o(191974);
  }
  
  public e(i parami)
  {
    AppMethodBeat.i(191973);
    this.KHu = parami;
    this.MPU = new AtomicInteger(0);
    AppMethodBeat.o(191973);
  }
  
  public final String Rv(int paramInt)
  {
    AppMethodBeat.i(191967);
    String str2 = this.KHu.gnQ();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(191967);
    return str1;
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    return "video/mp4";
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    AppMethodBeat.i(191964);
    long l = this.KHu.getTotalLength();
    AppMethodBeat.o(191964);
    return l;
  }
  
  public final int n(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191959);
    long l = this.KHu.aE(paramLong1, paramLong2);
    Log.d("MicroMsg.DownloaderTPAssetResourceLoader", "onReadData: checkAvailable(" + paramLong1 + ", " + paramLong2 + ")=" + l);
    if (l >= paramLong2)
    {
      paramInt = (int)paramLong2;
      AppMethodBeat.o(191959);
      return paramInt;
    }
    this.KHu.aF(paramLong1, paramLong2);
    paramInt = (int)l;
    AppMethodBeat.o(191959);
    return paramInt;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191955);
    Log.i("MicroMsg.DownloaderTPAssetResourceLoader", "onStartReadData: fileId=" + paramInt + ", fileKey=" + paramString + ", " + paramLong1 + '-' + paramLong2 + ", path=" + this.KHu.gnQ());
    paramInt = this.MPU.incrementAndGet();
    AppMethodBeat.o(191955);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(191962);
    Log.i("MicroMsg.DownloaderTPAssetResourceLoader", "onStopReadData: fileId=" + paramInt1 + ", fileKey=" + paramString + ", requestId=" + paramInt2);
    paramInt1 = this.MPU.get();
    AppMethodBeat.o(191962);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.e
 * JD-Core Version:    0.7.0.1
 */