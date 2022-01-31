import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.armap.ShopScanActivity;

class aaxg
  implements Runnable
{
  aaxg(aaxc paramaaxc, float paramFloat) {}
  
  public void run()
  {
    if (!ShopScanActivity.b(this.jdField_a_of_type_Aaxc.a)) {
      return;
    }
    int i = (int)(this.jdField_a_of_type_Float * 100.0F);
    if (this.jdField_a_of_type_Aaxc.a.b.getVisibility() != 0)
    {
      this.jdField_a_of_type_Aaxc.a.b.setVisibility(0);
      if (this.jdField_a_of_type_Aaxc.a.e != null) {
        this.jdField_a_of_type_Aaxc.a.e.setVisibility(8);
      }
    }
    this.jdField_a_of_type_Aaxc.a.a.setProgress(i);
    this.jdField_a_of_type_Aaxc.a.g.setText(this.jdField_a_of_type_Aaxc.a.getResources().getString(2131438480));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxg
 * JD-Core Version:    0.7.0.1
 */