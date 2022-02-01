package com.tencent.smtt.export.external.interfaces;

public abstract interface IX5CoreUrlUtil
{
  public abstract String composeSearchUrl(String paramString1, String paramString2, String paramString3);
  
  public abstract byte[] decode(byte[] paramArrayOfByte);
  
  public abstract String guessFileName(String paramString1, String paramString2, String paramString3);
  
  public abstract String guessUrl(String paramString);
  
  public abstract boolean isAboutUrl(String paramString);
  
  public abstract boolean isAssetUrl(String paramString);
  
  public abstract boolean isContentUrl(String paramString);
  
  public abstract boolean isCookielessProxyUrl(String paramString);
  
  public abstract boolean isDataUrl(String paramString);
  
  public abstract boolean isFileUrl(String paramString);
  
  public abstract boolean isHttpUrl(String paramString);
  
  public abstract boolean isHttpsUrl(String paramString);
  
  public abstract boolean isJavaScriptUrl(String paramString);
  
  public abstract boolean isNetworkUrl(String paramString);
  
  public abstract boolean isValidUrl(String paramString);
  
  public abstract String stripAnchor(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
 * JD-Core Version:    0.7.0.1
 */