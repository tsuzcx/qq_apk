import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ajce
  implements View.OnClickListener
{
  ajce(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ajbm.a(this.a), TroopAssisSettingActivity.class);
    ajbm.a(this.a).startActivityForResult(paramView, 9001);
    ajbm.a(this.a).sendEmptyMessageDelayed(1, 1000L);
    azmj.b(ajbm.a(this.a).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
    azmj.a(ajbm.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 17, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajce
 * JD-Core Version:    0.7.0.1
 */