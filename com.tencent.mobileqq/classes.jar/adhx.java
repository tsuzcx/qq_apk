import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adhx
  implements View.OnClickListener
{
  adhx(adhv paramadhv) {}
  
  public void onClick(View paramView)
  {
    adhv.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhx
 * JD-Core Version:    0.7.0.1
 */