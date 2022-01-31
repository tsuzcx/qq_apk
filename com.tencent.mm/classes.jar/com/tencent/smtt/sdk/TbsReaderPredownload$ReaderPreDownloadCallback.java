package com.tencent.smtt.sdk;

public abstract interface TbsReaderPredownload$ReaderPreDownloadCallback
{
  public static final int NOTIFY_PLUGIN_FAILED = -1;
  public static final int NOTIFY_PLUGIN_SUCCESS = 0;
  
  public abstract void onEvent(String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderPredownload.ReaderPreDownloadCallback
 * JD-Core Version:    0.7.0.1
 */