import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class ahjd
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahjd(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ahje localahje = (ahje)paramValueAnimator.next();
      localahje.jdField_c_of_type_Float = (localahje.f + (localahje.g - localahje.f) * f);
      localahje.d = (localahje.h + (localahje.i - localahje.h) * f);
      localahje.e = (localahje.j + (localahje.k - localahje.j) * f);
      localahje.a = (localahje.b + (int)((localahje.jdField_c_of_type_Int - localahje.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahjd
 * JD-Core Version:    0.7.0.1
 */