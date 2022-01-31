import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.widget.QQToast;

public class agob
  implements Runnable
{
  public agob(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    QQToast localQQToast = QQToast.a(this.a, "本机型无法支持穿越，请换其它手机穿越。", 1);
    localQQToast.a();
    localQQToast.a();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agob
 * JD-Core Version:    0.7.0.1
 */