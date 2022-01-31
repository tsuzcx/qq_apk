import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.7.1;
import com.tencent.qphone.base.util.QLog;

public class abtz
  extends ajss
{
  public abtz(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (paramaxau != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramaxau.b + " subAccount=" + paramaxau.c + " errType=" + paramaxau.jdField_a_of_type_Int + " errMsg=" + paramaxau.jdField_a_of_type_JavaLangString);
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
      this.a.c();
      if (paramBoolean)
      {
        this.a.c(this.a.getString(2131653962));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        axal.b(this.a.app);
        axal.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((paramaxau == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramaxau.jdField_a_of_type_JavaLangString + "...errorType = " + paramaxau.jdField_a_of_type_Int);
        return;
        if (paramaxau == null) {
          break;
        }
        switch (paramaxau.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131653951));
          break;
        case 1002: 
          axam.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131653952));
          break;
        case 1004: 
          String str2 = paramaxau.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131653953);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.7.1(this));
          SubLoginActivity.a(this.a, null);
          axal.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abtz
 * JD-Core Version:    0.7.0.1
 */