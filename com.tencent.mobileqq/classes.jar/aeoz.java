import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aeoz
  implements View.OnClickListener
{
  aeoz(aeox paramaeox) {}
  
  public void onClick(View paramView)
  {
    aeox.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoz
 * JD-Core Version:    0.7.0.1
 */