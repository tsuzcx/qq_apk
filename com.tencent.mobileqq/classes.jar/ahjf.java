import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class ahjf
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahjf(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ahjg localahjg = (ahjg)paramValueAnimator.next();
      localahjg.jdField_c_of_type_Float = (localahjg.f + (localahjg.g - localahjg.f) * f);
      localahjg.d = (localahjg.h + (localahjg.i - localahjg.h) * f);
      localahjg.e = (localahjg.j + (localahjg.k - localahjg.j) * f);
      localahjg.a = (localahjg.b + (int)((localahjg.jdField_c_of_type_Int - localahjg.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahjf
 * JD-Core Version:    0.7.0.1
 */