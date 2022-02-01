import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class ahjj
  implements bezd
{
  ahjj(ahiu paramahiu) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.optInt("retcode", -1) != 0) {
      return;
    }
    paramJSONObject = (bfas)this.a.app.getManager(132);
    paramInt = paramJSONObject.a(this.a.sessionInfo.curFriendUin);
    paramJSONObject.a(this.a.sessionInfo.curFriendUin, 0, paramInt & 0xF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjj
 * JD-Core Version:    0.7.0.1
 */