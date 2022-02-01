import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alaz
  implements View.OnClickListener
{
  alaz(alay paramalay) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    alay.a(this.a, (aiph)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alaz
 * JD-Core Version:    0.7.0.1
 */