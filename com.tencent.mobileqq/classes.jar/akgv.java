import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akgv
  implements View.OnClickListener
{
  public akgv(BaseActivityView paramBaseActivityView) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akgv
 * JD-Core Version:    0.7.0.1
 */