import android.os.Handler;
import com.tencent.mobileqq.widget.AudioAnimationView;

public class akst
  implements Runnable
{
  private akst(AudioAnimationView paramAudioAnimationView) {}
  
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
 * Qualified Name:     akst
 * JD-Core Version:    0.7.0.1
 */