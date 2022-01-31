import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;

public class aimr
  extends FriendListObserver
{
  public aimr(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    this.a.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimr
 * JD-Core Version:    0.7.0.1
 */