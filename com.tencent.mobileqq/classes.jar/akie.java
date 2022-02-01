import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akie
  implements View.OnClickListener
{
  akie(akid paramakid) {}
  
  public void onClick(View paramView)
  {
    akid.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akie
 * JD-Core Version:    0.7.0.1
 */