import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akak
  implements View.OnClickListener
{
  public akak(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.a, "dc00898", "", "", "0X800A16A", "0X800A16A", ChatHistoryBaseTenDocFragment.a(this.a), 0, "", "", "s_qq_history_tab", "");
    becb.a(this.a.getActivity(), "s_qq_history_tab", 1121);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akak
 * JD-Core Version:    0.7.0.1
 */