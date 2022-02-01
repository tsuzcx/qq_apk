import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aenn
  implements View.OnClickListener
{
  public aenn(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (anxh.a(this.a, FontSettingActivity.a(this.a), true)) {
      anxh.a();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenn
 * JD-Core Version:    0.7.0.1
 */