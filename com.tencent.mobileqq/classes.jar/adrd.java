import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qphone.base.util.QLog;

public class adrd
  extends anbq
{
  public adrd(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambcqu != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + parambcqu.b + " subAccount=" + parambcqu.c + " errType=" + parambcqu.jdField_a_of_type_Int + " errMsg=" + parambcqu.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131718657, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      bcqj.b(this.a.app);
      bcqj.a(this.a.app);
      bcqj.c(this.a.app);
      bcqj.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((parambcqu != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambcqu.jdField_a_of_type_JavaLangString + "...errorType = " + parambcqu.jdField_a_of_type_Int);
      }
      return;
      if (parambcqu != null) {
        switch (parambcqu.jdField_a_of_type_Int)
        {
        default: 
          this.a.a(2131718648, 0);
          break;
        case 1002: 
          bcqk.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131718649, 0);
          break;
        case 1004: 
          String str = parambcqu.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131718650);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrd
 * JD-Core Version:    0.7.0.1
 */