import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.qphone.base.util.QLog;

public class aeah
  extends amdg
{
  public aeah(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (parambade != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + parambade.b + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
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
        this.a.c(this.a.getString(2131720400));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        bact.b(this.a.app);
        bact.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((parambade == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + parambade.jdField_a_of_type_JavaLangString + "...errorType = " + parambade.jdField_a_of_type_Int);
        return;
        if (parambade == null) {
          break;
        }
        switch (parambade.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131720389));
          break;
        case 1002: 
          bacu.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131720390));
          break;
        case 1004: 
          String str2 = parambade.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131720391);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          bact.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeah
 * JD-Core Version:    0.7.0.1
 */