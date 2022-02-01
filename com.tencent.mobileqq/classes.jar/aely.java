import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aely
  implements View.OnClickListener
{
  public aely(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    bhjf.a(this.a.app, this.a, "setting");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aely
 * JD-Core Version:    0.7.0.1
 */