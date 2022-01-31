package com.tencent.smtt.export.external;

import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.net.URL;
import java.util.Enumeration;

class DexClassLoaderProvider$SpeedyDexClassLoader
  extends BaseDexClassLoader
{
  public DexClassLoaderProvider$SpeedyDexClassLoader(String paramString1, File paramFile, String paramString2, ClassLoader paramClassLoader)
  {
    super(paramString1, null, paramString2, paramClassLoader);
  }
  
  public Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
  {
    return super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
  }
  
  public Class<?> findClass(String paramString)
  {
    return super.findClass(paramString);
  }
  
  public URL findResource(String paramString)
  {
    return super.findResource(paramString);
  }
  
  public Enumeration<URL> findResources(String paramString)
  {
    return super.findResources(paramString);
  }
  
  public Package getPackage(String paramString)
  {
    try
    {
      paramString = super.getPackage(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Package[] getPackages()
  {
    return super.getPackages();
  }
  
  public Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    return super.loadClass(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider.SpeedyDexClassLoader
 * JD-Core Version:    0.7.0.1
 */