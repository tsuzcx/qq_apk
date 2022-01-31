package com.tencent.mm.plugin.voip.video.a;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/voip/video/filter/FilterPath;", "", "()V", "MIN_STORAGE_SIZE", "", "getMIN_STORAGE_SIZE", "()I", "TAG", "", "VIDEO_LUT_FILE_DIR", "getVIDEO_LUT_FILE_DIR", "()Ljava/lang/String;", "YT_MODEL_BACKUP_FILE_DIR", "getYT_MODEL_BACKUP_FILE_DIR", "YT_MODEL_FILE_DIR", "getYT_MODEL_FILE_DIR", "getExternalFilesDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "folder", "getVideoLutFileDir", "getYtDetectModelBackupFileDir", "getYtDetectModelFileDir", "plugin-voip_release"})
public final class a
{
  private static final int MIN_STORAGE_SIZE = 52428800;
  private static final String TAG = "MicroMsg.FilterPath";
  private static final String ltA = "weishi_yt_model";
  public static final String ltB = "weishi_yt_backup_model";
  public static final String ltz = "weishi_video_lut";
  public static final a tHN;
  
  static
  {
    AppMethodBeat.i(140306);
    tHN = new a();
    TAG = "MicroMsg.FilterPath";
    MIN_STORAGE_SIZE = 52428800;
    ltz = "weishi_video_lut";
    ltA = "weishi_yt_model";
    ltB = "weishi_yt_backup_model";
    AppMethodBeat.o(140306);
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(140305);
    j.q(paramContext, "context");
    j.q(paramString, "folder");
    Object localObject1 = localObject4;
    if (DeviceUtils.isExternalStorageAvailable())
    {
      localObject1 = localObject4;
      if (!DeviceUtils.isExternalStorageSpaceEnough(MIN_STORAGE_SIZE)) {}
    }
    try
    {
      localObject1 = paramContext.getExternalFilesDir(null);
      if (localObject1 == null)
      {
        localObject1 = "/Android/data/" + paramContext.getPackageName() + "/files/";
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramContext = paramContext.getFilesDir();
          j.p(paramContext, "context.filesDir");
          localObject3 = paramContext.getPath();
        }
        paramContext = new File((String)localObject3 + File.separator + paramString);
      }
      try
      {
        if ((paramContext.exists()) && (paramContext.isFile())) {
          paramContext.delete();
        }
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Object localObject2;
          LogUtils.e((Throwable)paramString);
        }
      }
      AppMethodBeat.o(140305);
      return paramContext;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        localObject2 = localObject3;
        continue;
        localObject2 = ((File)localObject2).getPath();
      }
    }
  }
  
  public static String getYtDetectModelFileDir()
  {
    AppMethodBeat.i(140304);
    Object localObject = Environment.getExternalStorageDirectory();
    j.p(localObject, "Environment.getExternalStorageDirectory()");
    localObject = ((File)localObject).getPath();
    File localFile = new File((String)localObject + File.separator + ltA);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    if (DeviceUtils.canWriteFile(localFile.getAbsolutePath()))
    {
      localObject = localFile.getAbsolutePath();
      j.p(localObject, "dir.absolutePath");
      AppMethodBeat.o(140304);
      return localObject;
    }
    j.p(localObject, "root");
    AppMethodBeat.o(140304);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */