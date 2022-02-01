package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TPDLFileSystem
{
  public static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(228180);
    clearInternalCache(paramContext);
    clearExternalCache(paramContext);
    AppMethodBeat.o(228180);
  }
  
  public static void clearCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228191);
    clearInternalCache(paramContext, paramString);
    clearExternalCache(paramContext, paramString);
    AppMethodBeat.o(228191);
  }
  
  public static void clearExternalCache(Context paramContext)
  {
    AppMethodBeat.i(228037);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext));
    AppMethodBeat.o(228037);
  }
  
  public static void clearExternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228052);
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(228052);
  }
  
  public static void clearInternalCache(Context paramContext)
  {
    AppMethodBeat.i(228135);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext));
    AppMethodBeat.o(228135);
  }
  
  public static void clearInternalCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228145);
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext, paramString));
    AppMethodBeat.o(228145);
  }
  
  public static void deleteDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228200);
    deleteInternalDirectory(paramContext, paramString);
    deleteExternalDirectory(paramContext, paramString);
    AppMethodBeat.o(228200);
  }
  
  public static void deleteExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(227960);
    TPDLIOUtil.recursiveDelete(getExternalDirectory(paramContext, paramString));
    AppMethodBeat.o(227960);
  }
  
  public static void deleteInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228087);
    TPDLIOUtil.recursiveDelete(getInternalDirectory(paramContext, paramString));
    AppMethodBeat.o(228087);
  }
  
  public static File getExternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(227992);
    paramContext = paramContext.getExternalCacheDir();
    AppMethodBeat.o(227992);
    return paramContext;
  }
  
  public static File getExternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228007);
    paramContext = getExternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(228007);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(228007);
    return paramContext;
  }
  
  public static File getExternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(228022);
    paramContext = getExternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(228022);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(228022);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(227924);
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile == null)
    {
      AppMethodBeat.o(227924);
      return null;
    }
    paramContext = new File(localFile.getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getPackageName() + File.separator + "files");
    AppMethodBeat.o(227924);
    return paramContext;
  }
  
  public static File getExternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(227941);
    paramContext = getExternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(227941);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(227941);
    return paramContext;
  }
  
  public static File getExternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(227975);
    paramContext = getExternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(227975);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(227975);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(228107);
    paramContext = paramContext.getCacheDir();
    AppMethodBeat.o(228107);
    return paramContext;
  }
  
  public static File getInternalCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228116);
    paramContext = getInternalCacheDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(228116);
      return null;
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + paramString);
    AppMethodBeat.o(228116);
    return paramContext;
  }
  
  public static File getInternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(228125);
    paramContext = getInternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(228125);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(228125);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext)
  {
    AppMethodBeat.i(228060);
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(228060);
    return paramContext;
  }
  
  public static File getInternalDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228073);
    paramContext = getInternalDirectory(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(228073);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    paramContext = new File(localStringBuilder.toString());
    AppMethodBeat.o(228073);
    return paramContext;
  }
  
  public static File getInternalFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(228099);
    paramContext = getInternalDirectory(paramContext, paramString1);
    if (paramContext == null)
    {
      AppMethodBeat.o(228099);
      return null;
    }
    paramContext = new File(paramContext, paramString2);
    AppMethodBeat.o(228099);
    return paramContext;
  }
  
  public static File getNewerCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(228217);
    paramContext = TPDLIOUtil.compare(getInternalCacheFile(paramContext, paramString1, paramString2), getExternalCacheFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(228217);
    return paramContext;
  }
  
  public static File getNewerFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(228210);
    paramContext = TPDLIOUtil.compare(getInternalFile(paramContext, paramString1, paramString2), getExternalFile(paramContext, paramString1, paramString2));
    AppMethodBeat.o(228210);
    return paramContext;
  }
  
  public static File getProperCacheDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228223);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheDirectory(paramContext, paramString);
      AppMethodBeat.o(228223);
      return paramContext;
    }
    paramContext = getInternalCacheDirectory(paramContext, paramString);
    AppMethodBeat.o(228223);
    return paramContext;
  }
  
  public static File getProperCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(228166);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalCacheFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(228166);
      return paramContext;
    }
    paramContext = getInternalCacheFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(228166);
    return paramContext;
  }
  
  public static File getProperDirectory(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228230);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalDirectory(paramContext, paramString);
      AppMethodBeat.o(228230);
      return paramContext;
    }
    paramContext = getInternalDirectory(paramContext, paramString);
    AppMethodBeat.o(228230);
    return paramContext;
  }
  
  public static File getProperFile(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(228154);
    if (TPDLIOUtil.isExternalStorageMounted())
    {
      paramContext = getExternalFile(paramContext, paramString1, paramString2);
      AppMethodBeat.o(228154);
      return paramContext;
    }
    paramContext = getInternalFile(paramContext, paramString1, paramString2);
    AppMethodBeat.o(228154);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem
 * JD-Core Version:    0.7.0.1
 */