import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class adii
  extends amdg
{
  public adii(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambade != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + parambade.b + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131720400, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      bact.b(this.a.app);
      bact.a(this.a.app);
      bact.c(this.a.app);
      bact.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((parambade != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambade.jdField_a_of_type_JavaLangString + "...errorType = " + parambade.jdField_a_of_type_Int);
      }
      return;
      if (parambade != null) {
        switch (parambade.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131720389, 0);
          break;
        case 1002: 
          bacu.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131720390, 0);
          break;
        case 1004: 
          String str = parambade.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131720391);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adii
 * JD-Core Version:    0.7.0.1
 */