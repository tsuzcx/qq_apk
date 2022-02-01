import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afax
  implements View.OnClickListener
{
  public afax(RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afax
 * JD-Core Version:    0.7.0.1
 */