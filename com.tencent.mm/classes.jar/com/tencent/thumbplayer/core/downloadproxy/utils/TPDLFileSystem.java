package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TPDLFileSystem
{
  public static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(190271);
    clearInternalCache(paramContext);
    clearExternalCache(paramContext);
    AppMethodBeat.o(190271);
  }
  
  public static void clearCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190272);
    clearInternalCache(paramContext, paramString);
    clearExternalCache(paramContext, paramString);
    AppMethodBeat.o(190272);
  }
  
  public static void clearExternalCache(Context paramContext)
  {
    AppMethodBeat.i(190258);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext));
    AppMethodBeat.o(190258);
  }
  
  public static void clearExternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190259);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(190259);
  }
  
  public static void clearInternalCache(Context paramContext)
  {
    AppMethodBeat.i(190267);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext));
    AppMethodBeat.o(190267);
  }
  
  public static void clearInternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190268);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(190268);
  }
  
  public static void deleteDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190273);
    deleteInternalDirectory(paramContext, paramString);
    deleteExternalDirectory(paramContext, paramString);
    AppMethodBeat.o(190273);
  }
  
  public static void deleteExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190253);
    TPDLIOUtil.recursiveDelete(getExternalDirectory(paramContext, paramString));
    AppMethodBeat.o(190253);
  }
  
  public static void deleteInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190262);
    TPDLIOUtil.recursiveDelete(getInternalDirectory(paramContext, paramString));
    AppMethodBeat.o(190262);
  }
  
  public static File getExternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(190255);
    paramContext = paramContext.getExternalCacheDir();
    AppMethodBeat.o(190255);
    return paramContext;
  }
  
  public static File getExternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190256);
    paramContext = getExternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(190256);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(190256);
    return paramContext;
  }
  
  public static File getExternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190257);
    paramContext = getExternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(190257);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(190257);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(190251);
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile == null)
    {
      AppMethodBeat.o(190251);
      return null;
    }
    paramContext = new File(localFile.getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getPackageName() + File.separator + "files");
    AppMethodBeat.o(190251);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190252);
    paramContext = getExternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(190252);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(190252);
    return paramContext;
  }
  
  public static File getExternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190254);
    paramContext = getExternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(190254);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(190254);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(190264);
    paramContext = paramContext.getCacheDir();
    AppMethodBeat.o(190264);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190265);
    paramContext = getInternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(190265);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(190265);
    return paramContext;
  }
  
  public static File getInternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190266);
    paramContext = getInternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(190266);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(190266);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(190260);
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(190260);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190261);
    paramContext = getInternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(190261);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(190261);
    return paramContext;
  }
  
  public static File getInternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190263);
    paramContext = getInternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(190263);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(190263);
    return paramContext;
  }
  
  public static File getNewerCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190275);
    paramContext = TPDLIOUtil.compare(getInternalCacheFile(paramContext, paramString1, paramString2), getExternalCacheFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(190275);
    return paramContext;
  }
  
  public static File getNewerFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190274);
    paramContext = TPDLIOUtil.compare(getInternalFile(paramContext, paramString1, paramString2), getExternalFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(190274);
    return paramContext;
  }
  
  public static File getProperCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190276);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheDirectory(paramContext, paramString);
      AppMethodBeat.o(190276);
      return paramContext;
    }
    paramContext = getInternalCacheDirectory(paramContext, paramString);
    AppMethodBeat.o(190276);
    return paramContext;
  }
  
  public static File getProperCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190270);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(190270);
      return paramContext;
    }
    paramContext = getInternalCacheFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(190270);
    return paramContext;
  }
  
  public static File getProperDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190277);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalDirectory(paramContext, paramString);
      AppMethodBeat.o(190277);
      return paramContext;
    }
    paramContext = getInternalDirectory(paramContext, paramString);
    AppMethodBeat.o(190277);
    return paramContext;
  }
  
  public static File getProperFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190269);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(190269);
      return paramContext;
    }
    paramContext = getInternalFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(190269);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem
 * JD-Core Version:    0.7.0.1
 */