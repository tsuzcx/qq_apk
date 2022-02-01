import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aimt
  implements View.OnClickListener
{
  aimt(aimn paramaimn) {}
  
  public void onClick(View paramView)
  {
    aimn.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimt
 * JD-Core Version:    0.7.0.1
 */