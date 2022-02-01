import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeya
  implements View.OnClickListener
{
  public aeya(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((bkho)bkif.a(this.a, null));
      this.a.a.b(2131697335);
      this.a.a.b(2131691986);
      this.a.a.c(2131690582);
      this.a.a.a(new aeyb(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeya
 * JD-Core Version:    0.7.0.1
 */