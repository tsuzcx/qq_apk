import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import java.io.File;
import org.json.JSONObject;

public class ajus
  implements Runnable
{
  public ajus(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      String str = ((JSONObject)localObject).getString("video_dir");
      localObject = ((JSONObject)localObject).optString("thumb_dir");
      File localFile = new File(str);
      if ((localFile.exists()) && (localFile.isFile())) {
        localJSONObject.put("videoSize", localFile.length() / 1024L);
      }
      localJSONObject.put("thumbData", localObject);
      localJSONObject.put("videoID", str);
      if (Build.VERSION.SDK_INT >= 10)
      {
        localObject = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject).setDataSource(str);
        localJSONObject.put("videoDuration", String.valueOf(Long.parseLong(((MediaMetadataRetriever)localObject).extractMetadata(9)) / 1000L));
      }
      HealthBusinessPlugin.b(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin, this.b, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajus
 * JD-Core Version:    0.7.0.1
 */