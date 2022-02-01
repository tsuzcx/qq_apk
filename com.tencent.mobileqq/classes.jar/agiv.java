import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agiv
  implements View.OnClickListener
{
  agiv(agiu paramagiu) {}
  
  public void onClick(View paramView)
  {
    agiu.a(this.a, true, this.a.a.getCurrentAccountUin());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agiv
 * JD-Core Version:    0.7.0.1
 */