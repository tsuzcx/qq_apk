import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class abtn
  extends ajss
{
  public abtn(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, axau paramaxau)
  {
    if ((paramBoolean) && (paramaxau != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      paramaxau = paramaxau.c();
      if ((paramaxau != null) && (!paramaxau.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    paramaxau = (axam)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, paramaxau, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (paramaxau != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramaxau.b + " subAccount=" + paramaxau.c + " errType=" + paramaxau.jdField_a_of_type_Int + " errMsg=" + paramaxau.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramaxau == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramaxau.c)))) {}
    do
    {
      return;
      this.a.c();
      if (this.a.b)
      {
        this.a.b = false;
        if (paramBoolean)
        {
          this.a.a();
          this.a.c(this.a.getString(2131654030));
          return;
        }
        this.a.b(this.a.getString(2131654026));
        return;
      }
    } while (!paramBoolean);
    paramaxau = (axam)this.a.app.getManager(62);
    Pair localPair = paramaxau.a(this.a.jdField_a_of_type_JavaLangString, 1);
    paramaxau.a(this.a.app, this.a, localPair, new abto(this, paramaxau, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abtn
 * JD-Core Version:    0.7.0.1
 */