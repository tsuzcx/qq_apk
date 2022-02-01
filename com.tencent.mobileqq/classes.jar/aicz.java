import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aicz
  implements View.OnClickListener
{
  aicz(aict paramaict) {}
  
  public void onClick(View paramView)
  {
    aict.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicz
 * JD-Core Version:    0.7.0.1
 */