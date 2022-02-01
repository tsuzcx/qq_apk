import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiyn
  implements View.OnClickListener
{
  public aiyn(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.g = true;
    this.a.d.setVisibility(8);
    this.a.d = ((TextView)ChatHistoryTroopMemberFragment.a(this.a, 2131369070));
    this.a.d.setVisibility(0);
    this.a.d.setText(amtj.a(2131700808));
    this.a.d.setOnClickListener(new aiyo(this));
    ChatHistoryTroopMemberFragment.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyn
 * JD-Core Version:    0.7.0.1
 */