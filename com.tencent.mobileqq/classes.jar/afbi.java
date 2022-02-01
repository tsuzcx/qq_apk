import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbi
  implements View.OnClickListener
{
  public afbi(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.a(this.a, TempMsgSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbi
 * JD-Core Version:    0.7.0.1
 */