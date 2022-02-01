import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class algc
  implements View.OnClickListener
{
  public algc(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    SessionClearFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algc
 * JD-Core Version:    0.7.0.1
 */