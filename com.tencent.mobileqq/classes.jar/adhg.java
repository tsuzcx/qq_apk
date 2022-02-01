import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adhg
  implements View.OnClickListener
{
  public adhg(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.a.app, "CliOper", "", "", "0X800AA46", "0X800AA46", 0, 0, "", "", "", "");
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhg
 * JD-Core Version:    0.7.0.1
 */