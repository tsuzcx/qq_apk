import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahzg
  implements View.OnClickListener
{
  ahzg(ahzc paramahzc) {}
  
  public void onClick(View paramView)
  {
    this.a.d(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzg
 * JD-Core Version:    0.7.0.1
 */