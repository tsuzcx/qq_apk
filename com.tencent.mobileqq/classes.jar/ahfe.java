import android.content.Intent;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView.25.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.AccountObserver;

public class ahfe
  extends AccountObserver
{
  public ahfe(LoginView paramLoginView) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_LoginActivity.LoginView", 2, "onCheckQuickRegisterAccount|isSuccess= " + paramBoolean + ",code=" + paramInt);
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(4);
      if ((paramBoolean) && (paramInt == 0))
      {
        paramArrayOfByte = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RegisterByNicknameAndPwdActivity.class);
        paramArrayOfByte.putExtra("key_register_binduin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramArrayOfByte.putExtra("key_register_from_quick_register", true);
        paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
        paramArrayOfByte.putExtra("not_need_verify_sms", true);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramArrayOfByte = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RegisterPhoneNumActivity.class);
      paramArrayOfByte.putExtra("key_register_from", 3);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramArrayOfByte);
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    QLog.d("login", 1, "LoginActivity onLoginFailed ret=" + paramInt);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(0);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new LoginView.25.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt);
      }
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
      {
        List localList = BaseApplicationImpl.sApplication.getAllAccounts();
        if ((localList != null) && (localList.size() > 0))
        {
          str = this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
          int i = 0;
          for (;;)
          {
            if (i >= localList.size()) {
              break label250;
            }
            localSimpleAccount = (SimpleAccount)localList.get(i);
            if (localSimpleAccount != null) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      String str;
      SimpleAccount localSimpleAccount;
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin())));
      baig.a(BaseApplicationImpl.sApplication, this.a.jdField_a_of_type_JavaLangString, true);
      label250:
      if ((paramString2 == null) || (paramString2.equals("")))
      {
        bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628946, 0).a();
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NotificationActivity.class);
        localIntent.putExtra("type", 8);
        if (paramInt == 40) {
          localIntent.putExtra("msg", paramString2);
        }
        for (;;)
        {
          localIntent.putExtra("loginalias", paramString1);
          localIntent.putExtra("loginret", paramInt);
          localIntent.putExtra("errorUrl", paramString3);
          localIntent.putExtra("expiredSig", paramArrayOfByte);
          this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
          return;
          localIntent.putExtra("msg", paramString2 + " " + paramString3);
        }
      }
      if (paramInt == 2008)
      {
        babr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, ajjy.a(2131640576), ajjy.a(2131640571), "OK", null, new ahff(this), null).show();
        bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131627489, 0).a();
        return;
      }
      babr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, ajjy.a(2131640564), paramString2, new ahfg(this), null).show();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    QLog.d("login", 1, "LoginActivity onLoginSuccess");
    if (LoginView.f(this.a))
    {
      awqx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
      awqx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 1, 0, "", "", "", "");
    }
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("login", 1, "LoginActivity onLoginTimeout");
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(0);
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
      {
        paramString = BaseApplicationImpl.sApplication.getAllAccounts();
        if ((paramString != null) && (paramString.size() > 0))
        {
          str = this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
          int i = 0;
          for (;;)
          {
            if (i >= paramString.size()) {
              break label160;
            }
            localSimpleAccount = (SimpleAccount)paramString.get(i);
            if (localSimpleAccount != null) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      String str;
      SimpleAccount localSimpleAccount;
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      } while (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin())));
      baig.a(BaseApplicationImpl.sApplication, this.a.jdField_a_of_type_JavaLangString, true);
      label160:
      bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628946, 0).a();
    }
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahfe
 * JD-Core Version:    0.7.0.1
 */