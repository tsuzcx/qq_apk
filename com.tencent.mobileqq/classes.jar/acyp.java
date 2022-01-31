import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

public class acyp
  implements View.OnClickListener
{
  public acyp(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FontSettingActivity.class);
    this.a.startActivity(paramView);
    azmj.b(this.a.app, "CliOper", "", "", "Setting_tab", "0X8004FA2", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyp
 * JD-Core Version:    0.7.0.1
 */