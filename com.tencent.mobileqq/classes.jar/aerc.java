import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aerc
  implements View.OnClickListener
{
  public aerc(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((bkzi)bkzz.a(this.a, null));
      this.a.a.b(2131697840);
      this.a.a.b(2131692126);
      this.a.a.c(2131690697);
      this.a.a.a(new aerd(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerc
 * JD-Core Version:    0.7.0.1
 */