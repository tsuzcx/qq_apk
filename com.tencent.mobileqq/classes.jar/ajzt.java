import android.media.AudioManager;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class ajzt
  implements bdvc
{
  public ajzt(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(bdvb parambdvb)
  {
    QLog.i("ShortVideoPreviewActivity", 1, "[onCompletion] ");
    if (bhou.b()) {
      ((AudioManager)this.a.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzt
 * JD-Core Version:    0.7.0.1
 */