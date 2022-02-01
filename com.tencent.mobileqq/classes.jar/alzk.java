import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alzk
  implements View.OnClickListener
{
  public alzk(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = anni.a(2131712608);
    localObject = bglp.a(SessionClearFragment.a(this.a), 230, anni.a(2131712610), (String)localObject, 2131693977, 2131719210, new alzl(this), new alzm(this));
    SessionClearFragment.a(this.a, (Dialog)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzk
 * JD-Core Version:    0.7.0.1
 */