import android.content.Intent;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView.27.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.AccountObserver;

public class alnn
  extends AccountObserver
{
  public alnn(LoginView paramLoginView) {}
  
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
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    QLog.d("login", 1, "LoginActivity onLoginFailed ret=" + paramInt1);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(0);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new LoginView.27.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt1);
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
      } while (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getUinDisplayNameBeforeLogin(localSimpleAccount.getUin())));
      bhhr.a(BaseApplicationImpl.sApplication, this.a.jdField_a_of_type_JavaLangString, true);
      label250:
      if ((paramString2 == null) || (paramString2.equals(""))) {
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694253, 0).a();
      }
      Intent localIntent;
      do
      {
        return;
        if (TextUtils.isEmpty(paramString3)) {
          break label667;
        }
        localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NotificationActivity.class);
        localIntent.putExtra("type", 8);
        if (paramInt1 != 40) {
          break;
        }
        bdla.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
        LoginView.a(this.a, new aoka(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
      } while (aojy.a().a(paramArrayOfByte2, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString(), this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString(), LoginView.a(this.a)));
      localIntent.putExtra("msg", paramString2);
      localIntent.putExtra("errorver", paramInt2);
      localIntent.putExtra("tlverror", paramArrayOfByte2);
      localIntent.putExtra("errortitle", paramString4);
      localIntent.putExtra("is_need_login_with_mask", LoginView.g(this.a));
      localIntent.putExtra("title", paramString4);
      if (aojy.a().a(paramArrayOfByte2) == 1)
      {
        localIntent.putExtra("uin", this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString());
        localIntent.putExtra("passwd", this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString());
        localIntent.putExtra("is_from_login", true);
        localIntent.putExtra("keyTipsScenesId", 1);
      }
      for (;;)
      {
        localIntent.putExtra("loginalias", paramString1);
        localIntent.putExtra("loginret", paramInt1);
        localIntent.putExtra("errorUrl", paramString3);
        localIntent.putExtra("expiredSig", paramArrayOfByte1);
        localIntent.putExtra("keyFromLoginView", true);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        return;
        localIntent.putExtra("msg", paramString2 + " " + paramString3);
      }
      label667:
      if (paramInt1 == 2008)
      {
        bhdj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, anvx.a(2131705835), anvx.a(2131705830), "OK", null, new alno(this), null).show();
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131692890, 0).a();
        return;
      }
      bhdj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, anvx.a(2131705823), paramString2, new alnp(this), null).show();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    QLog.d("login", 1, "LoginActivity onLoginSuccess");
    if (LoginView.f(this.a))
    {
      bdla.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
      bdla.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 1, 0, "", "", "", "");
    }
    awov.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      } while (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getUinDisplayNameBeforeLogin(localSimpleAccount.getUin())));
      bhhr.a(BaseApplicationImpl.sApplication, this.a.jdField_a_of_type_JavaLangString, true);
      label160:
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694253, 0).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnn
 * JD-Core Version:    0.7.0.1
 */