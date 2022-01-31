import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.TimerTask;

public class alxh
  extends TimerTask
{
  public alxh(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void run()
  {
    QQProxyForQlink.a(this.a);
    if (QQProxyForQlink.b(this.a) > 1)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ qlink pulgin is dead:");
      QQProxyForQlink.a(this.a, new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false));
      QQProxyForQlink.c(this.a);
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxh
 * JD-Core Version:    0.7.0.1
 */