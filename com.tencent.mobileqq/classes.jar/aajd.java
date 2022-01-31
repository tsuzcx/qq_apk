import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aajd
  implements ValueAnimator.AnimatorUpdateListener
{
  public aajd(MainDownAni paramMainDownAni, WeakReference paramWeakReference1, WeakReference paramWeakReference2, String[] paramArrayOfString, BitmapDrawable paramBitmapDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    boolean bool2 = false;
    Object localObject = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    TextView localTextView = (TextView)this.b.get();
    if ((localObject == null) || (((ImageView)localObject).getVisibility() != 0) || (localTextView == null))
    {
      paramValueAnimator.removeAllUpdateListeners();
      String str = MainDownAni.a();
      StringBuilder localStringBuilder = new StringBuilder().append("startBackgroundDrawableAnimator, fail, image[");
      if (localObject != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = localStringBuilder.append(bool1).append("], text[");
        bool1 = bool2;
        if (localTextView != null) {
          bool1 = true;
        }
        QLog.w(str, 1, bool1 + "]");
        if (paramValueAnimator.isRunning()) {
          paramValueAnimator.end();
        }
        return;
      }
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a(localTextView, Color.parseColor(this.jdField_a_of_type_ArrayOfJavaLangString[i]), (ImageView)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajd
 * JD-Core Version:    0.7.0.1
 */