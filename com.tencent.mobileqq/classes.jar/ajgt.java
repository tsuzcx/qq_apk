import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ajgt
  implements View.OnClickListener
{
  ajgt(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ajgb.a(this.a), TroopAssisSettingActivity.class);
    ajgb.a(this.a).startActivityForResult(paramView, 9001);
    ajgb.a(this.a).sendEmptyMessageDelayed(1, 1000L);
    azqs.b(ajgb.a(this.a).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
    azqs.a(ajgb.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 17, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgt
 * JD-Core Version:    0.7.0.1
 */