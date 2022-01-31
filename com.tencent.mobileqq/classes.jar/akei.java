import android.media.AudioManager;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class akei
  implements bdzl
{
  public akei(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(bdzk parambdzk)
  {
    QLog.i("ShortVideoPreviewActivity", 1, "[onCompletion] ");
    if (bhtb.b()) {
      ((AudioManager)this.a.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akei
 * JD-Core Version:    0.7.0.1
 */