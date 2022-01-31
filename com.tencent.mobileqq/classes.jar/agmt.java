import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agmt
  implements Runnable
{
  public agmt(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.b(this.a, true, ScanTorchActivity.d(this.a));
    ScanTorchActivity.w(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agmt
 * JD-Core Version:    0.7.0.1
 */