import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adtg
  implements View.OnClickListener
{
  public adtg(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.k();
    bcst.b(this.a.app, "CliOper", "", "", "0X800568E", "0X800568E", this.a.k, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtg
 * JD-Core Version:    0.7.0.1
 */