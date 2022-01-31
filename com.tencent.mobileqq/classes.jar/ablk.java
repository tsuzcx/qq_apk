import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.armap.ShopScanActivity;

public class ablk
  implements Runnable
{
  public ablk(ShopScanActivity paramShopScanActivity) {}
  
  public void run()
  {
    ShopScanActivity.c(this.a);
    ShopScanActivity.d(this.a);
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablk
 * JD-Core Version:    0.7.0.1
 */