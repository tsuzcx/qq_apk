import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akjf
  implements View.OnClickListener
{
  akjf(akjc paramakjc) {}
  
  public void onClick(View paramView)
  {
    this.a.a = null;
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjf
 * JD-Core Version:    0.7.0.1
 */