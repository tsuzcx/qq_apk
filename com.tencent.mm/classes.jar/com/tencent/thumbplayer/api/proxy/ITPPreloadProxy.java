package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;

public abstract interface ITPPreloadProxy
{
  public abstract String getPlayErrorCodeStr(int paramInt);
  
  public abstract boolean isAvailable();
  
  public abstract void pushEvent(int paramInt);
  
  public abstract void setPreloadListener(IPreloadListener paramIPreloadListener);
  
  public abstract int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList);
  
  public abstract int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract void stopPreload(int paramInt);
  
  public static abstract interface IPreloadListener
  {
    public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
    
    public abstract void onPrepareError();
    
    public abstract void onPrepareSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
 * JD-Core Version:    0.7.0.1
 */