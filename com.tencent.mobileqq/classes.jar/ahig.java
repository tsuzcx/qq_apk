import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahig
  implements View.OnClickListener
{
  ahig(ahia paramahia) {}
  
  public void onClick(View paramView)
  {
    ahia.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahig
 * JD-Core Version:    0.7.0.1
 */