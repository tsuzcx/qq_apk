import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akds
  implements View.OnClickListener
{
  akds(akdn paramakdn) {}
  
  public void onClick(View paramView)
  {
    akdn.a(this.a, paramView);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akds
 * JD-Core Version:    0.7.0.1
 */