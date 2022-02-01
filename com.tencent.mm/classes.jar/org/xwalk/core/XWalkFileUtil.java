package org.xwalk.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class XWalkFileUtil
{
  public static final String TAG = "XWalkFileUtil";
  private static final String XWALK_CORE_APK_DIR = "apk";
  public static final String XWALK_CORE_APK_NAME = "base.apk";
  public static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
  private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
  public static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
  private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
  private static final String XWALK_CORE_OPTIMIZED_DEX_DIR = "dex";
  private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
  private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
  private static final String XWALK_CORE_RES_FILELIST_CONFIG_NAME = "reslist.config";
  private static final String XWALK_CORE_ZIP_DIR = "zip";
  private static final String XWALK_CORE_ZIP_NAME = "base.zip";
  private static final String XWALK_PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
  private static final String XWALK_PLUGIN_BASE_DIR = "xwalkplugin";
  private static final String XWALK_PLUGIN_UPDATE_CONFIG_NAME = "pluginUpdateConfig.xml";
  private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
  
  public static String getClassDexFilePath(int paramInt)
  {
    AppMethodBeat.i(187707);
    String str = getExtractedCoreDir(paramInt) + File.separator + "classes.dex";
    AppMethodBeat.o(187707);
    return str;
  }
  
  public static String getCurrentVersionDir(Context paramContext)
  {
    AppMethodBeat.i(187748);
    if (paramContext == null)
    {
      Log.e("XWalkFileUtil", "getCurrentVersionDir with context, context is null");
      AppMethodBeat.o(187748);
      return "";
    }
    int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    Log.i("XWalkFileUtil", "getCurrentVersionDir, version:".concat(String.valueOf(i)));
    paramContext = getVersionDir(paramContext, i);
    AppMethodBeat.o(187748);
    return paramContext;
  }
  
  public static String getDownloadApkDir(int paramInt)
  {
    AppMethodBeat.i(187692);
    String str = getVersionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(187692);
    return str;
  }
  
  public static String getDownloadApkPath(int paramInt)
  {
    AppMethodBeat.i(187696);
    String str = getDownloadApkDir(paramInt) + File.separator + "base.apk";
    AppMethodBeat.o(187696);
    return str;
  }
  
  public static String getDownloadApkPath(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(187755);
    if (paramContext == null)
    {
      Log.e("XWalkFileUtil", "getDownloadApkPath with context, context is null");
      AppMethodBeat.o(187755);
      return "";
    }
    paramContext = getVersionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkFileUtil", "getDownloadApkPath with context, versionDir is empty");
      AppMethodBeat.o(187755);
      return "";
    }
    paramContext = paramContext + File.separator + "apk" + File.separator + "base.apk";
    AppMethodBeat.o(187755);
    return paramContext;
  }
  
  public static String getDownloadPatchPath(int paramInt)
  {
    AppMethodBeat.i(187740);
    String str = getVersionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "patch.zip";
    AppMethodBeat.o(187740);
    return str;
  }
  
  public static String getDownloadResFileListConfig(int paramInt)
  {
    AppMethodBeat.i(187703);
    String str = getExtractedCoreFile(paramInt, "reslist.config");
    AppMethodBeat.o(187703);
    return str;
  }
  
  public static String getDownloadZipFileListConfig(int paramInt)
  {
    AppMethodBeat.i(187700);
    String str = getExtractedCoreFile(paramInt, "filelist.config");
    AppMethodBeat.o(187700);
    return str;
  }
  
  public static String getDownloadZipFileListConfig(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(187760);
    paramContext = getExtractedCoreFile(paramContext, paramInt, "filelist.config");
    AppMethodBeat.o(187760);
    return paramContext;
  }
  
  public static String getDownloadZipPath(int paramInt)
  {
    AppMethodBeat.i(187689);
    String str = getVersionDir(paramInt) + File.separator + "zip";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "base.zip";
    AppMethodBeat.o(187689);
    return str;
  }
  
  public static String getExtractedCoreDir(int paramInt)
  {
    AppMethodBeat.i(187676);
    String str = getVersionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(187676);
    return str;
  }
  
  public static String getExtractedCoreFile(int paramInt, String paramString)
  {
    AppMethodBeat.i(187679);
    paramString = getExtractedCoreDir(paramInt) + File.separator + paramString;
    AppMethodBeat.o(187679);
    return paramString;
  }
  
  public static String getExtractedCoreFile(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(187757);
    if (paramContext == null)
    {
      Log.e("XWalkFileUtil", "getExtractedCoreFile with context, context is null");
      AppMethodBeat.o(187757);
      return "";
    }
    paramContext = getVersionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkFileUtil", "getExtractedCoreFile with context, versionDir is empty");
      AppMethodBeat.o(187757);
      return "";
    }
    paramContext = paramContext + File.separator + "extracted_xwalkcore" + File.separator + paramString;
    AppMethodBeat.o(187757);
    return paramContext;
  }
  
  public static String getOptimizedDexDir(int paramInt)
  {
    AppMethodBeat.i(187683);
    String str = getVersionDir(paramInt) + File.separator + "dex";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(187683);
    return str;
  }
  
  public static String getPatchConfig(int paramInt)
  {
    AppMethodBeat.i(187733);
    String str = getPatchZipTempDecompressFilePath(paramInt, "patch.config");
    AppMethodBeat.o(187733);
    return str;
  }
  
  public static String getPatchFileListConfig(int paramInt)
  {
    AppMethodBeat.i(187726);
    String str = getPatchZipTempDecompressFilePath(paramInt, "filelist.config");
    AppMethodBeat.o(187726);
    return str;
  }
  
  public static String getPatchFileListConfig(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(187762);
    paramContext = getPatchZipTempDecompressFilePath(paramContext, paramInt, "filelist.config");
    AppMethodBeat.o(187762);
    return paramContext;
  }
  
  public static String getPatchZipTempDecompressDir(int paramInt)
  {
    AppMethodBeat.i(187713);
    String str = getVersionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(187713);
    return str;
  }
  
  public static String getPatchZipTempDecompressFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(187722);
    paramString = getPatchZipTempDecompressDir(paramInt) + File.separator + paramString;
    AppMethodBeat.o(187722);
    return paramString;
  }
  
  public static String getPatchZipTempDecompressFilePath(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(187759);
    if (paramContext == null)
    {
      Log.e("XWalkFileUtil", "getPatchZipTempDecompressFilePath with context, context is null");
      AppMethodBeat.o(187759);
      return "";
    }
    paramContext = getVersionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkFileUtil", "getPatchZipTempDecompressFilePath with context, versionDir is empty");
      AppMethodBeat.o(187759);
      return "";
    }
    paramContext = paramContext + File.separator + "patch_temp_decompress" + File.separator + paramString;
    AppMethodBeat.o(187759);
    return paramContext;
  }
  
  public static String getPluginBaseDir()
  {
    AppMethodBeat.i(187653);
    String str = XWalkEnvironment.getApplicationContext().getDir("xwalkplugin", 0).getAbsolutePath();
    AppMethodBeat.o(187653);
    return str;
  }
  
  public static String getPluginUpdateConfigFilePath()
  {
    AppMethodBeat.i(187667);
    String str = getUpdateConfigDir() + File.separator + "pluginUpdateConfig.xml";
    AppMethodBeat.o(187667);
    return str;
  }
  
  public static String getPredownloadVersionDir(Context paramContext)
  {
    AppMethodBeat.i(187751);
    if (paramContext == null)
    {
      Log.e("XWalkFileUtil", "getPredownloadVersionDir with context, context is null");
      AppMethodBeat.o(187751);
      return "";
    }
    int i = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    Log.i("XWalkFileUtil", "getPredownloadVersionDir, version:".concat(String.valueOf(i)));
    paramContext = getVersionDir(paramContext, i);
    AppMethodBeat.o(187751);
    return paramContext;
  }
  
  public static String getUpdateConfigDir()
  {
    AppMethodBeat.i(187656);
    String str = XWalkEnvironment.getApplicationContext().getDir("xwalkconfig", 0).getAbsolutePath();
    AppMethodBeat.o(187656);
    return str;
  }
  
  public static String getUpdateConfigFullPath()
  {
    AppMethodBeat.i(187663);
    String str = getUpdateConfigDir() + File.separator + "updateConfg.xml";
    AppMethodBeat.o(187663);
    return str;
  }
  
  public static String getVersionDir(int paramInt)
  {
    AppMethodBeat.i(187671);
    String str = XWalkEnvironment.getApplicationContext().getDir("xwalk_".concat(String.valueOf(paramInt)), 0).getAbsolutePath();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(187671);
    return str;
  }
  
  public static String getVersionDir(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(187744);
    if (paramContext == null)
    {
      Log.e("XWalkFileUtil", "getVersionDir with context, context is null");
      AppMethodBeat.o(187744);
      return "";
    }
    paramContext = paramContext.getDir("xwalk_".concat(String.valueOf(paramInt)), 0).getAbsolutePath();
    AppMethodBeat.o(187744);
    return paramContext;
  }
  
  public static boolean isDownloadApkFileExist(int paramInt)
  {
    AppMethodBeat.i(187769);
    File localFile = new File(getDownloadApkPath(paramInt));
    if ((localFile.exists()) && (localFile.isFile()))
    {
      AppMethodBeat.o(187769);
      return true;
    }
    AppMethodBeat.o(187769);
    return false;
  }
  
  public static boolean isExtractedCoreDirFileExist(int paramInt, String paramString)
  {
    AppMethodBeat.i(187765);
    paramString = new File(getExtractedCoreDir(paramInt) + File.separator + paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(187765);
      return true;
    }
    AppMethodBeat.o(187765);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkFileUtil
 * JD-Core Version:    0.7.0.1
 */