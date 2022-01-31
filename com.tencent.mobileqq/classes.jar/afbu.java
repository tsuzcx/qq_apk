import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class afbu
  implements afal
{
  private static int jdField_a_of_type_Int = -1;
  public agcb a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public afbu(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private static int a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutHelper", 2, "getLocalTroopAppShortcutSwitchStatus() called load from sp");
      }
      localObject = (QQAppInterface)localObject;
      return BaseApplicationImpl.getApplication().getSharedPreferences("troopapp_shortcut_switch_sp" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("key_troopapp_shortcut_switch", 1);
    }
    return -1;
  }
  
  private aexr a()
  {
    if (!aexp.a())
    {
      QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null))
    {
      QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    return new aexx(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (jdField_a_of_type_Int = 1;; jdField_a_of_type_Int = 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAppShortcutHelper", 2, "setLocalMultiCardSwitchStatus() called switch is " + jdField_a_of_type_Int);
        }
        localObject = (QQAppInterface)localObject;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("troopapp_shortcut_switch_sp" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("key_troopapp_shortcut_switch", jdField_a_of_type_Int);
        ((SharedPreferences.Editor)localObject).apply();
      }
      return;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int == -1) {
      jdField_a_of_type_Int = a();
    }
    return jdField_a_of_type_Int != 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return aukl.a(paramQQAppInterface).a();
  }
  
  private boolean c()
  {
    if (!a()) {}
    while (!b()) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agcb != null)
    {
      this.jdField_a_of_type_Agcb.b();
      this.jdField_a_of_type_Agcb = null;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      b();
      return;
    case 6: 
      c();
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 2, 6, 11 };
  }
  
  public void b()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) && (c())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aexr = a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aexr != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)))
    {
      if (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label144;
      }
      aekt.a((InputLinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131368333), 2130849207);
      if (ThemeUtil.isDefaultTheme()) {
        break label129;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849463);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.a);
      return;
      label129:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849464);
    }
    label144:
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.setBackgroundResource(2130843215);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843221);
  }
  
  public boolean b()
  {
    boolean bool = aukl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutHelper", 2, String.format("canShowTroopAppShortcut: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Agcb == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364137);
      this.jdField_a_of_type_Agcb = new agcb(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
    }
    this.jdField_a_of_type_Agcb.a(3);
    this.jdField_a_of_type_Agcb.c(75);
    this.jdField_a_of_type_Agcb.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Agcb == null) {
      return;
    }
    this.jdField_a_of_type_Agcb.d(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbu
 * JD-Core Version:    0.7.0.1
 */