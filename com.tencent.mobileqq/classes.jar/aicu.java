import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aicu
  implements View.OnClickListener
{
  aicu(aicl paramaicl) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.M) {
      aicl.c(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicu
 * JD-Core Version:    0.7.0.1
 */