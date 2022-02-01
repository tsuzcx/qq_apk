import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abcw
  implements View.OnClickListener
{
  abcw(abcu paramabcu) {}
  
  public void onClick(View paramView)
  {
    abcu.a(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcw
 * JD-Core Version:    0.7.0.1
 */