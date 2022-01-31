import android.content.Context;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahxk
{
  public static void a(Context paramContext)
  {
    P2VGlobalConfig.P2V_VIDEO_ROOT = paramContext.getFilesDir().getAbsolutePath() + File.separator + "qzone_dynamic_video" + File.separator;
    P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT = paramContext.getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator + "dynamic_video_cache" + File.separator;
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
    bbdx.c(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + ".nomedia");
    bbdx.c(P2VGlobalConfig.P2V_MATERIAL_ROOT + ".nomedia");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxk
 * JD-Core Version:    0.7.0.1
 */