import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adei
  implements View.OnClickListener
{
  public adei(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    bhqa.a(this.a, null);
    bhqa.a("0X800B5C7", AccountManageActivity.a(this.a));
    ((bbbq)this.a.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100190.100193.100192");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adei
 * JD-Core Version:    0.7.0.1
 */