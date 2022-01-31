import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.mobileqq.armap.ShopScanDragView;

public class abkl
  implements Runnable
{
  public abkl(ShopScanActivity paramShopScanActivity) {}
  
  public void run()
  {
    ShopScanActivity.c(this.a);
    ShopScanActivity.d(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abkl
 * JD-Core Version:    0.7.0.1
 */