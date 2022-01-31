import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.statistics.ReportController;

public class afoa
  implements View.OnClickListener
{
  public afoa(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    if (this.a.a.app != null)
    {
      if ((NearbyProfileFragment.a(this.a).iIsGodFlag != 1) || (NearbyProfileFragment.a(this.a).gender != 0)) {
        break label82;
      }
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
    }
    label82:
    while ((NearbyProfileFragment.a(this.a).iIsGodFlag != 1) || (NearbyProfileFragment.a(this.a).gender != 1)) {
      return;
    }
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afoa
 * JD-Core Version:    0.7.0.1
 */