import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeyq
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    MainFragment.b(true);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (!MainFragment.a()) {
      localViewGroup.callOnClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyq
 * JD-Core Version:    0.7.0.1
 */