import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class abyz
  implements View.OnClickListener
{
  public abyz(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity.b(this.a);
    new awrb(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_sort").a(new String[] { this.a.b }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abyz
 * JD-Core Version:    0.7.0.1
 */