import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afgi
  extends anqd
{
  public afgi(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, bdei parambdei)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambdei != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + parambdei.jdField_a_of_type_Int + "  errorMsg=" + parambdei.jdField_a_of_type_JavaLangString + " mainAccount=" + parambdei.jdField_b_of_type_JavaLangString + "  subAccount=" + parambdei.c + " isNeedStartGetMsg=" + parambdei.jdField_b_of_type_Boolean);
      }
    }
    if ((parambdei == null) || (paramString == null) || (paramString.length() < 5)) {}
    bddy localbddy;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localbddy = (bddy)this.a.app.getManager(62);
        if (parambdei.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localbddy, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localbddy.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgi
 * JD-Core Version:    0.7.0.1
 */