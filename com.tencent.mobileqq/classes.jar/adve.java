import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class adve
  extends alyr
{
  public adve(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, azyv paramazyv)
  {
    if ((paramBoolean) && (paramazyv != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      paramazyv = paramazyv.c();
      if ((paramazyv != null) && (!paramazyv.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    paramazyv = (azyl)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, paramazyv, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (paramazyv != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramazyv.b + " subAccount=" + paramazyv.c + " errType=" + paramazyv.jdField_a_of_type_Int + " errMsg=" + paramazyv.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramazyv == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramazyv.c)))) {}
    do
    {
      return;
      this.a.e();
      if (this.a.b)
      {
        this.a.b = false;
        if (paramBoolean)
        {
          this.a.a();
          this.a.c(this.a.getString(2131720460));
          return;
        }
        this.a.b(this.a.getString(2131720456));
        return;
      }
    } while (!paramBoolean);
    paramazyv = (azyl)this.a.app.getManager(62);
    Pair localPair = paramazyv.a(this.a.jdField_a_of_type_JavaLangString, 1);
    paramazyv.a(this.a.app, this.a, localPair, new advf(this, paramazyv, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adve
 * JD-Core Version:    0.7.0.1
 */