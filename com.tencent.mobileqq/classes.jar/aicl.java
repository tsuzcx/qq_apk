import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class aicl
  implements Animation.AnimationListener
{
  public aicl(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    while (paramAnimation != this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidWidgetLinearLayout.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicl
 * JD-Core Version:    0.7.0.1
 */