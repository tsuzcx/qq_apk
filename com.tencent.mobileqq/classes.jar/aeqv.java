import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeqv
  implements View.OnClickListener
{
  public aeqv(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      aato.a("see_streetview");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.isWifiEnabled(this.a)) {
        this.a.p();
      } else {
        bhdj.a(this.a, 230).setTitle(this.a.getString(2131690021)).setMessage(2131694456).setPositiveButton(2131691038, new aeqx(this)).setNegativeButton(2131690697, new aeqw(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqv
 * JD-Core Version:    0.7.0.1
 */