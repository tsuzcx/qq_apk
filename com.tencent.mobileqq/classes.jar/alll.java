import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.widget.DynamicGridView;

public class alll
  extends AnimatorListenerAdapter
{
  public alll(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.b(this.a, false);
    DynamicGridView.a(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.b(this.a, true);
    DynamicGridView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alll
 * JD-Core Version:    0.7.0.1
 */