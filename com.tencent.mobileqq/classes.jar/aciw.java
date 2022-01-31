import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.WeakReferenceHandler;

public class aciw
  extends RecyclerView.OnScrollListener
{
  public aciw(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((!ExtendFriendSquareFragment.a(this.a)) && (!ExtendFriendSquareFragment.b(this.a)) && (ExtendFriendSquareFragment.a(this.a) != null) && (ExtendFriendSquareFragment.a(this.a) != null) && (ExtendFriendSquareFragment.a(this.a).findViewByPosition(ExtendFriendSquareFragment.a(this.a).getItemCount() - 2) != null))
    {
      ExtendFriendSquareFragment.a(this.a, true);
      ExtendFriendSquareFragment.a(this.a).post(new acix(this));
      ReportController.b(ExtendFriendSquareFragment.a(this.a), "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
    if ((ExtendFriendSquareFragment.b(this.a) >= 0) && (ExtendFriendSquareFragment.a(this.a).findViewByPosition(ExtendFriendSquareFragment.b(this.a)) == null)) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aciw
 * JD-Core Version:    0.7.0.1
 */