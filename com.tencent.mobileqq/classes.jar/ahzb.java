import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahzb
  implements View.OnClickListener
{
  ahzb(ahyl paramahyl) {}
  
  public void onClick(View paramView)
  {
    paramView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzb
 * JD-Core Version:    0.7.0.1
 */