package com.tencent.thumbplayer.e.a;

import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;

public abstract interface a
{
  public abstract void a(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener);
  
  public abstract String getContentType(int paramInt, String paramString);
  
  public abstract String getDataFilePath(int paramInt, String paramString);
  
  public abstract long getDataTotalSize(int paramInt, String paramString);
  
  public abstract void kay();
  
  public abstract int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStopReadData(int paramInt1, String paramString, int paramInt2);
  
  public abstract void release();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a.a
 * JD-Core Version:    0.7.0.1
 */