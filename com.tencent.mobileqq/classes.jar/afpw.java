import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.qphone.base.util.QLog;

public class afpw
  extends aoib
{
  public afpw(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + parambdxd.b + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
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
        this.a.c(this.a.getString(2131718409));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        bdws.b(this.a.app);
        bdws.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((parambdxd == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambdxd.jdField_a_of_type_JavaLangString + "...errorType = " + parambdxd.jdField_a_of_type_Int);
        return;
        if (parambdxd == null) {
          break;
        }
        switch (parambdxd.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131718400));
          break;
        case 1002: 
          bdwt.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131718401));
          break;
        case 1004: 
          String str2 = parambdxd.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131718402);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          bdws.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpw
 * JD-Core Version:    0.7.0.1
 */