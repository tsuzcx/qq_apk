import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class advi
  extends alsi
{
  public advi(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramazyv != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramazyv.jdField_a_of_type_Int + "  errorMsg=" + paramazyv.jdField_a_of_type_JavaLangString + " mainAccount=" + paramazyv.jdField_b_of_type_JavaLangString + "  subAccount=" + paramazyv.c + " isNeedStartGetMsg=" + paramazyv.jdField_b_of_type_Boolean);
      }
    }
    if ((paramazyv == null) || (paramString == null) || (paramString.length() < 5)) {}
    azyl localazyl;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localazyl = (azyl)this.a.app.getManager(62);
        if (paramazyv.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localazyl, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localazyl.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advi
 * JD-Core Version:    0.7.0.1
 */