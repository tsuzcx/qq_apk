import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView;

public class ackn
  implements ValueAnimator.AnimatorUpdateListener
{
  public ackn(GdtVideoCeilingView paramGdtVideoCeilingView, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, GdtVideoCeilingLandView paramGdtVideoCeilingLandView, boolean paramBoolean) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.topMargin = ((int)(f * this.b) + i);
    if (((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin < 1) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin >= GdtVideoCeilingView.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView))) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Boolean)) {
      GdtVideoCeilingView.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, this.jdField_a_of_type_Boolean);
    }
    while (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackn
 * JD-Core Version:    0.7.0.1
 */