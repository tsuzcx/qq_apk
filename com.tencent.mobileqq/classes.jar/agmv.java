import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agmv
  implements View.OnClickListener
{
  agmv(agmu paramagmu) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmv
 * JD-Core Version:    0.7.0.1
 */