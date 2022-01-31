import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class abtr
  extends ajmm
{
  public abtr(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramaxau != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramaxau.jdField_a_of_type_Int + "  errorMsg=" + paramaxau.jdField_a_of_type_JavaLangString + " mainAccount=" + paramaxau.jdField_b_of_type_JavaLangString + "  subAccount=" + paramaxau.c + " isNeedStartGetMsg=" + paramaxau.jdField_b_of_type_Boolean);
      }
    }
    if ((paramaxau == null) || (paramString == null) || (paramString.length() < 5)) {}
    axam localaxam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localaxam = (axam)this.a.app.getManager(62);
        if (paramaxau.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localaxam, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localaxam.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abtr
 * JD-Core Version:    0.7.0.1
 */