import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adzu
  implements View.OnClickListener
{
  public adzu(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzu
 * JD-Core Version:    0.7.0.1
 */