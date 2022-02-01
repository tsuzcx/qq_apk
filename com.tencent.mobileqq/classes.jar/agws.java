import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class agws
  implements agvc
{
  public ahzx a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agws(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private agrt a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null))
    {
      QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    return new agrz(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahzx != null)
    {
      this.jdField_a_of_type_Ahzx.b();
      this.jdField_a_of_type_Ahzx = null;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      b();
      return;
    case 7: 
      c();
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 3, 7, 13 };
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agrt = a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agrt != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)))
    {
      if (nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label137;
      }
      agej.a((InputLinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131368726), 2130849842);
      if (ThemeUtil.isDefaultTheme()) {
        break label122;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850099);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a);
      return;
      label122:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850100);
    }
    label137:
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.setBackgroundResource(2130843607);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843613);
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ahzx == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364389);
      this.jdField_a_of_type_Ahzx = new ahzx(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
    }
    this.jdField_a_of_type_Ahzx.a(3);
    this.jdField_a_of_type_Ahzx.c(75);
    this.jdField_a_of_type_Ahzx.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ahzx == null) {
      return;
    }
    this.jdField_a_of_type_Ahzx.d(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agws
 * JD-Core Version:    0.7.0.1
 */