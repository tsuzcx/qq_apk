import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class abmt
  extends akhc
{
  public abmt(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramayaw != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + paramayaw.b + " subAccount=" + paramayaw.c + " errType=" + paramayaw.jdField_a_of_type_Int + " errMsg=" + paramayaw.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131719846, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      ayan.b(this.a.app);
      ayan.a(this.a.app);
      ayan.c(this.a.app);
      ayan.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((paramayaw != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramayaw.jdField_a_of_type_JavaLangString + "...errorType = " + paramayaw.jdField_a_of_type_Int);
      }
      return;
      if (paramayaw != null) {
        switch (paramayaw.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131719835, 0);
          break;
        case 1002: 
          ayao.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131719836, 0);
          break;
        case 1004: 
          String str = paramayaw.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131719837);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abmt
 * JD-Core Version:    0.7.0.1
 */