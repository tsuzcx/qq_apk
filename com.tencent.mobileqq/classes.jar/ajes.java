import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajes
  implements View.OnClickListener
{
  public ajes(SearchContactsActivity paramSearchContactsActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajes
 * JD-Core Version:    0.7.0.1
 */