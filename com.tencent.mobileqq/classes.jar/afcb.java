import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afcb
  implements View.OnClickListener
{
  public afcb(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    bhty.a(this.a.app, this.a, "setting");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcb
 * JD-Core Version:    0.7.0.1
 */