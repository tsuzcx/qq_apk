import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.2;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.4;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.6;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.7;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.8;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.9;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ajcf
  implements aitj, aivc, Handler.Callback, View.OnKeyListener
{
  public int a;
  public long a;
  private aabl jdField_a_of_type_Aabl;
  private aiyl jdField_a_of_type_Aiyl;
  private ajaf jdField_a_of_type_Ajaf;
  private ajaw jdField_a_of_type_Ajaw;
  private ajba jdField_a_of_type_Ajba;
  private ajbm jdField_a_of_type_Ajbm;
  private ajbo jdField_a_of_type_Ajbo;
  private ajcb jdField_a_of_type_Ajcb;
  private ajcj jdField_a_of_type_Ajcj;
  private ajcs jdField_a_of_type_Ajcs;
  private ajct jdField_a_of_type_Ajct;
  private ajcx jdField_a_of_type_Ajcx;
  private ajdf jdField_a_of_type_Ajdf;
  private ajdy jdField_a_of_type_Ajdy;
  private ajnl jdField_a_of_type_Ajnl;
  private ajon jdField_a_of_type_Ajon = new ajci(this);
  private ajrd jdField_a_of_type_Ajrd;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ajcg(this);
  private bfob jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  private IApolloRunnableTask jdField_a_of_type_ComTencentMobileqqApolloIApolloRunnableTask = new CmGameLauncher.7(this);
  private ApolloCmdChannel jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  public WeakReference<Activity> a;
  private HashMap<Integer, ApolloFloatActivity> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  private ajaw jdField_b_of_type_Ajaw;
  private IApolloRunnableTask jdField_b_of_type_ComTencentMobileqqApolloIApolloRunnableTask = new CmGameLauncher.8(this);
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private boolean c;
  public int d;
  private boolean d;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 1;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public ajcf(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    QLog.i("cmgame_process.CmGameLauncher", 1, "[CmGameLauncher], gameId:" + paramInt);
    bbdh.a();
    ajco localajco = ajac.a();
    if (localajco != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel = localajco.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.makesureHasInitObj();
    }
    this.jdField_a_of_type_Ajrd = new ajrd();
    this.jdField_a_of_type_Ajct = new ajct(paramInt);
    this.jdField_e_of_type_Int = paramInt;
    ajcy.a();
    this.jdField_a_of_type_Ajdf = new ajdf(paramInt);
    this.jdField_a_of_type_Ajaf = new ajaf(paramInt);
  }
  
  private void c(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (!TextUtils.isEmpty(paramStartCheckParam.extendJson))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramStartCheckParam.extendJson);
      this.jdField_a_of_type_Ajcj = new ajcj();
      this.jdField_a_of_type_Ajcj.g = localJSONObject.optString("payParam");
      paramStartCheckParam.gameTypeForRedPacket = localJSONObject.optInt("gameType", 0);
      paramStartCheckParam.redUrl = localJSONObject.optString("redUrl", "");
      this.jdField_a_of_type_Ajcj.jdField_a_of_type_Int = localJSONObject.optInt("score", -1);
      this.jdField_a_of_type_Ajcj.jdField_c_of_type_JavaLangString = localJSONObject.optString("baseUrl");
      this.jdField_a_of_type_Ajcj.b = localJSONObject.optString("listId");
      this.jdField_a_of_type_Ajcj.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      if (ajac.a() != null) {
        this.jdField_a_of_type_Ajcj.jdField_a_of_type_Long = Long.parseLong(ajac.a().getCurrentAccountUin());
      }
      this.jdField_a_of_type_Ajcj.e = localJSONObject.optString("nickName", String.valueOf(this.jdField_a_of_type_Ajcj.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 1, "[setRedPacketInfo] " + this.jdField_a_of_type_Ajcj.toString());
      }
      return;
    }
    catch (JSONException paramStartCheckParam)
    {
      paramStartCheckParam.printStackTrace();
    }
  }
  
  private void k()
  {
    ThreadManagerV2.excute(new CmGameLauncher.2(this), 16, null, false);
  }
  
  private void l()
  {
    ThreadManagerV2.excute(new CmGameLauncher.3(this), 16, null, false);
  }
  
  private void m()
  {
    Activity localActivity = a();
    if (localActivity == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new CmGameLauncher.4(this, localActivity));
  }
  
  private void n()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "game surface view is not ready.");
      ajac.a(new Object[] { "[startGameEngine], game is not ready, so status:", Boolean.valueOf(this.k) });
    }
    for (;;)
    {
      return;
      Object localObject1;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath)) || (!bbdx.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "mGameParams error");
        }
        localObject1 = a();
        if ((localObject1 == null) || (!(localObject1 instanceof ApolloGameActivity))) {
          continue;
        }
        ((ApolloGameActivity)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, -16);
        return;
      }
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        if (this.i)
        {
          QLog.w("cmgame_process.CmGameLauncher", 1, "has ready startGameEngine");
          return;
        }
        this.i = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.init_global_var.local", ajac.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameName(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameStatListener(this);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.onEnterGame(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath);
        int m = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mSrc;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          break label516;
        }
        localObject1 = "-1";
        label241:
        VipUtils.a(null, "cmshow", "Apollo", "initialize_game", m, 0, new String[] { localObject2, localObject1 });
        p();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "handleMessage onEnterGame");
        }
        if (this.jdField_a_of_type_Ajnl != null) {
          this.jdField_a_of_type_Ajnl.a();
        }
      }
      try
      {
        if (b()) {
          ajac.a().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
        }
        for (;;)
        {
          o();
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          long l = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_open_to_start_engine, duration=", Long.valueOf(l), ", mStartGameEngineTs=", Long.valueOf(this.jdField_a_of_type_Long), ", mOpenCmGameTs=", Long.valueOf(this.jdField_b_of_type_Long), ", gameId=", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName });
          ajac.a(new Object[] { "[startGameEngine] cost:", Long.valueOf(l) });
          if (l <= 0L) {
            break;
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_gameId", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName);
          localObject2 = ajac.a();
          if (localObject2 == null) {
            break;
          }
          axrn.a(((AppInterface)localObject2).getApp()).a(((AppInterface)localObject2).getCurrentAccountUin(), "cmgame_open_to_start_engine", true, l, 0L, (HashMap)localObject1, "", false);
          return;
          label516:
          localObject1 = String.valueOf(aiye.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson));
          break label241;
          ajac.a().callbackFromRequest(a(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
        }
      }
    }
  }
  
  private void o()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.isWhiteUsr) {}
    for (;;)
    {
      return;
      try
      {
        if (BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0).getBoolean("game_storage_switch", false))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender();
          Object localObject = ApolloRender.getUserPath(this.jdField_e_of_type_Int);
          if (localObject != null)
          {
            localObject = new File((String)localObject);
            if (((File)localObject).exists())
            {
              ((File)localObject).delete();
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
      }
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[showImmersiveMode] show fullscreen.");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity)))
    {
      Object localObject = (ChatFragment)((FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null) {
          ((BaseChatPie)localObject).al();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setSystemUiVisibility(this.jdField_a_of_type_Int);
    }
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public aabl a(long paramLong, Activity paramActivity)
  {
    if (this.jdField_a_of_type_Aabl != null) {
      return this.jdField_a_of_type_Aabl;
    }
    aabq.a();
    this.jdField_a_of_type_Aabl = aabq.a(paramActivity, 5, String.valueOf(paramLong));
    QLog.i("cmgame_process.CmGameLauncher", 1, "create API manager.");
    return this.jdField_a_of_type_Aabl;
  }
  
  public ajaf a()
  {
    return this.jdField_a_of_type_Ajaf;
  }
  
  public ajaw a()
  {
    return this.jdField_a_of_type_Ajaw;
  }
  
  public ajcj a()
  {
    return this.jdField_a_of_type_Ajcj;
  }
  
  public ajct a()
  {
    return this.jdField_a_of_type_Ajct;
  }
  
  public ajcx a()
  {
    if ((this.jdField_a_of_type_Ajcx == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null)) {
      this.jdField_a_of_type_Ajcx = new ajcx(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return this.jdField_a_of_type_Ajcx;
  }
  
  public ajdf a()
  {
    return this.jdField_a_of_type_Ajdf;
  }
  
  public ajdy a()
  {
    return this.jdField_a_of_type_Ajdy;
  }
  
  public ajei a()
  {
    Activity localActivity = a();
    if (!(localActivity instanceof ApolloGameActivity))
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "[playAdsVideo], not ApolloGameActivity");
      return null;
    }
    return ((ApolloGameActivity)localActivity).a();
  }
  
  public ajrd a()
  {
    return this.jdField_a_of_type_Ajrd;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public ApolloSurfaceView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  }
  
  public CmGameStartChecker.StartCheckParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  }
  
  public CmGameInitParams a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  }
  
  public void a()
  {
    Activity localActivity = a();
    if ((localActivity != null) && ((localActivity instanceof ApolloGameActivity))) {
      ((ApolloGameActivity)localActivity).h();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[closeWeb], taskId:", Integer.valueOf(paramInt) });
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        ApolloFloatActivity localApolloFloatActivity = (ApolloFloatActivity)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
        if ((localApolloFloatActivity != null) && (!localApolloFloatActivity.isFinishing()))
        {
          localApolloFloatActivity.finish();
          QLog.i("cmgame_process.CmGameLauncher", 1, "succeed to close web activity.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1))
        {
          localObject = a();
          if ((localObject != null) && ((localObject instanceof ApolloGameActivity)) && (!((Activity)localObject).isFinishing()))
          {
            localObject = ((ApolloGameActivity)localObject).a();
            if (localObject != null) {
              ((WebGameFakeView)localObject).a(paramInt1, this.jdField_e_of_type_Int, paramInt3, paramInt2);
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
        {
          if (paramInt1 == -1)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), -1, "sc.share_game_to_friend_result.local", "{}");
            return;
          }
          localObject = new ajda();
          ((ajda)localObject).jdField_e_of_type_Int = paramInt1;
          ((ajda)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
          ((ajda)localObject).jdField_a_of_type_Int = this.jdField_e_of_type_Int;
          ((ajda)localObject).d = paramInt2;
          ((ajda)localObject).jdField_c_of_type_Int = paramInt3;
          ((ajda)localObject).jdField_a_of_type_JavaLangString = paramString;
          ((ajda)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult],gameShareResult:", localObject });
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("reqCode", this.jdField_c_of_type_Int);
          this.jdField_c_of_type_Int = 0;
          localJSONObject.put("ret", paramInt1);
          localJSONObject.put("gameId", this.jdField_e_of_type_Int);
          localJSONObject.put("aioType", paramInt3);
          localJSONObject.put("shareTo", paramInt2);
          if (!ajcy.a().a((ajda)localObject)) {
            break label425;
          }
          paramInt3 = 0;
          localJSONObject.put("isFirstTimeShare", paramInt3);
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult] engine root:", localJSONObject.toString() });
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.share_game_to_friend_result.local", localJSONObject.toString());
          ajcy.a().a((ajda)localObject);
        }
        if ((this.jdField_a_of_type_Ajcb == null) || (!this.jdField_a_of_type_Ajcb.a())) {
          break label430;
        }
        paramInt3 = 1;
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, paramString, new Object[0]);
        return;
      }
      VipUtils.a(null, "cmshow", "Apollo", (String)localObject, 0, paramInt1, new String[] { String.valueOf(this.jdField_e_of_type_Int), paramString });
      return;
      label425:
      paramInt3 = 1;
      continue;
      label430:
      paramInt3 = 0;
      label435:
      for (Object localObject = "sendShowOffButtonSuccessful"; paramInt1 != 0; localObject = "sendUniversialFrameShareButtonSuccessful")
      {
        paramInt1 = 4;
        break;
        if (paramInt3 == 0) {
          break label435;
        }
      }
      paramInt1 = paramInt2;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[sendMsgToTargetG");
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        ApolloFloatActivity localApolloFloatActivity = (ApolloFloatActivity)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localApolloFloatActivity.a != null)
        {
          paramString = new JSONObject(paramString);
          paramString = "window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + nau.a("apolloGameWebMessage") + "," + String.valueOf(paramString) + "," + String.valueOf("") + ");";
          localApolloFloatActivity.a.callJs(paramString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, paramString, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.a(paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    Activity localActivity = a();
    if ((localActivity != null) && ((localActivity instanceof ApolloGameActivity))) {
      ((ApolloGameActivity)localActivity).b(paramLong);
    }
  }
  
  public void a(aiyl paramaiyl)
  {
    this.jdField_a_of_type_Aiyl = paramaiyl;
    this.jdField_g_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addRenderRunner(paramaiyl);
    }
  }
  
  public void a(ajee paramajee)
  {
    if (paramajee == null) {}
    ajei localajei;
    do
    {
      return;
      localajei = a();
    } while (localajei == null);
    localajei.a(paramajee);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    if (this.jdField_a_of_type_Ajdf != null) {
      this.jdField_a_of_type_Ajdf.a(paramActivity);
    }
    this.jdField_a_of_type_Ajcb = new ajcb(a(), ajac.a());
    this.jdField_a_of_type_Ajcb.a(null, this.jdField_e_of_type_Int);
  }
  
  public void a(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams == null) || (paramActivity == null)) {
      QLog.e("cmgame_process.CmGameLauncher", 2, "[openCmGame] parmas is null!");
    }
    do
    {
      return;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      this.jdField_a_of_type_Bfob.sendEmptyMessage(204);
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameLauncher", 2, "openCmGame params:" + paramCmGameInitParams);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      QLog.e("cmgame_process.CmGameLauncher", 2, "[openCmGame] parmas is null!");
    }
    long l;
    do
    {
      do
      {
        return;
        l = SystemClock.uptimeMillis();
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
        if (!ajom.a())
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, "engine is not ready.");
          ajom.b(this.jdField_a_of_type_Ajon);
          ajom.a(this.jdField_a_of_type_Ajon);
          ajom.a("CmGameLauncher");
          return;
        }
        ajom.b(this.jdField_a_of_type_Ajon);
        a(paramActivity);
        a(paramActivity);
        this.jdField_a_of_type_Ajnl = new ajnl(this.jdField_e_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
          break label562;
        }
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContextRef=null");
      return;
      if (this.jdField_a_of_type_Ajdy == null) {
        this.jdField_a_of_type_Ajdy = new ajdy((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_e_of_type_Int);
      }
      paramActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext=null");
    return;
    if (paramActivity.isFinishing())
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext is isFinishing");
      return;
    }
    boolean bool2;
    try
    {
      if (paramActivity.isDestroyed())
      {
        QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext not isDestroyed");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      bool2 = ajac.a(this.jdField_e_of_type_Int);
      if (!bool2) {}
    }
    label562:
    label755:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("cmgame_process.CmGameLauncher", 1, new Object[] { "[initGameUI] mGameId=", Integer.valueOf(this.jdField_e_of_type_Int), ", isIsland=", Boolean.valueOf(bool2), ", isTransparent=", Boolean.valueOf(bool1) });
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramActivity, null, bool2, paramBoolean, bool1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameId(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(this, 1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setTouchMode(1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setFrameNum(60);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setMainLoadingGameMode(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess);
      }
      this.jdField_f_of_type_Int = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
      this.jdField_a_of_type_Int = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
      for (;;)
      {
        try
        {
          if ((paramActivity instanceof ApolloGameActivity))
          {
            ((ApolloGameActivity)paramActivity).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addRenderRunner(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setOnKeyListener(this);
            if (this.jdField_a_of_type_Ajbo != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Ajbo);
            }
            if (this.jdField_a_of_type_Ajba != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Ajba);
            }
            this.jdField_a_of_type_Ajbo = new ajbo(this.jdField_e_of_type_Int, paramActivity);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Ajbo);
            this.jdField_a_of_type_Ajba = new ajba(this.jdField_e_of_type_Int);
            this.jdField_a_of_type_Ajbm = new ajbm(this);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Ajba);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Ajbm);
            if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker() != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker().jdField_b_of_type_Int = this.jdField_e_of_type_Int;
            }
            paramActivity = a();
            if ((paramActivity != null) && ((paramActivity instanceof ApolloGameActivity))) {
              ((ApolloGameActivity)paramActivity).a(SystemClock.uptimeMillis() - l);
            }
            this.jdField_g_of_type_Boolean = true;
            QLog.i("cmgame_process.CmGameLauncher", 2, "[initGameUI] gameId:" + this.jdField_e_of_type_Int);
            return;
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mIsTransGame)) {
              break label755;
            }
            bool1 = true;
            break;
          }
          if ((paramActivity instanceof ApolloWebGameActivity)) {
            ((ApolloWebGameActivity)paramActivity).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          } else {
            QLog.e("cmgame_process.CmGameLauncher", 1, "[initGameUI] launch from other activity, check it, activity=" + paramActivity);
          }
        }
        catch (Exception paramActivity)
        {
          QLog.e("cmgame_process.CmGameLauncher", 2, paramActivity, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
          return;
        }
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.j = true;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Ajcb != null) {
      this.jdField_a_of_type_Ajcb.a(paramBitmap, this.jdField_e_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "checkShareDefaultPic bitmap:" + paramBitmap);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    long l1 = 0L;
    if (paramBundle == null) {}
    Activity localActivity;
    do
    {
      long l2;
      CmGameInitParams localCmGameInitParams;
      do
      {
        return;
        l2 = paramBundle.getLong("ResultCode");
        localCmGameInitParams = (CmGameInitParams)paramBundle.getSerializable("CmGameInitParams");
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "onCmGameCheckGameRsp cmGameInitParams", localCmGameInitParams });
        }
        localActivity = a();
        if ((l2 != 0L) || (localCmGameInitParams == null)) {
          break;
        }
      } while (!(localActivity instanceof ApolloGameActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
      for (;;)
      {
        paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        b(paramBundle);
        ajac.a(new Object[] { "[checkFinish], loading from main process and tool process is on, before cost:", Long.valueOf(l1) });
        ((ApolloGameActivity)localActivity).a(paramBundle);
        ((ApolloGameActivity)localActivity).a(localCmGameInitParams);
        return;
        l1 = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs;
      }
      QLog.e("cmgame_process.CmGameLauncher", 1, new Object[] { "onCmGameCheckGameRsp resultCode:", Long.valueOf(l2) });
      if ((localActivity instanceof ApolloGameActivity)) {
        ((ApolloGameActivity)localActivity).i();
      }
    } while (localActivity == null);
    localActivity.finish();
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    c(paramStartCheckParam);
  }
  
  public void a(ApolloFloatActivity paramApolloFloatActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[setWebViewObj], taskId:", Integer.valueOf(paramInt), ",web:", paramApolloFloatActivity });
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramApolloFloatActivity);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    ajei localajei;
    do
    {
      return;
      localajei = a();
    } while (localajei == null);
    localajei.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.h)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setCanDraw(true);
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null)) || ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.j)) {}
    try
    {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "unRegisterScreenBroadcast error e=" + localThrowable.toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Ajaw == null)
    {
      if (paramInt != 0) {
        break label52;
      }
      this.jdField_a_of_type_Ajaw = new ajai(ajac.a(), this.jdField_e_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Ajaw == null) {
        this.jdField_b_of_type_Ajaw = new ajal(this.jdField_a_of_type_Ajbm);
      }
      return;
      label52:
      if (1 == paramInt) {
        this.jdField_a_of_type_Ajaw = new ajat(this.jdField_e_of_type_Int);
      }
    }
  }
  
  public void b(long paramLong)
  {
    Activity localActivity = a();
    if ((localActivity != null) && ((localActivity instanceof ApolloGameActivity))) {
      ((ApolloGameActivity)localActivity).c(paramLong);
    }
  }
  
  public void b(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    this.jdField_a_of_type_Ajcb = new ajcb(a(), ajac.a());
    this.jdField_a_of_type_Ajcb.a(null, this.jdField_e_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      this.jdField_a_of_type_Ajbo = new ajbo(this.jdField_e_of_type_Int, paramActivity);
      if (this.jdField_a_of_type_Ajba != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Ajba);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Ajbo);
      this.jdField_a_of_type_Ajba = new ajba(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Ajba);
    }
    int m;
    label152:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null)
      {
        m = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
          break label219;
        }
        paramCmGameInitParams = "-1";
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          break label230;
        }
        str = "-1";
        label164:
        VipUtils.a(null, "cmshow", "Apollo", "initialize_game", m, 0, new String[] { paramCmGameInitParams, str });
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajdf != null) {
        this.jdField_a_of_type_Ajdf.a(paramActivity);
      }
      return;
      m = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mSrc;
      break;
      label219:
      paramCmGameInitParams = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName;
      break label152;
      label230:
      str = String.valueOf(aiye.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson));
      break label164;
      QLog.e("cmgame_process.CmGameLauncher", 1, "[initContext] para is null");
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)) {
      return;
    }
    if ((paramStartCheckParam.statMap != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null))
    {
      if (paramStartCheckParam.statMap.containsKey("download_confirm")) {
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("download_confirm", paramStartCheckParam.statMap.get("download_confirm"));
      }
      if (paramStartCheckParam.statMap.containsKey("download_game_res")) {
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("download_game_res", paramStartCheckParam.statMap.get("download_game_res"));
      }
    }
    paramStartCheckParam.statMap = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap;
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public void b(String paramString)
  {
    QLog.d("cmgame_process.CmGameLauncher", 1, "shareGameInMenu ");
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, 0, "sc.game_shell_share.local", "{}");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_share.local", "{}");
      }
      this.jdField_a_of_type_Bfob.removeMessages(203);
      Message localMessage = this.jdField_a_of_type_Bfob.obtainMessage(203);
      localMessage.obj = paramString;
      this.jdField_a_of_type_Bfob.sendMessageDelayed(localMessage, 1000L);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 1, "sendGameShareMsg reqData is empty");
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Int == 1;
  }
  
  public void c()
  {
    ajei localajei = a();
    if (localajei != null) {
      localajei.b(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof ApolloGameActivity)))
    {
      ApolloGameActivity localApolloGameActivity = (ApolloGameActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 3)) {
        localApolloGameActivity.getWindow().getDecorView().setSystemUiVisibility(paramInt);
      }
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRuntimeState(), 0, "sc.web_callback_game.local", paramString);
        return;
      }
      QLog.e("cmgame_process.CmGameLauncher", 1, "[sendMessageToGame] gameview null");
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 1, "[sendMessageToGame] channel null");
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (!this.h);
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ajba != null) {
      this.jdField_a_of_type_Ajba.c();
    }
    ApolloCmdChannel localApolloCmdChannel = ajac.a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      ApolloGameStateMachine.a().a(3, "CmGame.onResume");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (localApolloCmdChannel != null))
    {
      if (this.jdField_a_of_type_Ajaw != null) {
        this.jdField_a_of_type_Ajaw.b();
      }
      if (this.jdField_b_of_type_Ajaw != null) {
        this.jdField_b_of_type_Ajaw.b();
      }
      if (localApolloCmdChannel != null)
      {
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_maximize.local", "{}");
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_foreground.local", "{}");
      }
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), paramInt, "sc.send_b2c_redpacket_result.local", "{}");
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Bfob.removeMessages(203);
    if (((!this.jdField_b_of_type_Boolean) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("inner")))) && (this.jdField_a_of_type_Ajcb != null))
    {
      boolean bool = this.jdField_e_of_type_Boolean;
      this.jdField_a_of_type_Bfob.post(new CmGameLauncher.9(this, paramString, bool));
    }
    QLog.d("cmgame_process.CmGameLauncher", 1, new Object[] { "handleShareMsgCallbackFromEngine mHadHandleShareMsg:", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "reqData:" + paramString);
    }
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ajba != null) {
      this.jdField_a_of_type_Ajba.b();
    }
    if (this.jdField_a_of_type_Ajaw != null) {
      this.jdField_a_of_type_Ajaw.a();
    }
    if (this.jdField_b_of_type_Ajaw != null) {
      this.jdField_b_of_type_Ajaw.a();
    }
    ApolloCmdChannel localApolloCmdChannel = ajac.a();
    if ((localApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_background.local", "{}");
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shareType", paramInt);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, 0, "sc.game_shell_share.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
    }
  }
  
  public void f()
  {
    b();
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.jdField_a_of_type_Bfob.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ajaw != null) {
      this.jdField_a_of_type_Ajaw.c();
    }
    if (this.jdField_b_of_type_Ajaw != null) {
      this.jdField_b_of_type_Ajaw.c();
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {
      g();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.i = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
      if (this.jdField_a_of_type_Ajcs != null) {}
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Ajcs);
        if (this.jdField_a_of_type_Ajnl != null) {
          this.jdField_a_of_type_Ajnl.b();
        }
        if (this.jdField_a_of_type_Ajcb != null) {
          this.jdField_a_of_type_Ajcb.a();
        }
        if (this.jdField_a_of_type_Aabl != null) {
          this.jdField_a_of_type_Aabl.b();
        }
        if (this.jdField_a_of_type_Ajdy != null) {
          this.jdField_a_of_type_Ajdy.a();
        }
        if (this.jdField_a_of_type_Ajaf != null) {
          this.jdField_a_of_type_Ajaf.a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy");
        }
        return;
        this.jdField_a_of_type_Bfob.obtainMessage(202).sendToTarget();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy in AsyncThread");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  public void g()
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[destroyGameView]");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      c(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setOnDestroyCloseGame(true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().c();
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent() != null)
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent() instanceof ViewGroup)) {
          break label231;
        }
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
        {
          if (this.jdField_a_of_type_Aiyl != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeRenderRunner(this.jdField_a_of_type_Aiyl);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeRenderRunner(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          }
          if (this.jdField_a_of_type_Ajbo != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Ajbo);
          }
          if (this.jdField_a_of_type_Ajba != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Ajba);
          }
          if (this.jdField_a_of_type_Ajba != null) {
            this.jdField_a_of_type_Ajba.d();
          }
          if (this.jdField_a_of_type_Ajbm != null)
          {
            this.jdField_a_of_type_Ajbm.a();
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Ajbm);
          }
        }
        return;
        label231:
        ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getContext().getSystemService("window")).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "destroyGameView windowManager.removeView(mApolloGameView)");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ajaw != null) {
      this.jdField_a_of_type_Ajaw.a();
    }
    if (this.jdField_b_of_type_Ajaw != null) {
      this.jdField_b_of_type_Ajaw.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      if (this.jdField_a_of_type_Ajba != null) {
        this.jdField_a_of_type_Ajba.a(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_minimize.local", "{}");
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_pack_up.local", "{}");
      }
    }
    ajbu.a("cs.make_room_min.local", "{}", false, null, this.jdField_e_of_type_Int);
    if ((ajac.a() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
      ajac.a(this.jdField_e_of_type_Int, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "onBackEvent");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 201: 
    default: 
    case 204: 
      do
      {
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null);
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
        a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mIsEnableMSAA);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mScreenMode == 0) && (Build.VERSION.SDK_INT >= 19))
      {
        this.jdField_a_of_type_Int = 5894;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.uiOptions = this.jdField_a_of_type_Int;
        }
        c(this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Boolean) {
        n();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("cmgame_process.CmGameLauncher", 2, "openCmGame screenMode:" + this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mScreenMode);
        return false;
        this.jdField_f_of_type_Boolean = true;
      }
    case 200: 
      n();
      return false;
    case 202: 
      f();
      return false;
    }
    if ((paramMessage.obj instanceof String))
    {
      if ((this.jdField_a_of_type_Ajcb == null) || (!this.jdField_a_of_type_Ajcb.a(this.jdField_e_of_type_Int))) {
        break label271;
      }
      this.jdField_a_of_type_Ajcb.a((String)paramMessage.obj, this.jdField_e_of_type_Int, this.jdField_e_of_type_Boolean);
      this.jdField_e_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return false;
      label271:
      ajnc.a(this.jdField_e_of_type_Int, (String)paramMessage.obj, a());
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_close.local", "{}");
    }
    ajbu.a("cs.close_room.local", "{}", false, null, this.jdField_e_of_type_Int);
  }
  
  public void j()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_query_check_game_data", localBundle, new ajch(this));
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      QLog.i("cmgame_process.CmGameLauncher", 1, "[KEYCODE_BACK]");
      paramView = ajac.a();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.runRenderTask(new CmGameLauncher.6(this, paramView));
        return true;
      }
    }
    return false;
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_Bfob.sendEmptyMessage(200);
        this.jdField_f_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsGameReady = true;
      }
      this.jdField_a_of_type_Ajcs = new ajcs(this.jdField_e_of_type_Int);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Ajcs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcf
 * JD-Core Version:    0.7.0.1
 */