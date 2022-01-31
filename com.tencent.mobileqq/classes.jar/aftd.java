import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.widget.QQToast;

class aftd
  implements Runnable
{
  aftd(aftc paramaftc) {}
  
  public void run()
  {
    QQToast.a(this.a.a.getApplicationContext(), "定位超时，请检查你的定位服务是否开启。", 1).b(this.a.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftd
 * JD-Core Version:    0.7.0.1
 */