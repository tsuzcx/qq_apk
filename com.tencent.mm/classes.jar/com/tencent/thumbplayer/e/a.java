package com.tencent.thumbplayer.e;

import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;

public abstract interface a
  extends ITPPlayerProxy
{
  public abstract void Iw(boolean paramBoolean);
  
  public abstract void WU(long paramLong);
  
  public abstract e a(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo);
  
  public abstract ITPMediaAsset a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract String a(int paramInt, String paramString, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract void a(ITPPlayListener paramITPPlayListener);
  
  public abstract void aBb(int paramInt);
  
  public abstract ITPMediaAsset b(ITPMediaAsset paramITPMediaAsset);
  
  public abstract e bDw(String paramString);
  
  public abstract void iqU();
  
  public abstract boolean iqV();
  
  public abstract String iqW();
  
  public abstract ITPPlayerProxyListener iqX();
  
  public abstract boolean isEnable();
  
  public abstract void oI(String paramString1, String paramString2);
  
  public abstract void pauseDownload();
  
  public abstract void release();
  
  public abstract void resumeDownload();
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
  
  public abstract void stopDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a
 * JD-Core Version:    0.7.0.1
 */