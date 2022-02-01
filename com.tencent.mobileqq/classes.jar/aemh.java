import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aemh
  implements View.OnClickListener
{
  public aemh(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    bhmz.a(this.a, "settings");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemh
 * JD-Core Version:    0.7.0.1
 */