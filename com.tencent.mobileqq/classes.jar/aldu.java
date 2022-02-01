import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class aldu
  implements View.OnClickListener
{
  aldu(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      aldh.a(this.a).startActivity(new Intent("android.settings.SETTINGS"));
    }
    for (;;)
    {
      bdla.a(aldh.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aldh.a(this.a).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldu
 * JD-Core Version:    0.7.0.1
 */