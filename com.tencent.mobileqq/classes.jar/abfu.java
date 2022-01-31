import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;

public class abfu
  implements View.OnClickListener
{
  public abfu(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, TroopAssisSettingActivity.class);
    this.a.startActivity(paramView);
    awqx.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_msginfor_grp", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfu
 * JD-Core Version:    0.7.0.1
 */