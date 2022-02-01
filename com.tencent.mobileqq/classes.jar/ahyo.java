import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahyo
  implements View.OnClickListener
{
  ahyo(ahyk paramahyk) {}
  
  public void onClick(View paramView)
  {
    this.a.y(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyo
 * JD-Core Version:    0.7.0.1
 */