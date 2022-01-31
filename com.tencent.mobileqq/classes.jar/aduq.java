import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aduq
  extends MqqHandler
{
  public aduq(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.finish();
      return;
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        RegisterPhoneNumActivity.a(this.a).a(paramMessage);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterPhoneNumActivity", 2, "captcha sig is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduq
 * JD-Core Version:    0.7.0.1
 */