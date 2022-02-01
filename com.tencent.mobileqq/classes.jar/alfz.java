import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alfz
  implements View.OnClickListener
{
  public alfz(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = amtj.a(2131712949);
    localObject = bfur.a(SessionClearFragment.a(this.a), 230, amtj.a(2131712951), (String)localObject, 2131694094, 2131719734, new alga(this), new algb(this));
    SessionClearFragment.a(this.a, (Dialog)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfz
 * JD-Core Version:    0.7.0.1
 */