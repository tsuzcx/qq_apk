import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.armap.ShopScanActivity;

public class abeb
  implements Runnable
{
  public abeb(ShopScanActivity paramShopScanActivity) {}
  
  public void run()
  {
    ShopScanActivity.b(this.a);
    this.a.a.setVisibility(4);
    this.a.d.setVisibility(8);
    ShopScanActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abeb
 * JD-Core Version:    0.7.0.1
 */