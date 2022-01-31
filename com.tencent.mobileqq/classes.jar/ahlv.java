import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ahlv
  implements View.OnClickListener
{
  ahlv(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ahkd.a(this.a), NotifyPushSettingActivity.class);
    ahkd.a(this.a).startActivity(paramView);
    axqy.b(ahkd.a(this.a).app, "CliOper", "", "", "0X8009EBB", "0X8009EBB", 0, 1, "", "", "", "");
    axqy.a(ahkd.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlv
 * JD-Core Version:    0.7.0.1
 */