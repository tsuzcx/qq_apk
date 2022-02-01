import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abcx
  implements View.OnClickListener
{
  abcx(abcu paramabcu) {}
  
  public void onClick(View paramView)
  {
    abcu.b(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcx
 * JD-Core Version:    0.7.0.1
 */