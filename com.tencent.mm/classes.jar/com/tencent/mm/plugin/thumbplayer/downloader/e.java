package com.tencent.mm.plugin.thumbplayer.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.concurrent.atomic.AtomicInteger;
import k.a.a.a.a.a.a.a.a.a.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/DownloaderTPAssetResourceLoader;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "(Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;)V", "TAG", "", "requestCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "getContentType", "fileId", "", "fileKey", "getDataFilePath", "getDataTotalSize", "", "onReadData", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private final i RgU;
  private final String TAG;
  private final AtomicInteger TCv;
  
  public e(i parami)
  {
    AppMethodBeat.i(272162);
    this.RgU = parami;
    this.TCv = new AtomicInteger(0);
    this.TAG = s.X("MicroMsg.DownloaderTPAssetResourceLoader@", Integer.valueOf(hashCode()));
    Log.i(this.TAG, s.X("<init>, downloader=", Integer.valueOf(this.RgU.hashCode())));
    AppMethodBeat.o(272162);
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    AppMethodBeat.i(272210);
    Log.i(this.TAG, "getContentType: fileId=" + paramInt + ", fileKey=" + paramString);
    AppMethodBeat.o(272210);
    return "video/mp4";
  }
  
  public final String getDataFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(272202);
    Log.i(this.TAG, "getDataFilePath: fileId=" + paramInt + ", fileKey=" + paramString);
    paramString = y.n(this.RgU.hKD(), false);
    if (paramString == null)
    {
      AppMethodBeat.o(272202);
      return "";
    }
    AppMethodBeat.o(272202);
    return paramString;
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    AppMethodBeat.i(272194);
    Log.i(this.TAG, "getDataTotalSize: fileId=" + paramInt + ", fileKey=" + paramString + ", length=" + this.RgU.getTotalLength() + ", downloader=" + this.RgU.hashCode());
    long l = this.RgU.getTotalLength();
    AppMethodBeat.o(272194);
    return l;
  }
  
  public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272180);
    long l = this.RgU.bo(paramLong1, paramLong2);
    Log.i(this.TAG, "onReadData: fileId=" + paramInt + ", fileKey=" + paramString + ", checkAvailable(" + paramLong1 + ", " + paramLong2 + ")=" + l);
    if (l >= paramLong2)
    {
      paramInt = (int)paramLong2;
      AppMethodBeat.o(272180);
      return paramInt;
    }
    this.RgU.bp(paramLong1, paramLong2);
    paramInt = (int)l;
    AppMethodBeat.o(272180);
    return paramInt;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272171);
    Log.i(this.TAG, "onStartReadData: fileId=" + paramInt + ", fileKey=" + paramString + ", " + paramLong1 + '-' + paramLong2 + ", path=" + this.RgU.hKD());
    paramInt = this.TCv.incrementAndGet();
    AppMethodBeat.o(272171);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(272188);
    Log.i(this.TAG, "onStopReadData: fileId=" + paramInt1 + ", fileKey=" + paramString + ", requestId=" + paramInt2);
    paramInt1 = this.TCv.get();
    AppMethodBeat.o(272188);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.e
 * JD-Core Version:    0.7.0.1
 */