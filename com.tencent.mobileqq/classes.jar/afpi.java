import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class afpi
  extends aoib
{
  public afpi(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, bdxd parambdxd)
  {
    if ((paramBoolean) && (parambdxd != null) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() >= 5))
    {
      parambdxd = parambdxd.c();
      if ((parambdxd != null) && (!parambdxd.contains(this.a.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    parambdxd = (bdwt)this.a.app.getManager(62);
    SubAccountUgActivity.a(this.a, parambdxd, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_a_of_type_JavaLangString);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + parambdxd.b + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambdxd == null) || (this.a.jdField_a_of_type_JavaLangString == null) || ((this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(parambdxd.c)))) {}
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
          this.a.c(this.a.getString(2131718454));
          return;
        }
        this.a.b(this.a.getString(2131718453));
        return;
      }
    } while (!paramBoolean);
    parambdxd = (bdwt)this.a.app.getManager(62);
    Pair localPair = parambdxd.a(this.a.jdField_a_of_type_JavaLangString, 1);
    parambdxd.a(this.a.app, this.a, localPair, new afpj(this, parambdxd, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpi
 * JD-Core Version:    0.7.0.1
 */