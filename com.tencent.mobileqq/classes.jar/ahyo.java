import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class ahyo
  implements View.OnClickListener
{
  public ahyo(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().setResult(0, this.a.getActivity().getIntent());
    this.a.getActivity().finish();
    if (this.a.d == 11) {
      azmj.b(this.a.getActivity().app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyo
 * JD-Core Version:    0.7.0.1
 */