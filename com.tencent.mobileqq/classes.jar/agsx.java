import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agsx
  implements View.OnClickListener
{
  public agsx(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(this.a).performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsx
 * JD-Core Version:    0.7.0.1
 */