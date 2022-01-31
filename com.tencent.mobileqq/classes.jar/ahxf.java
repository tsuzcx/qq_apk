import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class ahxf
  implements View.OnClickListener
{
  public ahxf(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    ChatHistoryTroopMemberFragment.b(this.a);
    new azmo(this.a.getActivity().app).a("dc00899").b("Grp_online").c("mber_list").d("clk_sort").a(new String[] { this.a.c }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxf
 * JD-Core Version:    0.7.0.1
 */