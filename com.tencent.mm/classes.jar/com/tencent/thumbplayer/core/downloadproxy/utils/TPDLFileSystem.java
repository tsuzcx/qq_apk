package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TPDLFileSystem
{
  public static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(191631);
    clearInternalCache(paramContext);
    clearExternalCache(paramContext);
    AppMethodBeat.o(191631);
  }
  
  public static void clearCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191632);
    clearInternalCache(paramContext, paramString);
    clearExternalCache(paramContext, paramString);
    AppMethodBeat.o(191632);
  }
  
  public static void clearExternalCache(Context paramContext)
  {
    AppMethodBeat.i(191618);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext));
    AppMethodBeat.o(191618);
  }
  
  public static void clearExternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191619);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(191619);
  }
  
  public static void clearInternalCache(Context paramContext)
  {
    AppMethodBeat.i(191627);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext));
    AppMethodBeat.o(191627);
  }
  
  public static void clearInternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191628);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(191628);
  }
  
  public static void deleteDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191633);
    deleteInternalDirectory(paramContext, paramString);
    deleteExternalDirectory(paramContext, paramString);
    AppMethodBeat.o(191633);
  }
  
  public static void deleteExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191613);
    TPDLIOUtil.recursiveDelete(getExternalDirectory(paramContext, paramString));
    AppMethodBeat.o(191613);
  }
  
  public static void deleteInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191622);
    TPDLIOUtil.recursiveDelete(getInternalDirectory(paramContext, paramString));
    AppMethodBeat.o(191622);
  }
  
  public static File getExternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(191615);
    paramContext = paramContext.getExternalCacheDir();
    AppMethodBeat.o(191615);
    return paramContext;
  }
  
  public static File getExternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191616);
    paramContext = getExternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(191616);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(191616);
    return paramContext;
  }
  
  public static File getExternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191617);
    paramContext = getExternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(191617);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(191617);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(191611);
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile == null)
    {
      AppMethodBeat.o(191611);
      return null;
    }
    paramContext = new File(localFile.getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getPackageName() + File.separator + "files");
    AppMethodBeat.o(191611);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191612);
    paramContext = getExternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(191612);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(191612);
    return paramContext;
  }
  
  public static File getExternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191614);
    paramContext = getExternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(191614);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(191614);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(191624);
    paramContext = paramContext.getCacheDir();
    AppMethodBeat.o(191624);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191625);
    paramContext = getInternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(191625);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(191625);
    return paramContext;
  }
  
  public static File getInternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191626);
    paramContext = getInternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(191626);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(191626);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(191620);
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(191620);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191621);
    paramContext = getInternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(191621);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(191621);
    return paramContext;
  }
  
  public static File getInternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191623);
    paramContext = getInternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(191623);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(191623);
    return paramContext;
  }
  
  public static File getNewerCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191635);
    paramContext = TPDLIOUtil.compare(getInternalCacheFile(paramContext, paramString1, paramString2), getExternalCacheFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(191635);
    return paramContext;
  }
  
  public static File getNewerFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191634);
    paramContext = TPDLIOUtil.compare(getInternalFile(paramContext, paramString1, paramString2), getExternalFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(191634);
    return paramContext;
  }
  
  public static File getProperCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191636);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheDirectory(paramContext, paramString);
      AppMethodBeat.o(191636);
      return paramContext;
    }
    paramContext = getInternalCacheDirectory(paramContext, paramString);
    AppMethodBeat.o(191636);
    return paramContext;
  }
  
  public static File getProperCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191630);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(191630);
      return paramContext;
    }
    paramContext = getInternalCacheFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(191630);
    return paramContext;
  }
  
  public static File getProperDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191637);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalDirectory(paramContext, paramString);
      AppMethodBeat.o(191637);
      return paramContext;
    }
    paramContext = getInternalDirectory(paramContext, paramString);
    AppMethodBeat.o(191637);
    return paramContext;
  }
  
  public static File getProperFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191629);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(191629);
      return paramContext;
    }
    paramContext = getInternalFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(191629);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem
 * JD-Core Version:    0.7.0.1
 */