package com.tencent.shadow.core.manager.installplugin;

import java.io.File;

public class AppCacheFolderManager
{
  public static File getAppDir(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }
  
  public static File getLibCopiedFile(File paramFile, String paramString)
  {
    return new File(paramFile, paramString + "_copied");
  }
  
  public static File getLibDir(File paramFile, String paramString)
  {
    return new File(getLibRootDir(paramFile), paramString + "_lib");
  }
  
  private static File getLibRootDir(File paramFile)
  {
    return new File(paramFile, "lib");
  }
  
  public static File getODexCopiedFile(File paramFile, String paramString)
  {
    return new File(paramFile, paramString + "_oDexed");
  }
  
  public static File getODexDir(File paramFile, String paramString)
  {
    return new File(getODexRootDir(paramFile), paramString + "_odex");
  }
  
  private static File getODexRootDir(File paramFile)
  {
    return new File(paramFile, "oDex");
  }
  
  public static File getVersionDir(File paramFile, String paramString1, String paramString2)
  {
    return new File(getAppDir(paramFile, paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.AppCacheFolderManager
 * JD-Core Version:    0.7.0.1
 */