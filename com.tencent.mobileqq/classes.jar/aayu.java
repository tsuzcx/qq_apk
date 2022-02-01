import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aayu
  implements View.OnClickListener
{
  aayu(aayr paramaayr) {}
  
  public void onClick(View paramView)
  {
    aayr.b(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aayu
 * JD-Core Version:    0.7.0.1
 */