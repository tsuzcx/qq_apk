import android.os.Handler;
import com.tencent.mobileqq.widget.AudioAnimationView;

public class akem
  implements Runnable
{
  private akem(AudioAnimationView paramAudioAnimationView) {}
  
  public void run()
  {
    this.a.b();
    if (this.a.a) {
      AudioAnimationView.a(this.a).postDelayed(this, 100L);
    }
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akem
 * JD-Core Version:    0.7.0.1
 */