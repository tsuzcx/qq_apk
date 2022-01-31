import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class adzt
  extends amdg
{
  public adzt(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, bade parambade)
  {
    if ((paramBoolean) && (parambade != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      parambade = parambade.c();
      if ((parambade != null) && (!parambade.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    parambade = (bacu)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, parambade, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (parambade != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + parambade.b + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambade == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(parambade.c)))) {}
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
          this.a.c(this.a.getString(2131720472));
          return;
        }
        this.a.b(this.a.getString(2131720468));
        return;
      }
    } while (!paramBoolean);
    parambade = (bacu)this.a.app.getManager(62);
    Pair localPair = parambade.a(this.a.jdField_a_of_type_JavaLangString, 1);
    parambade.a(this.a.app, this.a, localPair, new adzu(this, parambade, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzt
 * JD-Core Version:    0.7.0.1
 */