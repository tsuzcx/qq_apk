import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aced
  extends akav
{
  public aced(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramayaw != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramayaw.jdField_a_of_type_Int + "  errorMsg=" + paramayaw.jdField_a_of_type_JavaLangString + " mainAccount=" + paramayaw.jdField_b_of_type_JavaLangString + "  subAccount=" + paramayaw.c + " isNeedStartGetMsg=" + paramayaw.jdField_b_of_type_Boolean);
      }
    }
    if ((paramayaw == null) || (paramString == null) || (paramString.length() < 5)) {}
    ayao localayao;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localayao = (ayao)this.a.app.getManager(62);
        if (paramayaw.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localayao, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localayao.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aced
 * JD-Core Version:    0.7.0.1
 */