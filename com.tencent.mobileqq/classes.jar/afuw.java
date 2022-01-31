import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class afuw
  implements Animation.AnimationListener
{
  public afuw(MiniMsgTabFragment paramMiniMsgTabFragment, int paramInt, Bundle paramBundle) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramAnimation = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramAnimation = null)
    {
      if (paramAnimation != null)
      {
        paramAnimation = paramAnimation.a();
        if (paramAnimation == null) {
          break label125;
        }
      }
      label125:
      for (int i = paramAnimation.c();; i = 0)
      {
        paramAnimation = MiniMsgTabFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment);
        paramAnimation.putExtra("miniAppID", MiniMsgTabFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment));
        paramAnimation.putExtra("clickID", this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_AndroidOsBundle != null) {
          paramAnimation.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        }
        paramAnimation.putExtra("param_proc_badge_count", i);
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment.getActivity().setResult(-1, paramAnimation);
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment.getActivity().finish();
        return;
        paramAnimation = null;
        break;
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuw
 * JD-Core Version:    0.7.0.1
 */