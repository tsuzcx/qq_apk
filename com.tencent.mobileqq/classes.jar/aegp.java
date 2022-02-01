import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.widget.AbsListView;
import java.util.Iterator;
import java.util.List;

public class aegp
  implements bkhe
{
  public aegp(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FriendProfileCardActivity.a(this.a) != null)
    {
      Iterator localIterator = FriendProfileCardActivity.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((bkhe)localIterator.next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      adcd.a().a("vas_profilecard_list", false);
    }
    while (FriendProfileCardActivity.a(this.a) != null)
    {
      Iterator localIterator = FriendProfileCardActivity.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((bkhe)localIterator.next()).onScrollStateChanged(paramAbsListView, paramInt);
      }
      adcd.a().a("vas_profilecard_list");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegp
 * JD-Core Version:    0.7.0.1
 */