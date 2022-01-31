import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.qphone.base.util.QLog;

public class accr
  implements View.OnClickListener
{
  public accr(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      paramView = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
      paramView.putExtra("android.provider.extra.APP_PACKAGE", this.a.getPackageName());
      paramView.putExtra("android.provider.extra.CHANNEL_ID", "CHANNEL_ID_SHOW_BADGE");
      this.a.startActivity(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "go to channel setting");
      }
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        try
        {
          paramView = new Intent();
          paramView.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
          paramView.setData(Uri.fromParts("package", this.a.getPackageName(), null));
          this.a.startActivity(paramView);
          if (QLog.isColorLevel())
          {
            QLog.d("IphoneTitleBarActivity", 2, "go to system setting");
            return;
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          QLog.e("IphoneTitleBarActivity", 2, "go to setting fail");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     accr
 * JD-Core Version:    0.7.0.1
 */