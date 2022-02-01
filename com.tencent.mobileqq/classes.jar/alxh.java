import android.media.AudioManager;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class alxh
  implements bhgm
{
  public alxh(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(bhgl parambhgl)
  {
    QLog.i("ShortVideoPreviewActivity", 1, "[onCompletion] ");
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)this.a.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxh
 * JD-Core Version:    0.7.0.1
 */