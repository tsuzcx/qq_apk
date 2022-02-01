import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akhs
  implements View.OnClickListener
{
  akhs(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    if (akho.a(this.a).app != null)
    {
      ((amov)akho.a(this.a).app.getBusinessHandler(2)).a(0, "", "not_disturb_from_conversation");
      bcef.b(akho.a(this.a).app, "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akhs
 * JD-Core Version:    0.7.0.1
 */