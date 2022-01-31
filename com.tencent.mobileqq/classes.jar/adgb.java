import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;

public class adgb
  implements ValueAnimator.AnimatorUpdateListener
{
  public adgb(VideoFileViewer paramVideoFileViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((this.a.a.getVisibility() == 0) && (Math.abs(this.a.a.getAlpha() - f) >= 0.02F)) {
        this.a.a.setAlpha(f);
      }
      if ((this.a.a.getVisibility() == 0) && (Math.abs(this.a.a.getAlpha() - f) >= 0.02F)) {
        this.a.a.setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adgb
 * JD-Core Version:    0.7.0.1
 */