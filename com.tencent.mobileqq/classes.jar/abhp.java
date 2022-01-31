import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

public class abhp
  implements View.OnClickListener
{
  public abhp(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FontSettingActivity.class);
    this.a.startActivity(paramView);
    axqy.b(this.a.app, "CliOper", "", "", "Setting_tab", "0X8004FA2", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhp
 * JD-Core Version:    0.7.0.1
 */