import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class aeoy
  extends anvp
{
  public aeoy(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, bdei parambdei)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambdei != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + parambdei.b + " subAccount=" + parambdei.c + " errType=" + parambdei.jdField_a_of_type_Int + " errMsg=" + parambdei.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131718273, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      bddx.b(this.a.app);
      bddx.a(this.a.app);
      bddx.c(this.a.app);
      bddx.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((parambdei != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambdei.jdField_a_of_type_JavaLangString + "...errorType = " + parambdei.jdField_a_of_type_Int);
      }
      return;
      if (parambdei != null) {
        switch (parambdei.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131718264, 0);
          break;
        case 1002: 
          bddy.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131718265, 0);
          break;
        case 1004: 
          String str = parambdei.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131718266);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoy
 * JD-Core Version:    0.7.0.1
 */