import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahac
  implements View.OnClickListener
{
  public ahac(LightVideoItemBuilder paramLightVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    this.a.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahac
 * JD-Core Version:    0.7.0.1
 */