import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aldl
  implements View.OnClickListener
{
  aldl(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    if (aldh.a(this.a).app != null)
    {
      ((anri)aldh.a(this.a).app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(0, "", "not_disturb_from_conversation");
      bdla.b(aldh.a(this.a).app, "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldl
 * JD-Core Version:    0.7.0.1
 */