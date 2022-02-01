import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aflt
  implements View.OnClickListener
{
  public aflt(SearchMightKnowFragment paramSearchMightKnowFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflt
 * JD-Core Version:    0.7.0.1
 */