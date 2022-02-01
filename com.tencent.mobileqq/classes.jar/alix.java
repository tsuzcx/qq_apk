import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class alix
  implements ValueAnimator.AnimatorUpdateListener
{
  public alix(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      aliy localaliy = (aliy)paramValueAnimator.next();
      localaliy.jdField_c_of_type_Float = (localaliy.f + (localaliy.g - localaliy.f) * f);
      localaliy.d = (localaliy.h + (localaliy.i - localaliy.h) * f);
      localaliy.e = (localaliy.j + (localaliy.k - localaliy.j) * f);
      localaliy.a = (localaliy.b + (int)((localaliy.jdField_c_of_type_Int - localaliy.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alix
 * JD-Core Version:    0.7.0.1
 */