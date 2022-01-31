import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class afta
  implements Runnable
{
  public afta(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.c(this.a, true);
    ScanTorchActivity.k(this.a);
    ScanTorchActivity.d(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afta
 * JD-Core Version:    0.7.0.1
 */