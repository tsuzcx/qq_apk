import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.armap.ShopScanActivity;

public class abec
  implements Runnable
{
  public abec(ShopScanActivity paramShopScanActivity) {}
  
  public void run()
  {
    ShopScanActivity.b(this.a);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.d.setVisibility(0);
    this.a.f.setVisibility(4);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abec
 * JD-Core Version:    0.7.0.1
 */