import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qphone.base.util.QLog;

public class aeig
  extends aoef
{
  public aeig(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambdxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + parambdxt.b + " subAccount=" + parambdxt.c + " errType=" + parambdxt.jdField_a_of_type_Int + " errMsg=" + parambdxt.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131719046, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      bdxi.b(this.a.app);
      bdxi.a(this.a.app);
      bdxi.c(this.a.app);
      bdxi.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((parambdxt != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambdxt.jdField_a_of_type_JavaLangString + "...errorType = " + parambdxt.jdField_a_of_type_Int);
      }
      return;
      if (parambdxt != null) {
        switch (parambdxt.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131719037, 0);
          break;
        case 1002: 
          bdxj.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131719038, 0);
          break;
        case 1004: 
          String str = parambdxt.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131719039);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeig
 * JD-Core Version:    0.7.0.1
 */