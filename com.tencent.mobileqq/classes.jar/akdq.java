import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akdq
  implements View.OnClickListener
{
  public akdq(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.v();
    new bdlq(this.a.getActivity().app).a("dc00899").b("Grp_online").c("mber_list").d("clk_more").a(new String[] { this.a.c }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdq
 * JD-Core Version:    0.7.0.1
 */