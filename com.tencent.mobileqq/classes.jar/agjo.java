import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agjo
  implements Runnable
{
  public agjo(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. downloadArRes.");
    ScanTorchActivity.a(this.a);
    ScanTorchActivity.c(this.a);
    ScanTorchActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjo
 * JD-Core Version:    0.7.0.1
 */