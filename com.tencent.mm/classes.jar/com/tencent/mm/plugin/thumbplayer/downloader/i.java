package com.tencent.mm.plugin.thumbplayer.downloader;

import com.tencent.mm.plugin.thumbplayer.f.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "", "mediaId", "", "getMediaId", "()Ljava/lang/String;", "totalLength", "", "getTotalLength", "()J", "addReporter", "", "reporter", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "awaitFinished", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitMoovReady", "cachedMills", "checkAvailable", "offset", "length", "isDownloaded", "isDownloading", "isTaskFinished", "progress", "", "request", "requestAll", "savedPath", "start", "stop", "DownloadException", "FileExpiredException", "TimeoutException", "VideoDownloadCallback", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface i
{
  public abstract void a(a parama);
  
  public abstract boolean aVB();
  
  public abstract Object ao(d<? super ah> paramd);
  
  public abstract Object ap(d<? super Boolean> paramd);
  
  public abstract long bo(long paramLong1, long paramLong2);
  
  public abstract boolean bp(long paramLong1, long paramLong2);
  
  public abstract String getMediaId();
  
  public abstract long getTotalLength();
  
  public abstract void hKC();
  
  public abstract String hKD();
  
  public abstract long hKE();
  
  public abstract float hKG();
  
  public abstract boolean isDownloading();
  
  public abstract boolean start();
  
  public abstract void stop();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$VideoDownloadCallback;", "", "onDataAvailable", "", "msgId", "", "offset", "length", "(Ljava/lang/Long;JJ)V", "onDownloadProgress", "total", "onFinishDownload", "ret", "", "(Ljava/lang/Long;I)V", "onMoovReady", "onStartDownload", "(Ljava/lang/Long;)V", "onStopDownload", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(Long paramLong, long paramLong1, long paramLong2);
    
    public abstract void n(Long paramLong);
    
    public abstract void o(Long paramLong);
    
    public abstract void p(Long paramLong);
    
    public abstract void q(Long paramLong);
    
    public abstract void r(Long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.i
 * JD-Core Version:    0.7.0.1
 */