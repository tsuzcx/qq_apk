import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class ahjg
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahjg(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ahjh localahjh = (ahjh)paramValueAnimator.next();
      localahjh.jdField_c_of_type_Float = (localahjh.f + (localahjh.g - localahjh.f) * f);
      localahjh.d = (localahjh.h + (localahjh.i - localahjh.h) * f);
      localahjh.e = (localahjh.j + (localahjh.k - localahjh.j) * f);
      localahjh.a = (localahjh.b + (int)((localahjh.jdField_c_of_type_Int - localahjh.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahjg
 * JD-Core Version:    0.7.0.1
 */