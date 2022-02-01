import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;

class acdo
  implements ValueAnimator.AnimatorUpdateListener
{
  acdo(acdn paramacdn, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.topMargin = ((int)(f * this.b) + i);
    if (((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin <= acdn.a(this.jdField_a_of_type_Acdn)) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin >= acdn.b(this.jdField_a_of_type_Acdn))) && (acdn.a(this.jdField_a_of_type_Acdn).a))
    {
      acdn.a(this.jdField_a_of_type_Acdn);
      return;
    }
    acdn.a(this.jdField_a_of_type_Acdn).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_Acdn.a((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin - acdn.a(this.jdField_a_of_type_Acdn)) * 1.0F / (acdn.b(this.jdField_a_of_type_Acdn) - acdn.a(this.jdField_a_of_type_Acdn)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdo
 * JD-Core Version:    0.7.0.1
 */