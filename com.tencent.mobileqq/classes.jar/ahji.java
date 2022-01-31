import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class ahji
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahji(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      ahjj localahjj = (ahjj)paramValueAnimator.next();
      localahjj.jdField_c_of_type_Float = (localahjj.f + (localahjj.g - localahjj.f) * f);
      localahjj.d = (localahjj.h + (localahjj.i - localahjj.h) * f);
      localahjj.e = (localahjj.j + (localahjj.k - localahjj.j) * f);
      localahjj.a = (localahjj.b + (int)((localahjj.jdField_c_of_type_Int - localahjj.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahji
 * JD-Core Version:    0.7.0.1
 */