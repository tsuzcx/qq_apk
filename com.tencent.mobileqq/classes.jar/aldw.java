import android.media.AudioManager;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class aldw
  implements bgnl
{
  public aldw(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(bgnk parambgnk)
  {
    QLog.i("ShortVideoPreviewActivity", 1, "[onCompletion] ");
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)this.a.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldw
 * JD-Core Version:    0.7.0.1
 */