import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class aezi
  extends aoef
{
  public aezi(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, bdxt parambdxt)
  {
    if ((paramBoolean) && (parambdxt != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      parambdxt = parambdxt.c();
      if ((parambdxt != null) && (!parambdxt.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    parambdxt = (bdxj)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
    SubAccountUgActivity.a(this.a, parambdxt, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (parambdxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + parambdxt.b + " subAccount=" + parambdxt.c + " errType=" + parambdxt.jdField_a_of_type_Int + " errMsg=" + parambdxt.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambdxt == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(parambdxt.c)))) {}
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
          this.a.c(this.a.getString(2131719091));
          return;
        }
        this.a.b(this.a.getString(2131719090));
        return;
      }
    } while (!paramBoolean);
    parambdxt = (bdxj)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
    Pair localPair = parambdxt.a(this.a.jdField_a_of_type_JavaLangString, 1);
    parambdxt.a(this.a.app, this.a, localPair, new aezj(this, parambdxt, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezi
 * JD-Core Version:    0.7.0.1
 */