package com.tencent.tmassistantsdk.downloadservice;

public abstract interface IDownloadManagerListener
{
  public abstract void OnDownloadProgressChanged(String paramString, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadStateChanged(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.IDownloadManagerListener
 * JD-Core Version:    0.7.0.1
 */