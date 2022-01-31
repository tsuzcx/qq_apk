import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class afzd
  implements View.OnClickListener
{
  public afzd(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.g = true;
    this.a.d.setVisibility(8);
    this.a.d = ((TextView)ChatHistoryTroopMemberFragment.a(this.a, 2131368431));
    this.a.d.setVisibility(0);
    this.a.d.setText(ajya.a(2131701661));
    this.a.d.setOnClickListener(new afze(this));
    ChatHistoryTroopMemberFragment.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afzd
 * JD-Core Version:    0.7.0.1
 */