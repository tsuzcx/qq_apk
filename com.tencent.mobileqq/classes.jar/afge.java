import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class afge
  extends anvp
{
  public afge(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, bdei parambdei)
  {
    if ((paramBoolean) && (parambdei != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      parambdei = parambdei.c();
      if ((parambdei != null) && (!parambdei.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    parambdei = (bddy)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, parambdei, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, bdei parambdei)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (parambdei != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + parambdei.b + " subAccount=" + parambdei.c + " errType=" + parambdei.jdField_a_of_type_Int + " errMsg=" + parambdei.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambdei == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(parambdei.c)))) {}
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
          this.a.c(this.a.getString(2131718318));
          return;
        }
        this.a.b(this.a.getString(2131718317));
        return;
      }
    } while (!paramBoolean);
    parambdei = (bddy)this.a.app.getManager(62);
    Pair localPair = parambdei.a(this.a.jdField_a_of_type_JavaLangString, 1);
    parambdei.a(this.a.app, this.a, localPair, new afgf(this, parambdei, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afge
 * JD-Core Version:    0.7.0.1
 */