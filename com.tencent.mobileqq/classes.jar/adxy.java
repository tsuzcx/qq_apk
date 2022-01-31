import MyCarrier.Carrier;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.mybusiness.MyBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class adxy
  extends MyBusinessObserver
{
  public adxy(MyBusinessManager paramMyBusinessManager) {}
  
  public void a(boolean paramBoolean, Carrier paramCarrier, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessManager", 4, "onCarrierQuery refreshTimeSpan = " + paramInt);
    }
    this.a.a = paramInt;
    if (this.a.a > 86400) {
      this.a.a = 86400;
    }
    if (!paramBoolean)
    {
      this.a.b = false;
      return;
    }
    ThreadManager.getFileThreadHandler().post(new adxz(this, paramCarrier));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adxy
 * JD-Core Version:    0.7.0.1
 */