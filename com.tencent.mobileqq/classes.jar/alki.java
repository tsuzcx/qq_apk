import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alki
  implements View.OnClickListener
{
  alki(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    aljw.a(this.a).app.a().a("0X800474F", 1);
    bmim.a(aljw.a(this.a), 4, null);
    bdll.a(aljw.a(this.a).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 3, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alki
 * JD-Core Version:    0.7.0.1
 */