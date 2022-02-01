import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adxa
  implements View.OnClickListener
{
  public adxa(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    AuthDevActivity.h(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxa
 * JD-Core Version:    0.7.0.1
 */