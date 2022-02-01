import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adzd
  implements View.OnClickListener
{
  adzd(adzb paramadzb) {}
  
  public void onClick(View paramView)
  {
    adzb.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzd
 * JD-Core Version:    0.7.0.1
 */