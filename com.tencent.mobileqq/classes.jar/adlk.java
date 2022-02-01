import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adlk
  implements View.OnClickListener
{
  public adlk(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public void onClick(View paramView)
  {
    AgeSelectionActivity.a(this.a);
    this.a.finish();
    if ("VAL_FROM_STATUS_MSG_TAB".equals(AgeSelectionActivity.a(this.a))) {
      aypy.a("0X800AF47");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlk
 * JD-Core Version:    0.7.0.1
 */