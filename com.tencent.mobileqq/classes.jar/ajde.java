import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ajde
  implements View.OnClickListener
{
  ajde(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ajbm.a(this.a), NotifyPushSettingActivity.class);
    ajbm.a(this.a).startActivity(paramView);
    azmj.b(ajbm.a(this.a).app, "CliOper", "", "", "0X8009EBB", "0X8009EBB", 0, 1, "", "", "", "");
    azmj.a(ajbm.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajde
 * JD-Core Version:    0.7.0.1
 */