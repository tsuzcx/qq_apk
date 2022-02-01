import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahtr
  implements View.OnClickListener
{
  ahtr(ahtk paramahtk) {}
  
  public void onClick(View paramView)
  {
    this.a.a(((TextView)paramView).getText().toString());
    this.a.w();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtr
 * JD-Core Version:    0.7.0.1
 */