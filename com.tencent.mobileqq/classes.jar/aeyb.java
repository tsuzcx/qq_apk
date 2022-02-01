import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class aeyb
  extends aoib
{
  public aeyb(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + parambdxd.b + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131718409, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      bdws.b(this.a.app);
      bdws.a(this.a.app);
      bdws.c(this.a.app);
      bdws.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((parambdxd != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambdxd.jdField_a_of_type_JavaLangString + "...errorType = " + parambdxd.jdField_a_of_type_Int);
      }
      return;
      if (parambdxd != null) {
        switch (parambdxd.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131718400, 0);
          break;
        case 1002: 
          bdwt.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131718401, 0);
          break;
        case 1004: 
          String str = parambdxd.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131718402);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyb
 * JD-Core Version:    0.7.0.1
 */