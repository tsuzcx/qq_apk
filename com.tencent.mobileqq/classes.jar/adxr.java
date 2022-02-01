import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adxr
  implements View.OnClickListener
{
  public adxr(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (FontSettingManager.setCustomDensity(this.a, FontSettingActivity.a(this.a), true)) {
      FontSettingManager.killProcess();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxr
 * JD-Core Version:    0.7.0.1
 */