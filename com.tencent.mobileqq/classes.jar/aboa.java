import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;

class aboa
  implements ValueAnimator.AnimatorUpdateListener
{
  aboa(abnz paramabnz, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.topMargin = ((int)(f * this.b) + i);
    if (((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin <= abnz.a(this.jdField_a_of_type_Abnz)) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin >= abnz.b(this.jdField_a_of_type_Abnz))) && (abnz.a(this.jdField_a_of_type_Abnz).a))
    {
      abnz.a(this.jdField_a_of_type_Abnz);
      return;
    }
    abnz.a(this.jdField_a_of_type_Abnz).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_Abnz.a((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin - abnz.a(this.jdField_a_of_type_Abnz)) * 1.0F / (abnz.b(this.jdField_a_of_type_Abnz) - abnz.a(this.jdField_a_of_type_Abnz)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aboa
 * JD-Core Version:    0.7.0.1
 */