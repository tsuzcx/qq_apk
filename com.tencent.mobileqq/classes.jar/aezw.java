import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.qphone.base.util.QLog;

public class aezw
  extends aoef
{
  public aezw(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (parambdxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + parambdxt.b + " subAccount=" + parambdxt.c + " errType=" + parambdxt.jdField_a_of_type_Int + " errMsg=" + parambdxt.jdField_a_of_type_JavaLangString);
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
        this.a.c(this.a.getString(2131719046));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        bdxi.b(this.a.app);
        bdxi.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((parambdxt == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambdxt.jdField_a_of_type_JavaLangString + "...errorType = " + parambdxt.jdField_a_of_type_Int);
        return;
        if (parambdxt == null) {
          break;
        }
        switch (parambdxt.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131719037));
          break;
        case 1002: 
          bdxj.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131719038));
          break;
        case 1004: 
          String str2 = parambdxt.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131719039);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          bdxi.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezw
 * JD-Core Version:    0.7.0.1
 */