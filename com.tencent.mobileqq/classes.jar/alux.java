import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class alux
{
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString, aluy paramaluy)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.8");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_playing_usernum");
      ((JSONObject)localObject).put("from", paramString);
      ((JSONObject)localObject).put("gameId", paramInt);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(BaseApplicationImpl.getContext(), alsb.class);
      paramString.putExtra("timeout", 10000L);
      paramString.putExtra("cmd", "apollo_aio_game.get_playing_usernum");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.setObserver(paramaluy);
      paramAppInterface.startServlet(paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("cmgame_process._CmGameSSOReq", 1, "[queryUserAudioStatus] failed ", paramAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alux
 * JD-Core Version:    0.7.0.1
 */