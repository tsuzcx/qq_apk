import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akyt
  implements View.OnClickListener
{
  akyt(akyh paramakyh) {}
  
  public void onClick(View paramView)
  {
    akyh.a(this.a).app.a().a("0X800474F", 1);
    blhj.a(akyh.a(this.a), 4, null);
    bcst.a(akyh.a(this.a).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 3, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyt
 * JD-Core Version:    0.7.0.1
 */