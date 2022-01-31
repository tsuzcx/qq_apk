import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;

public class ahqx
  extends ajjh
{
  public ahqx(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahqx
 * JD-Core Version:    0.7.0.1
 */