import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.qphone.base.util.QLog;

public class alsy
  implements MediaPlayer.OnPreparedListener
{
  public alsy(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "onPrepared, duration:" + paramMediaPlayer.getDuration());
    }
    EditLocalVideoActivity.a(this.a).removeMessages(9999);
    EditLocalVideoActivity.h(this.a);
    EditLocalVideoActivity.a(this.a).a(EditLocalVideoActivity.a(this.a), EditLocalVideoActivity.a(this.a));
    EditLocalVideoActivity.a(this.a).a(EditLocalVideoActivity.c(this.a), EditLocalVideoActivity.d(this.a));
    EditLocalVideoActivity.a(this.a).a(paramMediaPlayer.getDuration());
    int i;
    int j;
    if (!EditLocalVideoActivity.a(this.a).a())
    {
      EditLocalVideoActivity.d(this.a, paramMediaPlayer.getDuration());
      if ((bnjl.a(EditLocalVideoActivity.b(this.a)) / EditLocalVideoActivity.a(this.a).getDuration() * 15000L > this.a.a(EditLocalVideoActivity.a())) && (QLog.isColorLevel())) {
        QLog.d("EditLocalVideoActivity", 2, "prepared, there is not enough space on sdcard");
      }
      i = paramMediaPlayer.getVideoWidth();
      j = paramMediaPlayer.getVideoHeight();
      if ((i <= 0) || (j <= 0)) {
        Toast.makeText(this.a.getApplicationContext(), anzj.a(2131702537), 1).show();
      }
    }
    else
    {
      return;
    }
    EditLocalVideoActivity.e(this.a, i);
    EditLocalVideoActivity.f(this.a, j);
    EditLocalVideoActivity.a(this.a, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsy
 * JD-Core Version:    0.7.0.1
 */