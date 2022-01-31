package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

public final class f
{
  public final String aRN;
  public final String appId;
  public final String ceG;
  public final String ceH;
  public final int ceI;
  public final long ceJ;
  public final Exception exception;
  public final String filePath;
  public final String url;
  public final String version;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, long paramLong, Exception paramException)
  {
    this.url = paramString1;
    this.filePath = paramString2;
    this.version = paramString3;
    this.appId = paramString4;
    this.ceG = paramString5;
    this.ceH = paramString6;
    this.ceI = paramInt;
    this.aRN = paramString7;
    this.ceJ = paramLong;
    this.exception = paramException;
  }
  
  public final String toString()
  {
    return "WebViewCacheResponseWrapper{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", version='" + this.version + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.ceG + '\'' + ", packageId='" + this.ceH + '\'' + ", cacheType=" + this.ceI + ", contentType='" + this.aRN + '\'' + ", contentLength=" + this.ceJ + ", exception=" + this.exception + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f
 * JD-Core Version:    0.7.0.1
 */