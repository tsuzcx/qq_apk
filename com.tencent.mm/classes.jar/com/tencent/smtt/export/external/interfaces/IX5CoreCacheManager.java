package com.tencent.smtt.export.external.interfaces;

import java.io.File;
import java.io.InputStream;

public abstract interface IX5CoreCacheManager
{
  public abstract boolean cacheDisabled();
  
  public abstract void clearLocalStorage();
  
  public abstract void clearNetworkCache();
  
  public abstract InputStream getCacheFile(String paramString, boolean paramBoolean);
  
  public abstract File getCacheFileBaseDir();
  
  public abstract String getLocalPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager
 * JD-Core Version:    0.7.0.1
 */