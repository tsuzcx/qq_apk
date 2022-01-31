import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class ajfb
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajfb(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ajfc localajfc = (ajfc)paramValueAnimator.next();
      localajfc.jdField_c_of_type_Float = (localajfc.f + (localajfc.g - localajfc.f) * f);
      localajfc.d = (localajfc.h + (localajfc.i - localajfc.h) * f);
      localajfc.e = (localajfc.j + (localajfc.k - localajfc.j) * f);
      localajfc.a = (localajfc.b + (int)((localajfc.jdField_c_of_type_Int - localajfc.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfb
 * JD-Core Version:    0.7.0.1
 */