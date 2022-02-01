import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class agkp
  implements agin
{
  public ahpl a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agkp(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private ager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null))
    {
      QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    return new agex(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahpl != null)
    {
      this.jdField_a_of_type_Ahpl.b();
      this.jdField_a_of_type_Ahpl = null;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      b();
      return;
    case 8: 
      c();
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 14 };
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer = a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)))
    {
      if (nty.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)) {
        break label137;
      }
      AIOUtils.setViewDrawalbe((InputLinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131368910), 2130849852);
      if (ThemeUtil.isDefaultTheme()) {
        break label122;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.setBackgroundResource(2130850109);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.chatBg.a);
      return;
      label122:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.setBackgroundResource(2130850110);
    }
    label137:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot.setBackgroundResource(2130843707);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.setBackgroundResource(2130843713);
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ahpl == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131364488);
      this.jdField_a_of_type_Ahpl = new ahpl(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
    }
    this.jdField_a_of_type_Ahpl.a(3);
    this.jdField_a_of_type_Ahpl.c(75);
    this.jdField_a_of_type_Ahpl.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ahpl == null) {
      return;
    }
    this.jdField_a_of_type_Ahpl.d(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkp
 * JD-Core Version:    0.7.0.1
 */