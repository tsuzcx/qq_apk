import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import org.json.JSONObject;

class aied
  implements bghi
{
  aied(aido paramaido) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.optInt("retcode", -1) != 0) {
      return;
    }
    paramJSONObject = (bgiy)this.a.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    paramInt = paramJSONObject.a(this.a.sessionInfo.curFriendUin);
    paramJSONObject.a(this.a.sessionInfo.curFriendUin, 0, paramInt & 0xF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aied
 * JD-Core Version:    0.7.0.1
 */