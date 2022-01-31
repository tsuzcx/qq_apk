package com.tencent.ttpic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLES20;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class VideoDeviceUtil
{
  private static String DIRECTORY;
  public static final int MIN_STORAGE_SIZE = 52428800;
  public static String SD_CARD_ROOT;
  private static final String TAG = VideoDeviceUtil.class.getSimpleName();
  
  static
  {
    checkSdcard();
  }
  
  public static boolean checkSdcard()
  {
    Object localObject1 = VideoPrefsUtil.getDefaultPrefs().getString("pref_key_storage", "");
    DIRECTORY = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      DIRECTORY = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "Camera";
      localObject1 = new File(DIRECTORY);
      if (((File)localObject1).exists())
      {
        if (!((File)localObject1).isDirectory()) {
          DIRECTORY = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        }
        SD_CARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
      }
    }
    for (;;)
    {
      try
      {
        l1 = getAvailableSize(new StatFs(DIRECTORY));
        if (l1 <= 0L) {
          continue;
        }
        bool = isDirectoryWritable(DIRECTORY);
      }
      catch (Exception localException1)
      {
        Object localObject6 = VideoStorageProxy.getAvailableStorage(VideoGlobalContext.getContext());
        Object localObject4 = null;
        Object localObject2 = null;
        if (localObject6 == null) {
          continue;
        }
        try
        {
          if (((List)localObject6).size() <= 0) {
            continue;
          }
          localObject6 = ((List)localObject6).iterator();
          l1 = 0L;
          localObject4 = localObject2;
          l2 = l1;
        }
        catch (Exception localException2)
        {
          l2 = 0L;
        }
        try
        {
          if (!((Iterator)localObject6).hasNext()) {
            continue;
          }
          localObject4 = (String)((Iterator)localObject6).next();
          l2 = getAvailableSize(new StatFs((String)localObject4));
          if (l2 <= 0L) {
            continue;
          }
          bool = isDirectoryWritable((String)localObject4);
        }
        catch (Exception localException3)
        {
          Object localObject3;
          Object localObject5 = localObject3;
          l2 = l1;
          continue;
          continue;
          continue;
          bool = false;
          continue;
        }
        if ((!bool) || (l2 <= l1)) {
          continue;
        }
        long l1 = l2;
        localObject2 = localObject4;
        continue;
        if ((l2 < 52428800L) || (TextUtils.isEmpty((CharSequence)localObject4))) {
          continue;
        }
        SD_CARD_ROOT = (String)localObject4;
        localObject4 = new File((String)localObject4 + File.separator + "DCIM" + File.separator + "Camera");
        if (!((File)localObject4).exists()) {
          continue;
        }
        localObject3 = localObject4;
        if (((File)localObject4).isDirectory()) {
          continue;
        }
        localObject3 = ((File)localObject4).getParentFile();
        if (!((File)localObject3).exists()) {
          continue;
        }
        if (((File)localObject3).isDirectory()) {
          continue;
        }
        localObject3 = new File(((File)localObject3).getParentFile() + File.separator + "Pitu");
        if ((!((File)localObject3).exists()) || (((File)localObject3).isDirectory())) {
          continue;
        }
        ((File)localObject3).delete();
        ((File)localObject3).mkdirs();
        DIRECTORY = ((File)localObject3).getAbsolutePath();
        VideoPrefsUtil.getDefaultPrefs().edit().putString("pref_key_storage", DIRECTORY).apply();
        return true;
        ((File)localObject3).mkdirs();
        continue;
        ((File)localObject4).mkdirs();
        localObject3 = localObject4;
        continue;
        return false;
        long l2 = 0L;
        continue;
        boolean bool = false;
        continue;
        int i = 0;
        continue;
      }
      if ((!bool) || (l1 < 52428800L)) {
        continue;
      }
      return true;
      ((File)localObject1).mkdirs();
      break;
      localObject1 = VideoStorageProxy.getAvailableStorage(VideoGlobalContext.getContext());
      if (localObject1 == null) {
        continue;
      }
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        continue;
      }
      localObject4 = (String)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject4).length() <= DIRECTORY.length()) && (DIRECTORY.contains((CharSequence)localObject4)))
      {
        SD_CARD_ROOT = (String)localObject4;
        i = 1;
        if (i == 0) {
          SD_CARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
      }
    }
  }
  
  @TargetApi(18)
  public static long getAvailableSize(StatFs paramStatFs)
  {
    if (VideoUtil.hasJellyBeanMR2()) {
      return paramStatFs.getAvailableBytes();
    }
    return paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize();
  }
  
  private static File getExternalFilesDir(Context paramContext)
  {
    File localFile2 = paramContext.getExternalFilesDir(null);
    File localFile1 = localFile2;
    if (localFile2 == null)
    {
      paramContext = "/Android/data/" + paramContext.getPackageName() + "/files/";
      localFile1 = new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
    }
    return localFile1;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isExternalStorageAvailable())
    {
      localObject1 = localObject2;
      if (isExternalStorageSpaceEnough(52428800L)) {
        localObject1 = getExternalFilesDir(paramContext).getPath();
      }
    }
    paramContext = new File((String)localObject1 + File.separator + paramString);
    try
    {
      if ((paramContext.exists()) && (paramContext.isFile())) {
        paramContext.delete();
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext;
    }
    catch (Exception paramString) {}
    return paramContext;
  }
  
  public static String getGPUInfo()
  {
    String str1 = GLES20.glGetString(7937);
    String str2 = GLES20.glGetString(7936);
    String str3 = GLES20.glGetString(7938);
    return str1 + "; " + str2 + "; " + str3;
  }
  
  public static long getHeapAllocatedSizeInKb()
  {
    return getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
  }
  
  private static long getRuntimeFreeMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().freeMemory();
    case 0: 
      return Runtime.getRuntime().freeMemory();
    case 1: 
      return Runtime.getRuntime().freeMemory() / 1024L;
    }
    return Runtime.getRuntime().freeMemory() / 1024L / 1024L;
  }
  
  public static long getRuntimeRemainSize(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory() - getHeapAllocatedSizeInKb() * 1024L;
    switch (paramInt)
    {
    case 0: 
    default: 
      return l;
    case 1: 
      return l / 1024L;
    }
    return l / 1048576L;
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().totalMemory();
    case 0: 
      return Runtime.getRuntime().totalMemory();
    case 1: 
      return Runtime.getRuntime().totalMemory() / 1024L;
    }
    return Runtime.getRuntime().totalMemory() / 1024L / 1024L;
  }
  
  public static boolean isDirectoryWritable(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory())) {}
    do
    {
      return false;
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
    } while (!paramString.isDirectory());
    try
    {
      boolean bool = paramString.canWrite();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isExternalStorageAvailable()
  {
    boolean bool = false;
    if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable())) {}
    try
    {
      new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      bool = true;
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isExternalStorageSpaceEnough(long paramLong)
  {
    return getAvailableSize(new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())) > paramLong;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnectedOrConnecting());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoDeviceUtil
 * JD-Core Version:    0.7.0.1
 */