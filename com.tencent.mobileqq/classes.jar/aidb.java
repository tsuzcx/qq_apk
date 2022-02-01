import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aidb
  implements View.OnClickListener
{
  aidb(aicv paramaicv) {}
  
  public void onClick(View paramView)
  {
    aicv.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidb
 * JD-Core Version:    0.7.0.1
 */