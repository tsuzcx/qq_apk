import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;

public class ahku
{
  private static String a = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vEffectUrl", "https://d3g.qq.com/sngapp/app/update/20180716151136_5735/p2v_effect.jar");
  private static String b = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vEffectJarMD5", "bc6e9f9cabc10efff4d0a9c44748c118");
  private static String c = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vMaterialUrl", "http://d3g.qq.com/sngapp/app/update/20180124144756_2643/p2v_material.zip");
  private static String d = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vMaterialMD5", "f61e9058b09761852fda262a13c353fc");
  
  public static void a(Context paramContext)
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      P2VGlobalConfig.P2V_VIDEO_ROOT = Environment.getExternalStorageDirectory().toString() + File.separator + "qzone_dynamic_video" + File.separator;
    }
    for (P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "dynamic_video_cache" + File.separator;; P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT = paramContext.getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator + "dynamic_video_cache" + File.separator)
    {
      P2VGlobalConfig.NO_AUDIO_MP4 = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "no_audio.mp4";
      P2VGlobalConfig.CONCAT_FINAL_M4A = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "concat_final.m4a";
      P2VGlobalConfig.CONCAT_FINAL_MP3 = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "concat_final.mp3";
      P2VGlobalConfig.P2V_MATERIAL_ROOT = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "p2v_material" + File.separator;
      P2VGlobalConfig.P2V_MATERIAL_WATER_MARKER_PNG_NAME = P2VGlobalConfig.P2V_MATERIAL_ROOT + "qzone_p2v_watermark.png";
      P2VGlobalConfig.P2V_MATERIAL_DUMMY_VIDEO_NAME = P2VGlobalConfig.P2V_MATERIAL_ROOT + "resizeddummy.mp4";
      try
      {
        paramContext = new File(P2VGlobalConfig.P2V_VIDEO_ROOT);
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        paramContext = new File(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT);
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          QLog.d("P2VEffectLoader", 2, "initP2VCacheRootSpace exception", paramContext);
        }
      }
      bace.c(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + ".nomedia");
      bace.c(P2VGlobalConfig.P2V_MATERIAL_ROOT + ".nomedia");
      return;
      P2VGlobalConfig.P2V_VIDEO_ROOT = paramContext.getFilesDir().getAbsolutePath() + File.separator + "qzone_dynamic_video" + File.separator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahku
 * JD-Core Version:    0.7.0.1
 */