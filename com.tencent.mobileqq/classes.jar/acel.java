import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.7.1;
import com.tencent.qphone.base.util.QLog;

public class acel
  extends akhc
{
  public acel(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (paramayaw != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramayaw.b + " subAccount=" + paramayaw.c + " errType=" + paramayaw.jdField_a_of_type_Int + " errMsg=" + paramayaw.jdField_a_of_type_JavaLangString);
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
        this.a.c(this.a.getString(2131719846));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        ayan.b(this.a.app);
        ayan.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((paramayaw == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramayaw.jdField_a_of_type_JavaLangString + "...errorType = " + paramayaw.jdField_a_of_type_Int);
        return;
        if (paramayaw == null) {
          break;
        }
        switch (paramayaw.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131719835));
          break;
        case 1002: 
          ayao.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131719836));
          break;
        case 1004: 
          String str2 = paramayaw.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131719837);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.7.1(this));
          SubLoginActivity.a(this.a, null);
          ayan.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acel
 * JD-Core Version:    0.7.0.1
 */