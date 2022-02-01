import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aihx
  implements View.OnClickListener
{
  aihx(aihh paramaihh) {}
  
  public void onClick(View paramView)
  {
    paramView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihx
 * JD-Core Version:    0.7.0.1
 */