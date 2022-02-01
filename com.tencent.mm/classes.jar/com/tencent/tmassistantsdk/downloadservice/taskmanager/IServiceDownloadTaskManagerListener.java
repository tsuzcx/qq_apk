package com.tencent.tmassistantsdk.downloadservice.taskmanager;

public abstract interface IServiceDownloadTaskManagerListener
{
  public abstract void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener
 * JD-Core Version:    0.7.0.1
 */