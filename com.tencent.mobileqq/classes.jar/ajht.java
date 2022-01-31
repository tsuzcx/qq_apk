import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ajht
  implements View.OnClickListener
{
  ajht(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ajgb.a(this.a), NotifyPushSettingActivity.class);
    ajgb.a(this.a).startActivity(paramView);
    azqs.b(ajgb.a(this.a).app, "CliOper", "", "", "0X8009EBB", "0X8009EBB", 0, 1, "", "", "", "");
    azqs.a(ajgb.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajht
 * JD-Core Version:    0.7.0.1
 */