import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.qphone.base.util.QLog;

public class agnu
  implements MessageQueue.IdleHandler
{
  public agnu(ScanTorchActivity paramScanTorchActivity) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "queueIdle called ");
    }
    this.a.a.c();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnu
 * JD-Core Version:    0.7.0.1
 */