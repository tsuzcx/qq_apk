import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;

public class aidn
  extends ajxj
{
  public aidn(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidn
 * JD-Core Version:    0.7.0.1
 */