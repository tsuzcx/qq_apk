import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aadb
  extends aqyp
{
  aadb(aada paramaada) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    int i;
    Object localObject;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == aada.a(this.a).key))
    {
      i = paramBundle.getInt("failcode");
      localObject = paramBundle.getBundle("request");
      if (i == 1000) {
        break label80;
      }
      QLog.e("SSOWebviewPlugin", 2, "IPC failed ! failcode: " + i + "  reqParams: " + localObject);
    }
    for (;;)
    {
      return;
      label80:
      String str = paramBundle.getString("cmd");
      paramBundle = paramBundle.getBundle("response");
      if (("ipc_cmd_certified_account_web_plugin_follow".equals(str)) && (localObject != null) && (paramBundle != null))
      {
        localObject = ((Bundle)localObject).getString("callback");
        i = paramBundle.getInt("retCode");
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("retCode", i);
          this.a.callJs((String)localObject, new String[] { paramBundle.toString() });
          if (QLog.isColorLevel())
          {
            QLog.d("SSOWebviewPlugin", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW return! retCode: " + i);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          QLog.e("SSOWebviewPlugin", 2, "sso.PublicFollow failed! " + QLog.getStackTraceString(paramBundle));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadb
 * JD-Core Version:    0.7.0.1
 */