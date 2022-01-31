import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class agwt
  implements ValueAnimator.AnimatorUpdateListener
{
  public agwt(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      agwu localagwu = (agwu)paramValueAnimator.next();
      localagwu.jdField_c_of_type_Float = (localagwu.f + (localagwu.g - localagwu.f) * f);
      localagwu.d = (localagwu.h + (localagwu.i - localagwu.h) * f);
      localagwu.e = (localagwu.j + (localagwu.k - localagwu.j) * f);
      localagwu.a = (localagwu.b + (int)((localagwu.jdField_c_of_type_Int - localagwu.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwt
 * JD-Core Version:    0.7.0.1
 */