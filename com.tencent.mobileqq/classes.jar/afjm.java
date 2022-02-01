import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afjm
  extends MqqHandler
{
  public afjm(RegisterActivity paramRegisterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        RegisterActivity.b(this.a, paramMessage);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "captcha sig is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjm
 * JD-Core Version:    0.7.0.1
 */