import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class alcf
  implements ValueAnimator.AnimatorUpdateListener
{
  public alcf(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      alcg localalcg = (alcg)paramValueAnimator.next();
      localalcg.jdField_c_of_type_Float = (localalcg.f + (localalcg.g - localalcg.f) * f);
      localalcg.d = (localalcg.h + (localalcg.i - localalcg.h) * f);
      localalcg.e = (localalcg.j + (localalcg.k - localalcg.j) * f);
      localalcg.a = (localalcg.b + (int)((localalcg.jdField_c_of_type_Int - localalcg.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcf
 * JD-Core Version:    0.7.0.1
 */