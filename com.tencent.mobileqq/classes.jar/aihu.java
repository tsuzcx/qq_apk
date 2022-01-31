import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aihu
  extends baox
{
  private aihu(FriendCardApolloViewController paramFriendCardApolloViewController) {}
  
  protected void onGetExploreMsg(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendCardApolloViewController", 1, "[onGetExploreMsg] get info end");
        }
        paramObject = new JSONObject((String)paramObject);
        if (paramObject.optInt("entry_id", -1) != 2) {
          return;
        }
        FriendCardApolloViewController.a(this.a, paramObject.optString("icon_url"));
        QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] iconUrl:" + FriendCardApolloViewController.a(this.a));
        return;
      }
      catch (Exception paramObject)
      {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aihu
 * JD-Core Version:    0.7.0.1
 */