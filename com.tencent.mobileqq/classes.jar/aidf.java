import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aidf
  implements View.OnClickListener
{
  aidf(aicy paramaicy) {}
  
  public void onClick(View paramView)
  {
    this.a.a(((TextView)paramView).getText().toString());
    this.a.w();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidf
 * JD-Core Version:    0.7.0.1
 */