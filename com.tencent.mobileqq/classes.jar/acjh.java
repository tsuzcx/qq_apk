import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class acjh
  implements View.OnClickListener
{
  public acjh(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity.b(this.a);
    new axrc(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_sort").a(new String[] { this.a.b }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acjh
 * JD-Core Version:    0.7.0.1
 */