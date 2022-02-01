import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acsm
  implements View.OnClickListener
{
  public acsm(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    new bgbi(this.a).a(this.a.getString(2131694844)).b(this.a.getString(2131694843)).c(this.a.getString(2131692712)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsm
 * JD-Core Version:    0.7.0.1
 */