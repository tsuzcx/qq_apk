package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.IInterface;
import java.util.List;
import java.util.Map;

public abstract interface ITPPlayListenerAidl
  extends IInterface
{
  public abstract long getAdvRemainTime();
  
  public abstract String getContentType(long paramLong, String paramString);
  
  public abstract int getCurrentPlayClipNo();
  
  public abstract long getCurrentPosition();
  
  public abstract String getDataFilePath(long paramLong, String paramString);
  
  public abstract long getDataTotalSize(long paramLong, String paramString);
  
  public abstract String getPlayInfo(String paramString);
  
  public abstract long getPlayerBufferLength();
  
  public abstract void onDownloadCdnUrlExpired(Map paramMap);
  
  public abstract void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onDownloadCdnUrlUpdate(String paramString);
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadFinish();
  
  public abstract void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void onDownloadProtocolUpdate(String paramString1, String paramString2);
  
  public abstract void onDownloadStatusUpdate(int paramInt);
  
  public abstract int onPlayCallback(int paramInt, List paramList);
  
  public abstract int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3);
  
  public abstract int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3);
  
  public abstract int onStopReadData(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
 * JD-Core Version:    0.7.0.1
 */