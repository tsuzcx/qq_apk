import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aeoy
  implements View.OnClickListener
{
  aeoy(aeox paramaeox) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    aeox.a(this.a, (ajuk)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoy
 * JD-Core Version:    0.7.0.1
 */