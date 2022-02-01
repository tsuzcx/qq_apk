import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aejh
  implements View.OnClickListener
{
  public aejh(GesturePWDCreateActivity paramGesturePWDCreateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejh
 * JD-Core Version:    0.7.0.1
 */