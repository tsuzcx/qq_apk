import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aldt
  implements View.OnClickListener
{
  aldt(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    aldh.a(this.a).app.getQQProxyForQlink().a("0X800474F", 1);
    blyb.a(aldh.a(this.a), 4, null);
    bdla.a(aldh.a(this.a).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 3, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldt
 * JD-Core Version:    0.7.0.1
 */