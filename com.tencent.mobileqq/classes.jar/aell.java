import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aell
  implements View.OnClickListener
{
  public aell(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://zb.vip.qq.com/v2/pages/nudgeMall?_wv=2");
    this.a.startActivity(localIntent);
    bdla.b(null, "dc00898", "", "", "0X800B3A5", "0X800B3A5", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aell
 * JD-Core Version:    0.7.0.1
 */