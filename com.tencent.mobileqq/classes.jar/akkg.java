import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.addfriendverifi.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.app.addfriendverifi.ui.NewFriendVerifyBlockedListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class akkg
  extends akkd
{
  public akkg(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BlockedListFragment", 2, "onGetAddFriendBlockedList, success=" + paramBoolean);
    }
    if ((!paramBoolean) || (NewFriendVerifyBlockedListFragment.a(this.a) == null) || (NewFriendVerifyBlockedListFragment.a(this.a).isFinishing()) || (NewFriendVerifyBlockedListFragment.a(this.a) == null) || (NewFriendVerifyBlockedListFragment.a(this.a) == null)) {
      return;
    }
    this.a.a.removeMessages(1);
    this.a.a.sendEmptyMessage(1);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.a.removeMessages(1);
      this.a.a.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkg
 * JD-Core Version:    0.7.0.1
 */