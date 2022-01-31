import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;

public class alwx
  implements Runnable
{
  public alwx(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void run()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppInit....");
    QQProxyForQlink.a(this.a);
    QQProxyForQlink.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alwx
 * JD-Core Version:    0.7.0.1
 */