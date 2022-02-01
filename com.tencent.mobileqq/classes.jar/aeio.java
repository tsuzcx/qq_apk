import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.qphone.base.util.QLog;

public class aeio
  extends anbq
{
  public aeio(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (parambcqu != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + parambcqu.b + " subAccount=" + parambcqu.c + " errType=" + parambcqu.jdField_a_of_type_Int + " errMsg=" + parambcqu.jdField_a_of_type_JavaLangString);
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
        this.a.c(this.a.getString(2131718657));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        bcqj.b(this.a.app);
        bcqj.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((parambcqu == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambcqu.jdField_a_of_type_JavaLangString + "...errorType = " + parambcqu.jdField_a_of_type_Int);
        return;
        if (parambcqu == null) {
          break;
        }
        switch (parambcqu.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131718648));
          break;
        case 1002: 
          bcqk.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131718649));
          break;
        case 1004: 
          String str2 = parambcqu.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131718650);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          bcqj.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeio
 * JD-Core Version:    0.7.0.1
 */