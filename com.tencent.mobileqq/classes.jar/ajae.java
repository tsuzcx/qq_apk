import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ai.ApolloAIActivity;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment;
import com.tencent.mobileqq.apollo.process.CmGameUtil.2;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajae
{
  static float jdField_a_of_type_Float = -1.0F;
  static int jdField_a_of_type_Int;
  public static long a;
  private static LRULinkedHashMap<String, String> jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  public static boolean a;
  public static long b;
  public static long c;
  static long d = -1L;
  public static long e;
  private static long f;
  private static volatile long g;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(3);
    jdField_a_of_type_Int = -1;
  }
  
  public static int a()
  {
    return aizw.a().a();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {}
    do
    {
      return 1;
      if (paramInt == 2) {
        return 8;
      }
    } while (paramInt != 3);
    return 0;
  }
  
  public static int a(long paramLong)
  {
    ajch localajch = b(paramLong);
    if (localajch == null) {
      return -1;
    }
    return localajch.a();
  }
  
  public static aiwu a()
  {
    ajcq localajcq = a();
    if (localajcq != null) {
      return localajcq.a();
    }
    return null;
  }
  
  public static ajch a()
  {
    ajcq localajcq = a();
    if (localajcq == null) {
      return null;
    }
    return localajcq.a();
  }
  
  public static ajch a(int paramInt)
  {
    ajcq localajcq = a();
    if (localajcq == null) {
      return null;
    }
    return localajcq.a(paramInt);
  }
  
  public static ajch a(int paramInt1, int paramInt2)
  {
    ajcq localajcq = a();
    if (localajcq == null) {
      return null;
    }
    return localajcq.a(paramInt1, paramInt2);
  }
  
  public static ajch a(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getRenderByThreadId();
    if ((localApolloRender == null) || (localApolloRender.getSavaWrapper() == null))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "render is null.");
      return null;
    }
    return b(localApolloRender.getSavaWrapper().a());
  }
  
  public static ajco a()
  {
    int i = a();
    if (-1 == i) {}
    ajcm localajcm;
    do
    {
      return null;
      localajcm = aizw.a().a(i);
    } while (localajcm == null);
    return localajcm.a();
  }
  
  public static ajcq a()
  {
    AppInterface localAppInterface = a();
    if ((localAppInterface instanceof CmGameAppInterface)) {
      return (ajcq)((CmGameAppInterface)localAppInterface).getManager(255);
    }
    return null;
  }
  
  public static ajcv a(int paramInt)
  {
    ajch localajch = a(paramInt);
    if (localajch != null) {
      return localajch.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static ajcv a(long paramLong)
  {
    ajch localajch = b(paramLong);
    if (localajch != null) {
      return localajch.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static ajdq a()
  {
    try
    {
      Object localObject = a();
      if ((localObject != null) && ((localObject instanceof CmGameAppInterface)))
      {
        localObject = (ajdq)((AppInterface)localObject).getBusinessHandler(0);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
      return null;
    }
    return null;
  }
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("cmshowgame_module");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  public static ApolloSurfaceView a()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((ajcq)localObject).a();
    } while (localObject == null);
    return ((ajch)localObject).a();
  }
  
  public static ApolloCmdChannel a()
  {
    ajcq localajcq = a();
    if (localajcq != null) {
      return localajcq.a();
    }
    return null;
  }
  
  public static Class a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        int i = paramString.indexOf(')');
        if (-1 != i)
        {
          paramString = a(paramString.substring(i + 1));
          if ((paramString != null) && (paramString.length != 0))
          {
            paramString = paramString[0];
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public static String a(CmGameInitParams paramCmGameInitParams)
  {
    return b(paramCmGameInitParams);
  }
  
  public static String a(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[getMainJsFromCache] sEnableMainJsCache=", Boolean.valueOf(jdField_a_of_type_Boolean), ", mainJsPath=", paramString });
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (jdField_a_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (String)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
      }
    }
    return localObject1;
  }
  
  public static void a()
  {
    aizw.a().a();
  }
  
  public static void a(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameUtil", 1, "fail to close game, gameId:" + paramInt);
    }
    do
    {
      return;
      localObject = ((ajch)localObject).a();
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "success to close game, gameId:" + paramInt);
    }
    ((Activity)localObject).finish();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("cmgame_process.CmGameUtil", 1, "[sendActLifeCycleIpc], gameId:" + paramInt2 + ",status:" + paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt1);
    localBundle.putInt("gameId", paramInt2);
    localBundle.putInt("activityId", paramInt3);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", localBundle, null);
  }
  
  public static void a(int paramInt1, int paramInt2, CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt3)
  {
    QLog.i("cmgame_process.CmGameUtil", 1, "[sendActLifeCycleIpc], gameId:" + paramInt2 + ",status:" + paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt1);
    localBundle.putInt("gameId", paramInt2);
    localBundle.putInt("activityId", paramInt3);
    localBundle.putSerializable("para", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", localBundle, null);
  }
  
  public static void a(int paramInt, Context paramContext)
  {
    try
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      localObject = ((ajch)localObject).a();
      if (localObject == null)
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "CmGameInitParams is null.");
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, paramContext, new Object[0]);
      return;
    }
    if ((paramContext instanceof ApolloGameActivity))
    {
      ((ApolloGameActivity)paramContext).moveTaskToBack(true);
      return;
    }
    paramInt = ((CmGameStartChecker.StartCheckParam)localObject).enter;
    Object localObject = new Intent(paramContext, SplashActivity.class);
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 7))
    {
      ((Intent)localObject).putExtra("fragment_id", 2);
      for (;;)
      {
        ((Intent)localObject).putExtra("fromApollo", 1);
        ((Intent)localObject).setFlags(67174400);
        paramContext.startActivity((Intent)localObject);
        return;
        label123:
        ((Intent)localObject).putExtra("fragment_id", 1);
        ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      break;
      if ((paramInt == 2) || (paramInt == 8)) {
        break label123;
      }
      if (paramInt != 5) {
        if (paramInt != 4) {
          break;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(paramActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("fromApolloNewUser", 1);
      localIntent.setFlags(67174400);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(Activity paramActivity, Conversation paramConversation)
  {
    if (a() == null) {}
    airz localairz;
    do
    {
      return;
      localairz = (airz)a().getManager(153);
      if (a(null)) {
        localairz.k = true;
      }
    } while ((localairz == null) || (!localairz.j) || (paramActivity == null) || (!(paramActivity instanceof SplashActivity)) || (paramActivity.isFinishing()) || (!((SplashActivity)paramActivity).isResume()) || (paramConversation == null));
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.s();
    }
    a(paramConversation.b, localairz.a());
    localairz.j = false;
    paramConversation.d = true;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[openCmGameWebView] context and url must not be null");
      return;
    }
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[openCmGameWebView] url=", paramString });
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(View paramView, String paramString)
  {
    if (paramView != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Rect localRect = new Rect();
        paramView.getGlobalVisibleRect(localRect);
        TextView localTextView = new TextView(paramView.getContext());
        localTextView.setText(paramString);
        localTextView.setGravity(17);
        localTextView.setTextSize(16.0F);
        localTextView.setTextColor(-1);
        localTextView.setBackgroundResource(2130838426);
        localTextView.setPadding((int)(bbct.jdField_a_of_type_Float * 7.0F), (int)(bbct.jdField_a_of_type_Float * 7.0F), (int)(bbct.jdField_a_of_type_Float * 7.0F), 0);
        paramString = new PopupWindow(localTextView, -2, -2);
        paramString.setOutsideTouchable(true);
        paramString.setBackgroundDrawable(new ColorDrawable(0));
        localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int i = (int)((float)bbct.k() - bbct.jdField_a_of_type_Float * 7.0F - localTextView.getMeasuredWidth());
        int j = (int)(localRect.bottom - 6.0F * bbct.jdField_a_of_type_Float);
        paramString.showAtLocation(paramView.getRootView(), 0, i, j);
        b(1);
        ThreadManager.getUIHandler().postDelayed(new CmGameUtil.2(paramString), 10000L);
        QLog.d("cmgame_process.CmGameUtil", 1, "showNewPlusGuidePop");
        VipUtils.a(a(), "cmshow", "Apollo", "plusbubbleexposure", 0, 0, new String[] { "" + c() });
      }
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[reportGameEvent] gameId=", Integer.valueOf(paramInt3), ", eventId=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", failCode=", Long.valueOf(paramLong), ", extInfo=", paramJSONObject });
    }
    if (paramAppInterface == null)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameEvent] app null");
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.2.8");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("platform", 109);
      ((JSONObject)localObject).put("osVersion", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("brand", Build.BRAND);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("sqVersion", "8.2.8.4440");
      ((JSONObject)localObject).put("ts", NetConnInfoCenter.getServerTime());
      ((JSONObject)localObject).put("mid", paramInt1);
      ((JSONObject)localObject).put("value", paramInt2);
      ((JSONObject)localObject).put("gameId", paramInt3);
      ((JSONObject)localObject).put("failCode", paramLong);
      if (paramJSONObject != null) {
        ((JSONObject)localObject).put("extInfo", paramJSONObject);
      }
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramJSONObject = new NewIntent(paramAppInterface.getApp(), aiwi.class);
      paramJSONObject.putExtra("cmd", "apollo_monit_report.game_report_single");
      paramJSONObject.putExtra("data", localUniSsoServerReq.toByteArray());
      paramJSONObject.setObserver(new ajaf());
      paramAppInterface.startServlet(paramJSONObject);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameEvent] failed, exception=", paramAppInterface);
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[reportGameData]", paramString });
    }
    if (paramAppInterface == null)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameData] app null");
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.2.8");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("id", -1);
      ((JSONObject)localObject).put("from", "android");
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ((JSONObject)localObject).put("reportData", localJSONArray);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(paramAppInterface.getApp(), aiwi.class);
      paramString.putExtra("cmd", "ltgame_redpkg_report.terminal_report");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.setObserver(new ajag());
      paramAppInterface.startServlet(paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameData] failed, exception=", paramAppInterface);
    }
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "[launchGame]");
    }
    if (paramStartCheckParam == null) {
      QLog.e("cmgame_process.CmGameUtil", 1, "[launchGame], null params.");
    }
    ajcq localajcq;
    do
    {
      return;
      localajcq = a();
    } while (localajcq == null);
    long l = System.currentTimeMillis();
    if (l - f < 1000L)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[launchGame] current - sLastLaunchGameTime < 1000");
      return;
    }
    f = l;
    if (paramStartCheckParam.mCreateTs == jdField_b_of_type_Long)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, new Object[] { "launchGame had launch game sLastStartGameCreateTs:", Long.valueOf(jdField_b_of_type_Long) });
      return;
    }
    jdField_b_of_type_Long = paramStartCheckParam.mCreateTs;
    jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if ((paramStartCheckParam != null) && (paramStartCheckParam.statMap != null)) {
      paramStartCheckParam.statMap.put("game_launch_time", Long.valueOf(jdField_c_of_type_Long));
    }
    QLog.d("CmGameStat", 1, new Object[] { "sLaunchGameTs=", Long.valueOf(jdField_c_of_type_Long) });
    Object localObject1 = null;
    Object localObject2 = null;
    localajcq.a();
    List localList;
    int i;
    Object localObject3;
    Object localObject4;
    if (paramStartCheckParam.gameId == 3112)
    {
      localObject2 = ApolloAIActivity.class;
      if ((BaseActivity.sTopActivity != null) && (BaseActivity.sTopActivity.getClass() != localObject2) && (BaseActivity.sTopActivity.getClass() != SingleTaskQQBrowser.class))
      {
        localObject1 = new Intent(BaseActivity.sTopActivity, (Class)localObject2);
        ((Intent)localObject1).putExtra("extra_startcheckparam", paramStartCheckParam);
        ((Intent)localObject1).addFlags(268435456);
        BaseActivity.sTopActivity.startActivity((Intent)localObject1);
      }
    }
    else
    {
      localList = localajcq.a();
      if ((paramStartCheckParam.mStartType == 2) || (paramStartCheckParam.mStartType == 1) || (paramStartCheckParam.mStartType == 3))
      {
        QLog.i("cmgame_process.CmGameUtil", 1, "[launchGame], params.mStartType:" + paramStartCheckParam.mStartType);
        localObject1 = localObject2;
        if (localList != null)
        {
          i = 0;
          localObject1 = localObject2;
          if (i < localList.size())
          {
            localObject3 = (ajct)localList.get(i);
            if ((localObject3 == null) || (((ajct)localObject3).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)) {
              break label713;
            }
            localObject1 = localajcq.a(((ajct)localObject3).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
            if (localObject1 == null) {
              break label713;
            }
            localObject4 = ((ajch)localObject1).a();
            if ((((ajch)localObject1).a() != paramStartCheckParam.gameId) || ((paramStartCheckParam.roomId != 0L) && (paramStartCheckParam.roomId != ((ajrf)localObject4).jdField_a_of_type_Long))) {
              break label713;
            }
            if (((ajch)localObject1).a() == null) {
              break label1490;
            }
          }
        }
      }
    }
    label713:
    label849:
    label1490:
    for (localObject1 = ((ajch)localObject1).a().getClass();; localObject1 = null)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, " launchGame found old task.mStartCheckParam:" + ((ajct)localObject3).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      if (localObject1 == null)
      {
        if ((localList != null) && (localList.size() >= ajcq.jdField_a_of_type_ArrayOfJavaLangClass.length))
        {
          localObject2 = (ajct)localList.get(0);
          if ((localObject2 != null) && (((ajct)localObject2).jdField_a_of_type_JavaLangRefWeakReference != null))
          {
            localObject3 = (Activity)((ajct)localObject2).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localObject3 != null)
            {
              ((Activity)localObject3).finish();
              if (((ajct)localObject2).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
              {
                ajbw.a("cs.close_room.local", "{}", false, null, ((ajct)localObject2).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
                QLog.i("cmgame_process.CmGameUtil", 1, " launchGame close old  task.mStartCheckParam.gameId:" + ((ajct)localObject2).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
              }
            }
          }
          localajcq.jdField_a_of_type_JavaUtilList.remove(0);
        }
        localObject2 = new HashMap();
        i = 0;
        for (;;)
        {
          if (i < localajcq.jdField_a_of_type_JavaUtilList.size())
          {
            localObject3 = (ajct)localajcq.jdField_a_of_type_JavaUtilList.get(i);
            if ((localObject3 != null) && (((ajct)localObject3).jdField_a_of_type_JavaLangString != null)) {
              ((HashMap)localObject2).put(((ajct)localObject3).jdField_a_of_type_JavaLangString, ((ajct)localObject3).jdField_a_of_type_JavaLangString);
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        i = 0;
        if (i >= ajcq.jdField_a_of_type_ArrayOfJavaLangClass.length) {
          break label1483;
        }
        if (TextUtils.isEmpty((String)((HashMap)localObject2).get(ajcq.jdField_a_of_type_ArrayOfJavaLangClass[i].getSimpleName())))
        {
          localObject2 = ajcq.jdField_a_of_type_ArrayOfJavaLangClass[i];
          QLog.i("cmgame_process.CmGameUtil", 1, " launchGame startInGame found activityClass:" + localObject2);
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ajcq.jdField_a_of_type_ArrayOfJavaLangClass[0];
          QLog.e("cmgame_process.CmGameUtil", 1, "can not find activityClass, use first class");
        }
        localObject2 = new ajct();
        ((ajct)localObject2).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
        ((ajct)localObject2).jdField_a_of_type_JavaLangString = ((Class)localObject1).getSimpleName();
        localajcq.jdField_a_of_type_JavaUtilList.add(localObject2);
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = localajcq.jdField_a_of_type_JavaUtilList.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (ajct)((Iterator)localObject2).next();
                QLog.d("cmgame_process.CmGameUtil", 2, "launchGame task:" + ((ajct)localObject3).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
                continue;
                i += 1;
                break;
                QLog.i("cmgame_process.CmGameUtil", 1, " launchGame startInGame start old Activity activityClass:" + localObject1);
                break label849;
                if (localList == null) {
                  break label1477;
                }
                localObject4 = new ArrayList();
                i = 0;
                while (i < localList.size())
                {
                  ajct localajct = (ajct)localList.get(i);
                  boolean bool2 = false;
                  localObject3 = localObject1;
                  if (localajct != null)
                  {
                    localObject3 = localObject1;
                    if (localajct.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
                    {
                      localObject3 = localajcq.a(localajct.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
                      boolean bool1 = bool2;
                      localObject2 = localObject1;
                      if (localObject3 != null)
                      {
                        ajrf localajrf = ((ajch)localObject3).a();
                        bool1 = bool2;
                        localObject2 = localObject1;
                        if (((ajch)localObject3).a() == paramStartCheckParam.gameId) {
                          if (paramStartCheckParam.roomId != 0L)
                          {
                            bool1 = bool2;
                            localObject2 = localObject1;
                            if (paramStartCheckParam.roomId != localajrf.jdField_a_of_type_Long) {}
                          }
                          else
                          {
                            bool2 = true;
                            bool1 = bool2;
                            localObject2 = localObject1;
                            if (((ajch)localObject3).a() != null)
                            {
                              localObject2 = ((ajch)localObject3).a().getClass();
                              bool1 = bool2;
                            }
                          }
                        }
                      }
                      QLog.i("cmgame_process.CmGameUtil", 1, " launchGame check sameGame:" + bool1);
                      localObject3 = localObject2;
                      if (!bool1)
                      {
                        if (localajct.jdField_a_of_type_JavaLangRefWeakReference != null)
                        {
                          localObject1 = (Activity)localajct.jdField_a_of_type_JavaLangRefWeakReference.get();
                          if (localObject1 != null)
                          {
                            ((Activity)localObject1).finish();
                            if (localajct.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
                              ajbw.a("cs.close_room.local", "{}", false, null, localajct.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
                            }
                            QLog.i("cmgame_process.CmGameUtil", 1, " launchGame close old  task.mStartCheckParam.gameId:" + localajct.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
                          }
                        }
                        ((List)localObject4).add(localajct);
                        localObject3 = localObject2;
                      }
                    }
                  }
                  i += 1;
                  localObject1 = localObject3;
                }
                localList.removeAll((Collection)localObject4);
              }
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            localObject1 = ajcq.jdField_a_of_type_ArrayOfJavaLangClass[0];
            localObject2 = new ajct();
            ((ajct)localObject2).jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
            ((ajct)localObject2).jdField_a_of_type_JavaLangString = ((Class)localObject1).getSimpleName();
            localajcq.jdField_a_of_type_JavaUtilList.add(localObject2);
            break label849;
          }
          QLog.i("cmgame_process.CmGameUtil", 1, " launchGame start old Activity activityClass:" + localObject1);
          break label849;
          QLog.d("cmgame_process.CmGameUtil", 2, "launchGame current ActivityClass:" + localObject1);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          localObject2 = ajcq.jdField_a_of_type_ArrayOfJavaLangClass[0];
          break;
          localObject1 = new Intent(BaseApplicationImpl.getApplication(), (Class)localObject2);
          ((Intent)localObject1).putExtra("extra_startcheckparam", paramStartCheckParam);
          ((Intent)localObject1).addFlags(268435456);
          BaseApplicationImpl.getApplication().startActivity((Intent)localObject1);
          return;
          localObject1 = null;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    if (l - g < 1800000L) {}
    while ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    boolean bool = a(paramQQAppInterface.getApp());
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[preloadGameProcess] isProcessOn=", Boolean.valueOf(bool) });
    if (!bool)
    {
      paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(100);
      }
    }
    g = l;
  }
  
  public static void a(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] mainJsPath=", paramString });
    if (!TextUtils.isEmpty(paramString)) {
      jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!a()) {}
    ajdq localajdq;
    do
    {
      do
      {
        return;
      } while (!"apollo_aio_game.cancel_game_room".equals(paramString1));
      localajdq = a();
    } while (localajdq == null);
    localajdq.a(paramString1, paramString2, -1L, 4, false, null);
  }
  
  public static void a(Object... paramVarArgs)
  {
    aiwu localaiwu = a();
    if (localaiwu != null) {
      localaiwu.a("cmg_launch", 4, paramVarArgs);
    }
  }
  
  public static boolean a()
  {
    AppInterface localAppInterface = a();
    return (localAppInterface != null) && ((localAppInterface instanceof CmGameAppInterface));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1000;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    return (paramStartCheckParam != null) && (paramStartCheckParam.mGameType == 3);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject = (ajmw)paramQQAppInterface.getManager(155);
    ApolloGameData localApolloGameData = ((ajmw)localObject).a(paramStartCheckParam.gameId);
    airz localairz = (airz)paramQQAppInterface.getManager(153);
    if (localairz != null)
    {
      paramStartCheckParam.game = localApolloGameData;
      if ((localApolloGameData != null) && ((((ajmw)localObject).a(paramStartCheckParam.gameId)) || (paramStartCheckParam.isRequestConf))) {
        break label244;
      }
    }
    label244:
    for (boolean bool = true;; bool = false)
    {
      paramStartCheckParam.isNeedConfInfo = bool;
      paramStartCheckParam.version = localairz.a(paramStartCheckParam.gameId);
      localObject = paramQQAppInterface.getCurrentAccountUin();
      paramStartCheckParam.isWhiteUsr = localairz.c((String)localObject);
      paramStartCheckParam.apolloStatus = localairz.b((String)localObject);
      paramStartCheckParam.pushItem = localairz.a().a();
      paramStartCheckParam.mGameType = ApolloGameUtil.a(paramStartCheckParam.gameId);
      paramStartCheckParam.isGameRscExist = ApolloUtil.a(paramStartCheckParam.gameId);
      if (localApolloGameData != null) {
        paramStartCheckParam.viewMode = localApolloGameData.viewMode;
      }
      int i = ApolloGameUtil.a(paramStartCheckParam.gameId, paramStartCheckParam.mGameType);
      if (i != -1) {
        paramStartCheckParam.viewMode = i;
      }
      paramStartCheckParam.gender = ((aszd)paramQQAppInterface.getManager(106)).b();
      paramStartCheckParam.isEnableMSAA = c(paramStartCheckParam.gameId);
      paramStartCheckParam.mIsTransGame = ajmt.c.contains(Integer.valueOf(paramStartCheckParam.gameId));
      return true;
    }
  }
  
  public static boolean a(Object paramObject)
  {
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "encrypt, no key");
      return paramArrayOfByte;
    }
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static Class[] a(String paramString)
  {
    int i1 = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (TextUtils.isEmpty(paramString.trim())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i2 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int j = 0;
    int m;
    if (k < i2)
    {
      m = paramString.charAt(k);
      if (41 != m) {}
    }
    else
    {
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "paramList clsList:", localStringBuilder.toString() });
      }
      if (localArrayList.size() != 0) {
        break label760;
      }
      return null;
    }
    int n = k;
    int i = j;
    switch (m)
    {
    default: 
      i = j;
      n = k;
    }
    for (;;)
    {
      k = n + 1;
      j = i;
      break;
      localArrayList.add(Void.TYPE);
      n = k;
      i = j;
      continue;
      i = 1;
      n = k;
      continue;
      if (j != 0)
      {
        localArrayList.add([Z.class);
        i = 0;
        n = k;
      }
      else
      {
        localArrayList.add(Boolean.TYPE);
        n = k;
        i = j;
        continue;
        if (j != 0)
        {
          localArrayList.add([B.class);
          i = 0;
          n = k;
        }
        else
        {
          localArrayList.add(Byte.TYPE);
          n = k;
          i = j;
          continue;
          if (j != 0)
          {
            localArrayList.add([C.class);
            i = 0;
            n = k;
          }
          else
          {
            localArrayList.add(Character.TYPE);
            n = k;
            i = j;
            continue;
            if (j != 0)
            {
              localArrayList.add([S.class);
              i = 0;
              n = k;
            }
            else
            {
              localArrayList.add(Short.TYPE);
              n = k;
              i = j;
              continue;
              if (j != 0)
              {
                localArrayList.add([I.class);
                i = 0;
                n = k;
              }
              else
              {
                localArrayList.add(Integer.TYPE);
                n = k;
                i = j;
                continue;
                if (j != 0)
                {
                  localArrayList.add([J.class);
                  i = 0;
                  n = k;
                }
                else
                {
                  localArrayList.add(Long.TYPE);
                  n = k;
                  i = j;
                  continue;
                  if (j != 0)
                  {
                    localArrayList.add([F.class);
                    i = 0;
                    n = k;
                  }
                  else
                  {
                    localArrayList.add(Float.TYPE);
                    n = k;
                    i = j;
                    continue;
                    if (j != 0)
                    {
                      localArrayList.add([D.class);
                      i = 0;
                      n = k;
                    }
                    else
                    {
                      localArrayList.add(Double.TYPE);
                      n = k;
                      i = j;
                      continue;
                      n = k + 1;
                      k = n;
                      for (i = m; (k < i2) && (i != 59); i = paramString.charAt(k)) {
                        k += 1;
                      }
                      m = j;
                      try
                      {
                        Object localObject = paramString.substring(n, k);
                        m = j;
                        localStringBuilder.append("clsName:").append((String)localObject).append(",");
                        m = j;
                        String str = ((String)localObject).replace('/', '.');
                        i = j;
                        localObject = str;
                        if (j != 0)
                        {
                          m = j;
                          localObject = "[L" + str + ";";
                          i = 0;
                        }
                        m = i;
                        localArrayList.add(Class.forName((String)localObject));
                        n = k;
                      }
                      catch (Throwable localThrowable)
                      {
                        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
                        n = k;
                        i = m;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label760:
    paramString = new Class[localArrayList.size()];
    Iterator localIterator = localArrayList.iterator();
    i = i1;
    while (localIterator.hasNext())
    {
      paramString[i] = ((Class)localIterator.next());
      i += 1;
    }
    return paramString;
  }
  
  public static int b()
  {
    if (a() == null) {
      return 0;
    }
    airz localairz = (airz)a().getManager(153);
    if ((localairz != null) && (localairz.j())) {
      return 1;
    }
    return 0;
  }
  
  public static int b(int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append(ajmu.s).append(paramInt).append(File.separator).append("gameConfig.json");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "[getGameRscType], gameConfig.json NOT exist.");
        return 0;
      }
      localObject = new JSONObject(bbdj.b((File)localObject)).optJSONArray("subpackages");
      if (localObject != null)
      {
        paramInt = ((JSONArray)localObject).length();
        if (paramInt > 0) {
          return 1;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
    }
    return 0;
  }
  
  public static ajch b(int paramInt1, int paramInt2)
  {
    ajcq localajcq = a();
    if (localajcq == null) {
      return null;
    }
    return localajcq.b(paramInt1, paramInt2);
  }
  
  public static ajch b(long paramLong)
  {
    ajcq localajcq = a();
    if (localajcq == null) {
      return null;
    }
    return localajcq.a(paramLong);
  }
  
  public static String b(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = ajne.a(0, ajhw.a);
        if (localJSONObject1 == null)
        {
          QLog.e("cmgame_process.CmGameUtil", 1, "json is null");
          return "{}";
        }
        localJSONObject1.put("roomId", String.valueOf(paramCmGameInitParams.mRoomId));
        localJSONObject1.put("svrIp", paramCmGameInitParams.mServerIp);
        localJSONObject1.put("port", paramCmGameInitParams.mPort);
        localJSONObject1.put("spriteDesignHeight", 368);
        if (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))
        {
          localJSONObject1.put("gameId", paramCmGameInitParams.mGameName);
          if ((!ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) || (ApolloGameStateMachine.jdField_a_of_type_Aiye == null)) {
            break label999;
          }
          localJSONObject1.put("freeMemory", ApolloGameStateMachine.jdField_a_of_type_Aiye.jdField_b_of_type_Long);
          localJSONObject1.put("totalMemory", ApolloGameStateMachine.jdField_a_of_type_Aiye.jdField_c_of_type_Long);
          localJSONObject1.put("osVersion", aiye.jdField_a_of_type_JavaLangString);
          localJSONObject1.put("model", aiye.jdField_b_of_type_JavaLangString);
          localJSONObject1.put("cpuType", aiye.jdField_c_of_type_JavaLangString);
          localJSONObject1.put("cpuNumber", aiye.jdField_a_of_type_Int);
          localJSONObject1.put("cpuFrequency", aiye.jdField_a_of_type_Long);
          localJSONObject1.put("gameVersion", paramCmGameInitParams.mVersion);
          localJSONObject1.put("QQVer", "8.2.8.4440");
          localJSONObject1.put("platform", "android");
          localJSONObject1.put("gameMode", paramCmGameInitParams.mGameMode);
          if (!TextUtils.isEmpty(paramCmGameInitParams.openId)) {
            localJSONObject1.put("openId", paramCmGameInitParams.openId);
          }
          if (!TextUtils.isEmpty(paramCmGameInitParams.mRobotOpenId)) {
            localJSONObject1.put("robotOpenId", paramCmGameInitParams.mRobotOpenId);
          }
          str2 = paramCmGameInitParams.mGameParam;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = str2.contains("extendInfo");
            localObject = str2;
            if (!bool1) {}
          }
        }
      }
      catch (Exception paramCmGameInitParams)
      {
        Object localObject;
        JSONObject localJSONObject2;
        QLog.e("cmgame_process.CmGameUtil", 2, paramCmGameInitParams.getMessage());
        return "{}";
      }
      try
      {
        localJSONObject2 = new JSONObject(str2);
        localObject = str2;
        if (localJSONObject2.has("extendInfo")) {
          localObject = localJSONObject2.optString("extendInfo");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
        String str1 = str2;
        continue;
        localJSONObject1.put("aioType", paramCmGameInitParams.mSessionType);
        if (!paramCmGameInitParams.mIsMaster) {
          break label1145;
        }
        for (i = 1;; i = 0)
        {
          localJSONObject1.put("isMaster", i);
          break;
        }
        bool2 = false;
        bool1 = true;
        if (!bool1) {
          break label1171;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
      }
      localJSONObject1.put("gameParam", localObject);
      if (!paramCmGameInitParams.isWhiteUsr) {
        break label1166;
      }
      i = 1;
      localJSONObject1.put("isWhiteUser", i);
      localJSONObject1.put("src", paramCmGameInitParams.mSrc);
      localJSONObject1.put("networkType", 0);
      localJSONObject1.put("connType", bbev.a(BaseApplicationImpl.getContext()));
      localJSONObject1.put("accessTokenCode", paramCmGameInitParams.accessTokenRet);
      localJSONObject1.put("accessToken", paramCmGameInitParams.accessToken);
      localJSONObject1.put("commFlagBits", paramCmGameInitParams.commFlag);
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 4);
      if (localObject == null) {
        break label1150;
      }
      bool1 = ((SharedPreferences)localObject).getBoolean("is_ever_play_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false);
      bool2 = ((SharedPreferences)localObject).getBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, true);
      if (!bool2) {
        break label1157;
      }
      ((SharedPreferences)localObject).edit().putBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false).commit();
      break label1157;
      localJSONObject1.put("isFirstPlay", i);
      if (!bool2) {
        break label1176;
      }
      i = 1;
      localJSONObject1.put("isFirstInstall", i);
      localJSONObject1.put("sessionId", String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000)));
      if ((paramCmGameInitParams.mGameMode != 1) && (paramCmGameInitParams.mGameMode != 2)) {
        break;
      }
      localJSONObject1.put("aioType", 1);
      localJSONObject1.put("isMaster", 1);
      if ((!TextUtils.isEmpty(paramCmGameInitParams.mExtraStr)) && (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))) {
        localJSONObject1.put("extraStr", paramCmGameInitParams.mExtraStr);
      }
      localJSONObject1.put("sex", paramCmGameInitParams.gender);
      localJSONObject1.put("apolloStatus", paramCmGameInitParams.apolloStatus);
      localJSONObject1.put("gameType", paramCmGameInitParams.gameType);
      localJSONObject1.put("redUrl", paramCmGameInitParams.redUrl);
      if (paramCmGameInitParams.adForbidPosId != null) {
        localJSONObject1.put("adForbitPosId", paramCmGameInitParams.adForbidPosId);
      }
      localJSONObject1.put("transInfo", paramCmGameInitParams.transInfo);
      QLog.i("cmgame_process.CmGameUtil", 1, "gameId:" + paramCmGameInitParams.mGameName + ",gameMode:" + paramCmGameInitParams.mGameMode + ",src:" + paramCmGameInitParams.mSrc + ",roomId:" + paramCmGameInitParams.mRoomId);
      paramCmGameInitParams = localJSONObject1.toString();
      return paramCmGameInitParams;
      try
      {
        localJSONObject1.put("gameId", Integer.parseInt(paramCmGameInitParams.mGameName));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label999:
      localJSONObject1.put("freeMemory", bbct.a(Process.myPid()));
      localJSONObject1.put("totalMemory", bbct.f());
      localJSONObject1.put("osVersion", bbct.e());
      localJSONObject1.put("model", bbct.i());
      localJSONObject1.put("cpuType", bbct.g());
      localJSONObject1.put("cpuNumber", bbct.b());
      localJSONObject1.put("cpuFrequency", bbct.a());
    }
  }
  
  public static void b()
  {
    if (a(BaseApplicationImpl.getContext())) {}
    Object localObject;
    do
    {
      int i;
      do
      {
        return;
        QLog.d("cmgame_process.CmGameUtil", 1, "onGameCrashed");
        localObject = (airz)a().getManager(153);
        if ((localObject != null) && (((airz)localObject).k())) {
          ((airz)localObject).a().b();
        }
        i = a();
      } while (-1 == i);
      localObject = aizw.a().a(i);
    } while (localObject == null);
    ((ajcm)localObject).c();
  }
  
  public static void b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramInt);
      ((bbqp)a().getBusinessHandler(71)).a("apollo_router_game.game_extend_linkcmd_set_plus_flag", localJSONObject.toString(), -1L, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, paramString, -1L, localIntent, false, -1);
  }
  
  public static void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, "[openLoadingInMainProc]");
    if (paramStartCheckParam == null) {
      return;
    }
    Intent localIntent;
    try
    {
      e = SystemClock.uptimeMillis();
      localIntent = new Intent(BaseApplicationImpl.getApplication(), CmGameLoadingFragment.class);
      localIntent.putExtra("extra_startcheckparam", paramStartCheckParam);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.addFlags(268435456);
      if (paramStartCheckParam.notFullScreen)
      {
        PublicFragmentActivity.a(BaseApplicationImpl.getApplication(), localIntent, CmGameLoadingFragment.class);
        return;
      }
    }
    catch (Exception paramStartCheckParam)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[openLoadingInMainProc] exception=", paramStartCheckParam);
      return;
    }
    PublicTransFragmentActivity.b(BaseApplicationImpl.getApplication(), localIntent, CmGameLoadingFragment.class);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[putMainJsToCache] sEnableMainJsCache=", Boolean.valueOf(jdField_a_of_type_Boolean), ", mainJsPath=", paramString1 });
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString1, paramString2);
    }
  }
  
  public static boolean b()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getRingerMode();
        if (i == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "isRingerVibrate error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 3112;
  }
  
  public static boolean b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    return (paramStartCheckParam != null) && (paramStartCheckParam.gameId == 4698);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "decrypt, no key");
      return paramArrayOfByte;
    }
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(2, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static int c()
  {
    if (a() == null) {
      return 0;
    }
    airz localairz = (airz)a().getManager(153);
    if ((localairz != null) && (localairz.f)) {
      return 1;
    }
    return 0;
  }
  
  public static void c(int paramInt)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] gameId=", Integer.valueOf(paramInt) });
    a(ApolloUtil.a(paramInt));
  }
  
  public static boolean c()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getStreamVolume(2);
        if (i == 0) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "isRingEqualsZero error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = true;
    try
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append(ajmu.s).append(paramInt).append(File.separator).append("gameConfig.json");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "[isMSAAEnabled], gameConfig.json NOT exist.");
        return false;
      }
      int i = new JSONObject(bbdj.b((File)localObject)).optInt("enableMSAA");
      QLog.i("cmgame_process.CmGameUtil", 1, "[mobile_performance],enableMSAA:" + i + ",gameId:" + paramInt);
      if (i == 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
    }
  }
  
  public static final int d()
  {
    int i;
    if (NetworkState.isWifiConn()) {
      i = 4;
    }
    String str;
    do
    {
      int j;
      do
      {
        return i;
        j = 0;
        str = bfmw.b("7411ce");
        i = j;
      } while (TextUtils.isEmpty(str));
      if ((str.startsWith("46000")) || (str.startsWith("46002"))) {
        return 1;
      }
      if (str.startsWith("46001")) {
        return 2;
      }
      i = j;
    } while (!str.startsWith("46003"));
    return 3;
  }
  
  public static boolean d()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public static int e()
  {
    int i = 2;
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = bbct.b();
    }
    if (jdField_a_of_type_Float < 0.0F) {
      jdField_a_of_type_Float = (float)bbct.a() / 1.0F / 1024.0F;
    }
    if (d < 0L) {
      d = Math.ceil(bbct.d() / 1073741824.0D);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[mobile_performance],cpuCoreNumber:", Integer.valueOf(jdField_a_of_type_Int), ",cpuFrequency:", Float.valueOf(jdField_a_of_type_Float), ",totalMemory:", Long.valueOf(d) });
    }
    if ((d >= 4.0D) && (jdField_a_of_type_Int >= 4) && (jdField_a_of_type_Float > 1.5D)) {
      i = 1;
    }
    for (;;)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "[mobile_performance],level:" + i);
      return i;
      if ((d >= 3.0D) && (d <= 4.0D) && (jdField_a_of_type_Int >= 4))
      {
        if (d < 4.0D)
        {
          if (jdField_a_of_type_Float <= 1.5D) {
            i = 3;
          }
        }
        else if (d != 4.0D) {
          i = 3;
        }
      }
      else {
        i = 3;
      }
    }
  }
  
  public static boolean e()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - jdField_a_of_type_Long;
    if ((0L < l2) && (l2 < 1000L)) {
      return true;
    }
    jdField_a_of_type_Long = l1;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajae
 * JD-Core Version:    0.7.0.1
 */