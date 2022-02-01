import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeci
  implements View.OnClickListener
{
  public aeci(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.k();
    bdll.b(this.a.app, "CliOper", "", "", "0X800568E", "0X800568E", this.a.k, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeci
 * JD-Core Version:    0.7.0.1
 */