package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.IInterface;
import java.util.List;
import java.util.Map;

public abstract interface ITPPlayListenerAidl
  extends IInterface
{
  public abstract long getAdvRemainTime();
  
  public abstract String getContentType(int paramInt, String paramString);
  
  public abstract int getCurrentPlayClipNo();
  
  public abstract long getCurrentPosition();
  
  public abstract String getDataFilePath(int paramInt, String paramString);
  
  public abstract long getDataTotalSize(int paramInt, String paramString);
  
  public abstract String getPlayInfo(String paramString);
  
  public abstract long getPlayerBufferLength();
  
  public abstract void onDownloadCdnUrlExpired(Map paramMap);
  
  public abstract void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onDownloadCdnUrlUpdate(String paramString);
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadFinish();
  
  public abstract void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
  
  public abstract void onDownloadProtocolUpdate(String paramString1, String paramString2);
  
  public abstract void onDownloadStatusUpdate(int paramInt);
  
  public abstract int onPlayCallback(int paramInt, List paramList);
  
  public abstract int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStopReadData(int paramInt1, String paramString, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
 * JD-Core Version:    0.7.0.1
 */