import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akkf
  implements View.OnClickListener
{
  akkf(akka paramakka) {}
  
  public void onClick(View paramView)
  {
    akka.a(this.a, paramView);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkf
 * JD-Core Version:    0.7.0.1
 */