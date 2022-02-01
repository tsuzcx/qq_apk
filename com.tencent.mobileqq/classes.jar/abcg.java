import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;

public class abcg
  implements ValueAnimator.AnimatorUpdateListener
{
  public abcg(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (SingleLyricView.a(this.a) != null) {
      SingleLyricView.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcg
 * JD-Core Version:    0.7.0.1
 */