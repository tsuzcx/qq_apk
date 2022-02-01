import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alyw
  implements View.OnClickListener
{
  alyw(alyu paramalyu) {}
  
  public void onClick(View paramView)
  {
    alyu.a(this.a).onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyw
 * JD-Core Version:    0.7.0.1
 */