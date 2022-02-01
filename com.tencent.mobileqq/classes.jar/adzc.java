import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adzc
  implements View.OnClickListener
{
  adzc(adzb paramadzb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    adzb.a(this.a, (ajkw)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzc
 * JD-Core Version:    0.7.0.1
 */