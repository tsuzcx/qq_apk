import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class adzx
  extends alwx
{
  public adzx(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambade != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + parambade.jdField_a_of_type_Int + "  errorMsg=" + parambade.jdField_a_of_type_JavaLangString + " mainAccount=" + parambade.jdField_b_of_type_JavaLangString + "  subAccount=" + parambade.c + " isNeedStartGetMsg=" + parambade.jdField_b_of_type_Boolean);
      }
    }
    if ((parambade == null) || (paramString == null) || (paramString.length() < 5)) {}
    bacu localbacu;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localbacu = (bacu)this.a.app.getManager(62);
        if (parambade.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localbacu, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localbacu.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzx
 * JD-Core Version:    0.7.0.1
 */