import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adhw
  implements View.OnClickListener
{
  adhw(adhv paramadhv) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    adhv.a(this.a, (aiph)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhw
 * JD-Core Version:    0.7.0.1
 */