import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acdz
  extends akat
{
  public acdz(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramayay != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramayay.jdField_a_of_type_Int + "  errorMsg=" + paramayay.jdField_a_of_type_JavaLangString + " mainAccount=" + paramayay.jdField_b_of_type_JavaLangString + "  subAccount=" + paramayay.c + " isNeedStartGetMsg=" + paramayay.jdField_b_of_type_Boolean);
      }
    }
    if ((paramayay == null) || (paramString == null) || (paramString.length() < 5)) {}
    ayaq localayaq;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localayaq = (ayaq)this.a.app.getManager(62);
        if (paramayay.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localayaq, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localayaq.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdz
 * JD-Core Version:    0.7.0.1
 */