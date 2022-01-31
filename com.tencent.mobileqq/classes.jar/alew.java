import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.TabDragAnimationView;

public final class alew
  implements ValueAnimator.AnimatorUpdateListener
{
  public float a;
  private final TabDragAnimationView a;
  public float b = 0.0F;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public alew(TabDragAnimationView paramTabDragAnimationView)
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = paramTabDragAnimationView;
  }
  
  public void a()
  {
    this.c = this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.c;
    this.jdField_d_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.jdField_d_of_type_Float;
    this.e = (this.c - this.jdField_a_of_type_Float);
    this.f = (this.jdField_d_of_type_Float - this.b);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((f2 < 0.1F) && (this.jdField_a_of_type_Float == 0.0F) && (this.b == 0.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.c();
      paramValueAnimator.cancel();
      paramValueAnimator.removeUpdateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.a = null;
      return;
    }
    float f1;
    if (f2 < 0.1F)
    {
      f1 = this.e;
      if (f2 >= 0.1F) {
        break label126;
      }
    }
    label126:
    for (f2 = this.f;; f2 = this.f * (1.0F - f2))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.a(this.c - f1, this.jdField_d_of_type_Float - f2, false);
      return;
      f1 = this.e * (1.0F - f2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alew
 * JD-Core Version:    0.7.0.1
 */