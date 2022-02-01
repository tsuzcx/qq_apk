package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.mm.plugin.thumbplayer.g.a;
import kotlin.d.d;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "", "mediaId", "", "getMediaId", "()Ljava/lang/String;", "totalLength", "", "getTotalLength", "()J", "addReporter", "", "reporter", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "awaitFinished", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitMoovReady", "cachedMills", "checkAvailable", "offset", "length", "isDownloaded", "isTaskFinished", "progress", "", "request", "requestAll", "savedPath", "start", "stop", "DownloadException", "FileExpiredException", "TimeoutException", "plugin-thumbplayer_release"})
public abstract interface i
{
  public abstract void a(a parama);
  
  public abstract boolean aCE();
  
  public abstract long aE(long paramLong1, long paramLong2);
  
  public abstract boolean aF(long paramLong1, long paramLong2);
  
  public abstract Object f(d<? super x> paramd);
  
  public abstract Object g(d<? super Boolean> paramd);
  
  public abstract String getMediaId();
  
  public abstract long getTotalLength();
  
  public abstract void gnP();
  
  public abstract String gnQ();
  
  public abstract long gnR();
  
  public abstract float gnT();
  
  public abstract boolean start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.i
 * JD-Core Version:    0.7.0.1
 */