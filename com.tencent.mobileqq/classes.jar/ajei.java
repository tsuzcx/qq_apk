import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajei
  implements View.OnClickListener
{
  public ajei(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(1);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajei
 * JD-Core Version:    0.7.0.1
 */