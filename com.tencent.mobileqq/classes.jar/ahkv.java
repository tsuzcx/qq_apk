import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ahkv
  implements View.OnClickListener
{
  ahkv(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ahkd.a(this.a), TroopAssisSettingActivity.class);
    ahkd.a(this.a).startActivityForResult(paramView, 9001);
    ahkd.a(this.a).sendEmptyMessageDelayed(1, 1000L);
    axqy.b(ahkd.a(this.a).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
    axqy.a(ahkd.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 17, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkv
 * JD-Core Version:    0.7.0.1
 */