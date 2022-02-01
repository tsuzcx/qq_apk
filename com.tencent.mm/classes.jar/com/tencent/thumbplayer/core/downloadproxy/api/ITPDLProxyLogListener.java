package com.tencent.thumbplayer.core.downloadproxy.api;

public abstract interface ITPDLProxyLogListener
{
  public static final String COMMON_TAG = "tpdlnative";
  public static final int LOG_DEBUG = 3;
  public static final int LOG_ERROR = 6;
  public static final int LOG_INFO = 4;
  public static final int LOG_WARN = 5;
  
  public abstract int d(String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract int e(String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract int i(String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract int w(String paramString1, int paramInt, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
 * JD-Core Version:    0.7.0.1
 */