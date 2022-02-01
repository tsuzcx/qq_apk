import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alua
  implements View.OnClickListener
{
  alua(altz paramaltz) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    altz.a(this.a, (ajjb)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alua
 * JD-Core Version:    0.7.0.1
 */