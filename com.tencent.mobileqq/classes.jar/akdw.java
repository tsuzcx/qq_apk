import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akdw
  implements View.OnClickListener
{
  akdw(akdt paramakdt) {}
  
  public void onClick(View paramView)
  {
    this.a.a = null;
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdw
 * JD-Core Version:    0.7.0.1
 */