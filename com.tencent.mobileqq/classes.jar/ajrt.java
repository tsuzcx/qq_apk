import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajrt
  implements View.OnClickListener
{
  public ajrt(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ChatHistoryTroopFileFragment.a(this.a) != null) {
        ChatHistoryTroopFileFragment.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrt
 * JD-Core Version:    0.7.0.1
 */