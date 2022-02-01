import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahmj
  implements View.OnClickListener
{
  ahmj(ahmi paramahmi) {}
  
  public void onClick(View paramView)
  {
    ahmi.a(this.a, true, this.a.a.getCurrentAccountUin());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmj
 * JD-Core Version:    0.7.0.1
 */