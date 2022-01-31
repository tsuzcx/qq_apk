import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class agaq
  implements View.OnClickListener
{
  public agaq(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().setResult(0, this.a.getActivity().getIntent());
    this.a.getActivity().finish();
    if (this.a.d == 11) {
      axqy.b(this.a.getActivity().app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agaq
 * JD-Core Version:    0.7.0.1
 */