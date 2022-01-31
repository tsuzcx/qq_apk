import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.armap.ShopScanActivity;

class abeh
  implements Runnable
{
  abeh(abed paramabed, float paramFloat) {}
  
  public void run()
  {
    if (!ShopScanActivity.b(this.jdField_a_of_type_Abed.a)) {
      return;
    }
    int i = (int)(this.jdField_a_of_type_Float * 100.0F);
    if (this.jdField_a_of_type_Abed.a.b.getVisibility() != 0)
    {
      this.jdField_a_of_type_Abed.a.b.setVisibility(0);
      if (this.jdField_a_of_type_Abed.a.e != null) {
        this.jdField_a_of_type_Abed.a.e.setVisibility(8);
      }
    }
    this.jdField_a_of_type_Abed.a.a.setProgress(i);
    this.jdField_a_of_type_Abed.a.g.setText(this.jdField_a_of_type_Abed.a.getResources().getString(2131438498));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abeh
 * JD-Core Version:    0.7.0.1
 */