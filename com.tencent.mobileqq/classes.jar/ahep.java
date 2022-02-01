import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahep
  implements View.OnClickListener
{
  ahep(ahek paramahek) {}
  
  public void onClick(View paramView)
  {
    this.a.c(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahep
 * JD-Core Version:    0.7.0.1
 */