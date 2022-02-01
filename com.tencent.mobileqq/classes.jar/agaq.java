import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agaq
  implements View.OnClickListener
{
  agaq(agab paramagab) {}
  
  public void onClick(View paramView)
  {
    if (!azbj.a().a(this.a.mActivity.app, this.a.mActivity, this.a.sessionInfo, paramView)) {
      bhmz.a(this.a.mActivity, "aio");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agaq
 * JD-Core Version:    0.7.0.1
 */