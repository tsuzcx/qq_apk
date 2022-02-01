import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;

class acnp
  implements ValueAnimator.AnimatorUpdateListener
{
  acnp(acno paramacno, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.topMargin = ((int)(f * this.b) + i);
    if (((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin <= acno.a(this.jdField_a_of_type_Acno)) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin >= acno.b(this.jdField_a_of_type_Acno))) && (acno.a(this.jdField_a_of_type_Acno).a))
    {
      acno.a(this.jdField_a_of_type_Acno);
      return;
    }
    acno.a(this.jdField_a_of_type_Acno).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_Acno.a((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin - acno.a(this.jdField_a_of_type_Acno)) * 1.0F / (acno.b(this.jdField_a_of_type_Acno) - acno.a(this.jdField_a_of_type_Acno)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnp
 * JD-Core Version:    0.7.0.1
 */