import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class ajap
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajap(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ajaq localajaq = (ajaq)paramValueAnimator.next();
      localajaq.jdField_c_of_type_Float = (localajaq.f + (localajaq.g - localajaq.f) * f);
      localajaq.d = (localajaq.h + (localajaq.i - localajaq.h) * f);
      localajaq.e = (localajaq.j + (localajaq.k - localajaq.j) * f);
      localajaq.a = (localajaq.b + (int)((localajaq.jdField_c_of_type_Int - localajaq.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajap
 * JD-Core Version:    0.7.0.1
 */