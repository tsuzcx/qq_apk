import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adnw
  implements View.OnClickListener
{
  public adnw(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.a(12, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnw
 * JD-Core Version:    0.7.0.1
 */