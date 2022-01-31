import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class acrf
  extends RecyclerView.AdapterDataObserver
{
  public acrf(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onChanged()
  {
    if (ExtendFriendSquareFragment.a(this.a).a() == 0)
    {
      ExtendFriendSquareFragment.a(this.a).removeItemDecoration(ExtendFriendSquareFragment.a(this.a));
      return;
    }
    ExtendFriendSquareFragment.a(this.a).removeItemDecoration(ExtendFriendSquareFragment.a(this.a));
    ExtendFriendSquareFragment.a(this.a).addItemDecoration(ExtendFriendSquareFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrf
 * JD-Core Version:    0.7.0.1
 */