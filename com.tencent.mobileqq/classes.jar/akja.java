import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class akja
  implements View.OnClickListener
{
  akja(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(akho.a(this.a), GuideBindPhoneActivity.class);
    localIntent.putExtra("fromKeyForContactBind", 4);
    akho.a(this.a).startActivity(localIntent);
    akho.a(this.a).getSharedPreferences("contact_bind_info" + akho.a(this.a).app.getAccount(), 0).edit().putBoolean("key_show_contact_banner", false).commit();
    this.a.a(18, 0);
    akho.a(this.a).removeMessages(11);
    bcef.a(akho.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 13, 0, "", "", "", "");
    bcef.b(akho.a(this.a).app, "CliOper", "", "", "0X80053D9", "0X80053D9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akja
 * JD-Core Version:    0.7.0.1
 */