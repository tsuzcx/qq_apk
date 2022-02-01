import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aivk
  implements View.OnClickListener
{
  public aivk(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void onClick(View paramView)
  {
    bcef.b(this.a.a, "dc00898", "", "", "0X800A16A", "0X800A16A", ChatHistoryBaseTenDocFragment.a(this.a), 0, "", "", "s_qq_history_tab", "");
    bcvs.a(this.a.getActivity(), "s_qq_history_tab", 1121);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivk
 * JD-Core Version:    0.7.0.1
 */