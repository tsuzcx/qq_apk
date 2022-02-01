import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class alkj
  implements View.OnClickListener
{
  alkj(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      aljw.a(this.a).startActivity(new Intent("android.settings.SETTINGS"));
    }
    for (;;)
    {
      bdll.a(aljw.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aljw.a(this.a).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkj
 * JD-Core Version:    0.7.0.1
 */