import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.armap.ShopScanActivity;

class aaxd
  implements Runnable
{
  aaxd(aaxc paramaaxc) {}
  
  public void run()
  {
    if (!ShopScanActivity.a(this.a.a))
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
      this.a.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.a.a.f.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxd
 * JD-Core Version:    0.7.0.1
 */