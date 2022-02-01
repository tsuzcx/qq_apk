import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.grayversion.ShareAppLogActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class addk
  implements View.OnClickListener
{
  public addk(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(ShareAppLogActivity.buildIntent(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addk
 * JD-Core Version:    0.7.0.1
 */