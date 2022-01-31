import android.os.SystemClock;
import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ajwo
  implements Runnable
{
  ajwo(ajwn paramajwn) {}
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = VipVideoPlayActivity.a(this.a.a);
    this.a.a.a("play_success", 0, 0, l1 - l2, "");
    if (VipVideoPlayActivity.a(this.a.a) != null) {
      VipVideoPlayActivity.a(this.a.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajwo
 * JD-Core Version:    0.7.0.1
 */