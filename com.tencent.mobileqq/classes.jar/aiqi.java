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

public class aiqi
  implements Animation.AnimationListener
{
  public aiqi(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.p.setVisibility(8);
    this.a.q.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.d.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
    if (!this.a.H)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850099);
      this.a.k.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166987);
      this.a.e.setTextColor(paramAnimation);
    }
    for (;;)
    {
      agej.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130849842);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850100);
      this.a.k.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166988);
      this.a.e.setTextColor(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqi
 * JD-Core Version:    0.7.0.1
 */