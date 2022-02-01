import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afpm
  extends aocj
{
  public afpm(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambdxd != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + parambdxd.jdField_a_of_type_Int + "  errorMsg=" + parambdxd.jdField_a_of_type_JavaLangString + " mainAccount=" + parambdxd.jdField_b_of_type_JavaLangString + "  subAccount=" + parambdxd.c + " isNeedStartGetMsg=" + parambdxd.jdField_b_of_type_Boolean);
      }
    }
    if ((parambdxd == null) || (paramString == null) || (paramString.length() < 5)) {}
    bdwt localbdwt;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localbdwt = (bdwt)this.a.app.getManager(62);
        if (parambdxd.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localbdwt, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localbdwt.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpm
 * JD-Core Version:    0.7.0.1
 */