import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adiy
  implements View.OnClickListener
{
  public adiy(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    new bhjz(this.a).a(this.a.getString(2131695058)).b(this.a.getString(2131695057)).c(this.a.getString(2131692814)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adiy
 * JD-Core Version:    0.7.0.1
 */