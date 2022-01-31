import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.qphone.base.util.QLog;

class aaxf
  implements ValueAnimation.AnimationUpdateListener
{
  aaxf(aaxe paramaaxe, int paramInt) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (this.jdField_a_of_type_Aaxe.a.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "ValueAnimation.chatPie == null!");
      }
      return;
    }
    paramValueAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aaxe.b.getLayoutParams();
    int i;
    if (paramInteger.intValue() < this.jdField_a_of_type_Int)
    {
      i = paramInteger.intValue();
      paramValueAnimation.height = i;
      if (Build.VERSION.SDK_INT >= 11) {
        if (paramInteger.intValue() >= this.jdField_a_of_type_Int) {
          break label136;
        }
      }
    }
    label136:
    for (paramFloat = paramInteger.intValue() / this.jdField_a_of_type_Int;; paramFloat = 1.0F)
    {
      this.jdField_a_of_type_Aaxe.b.setAlpha(paramFloat);
      this.jdField_a_of_type_Aaxe.b.requestLayout();
      this.jdField_a_of_type_Aaxe.b.setVisibility(0);
      return;
      i = -2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxf
 * JD-Core Version:    0.7.0.1
 */