import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class akqm
  extends bdul
{
  private java.lang.ref.WeakReference<FriendCardApolloViewController> a;
  
  public akqm(FriendCardApolloViewController paramFriendCardApolloViewController)
  {
    this.a = new mqq.util.WeakReference(paramFriendCardApolloViewController);
  }
  
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
        FriendCardApolloViewController localFriendCardApolloViewController = (FriendCardApolloViewController)this.a.get();
        if (localFriendCardApolloViewController == null) {
          return;
        }
        FriendCardApolloViewController.a(localFriendCardApolloViewController, paramObject.optString("icon_url"));
        QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] iconUrl:" + FriendCardApolloViewController.a(localFriendCardApolloViewController));
        return;
      }
      catch (Exception paramObject) {}
    } else if (QLog.isColorLevel()) {
      QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqm
 * JD-Core Version:    0.7.0.1
 */