import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.tencent.mobileqq.armap.RedPackRainCloudView;
import java.text.NumberFormat;

public class abdb
  implements ValueAnimator.AnimatorUpdateListener
{
  public abdb(RedPackRainCloudView paramRedPackRainCloudView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j = String.valueOf(i).length();
    if (j >= 8) {
      RedPackRainCloudView.a(this.a).setTextSize(1, 19.0F);
    }
    for (;;)
    {
      paramValueAnimator = NumberFormat.getNumberInstance();
      paramValueAnimator = new SpannableString(paramValueAnimator.format(i) + "个");
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-10066330);
      paramValueAnimator.setSpan(new AbsoluteSizeSpan(12, true), paramValueAnimator.length() - 1, paramValueAnimator.length(), 33);
      paramValueAnimator.setSpan(localForegroundColorSpan, paramValueAnimator.length() - 1, paramValueAnimator.length(), 33);
      paramValueAnimator.setSpan(new StyleSpan(1), 0, paramValueAnimator.length() - 1, 33);
      RedPackRainCloudView.a(this.a).setText(paramValueAnimator);
      return;
      if (j >= 7) {
        RedPackRainCloudView.a(this.a).setTextSize(1, 21.0F);
      } else if (j >= 6) {
        RedPackRainCloudView.a(this.a).setTextSize(1, 23.0F);
      } else if (j >= 5) {
        RedPackRainCloudView.a(this.a).setTextSize(1, 25.0F);
      } else {
        RedPackRainCloudView.a(this.a).setTextSize(1, 27.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdb
 * JD-Core Version:    0.7.0.1
 */