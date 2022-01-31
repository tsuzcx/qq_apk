import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class aear
  implements View.OnClickListener
{
  public aear(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity.b(this.a);
    new azmo(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_sort").a(new String[] { this.a.b }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aear
 * JD-Core Version:    0.7.0.1
 */