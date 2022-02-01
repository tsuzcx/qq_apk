import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aktp
  implements View.OnClickListener
{
  aktp(akto paramakto) {}
  
  public void onClick(View paramView)
  {
    akto.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktp
 * JD-Core Version:    0.7.0.1
 */