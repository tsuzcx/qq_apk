import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class aeia
  extends anbq
{
  public aeia(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, bcqu parambcqu)
  {
    if ((paramBoolean) && (parambcqu != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      parambcqu = parambcqu.c();
      if ((parambcqu != null) && (!parambcqu.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    parambcqu = (bcqk)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, parambcqu, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (parambcqu != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + parambcqu.b + " subAccount=" + parambcqu.c + " errType=" + parambcqu.jdField_a_of_type_Int + " errMsg=" + parambcqu.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambcqu == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(parambcqu.c)))) {}
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
          this.a.c(this.a.getString(2131718702));
          return;
        }
        this.a.b(this.a.getString(2131718701));
        return;
      }
    } while (!paramBoolean);
    parambcqu = (bcqk)this.a.app.getManager(62);
    Pair localPair = parambcqu.a(this.a.jdField_a_of_type_JavaLangString, 1);
    parambcqu.a(this.a.app, this.a, localPair, new aeib(this, parambcqu, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeia
 * JD-Core Version:    0.7.0.1
 */