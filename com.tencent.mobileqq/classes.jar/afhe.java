import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afhe
  implements View.OnClickListener
{
  public afhe(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.u();
    bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "sdk_locate", "click_send", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhe
 * JD-Core Version:    0.7.0.1
 */