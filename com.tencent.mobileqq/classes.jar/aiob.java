import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiob
  implements View.OnClickListener
{
  aiob(ainh paramainh) {}
  
  public void onClick(View paramView)
  {
    paramView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiob
 * JD-Core Version:    0.7.0.1
 */