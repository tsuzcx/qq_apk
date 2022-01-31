import android.os.Handler;
import com.tencent.mobileqq.widget.AudioAnimationView;

public class alak
  implements Runnable
{
  private alak(AudioAnimationView paramAudioAnimationView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alak
 * JD-Core Version:    0.7.0.1
 */