import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.util.QLog;

public class ahwn
  implements Runnable
{
  public ahwn(SubAccountControll paramSubAccountControll) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("launchTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
      if (this.a.a != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.a.a.isRunning()))
    {
      QLog.d("SUB_ACCOUNT", 2, localObject);
      if ((this.a.a != null) && (this.a.a.isRunning())) {
        this.a.a.f(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahwn
 * JD-Core Version:    0.7.0.1
 */