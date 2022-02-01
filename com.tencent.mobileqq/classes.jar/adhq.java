import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adhq
  implements View.OnClickListener
{
  public adhq(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      apyp.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).appName, null, apyp.c, 0, 0);
    }
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhq
 * JD-Core Version:    0.7.0.1
 */