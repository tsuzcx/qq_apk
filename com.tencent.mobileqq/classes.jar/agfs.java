import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agfs
  implements Runnable
{
  public agfs(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.c(this.a, false);
    this.a.a.a.a.b();
    ScanTorchActivity.i(this.a);
    ScanTorchActivity.j(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfs
 * JD-Core Version:    0.7.0.1
 */