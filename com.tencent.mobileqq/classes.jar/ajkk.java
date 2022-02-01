import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajkk
  implements View.OnClickListener
{
  public ajkk(NewFriendMoreSysMsgSuspiciousFragment paramNewFriendMoreSysMsgSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkk
 * JD-Core Version:    0.7.0.1
 */