import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class acdz
  extends akhc
{
  public acdz(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, ayaw paramayaw)
  {
    if ((paramBoolean) && (paramayaw != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      paramayaw = paramayaw.c();
      if ((paramayaw != null) && (!paramayaw.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    paramayaw = (ayao)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, paramayaw, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (paramayaw != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramayaw.b + " subAccount=" + paramayaw.c + " errType=" + paramayaw.jdField_a_of_type_Int + " errMsg=" + paramayaw.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramayaw == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramayaw.c)))) {}
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
          this.a.c(this.a.getString(2131719914));
          return;
        }
        this.a.b(this.a.getString(2131719910));
        return;
      }
    } while (!paramBoolean);
    paramayaw = (ayao)this.a.app.getManager(62);
    Pair localPair = paramayaw.a(this.a.jdField_a_of_type_JavaLangString, 1);
    paramayaw.a(this.a.app, this.a, localPair, new acea(this, paramayaw, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdz
 * JD-Core Version:    0.7.0.1
 */