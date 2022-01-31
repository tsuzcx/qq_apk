import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agim
  implements Runnable
{
  public agim(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.b(this.a, false, ScanTorchActivity.d(this.a) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agim
 * JD-Core Version:    0.7.0.1
 */