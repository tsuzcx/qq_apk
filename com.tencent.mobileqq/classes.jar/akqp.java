import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class akqp
  implements BusinessObserver
{
  public void a(boolean paramBoolean, long paramLong, Object paramObject) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process._CmGameSSOReq", 2, "[ICmGameSSOReqListener] onReceive");
    }
    Object localObject = paramBundle.getString("cmd");
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        localUniSsoServerRsp.mergeFrom(paramBundle);
        long l1 = localUniSsoServerRsp.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process._CmGameSSOReq", 2, new Object[] { "[handleGameOnlineCountRsp] ret=", Long.valueOf(localUniSsoServerRsp.ret.get()) });
        }
        if ("apollo_aio_game.get_playing_usernum".equals(localObject))
        {
          if (l1 == 0L)
          {
            paramBundle = localUniSsoServerRsp.rspdata.get();
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process._CmGameSSOReq", 2, new Object[] { "[handleGameOnlineCountRsp] respData=", paramBundle });
            }
            paramBundle = new JSONObject(paramBundle);
            long l2 = 0L;
            l1 = l2;
            if (paramBundle != null)
            {
              localObject = paramBundle.optJSONObject("data");
              l1 = l2;
              if (localObject != null) {
                l1 = ((JSONObject)localObject).optLong("num");
              }
            }
            a(true, l1, paramBundle);
            return;
          }
          a(false, 0L, null);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("cmgame_process._CmGameSSOReq", 1, "[handleGameOnlineCountRsp] exception=", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqp
 * JD-Core Version:    0.7.0.1
 */