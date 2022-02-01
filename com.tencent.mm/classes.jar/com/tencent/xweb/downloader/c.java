package com.tencent.xweb.downloader;

public abstract interface c
{
  public abstract void onProgressChange(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onTaskFail(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void onTaskFinish(String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.downloader.c
 * JD-Core Version:    0.7.0.1
 */