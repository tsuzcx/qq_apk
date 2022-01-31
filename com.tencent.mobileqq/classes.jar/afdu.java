import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class afdu
  implements DialogInterface.OnClickListener
{
  public afdu(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.d(true);
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_like", "clk_entry", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdu
 * JD-Core Version:    0.7.0.1
 */