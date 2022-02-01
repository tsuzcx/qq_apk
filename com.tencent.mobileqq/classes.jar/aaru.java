import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaru
  implements View.OnClickListener
{
  aaru(aart paramaart) {}
  
  public void onClick(View paramView)
  {
    this.a.b.setClickable(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaru
 * JD-Core Version:    0.7.0.1
 */