import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.qphone.base.util.QLog;

public class afgs
  extends anvp
{
  public afgs(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, bdei parambdei)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (parambdei != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + parambdei.b + " subAccount=" + parambdei.c + " errType=" + parambdei.jdField_a_of_type_Int + " errMsg=" + parambdei.jdField_a_of_type_JavaLangString);
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
        this.a.c(this.a.getString(2131718273));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        bddx.b(this.a.app);
        bddx.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((parambdei == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambdei.jdField_a_of_type_JavaLangString + "...errorType = " + parambdei.jdField_a_of_type_Int);
        return;
        if (parambdei == null) {
          break;
        }
        switch (parambdei.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131718264));
          break;
        case 1002: 
          bddy.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131718265));
          break;
        case 1004: 
          String str2 = parambdei.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131718266);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          bddx.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgs
 * JD-Core Version:    0.7.0.1
 */