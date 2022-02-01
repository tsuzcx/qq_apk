import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aavt
  implements View.OnClickListener
{
  aavt(aavp paramaavp) {}
  
  public void onClick(View paramView)
  {
    this.a.l();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aavt
 * JD-Core Version:    0.7.0.1
 */