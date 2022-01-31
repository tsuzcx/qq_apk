import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.binhai.BinHaiHandler;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agit
  implements Runnable
{
  public agit(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ((BinHaiHandler)this.a.b.getBusinessHandler(3)).b(ScanTorchActivity.c(this.a), ScanTorchActivity.c(this.a));
    QLog.d("ScanTorchActivity", 1, "binhai sendOpenReqTime=" + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agit
 * JD-Core Version:    0.7.0.1
 */