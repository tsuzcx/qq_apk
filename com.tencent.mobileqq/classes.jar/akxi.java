import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import java.util.Iterator;
import java.util.List;

public class akxi
  implements ValueAnimator.AnimatorUpdateListener
{
  public akxi(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      akxj localakxj = (akxj)paramValueAnimator.next();
      localakxj.jdField_c_of_type_Float = (localakxj.f + (localakxj.g - localakxj.f) * f);
      localakxj.d = (localakxj.h + (localakxj.i - localakxj.h) * f);
      localakxj.e = (localakxj.j + (localakxj.k - localakxj.j) * f);
      localakxj.a = (localakxj.b + (int)((localakxj.jdField_c_of_type_Int - localakxj.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxi
 * JD-Core Version:    0.7.0.1
 */