import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class aezm
  extends anyz
{
  public aezm(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambdxt != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + parambdxt.jdField_a_of_type_Int + "  errorMsg=" + parambdxt.jdField_a_of_type_JavaLangString + " mainAccount=" + parambdxt.jdField_b_of_type_JavaLangString + "  subAccount=" + parambdxt.c + " isNeedStartGetMsg=" + parambdxt.jdField_b_of_type_Boolean);
      }
    }
    if ((parambdxt == null) || (paramString == null) || (paramString.length() < 5)) {}
    bdxj localbdxj;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localbdxj = (bdxj)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
        if (parambdxt.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localbdxj, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localbdxj.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezm
 * JD-Core Version:    0.7.0.1
 */