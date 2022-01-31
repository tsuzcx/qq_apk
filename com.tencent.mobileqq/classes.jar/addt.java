import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class addt
  extends alyr
{
  public addt(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramazyv != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + paramazyv.b + " subAccount=" + paramazyv.c + " errType=" + paramazyv.jdField_a_of_type_Int + " errMsg=" + paramazyv.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131720388, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      azyk.b(this.a.app);
      azyk.a(this.a.app);
      azyk.c(this.a.app);
      azyk.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((paramazyv != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramazyv.jdField_a_of_type_JavaLangString + "...errorType = " + paramazyv.jdField_a_of_type_Int);
      }
      return;
      if (paramazyv != null) {
        switch (paramazyv.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131720377, 0);
          break;
        case 1002: 
          azyl.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131720378, 0);
          break;
        case 1004: 
          String str = paramazyv.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131720379);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addt
 * JD-Core Version:    0.7.0.1
 */