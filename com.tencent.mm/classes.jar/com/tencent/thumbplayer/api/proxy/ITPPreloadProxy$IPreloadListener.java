package com.tencent.thumbplayer.api.proxy;

public abstract interface ITPPreloadProxy$IPreloadListener
{
  public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void onPrepareError();
  
  public abstract void onPrepareSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener
 * JD-Core Version:    0.7.0.1
 */