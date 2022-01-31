import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.qphone.base.util.QLog;

public class advs
  extends alyr
{
  public advs(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (paramazyv != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramazyv.b + " subAccount=" + paramazyv.c + " errType=" + paramazyv.jdField_a_of_type_Int + " errMsg=" + paramazyv.jdField_a_of_type_JavaLangString);
      }
    }
    if (!this.a.a) {}
    label428:
    for (;;)
    {
      return;
      this.a.a = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount: start");
      }
      this.a.e();
      if (paramBoolean)
      {
        this.a.c(this.a.getString(2131720388));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        azyk.b(this.a.app);
        azyk.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((paramazyv == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramazyv.jdField_a_of_type_JavaLangString + "...errorType = " + paramazyv.jdField_a_of_type_Int);
        return;
        if (paramazyv == null) {
          break;
        }
        switch (paramazyv.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131720377));
          break;
        case 1002: 
          azyl.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131720378));
          break;
        case 1004: 
          String str2 = paramazyv.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131720379);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          azyk.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advs
 * JD-Core Version:    0.7.0.1
 */