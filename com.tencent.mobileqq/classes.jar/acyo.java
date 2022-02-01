import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxEnterImageView;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class acyo
  implements ValueAnimator.AnimatorUpdateListener
{
  public acyo(TransitionContext paramTransitionContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Rect paramRect) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    int j = this.jdField_a_of_type_Int;
    int k = Math.round((0 - this.jdField_a_of_type_Int) * f1);
    int m = this.b;
    int n = Math.round((0 - this.b) * f1);
    int i1 = this.c;
    int i2 = Math.round((this.d - this.c) * f1);
    if (this.e < TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).getHeight()) {}
    for (int i = TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).getHeight();; i = this.e)
    {
      int i3 = this.f;
      i = Math.round((i - this.f) * f1);
      this.jdField_a_of_type_AndroidGraphicsRect.set(k + j, n + m, i2 + i1, i + i3);
      TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).setClipBoundsCompact(this.jdField_a_of_type_AndroidGraphicsRect);
      TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).invalidate();
      acvc.a("TransitionContext", "onAnimationUpdate() mPreviewView.getHeight = [" + TransitionContext.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxTransitionContext).getHeight() + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyo
 * JD-Core Version:    0.7.0.1
 */