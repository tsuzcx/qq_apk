package com.tencent.mm.plugin.thumbplayer.downloader;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "", "filename", "", "getFilename", "()Ljava/lang/String;", "length", "", "getLength", "()J", "localMsgId", "getLocalMsgId", "()Ljava/lang/Long;", "mediaId", "getMediaId", "minRemainPercent", "", "getMinRemainPercent", "()I", "savedPath", "getSavedPath", "finishRemaining", "", "isDownloading", "", "isFinished", "refresh", "start", "stat", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask$Stat;", "stop", "Stat", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
{
  public abstract long RU();
  
  public abstract void bDL();
  
  public abstract String fZN();
  
  public abstract String getMediaId();
  
  public abstract String hso();
  
  public abstract Long hsp();
  
  public abstract int hsq();
  
  public abstract h.a hsr();
  
  public abstract void hst();
  
  public abstract boolean isDownloading();
  
  public abstract boolean isFinished();
  
  public abstract boolean start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.h
 * JD-Core Version:    0.7.0.1
 */