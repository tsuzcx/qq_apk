import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acyo
  implements acxg
{
  private static int jdField_a_of_type_Int = -1;
  public aduq a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private artp jdField_a_of_type_Artp;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public acyo(BaseChatPie paramBaseChatPie)
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
        QLog.d("TroopMultiCardHelper", 2, "getLocalMultiCardSwitchStatus() called load from sp");
      }
      localObject = (QQAppInterface)localObject;
      return BaseApplicationImpl.getApplication().getSharedPreferences("multicard_switch_sp" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("key_multicard_switch", 1);
    }
    return -1;
  }
  
  private acuz a()
  {
    if (!acux.a())
    {
      QLog.d("TroopMultiCardHelper", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null))
    {
      QLog.d("TroopMultiCardHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    return new acve(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
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
          QLog.d("TroopMultiCardHelper", 2, "setLocalMultiCardSwitchStatus() called switch is " + jdField_a_of_type_Int);
        }
        localObject = (QQAppInterface)localObject;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("multicard_switch_sp" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("key_multicard_switch", jdField_a_of_type_Int);
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
  
  public static boolean b()
  {
    amcp localamcp = amcq.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopMultiCardHelper", 2, "isSwitchOn:" + localamcp.a);
    }
    return localamcp.a;
  }
  
  public static boolean c()
  {
    Object localObject2 = (artp)alzw.a().a(478);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new artp();
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopMultiCardHelper", 2, "isDeviceSupport, MultiAIOEntranceConfigData =null, general new bean");
        localObject1 = localObject2;
      }
    }
    localObject2 = ((artp)localObject1).a();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMultiCardHelper", 2, "devicetype:" + str + " version:" + Build.VERSION.SDK_INT);
    }
    str = str.trim();
    if ((localObject2 != null) && (((List)localObject2).contains(str))) {
      return false;
    }
    localObject1 = ((artp)localObject1).a();
    return (TextUtils.isEmpty((CharSequence)localObject1)) || (awkj.b((String)localObject1) > 0);
  }
  
  private boolean d()
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "isLocalSwitchOn: false");
      }
    }
    Object localObject;
    do
    {
      String str;
      do
      {
        do
        {
          return false;
        } while (!b());
        f();
        localObject = this.jdField_a_of_type_Artp.a();
        str = Build.MANUFACTURER + Build.MODEL;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMultiCardHelper", 2, "devicetype:" + str + " version:" + Build.VERSION.SDK_INT);
        }
        str = str.trim();
      } while ((localObject != null) && (((List)localObject).contains(str)));
      localObject = this.jdField_a_of_type_Artp.a();
    } while ((!TextUtils.isEmpty((CharSequence)localObject)) && (awkj.b((String)localObject) <= 0));
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aduq != null)
    {
      this.jdField_a_of_type_Aduq.b();
      this.jdField_a_of_type_Aduq = null;
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
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb)) && (d())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acuz = a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acuz != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb)))
    {
      if (mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label147;
      }
      aciy.a((InputLinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131302567), 2130848527);
      if (ThemeUtil.isDefaultTheme()) {
        break label131;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130848801);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.a);
      return;
      label131:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130848802);
    }
    label147:
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.setBackgroundResource(2130842947);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130842953);
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aduq == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131298518);
      this.jdField_a_of_type_Aduq = new aduq(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
    }
    this.jdField_a_of_type_Aduq.a(2);
    this.jdField_a_of_type_Aduq.c(75);
    this.jdField_a_of_type_Aduq.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aduq == null) {
      return;
    }
    this.jdField_a_of_type_Aduq.d(2);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Artp = ((artp)alzw.a().a(478));
    if (this.jdField_a_of_type_Artp == null)
    {
      this.jdField_a_of_type_Artp = new artp();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "MultiAIOEntranceConfigData =null, general new bean");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acyo
 * JD-Core Version:    0.7.0.1
 */