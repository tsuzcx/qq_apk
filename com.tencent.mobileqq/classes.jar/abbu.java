import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abbu
  implements View.OnClickListener
{
  abbu(abbt paramabbt) {}
  
  public void onClick(View paramView)
  {
    this.a.b.setClickable(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abbu
 * JD-Core Version:    0.7.0.1
 */