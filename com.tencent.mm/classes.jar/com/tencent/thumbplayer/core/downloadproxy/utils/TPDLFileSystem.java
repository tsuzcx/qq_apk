package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TPDLFileSystem
{
  public static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(210127);
    clearInternalCache(paramContext);
    clearExternalCache(paramContext);
    AppMethodBeat.o(210127);
  }
  
  public static void clearCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210128);
    clearInternalCache(paramContext, paramString);
    clearExternalCache(paramContext, paramString);
    AppMethodBeat.o(210128);
  }
  
  public static void clearExternalCache(Context paramContext)
  {
    AppMethodBeat.i(210114);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext));
    AppMethodBeat.o(210114);
  }
  
  public static void clearExternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210115);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(210115);
  }
  
  public static void clearInternalCache(Context paramContext)
  {
    AppMethodBeat.i(210123);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext));
    AppMethodBeat.o(210123);
  }
  
  public static void clearInternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210124);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(210124);
  }
  
  public static void deleteDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210129);
    deleteInternalDirectory(paramContext, paramString);
    deleteExternalDirectory(paramContext, paramString);
    AppMethodBeat.o(210129);
  }
  
  public static void deleteExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210109);
    TPDLIOUtil.recursiveDelete(getExternalDirectory(paramContext, paramString));
    AppMethodBeat.o(210109);
  }
  
  public static void deleteInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210118);
    TPDLIOUtil.recursiveDelete(getInternalDirectory(paramContext, paramString));
    AppMethodBeat.o(210118);
  }
  
  public static File getExternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(210111);
    paramContext = paramContext.getExternalCacheDir();
    AppMethodBeat.o(210111);
    return paramContext;
  }
  
  public static File getExternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210112);
    paramContext = getExternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(210112);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(210112);
    return paramContext;
  }
  
  public static File getExternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210113);
    paramContext = getExternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(210113);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(210113);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(210107);
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile == null)
    {
      AppMethodBeat.o(210107);
      return null;
    }
    paramContext = new File(localFile.getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getPackageName() + File.separator + "files");
    AppMethodBeat.o(210107);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210108);
    paramContext = getExternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(210108);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(210108);
    return paramContext;
  }
  
  public static File getExternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210110);
    paramContext = getExternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(210110);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(210110);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(210120);
    paramContext = paramContext.getCacheDir();
    AppMethodBeat.o(210120);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210121);
    paramContext = getInternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(210121);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(210121);
    return paramContext;
  }
  
  public static File getInternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210122);
    paramContext = getInternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(210122);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(210122);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(210116);
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(210116);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210117);
    paramContext = getInternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(210117);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(210117);
    return paramContext;
  }
  
  public static File getInternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210119);
    paramContext = getInternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(210119);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(210119);
    return paramContext;
  }
  
  public static File getNewerCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210131);
    paramContext = TPDLIOUtil.compare(getInternalCacheFile(paramContext, paramString1, paramString2), getExternalCacheFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(210131);
    return paramContext;
  }
  
  public static File getNewerFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210130);
    paramContext = TPDLIOUtil.compare(getInternalFile(paramContext, paramString1, paramString2), getExternalFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(210130);
    return paramContext;
  }
  
  public static File getProperCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210132);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheDirectory(paramContext, paramString);
      AppMethodBeat.o(210132);
      return paramContext;
    }
    paramContext = getInternalCacheDirectory(paramContext, paramString);
    AppMethodBeat.o(210132);
    return paramContext;
  }
  
  public static File getProperCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210126);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(210126);
      return paramContext;
    }
    paramContext = getInternalCacheFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(210126);
    return paramContext;
  }
  
  public static File getProperDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210133);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalDirectory(paramContext, paramString);
      AppMethodBeat.o(210133);
      return paramContext;
    }
    paramContext = getInternalDirectory(paramContext, paramString);
    AppMethodBeat.o(210133);
    return paramContext;
  }
  
  public static File getProperFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210125);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(210125);
      return paramContext;
    }
    paramContext = getInternalFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(210125);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem
 * JD-Core Version:    0.7.0.1
 */