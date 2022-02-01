import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajyw
  implements View.OnClickListener
{
  ajyw(ajyr paramajyr) {}
  
  public void onClick(View paramView)
  {
    ajyr.a(this.a, paramView);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyw
 * JD-Core Version:    0.7.0.1
 */