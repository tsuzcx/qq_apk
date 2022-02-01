import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import java.util.Iterator;
import java.util.List;

public class akxf
  implements ValueAnimator.AnimatorUpdateListener
{
  public akxf(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      akxg localakxg = (akxg)paramValueAnimator.next();
      localakxg.jdField_c_of_type_Float = (localakxg.f + (localakxg.g - localakxg.f) * f);
      localakxg.d = (localakxg.h + (localakxg.i - localakxg.h) * f);
      localakxg.e = (localakxg.j + (localakxg.k - localakxg.j) * f);
      localakxg.a = (localakxg.b + (int)((localakxg.jdField_c_of_type_Int - localakxg.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxf
 * JD-Core Version:    0.7.0.1
 */