import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afjl
  implements View.OnClickListener
{
  afjl(afiw paramafiw) {}
  
  public void onClick(View paramView)
  {
    if (!axuy.a().a(this.a.mActivity.app, this.a.mActivity, this.a.sessionInfo, paramView)) {
      bgeg.a(this.a.mActivity, "aio");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjl
 * JD-Core Version:    0.7.0.1
 */