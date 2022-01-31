import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.armap.ShopScanActivity;

class ablf
  implements Runnable
{
  ablf(abld paramabld) {}
  
  public void run()
  {
    if ((!ShopScanActivity.a(this.a.a)) && (this.a.a.d.getVisibility() == 0))
    {
      this.a.a.d.setVisibility(8);
      this.a.a.a.setVisibility(0);
      ShopScanActivity.b(this.a.a);
      ShopScanActivity.a(this.a.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablf
 * JD-Core Version:    0.7.0.1
 */