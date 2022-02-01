import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aavs
  implements View.OnClickListener
{
  aavs(aavp paramaavp) {}
  
  public void onClick(View paramView)
  {
    this.a.k();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aavs
 * JD-Core Version:    0.7.0.1
 */