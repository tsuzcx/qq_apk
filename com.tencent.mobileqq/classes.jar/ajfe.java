import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class ajfe
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajfe(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ajff localajff = (ajff)paramValueAnimator.next();
      localajff.jdField_c_of_type_Float = (localajff.f + (localajff.g - localajff.f) * f);
      localajff.d = (localajff.h + (localajff.i - localajff.h) * f);
      localajff.e = (localajff.j + (localajff.k - localajff.j) * f);
      localajff.a = (localajff.b + (int)((localajff.jdField_c_of_type_Int - localajff.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfe
 * JD-Core Version:    0.7.0.1
 */