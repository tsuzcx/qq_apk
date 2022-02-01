import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class alci
  implements ValueAnimator.AnimatorUpdateListener
{
  public alci(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      alcj localalcj = (alcj)paramValueAnimator.next();
      localalcj.jdField_c_of_type_Float = (localalcj.f + (localalcj.g - localalcj.f) * f);
      localalcj.d = (localalcj.h + (localalcj.i - localalcj.h) * f);
      localalcj.e = (localalcj.j + (localalcj.k - localalcj.j) * f);
      localalcj.a = (localalcj.b + (int)((localalcj.jdField_c_of_type_Int - localalcj.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alci
 * JD-Core Version:    0.7.0.1
 */