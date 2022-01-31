import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class ahxb
  implements View.OnClickListener
{
  public ahxb(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.g = true;
    this.a.d.setVisibility(8);
    this.a.d = ((TextView)ChatHistoryTroopMemberFragment.a(this.a, 2131368615));
    this.a.d.setVisibility(0);
    this.a.d.setText(alpo.a(2131702034));
    this.a.d.setOnClickListener(new ahxc(this));
    ChatHistoryTroopMemberFragment.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxb
 * JD-Core Version:    0.7.0.1
 */