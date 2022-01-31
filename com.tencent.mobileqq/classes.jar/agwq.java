import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class agwq
  implements ValueAnimator.AnimatorUpdateListener
{
  public agwq(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      agwr localagwr = (agwr)paramValueAnimator.next();
      localagwr.jdField_c_of_type_Float = (localagwr.f + (localagwr.g - localagwr.f) * f);
      localagwr.d = (localagwr.h + (localagwr.i - localagwr.h) * f);
      localagwr.e = (localagwr.j + (localagwr.k - localagwr.j) * f);
      localagwr.a = (localagwr.b + (int)((localagwr.jdField_c_of_type_Int - localagwr.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwq
 * JD-Core Version:    0.7.0.1
 */