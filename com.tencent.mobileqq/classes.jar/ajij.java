import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajij
  implements View.OnClickListener
{
  public ajij(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    ajic.a(NewFriendVerifyBlockedListFragment.a(this.a).app).c(NewFriendVerifyBlockedListFragment.a(this.a).app.getCurrentAccountUin());
    bdll.b(null, "dc00898", "", "", "0X800A3A9", "0X800A3A9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajij
 * JD-Core Version:    0.7.0.1
 */