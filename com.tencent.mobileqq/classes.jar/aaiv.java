import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaiv
  implements View.OnClickListener
{
  aaiv(aaiu paramaaiu) {}
  
  public void onClick(View paramView)
  {
    aaiu.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiv
 * JD-Core Version:    0.7.0.1
 */