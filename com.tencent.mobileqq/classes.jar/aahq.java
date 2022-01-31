import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aahq
  extends BroadcastReceiver
{
  private aahq(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = null;
    String str = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      if ("[onRecevier] action:" + str + ",data:" + paramIntent.getExtras() != null) {
        paramContext = paramIntent.getExtras().toString();
      }
      QLog.d("GCApi", 2, paramContext);
    }
    if (str == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ("action_qgame_messgae_change".equals(str))
          {
            paramIntent = paramIntent.getExtras();
            if (paramIntent == null) {
              continue;
            }
            paramContext = (GameCenterSessionInfo)paramIntent.getParcelable("key_game_msg");
            i = paramIntent.getInt("key_msg_change_type");
            if (QLog.isColorLevel()) {
              QLog.d("GCApi", 0, "[onReceive] type:" + i + ",info:" + paramContext);
            }
            paramIntent = new JSONArray();
            if (paramContext != null) {
              paramIntent.put(paramContext.a());
            }
            try
            {
              paramContext = new JSONObject();
              paramContext.put("session", paramIntent);
              paramContext.put("eventType", i);
              paramContext.put("ret", 0);
              this.a.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_SESSION_INFO, paramContext, null);
              if (QLog.isColorLevel())
              {
                QLog.d("GCApi", 2, "[onReceive] gameCenterMsg: " + paramContext.toString());
                return;
              }
            }
            catch (Exception paramContext)
            {
              return;
            }
          }
        }
      } while (!"action_qgame_unread_change".equals(str));
      paramContext = paramIntent.getExtras();
    } while (paramContext == null);
    int i = paramContext.getInt("key_msg_unread_cnt");
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 2, "[onReceive] cnt:" + i);
    }
    try
    {
      paramContext = new JSONObject();
      paramContext.put("newMsgCount", i);
      paramContext.put("ret", 0);
      this.a.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_UNREAD_CNT, paramContext, null);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GCApi", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahq
 * JD-Core Version:    0.7.0.1
 */