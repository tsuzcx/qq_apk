import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.navigate.IntimateInfoNavBar.1;
import com.tencent.mobileqq.activity.aio.navigate.IntimateInfoNavBar.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ahpj
  extends ahpk
  implements Animation.AnimationListener
{
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  public ahpj(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
  }
  
  public long a()
  {
    return 15000L;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560984, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362992));
    TextView localTextView = (TextView)localView.findViewById(2131378961);
    return localView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer.b(true);
    }
    bdla.b(null, "dc00898", "", "", "0X800A11D", "0X800A11D", 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer == null)) {
      QLog.d("NavigateBarManager.IntimateInfoNavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
    }
    ExtensionInfo localExtensionInfo;
    do
    {
      return false;
      localExtensionInfo = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, false);
    } while ((localExtensionInfo == null) || (localExtensionInfo.intimate_type == 0));
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("IntimateInfo" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("key_aio_score_guide_count", 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.IntimateInfoNavBar", 2, String.format("needShow score guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new IntimateInfoNavBar.1(this), 500L);
    ThreadManager.postImmediately(new IntimateInfoNavBar.2(this), null, false);
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpj
 * JD-Core Version:    0.7.0.1
 */