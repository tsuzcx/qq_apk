import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afok
  implements View.OnClickListener
{
  public afok(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(0);
    SettingCloneUtil.writeValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", 2131230720);
    if (this.a.a().booleanValue())
    {
      this.a.b();
      this.a.a(Uri.parse("android.resource://" + this.a.getApplicationContext().getPackageName() + "/" + 2131230720));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afok
 * JD-Core Version:    0.7.0.1
 */