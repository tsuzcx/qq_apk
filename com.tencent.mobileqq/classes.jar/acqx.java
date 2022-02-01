import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acqx
  implements View.OnClickListener
{
  public acqx(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    bcef.b(this.a.app, "CliOper", "", "", "0X800AA44", "0X800AA44", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqx
 * JD-Core Version:    0.7.0.1
 */