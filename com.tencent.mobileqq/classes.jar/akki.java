import com.tencent.mobileqq.app.addfriendverifi.ui.NewFriendVerifyBlockedListFragment;
import com.tencent.widget.AbsListView;

public class akki
  implements bfob
{
  public akki(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a) != null)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        NewFriendVerifyBlockedListFragment.a(this.a).a();
      }
    }
    else {
      return;
    }
    NewFriendVerifyBlockedListFragment.a(this.a).b();
    NewFriendVerifyBlockedListFragment.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akki
 * JD-Core Version:    0.7.0.1
 */