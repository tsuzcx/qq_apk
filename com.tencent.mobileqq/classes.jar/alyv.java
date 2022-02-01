import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alyv
  implements View.OnClickListener
{
  alyv(alyu paramalyu) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    alyu.a(this.a, (ajkw)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyv
 * JD-Core Version:    0.7.0.1
 */