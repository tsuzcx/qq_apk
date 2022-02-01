import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aleb
  implements View.OnClickListener
{
  aleb(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aldh.a(this.a), TroopAssisSettingActivity.class);
    aldh.a(this.a).startActivityForResult(localIntent, 9001);
    aldh.a(this.a).sendEmptyMessageDelayed(1, 1000L);
    bdla.b(aldh.a(this.a).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
    bdla.a(aldh.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 17, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aleb
 * JD-Core Version:    0.7.0.1
 */