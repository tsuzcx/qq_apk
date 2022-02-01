import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aepc
  implements View.OnClickListener
{
  public aepc(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onClick(View paramView)
  {
    ForwardTroopListFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepc
 * JD-Core Version:    0.7.0.1
 */