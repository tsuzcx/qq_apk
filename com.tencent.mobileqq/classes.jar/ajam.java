import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class ajam
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajam(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ajan localajan = (ajan)paramValueAnimator.next();
      localajan.jdField_c_of_type_Float = (localajan.f + (localajan.g - localajan.f) * f);
      localajan.d = (localajan.h + (localajan.i - localajan.h) * f);
      localajan.e = (localajan.j + (localajan.k - localajan.j) * f);
      localajan.a = (localajan.b + (int)((localajan.jdField_c_of_type_Int - localajan.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajam
 * JD-Core Version:    0.7.0.1
 */