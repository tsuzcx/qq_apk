import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.1;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.10;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.5;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.7;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.8;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.9;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;

public class akxp
  implements akrq
{
  public static int a;
  public static int b;
  public static int c;
  private aljl jdField_a_of_type_Aljl;
  private aljp jdField_a_of_type_Aljp;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, akup> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private HashMap<String, Bitmap> b;
  private int d;
  private int e = 1;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
  }
  
  public akxp(int paramInt, Activity paramActivity)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Aljl = new aljl(akwd.a(), paramActivity);
    this.jdField_a_of_type_Aljp = new aljp(paramActivity, akwd.a());
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  private void a(long paramLong)
  {
    try
    {
      ApolloRender.stopGyroSensor();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
  
  private void a(long paramLong, int paramInt, akyk paramakyk)
  {
    ApolloCmdChannel localApolloCmdChannel = akwd.a();
    if (localApolloCmdChannel != null)
    {
      localApolloCmdChannel.callbackFromRequest(paramLong, paramInt, "cs.get_redPacket_result.local", paramakyk.a());
      paramakyk.jdField_b_of_type_Int = 0;
      paramakyk.jdField_a_of_type_Boolean = false;
      return;
    }
    QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[notifyRedPacketResult] cmdChannel is null");
  }
  
  private void a(long paramLong, String paramString, abwx paramabwx)
  {
    if (paramabwx == null) {
      return;
    }
    String str = "";
    if ("cs.get_app_friends.local".equals(paramString)) {
      str = "getAppFriends";
    }
    while (TextUtils.isEmpty(str))
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "invalid cmd:" + paramString);
      return;
      if ("cs.get_user_info.local".equals(paramString)) {
        str = "getUserInfo";
      } else if ("cs.get_location.local".equals(paramString)) {
        str = "getLocation";
      } else if ("cs.get_city.local".equals(paramString)) {
        str = "getCity";
      }
    }
    paramabwx.a(str, null, new akxu(this, paramString, paramLong));
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = akwd.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[showBannerAds], launcher is null, mGameId:" + this.jdField_d_of_type_Int);
    }
    do
    {
      return;
      localObject = ((akyg)localObject).a();
    } while (localObject == null);
    ((akwg)localObject).a(paramLong, paramString1, paramString2);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[nofityApiRequestFailure], cmd:", paramString, ",code:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt);
      ApolloCmdChannel localApolloCmdChannel = akwd.a();
      if (localApolloCmdChannel != null) {
        localApolloCmdChannel.callbackFromRequest(paramLong, paramInt, paramString, localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_JavaUtilRegexPattern == null)
        {
          Object localObject = akwd.a();
          if (localObject != null)
          {
            localObject = ((akyp)localObject).a(this.jdField_d_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "isValidSsoCmd cmd:" + paramString + ", rule: " + (String)localObject);
            }
            this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile((String)localObject);
          }
        }
      } while (this.jdField_a_of_type_JavaUtilRegexPattern == null);
      bool2 = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches();
      bool1 = bool2;
    } while (bool2);
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "ssoCmdRule,fail to match sso cmd, cmd:" + paramString + ", gameId: " + this.jdField_d_of_type_Int);
    return bool2;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    if ((!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!akru.a(paramString1)) && (a(paramString1))) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "ssoCmdRule, [game],cmd:" + paramString1);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString2);
        ((JSONObject)localObject2).put("from", "cmshow_game_" + this.jdField_d_of_type_Int);
        if ("apollo_router_game.apollo_user_rankinglist_linkcmd_custom_ranking".equals(paramString1))
        {
          paramString2 = akwd.a(this.jdField_d_of_type_Int);
          if ((paramString2 == null) || (paramString2.a() == null) || (TextUtils.isEmpty(paramString2.a().sessionUin))) {
            continue;
          }
          if (((JSONObject)localObject2).optInt("rankType", 0) != 0)
          {
            ((JSONObject)localObject2).put("rankType", ApolloUtil.e(paramString2.a().sessionType));
            ((JSONObject)localObject2).put("sessionId", Integer.parseInt(paramString2.a().sessionUin));
            paramString2 = akwd.a();
            if (paramString2 != null)
            {
              localObject1 = (TicketManager)paramString2.getManager(2);
              if (localObject1 != null)
              {
                localObject1 = ((TicketManager)localObject1).getSkey(paramString2.getCurrentAccountUin());
                paramString2 = (String)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramString2 = "";
                }
                ((JSONObject)localObject2).put("skey", paramString2);
              }
            }
          }
        }
        paramString2 = null;
        Object localObject1 = ((JSONObject)localObject2).toString();
        if ("apollo_router_game.game_ad_linkcmd_get_ad".equals(paramString1))
        {
          paramString2 = a((String)localObject1);
          bool = true;
          localObject2 = akwd.a();
          if (localObject2 == null) {
            break;
          }
          ((akzp)localObject2).a(paramString1, (String)localObject1, paramLong, 4, bool, paramString2);
          break;
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[isSSoRequest] lancher or sessionUin is null");
          continue;
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "errInfo->", paramString1);
      }
      boolean bool = false;
    }
    return true;
  }
  
  private byte[] a(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return null;
    }
    try
    {
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
      Object localObject2 = new qq_ad_get.QQAdGet.UserInfo();
      ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(l);
      localQQAdGet.user_info.set((MessageMicro)localObject2);
      paramString = new JSONObject(paramString);
      localObject2 = new ArrayList();
      qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
      localPositionInfo.pos_id.set(paramString.optString("posid"));
      localPositionInfo.ad_count.set(paramString.optInt("count", 1));
      ((List)localObject2).add(localPositionInfo);
      localQQAdGet.position_info.set((List)localObject2);
      localObject1 = aatg.a((Context)localObject1);
      localQQAdGet.device_info.set((MessageMicro)localObject1);
      localObject1 = new qq_ad_get.QQAdGet.ContextInfo();
      ((qq_ad_get.QQAdGet.ContextInfo)localObject1).article_id.set(paramString.optInt("game_id"));
      localQQAdGet.context_info.set((MessageMicro)localObject1);
      paramString = localQQAdGet.toByteArray();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "getAdPacket error:", paramString);
    }
    return null;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[onFirstFrameDrawn]");
    }
    Object localObject = akwd.a(this.jdField_d_of_type_Int);
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        Activity localActivity = ((akyg)localObject).a();
        if ((localActivity instanceof ApolloGameActivity)) {
          ((ApolloGameActivity)localActivity).f();
        }
        localObject = ((akyg)localObject).a();
      } while (localObject == null);
      l2 = ((CmGameStartChecker.StartCheckParam)localObject).startT;
    } while (l2 <= 0L);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - l2;
    l1 -= ((CmGameStartChecker.StartCheckParam)localObject).startCallEngine;
    QLog.i("cmgame_process.CmGameSubProcessHandler", 1, "startApolloGame initGameCost: " + l1 + ", totalCost:" + l2);
    if (l2 > 20000L)
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "sth must be wrong because it's too long.");
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "start_game_time_cost", 0, 0, new String[] { String.valueOf(this.jdField_d_of_type_Int), String.valueOf(l2), l1 + "" });
    ((CmGameStartChecker.StartCheckParam)localObject).startT = -1L;
  }
  
  private void d()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      akwd.a(this.jdField_d_of_type_Int, localActivity);
    }
  }
  
  private void e()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      localActivity.finish();
      if ((localActivity instanceof ApolloGameActivity)) {
        ((ApolloGameActivity)localActivity).e();
      }
    }
  }
  
  private void e(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleReportEvent] reqData=", paramString });
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((!localJSONObject.has("mid")) || (!localJSONObject.has("value"))) {
          continue;
        }
        i = localJSONObject.optInt("mid");
        int j = localJSONObject.optInt("value");
        int k = localJSONObject.optInt("failCode", 0);
        paramString = localJSONObject.optJSONObject("extInfo");
        akwd.a(akwd.a(), i, j, this.jdField_d_of_type_Int, k, paramString);
        i = 0;
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] e=", paramString);
        int i = -1;
        continue;
      }
      paramString = akwd.a();
      if (paramString != null) {
        paramString.callbackFromRequest(paramLong, i, "cs.report_event.local", "{}");
      }
      return;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, new Object[] { "[handleReportEvent] reqData invalid, reqData=", paramString });
      i = -1;
      continue;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] reqData null");
      i = -1;
    }
  }
  
  private void e(String paramString) {}
  
  private void f()
  {
    try
    {
      ApolloRender.cancelVibrate(this.jdField_d_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
  
  private void f(long paramLong, String paramString)
  {
    Object localObject = akwd.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[checkFileCorrectness], launcher is null, mGameId:" + this.jdField_d_of_type_Int);
    }
    do
    {
      return;
      localObject = ((akyg)localObject).a();
    } while (localObject == null);
    ((akzg)localObject).b(paramLong, paramString);
  }
  
  private void f(String paramString)
  {
    ThreadManager.getUIHandler().post(new CmGameSubProcessHandler.7(this, paramString));
  }
  
  private void g(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "createGameShortCut reqData:" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManagerV2.excute(new CmGameSubProcessHandler.1(this, paramString, paramLong), 16, null, false);
    }
  }
  
  private void g(String paramString)
  {
    ThreadManager.getUIHandler().post(new CmGameSubProcessHandler.8(this, paramString));
  }
  
  private void h(long paramLong, String paramString)
  {
    Object localObject = akwd.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[handleLoadSuppack], launcher is null, mGameId:" + this.jdField_d_of_type_Int);
    }
    do
    {
      return;
      localObject = ((akyg)localObject).a();
    } while (localObject == null);
    ((akzg)localObject).a(paramLong, paramString);
  }
  
  private void h(String paramString)
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    localBundle.putInt("apollo.game.invite.from", 4);
    localBundle.putInt("forward_type", 34);
    localBundle.putString("forward.apollo.redpacket_info", paramString);
    localIntent.putExtras(localBundle);
    paramString = a();
    if (paramString != null) {
      aryv.a(paramString, localIntent, 20180427);
    }
  }
  
  private void i(long paramLong, String paramString)
  {
    Object localObject = akwd.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.jdField_d_of_type_Int);
    }
    CmGameInitParams localCmGameInitParams;
    do
    {
      do
      {
        return;
        localCmGameInitParams = ((akyg)localObject).a();
      } while (localCmGameInitParams == null);
      localObject = ((akyg)localObject).a(localCmGameInitParams.appId, ((akyg)localObject).a());
    } while (localObject == null);
    if (localCmGameInitParams.accessTokenRet != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "login first, cmd:", paramString });
      }
      ((abwx)localObject).a("login", null, new akxt(this, paramString, paramLong, (abwx)localObject, localCmGameInitParams));
      return;
    }
    a(paramLong, paramString, (abwx)localObject);
  }
  
  private void i(String paramString)
  {
    if (this.jdField_a_of_type_Aljl == null) {}
    for (;;)
    {
      return;
      String str = "";
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        str = new JSONObject(paramString).optString("wording");
        akyg localakyg = akwd.a(this.jdField_d_of_type_Int);
        if (localakyg != null)
        {
          localakyg.jdField_c_of_type_Int = 0;
          alnf localalnf2 = localakyg.a();
          alnf localalnf1;
          if ((localalnf2 != null) && (localalnf2.jdField_a_of_type_Long != 0L))
          {
            localalnf1 = localalnf2;
            if (localalnf2.jdField_a_of_type_Int != 0) {}
          }
          else
          {
            localalnf1 = this.jdField_a_of_type_Aljl.a(paramString);
          }
          if (localalnf1 != null)
          {
            this.jdField_a_of_type_Aljl.a(localalnf1);
            this.jdField_a_of_type_Aljl.a(str);
            ThreadManager.getUIHandler().post(new CmGameSubProcessHandler.9(this));
            paramString = localakyg.a();
            if (paramString != null)
            {
              VipUtils.a(null, "cmshow", "Apollo", "clk_invite", 0, 0, new String[] { paramString.mGameName });
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[inviteFriends], errInfo->" + paramString.getMessage());
      }
    }
  }
  
  private void j(long paramLong, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject = akwd.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[hanldeGetRedPacketResult] luncher is null");
    }
    do
    {
      return;
      localObject = ((akyg)localObject).a();
    } while (localObject == null);
    for (;;)
    {
      int i;
      try
      {
        i = new JSONObject(paramString).optInt("score");
        ((akyk)localObject).jdField_d_of_type_Int = i;
        if ((((akyk)localObject).jdField_a_of_type_Int <= 0) || (((akyk)localObject).jdField_d_of_type_Int < ((akyk)localObject).jdField_a_of_type_Int)) {
          break label345;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[hanldeGetRedPacketResult] score:" + ((akyk)localObject).jdField_d_of_type_Int + "info.grabState:" + ((akyk)localObject).jdField_b_of_type_Int);
        }
        if (((akyk)localObject).jdField_b_of_type_Int == 3)
        {
          a(paramLong, 0, (akyk)localObject);
          if (!"0".equals(((akyk)localObject).f)) {
            break label429;
          }
          ajeu.a(((akyk)localObject).jdField_b_of_type_JavaLangString, ((akyk)localObject).jdField_a_of_type_Long, ((akyk)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((akyk)localObject).jdField_d_of_type_JavaLangString), bool1, false, this.jdField_d_of_type_Int);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (((akyk)localObject).jdField_b_of_type_Int == 0)
      {
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ajeu.a(akwd.a(), ((akyk)localObject).g + "", this.jdField_d_of_type_Int + "", i + "", new CmGameSubProcessHandler.4(this, null, paramLong));
        }
        ((akyk)localObject).jdField_b_of_type_Int = 1;
        return;
      }
      ((akyk)localObject).jdField_a_of_type_Boolean = true;
      return;
      label345:
      a(paramLong, 0, (akyk)localObject);
      if ("0".equals(((akyk)localObject).f)) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ajeu.a(((akyk)localObject).jdField_b_of_type_JavaLangString, ((akyk)localObject).jdField_a_of_type_Long, ((akyk)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((akyk)localObject).jdField_d_of_type_JavaLangString), bool1, false, this.jdField_d_of_type_Int);
        return;
      }
      label429:
      bool1 = false;
    }
  }
  
  private void j(String paramString)
  {
    akyg localakyg;
    alnf localalnf;
    try
    {
      localakyg = akwd.a(this.jdField_d_of_type_Int);
      if (localakyg == null) {
        return;
      }
      localalnf = localakyg.a();
      paramString = new JSONObject(paramString);
      i = paramString.optInt("retcode");
      if (i != 0)
      {
        QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onJoinRoom], retCode is 0, fail to joinroom, return. retCode:" + i);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
      return;
    }
    int i = paramString.optInt("gameId");
    localalnf.b();
    long l = paramString.optLong("roomId");
    int j = paramString.optInt("gameMode");
    localalnf.jdField_a_of_type_Int = i;
    localalnf.jdField_a_of_type_Long = l;
    localalnf.jdField_c_of_type_Int = j;
    localalnf.jdField_c_of_type_JavaLangString = paramString.optString("extendInfo");
    paramString = localakyg.a();
    if (paramString != null)
    {
      paramString.mRoomId = l;
      localalnf.jdField_b_of_type_JavaLangString = paramString.mChineseName;
      localalnf.jdField_b_of_type_Int = paramString.mActionId;
    }
    QLog.i("cmgame_process.CmGameSubProcessHandler", 1, "save game msginfo.");
  }
  
  private void k(long paramLong, String paramString)
  {
    akyg localakyg = akwd.a(this.jdField_d_of_type_Int);
    if (localakyg == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = new JSONObject(paramString).optInt("score");
        paramString = localakyg.a();
        if (paramString != null)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "gameScore:" + i + ",target:" + paramString.jdField_a_of_type_Int);
          if ((paramString.jdField_a_of_type_Int > 0) && (i >= paramString.jdField_a_of_type_Int) && (paramString.jdField_b_of_type_Int == 0))
          {
            ajeu.a(akwd.a(), paramString.g + "", this.jdField_d_of_type_Int + "", i + "", new CmGameSubProcessHandler.5(this, null, paramLong));
            paramString.jdField_b_of_type_Int = 1;
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void k(String paramString)
  {
    AppInterface localAppInterface = akwd.a();
    if (localAppInterface != null) {
      alje.a(localAppInterface, paramString);
    }
  }
  
  private void l(long paramLong, String paramString)
  {
    Object localObject = akwd.b(paramLong);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = akwd.a((int)paramLong);
    }
    if (paramString != null)
    {
      localObject = paramString.a();
      if (localObject != null)
      {
        paramString = paramString.a(((CmGameInitParams)localObject).appId, paramString.a());
        if (paramString == null) {
          break label138;
        }
        paramString.a("login", null, new akxs(this, (CmGameInitParams)localObject, paramLong));
      }
    }
    try
    {
      paramString = akwd.a();
      if (paramString != null)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("type", "complete");
        paramString.callbackFromRequest(paramLong, 0, "cs.xy_login.local", ((JSONObject)localObject).toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
      return;
    }
    label138:
    QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "fail to create DoraemonAPIManager.");
  }
  
  private void m(long paramLong, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optJSONArray("pattern");
      int j = ((JSONObject)localObject).getInt("repeate");
      localObject = new long[paramString.length()];
      int i = 0;
      while (i < paramString.length())
      {
        localObject[i] = paramString.getLong(i);
        i += 1;
      }
      ApolloRender.vibrate(this.jdField_d_of_type_Int, paramLong, (long[])localObject, j);
      return;
    }
    catch (Exception paramString)
    {
      akwd.a().callbackFromRequest(paramLong, 6, "cs.xy_device_vibrate.local", "{}");
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private void n(long paramLong, String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("interval");
      ApolloRender.startGyroSensor(this.jdField_d_of_type_Int, paramLong, i);
      return;
    }
    catch (Exception paramString)
    {
      akwd.a().callbackFromRequest(paramLong, 4, "cs.xy_device_gyro_sensor_start.local", "{}");
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public akrw a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleCmd], cmd:", paramString1 });
    }
    akyg localakyg = akwd.a(this.jdField_d_of_type_Int);
    if ((localakyg != null) && (!localakyg.b())) {
      if (paramLong == localakyg.a()) {
        break label104;
      }
    }
    label104:
    do
    {
      do
      {
        do
        {
          return null;
        } while ((localakyg == null) || (localakyg.a() == null));
        if (localakyg.a().getLuaState() == paramLong) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "abandon it, not the same jsState.");
      return null;
      if (a(paramString1, paramString2, paramLong)) {
        return new akrw();
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        j(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        d();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        e();
        return null;
      }
      if ("cs.report_data_2_compass.local".equals(paramString1))
      {
        k(paramString2);
        return null;
      }
      if ("cs.invite_friends.local".equals(paramString1))
      {
        i(paramString2);
        return null;
      }
      if ("cs.send_b2c_redpacket.local".equals(paramString1))
      {
        h(paramString2);
        return null;
      }
      if ("cs.share_game_result.local".equals(paramString1))
      {
        g(paramString2);
        return null;
      }
      if ("cs.qta_notify_test_result.local".equals(paramString1))
      {
        e(paramString2);
        return null;
      }
      if ("cs.share_pic.local".equals(paramString1))
      {
        f(paramString2);
        return null;
      }
      if ("cs.first_frame_drawn.local".equals(paramString1))
      {
        c();
        return null;
      }
      if ("cs.apolloGameWebMessage.local".equals(paramString1))
      {
        alje.a(paramString2);
        return null;
      }
      if ("cs.openWebViewWithoutUrl.local".equals(paramString1))
      {
        b(paramLong, paramString2);
        return null;
      }
      if ("cs.share_game_in_ark.local".equals(paramString1))
      {
        alje.a(this.jdField_d_of_type_Int, paramString2, a());
        return null;
      }
      if ("cs.enter_pubAccount_card.local".equals(paramString1))
      {
        d(paramString2);
        return null;
      }
      if ("cs.game_update_score.local".equals(paramString1))
      {
        k(paramLong, paramString2);
        return null;
      }
      if ("cs.get_redPacket_result.local".equals(paramString1))
      {
        j(paramLong, paramString2);
        return null;
      }
      if ("cs.fetch_cloud_signature.local".equals(paramString1))
      {
        a(paramString2, paramLong);
        return null;
      }
      if ("cs.closeWebview.local".equals(paramString1))
      {
        b(paramString2);
        return null;
      }
      if ("cs.apolloGameTargetWebMessage.local".equals(paramString1))
      {
        c(paramString2);
        return null;
      }
      if ("cs.game_ad_video_jump.local".equals(paramString1))
      {
        a(paramLong, paramString2);
        return null;
      }
      if ("cs.game_ad_video_close.local".equals(paramString1))
      {
        b();
        return null;
      }
      if (("cs.get_user_info.local".equals(paramString1)) || ("cs.get_app_friends.local".equals(paramString1)) || ("cs.get_location.local".equals(paramString1)) || ("cs.get_city.local".equals(paramString1)))
      {
        i(paramLong, paramString1);
        return null;
      }
      if ("cs.create_xy_shortcut.local".equals(paramString1))
      {
        g(paramLong, paramString2);
        return null;
      }
      if ("cs.load_subpackage.local".equals(paramString1))
      {
        h(paramLong, paramString2);
        return null;
      }
      if ("cs.file_correctness_check.local".equals(paramString1))
      {
        f(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_ad_banner_jump.local".equals(paramString1))
      {
        a(paramString2);
        return null;
      }
      if ("cs.preload_userInfoList.local".equals(paramString1))
      {
        c(paramLong, paramString2);
        return null;
      }
      if (("cs.game_ad_banner_load.local".equals(paramString1)) || ("cs.game_ad_banner_show.local".equals(paramString1)) || ("cs.game_ad_banner_close.local".equals(paramString1)) || ("cs.game_ad_banner_resize.local".equals(paramString1)) || ("cs.game_ad_banner_hide.local".equals(paramString1)))
      {
        a(paramLong, paramString1, paramString2);
        return null;
      }
      if ("cs.xy_error_info.local".equals(paramString1))
      {
        d(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_login.local".equals(paramString1))
      {
        l(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_device_vibrate.local".equals(paramString1))
      {
        m(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_device_vibrate_cancel.local".equals(paramString1))
      {
        f();
        return null;
      }
      if ("cs.xy_device_gyro_sensor_start.local".equals(paramString1))
      {
        n(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_device_gyro_sensor_stop.local".equals(paramString1))
      {
        a(paramLong);
        return null;
      }
    } while (!"cs.report_event.local".equals(paramString1));
    e(paramLong, paramString2);
    return null;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Bitmap)localIterator.next()).recycle();
    }
    this.jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(long paramLong, String paramString)
  {
    paramString = alaf.a(paramString);
    akyg localakyg = akwd.a(this.jdField_d_of_type_Int);
    if ((paramString == null) || (localakyg == null))
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[playADsVideo], adInfo or launcher is null.");
      return;
    }
    paramString.b = paramLong;
    localakyg.a(paramString);
  }
  
  public void a(long paramLong, String paramString, akrr paramakrr)
  {
    if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))) {
      paramakrr.a((Bitmap)this.jdField_b_of_type_JavaUtilHashMap.get(paramString), 200);
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
      {
        ThreadManagerV2.excute(new CmGameSubProcessHandler.10(this, ((akup)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_JavaLangString, paramakrr, paramString), 128, null, true);
        return;
      }
      paramakrr = akwd.a();
      if (paramakrr != null)
      {
        Object localObject1 = akwd.a(this.jdField_d_of_type_Int);
        if (localObject1 == null)
        {
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.jdField_d_of_type_Int);
          return;
        }
        Object localObject2 = ((akyg)localObject1).a();
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("gameId", this.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("selfUid", ((CmGameInitParams)localObject2).openId);
          ((JSONObject)localObject1).put("selfKey", "abc");
          localObject2 = new JSONArray();
          ((JSONArray)localObject2).put(paramString);
          ((JSONObject)localObject1).put("uidList", localObject2);
          paramakrr.a("ltgame_native_api.batch_get_user_info", ((JSONObject)localObject1).toString(), paramLong, jdField_a_of_type_Int);
          if (QLog.isColorLevel())
          {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "getOpenApiHead by sso");
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "GET_OPENID_INFO send e=" + paramString.toString());
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString, akrs paramakrs)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      paramakrs.a(((akup)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      paramakrs = akwd.a();
      if (paramakrs != null)
      {
        Object localObject1 = akwd.a(this.jdField_d_of_type_Int);
        if (localObject1 == null)
        {
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.jdField_d_of_type_Int);
          return;
        }
        Object localObject2 = ((akyg)localObject1).a();
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("gameId", this.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("selfUid", ((CmGameInitParams)localObject2).openId);
          ((JSONObject)localObject1).put("selfKey", "abc");
          localObject2 = new JSONArray();
          ((JSONArray)localObject2).put(paramString);
          ((JSONObject)localObject1).put("uidList", localObject2);
          paramakrs.a("ltgame_native_api.batch_get_user_info", ((JSONObject)localObject1).toString(), paramLong, jdField_b_of_type_Int);
          if (QLog.isColorLevel())
          {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "getOpenApiNick by sso");
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "GET_OPENID_INFO send e=" + paramString.toString());
        }
      }
    }
  }
  
  public void a(akup paramakup)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramakup.jdField_c_of_type_JavaLangString, paramakup);
    }
  }
  
  public void a(String paramString)
  {
    akyg localakyg = akwd.a(this.jdField_d_of_type_Int);
    if (localakyg == null)
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[playADsVideo], launcher is null.");
      return;
    }
    localakyg.a(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = akwd.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = ((akyg)localObject).a();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("now");
      }
      catch (Throwable paramString)
      {
        try
        {
          j = paramString.optInt("delta");
          paramString = ApolloGameInterfaceProxy.a(i, j, (CmGameInitParams)localObject);
          localObject = akwd.a();
          if (localObject == null) {
            break;
          }
          ((ApolloCmdChannel)localObject).callbackFromRequest(paramLong, 0, "cs.fetch_cloud_signature.local", paramString);
          return;
        }
        catch (Throwable paramString)
        {
          int i;
          int j;
          break label85;
        }
        paramString = paramString;
        i = 0;
      }
      label85:
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "get cloud errInfo->", paramString);
      j = 0;
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  public void b()
  {
    akyg localakyg = akwd.a(this.jdField_d_of_type_Int);
    if (localakyg == null)
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[closeADView], launcher is null.");
      return;
    }
    localakyg.c();
  }
  
  public void b(long paramLong, String paramString)
  {
    int i = this.e;
    if (alje.a(a(), paramString, this.jdField_d_of_type_Int, i)) {}
    try
    {
      paramString = new JSONObject();
      paramString.put("taskId", i);
      ApolloCmdChannel localApolloCmdChannel = akwd.a();
      if (localApolloCmdChannel != null)
      {
        localApolloCmdChannel.callbackFromRequest(paramLong, 0, "cs.openWebViewWithoutUrl.local", paramString.toString());
        this.e += 1;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      paramString = akwd.a(this.jdField_d_of_type_Int);
      if (paramString != null) {
        paramString.a(i);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void c(long paramLong, String paramString)
  {
    int i = 0;
    akzp localakzp = akwd.a();
    if (localakzp != null)
    {
      localObject1 = akwd.a(this.jdField_d_of_type_Int);
      if (localObject1 == null) {
        QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    Object localObject1 = ((akyg)localObject1).a();
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString).optJSONArray("openIdList");
        paramString = new JSONArray();
        if (i < ((JSONArray)localObject2).length())
        {
          String str = ((JSONArray)localObject2).getString(i);
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
            paramString.put(str);
          }
        }
        else
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("gameId", this.jdField_d_of_type_Int);
          ((JSONObject)localObject2).put("selfUid", ((CmGameInitParams)localObject1).openId);
          ((JSONObject)localObject2).put("selfKey", this.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject2).put("uidList", paramString);
          localakzp.a("ltgame_native_api.batch_get_user_info", ((JSONObject)localObject2).toString(), paramLong, jdField_c_of_type_Int, false, null);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "GET_OPENID_INFO send e=" + paramString.toString());
        return;
      }
      i += 1;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      akyg localakyg = akwd.a(this.jdField_d_of_type_Int);
      if (localakyg != null) {
        localakyg.a(i, paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void d(long paramLong, String paramString)
  {
    Object localObject2 = akwd.b(paramLong);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = akwd.a((int)paramLong);
    }
    if (localObject1 != null)
    {
      localObject2 = ((akyg)localObject1).a();
      if (localObject2 != null) {
        try
        {
          CmGameInitParams localCmGameInitParams = ((akyg)localObject1).a();
          if (localCmGameInitParams != null)
          {
            if (!localCmGameInitParams.isWhiteUsr) {
              return;
            }
            paramString = new JSONObject(paramString);
            paramString.put("action", "show");
            paramString.put("title", "JS Error");
            int i = ((akyg)localObject1).a();
            localObject1 = "[game:" + i + "]" + paramString.optString("data");
            paramString.put("content", localObject1);
            ((akzz)localObject2).a("Dialog", "alert", "", paramString.toString());
            paramString = akwd.a();
            if (paramString != null)
            {
              paramString.a("JS_Error", 3, new Object[] { localObject1 });
              return;
            }
          }
        }
        catch (Throwable paramString)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    Activity localActivity = a();
    if ((TextUtils.isEmpty(paramString)) || (localActivity == null)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("puin");
      Intent localIntent = new Intent(localActivity, AccountDetailActivity.class);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("report_src_param_type", "");
      localIntent.putExtra("report_src_param_name", "");
      localIntent.setFlags(67108864);
      localActivity.startActivityForResult(localIntent, 9999);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "ENTER_PUBACCOUNT_CARD error:", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxp
 * JD-Core Version:    0.7.0.1
 */