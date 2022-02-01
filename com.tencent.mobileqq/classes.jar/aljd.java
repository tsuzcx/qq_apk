import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aljd
  implements View.OnClickListener
{
  aljd(aljc paramaljc) {}
  
  public void onClick(View paramView)
  {
    aljc.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aljd
 * JD-Core Version:    0.7.0.1
 */