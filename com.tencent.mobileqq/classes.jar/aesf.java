import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aesf
  implements View.OnClickListener
{
  public aesf(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, FontSettingActivity.class);
    this.a.startActivity(localIntent);
    bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "0X8004FA2", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesf
 * JD-Core Version:    0.7.0.1
 */