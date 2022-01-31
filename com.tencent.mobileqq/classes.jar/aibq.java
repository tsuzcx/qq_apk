import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class aibq
  implements View.OnClickListener
{
  public aibq(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.g = true;
    this.a.d.setVisibility(8);
    this.a.d = ((TextView)ChatHistoryTroopMemberFragment.a(this.a, 2131368626));
    this.a.d.setVisibility(0);
    this.a.d.setText(alud.a(2131702046));
    this.a.d.setOnClickListener(new aibr(this));
    ChatHistoryTroopMemberFragment.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibq
 * JD-Core Version:    0.7.0.1
 */