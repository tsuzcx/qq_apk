import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afzo
  implements View.OnClickListener
{
  public afzo(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afzo
 * JD-Core Version:    0.7.0.1
 */