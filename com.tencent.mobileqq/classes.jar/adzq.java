import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adzq
  implements View.OnClickListener
{
  public adzq(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      aaec.a("see_streetview");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.isWifiEnabled(this.a)) {
        this.a.p();
      } else {
        bfur.a(this.a, 230).setTitle(this.a.getString(2131689992)).setMessage(2131694258).setPositiveButton(2131690953, new adzs(this)).setNegativeButton(2131690620, new adzr(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzq
 * JD-Core Version:    0.7.0.1
 */