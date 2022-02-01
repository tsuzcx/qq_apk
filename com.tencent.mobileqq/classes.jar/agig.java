import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agig
  implements View.OnClickListener
{
  public agig(ColorView paramColorView) {}
  
  public void onClick(View paramView)
  {
    if (ColorView.a(this.a) != null) {
      ColorView.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agig
 * JD-Core Version:    0.7.0.1
 */