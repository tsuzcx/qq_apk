import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class akyu
  implements View.OnClickListener
{
  akyu(akyh paramakyh) {}
  
  public void onClick(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      akyh.a(this.a).startActivity(new Intent("android.settings.SETTINGS"));
    }
    for (;;)
    {
      bcst.a(akyh.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      akyh.a(this.a).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyu
 * JD-Core Version:    0.7.0.1
 */