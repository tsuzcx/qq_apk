import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiga
  implements View.OnClickListener
{
  aiga(aifz paramaifz) {}
  
  public void onClick(View paramView)
  {
    aifz.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiga
 * JD-Core Version:    0.7.0.1
 */