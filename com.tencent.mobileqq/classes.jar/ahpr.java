import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.1;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.2;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class ahpr
  extends ahpk
  implements Animation.AnimationListener
{
  private long jdField_a_of_type_Long;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  public ahpr(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
    paramBaseChatPie = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = paramBaseChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
      if (paramBaseChatPie != null) {
        this.jdField_a_of_type_Long = paramBaseChatPie.dwGroupClassExt;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        paramQQAppInterface = (QQAppInterface)localObject;
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        return "troopapp_shortcut_guide_counts";
      }
    }
    return "troopapp_shortcut_guide_counts" + ((QQAppInterface)localObject).getCurrentAccountUin();
  }
  
  public static void e()
  {
    ThreadManager.postImmediately(new TroopAppShortcutNavBar.3(), null, false);
  }
  
  public long a()
  {
    return 15000L;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561002, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362992));
    return localView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer.b(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer instanceof agex)) {
        ((agex)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer).c(4);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)
    {
      bdla.b(null, "dc00898", "", str, "0X800AD07", "0X800AD07", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer == null))
    {
      QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getInt(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0);
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i) }));
      }
    } while (i < 3);
    return false;
  }
  
  public void b()
  {
    bdla.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, "0X800AD06", "0X800AD06", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new TroopAppShortcutNavBar.1(this), 500L);
    ThreadManager.postImmediately(new TroopAppShortcutNavBar.2(this), null, false);
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
 * Qualified Name:     ahpr
 * JD-Core Version:    0.7.0.1
 */