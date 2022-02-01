import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agte
  implements View.OnClickListener
{
  public agte(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.b(this.a, paramView);
    AIOLongShotHelper.a("0X8009DE7");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agte
 * JD-Core Version:    0.7.0.1
 */