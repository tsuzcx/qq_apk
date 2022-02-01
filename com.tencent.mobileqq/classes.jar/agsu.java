import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agsu
  implements View.OnClickListener
{
  agsu(agss paramagss) {}
  
  public void onClick(View paramView)
  {
    this.a.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsu
 * JD-Core Version:    0.7.0.1
 */