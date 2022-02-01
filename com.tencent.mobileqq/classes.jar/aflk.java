import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aflk
  implements View.OnClickListener
{
  aflk(afli paramafli) {}
  
  public void onClick(View paramView)
  {
    this.a.a.b(paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflk
 * JD-Core Version:    0.7.0.1
 */