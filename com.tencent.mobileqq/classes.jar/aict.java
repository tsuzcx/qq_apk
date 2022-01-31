import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.QLog;

public final class aict
  implements Runnable
{
  public void run()
  {
    try
    {
      SosoInterface.a(QZoneNotifyServlet.a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "locate exception " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aict
 * JD-Core Version:    0.7.0.1
 */