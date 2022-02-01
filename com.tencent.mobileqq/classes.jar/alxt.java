import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alxt
  implements View.OnClickListener
{
  public alxt(PhoneContactTabView paramPhoneContactTabView) {}
  
  public void onClick(View paramView)
  {
    PhoneContactTabView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxt
 * JD-Core Version:    0.7.0.1
 */