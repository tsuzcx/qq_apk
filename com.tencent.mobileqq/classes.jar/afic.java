import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMe.31;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afic
  implements View.OnClickListener
{
  public afic(QQSettingMe.31 param31) {}
  
  public void onClick(View paramView)
  {
    bhyu.a();
    bhyu.a("0X800B232", bhyu.a(), bhyu.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afic
 * JD-Core Version:    0.7.0.1
 */