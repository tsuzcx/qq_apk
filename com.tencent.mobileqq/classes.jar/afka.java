import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afka
  implements View.OnClickListener
{
  public afka(RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afka
 * JD-Core Version:    0.7.0.1
 */