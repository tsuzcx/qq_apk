import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aflm
  implements View.OnClickListener
{
  public aflm(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.g();
    new bcsy(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_more").a(new String[] { this.a.b }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflm
 * JD-Core Version:    0.7.0.1
 */