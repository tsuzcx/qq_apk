import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class ahll
  implements View.OnClickListener
{
  ahll(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ahkd.a(this.a), GuideBindPhoneActivity.class);
    paramView.putExtra("fromKeyForContactBind", 4);
    ahkd.a(this.a).startActivity(paramView);
    ahkd.a(this.a).getSharedPreferences("contact_bind_info" + ahkd.a(this.a).app.getAccount(), 0).edit().putBoolean("key_show_contact_banner", false).commit();
    this.a.a(15, 0);
    ahkd.a(this.a).removeMessages(11);
    axqy.a(ahkd.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 13, 0, "", "", "", "");
    axqy.b(ahkd.a(this.a).app, "CliOper", "", "", "0X80053D9", "0X80053D9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahll
 * JD-Core Version:    0.7.0.1
 */