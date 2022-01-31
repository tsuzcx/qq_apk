import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.portal.ConversationHongBao;

public class agqq
  implements ValueAnimator.AnimatorUpdateListener
{
  public agqq(ConversationHongBao paramConversationHongBao, RelativeLayout.LayoutParams paramLayoutParams, View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {}
    float f;
    do
    {
      return;
      f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
      int i = (int)(-ConversationHongBao.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao) * (1.0F - f));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = i;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    } while (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.f);
    this.b.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqq
 * JD-Core Version:    0.7.0.1
 */