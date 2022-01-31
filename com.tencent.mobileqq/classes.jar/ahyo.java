import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;

public class ahyo
  extends FriendListObserver
{
  public ahyo(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    this.a.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahyo
 * JD-Core Version:    0.7.0.1
 */