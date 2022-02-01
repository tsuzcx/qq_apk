import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aimm
  implements View.OnClickListener
{
  aimm(aimd paramaimd) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.M) {
      aimd.c(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimm
 * JD-Core Version:    0.7.0.1
 */