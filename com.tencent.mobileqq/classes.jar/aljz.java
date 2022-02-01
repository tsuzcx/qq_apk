import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aljz
  implements View.OnClickListener
{
  aljz(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aljw.a(this.a), NotifyPushSettingActivity.class);
    aljw.a(this.a).startActivity(localIntent);
    bdll.b(aljw.a(this.a).app, "CliOper", "", "", "0X8009EBB", "0X8009EBB", 0, 1, "", "", "", "");
    bdll.a(aljw.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 2, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljz
 * JD-Core Version:    0.7.0.1
 */