import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.PositionActivatePage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

public class agch
  implements View.OnClickListener
{
  public agch(PositionActivatePage paramPositionActivatePage) {}
  
  public void onClick(View paramView)
  {
    if ((PositionActivatePage.a(this.a) != null) && (PositionActivatePage.a(this.a).get() != null))
    {
      Intent localIntent = new Intent((Context)PositionActivatePage.a(this.a).get(), NearbyActivity.class);
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("FROM_WHERE", 1002);
      localIntent.putExtra("is_skip_nearby_guide", true);
      localIntent.setFlags(67108864);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).startActivity(localIntent);
      bdll.b(((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E07", "0X8004E07", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agch
 * JD-Core Version:    0.7.0.1
 */