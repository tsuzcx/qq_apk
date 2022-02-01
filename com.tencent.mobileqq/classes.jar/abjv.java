import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abjv
  implements View.OnClickListener
{
  abjv(abju paramabju) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abjv
 * JD-Core Version:    0.7.0.1
 */