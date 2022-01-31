import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class abmp
  extends akhb
{
  public abmp(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramayay != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + paramayay.b + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131719857, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      ayap.b(this.a.app);
      ayap.a(this.a.app);
      ayap.c(this.a.app);
      ayap.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((paramayay != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramayay.jdField_a_of_type_JavaLangString + "...errorType = " + paramayay.jdField_a_of_type_Int);
      }
      return;
      if (paramayay != null) {
        switch (paramayay.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131719846, 0);
          break;
        case 1002: 
          ayaq.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131719847, 0);
          break;
        case 1004: 
          String str = paramayay.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131719848);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abmp
 * JD-Core Version:    0.7.0.1
 */