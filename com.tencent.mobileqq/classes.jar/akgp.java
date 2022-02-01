import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class akgp
  implements ValueAnimator.AnimatorUpdateListener
{
  public akgp(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      akgq localakgq = (akgq)paramValueAnimator.next();
      localakgq.jdField_c_of_type_Float = (localakgq.f + (localakgq.g - localakgq.f) * f);
      localakgq.d = (localakgq.h + (localakgq.i - localakgq.h) * f);
      localakgq.e = (localakgq.j + (localakgq.k - localakgq.j) * f);
      localakgq.a = (localakgq.b + (int)((localakgq.jdField_c_of_type_Int - localakgq.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgp
 * JD-Core Version:    0.7.0.1
 */