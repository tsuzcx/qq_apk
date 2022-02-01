import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abjw
  implements View.OnClickListener
{
  abjw(abju paramabju) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abjw
 * JD-Core Version:    0.7.0.1
 */