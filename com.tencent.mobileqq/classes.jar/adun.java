import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adun
  implements View.OnClickListener
{
  public adun(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      aqca.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, aqca.c, 0, 0);
    }
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adun
 * JD-Core Version:    0.7.0.1
 */