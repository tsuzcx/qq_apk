import android.net.Uri;
import android.provider.Settings.System;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afom
  implements View.OnClickListener
{
  public afom(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(2);
    SettingCloneUtil.writeValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.a);
    if (this.a.a().booleanValue())
    {
      Uri localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
      this.a.b();
      this.a.a(localUri);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afom
 * JD-Core Version:    0.7.0.1
 */