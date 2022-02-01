import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alba
  implements View.OnClickListener
{
  alba(alay paramalay) {}
  
  public void onClick(View paramView)
  {
    alay.a(this.a).onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alba
 * JD-Core Version:    0.7.0.1
 */