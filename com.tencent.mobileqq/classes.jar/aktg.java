import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel.5;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

public class aktg
{
  private static String[] a = { "cs.create_room.local", "cs.game_start.local", "cs.game_tips.local", "cs.check_pubAccount_state.local", "cs.on_get_open_key.local", "general_cmd_ui_show_toast", "cs.get_dress_path.local", "cs.send_game_msg.local", "cs.report_data_2_backstage.local", "cs.report_flow_data.local", "cs.openWebView.local", "cs.openFloatTransparentView.local", "cs.get_server_ip_port.local", "cs.save_recommend_ip.local", "cs.script_get_action_data.local", "cs.game_shell_share_callback.local", "cs.create_xy.local", "cs.open_cm_aio.local", "cs.show_one_more_page.local" };
  private static String[] b = { "cs.report_data_2_compass.local", "cs.invite_friends.local", "cs.send_b2c_redpacket.local", "cs.share_game_result.local", "cs.qta_notify_test_result.local", "cs.share_pic.local", "cs.apolloGameWebMessage.local", "cs.openWebViewWithoutUrl.local", "cs.share_game_in_ark.local", "cs.enter_pubAccount_card.local", "cs.fetch_cloud_signature.local", "cs.game_update_score.local", "cs.get_redPacket_result.local", "cs.closeWebview.local", "cs.game_ad_video_jump.local", "cs.xy_ad_banner_jump.local", "cs.game_ad_video_close.local", "cs.get_user_info.local", "cs.get_app_friends.local", "cs.get_location.local", "cs.get_city.local", "cs.apolloGameTargetWebMessage.local", "cs.load_subpackage.local", "sc.load_percentage_nofity.local", "cs.file_correctness_check.local", "cs.game_ad_banner_show.local", "cs.game_ad_banner_close.local", "cs.game_ad_banner_hide.local", "cs.game_ad_banner_resize.local", "cs.game_ad_banner_load.local", "cs.report_event.local" };
  private static String[] c = { "cs.first_frame_drawn.local", "cs.join_room.local", "cs.make_room_min.local", "cs.close_room.local" };
  
  public static int a(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!akro.a()) {
      return 0;
    }
    int i = -1;
    aktr localaktr = akro.b(paramLong);
    if (localaktr != null) {
      i = localaktr.a();
    }
    int j = a(paramString1);
    if ((1 == j) || (3 == j)) {
      a(paramLong, paramString1, paramString2, paramBoolean, i);
    }
    return j;
  }
  
  public static int a(String paramString)
  {
    int i;
    if (a(paramString, a)) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameToolCmdChannel", 2, new Object[] { "[getCmdType], cmd:", paramString, ",type:", Integer.valueOf(i) });
      }
      return i;
      if (a(paramString, b)) {
        i = 2;
      } else if (a(paramString, c)) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, EIPCResultCallback paramEIPCResultCallback, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("reqData", paramString2);
    localBundle.putBoolean("async", paramBoolean);
    localBundle.putInt("gameId", paramInt);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_chanel_req", localBundle, paramEIPCResultCallback);
  }
  
  private static boolean a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (paramString1.equals("cs.check_pubAccount_state.local")) {
      a(paramString1, paramString2, paramBoolean, new akth(paramLong), paramInt);
    }
    label199:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          return false;
          if (paramString1.equals("cs.on_get_open_key.local"))
          {
            a(paramString1, paramString2, paramBoolean, new akti(paramLong), paramInt);
            return false;
          }
          if (!paramString1.equals("cs.get_dress_path.local")) {
            break label199;
          }
          localObject2 = new aktj(paramLong, paramString1);
          try
          {
            aktr localaktr = akro.b(paramLong);
            str = paramString2;
            if (localaktr != null)
            {
              JSONObject localJSONObject = new JSONObject(paramString2);
              str = paramString2;
              if (!localJSONObject.has("gameId"))
              {
                localJSONObject.put("gameId", localaktr.a());
                str = localJSONObject.toString();
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              String str;
              QLog.e("cmgame_process.CmGameToolCmdChannel", 1, localException, new Object[0]);
              localObject1 = paramString2;
            }
          }
          a(paramString1, str, paramBoolean, (EIPCResultCallback)localObject2, paramInt);
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GET_DRESS_PATH ccallServer reqData:" + str);
        return false;
        if (!paramString1.equals("cs.script_get_action_data.local")) {
          break;
        }
        Object localObject1 = new aktk(paramLong);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("cmd", paramString1);
        ((Bundle)localObject2).putString("reqData", paramString2);
        ((Bundle)localObject2).putBoolean("async", paramBoolean);
        QIPCClientHelper.getInstance().callServer("cm_game_module", "action_get_action_data", (Bundle)localObject2, (EIPCResultCallback)localObject1);
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, "GET_ACTION_DATA ccallServer bundle:" + localObject2);
      return false;
      if (!"cs.game_shell_share_callback.local".equals(paramString1)) {
        break;
      }
      paramString1 = akro.b(paramLong);
      if (paramString1 != null) {
        paramString1.d(paramString2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GAME_SHARE_CALLBACK ");
    return false;
    if ("cs.show_one_more_page.local".equals(paramString1))
    {
      ThreadManagerV2.excute(new CmGameToolCmdChannel.5(paramInt, paramString1, paramString2), 16, null, false);
      return false;
    }
    a(paramString1, paramString2, paramBoolean, null, paramInt);
    return false;
  }
  
  public static boolean a(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!akro.a()) {}
    for (;;)
    {
      return false;
      try
      {
        akuf localakuf = akro.a(paramLong);
        if (localakuf != null)
        {
          paramBoolean = localakuf.a(paramLong, paramBoolean, paramString1, paramString2);
          return paramBoolean;
        }
      }
      catch (Throwable paramString1) {}
    }
    return false;
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktg
 * JD-Core Version:    0.7.0.1
 */