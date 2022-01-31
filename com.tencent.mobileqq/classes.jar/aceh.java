import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.7.1;
import com.tencent.qphone.base.util.QLog;

public class aceh
  extends akhb
{
  public aceh(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (paramayay != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramayay.b + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
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
        this.a.c(this.a.getString(2131719857));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        ayap.b(this.a.app);
        ayap.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((paramayay == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramayay.jdField_a_of_type_JavaLangString + "...errorType = " + paramayay.jdField_a_of_type_Int);
        return;
        if (paramayay == null) {
          break;
        }
        switch (paramayay.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131719846));
          break;
        case 1002: 
          ayaq.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131719847));
          break;
        case 1004: 
          String str2 = paramayay.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131719848);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.7.1(this));
          SubLoginActivity.a(this.a, null);
          ayap.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aceh
 * JD-Core Version:    0.7.0.1
 */