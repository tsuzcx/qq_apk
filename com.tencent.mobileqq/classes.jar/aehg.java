import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aehg
  implements View.OnClickListener
{
  public aehg(ChatTextSizeSettingActivity paramChatTextSizeSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131378745: 
    default: 
      this.a.a = 0;
    }
    for (;;)
    {
      this.a.a(this.a.a);
      bdll.b(this.a.app, "CliOper", "", "", "Trends_tab", "Font_size", 0, 0, Integer.toString(this.a.a), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a = 1;
      continue;
      this.a.a = 2;
      continue;
      this.a.a = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehg
 * JD-Core Version:    0.7.0.1
 */