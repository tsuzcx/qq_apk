import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class afke
  implements Animation.AnimationListener
{
  public afke(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.setVisibility(8);
    this.a.d.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.afRoot.setBackgroundDrawable(this.a.sessionInfo.chatBg.a);
    if (!this.a.isThemeDefault)
    {
      this.a.mCustomTitleView.setBackgroundResource(2130850016);
      this.a.titleBgView.setVisibility(8);
      paramAnimation = this.a.mContext.getResources().getColorStateList(2131167009);
      this.a.mTitleText.setTextColor(paramAnimation);
    }
    for (;;)
    {
      AIOUtils.setViewDrawalbe(this.a.mInputBar, 2130849759);
      return;
      this.a.mCustomTitleView.setBackgroundResource(2130850017);
      this.a.titleBgView.setVisibility(8);
      paramAnimation = this.a.mContext.getResources().getColorStateList(2131167010);
      this.a.mTitleText.setTextColor(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afke
 * JD-Core Version:    0.7.0.1
 */