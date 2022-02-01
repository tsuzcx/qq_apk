import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afck
  implements View.OnClickListener
{
  public afck(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    bhxv.a(this.a, "settings");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afck
 * JD-Core Version:    0.7.0.1
 */