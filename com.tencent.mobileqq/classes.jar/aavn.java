import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.widget.AbsListView;

public class aavn
  implements begh
{
  public aavn(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    FriendProfileCardActivity.a(this.a, paramInt1);
    if ((this.a.a != null) && (this.a.a.a("map_key_extend_friend_info"))) {
      this.a.a.d();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a.b != paramInt) {
      this.a.b = paramInt;
    }
    switch (paramInt)
    {
    default: 
      zqk.a().a("vas_profilecard_list");
    }
    for (;;)
    {
      if (FriendProfileCardActivity.a(this.a) != null) {
        FriendProfileCardActivity.a(this.a).a(paramInt);
      }
      return;
      zqk.a().a("vas_profilecard_list", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavn
 * JD-Core Version:    0.7.0.1
 */