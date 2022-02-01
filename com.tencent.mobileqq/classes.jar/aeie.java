import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeie
  extends amwl
{
  public aeie(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambcqu != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + parambcqu.jdField_a_of_type_Int + "  errorMsg=" + parambcqu.jdField_a_of_type_JavaLangString + " mainAccount=" + parambcqu.jdField_b_of_type_JavaLangString + "  subAccount=" + parambcqu.c + " isNeedStartGetMsg=" + parambcqu.jdField_b_of_type_Boolean);
      }
    }
    if ((parambcqu == null) || (paramString == null) || (paramString.length() < 5)) {}
    bcqk localbcqk;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localbcqk = (bcqk)this.a.app.getManager(62);
        if (parambcqu.jdField_a_of_type_Int != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localbcqk, paramString);
      return;
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)));
    localbcqk.a(this.a.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeie
 * JD-Core Version:    0.7.0.1
 */