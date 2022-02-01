import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alkr
  implements View.OnClickListener
{
  alkr(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aljw.a(this.a), TroopAssisSettingActivity.class);
    aljw.a(this.a).startActivityForResult(localIntent, 9001);
    aljw.a(this.a).sendEmptyMessageDelayed(1, 1000L);
    bdll.b(aljw.a(this.a).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
    bdll.a(aljw.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 17, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkr
 * JD-Core Version:    0.7.0.1
 */