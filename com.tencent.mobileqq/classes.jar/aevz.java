import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.statistics.ReportController;

public class aevz
  implements View.OnClickListener
{
  public aevz(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    this.a.a.startActivity(paramView);
    ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevz
 * JD-Core Version:    0.7.0.1
 */