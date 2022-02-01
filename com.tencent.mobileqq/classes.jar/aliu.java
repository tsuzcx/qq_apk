import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class aliu
  implements ValueAnimator.AnimatorUpdateListener
{
  public aliu(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      aliv localaliv = (aliv)paramValueAnimator.next();
      localaliv.jdField_c_of_type_Float = (localaliv.f + (localaliv.g - localaliv.f) * f);
      localaliv.d = (localaliv.h + (localaliv.i - localaliv.h) * f);
      localaliv.e = (localaliv.j + (localaliv.k - localaliv.j) * f);
      localaliv.a = (localaliv.b + (int)((localaliv.jdField_c_of_type_Int - localaliv.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aliu
 * JD-Core Version:    0.7.0.1
 */