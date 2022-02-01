import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afev
  implements View.OnClickListener
{
  public afev(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity.b(this.a);
    new bdlf(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_sort").a(new String[] { this.a.b }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afev
 * JD-Core Version:    0.7.0.1
 */