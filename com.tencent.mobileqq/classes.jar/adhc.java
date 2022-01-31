import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;

public class adhc
  implements View.OnClickListener
{
  public adhc(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getActivity(), SoundAndVibrateActivity.class);
    this.a.startActivity(paramView);
    azmj.b(this.a.app, "CliOper", "", "", "0X800403C", "0X800403C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhc
 * JD-Core Version:    0.7.0.1
 */