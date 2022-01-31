import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameClientQIPCModule.1;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;

public class akvt
  extends QIPCModule
{
  public static boolean a;
  
  public akvt(String paramString)
  {
    super(paramString);
  }
  
  public static akvt a()
  {
    return akvu.a();
  }
  
  public static void a()
  {
    akvt localakvt = a();
    if (!a)
    {
      QIPCClientHelper.getInstance().register(localakvt);
      a = true;
    }
  }
  
  public static void a(int paramInt)
  {
    if (3112 == paramInt) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManagerV2.excute(new CmGameClientQIPCModule.1(paramInt), 16, null, false);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("gameId", paramInt);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_close_game", localBundle, null);
  }
  
  public akyg a()
  {
    akyp localakyp = akwd.a();
    if (localakyp != null) {
      return localakyp.a();
    }
    return null;
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public void onAccountChange()
  {
    super.onAccountChange();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameClientQIPCModule", 2, "onCall main server action=" + paramString);
    }
    boolean bool;
    try
    {
      if ("action_close_game".equals(paramString))
      {
        akwd.a(paramBundle.getInt("gameId"));
      }
      else if ("action_update_audio_status".equals(paramString))
      {
        bool = paramBundle.getBoolean("isOpen");
        paramString = paramBundle.getString("key_game_friUin");
        paramBundle = a();
        if (paramBundle == null) {
          break label761;
        }
        paramBundle = paramBundle.a();
        if ((paramBundle == null) || (!(paramBundle instanceof ApolloGameActivity))) {
          break label761;
        }
        ((ApolloGameActivity)paramBundle).a(bool, paramString);
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameClientQIPCModule", 1, paramString, new Object[0]);
    }
    if ("action_dress_changed".equals(paramString))
    {
      CmShowRenderView.a(paramBundle.getStringArrayList("key_dress_change_uin"));
    }
    else if ("action_check_game_running".equals(paramString))
    {
      paramString = a();
      if (paramString != null)
      {
        paramString = paramString.a();
        if (paramString != null)
        {
          if ((paramString.src == 319) || (paramString.src == 318))
          {
            paramBundle = new Bundle();
            paramBundle.putString("key_game_friUin", paramString.mTempAIOUin);
            callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
          }
        }
        else
        {
          paramString = new EIPCResult();
          paramString.code = -1;
          callbackResult(paramInt, paramString);
        }
      }
      else
      {
        paramString = new EIPCResult();
        paramString.code = -1;
        callbackResult(paramInt, paramString);
      }
    }
    else if ("action_show_audio_dialog".equals(paramString))
    {
      paramString = a();
      if (paramString != null)
      {
        paramString = paramString.a();
        if ((paramString != null) && ((paramString instanceof ApolloGameActivity))) {
          ((ApolloGameActivity)paramString).a(paramBundle.getString("key_dialog_type"));
        }
      }
    }
    else if ("action_set_sso_rule".equals(paramString))
    {
      paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
      paramBundle = paramBundle.getString("rule");
      if ((paramString == null) || (TextUtils.isEmpty(paramBundle))) {
        break label763;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameClientQIPCModule", 2, new Object[] { "ACTION_SET_SSO_RULE startCheckParam:", paramString, " rule:", paramBundle });
      }
      akyp localakyp = akwd.a();
      if (localakyp != null) {
        localakyp.a(paramString.gameId, paramBundle);
      }
    }
    else
    {
      bool = "action_start_cmgame_direct".equals(paramString);
      if (bool)
      {
        try
        {
          long l = paramBundle.getLong("startTime", 0L);
          paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (paramString == null) {
            return null;
          }
          paramInt = paramString.gameId;
          int i = paramString.src;
          l = System.currentTimeMillis() - l;
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_ipc_start_receive, duration=", Long.valueOf(l), ", gameId=", Integer.valueOf(paramInt), ", src=", Integer.valueOf(i) });
          if (l >= 0L)
          {
            paramBundle = new HashMap();
            paramBundle.put("param_gameId", String.valueOf(paramInt));
            paramBundle.put("param_src", String.valueOf(i));
            azri.a(BaseApplicationImpl.getApplication()).a(null, "cmgame_ipc_start_receive", true, l, 0L, paramBundle, "", false);
          }
          akwd.a(paramString);
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameClientQIPCModule", 1, paramString, new Object[0]);
        }
      }
      else if ("action_check_game_data".equals(paramString))
      {
        paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if (paramString == null) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameClientQIPCModule", 2, new Object[] { "ACTION_CHECK_GAME_DATA startCheckParam", paramString });
        }
        paramString = akwd.a(paramString.gameId);
        if (paramString != null) {
          paramString.a(paramBundle);
        }
      }
      else if ("action_game_loading_closed".equals(paramString))
      {
        paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if (paramString == null) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameClientQIPCModule", 2, new Object[] { "ACTION_GAME_LOADING_CLOSED startCheckParam", paramString });
        }
        paramString = akwd.a(paramString.gameId);
        if (paramString != null)
        {
          paramString = paramString.a();
          if (paramString != null) {
            paramString.finish();
          }
        }
      }
    }
    label761:
    return null;
    label763:
    return null;
  }
  
  public void onReceiveMsg(int paramInt, Bundle paramBundle)
  {
    super.onReceiveMsg(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvt
 * JD-Core Version:    0.7.0.1
 */