import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.utils.NetworkUtil;

public class acja
  implements Runnable
{
  public acja(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void run()
  {
    if (NetworkUtil.g(ExtendFriendSquareFragment.a(this.a)))
    {
      if (ExtendFriendSquareFragment.a(this.a) != null)
      {
        ExtendFriendSquareFragment.a(this.a).setRefreshing();
        ExtendFriendSquareFragment.a(this.a).a(0, true);
      }
      return;
    }
    ExtendFriendSquareFragment.a(this.a, this.a.getString(2131437530), 1);
    ExtendFriendSquareFragment.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acja
 * JD-Core Version:    0.7.0.1
 */