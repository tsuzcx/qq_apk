import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class akgm
  implements ValueAnimator.AnimatorUpdateListener
{
  public akgm(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      akgn localakgn = (akgn)paramValueAnimator.next();
      localakgn.jdField_c_of_type_Float = (localakgn.f + (localakgn.g - localakgn.f) * f);
      localakgn.d = (localakgn.h + (localakgn.i - localakgn.h) * f);
      localakgn.e = (localakgn.j + (localakgn.k - localakgn.j) * f);
      localakgn.a = (localakgn.b + (int)((localakgn.jdField_c_of_type_Int - localakgn.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgm
 * JD-Core Version:    0.7.0.1
 */