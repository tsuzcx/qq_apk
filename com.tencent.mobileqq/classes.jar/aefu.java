import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aefu
  implements View.OnClickListener
{
  aefu(aeft paramaeft) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    aeft.a(this.a, (ajjb)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefu
 * JD-Core Version:    0.7.0.1
 */