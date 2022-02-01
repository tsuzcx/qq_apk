import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akmt
  implements View.OnClickListener
{
  akmt(akms paramakms) {}
  
  public void onClick(View paramView)
  {
    akms.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmt
 * JD-Core Version:    0.7.0.1
 */