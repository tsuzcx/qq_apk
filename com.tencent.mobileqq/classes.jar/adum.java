import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adum
  implements View.OnClickListener
{
  public adum(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      aqca.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, aqca.b, 0, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "click to close");
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adum
 * JD-Core Version:    0.7.0.1
 */