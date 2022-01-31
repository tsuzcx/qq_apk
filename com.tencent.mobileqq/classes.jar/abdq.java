import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.mobileqq.widget.QQToast;

public class abdq
  implements Runnable
{
  public abdq(ShopScanActivity paramShopScanActivity) {}
  
  public void run()
  {
    QQToast.a(this.a.getApplicationContext(), "识别失败，请稍后再试。", 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdq
 * JD-Core Version:    0.7.0.1
 */