import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class acdv
  extends akhb
{
  public acdv(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, ayay paramayay)
  {
    if ((paramBoolean) && (paramayay != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      paramayay = paramayay.c();
      if ((paramayay != null) && (!paramayay.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    paramayay = (ayaq)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, paramayay, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (paramayay != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramayay.b + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramayay == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramayay.c)))) {}
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
          this.a.c(this.a.getString(2131719925));
          return;
        }
        this.a.b(this.a.getString(2131719921));
        return;
      }
    } while (!paramBoolean);
    paramayay = (ayaq)this.a.app.getManager(62);
    Pair localPair = paramayay.a(this.a.jdField_a_of_type_JavaLangString, 1);
    paramayay.a(this.a.app, this.a, localPair, new acdw(this, paramayay, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdv
 * JD-Core Version:    0.7.0.1
 */