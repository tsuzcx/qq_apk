import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class aeun
  implements Animation.AnimationListener
{
  public aeun(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.q.setVisibility(8);
    this.a.r.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.d.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
    if (!this.a.I)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849032);
      this.a.o.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166851);
      this.a.e.setTextColor(paramAnimation);
    }
    for (;;)
    {
      actj.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130848776);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849033);
      this.a.o.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166852);
      this.a.e.setTextColor(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeun
 * JD-Core Version:    0.7.0.1
 */