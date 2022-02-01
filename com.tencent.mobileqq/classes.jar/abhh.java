import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abhh
  implements View.OnClickListener
{
  abhh(abhf paramabhf) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abhh
 * JD-Core Version:    0.7.0.1
 */