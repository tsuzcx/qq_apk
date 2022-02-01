import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiei
  implements View.OnClickListener
{
  aiei(aido paramaido) {}
  
  public void onClick(View paramView)
  {
    paramView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiei
 * JD-Core Version:    0.7.0.1
 */