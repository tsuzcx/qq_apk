import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;

class acrr
  implements ValueAnimator.AnimatorUpdateListener
{
  acrr(acrq paramacrq, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.topMargin = ((int)(f * this.b) + i);
    if (((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin <= acrq.a(this.jdField_a_of_type_Acrq)) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin >= acrq.b(this.jdField_a_of_type_Acrq))) && (acrq.a(this.jdField_a_of_type_Acrq).a))
    {
      acrq.a(this.jdField_a_of_type_Acrq);
      return;
    }
    acrq.a(this.jdField_a_of_type_Acrq).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_Acrq.a((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin - acrq.a(this.jdField_a_of_type_Acrq)) * 1.0F / (acrq.b(this.jdField_a_of_type_Acrq) - acrq.a(this.jdField_a_of_type_Acrq)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrr
 * JD-Core Version:    0.7.0.1
 */