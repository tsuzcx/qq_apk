import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbh
  implements View.OnClickListener
{
  public afbh(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getActivity(), SoundAndVibrateActivity.class);
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbh
 * JD-Core Version:    0.7.0.1
 */