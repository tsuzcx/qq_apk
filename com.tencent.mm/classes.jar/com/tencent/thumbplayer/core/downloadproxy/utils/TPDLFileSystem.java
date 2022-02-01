package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TPDLFileSystem
{
  public static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(207484);
    clearInternalCache(paramContext);
    clearExternalCache(paramContext);
    AppMethodBeat.o(207484);
  }
  
  public static void clearCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207485);
    clearInternalCache(paramContext, paramString);
    clearExternalCache(paramContext, paramString);
    AppMethodBeat.o(207485);
  }
  
  public static void clearExternalCache(Context paramContext)
  {
    AppMethodBeat.i(207471);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext));
    AppMethodBeat.o(207471);
  }
  
  public static void clearExternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207472);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(207472);
  }
  
  public static void clearInternalCache(Context paramContext)
  {
    AppMethodBeat.i(207480);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext));
    AppMethodBeat.o(207480);
  }
  
  public static void clearInternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207481);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(207481);
  }
  
  public static void deleteDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207486);
    deleteInternalDirectory(paramContext, paramString);
    deleteExternalDirectory(paramContext, paramString);
    AppMethodBeat.o(207486);
  }
  
  public static void deleteExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207466);
    TPDLIOUtil.recursiveDelete(getExternalDirectory(paramContext, paramString));
    AppMethodBeat.o(207466);
  }
  
  public static void deleteInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207475);
    TPDLIOUtil.recursiveDelete(getInternalDirectory(paramContext, paramString));
    AppMethodBeat.o(207475);
  }
  
  public static File getExternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(207468);
    paramContext = paramContext.getExternalCacheDir();
    AppMethodBeat.o(207468);
    return paramContext;
  }
  
  public static File getExternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207469);
    paramContext = getExternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(207469);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(207469);
    return paramContext;
  }
  
  public static File getExternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207470);
    paramContext = getExternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(207470);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(207470);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(207464);
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile == null)
    {
      AppMethodBeat.o(207464);
      return null;
    }
    paramContext = new File(localFile.getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getPackageName() + File.separator + "files");
    AppMethodBeat.o(207464);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207465);
    paramContext = getExternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(207465);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(207465);
    return paramContext;
  }
  
  public static File getExternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207467);
    paramContext = getExternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(207467);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(207467);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(207477);
    paramContext = paramContext.getCacheDir();
    AppMethodBeat.o(207477);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207478);
    paramContext = getInternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(207478);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(207478);
    return paramContext;
  }
  
  public static File getInternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207479);
    paramContext = getInternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(207479);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(207479);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(207473);
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(207473);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207474);
    paramContext = getInternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(207474);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(207474);
    return paramContext;
  }
  
  public static File getInternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207476);
    paramContext = getInternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(207476);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(207476);
    return paramContext;
  }
  
  public static File getNewerCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207488);
    paramContext = TPDLIOUtil.compare(getInternalCacheFile(paramContext, paramString1, paramString2), getExternalCacheFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(207488);
    return paramContext;
  }
  
  public static File getNewerFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207487);
    paramContext = TPDLIOUtil.compare(getInternalFile(paramContext, paramString1, paramString2), getExternalFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(207487);
    return paramContext;
  }
  
  public static File getProperCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207489);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheDirectory(paramContext, paramString);
      AppMethodBeat.o(207489);
      return paramContext;
    }
    paramContext = getInternalCacheDirectory(paramContext, paramString);
    AppMethodBeat.o(207489);
    return paramContext;
  }
  
  public static File getProperCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207483);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(207483);
      return paramContext;
    }
    paramContext = getInternalCacheFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(207483);
    return paramContext;
  }
  
  public static File getProperDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207490);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalDirectory(paramContext, paramString);
      AppMethodBeat.o(207490);
      return paramContext;
    }
    paramContext = getInternalDirectory(paramContext, paramString);
    AppMethodBeat.o(207490);
    return paramContext;
  }
  
  public static File getProperFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207482);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(207482);
      return paramContext;
    }
    paramContext = getInternalFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(207482);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem
 * JD-Core Version:    0.7.0.1
 */