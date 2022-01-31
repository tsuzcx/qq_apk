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

public class akyg
  implements akpk, akrd, Handler.Callback, View.OnKeyListener
{
  public int a;
  public long a;
  private abwx jdField_a_of_type_Abwx;
  private akum jdField_a_of_type_Akum;
  private akwg jdField_a_of_type_Akwg;
  private akwx jdField_a_of_type_Akwx;
  private akxb jdField_a_of_type_Akxb;
  private akxn jdField_a_of_type_Akxn;
  private akxp jdField_a_of_type_Akxp;
  private akyc jdField_a_of_type_Akyc;
  private akyk jdField_a_of_type_Akyk;
  private akyt jdField_a_of_type_Akyt;
  private akyu jdField_a_of_type_Akyu;
  private akyy jdField_a_of_type_Akyy;
  private akzg jdField_a_of_type_Akzg;
  private akzz jdField_a_of_type_Akzz;
  private aljn jdField_a_of_type_Aljn;
  private alkp jdField_a_of_type_Alkp = new akyj(this);
  private alnf jdField_a_of_type_Alnf;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new akyh(this);
  private bhtd jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
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
  private akwx jdField_b_of_type_Akwx;
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
  
  public akyg(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    QLog.i("cmgame_process.CmGameLauncher", 1, "[CmGameLauncher], gameId:" + paramInt);
    bdgk.a();
    akyp localakyp = akwd.a();
    if (localakyp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel = localakyp.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.makesureHasInitObj();
    }
    this.jdField_a_of_type_Alnf = new alnf();
    this.jdField_a_of_type_Akyu = new akyu(paramInt);
    this.jdField_e_of_type_Int = paramInt;
    akyz.a();
    this.jdField_a_of_type_Akzg = new akzg(paramInt);
    this.jdField_a_of_type_Akwg = new akwg(paramInt);
  }
  
  private void c(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (!TextUtils.isEmpty(paramStartCheckParam.extendJson))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramStartCheckParam.extendJson);
      this.jdField_a_of_type_Akyk = new akyk();
      this.jdField_a_of_type_Akyk.g = localJSONObject.optString("payParam");
      paramStartCheckParam.gameTypeForRedPacket = localJSONObject.optInt("gameType", 0);
      paramStartCheckParam.redUrl = localJSONObject.optString("redUrl", "");
      this.jdField_a_of_type_Akyk.jdField_a_of_type_Int = localJSONObject.optInt("score", -1);
      this.jdField_a_of_type_Akyk.jdField_c_of_type_JavaLangString = localJSONObject.optString("baseUrl");
      this.jdField_a_of_type_Akyk.b = localJSONObject.optString("listId");
      this.jdField_a_of_type_Akyk.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      if (akwd.a() != null) {
        this.jdField_a_of_type_Akyk.jdField_a_of_type_Long = Long.parseLong(akwd.a().getCurrentAccountUin());
      }
      this.jdField_a_of_type_Akyk.e = localJSONObject.optString("nickName", String.valueOf(this.jdField_a_of_type_Akyk.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 1, "[setRedPacketInfo] " + this.jdField_a_of_type_Akyk.toString());
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
      akwd.a(new Object[] { "[startGameEngine], game is not ready, so status:", Boolean.valueOf(this.k) });
    }
    for (;;)
    {
      return;
      Object localObject1;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath)) || (!bdhb.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGamePath)))
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
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.init_global_var.local", akwd.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
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
        if (this.jdField_a_of_type_Aljn != null) {
          this.jdField_a_of_type_Aljn.a();
        }
      }
      try
      {
        if (b()) {
          akwd.a().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
        }
        for (;;)
        {
          o();
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          long l = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_open_to_start_engine, duration=", Long.valueOf(l), ", mStartGameEngineTs=", Long.valueOf(this.jdField_a_of_type_Long), ", mOpenCmGameTs=", Long.valueOf(this.jdField_b_of_type_Long), ", gameId=", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName });
          akwd.a(new Object[] { "[startGameEngine] cost:", Long.valueOf(l) });
          if (l <= 0L) {
            break;
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_gameId", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName);
          localObject2 = akwd.a();
          if (localObject2 == null) {
            break;
          }
          azri.a(((AppInterface)localObject2).getApp()).a(((AppInterface)localObject2).getCurrentAccountUin(), "cmgame_open_to_start_engine", true, l, 0L, (HashMap)localObject1, "", false);
          return;
          label516:
          localObject1 = String.valueOf(akuf.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson));
          break label241;
          akwd.a().callbackFromRequest(a(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
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
          ((BaseChatPie)localObject).an();
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
  
  public abwx a(long paramLong, Activity paramActivity)
  {
    if (this.jdField_a_of_type_Abwx != null) {
      return this.jdField_a_of_type_Abwx;
    }
    abxc.a();
    this.jdField_a_of_type_Abwx = abxc.a(paramActivity, 5, String.valueOf(paramLong));
    QLog.i("cmgame_process.CmGameLauncher", 1, "create API manager.");
    return this.jdField_a_of_type_Abwx;
  }
  
  public akwg a()
  {
    return this.jdField_a_of_type_Akwg;
  }
  
  public akwx a()
  {
    return this.jdField_a_of_type_Akwx;
  }
  
  public akyk a()
  {
    return this.jdField_a_of_type_Akyk;
  }
  
  public akyu a()
  {
    return this.jdField_a_of_type_Akyu;
  }
  
  public akyy a()
  {
    if ((this.jdField_a_of_type_Akyy == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null)) {
      this.jdField_a_of_type_Akyy = new akyy(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return this.jdField_a_of_type_Akyy;
  }
  
  public akzg a()
  {
    return this.jdField_a_of_type_Akzg;
  }
  
  public akzz a()
  {
    return this.jdField_a_of_type_Akzz;
  }
  
  public alaj a()
  {
    Activity localActivity = a();
    if (!(localActivity instanceof ApolloGameActivity))
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "[playAdsVideo], not ApolloGameActivity");
      return null;
    }
    return ((ApolloGameActivity)localActivity).a();
  }
  
  public alnf a()
  {
    return this.jdField_a_of_type_Alnf;
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
          localObject = new akzb();
          ((akzb)localObject).jdField_e_of_type_Int = paramInt1;
          ((akzb)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
          ((akzb)localObject).jdField_a_of_type_Int = this.jdField_e_of_type_Int;
          ((akzb)localObject).d = paramInt2;
          ((akzb)localObject).jdField_c_of_type_Int = paramInt3;
          ((akzb)localObject).jdField_a_of_type_JavaLangString = paramString;
          ((akzb)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
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
          if (!akyz.a().a((akzb)localObject)) {
            break label425;
          }
          paramInt3 = 0;
          localJSONObject.put("isFirstTimeShare", paramInt3);
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult] engine root:", localJSONObject.toString() });
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.share_game_to_friend_result.local", localJSONObject.toString());
          akyz.a().a((akzb)localObject);
        }
        if ((this.jdField_a_of_type_Akyc == null) || (!this.jdField_a_of_type_Akyc.a())) {
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
          paramString = "window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + ndq.a("apolloGameWebMessage") + "," + String.valueOf(paramString) + "," + String.valueOf("") + ");";
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
    if (this.jdField_a_of_type_Akum != null) {
      this.jdField_a_of_type_Akum.a(paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    Activity localActivity = a();
    if ((localActivity != null) && ((localActivity instanceof ApolloGameActivity))) {
      ((ApolloGameActivity)localActivity).b(paramLong);
    }
  }
  
  public void a(akum paramakum)
  {
    this.jdField_a_of_type_Akum = paramakum;
    this.jdField_g_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addRenderRunner(paramakum);
    }
  }
  
  public void a(alaf paramalaf)
  {
    if (paramalaf == null) {}
    alaj localalaj;
    do
    {
      return;
      localalaj = a();
    } while (localalaj == null);
    localalaj.a(paramalaf);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    if (this.jdField_a_of_type_Akzg != null) {
      this.jdField_a_of_type_Akzg.a(paramActivity);
    }
    this.jdField_a_of_type_Akyc = new akyc(a(), akwd.a());
    this.jdField_a_of_type_Akyc.a(null, this.jdField_e_of_type_Int);
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
      this.jdField_a_of_type_Bhtd.sendEmptyMessage(204);
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
        if (!alko.a())
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, "engine is not ready.");
          alko.b(this.jdField_a_of_type_Alkp);
          alko.a(this.jdField_a_of_type_Alkp);
          alko.a("CmGameLauncher");
          return;
        }
        alko.b(this.jdField_a_of_type_Alkp);
        a(paramActivity);
        a(paramActivity);
        this.jdField_a_of_type_Aljn = new aljn(this.jdField_e_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
          break label562;
        }
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContextRef=null");
      return;
      if (this.jdField_a_of_type_Akzz == null) {
        this.jdField_a_of_type_Akzz = new akzz((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_e_of_type_Int);
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
      bool2 = akwd.a(this.jdField_e_of_type_Int);
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
            if (this.jdField_a_of_type_Akxp != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Akxp);
            }
            if (this.jdField_a_of_type_Akxb != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Akxb);
            }
            this.jdField_a_of_type_Akxp = new akxp(this.jdField_e_of_type_Int, paramActivity);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Akxp);
            this.jdField_a_of_type_Akxb = new akxb(this.jdField_e_of_type_Int);
            this.jdField_a_of_type_Akxn = new akxn(this);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Akxb);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Akxn);
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
    if (this.jdField_a_of_type_Akyc != null) {
      this.jdField_a_of_type_Akyc.a(paramBitmap, this.jdField_e_of_type_Int);
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
        akwd.a(new Object[] { "[checkFinish], loading from main process and tool process is on, before cost:", Long.valueOf(l1) });
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
    alaj localalaj;
    do
    {
      return;
      localalaj = a();
    } while (localalaj == null);
    localalaj.a(paramString);
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
    if (this.jdField_a_of_type_Akwx == null)
    {
      if (paramInt != 0) {
        break label52;
      }
      this.jdField_a_of_type_Akwx = new akwj(akwd.a(), this.jdField_e_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Akwx == null) {
        this.jdField_b_of_type_Akwx = new akwm(this.jdField_a_of_type_Akxn);
      }
      return;
      label52:
      if (1 == paramInt) {
        this.jdField_a_of_type_Akwx = new akwu(this.jdField_e_of_type_Int);
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
    this.jdField_a_of_type_Akyc = new akyc(a(), akwd.a());
    this.jdField_a_of_type_Akyc.a(null, this.jdField_e_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      this.jdField_a_of_type_Akxp = new akxp(this.jdField_e_of_type_Int, paramActivity);
      if (this.jdField_a_of_type_Akxb != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Akxb);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Akxp);
      this.jdField_a_of_type_Akxb = new akxb(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Akxb);
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
      if (this.jdField_a_of_type_Akzg != null) {
        this.jdField_a_of_type_Akzg.a(paramActivity);
      }
      return;
      m = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mSrc;
      break;
      label219:
      paramCmGameInitParams = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.mGameName;
      break label152;
      label230:
      str = String.valueOf(akuf.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson));
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
      this.jdField_a_of_type_Bhtd.removeMessages(203);
      Message localMessage = this.jdField_a_of_type_Bhtd.obtainMessage(203);
      localMessage.obj = paramString;
      this.jdField_a_of_type_Bhtd.sendMessageDelayed(localMessage, 1000L);
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
    alaj localalaj = a();
    if (localalaj != null) {
      localalaj.b(false);
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
    if (this.jdField_a_of_type_Akxb != null) {
      this.jdField_a_of_type_Akxb.c();
    }
    ApolloCmdChannel localApolloCmdChannel = akwd.a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      ApolloGameStateMachine.a().a(3, "CmGame.onResume");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (localApolloCmdChannel != null))
    {
      if (this.jdField_a_of_type_Akwx != null) {
        this.jdField_a_of_type_Akwx.b();
      }
      if (this.jdField_b_of_type_Akwx != null) {
        this.jdField_b_of_type_Akwx.b();
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
    this.jdField_a_of_type_Bhtd.removeMessages(203);
    if (((!this.jdField_b_of_type_Boolean) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("inner")))) && (this.jdField_a_of_type_Akyc != null))
    {
      boolean bool = this.jdField_e_of_type_Boolean;
      this.jdField_a_of_type_Bhtd.post(new CmGameLauncher.9(this, paramString, bool));
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
    if (this.jdField_a_of_type_Akxb != null) {
      this.jdField_a_of_type_Akxb.b();
    }
    if (this.jdField_a_of_type_Akwx != null) {
      this.jdField_a_of_type_Akwx.a();
    }
    if (this.jdField_b_of_type_Akwx != null) {
      this.jdField_b_of_type_Akwx.a();
    }
    ApolloCmdChannel localApolloCmdChannel = akwd.a();
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
    this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Akwx != null) {
      this.jdField_a_of_type_Akwx.c();
    }
    if (this.jdField_b_of_type_Akwx != null) {
      this.jdField_b_of_type_Akwx.c();
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {
      g();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.i = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
      if (this.jdField_a_of_type_Akyt != null) {}
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Akyt);
        if (this.jdField_a_of_type_Aljn != null) {
          this.jdField_a_of_type_Aljn.b();
        }
        if (this.jdField_a_of_type_Akyc != null) {
          this.jdField_a_of_type_Akyc.a();
        }
        if (this.jdField_a_of_type_Abwx != null) {
          this.jdField_a_of_type_Abwx.b();
        }
        if (this.jdField_a_of_type_Akzz != null) {
          this.jdField_a_of_type_Akzz.a();
        }
        if (this.jdField_a_of_type_Akwg != null) {
          this.jdField_a_of_type_Akwg.a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy");
        }
        return;
        this.jdField_a_of_type_Bhtd.obtainMessage(202).sendToTarget();
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
          if (this.jdField_a_of_type_Akum != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeRenderRunner(this.jdField_a_of_type_Akum);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeRenderRunner(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          }
          if (this.jdField_a_of_type_Akxp != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Akxp);
          }
          if (this.jdField_a_of_type_Akxb != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Akxb);
          }
          if (this.jdField_a_of_type_Akxb != null) {
            this.jdField_a_of_type_Akxb.d();
          }
          if (this.jdField_a_of_type_Akxn != null)
          {
            this.jdField_a_of_type_Akxn.a();
            this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Akxn);
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
    if (this.jdField_a_of_type_Akwx != null) {
      this.jdField_a_of_type_Akwx.a();
    }
    if (this.jdField_b_of_type_Akwx != null) {
      this.jdField_b_of_type_Akwx.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      if (this.jdField_a_of_type_Akxb != null) {
        this.jdField_a_of_type_Akxb.a(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_minimize.local", "{}");
        this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_pack_up.local", "{}");
      }
    }
    akxv.a("cs.make_room_min.local", "{}", false, null, this.jdField_e_of_type_Int);
    if ((akwd.a() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
      akwd.a(this.jdField_e_of_type_Int, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
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
      if ((this.jdField_a_of_type_Akyc == null) || (!this.jdField_a_of_type_Akyc.a(this.jdField_e_of_type_Int))) {
        break label271;
      }
      this.jdField_a_of_type_Akyc.a((String)paramMessage.obj, this.jdField_e_of_type_Int, this.jdField_e_of_type_Boolean);
      this.jdField_e_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return false;
      label271:
      alje.a(this.jdField_e_of_type_Int, (String)paramMessage.obj, a());
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_close.local", "{}");
    }
    akxv.a("cs.close_room.local", "{}", false, null, this.jdField_e_of_type_Int);
  }
  
  public void j()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_query_check_game_data", localBundle, new akyi(this));
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      QLog.i("cmgame_process.CmGameLauncher", 1, "[KEYCODE_BACK]");
      paramView = akwd.a();
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
        this.jdField_a_of_type_Bhtd.sendEmptyMessage(200);
        this.jdField_f_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsGameReady = true;
      }
      this.jdField_a_of_type_Akyt = new akyt(this.jdField_e_of_type_Int);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Akyt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyg
 * JD-Core Version:    0.7.0.1
 */