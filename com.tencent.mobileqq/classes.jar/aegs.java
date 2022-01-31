import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

public class aegs
  extends awdn
{
  public aegs(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 2, "VerifyPhoneNumActivity onReBindMblWTLogin isSuccess = " + paramBoolean1 + "; resultOk = " + paramBoolean2);
    }
    this.a.a();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        VerifyPhoneNumActivity.a(this.a, true);
        VerifyPhoneNumActivity.c(this.a);
        return;
      }
      VerifyPhoneNumActivity.c(this.a);
      return;
    }
    VerifyPhoneNumActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegs
 * JD-Core Version:    0.7.0.1
 */