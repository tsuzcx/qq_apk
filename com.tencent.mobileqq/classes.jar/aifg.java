import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager.11;
import com.tencent.mobileqq.apollo.ApolloManager.13;
import com.tencent.mobileqq.apollo.ApolloManager.14;
import com.tencent.mobileqq.apollo.ApolloManager.15;
import com.tencent.mobileqq.apollo.ApolloManager.16;
import com.tencent.mobileqq.apollo.ApolloManager.17;
import com.tencent.mobileqq.apollo.ApolloManager.18;
import com.tencent.mobileqq.apollo.ApolloManager.2;
import com.tencent.mobileqq.apollo.ApolloManager.21;
import com.tencent.mobileqq.apollo.ApolloManager.3;
import com.tencent.mobileqq.apollo.ApolloManager.4;
import com.tencent.mobileqq.apollo.ApolloManager.5;
import com.tencent.mobileqq.apollo.ApolloManager.8;
import com.tencent.mobileqq.apollo.ApolloManager.9;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.data.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgContent;

public class aifg
  implements Manager
{
  public static int a;
  public static String a;
  public static ArrayList<Long> a;
  public static HashSet<Integer> a;
  public static Vector<String> a;
  public static AtomicBoolean a;
  public static boolean a;
  public static int b;
  public static String b;
  public static Vector<String> b;
  public static boolean b;
  private static int jdField_c_of_type_Int;
  public static String c;
  private static AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static int d;
  public static String d;
  private static int e;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  private static String l;
  public static boolean p;
  private static boolean q;
  private static boolean r;
  private static boolean s = true;
  private static boolean t = true;
  private static boolean u = true;
  public long a;
  private aife jdField_a_of_type_Aife;
  private aifq jdField_a_of_type_Aifq;
  private aift jdField_a_of_type_Aift;
  aify jdField_a_of_type_Aify;
  private aijn jdField_a_of_type_Aijn = new aijn();
  private aily jdField_a_of_type_Aily;
  private aime jdField_a_of_type_Aime;
  private aimr jdField_a_of_type_Aimr;
  aiud jdField_a_of_type_Aiud;
  ajak jdField_a_of_type_Ajak;
  Handler jdField_a_of_type_AndroidOsHandler = new aifj(this, ThreadManager.getSubThreadLooper());
  private atmp jdField_a_of_type_Atmp;
  batl jdField_a_of_type_Batl = new aifn(this);
  private QQLruCache<String, ApolloBaseInfo> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new aifh(this, 2009, 1024, ApolloBaseInfo.calcSelfMemorySize());
  public QQAppInterface a;
  private ApolloBaseInfo jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloManager.2(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  Comparator<DrawerPushItem> jdField_a_of_type_JavaUtilComparator = new aifk(this);
  public HashMap<Integer, Bundle> a;
  private List<DrawerPushItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  public Timer a;
  private ConcurrentHashMap<String, ApolloPandora> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public JSONObject a;
  public batl b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ApolloManager.4(this);
  private WeakReference<BaseChatPie> jdField_b_of_type_JavaLangRefWeakReference;
  private HashSet<Long> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private List<aifp> jdField_b_of_type_JavaUtilList;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private batl jdField_c_of_type_Batl = new aifl(this);
  private Runnable jdField_c_of_type_JavaLangRunnable = new ApolloManager.5(this);
  private List<WeakReference<aifr>> jdField_c_of_type_JavaUtilList = new ArrayList();
  public boolean c;
  public boolean d;
  public volatile boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public String j;
  public boolean j;
  public String k;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  private volatile boolean v;
  private volatile boolean w;
  
  static
  {
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_e_of_type_Int = -1;
    jdField_a_of_type_JavaUtilHashSet = new HashSet(16);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
    jdField_a_of_type_Int = 4096;
    jdField_b_of_type_Int = 4097;
  }
  
  public aifg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Batl = new aifo(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_a_of_type_JavaUtilVector.clear();
    jdField_b_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (b(paramQQAppInterface.getApp()))
    {
      this.jdField_a_of_type_Ajak = new ajak();
      p();
      aind.b();
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getFileThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_Aify = new aify(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Aife = new aife(paramQQAppInterface);
    n();
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    for (;;)
    {
      try
      {
        if (jdField_c_of_type_Int == -1)
        {
          jdField_c_of_type_Int = 0;
          if (paramAppInterface != null)
          {
            i1 = baig.q(paramAppInterface.getApplication());
            if (i1 != 0) {
              continue;
            }
            jdField_c_of_type_Int = paramAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppInterface.getCurrentAccountUin() + "_whiteList", 0);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "white list global: " + i1 + ", mWhiteUserStatus: " + jdField_c_of_type_Int);
            }
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        int i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloManager", 2, "getWhiteListStatus error = " + paramAppInterface.toString());
        continue;
      }
      return jdField_c_of_type_Int;
      if (1 == i1) {
        jdField_c_of_type_Int = 1;
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return 0;
      } while (!b(BaseApplicationImpl.getContext()));
      o();
    } while ((!s) && (!u));
    ApolloBaseInfo localApolloBaseInfo = ((aifg)paramQQAppInterface.getManager(153)).a(paramQQAppInterface.c());
    int i1;
    if ((localApolloBaseInfo != null) && (localApolloBaseInfo.apolloStatus == 1)) {
      if ((u) && (b(paramQQAppInterface) == 1))
      {
        i1 = 1;
        if ((i1 == 0) || ((localApolloBaseInfo.cmshow3dFlag & 0x1) != 1)) {
          break label99;
        }
        i1 = 2;
      }
    }
    for (;;)
    {
      return i1;
      i1 = 0;
      break;
      label99:
      if ((s) && (a(paramQQAppInterface) == 1)) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label129;
        }
        i1 = 1;
        break;
      }
      label129:
      i1 = 0;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString, true);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (!b(paramQQAppInterface.getApplication())) || (TextUtils.isEmpty(paramString1)) || (aiyr.jdField_a_of_type_OrgJsonJSONObject == null)) {
      return -1;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))
      {
        paramString2 = (aifg)paramQQAppInterface.getManager(153);
        if (paramString2.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo == null) {
          break label197;
        }
        i1 = paramString2.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloStatus;
        int i2 = a(paramQQAppInterface);
        str = i2 + "x" + i1;
      }
    }
    if ((aiyr.jdField_a_of_type_OrgJsonJSONObject != null) && (str != null))
    {
      paramQQAppInterface = aiyr.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(str);
      if (paramQQAppInterface == null) {}
    }
    for (int i1 = paramQQAppInterface.optInt(paramString1);; i1 = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "queryStatusInConfig ruleKey: " + str + ", entry = " + paramString1 + ", value=" + i1);
      }
      return i1;
      label197:
      ThreadManager.getSubThreadHandler().post(new ApolloManager.14(paramString2, paramQQAppInterface));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "queryStatusInConfig but apollomanager dont init done");
      return -1;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[getCmShowStatus] withStrictCheck=", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return 0;
            localObject = (aifg)paramQQAppInterface.getManager(153);
            paramString = ((aifg)localObject).a(paramString);
          } while (paramString == null);
          if (!paramBoolean) {
            break;
          }
        } while (!b(BaseApplicationImpl.getContext()));
        o();
      } while ((!s) && (!u));
      localObject = ((aifg)localObject).a(paramQQAppInterface.c());
    } while ((localObject == null) || (((ApolloBaseInfo)localObject).apolloStatus != 1) || (paramString.apolloStatus != 1));
    int i1;
    if ((u) && (b(paramQQAppInterface) == 1) && ((paramString.cmshow3dFlag & 0x2) == 2) && ((paramString.cmshow3dFlag & 0x1) == 1)) {
      i1 = 2;
    }
    for (;;)
    {
      return i1;
      if ((s) && (a(paramQQAppInterface) == 1) && ((paramString.cmshow3dFlag & 0x1) == 0))
      {
        i1 = 1;
      }
      else
      {
        i1 = 0;
        continue;
        if (((paramString.cmshow3dFlag & 0x2) == 2) && ((paramString.cmshow3dFlag & 0x1) == 1)) {
          i1 = 2;
        } else {
          i1 = 1;
        }
      }
    }
  }
  
  public static SharedPreferences a()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_stand_up" + str1, 4);
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("CMShow.GameId", String.valueOf(paramInt));
      localJSONObject2.put("extraInfo", paramString);
      localJSONObject1.put("CMShow.Game", localJSONObject2);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "[launchGameDetailView] mate:" + localJSONObject1.toString());
      }
      ArkFullScreenAppActivity.a(paramActivity, "com.tencent.cmgame.intent", "GameCard", localJSONObject1.toString());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "[launchGameDetailView] error:", paramString);
      }
    }
  }
  
  private void a(int paramInt, List<submsgtype0xdc.MsgContent> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_Atmp == null)) {
      QLog.e("ApolloManager", 1, "[saveBubblePushData], null param");
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[saveBubblePushData] msgType:", Integer.valueOf(paramInt) });
      }
      atmr localatmr = this.jdField_a_of_type_Atmp.a();
      try
      {
        localatmr.a();
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            submsgtype0xdc.MsgContent localMsgContent = (submsgtype0xdc.MsgContent)paramList.next();
            localDrawerPushItem = new DrawerPushItem();
            localDrawerPushItem.msg_type = paramInt;
            localDrawerPushItem.msg_id = String.valueOf(localMsgContent.uint64_msg_id.get());
            localDrawerPushItem.priority = ((int)localMsgContent.uint64_master_pri.get());
            localDrawerPushItem.sub_priority = ((int)localMsgContent.uint64_sub_pri.get());
            localDrawerPushItem.start_ts = ((int)localMsgContent.uint64_show_beg_ts.get());
            localDrawerPushItem.end_ts = ((int)localMsgContent.uint64_exp_ts.get());
            localDrawerPushItem.send_time = ((int)localMsgContent.uint64_msg_sent_ts.get());
            localDrawerPushItem.action_id = ((int)localMsgContent.uint64_action_id.get());
            localDrawerPushItem.color = ((int)localMsgContent.uint64_wording_color.get());
            localDrawerPushItem.content = localMsgContent.str_wording.get();
            localDrawerPushItem.scheme = localMsgContent.str_scheme.get();
            localDrawerPushItem.ext_url = localMsgContent.str_region_url.get();
            localDrawerPushItem.bubble_res_id = ((int)localMsgContent.uint64_bubble_id.get());
            localDrawerPushItem.is_reddot = 0;
            localDrawerPushItem.tips_str = localMsgContent.str_tips.get();
            localDrawerPushItem.show_counts = ((int)localMsgContent.uint64_show_times.get());
            localDrawerPushItem.reddotGameId = ((int)localMsgContent.uint64_game_id.get());
            if ((localDrawerPushItem.reddotGameId > 0) && (!ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDrawerPushItem.reddotGameId))) {
              QLog.i("ApolloManager", 1, "saveBubblePushData push game not exit,gameId:" + localDrawerPushItem.reddotGameId);
            }
          }
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          DrawerPushItem localDrawerPushItem;
          QLog.e("ApolloManager", 1, "[saveBubblePushData], Apollo Push Bubble Error:" + paramList.getMessage());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "saveBubblePushData receive item:", localDrawerPushItem.toString() });
          }
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!a(localDrawerPushItem))) {
            this.jdField_a_of_type_JavaUtilList.add(localDrawerPushItem);
          }
          this.jdField_a_of_type_Atmp.a(localDrawerPushItem);
        }
        localatmr.c();
        return;
      }
      finally
      {
        if (localatmr != null) {
          localatmr.b();
        }
      }
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +40 -> 49
    //   12: ldc_w 355
    //   15: iconst_2
    //   16: new 327	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 699
    //   26: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 701
    //   36: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: new 703	java/io/File
    //   52: dup
    //   53: getstatic 707	aiys:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokespecial 710	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokevirtual 713	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: aload_0
    //   64: invokevirtual 719	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   67: aload_1
    //   68: invokevirtual 725	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   71: astore_0
    //   72: new 727	java/io/FileOutputStream
    //   75: dup
    //   76: new 703	java/io/File
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 710	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokespecial 730	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: astore_1
    //   88: sipush 4096
    //   91: newarray byte
    //   93: astore_2
    //   94: aload_0
    //   95: aload_2
    //   96: invokevirtual 736	java/io/InputStream:read	([B)I
    //   99: istore_3
    //   100: iload_3
    //   101: iconst_m1
    //   102: if_icmpeq +77 -> 179
    //   105: aload_1
    //   106: aload_2
    //   107: iconst_0
    //   108: iload_3
    //   109: invokevirtual 740	java/io/FileOutputStream:write	([BII)V
    //   112: goto -18 -> 94
    //   115: astore 4
    //   117: aload_0
    //   118: astore_2
    //   119: aload 4
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 743	java/lang/Exception:printStackTrace	()V
    //   126: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +33 -> 162
    //   132: ldc_w 355
    //   135: iconst_2
    //   136: new 327	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 745
    //   146: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 676	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 748	java/io/InputStream:close	()V
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 749	java/io/FileOutputStream:close	()V
    //   178: return
    //   179: aload_1
    //   180: invokevirtual 752	java/io/FileOutputStream:flush	()V
    //   183: aload_0
    //   184: ifnull +7 -> 191
    //   187: aload_0
    //   188: invokevirtual 748	java/io/InputStream:close	()V
    //   191: aload_1
    //   192: ifnull -14 -> 178
    //   195: aload_1
    //   196: invokevirtual 749	java/io/FileOutputStream:close	()V
    //   199: return
    //   200: astore_0
    //   201: return
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_1
    //   205: aload 5
    //   207: astore_2
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 748	java/io/InputStream:close	()V
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 749	java/io/FileOutputStream:close	()V
    //   224: aload_0
    //   225: athrow
    //   226: astore_1
    //   227: goto -3 -> 224
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_0
    //   235: astore_2
    //   236: aload 4
    //   238: astore_0
    //   239: goto -31 -> 208
    //   242: astore 4
    //   244: aload_0
    //   245: astore_2
    //   246: aload 4
    //   248: astore_0
    //   249: goto -41 -> 208
    //   252: astore_0
    //   253: goto -45 -> 208
    //   256: astore_0
    //   257: return
    //   258: astore_0
    //   259: aconst_null
    //   260: astore_1
    //   261: aload 4
    //   263: astore_2
    //   264: goto -142 -> 122
    //   267: astore 4
    //   269: aconst_null
    //   270: astore_1
    //   271: aload_0
    //   272: astore_2
    //   273: aload 4
    //   275: astore_0
    //   276: goto -154 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   0	279	1	paramString1	String
    //   0	279	2	paramString2	String
    //   99	10	3	i1	int
    //   4	1	4	localObject1	Object
    //   115	5	4	localException1	Exception
    //   230	7	4	localObject2	Object
    //   242	20	4	localObject3	Object
    //   267	7	4	localException2	Exception
    //   1	205	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	94	115	java/lang/Exception
    //   94	100	115	java/lang/Exception
    //   105	112	115	java/lang/Exception
    //   179	183	115	java/lang/Exception
    //   187	191	200	java/lang/Exception
    //   195	199	200	java/lang/Exception
    //   49	72	202	finally
    //   212	216	226	java/lang/Exception
    //   220	224	226	java/lang/Exception
    //   72	88	230	finally
    //   88	94	242	finally
    //   94	100	242	finally
    //   105	112	242	finally
    //   179	183	242	finally
    //   122	162	252	finally
    //   166	170	256	java/lang/Exception
    //   174	178	256	java/lang/Exception
    //   49	72	258	java/lang/Exception
    //   72	88	267	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new ApolloManager.13(paramAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = (aifg)paramQQAppInterface.getManager(153);
    baot localbaot = (baot)paramQQAppInterface.a(71);
    ApolloBaseInfo localApolloBaseInfo = ((aifg)localObject).b(paramString1 + "");
    if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloUpdateTime == 0L))
    {
      localbaot.b(paramString1 + "");
      if (QLog.isColorLevel()) {
        if (paramString1.length() < 4) {
          break label447;
        }
      }
    }
    label447:
    for (paramQQAppInterface = paramString1.substring(0, 4);; paramQQAppInterface = paramString1)
    {
      QLog.d("ApolloManager", 2, "checkUserDress---> getApolloBaseInfo uin: " + paramQQAppInterface);
      do
      {
        do
        {
          if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (!localApolloBaseInfo.isApolloStatusOpen())) {
            QLog.d("ApolloManager", 2, "checkUserDress---> user apollo status is not open uin: " + paramString1 + ", status: " + localApolloBaseInfo.apolloStatus);
          }
          if ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (0L == localApolloBaseInfo.apolloSignValidTS) || (NetConnInfoCenter.getServerTime() >= localApolloBaseInfo.apolloSignValidTS) || (localApolloBaseInfo.apolloSignValidTS == localApolloBaseInfo.apolloLocalSignTs)) {
            break;
          }
          localbaot.b(paramString1, "AIO");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "getUserSignStr...");
          return;
        } while ((!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS));
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(Long.valueOf(Long.parseLong(paramString1)));
        localObject = ((aifg)localObject).b(paramQQAppInterface.c());
        if ((localObject != null) && (((ApolloBaseInfo)localObject).apolloLocalTS != ((ApolloBaseInfo)localObject).apolloServerTS)) {
          localArrayList.add(Long.valueOf(paramQQAppInterface.getLongAccountUin()));
        }
        localbaot.a(localArrayList, paramString2);
      } while (!QLog.isColorLevel());
      if (paramString1.length() >= 4) {}
      for (paramQQAppInterface = paramString1.substring(0, 4);; paramQQAppInterface = paramString1)
      {
        QLog.d("ApolloManager", 2, "checkUserDress---> getGetUserApolloDress uin: " + paramQQAppInterface + ", old dress: " + localApolloBaseInfo.getApolloDress());
        break;
      }
    }
  }
  
  private void a(ApolloActionPackage paramApolloActionPackage, JSONObject paramJSONObject)
  {
    if ((paramApolloActionPackage == null) || (paramJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      long l1;
      long l2;
      int i1;
      try
      {
        l1 = paramJSONObject.optLong("startTime");
        l2 = paramJSONObject.optLong("interval");
        i1 = paramJSONObject.optInt("actionId");
        localObject = ((aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramApolloActionPackage.packageId);
        if ((localObject != null) && (l1 == ((ApolloActionPackage)localObject).redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " have not new red push" });
          }
          paramApolloActionPackage.isUpdate = ((ApolloActionPackage)localObject).isUpdate;
          paramApolloActionPackage.redFlowId = ((ApolloActionPackage)localObject).redFlowId;
          paramApolloActionPackage.redStartTime = ((ApolloActionPackage)localObject).redStartTime;
          paramApolloActionPackage.redInterval = ((ApolloActionPackage)localObject).redInterval;
          return;
        }
      }
      catch (Exception paramApolloActionPackage)
      {
        QLog.e("ApolloManager", 1, "checkPackageRedDots Exception:", paramApolloActionPackage);
        return;
      }
      paramApolloActionPackage.isUpdate = true;
      paramApolloActionPackage.redFlowId = i1;
      paramApolloActionPackage.redStartTime = l1;
      paramApolloActionPackage.redInterval = l2;
      g(paramApolloActionPackage.packageId);
      Object localObject = new ArrayList();
      ApolloActionData localApolloActionData = new ApolloActionData();
      localApolloActionData.actionId = i1;
      ((List)localObject).add(localApolloActionData);
      a((List)localObject, "apollo_key");
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " push red:", Integer.valueOf(paramApolloActionPackage.packageId), " dots:", paramJSONObject });
  }
  
  private void a(List<ApolloActionData> paramList, List<ApolloActionPackage> paramList1, List<ApolloActionPackageData> paramList2, JSONObject paramJSONObject)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i1;
      Object localObject4;
      int i2;
      try
      {
        localObject1 = new ArrayList();
        Object localObject6;
        Object localObject5;
        if ((paramJSONObject != null) && (paramJSONObject.has("data")))
        {
          localObject2 = paramJSONObject.getJSONArray("data");
          if (localObject2 != null)
          {
            int i3 = ((JSONArray)localObject2).length();
            i1 = 0;
            if (i1 < i3)
            {
              localObject4 = ((JSONArray)localObject2).getJSONObject(i1);
              if (localObject4 == null) {
                break label1732;
              }
              localObject3 = new ApolloActionData();
              ((ApolloActionData)localObject3).actionId = ((JSONObject)localObject4).getInt("id");
              ((ApolloActionData)localObject3).sessionType = ((JSONObject)localObject4).optInt("use");
              ((ApolloActionData)localObject3).actionName = ((JSONObject)localObject4).getString("name");
              ((ApolloActionData)localObject3).vipLevel = ((JSONObject)localObject4).optInt("vipLevel");
              ((ApolloActionData)localObject3).feeType = ((JSONObject)localObject4).optInt("feeType", 1);
              if (((JSONObject)localObject4).has("icon")) {
                ((ApolloActionData)localObject3).icon = ((JSONObject)localObject4).getInt("icon");
              }
              ((ApolloActionData)localObject3).iconUrl = ((JSONObject)localObject4).optString("iconUrl");
              ((ApolloActionData)localObject3).personNum = ((JSONObject)localObject4).getInt("type");
              ((ApolloActionData)localObject3).anmiName = ((JSONObject)localObject4).optString("animationName");
              ((ApolloActionData)localObject3).isShow = ((JSONObject)localObject4).optInt("isShow");
              ((ApolloActionData)localObject3).textImg = ((JSONObject)localObject4).optString("textImg");
              if (((JSONObject)localObject4).has("limitFree"))
              {
                ((ApolloActionData)localObject3).limitFree = ((JSONObject)localObject4).getInt("limitFree");
                ((ApolloActionData)localObject3).limitStart = ((JSONObject)localObject4).getLong("begin");
                ((ApolloActionData)localObject3).limitEnd = ((JSONObject)localObject4).getLong("end");
              }
              ((ApolloActionData)localObject3).startTime = ((JSONObject)localObject4).optLong("startTime");
              ((ApolloActionData)localObject3).endTime = ((JSONObject)localObject4).optLong("endTime");
              ((ApolloActionData)localObject3).url = ((JSONObject)localObject4).optString("activeUrl");
              ((ApolloActionData)localObject3).version = ((JSONObject)localObject4).getLong("version");
              ((ApolloActionData)localObject3).actionMoveDis = ((float)((JSONObject)localObject4).optDouble("actionDis", 0.0D));
              ((ApolloActionData)localObject3).peerMoveDis = ((float)((JSONObject)localObject4).optDouble("actionPeerDis", 0.0D));
              ((ApolloActionData)localObject3).compoundType = ((JSONObject)localObject4).optInt("actionSubType");
              ((ApolloActionData)localObject3).playArea = ((JSONObject)localObject4).optInt("posType");
              ((ApolloActionData)localObject3).actionType = ((JSONObject)localObject4).optInt("actionType");
              ((ApolloActionData)localObject3).slaveActionId = ((JSONObject)localObject4).optInt("slaveActionId");
              ((ApolloActionData)localObject3).currencyType = ((JSONObject)localObject4).optInt("currencyType");
              ((ApolloActionData)localObject3).currencyNum = ((JSONObject)localObject4).optInt("currencyNum");
              ((ApolloActionData)localObject3).description = ((JSONObject)localObject4).optString("description");
              ((ApolloActionData)localObject3).extraWording = ((JSONObject)localObject4).optString("extraWording");
              ((ApolloActionData)localObject3).minVer = ((JSONObject)localObject4).optString("minVer");
              ((ApolloActionData)localObject3).maxVer = ((JSONObject)localObject4).optString("maxVer");
              ((ApolloActionData)localObject3).gameId = ((JSONObject)localObject4).optInt("gameId");
              ((ApolloActionData)localObject3).gameName = ((JSONObject)localObject4).optString("gameName");
              ((ApolloActionData)localObject3).activeValue = ((JSONObject)localObject4).optInt("activeValue");
              ((ApolloActionData)localObject3).soundURL = ((JSONObject)localObject4).optString("soundURL");
              ((ApolloActionData)localObject3).soundType = ((JSONObject)localObject4).optInt("soundType");
              localObject6 = ((JSONObject)localObject4).optJSONArray("pkIds");
              localObject5 = ((JSONObject)localObject4).optJSONArray("pk3DIds");
              int i4;
              if (localObject6 != null)
              {
                i4 = ((JSONArray)localObject6).length();
                StringBuilder localStringBuilder = new StringBuilder();
                i2 = 0;
                label606:
                if (i2 < i4)
                {
                  localStringBuilder.append(String.valueOf(((JSONArray)localObject6).get(i2)));
                  if (i2 == i4 - 1) {
                    break label1705;
                  }
                  localStringBuilder.append(",");
                  break label1705;
                }
                ((ApolloActionData)localObject3).pkIds = localStringBuilder.toString();
              }
              if (localObject5 != null)
              {
                i4 = ((JSONArray)localObject5).length();
                localObject6 = new StringBuilder();
                i2 = 0;
                label684:
                if (i2 < i4)
                {
                  ((StringBuilder)localObject6).append(String.valueOf(((JSONArray)localObject5).get(i2)));
                  if (i2 == i4 - 1) {
                    break label1714;
                  }
                  ((StringBuilder)localObject6).append(",");
                  break label1714;
                }
                ((ApolloActionData)localObject3).pk3DIds = ((StringBuilder)localObject6).toString();
              }
              localObject4 = ((JSONObject)localObject4).optJSONArray("keywords");
              if (localObject4 != null)
              {
                i4 = ((JSONArray)localObject4).length();
                localObject5 = new StringBuilder();
                i2 = 0;
                label772:
                if (i2 < i4)
                {
                  ((StringBuilder)localObject5).append(String.valueOf(((JSONArray)localObject4).get(i2)));
                  if (i2 == i4 - 1) {
                    break label1723;
                  }
                  ((StringBuilder)localObject5).append(",");
                  break label1723;
                }
                ((ApolloActionData)localObject3).keywords = ((StringBuilder)localObject5).toString();
              }
              if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(((ApolloActionData)localObject3).actionId))))
              {
                if (((ApolloActionData)localObject3).isShow == 0) {
                  ((ApolloActionData)localObject3).isShow = 1;
                }
                a((ApolloActionData)localObject3, (Bundle)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((ApolloActionData)localObject3).actionId)));
              }
              b((ApolloActionData)localObject3);
              paramList.add(localObject3);
              if (((ApolloActionData)localObject3).feeType != 6) {
                break label1732;
              }
              ((List)localObject1).add(localObject3);
              break label1732;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        localObject1 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
        localObject1 = new ArrayList();
        if ((paramJSONObject == null) || (!paramJSONObject.has("packageInfo"))) {
          break label1590;
        }
        paramJSONObject = paramJSONObject.getJSONArray("packageInfo");
        if (paramJSONObject == null) {
          break label1590;
        }
        i1 = 0;
        if (i1 >= paramJSONObject.length()) {
          break label1590;
        }
        Object localObject3 = paramJSONObject.getJSONObject(i1);
        if (localObject3 == null) {
          break label1742;
        }
        localObject2 = new ApolloActionPackage();
        ((ApolloActionPackage)localObject2).packageId = ((JSONObject)localObject3).getInt("packageId");
        ((ApolloActionPackage)localObject2).version = ((JSONObject)localObject3).optInt("version");
        ((ApolloActionPackage)localObject2).startVersion = ((JSONObject)localObject3).optString("startVersion");
        ((ApolloActionPackage)localObject2).endVersion = ((JSONObject)localObject3).optString("endVersion");
        ((ApolloActionPackage)localObject2).type = ((JSONObject)localObject3).optInt("type");
        ((ApolloActionPackage)localObject2).sessionType = ((JSONObject)localObject3).optInt("use");
        ((ApolloActionPackage)localObject2).name = ((JSONObject)localObject3).optString("name");
        ((ApolloActionPackage)localObject2).mIconUnselectedUrl = ((JSONObject)localObject3).optString("apImg");
        ((ApolloActionPackage)localObject2).mIconSelectedUrl = ((JSONObject)localObject3).optString("apcImg");
        a((ApolloActionPackage)localObject2, ((JSONObject)localObject3).optJSONObject("reddots"));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "ActionPackage pid = " + ((ApolloActionPackage)localObject2).packageId + " actionPackage.isUpdate = " + ((ApolloActionPackage)localObject2).isUpdate);
        }
        paramList1.add(localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "add actionPackage pid=" + ((ApolloActionPackage)localObject2).packageId);
        }
        localObject3 = ((JSONObject)localObject3).optJSONArray("actionSet");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          break label1569;
        }
        localObject4 = new StringBuilder();
        i2 = 0;
        if (i2 < ((JSONArray)localObject3).length())
        {
          localObject5 = ((JSONArray)localObject3).getJSONObject(i2);
          localObject6 = new ApolloActionPackageData();
          ((ApolloActionPackageData)localObject6).packageId = ((ApolloActionPackage)localObject2).packageId;
          ((ApolloActionPackageData)localObject6).acitonId = ((JSONObject)localObject5).optInt("actionId");
          ((ApolloActionPackageData)localObject6).text = ((JSONObject)localObject5).optString("text");
          ((ApolloActionPackageData)localObject6).textType = ((JSONObject)localObject5).optInt("textType");
          if (a(((ApolloActionPackageData)localObject6).acitonId, paramList))
          {
            paramList2.add(localObject6);
            if (((ApolloActionPackageData)localObject6).packageId == 5) {
              ((List)localObject1).add(Integer.valueOf(((ApolloActionPackageData)localObject6).acitonId));
            }
            ((StringBuilder)localObject4).append(((ApolloActionPackageData)localObject6).acitonId).append(" ");
            i2 += 1;
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloManager", 2, "action list has not packageAction id=" + ((ApolloActionPackageData)localObject6).acitonId);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label1742;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloManager", 1, "parse ActionInfo error:" + paramList);
        return;
      }
      QLog.d("ApolloManager", 2, new Object[] { "addActionPackageData packageId=", Integer.valueOf(((ApolloActionPackage)localObject2).packageId), " actionId=[", ((StringBuilder)localObject4).toString(), "]" });
      break label1742;
      label1569:
      if (((ApolloActionPackage)localObject2).type != 2)
      {
        paramList1.remove(localObject2);
        break label1742;
        label1590:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "[parseActionInfo] world action list=", localObject1 });
        }
        if ((localObject1 != null) && (((List)localObject1).size() > 0) && (paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          for (;;)
          {
            if (paramList.hasNext())
            {
              paramList1 = (ApolloActionData)paramList.next();
              if (((List)localObject1).contains(Integer.valueOf(paramList1.actionId)))
              {
                paramList1.hasExtraAction = true;
              }
              else
              {
                paramList1.hasExtraAction = false;
                continue;
                label1705:
                i2 += 1;
                break label606;
                label1714:
                i2 += 1;
                break label684;
                label1723:
                i2 += 1;
                break label772;
                label1732:
                i1 += 1;
                break;
              }
            }
          }
        }
        return;
      }
      label1742:
      i1 += 1;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    int i2 = Build.VERSION.SDK_INT;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optInt("all") == 1) {
        p = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ApolloManager", 2, "initTextureViewConfig jsonObject:" + paramJSONObject);
        }
        if (Build.MODEL.contains("MI 4")) {
          p = false;
        }
        QLog.i("ApolloManager", 2, "initTextureViewConfig sUseTextureViewConfig:" + p);
        return;
        JSONArray localJSONArray = paramJSONObject.optJSONArray("sdkIntArray");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          int i3 = localJSONArray.length();
          int i1 = 0;
          for (;;)
          {
            if (i1 >= i3) {
              break label166;
            }
            if (localJSONArray.optInt(i1) == i2)
            {
              p = true;
              break;
            }
            p = false;
            i1 += 1;
          }
        }
        else
        {
          label166:
          p = false;
        }
      }
    }
    boolean bool1 = bool2;
    if (i2 != 19) {
      if (i2 != 23) {
        break label203;
      }
    }
    label203:
    for (bool1 = bool2;; bool1 = false)
    {
      p = bool1;
      break;
    }
  }
  
  private void a(JSONObject paramJSONObject, List<ApolloWhiteFaceID> paramList)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("IDMap");
        if (paramJSONObject == null) {
          continue;
        }
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i1);
          if (localJSONObject != null)
          {
            ApolloWhiteFaceID localApolloWhiteFaceID = new ApolloWhiteFaceID();
            localApolloWhiteFaceID.terminalId = localJSONObject.optInt("terminalID");
            localApolloWhiteFaceID.action2d = localJSONObject.optInt("action2D");
            localApolloWhiteFaceID.action3d = localJSONObject.optInt("action3D");
            paramList.add(localApolloWhiteFaceID);
          }
          i1 += 1;
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloManager", 1, "parseWhiteFaceIdMapping:", paramJSONObject);
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    l1 = System.currentTimeMillis();
    bace.a(new File(aiys.c, "/def/basic").getAbsolutePath());
    do
    {
      try
      {
        long l2 = System.currentTimeMillis();
        a(BaseApplicationImpl.getApplication().getApplicationContext(), "apollo_def_rsc", aiys.jdField_a_of_type_JavaLangString + "/apollo_def_rsc");
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "copy file to sdcard cost:" + (l3 - l2));
        }
        new File(aiys.c, "def").mkdirs();
        int i1 = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), aiys.jdField_a_of_type_JavaLangString + "/apollo_def_rsc", aiys.c + "/def/");
        bace.d(aiys.jdField_a_of_type_JavaLangString + "/apollo_def_rsc");
        if (i1 != 0) {
          continue;
        }
        boolean bool2 = true;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
          bool1 = bool2;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloManager", 2, "errorInfo->" + localException.getMessage());
        return false;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label432;
        }
        QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
      }
      return bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, Boolean.valueOf(true));
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!b(paramContext)) {}
    do
    {
      return false;
      o();
    } while ((!s) && (!u));
    boolean bool1;
    if (paramBoolean.booleanValue())
    {
      if (!s) {
        break label90;
      }
      if (a(aing.a()) == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((!bool1) && (u)) {
        if (b(aing.a()) == 1) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        bool1 = false;
        break;
        bool1 = false;
        continue;
        return true;
      }
      label90:
      bool1 = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!b(BaseApplicationImpl.getContext()))
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] isHardwareSupport false");
      return false;
    }
    o();
    if (!u)
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] dpc switch off");
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = ((aifg)paramQQAppInterface.getManager(153)).a(paramQQAppInterface.c());
    if (localApolloBaseInfo == null)
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] no baseInfo");
      return false;
    }
    if ((localApolloBaseInfo.apolloStatus == 1) && (b(paramQQAppInterface) == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[is3dAvailable] is3dAvailable=", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public static boolean a(ApolloBaseInfo paramApolloBaseInfo)
  {
    boolean bool = true;
    if (paramApolloBaseInfo == null) {
      return false;
    }
    if (paramApolloBaseInfo.apolloStatus == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    String str = aiys.s + paramString1 + ".zip";
    localObject1 = aiys.s + paramString1 + ".patch";
    localObject2 = aiys.s + paramString1 + ".patched";
    paramString1 = new File(str);
    localObject1 = new File((String)localObject1);
    localObject2 = new File((String)localObject2);
    label250:
    do
    {
      try
      {
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        ((File)localObject2).createNewFile();
        if ((!paramString1.exists()) || (!paramString1.isFile()) || (!((File)localObject1).exists()) || (!((File)localObject1).isFile()) || (!BspatchUtil.a(paramString1.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath()))) {
          break label286;
        }
        ((File)localObject1).delete();
        paramString1.delete();
        ((File)localObject2).renameTo(paramString1);
        str = bech.a(paramString1);
        if ((str == null) || (str.equals(paramString2))) {
          break label250;
        }
        QLog.e("ApolloManager", 1, "md5 not match!");
        paramString1.delete();
      }
      catch (Exception paramString2)
      {
        QLog.e("ApolloManager", 1, "[patchGameRes] Exception:", paramString2);
        if (!paramString1.exists()) {
          break;
        }
        paramString1.delete();
        return false;
      }
      finally
      {
        if (!((File)localObject2).exists()) {
          break label397;
        }
        ((File)localObject2).delete();
        if (!((File)localObject1).exists()) {
          break label409;
        }
        ((File)localObject1).delete();
      }
      return false;
      QLog.i("ApolloManager", 1, "patch files succeed.");
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      return true;
      QLog.e("ApolloManager", 1, "patch game res error.");
      if (paramString1.exists()) {
        paramString1.delete();
      }
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
    } while (!((File)localObject1).exists());
    label286:
    ((File)localObject1).delete();
    return false;
  }
  
  public static int b(AppInterface paramAppInterface)
  {
    for (;;)
    {
      try
      {
        if (jdField_d_of_type_Int == -1)
        {
          jdField_d_of_type_Int = 0;
          if (paramAppInterface != null)
          {
            i1 = baig.r(paramAppInterface.getApplication());
            QLog.d("ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(i1) });
            if (i1 != 0) {
              continue;
            }
            jdField_d_of_type_Int = paramAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppInterface.getCurrentAccountUin() + "_3dwhiteList", 0);
            QLog.d("ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(i1), ", s3dWhiteUserStatus=", Integer.valueOf(jdField_d_of_type_Int) });
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        int i1;
        QLog.e("ApolloManager", 1, "[get3dWhiteListStatus] exception=", paramAppInterface);
        continue;
      }
      return jdField_d_of_type_Int;
      if (1 == i1) {
        jdField_d_of_type_Int = 1;
      }
    }
  }
  
  public static String b(String paramString, boolean paramBoolean)
  {
    String str1 = "";
    String str2;
    if ("mall".equals(paramString))
    {
      str1 = aiys.ah;
      str2 = str1;
      if (paramBoolean)
      {
        if (!"game_city".equals(paramString)) {
          break label111;
        }
        str2 = aiys.am;
      }
    }
    label111:
    do
    {
      return str2;
      if (("interact".equals(paramString)) || ("interactive".equals(paramString)))
      {
        str1 = aiys.ai;
        break;
      }
      if ("3d_mall".equals(paramString))
      {
        str1 = aiys.an;
        break;
      }
      if ((!"3d_interact".equals(paramString)) && (!"3d_interactive".equals(paramString))) {
        break;
      }
      str1 = aiys.ao;
      break;
      str2 = str1;
    } while (!"3d_game_city".equals(paramString));
    return aiys.ap;
  }
  
  public static void b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if ((localObject instanceof AppInterface))
        {
          localObject = ((AppInterface)localObject).getHandler(ApolloStoreActivity.class);
          if (localObject != null)
          {
            ((MqqHandler)localObject).sendEmptyMessage(258);
            QLog.i("ApolloStoreActivity", 1, "send refresh apollo view msg");
          }
        }
      }
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    int i1 = 3;
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i2 = (int)(paramJSONObject.optLong("startTime") / 1000L);
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
        if (i2 == localSharedPreferences.getInt("key_panel_bubble_start_time", 0)) {
          break;
        }
        DrawerPushItem localDrawerPushItem = new DrawerPushItem();
        localDrawerPushItem.is_reddot = 0;
        localDrawerPushItem.msg_id = "aio_panel_bubble_push";
        localDrawerPushItem.msg_type = 7;
        localDrawerPushItem.priority = 1000;
        localDrawerPushItem.start_ts = i2;
        localDrawerPushItem.end_ts = ((int)NetConnInfoCenter.getServerTime() + (int)(paramJSONObject.optLong("interval") / 1000L));
        localDrawerPushItem.send_time = i2;
        localDrawerPushItem.content = paramJSONObject.optString("bubbleText");
        localDrawerPushItem.show_counts = paramJSONObject.optInt("showCount");
        if (localDrawerPushItem.show_counts == 0) {
          localDrawerPushItem.show_counts = 1;
        }
        int i3 = paramJSONObject.optInt("packageId");
        if (ApolloActionPackage.is3DPackage(i3))
        {
          localDrawerPushItem.target_model = i1;
          c(localDrawerPushItem);
          paramJSONObject = localSharedPreferences.edit();
          paramJSONObject.putInt("key_panel_bubble_start_time", i2);
          if (i3 >= 0) {
            paramJSONObject.putInt("key_panel_bubble_tab", i3);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "checkPackageBubbleInfo", " push bubble:", localDrawerPushItem.toString(), " ,packageId", Integer.valueOf(i3) });
          }
          paramJSONObject.commit();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloManager", 1, "checkPackageBubbleInfo Exception:", paramJSONObject);
        return;
      }
      i1 = 2;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    boolean bool = e();
    f();
    if (!bool)
    {
      if (!TextUtils.isEmpty(aiys.au)) {
        break label25;
      }
      amap.c();
    }
    label25:
    while ((paramBoolean) || (!a(BaseApplicationImpl.getContext()))) {
      return;
    }
    akgx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    if (ApolloGameUtil.a()) {
      return false;
    }
    if (q) {
      return r;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      bool = true;
    }
    r = bool;
    if (!r)
    {
      q = true;
      return r;
    }
    if (paramContext != null)
    {
      r = c(paramContext);
      q = true;
    }
    return r;
  }
  
  public static int c(String paramString)
  {
    int i2 = 0;
    int i1;
    if (aiyr.b == null)
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloManager", 2, "queryApolloSwitchSet key:" + paramString + " sSwitchSet = null");
        i1 = i2;
      }
    }
    do
    {
      do
      {
        return i1;
        if (!"gameSwitch".equals(paramString)) {
          break;
        }
        i1 = i2;
      } while (!t);
      i2 = aiyr.b.optInt(paramString);
      i1 = i2;
    } while (i2 != 2);
    return jdField_e_of_type_Int;
    return aiyr.b.optInt(paramString);
  }
  
  public static boolean c()
  {
    if (aiyr.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "queryApolloSwitchSet sSwitchSet = null");
      }
    }
    do
    {
      do
      {
        return false;
        if (!aiyr.b.has("autoOpenBox")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "openBoxByH5 autoOpenBox:", Integer.valueOf(aiyr.b.optInt("autoOpenBox")) });
        }
      } while (aiyr.b.optInt("autoOpenBox") != 0);
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "openBoxByH5 not autoOpenBox");
    return false;
  }
  
  private static boolean c(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
        if (paramContext != null)
        {
          int i1 = paramContext.reqGlEsVersion;
          if (i1 >= 131072) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    QLog.e("ApolloManager", 2, "isOpenglSupport:" + paramContext.getMessage());
    return false;
  }
  
  public static void d(int paramInt)
  {
    QLog.i("ApolloManager", 1, "setsGameOidbStatus:" + paramInt);
    jdField_e_of_type_Int = paramInt >> 3 & 0x1;
  }
  
  public static boolean d()
  {
    return c("eggSwitch") == 1;
  }
  
  public static boolean e()
  {
    boolean bool2 = false;
    try
    {
      String str = aiys.av + "cmshow_script_engine.js";
      localFile = new File(str);
      bool1 = bool2;
      if (localFile.exists())
      {
        if (new ajav(str + ".sig", str).a(1)) {
          break label181;
        }
        QLog.w("ApolloManager", 1, "verify fails, path:" + str);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      File localFile;
      QLog.e("ApolloManager", 1, "initEngineScript:", localException);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "initEngineScript:", localOutOfMemoryError);
        continue;
        boolean bool1 = true;
      }
    }
    if (bool1)
    {
      jdField_d_of_type_JavaLangString = bace.b(localFile);
      return bool1;
    }
    QLog.w("ApolloManager", 1, "Fail to initEngineScript " + localFile.getAbsolutePath());
    return bool1;
  }
  
  public static boolean f()
  {
    boolean bool2 = false;
    try
    {
      String str = aiys.av + "cmshow_script_0.js";
      localFile = new File(str);
      bool1 = bool2;
      if (localFile.exists())
      {
        if (new ajav(str + ".sig", str).a(1)) {
          break label181;
        }
        QLog.w("ApolloManager", 1, "verify fails, path:" + str);
        bool1 = bool2;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("ApolloManager", 1, "[loadScript],OOM:", localOutOfMemoryError);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "[loadScript],", localThrowable);
        continue;
        boolean bool1 = true;
      }
    }
    if (bool1)
    {
      jdField_e_of_type_JavaLangString = bace.b(localFile);
      return bool1;
    }
    QLog.w("ApolloManager", 1, "Fail to read script file. " + localFile.getAbsolutePath());
    return bool1;
  }
  
  private void g(int paramInt)
  {
    String str = "action_red_tab_update_" + paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putLong(str, NetConnInfoCenter.getServerTimeMillis()).commit();
  }
  
  private void n()
  {
    this.jdField_a_of_type_Aifq = new aifq(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_APOLLO_STORE_CRASH_EVENT");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Aifq, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloManager", 1, "registerReceiver failed. ", localException);
    }
  }
  
  private static void o()
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.apollo_info.name(), "");
    if ((!TextUtils.isEmpty(str)) && (!str.equals(jdField_l_of_type_JavaLangString)))
    {
      jdField_l_of_type_JavaLangString = str;
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length > 0) {
        s = "1".equals(arrayOfString[0]);
      }
      if (arrayOfString.length > 1) {
        t = "1".equals(arrayOfString[1]);
      }
      if (arrayOfString.length > 2) {
        u = "1".equals(arrayOfString[2]);
      }
      QLog.d("ApolloManager", 1, new Object[] { "checkDpcSwitch, apolloInfo=", str, ", sApolloSwitch=", Boolean.valueOf(s), ", sCmGameDPCSwitch=", Boolean.valueOf(t), ", sCmShow3dDPCSwitch=", Boolean.valueOf(u) });
    }
  }
  
  private static void p()
  {
    ApolloManager.3 local3 = new ApolloManager.3();
    if (!jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      ThreadManager.post(local3, 8, null, false);
    }
  }
  
  /* Error */
  private void q()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 355
    //   11: iconst_2
    //   12: ldc_w 1663
    //   15: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 1665	aifg:v	Z
    //   22: ifne +550 -> 572
    //   25: aload_0
    //   26: getfield 1665	aifg:v	Z
    //   29: ifeq +4 -> 33
    //   32: return
    //   33: aload_0
    //   34: getfield 235	aifg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: ifnull +293 -> 330
    //   40: aload_0
    //   41: getfield 235	aifg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   47: astore 5
    //   49: invokestatic 796	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   52: lstore_3
    //   53: aload_0
    //   54: getfield 252	aifg:jdField_a_of_type_Atmp	Latmp;
    //   57: ldc 146
    //   59: invokevirtual 1668	atmp:a	(Ljava/lang/Class;)Ljava/util/List;
    //   62: checkcast 101	java/util/ArrayList
    //   65: astore 6
    //   67: aload 6
    //   69: ifnull +498 -> 567
    //   72: aload 6
    //   74: invokevirtual 1669	java/util/ArrayList:size	()I
    //   77: istore_1
    //   78: aload 6
    //   80: invokevirtual 1670	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   83: astore 7
    //   85: aload 7
    //   87: invokeinterface 542 1 0
    //   92: ifeq +254 -> 346
    //   95: aload 7
    //   97: invokeinterface 546 1 0
    //   102: checkcast 1672	atmo
    //   105: checkcast 146	com/tencent/mobileqq/data/ApolloBaseInfo
    //   108: astore 8
    //   110: aload 8
    //   112: ifnull -27 -> 85
    //   115: aload 8
    //   117: getfield 1675	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   120: invokestatic 407	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne -38 -> 85
    //   126: lload_3
    //   127: aload 8
    //   129: getfield 791	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignValidTS	J
    //   132: lcmp
    //   133: ifle +19 -> 152
    //   136: aload 8
    //   138: aload 8
    //   140: getfield 791	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignValidTS	J
    //   143: putfield 799	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalSignTs	J
    //   146: aload 8
    //   148: aconst_null
    //   149: putfield 1678	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignStr	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 155	aifg:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   156: astore 6
    //   158: aload 6
    //   160: monitorenter
    //   161: aload_0
    //   162: getfield 155	aifg:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   165: aload 8
    //   167: getfield 1675	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   170: aload 8
    //   172: invokevirtual 1683	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload 6
    //   178: monitorexit
    //   179: aload 8
    //   181: getfield 1675	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   184: aload 5
    //   186: invokevirtual 1364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifeq -104 -> 85
    //   192: aload_0
    //   193: aload 8
    //   195: putfield 413	aifg:jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo	Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   198: aload_0
    //   199: aload_0
    //   200: getfield 413	aifg:jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo	Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   203: getfield 1686	com/tencent/mobileqq/data/ApolloBaseInfo:apolloAISwitch	I
    //   206: iconst_0
    //   207: invokevirtual 1689	aifg:a	(II)V
    //   210: goto -125 -> 85
    //   213: astore 5
    //   215: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +15 -> 233
    //   221: ldc_w 355
    //   224: iconst_2
    //   225: ldc_w 1691
    //   228: aload 5
    //   230: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -204 -> 32
    //   239: aload_0
    //   240: getfield 235	aifg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: ifnull -211 -> 32
    //   246: aload_0
    //   247: getfield 155	aifg:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   250: aload_0
    //   251: getfield 235	aifg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   254: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   257: invokevirtual 1692	com/tencent/commonsdk/cache/QQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   260: checkcast 146	com/tencent/mobileqq/data/ApolloBaseInfo
    //   263: astore 5
    //   265: aload 5
    //   267: ifnull +9 -> 276
    //   270: aload 5
    //   272: getfield 388	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   275: istore_2
    //   276: ldc_w 355
    //   279: iconst_2
    //   280: new 327	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 1694
    //   290: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 155	aifg:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   297: invokevirtual 1695	com/tencent/commonsdk/cache/QQLruCache:size	()I
    //   300: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc_w 1697
    //   306: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: iload_1
    //   310: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1699
    //   316: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload_2
    //   320: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: return
    //   330: ldc_w 765
    //   333: astore 5
    //   335: goto -286 -> 49
    //   338: astore 5
    //   340: aload 6
    //   342: monitorexit
    //   343: aload 5
    //   345: athrow
    //   346: aload_0
    //   347: getfield 252	aifg:jdField_a_of_type_Atmp	Latmp;
    //   350: ldc_w 550
    //   353: invokevirtual 1668	atmp:a	(Ljava/lang/Class;)Ljava/util/List;
    //   356: checkcast 101	java/util/ArrayList
    //   359: astore 6
    //   361: aload 6
    //   363: ifnull +124 -> 487
    //   366: aload_0
    //   367: getfield 132	aifg:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   370: astore 5
    //   372: aload 5
    //   374: monitorenter
    //   375: aload_0
    //   376: getfield 135	aifg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   379: invokeinterface 1700 1 0
    //   384: invokestatic 1260	java/lang/System:currentTimeMillis	()J
    //   387: ldc2_w 1442
    //   390: ldiv
    //   391: lstore_3
    //   392: aload 6
    //   394: invokeinterface 537 1 0
    //   399: astore 6
    //   401: aload 6
    //   403: invokeinterface 542 1 0
    //   408: ifeq +76 -> 484
    //   411: aload 6
    //   413: invokeinterface 546 1 0
    //   418: checkcast 550	com/tencent/mobileqq/DrawerPushItem
    //   421: astore 7
    //   423: aload 7
    //   425: getfield 594	com/tencent/mobileqq/DrawerPushItem:end_ts	I
    //   428: i2l
    //   429: lload_3
    //   430: lcmp
    //   431: ifle +40 -> 471
    //   434: aload_0
    //   435: aload 7
    //   437: invokevirtual 683	aifg:a	(Lcom/tencent/mobileqq/DrawerPushItem;)Z
    //   440: ifne +31 -> 471
    //   443: aload_0
    //   444: getfield 135	aifg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   447: aload 7
    //   449: invokeinterface 687 2 0
    //   454: pop
    //   455: goto -54 -> 401
    //   458: astore 6
    //   460: aload 5
    //   462: monitorexit
    //   463: aload 6
    //   465: athrow
    //   466: astore 5
    //   468: goto -253 -> 215
    //   471: aload_0
    //   472: getfield 252	aifg:jdField_a_of_type_Atmp	Latmp;
    //   475: aload 7
    //   477: invokevirtual 1703	atmp:b	(Latmo;)Z
    //   480: pop
    //   481: goto -80 -> 401
    //   484: aload 5
    //   486: monitorexit
    //   487: aload_0
    //   488: getfield 235	aifg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   491: ifnull +61 -> 552
    //   494: aload_0
    //   495: getfield 235	aifg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   498: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   501: astore 5
    //   503: aload_0
    //   504: invokestatic 451	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   507: ldc_w 1705
    //   510: iconst_4
    //   511: invokevirtual 465	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   514: new 327	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   521: aload 5
    //   523: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc_w 1707
    //   529: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 1709
    //   535: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: ldc_w 765
    //   544: invokeinterface 1711 3 0
    //   549: putfield 1713	aifg:k	Ljava/lang/String;
    //   552: aload_0
    //   553: iconst_1
    //   554: putfield 1665	aifg:v	Z
    //   557: goto -324 -> 233
    //   560: astore 5
    //   562: iconst_0
    //   563: istore_1
    //   564: goto -349 -> 215
    //   567: iconst_0
    //   568: istore_1
    //   569: goto -223 -> 346
    //   572: iconst_0
    //   573: istore_1
    //   574: goto -341 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	aifg
    //   77	497	1	i1	int
    //   1	319	2	i2	int
    //   52	378	3	l1	long
    //   47	138	5	str1	String
    //   213	16	5	localOutOfMemoryError1	OutOfMemoryError
    //   263	71	5	localObject1	Object
    //   338	6	5	localObject2	Object
    //   466	19	5	localOutOfMemoryError2	OutOfMemoryError
    //   501	21	5	str2	String
    //   560	1	5	localOutOfMemoryError3	OutOfMemoryError
    //   458	6	6	localObject5	Object
    //   83	393	7	localObject6	Object
    //   108	86	8	localApolloBaseInfo	ApolloBaseInfo
    // Exception table:
    //   from	to	target	type
    //   78	85	213	java/lang/OutOfMemoryError
    //   85	110	213	java/lang/OutOfMemoryError
    //   115	152	213	java/lang/OutOfMemoryError
    //   152	161	213	java/lang/OutOfMemoryError
    //   179	210	213	java/lang/OutOfMemoryError
    //   343	346	213	java/lang/OutOfMemoryError
    //   161	179	338	finally
    //   340	343	338	finally
    //   375	401	458	finally
    //   401	455	458	finally
    //   460	463	458	finally
    //   471	481	458	finally
    //   484	487	458	finally
    //   346	361	466	java/lang/OutOfMemoryError
    //   366	375	466	java/lang/OutOfMemoryError
    //   463	466	466	java/lang/OutOfMemoryError
    //   487	552	466	java/lang/OutOfMemoryError
    //   552	557	466	java/lang/OutOfMemoryError
    //   49	67	560	java/lang/OutOfMemoryError
    //   72	78	560	java/lang/OutOfMemoryError
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "initApolloPandoraCache begin...");
    }
    try
    {
      ??? = (ArrayList)this.jdField_a_of_type_Atmp.a(ApolloPandora.class);
      if (??? != null)
      {
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext())
        {
          ApolloPandora localApolloPandora = (ApolloPandora)localIterator.next();
          if ((localApolloPandora != null) && (localApolloPandora.uin != null)) {
            synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localApolloPandora.uin, localApolloPandora);
            }
          }
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "initApolloPandoraCache oom", localOutOfMemoryError);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "initApolloPandoraCache end size:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
    }
  }
  
  public int a()
  {
    int i3 = 0;
    int i1 = -1;
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      i2 = i1;
    }
    int i4;
    do
    {
      boolean bool;
      do
      {
        return i2;
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
          i1 = 0;
        }
        bool = ApolloEngine.a();
        i4 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (i4 > 0) {
          i3 = 1;
        }
        i2 = i1;
      } while (!bool);
      i2 = i1;
    } while (i3 == 0);
    if (i4 == 1) {
      return 1;
    }
    return 6;
  }
  
  public int a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (this.j == null) {
          return -1;
        }
        JSONArray localJSONArray = new JSONArray(this.j);
        int i2 = localJSONArray.length();
        if (i1 >= i2) {
          continue;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
        if (localJSONObject.getInt("roleId") != paramInt) {
          continue;
        }
        localJSONArray = localJSONObject.getJSONArray("petStateMapping").getJSONObject(0).getJSONArray("actionSet");
        paramInt = localJSONArray.length();
        paramInt = ((Integer)localJSONArray.get(new Random().nextInt(paramInt))).intValue();
      }
      catch (Exception localException)
      {
        QLog.e("ApolloPet", 1, "getPetRandomAction error:", localException);
        paramInt = -1;
        continue;
      }
      return paramInt;
      i1 += 1;
    }
  }
  
  public int a(String paramString)
  {
    paramString = b(paramString);
    if ((paramString == null) || (paramString.apolloVipLevel < 1)) {
      return 1;
    }
    return paramString.apolloVipLevel;
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {}
    for (;;)
    {
      return 0L;
      JSONObject localJSONObject = null;
      if (paramInt1 == 3) {
        localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("action_version");
      }
      while (localJSONObject != null)
      {
        return localJSONObject.optLong(String.valueOf(paramInt2));
        if (paramInt1 == 2) {
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("dress_version");
        } else if (paramInt1 == 1) {
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("role_version");
        }
      }
    }
  }
  
  public aife a()
  {
    return this.jdField_a_of_type_Aife;
  }
  
  public aift a()
  {
    if (this.jdField_a_of_type_Aift == null) {}
    try
    {
      if (this.jdField_a_of_type_Aift == null) {
        this.jdField_a_of_type_Aift = new aift(this, null);
      }
      return this.jdField_a_of_type_Aift;
    }
    finally {}
  }
  
  public aify a()
  {
    return this.jdField_a_of_type_Aify;
  }
  
  public aijn a()
  {
    return this.jdField_a_of_type_Aijn;
  }
  
  public aily a()
  {
    try
    {
      if (this.jdField_a_of_type_Aily == null) {
        this.jdField_a_of_type_Aily = new aily(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aily localaily = this.jdField_a_of_type_Aily;
      return localaily;
    }
    finally {}
  }
  
  public aime a()
  {
    try
    {
      if (this.jdField_a_of_type_Aime == null) {
        this.jdField_a_of_type_Aime = new aime(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aime localaime = this.jdField_a_of_type_Aime;
      return localaime;
    }
    finally {}
  }
  
  public aimr a()
  {
    if (this.jdField_a_of_type_Aimr == null) {
      this.jdField_a_of_type_Aimr = new aimr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Aimr;
  }
  
  public aiud a()
  {
    if (this.jdField_a_of_type_Aiud == null) {
      this.jdField_a_of_type_Aiud = new aifi(this);
    }
    return this.jdField_a_of_type_Aiud;
  }
  
  public batr a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return ((bato)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(3);
  }
  
  public DrawerPushItem a(int paramInt)
  {
    int i1;
    switch (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
    default: 
      i1 = 0;
    }
    for (;;)
    {
      return a(paramInt, i1);
      i1 = 2;
      continue;
      i1 = 3;
    }
  }
  
  public DrawerPushItem a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      DrawerPushItem localDrawerPushItem;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          return null;
        }
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
        long l1 = System.currentTimeMillis() / 1000L;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_type != paramInt1) || (localDrawerPushItem.start_ts >= l1) || (localDrawerPushItem.end_ts <= l1) || (localDrawerPushItem.show_sum >= localDrawerPushItem.show_counts)) {
          continue;
        }
        if (((paramInt2 == 0) || (paramInt2 == 2)) && ((localDrawerPushItem.target_model == 0) || (localDrawerPushItem.target_model == 2))) {
          return localDrawerPushItem;
        }
      }
      if (localDrawerPushItem.target_model == paramInt2) {
        return localDrawerPushItem;
      }
    }
    return null;
  }
  
  public DrawerPushItem a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return null;
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      long l1 = System.currentTimeMillis() / 1000L;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_id.equals(paramString)) && (localDrawerPushItem.start_ts < l1) && (localDrawerPushItem.end_ts > l1)) {
          return localDrawerPushItem;
        }
      }
    }
    return null;
  }
  
  public DrawerPushItem a(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    if ((paramJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      paramString1 = null;
      return paramString1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "parseShopRedTouchManager:", paramJSONObject, ", isNewRed：", Boolean.valueOf(paramBoolean), ",msgType：", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      DrawerPushItem localDrawerPushItem;
      try
      {
        int i1 = paramJSONObject.optInt("time");
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
        if (i1 == localSharedPreferences.getInt(paramString1, 0))
        {
          paramJSONObject = a(paramString2);
          paramString1 = paramJSONObject;
          if (paramBoolean) {
            break;
          }
          if (paramJSONObject == null) {
            break label534;
          }
          b(paramString2);
          break label534;
        }
        paramJSONObject = paramJSONObject.optString("content");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONObject(paramJSONObject);
          localDrawerPushItem = new DrawerPushItem();
          localDrawerPushItem.is_reddot = 1;
          localDrawerPushItem.msg_id = paramString2;
          localDrawerPushItem.msg_type = paramInt;
          if (!paramJSONObject.has("mainPriority")) {
            return null;
          }
          localDrawerPushItem.priority = paramJSONObject.optInt("mainPriority");
          localDrawerPushItem.sub_priority = paramJSONObject.optInt("subPriority");
          localDrawerPushItem.start_ts = paramJSONObject.optInt("showTime");
          localDrawerPushItem.end_ts = paramJSONObject.optInt("expireTime");
          localDrawerPushItem.send_time = i1;
          localDrawerPushItem.action_id = paramJSONObject.optInt("actionId");
          localDrawerPushItem.color = paramJSONObject.optInt("fontColor");
          localDrawerPushItem.content = paramJSONObject.optString("bubbleText");
          localDrawerPushItem.bubble_res_id = paramJSONObject.optInt("bubbleID");
          localDrawerPushItem.icon_url = paramJSONObject.optString("iconUrl");
          localDrawerPushItem.life_Time = paramJSONObject.optInt("tipsDuration");
          paramInt = paramJSONObject.optInt("type");
          if (paramInt != 0) {
            break label496;
          }
          localDrawerPushItem.scheme = paramJSONObject.optString("scheme");
          localDrawerPushItem.show_counts = paramJSONObject.optInt("showCounts");
          long l1 = NetConnInfoCenter.getServerTime();
          if ((paramBoolean) && (localDrawerPushItem.start_ts < l1) && (localDrawerPushItem.end_ts > l1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "parseShopRedTouchManager addPushItem:", localDrawerPushItem.toString() });
            }
            c(localDrawerPushItem);
            localSharedPreferences.edit().putInt(paramString1, i1).commit();
            return localDrawerPushItem;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloManager", 2, "parseApolloRedTouchContent Exception:", paramString1);
      }
      return null;
      label496:
      if (paramInt == 1) {
        localDrawerPushItem.ext_url = aiys.T;
      } else if (paramInt == 2) {
        localDrawerPushItem.ext_url = paramJSONObject.optString("url");
      }
    }
    label534:
    return null;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ApolloActionData a(QQAppInterface paramQQAppInterface, String paramString, int... paramVarArgs)
  {
    if ((paramQQAppInterface == null) || (paramString == null) || (paramVarArgs == null)) {
      return null;
    }
    Object localObject = b(paramString);
    if (localObject == null) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    int i2 = paramVarArgs.length;
    int i1 = 0;
    if (i1 < i2)
    {
      int i3 = paramVarArgs[i1];
      if ((i3 == 4) && (!((ApolloBaseInfo)localObject).hasPet)) {}
      for (;;)
      {
        i1 += 1;
        break;
        localHashSet.add(Integer.valueOf(i3));
      }
    }
    for (;;)
    {
      try
      {
        paramString = a(paramQQAppInterface, paramString);
        if (paramString == null) {
          return null;
        }
        paramString = new JSONArray(paramString);
        i2 = paramString.length();
        paramVarArgs = new ArrayList();
        i1 = 0;
        if (i1 < i2)
        {
          localObject = paramString.getJSONObject(i1);
          if ((localObject == null) || (!localHashSet.contains(Integer.valueOf(((JSONObject)localObject).getInt("type"))))) {
            break label439;
          }
          paramVarArgs.add(localObject);
          break label439;
        }
        if (paramVarArgs.size() != 0)
        {
          paramString = (JSONObject)paramVarArgs.get(ApolloUtil.d(paramVarArgs.size()));
          if (paramString != null)
          {
            i2 = paramString.getInt("id");
            i1 = paramString.getInt("type");
            if (i2 <= 0) {
              break label437;
            }
            if (ApolloUtil.a(i2, 0))
            {
              paramQQAppInterface = new ApolloActionData();
              paramQQAppInterface.actionId = i2;
              if (i1 == 4) {
                paramQQAppInterface.actionType = 7;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloManager", 2, new Object[] { "getRandomAppearAction actionId:", Integer.valueOf(i2), ",type:", Integer.valueOf(i1) });
              }
              return paramQQAppInterface;
            }
          }
          else
          {
            QLog.e("ApolloManager", 1, "[getRandomAppearAction] found empty json obj");
            break label448;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label448;
          }
          QLog.d("ApolloManager", 2, "[getRandomAppearAction]found empty json arr ");
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("ApolloManager", 1, "[getRandomAppearAction]:" + paramQQAppInterface);
        return null;
      }
      paramString = new ApolloActionData();
      paramString.actionId = i2;
      paramVarArgs = ApolloUtil.a(paramString, 5);
      aitw.a(paramQQAppInterface, ApolloUtil.a(paramString, 4), paramVarArgs);
      QLog.w("ApolloManager", 2, "getRandomAppearAction action resource not ready,actionId:" + i2);
      label437:
      return null;
      label439:
      i1 += 1;
      continue;
      label448:
      i1 = 0;
      i2 = 0;
    }
  }
  
  public ApolloBaseInfo a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    if ((paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
    }
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(paramString)) {
      return (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloManager.15(this, paramString));
    return null;
  }
  
  public ApolloPandora a(String paramString, boolean paramBoolean)
  {
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    ApolloPandora localApolloPandora;
    do
    {
      do
      {
        return ???;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString)) {
          return (ApolloPandora)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        }
      } while (!paramBoolean);
      localApolloPandora = (ApolloPandora)this.jdField_a_of_type_Atmp.a(ApolloPandora.class, paramString);
      ??? = localApolloPandora;
    } while (localApolloPandora == null);
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localApolloPandora);
      return localApolloPandora;
    }
  }
  
  public File a(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return new File(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public File a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    return new File(ApolloUtil.a(paramApolloActionPackage));
  }
  
  public String a()
  {
    if ((!this.f) && (!this.jdField_l_of_type_Boolean)) {
      return ajjy.a(2131634668);
    }
    return ajjy.a(2131634665);
  }
  
  public String a(int paramInt)
  {
    Object localObject2;
    if (!new File(ApolloUtil.a(paramInt)).exists())
    {
      QLog.i("ApolloManager", 1, "[getApolloGameLocalVersion], errInfo->game main.lua file not exists, gameId:" + paramInt);
      localObject2 = "0.0";
      return localObject2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return "0.0";
    }
    Object localObject1 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    if (((aiyu)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
      ((aiyu)localObject1).a();
    }
    for (;;)
    {
      localObject2 = (String)((aiyu)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getString("apollo_game_ver_" + paramInt, "0.0");
        QLog.i("ApolloManager", 1, "read game ver from sp");
      }
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "gameVer:" + (String)localObject1 + ",id:" + paramInt);
      return localObject1;
      if (TextUtils.isEmpty((CharSequence)((aiyu)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)))) {
        ((aiyu)localObject1).a(paramInt);
      }
    }
  }
  
  public String a(int paramInt, String paramString)
  {
    int i2 = a(a());
    boolean bool = a(a());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("3d"))) {}
    for (paramInt = 2;; paramInt = 1)
    {
      Object localObject1 = "";
      int i1;
      if ((!bool) && (i2 == paramInt))
      {
        localObject1 = b(paramString, true);
        i1 = 1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (i1 == 0))
        {
          if (i2 != 2) {
            break label393;
          }
          localObject1 = aiys.ao;
        }
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (bool)
        {
          localObject2 = localObject1;
          if (i2 == 1)
          {
            localObject2 = localObject1;
            if (a() != null)
            {
              SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
              localObject3 = a().getCurrentAccountUin() + "_" + "sp_key_first_3d_tab";
              localObject2 = localObject1;
              if (!localSharedPreferences.getBoolean((String)localObject3, false))
              {
                localObject2 = localObject1;
                if (!TextUtils.isEmpty(aiys.ao))
                {
                  localObject2 = aiys.ao;
                  localObject1 = localSharedPreferences.edit();
                  ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject3, true);
                  ((SharedPreferences.Editor)localObject1).commit();
                }
              }
            }
          }
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getLastTabUrl userStatus:").append(i2).append(",tabStatus:").append(paramInt).append(",tabScheme:").append(paramString).append(",is3DAvailable:").append(bool).append(",url:").append((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, ((StringBuilder)localObject3).toString());
        }
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty(aiys.ao))
        {
          paramString = (String)localObject2;
          if (aiys.ao.equals(localObject2)) {
            paramString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, null);
          }
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject1 = aiys.ai;
          QLog.d("ApolloManager", 1, new Object[] { "url is empty", ((StringBuilder)localObject3).toString() });
        }
        return localObject1;
        i1 = 0;
        break;
        label393:
        if (bool) {
          localObject1 = aiys.aq;
        } else {
          localObject1 = aiys.ai;
        }
      }
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloBaseInfo localApolloBaseInfo = b(paramString);
    if (localApolloBaseInfo == null) {
      return null;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap.get(paramString) == null) {}
      for (long l1 = 0L; (localApolloBaseInfo.appearAction == null) && (NetConnInfoCenter.getServerTime() - l1 > 180L); l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "getApolloAppearAction request appear action uin:", paramString.substring(0, 4) });
        }
        ((baot)paramQQAppInterface.a(71)).a(new long[] { Long.parseLong(paramString) });
        this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
        return null;
      }
      if (localApolloBaseInfo.appearAction == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "getApolloAppearAction request appear action is null and last request is near");
        }
      }
      else
      {
        paramQQAppInterface = new JSONObject(localApolloBaseInfo.appearAction).optJSONArray("action").toString();
        return paramQQAppInterface;
      }
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("ApolloManager", 1, "getApolloAppearAction e:", paramQQAppInterface);
      return null;
    }
    return null;
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (!paramString1.contains("3d_interact"))) {}
    do
    {
      do
      {
        return paramString1;
        String str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramQQAppInterface.getCurrentAccountUin();
        }
        paramQQAppInterface = a(str);
      } while (paramQQAppInterface == null);
      paramString2 = paramQQAppInterface.getApolloDress3D();
    } while (paramString2 == null);
    paramQQAppInterface = paramString1;
    if (paramString2.jdField_a_of_type_JavaLangString != null) {
      paramQQAppInterface = befm.a(paramString1, "facedata", paramString2.jdField_a_of_type_JavaLangString);
    }
    paramString1 = paramQQAppInterface;
    if (paramString2.a() != null) {
      paramString1 = befm.a(paramQQAppInterface, "dressids", Arrays.toString(paramString2.a()).replaceAll(" ", ""));
    }
    return befm.a(paramString1, "roleid", String.valueOf(paramString2.jdField_a_of_type_Int));
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = b(paramString);
      if (paramString == null) {
        return "";
      }
      paramString = paramString.getApolloPetDress();
      if (paramString == null) {
        return "";
      }
      int i1 = paramString.jdField_a_of_type_Int;
      return String.valueOf(i1);
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return aiys.ai;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aiys.ao, paramString);
  }
  
  public WeakReference<BaseChatPie> a()
  {
    return this.jdField_b_of_type_JavaLangRefWeakReference;
  }
  
  public void a()
  {
    if (this.w) {
      return;
    }
    this.w = true;
    amap.b();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[downloadJson], task:" + paramInt);
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    if ((paramInt & 0x1) == 1)
    {
      ((List)localObject).add("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json");
      localArrayList.add(ApolloUtil.jdField_a_of_type_JavaLangString);
      localHashMap.put("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", new File(ApolloUtil.jdField_a_of_type_JavaLangString));
      localBundle.putInt("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", 1);
    }
    if (a() != null)
    {
      localObject = new batm((List)localObject, localHashMap, "apollo_json_task" + System.currentTimeMillis());
      ((batm)localObject).p = true;
      ((batm)localObject).j = false;
      ((batm)localObject).n = true;
      ((batm)localObject).s = false;
      ((batm)localObject).f = "apollo_res";
      ((batm)localObject).r = true;
      ((batm)localObject).q = true;
      a().a((batm)localObject, this.jdField_a_of_type_Batl, localBundle);
      if ((paramInt & 0x1) == 1) {
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_begin", 0, 0, new String[0]);
      }
      if ((paramInt & 0x2) == 2) {
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_begin", 1, 0, new String[0]);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    d(paramInt1);
    e(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    long l2 = 0L;
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    }
    String str;
    JSONObject localJSONObject1;
    if (paramInt1 == 3)
    {
      str = "action_version";
      if (str != null)
      {
        ??? = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(str);
        localJSONObject1 = ???;
        if (??? == null) {
          localJSONObject1 = new JSONObject();
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_OrgJsonJSONObject)
      {
        try
        {
          l1 = localJSONObject1.optLong(String.valueOf(paramInt2), 0L);
          l2 = l1;
          if (l1 == paramLong) {
            break label285;
          }
          l2 = l1;
          localJSONObject1.put(String.valueOf(paramInt2), paramLong);
          l2 = l1;
          this.jdField_a_of_type_OrgJsonJSONObject.put(str, localJSONObject1);
          i1 = 1;
          if (i1 != 0)
          {
            ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
            ThreadManager.getFileThreadHandler().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 6000L);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "saveLocalTS id: " + paramInt2 + ", old TS: " + l1 + ", new TS: " + paramLong + ", type: " + paramInt1);
            }
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.d("ApolloManager", 2, localException.getMessage());
        }
        if (paramInt1 == 2)
        {
          str = "dress_version";
          break;
        }
        if (paramInt1 == 1) {
          str = "role_version";
        }
      }
      Object localObject2 = null;
      break;
      label285:
      int i1 = 0;
      long l1 = l2;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    aiyu localaiyu = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    if (localaiyu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localaiyu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putString("apollo_game_ver_" + paramInt, paramString).commit();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloManager.8(this, paramBoolean, paramInt), 5, null, false);
  }
  
  /* Error */
  public void a(aifp paramaifp)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 2142	aifg:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 101	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 133	java/util/ArrayList:<init>	()V
    //   17: invokestatic 2146	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   20: putfield 2142	aifg:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   23: aload_0
    //   24: getfield 2142	aifg:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   27: astore_2
    //   28: aload_2
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 2142	aifg:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   34: aload_1
    //   35: invokeinterface 687 2 0
    //   40: pop
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_2
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	aifg
    //   0	56	1	paramaifp	aifp
    // Exception table:
    //   from	to	target	type
    //   30	43	46	finally
    //   47	49	46	finally
    //   2	23	51	finally
    //   23	30	51	finally
    //   49	51	51	finally
  }
  
  public void a(aifr paramaifr)
  {
    if (paramaifr == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[setApolloStatusUpdateListener] listener=", paramaifr });
    }
    this.jdField_c_of_type_JavaUtilList.add(new WeakReference(paramaifr));
  }
  
  public void a(ajat paramajat)
  {
    if (paramajat != null) {}
    try
    {
      if (this.jdField_a_of_type_Ajak != null) {
        this.jdField_a_of_type_Ajak.a(paramajat);
      }
      return;
    }
    finally
    {
      paramajat = finally;
      throw paramajat;
    }
  }
  
  public void a(DrawerPushItem paramDrawerPushItem)
  {
    ThreadManager.post(new ApolloManager.16(this, paramDrawerPushItem), 5, null, true);
  }
  
  public void a(DrawerPushItem paramDrawerPushItem, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if ((paramDrawerPushItem == null) || (paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    a(paramQQAppInterface, paramContext, paramDrawerPushItem.scheme, paramDrawerPushItem.ext_url, paramString);
  }
  
  public void a(DrawerPushItem paramDrawerPushItem, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!a(paramDrawerPushItem)))
      {
        this.jdField_a_of_type_JavaUtilList.add(paramDrawerPushItem);
        if ((this.jdField_a_of_type_Atmp != null) && (paramBoolean)) {
          this.jdField_a_of_type_Atmp.a(paramDrawerPushItem);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ApolloPushBubble", 2, "add red push item:" + paramDrawerPushItem);
        }
      }
      return;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (badq.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))) {}
    do
    {
      do
      {
        return;
        jdField_a_of_type_JavaUtilArrayList.clear();
      } while ((paramSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramSessionInfo.jdField_a_of_type_JavaLangString) != null));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (1 == b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "doAfterOpenAIO: apollo function is not opened status: " + b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    return;
    ThreadManager.getSubThreadHandler().post(new ApolloManager.9(this, paramSessionInfo));
  }
  
  public void a(ApolloPreDownloadData paramApolloPreDownloadData, String paramString1, String paramString2)
  {
    if ((paramApolloPreDownloadData == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("ApolloManager", 1, "preDownloadListener err param");
    }
    File localFile;
    for (;;)
    {
      return;
      try
      {
        localFile = new File(paramString1);
        if (localFile.exists())
        {
          String str = bech.a(localFile);
          if ((str != null) && (!str.equalsIgnoreCase(paramApolloPreDownloadData.md5)))
          {
            QLog.e("ApolloManager", 1, "preDownloadListener md5 not match!");
            localFile.delete();
            return;
          }
        }
      }
      catch (Exception paramApolloPreDownloadData)
      {
        QLog.e("ApolloManager", 1, "preDownloadListener fail zip file: " + paramString1, paramApolloPreDownloadData);
        return;
      }
    }
    bace.a(paramString1, paramString2, false);
    if (TextUtils.isEmpty(paramApolloPreDownloadData.zipDir)) {
      localFile.delete();
    }
    paramString2 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    paramApolloPreDownloadData.status = 1;
    paramString2.a(paramApolloPreDownloadData);
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "pre_download_res", 0, 0, new String[] { paramApolloPreDownloadData.reportId });
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (paramContext == null))
    {
      QLog.e("ApolloManager", 1, "openStoreByTabScheme context is null");
      return;
    }
    String str = b(paramString1, true);
    if (!TextUtils.isEmpty(str))
    {
      paramString2 = new Intent();
      if ("interact".equals(paramString1)) {
        paramString2.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
      }
      ApolloUtil.a(paramContext, paramString2, paramString3, str, null);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("url", paramString2);
      paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    QLog.w("ApolloManager", 1, "openStoreByTabScheme params is error");
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) && (!bace.a(ApolloUtil.a(paramApolloActionData, 7)))) {}
    while ((!a(bace.a(new File(ApolloUtil.a(paramApolloActionData, 7))), paramApolloActionData)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ((aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramApolloActionData);
  }
  
  public void a(ApolloActionData paramApolloActionData, Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("way");
    if (i1 == 1) {
      paramApolloActionData.feeType = 6;
    }
    while (i1 == 6)
    {
      paramApolloActionData.limitFree = 1;
      paramApolloActionData.limitStart = paramBundle.getLong("beginTs");
      paramApolloActionData.limitEnd = paramBundle.getLong("endts");
      return;
      if (i1 == 2) {
        paramApolloActionData.feeType = 7;
      } else if (i1 == 4) {
        paramApolloActionData.feeType = 2;
      }
    }
    paramApolloActionData.limitFree = 0;
    paramApolloActionData.obtainedTime = paramBundle.getLong("beginTs");
  }
  
  public void a(ApolloBaseInfo paramApolloBaseInfo)
  {
    if ((paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramApolloBaseInfo.uin))) {}
    for (;;)
    {
      return;
      int i1;
      if (paramApolloBaseInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = paramApolloBaseInfo;
        if ((paramApolloBaseInfo.cmshow3dFlag & 0x2) != 2) {
          break label214;
        }
        i1 = 1;
        c(i1);
      }
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramApolloBaseInfo.uin, paramApolloBaseInfo);
        a(paramApolloBaseInfo);
        if ((!QLog.isColorLevel()) || (!paramApolloBaseInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          continue;
        }
        QLog.d("ApolloManager", 2, "save apollo info vip status: " + paramApolloBaseInfo.apolloVipFlag + ", vip lev: " + paramApolloBaseInfo.apolloVipFlag + ", apollo status: " + paramApolloBaseInfo.apolloStatus + ", apollo local TS: " + paramApolloBaseInfo.apolloLocalTS + ", apollo svr TS:" + paramApolloBaseInfo.apolloServerTS + ", apollo upt TS:" + paramApolloBaseInfo.apolloUpdateTime + ", apollo AISwitch: " + paramApolloBaseInfo.apolloAISwitch);
        return;
        label214:
        i1 = 0;
      }
    }
  }
  
  public void a(ApolloPandora paramApolloPandora)
  {
    if ((paramApolloPandora == null) || (TextUtils.isEmpty(paramApolloPandora.uin))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramApolloPandora.uin, paramApolloPandora);
      a(paramApolloPandora);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnSubThread(new ApolloManager.18(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = jdField_b_of_type_Int;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString1, String paramString2, aifv paramaifv)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    batr localbatr;
    do
    {
      return;
      localbatr = a();
    } while ((localbatr == null) || (localbatr.a(paramString1) != null));
    File localFile = new File(paramString2);
    paramString2 = new batm(paramString1, localFile);
    if (localFile.exists())
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      paramString2.i = localSharedPreferences.getLong(paramString1 + "_lastModifiedTime", 0L);
      long l1 = localSharedPreferences.getLong(paramString1, 0L);
      if (localFile.lastModified() != l1) {
        paramString2.m = true;
      }
    }
    paramString2.p = true;
    paramString2.j = true;
    paramString2.n = true;
    paramString2.s = false;
    paramString2.f = "apollo_res";
    paramString2.r = true;
    paramString2.q = true;
    paramString1 = new Bundle();
    localbatr.a(paramString2, new aifw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaifv), paramString1);
  }
  
  public void a(WeakReference<BaseChatPie> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = paramWeakReference;
    aift localaift = a();
    if (paramWeakReference != null) {}
    for (boolean bool = true;; bool = false)
    {
      aift.a(localaift, bool);
      return;
    }
  }
  
  public void a(List<ApolloBaseInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloManager.11(this, paramList));
  }
  
  public void a(List<ApolloActionData> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Bundle localBundle;
    ArrayList localArrayList;
    do
    {
      HashMap localHashMap;
      do
      {
        return;
        localBundle = new Bundle();
        localArrayList = new ArrayList();
        localHashMap = new HashMap();
        a(localArrayList, localHashMap, paramList, localBundle);
      } while (localBundle.size() == 0);
      paramList = new batm(localArrayList, localHashMap, paramString);
      paramList.n = true;
      paramList.f = "apollo_res";
      paramList.p = true;
      paramList.s = false;
      paramList.r = true;
      paramList.q = true;
    } while ((localArrayList.size() == 0) || (a() == null));
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_begin", 0, 0, new String[0]);
    a().a(paramList, this.jdField_b_of_type_Batl, localBundle);
  }
  
  public void a(List<String> paramList, Map<String, File> paramMap, List<ApolloActionData> paramList1, Bundle paramBundle)
  {
    if ((paramList1 == null) || (paramList1.size() <= 0) || (paramList == null) || (paramMap == null)) {
      return;
    }
    int i1 = 0;
    label25:
    ApolloActionData localApolloActionData;
    String str1;
    Object localObject;
    String str2;
    String str3;
    if (i1 < paramList1.size())
    {
      localApolloActionData = (ApolloActionData)paramList1.get(i1);
      str1 = ApolloUtil.a(localApolloActionData, 1);
      localObject = ApolloUtil.a(localApolloActionData, 0);
      str2 = ApolloUtil.a(localApolloActionData, 5);
      str3 = ApolloUtil.a(localApolloActionData, 4);
      if (!apdh.a((String)localObject)) {
        break label216;
      }
      localObject = new batm(str1, new File((String)localObject));
      Bundle localBundle = new Bundle();
      localBundle.putSerializable(str1, localApolloActionData);
      ((batm)localObject).c = str1;
      ((batm)localObject).a(localBundle);
      this.jdField_b_of_type_Batl.onDoneFile((batm)localObject);
    }
    for (;;)
    {
      if (!ApolloUtil.a(localApolloActionData.actionId, localApolloActionData.personNum))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        if (paramBundle != null) {
          paramBundle.putSerializable(str2, localApolloActionData);
        }
      }
      i1 += 1;
      break label25;
      break;
      label216:
      paramList.add(str1);
      paramMap.put(str1, new File((String)localObject));
      if (paramBundle != null) {
        paramBundle.putSerializable(str1, localApolloActionData);
      }
    }
  }
  
  public void a(Map<String, ApolloPreDownloadData> paramMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMap == null) || (paramMap.size() == 0)) {}
    Bundle localBundle;
    do
    {
      ArrayList localArrayList;
      HashMap localHashMap;
      do
      {
        return;
        StringBuilder localStringBuilder1;
        StringBuilder localStringBuilder2;
        aiyu localaiyu;
        for (;;)
        {
          ApolloPreDownloadData localApolloPreDownloadData;
          try
          {
            localArrayList = new ArrayList();
            localHashMap = new HashMap();
            localBundle = new Bundle();
            localStringBuilder1 = new StringBuilder();
            localStringBuilder2 = new StringBuilder();
            localaiyu = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
            Map localMap = localaiyu.a();
            Iterator localIterator = paramMap.values().iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localApolloPreDownloadData = (ApolloPreDownloadData)localIterator.next();
            if ((TextUtils.isEmpty(localApolloPreDownloadData.resId)) || (TextUtils.isEmpty(localApolloPreDownloadData.dir)) || (TextUtils.isEmpty(localApolloPreDownloadData.md5)) || ((localApolloPreDownloadData.endTime > 0L) && (localApolloPreDownloadData.endTime < NetConnInfoCenter.getServerTime())))
            {
              localStringBuilder1.append(localApolloPreDownloadData.reportId).append(",");
              continue;
            }
            localObject = (ApolloPreDownloadData)localMap.get(localApolloPreDownloadData.resId);
          }
          catch (Exception paramMap)
          {
            QLog.e("ApolloManager", 1, "updateAndDownloadPreRes e:", paramMap);
            return;
          }
          Object localObject;
          if ((localObject == null) || (((ApolloPreDownloadData)localObject).status == 0) || (localApolloPreDownloadData.version > ((ApolloPreDownloadData)localObject).version))
          {
            localStringBuilder2.append(localApolloPreDownloadData.reportId).append(",ver:").append(localApolloPreDownloadData.version).append(" | ");
            localArrayList.add(localApolloPreDownloadData.url);
            if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir)) {}
            for (localObject = ApolloUtil.e(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.zipDir;; localObject = aiys.t + localApolloPreDownloadData.resId + ".zip")
            {
              localHashMap.put(localApolloPreDownloadData.url, new File((String)localObject));
              localBundle.putSerializable(localApolloPreDownloadData.url, localApolloPreDownloadData);
              break;
            }
          }
          localApolloPreDownloadData.status = 1;
        }
        localaiyu.a(paramMap, true);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "updateAndDownloadPreRes valid download:", localStringBuilder2.toString(), "\ninvalid config:", localStringBuilder1.toString() });
        }
      } while (localArrayList.size() <= 0);
      paramMap = new batm(localArrayList, localHashMap, "apollo_preDownload");
      paramMap.n = true;
      paramMap.f = "apollo_res";
      paramMap.p = true;
      paramMap.s = false;
      paramMap.r = true;
      paramMap.q = true;
      paramMap.jdField_b_of_type_Int = 0;
    } while (a() == null);
    a().a(paramMap, this.jdField_c_of_type_Batl, localBundle);
  }
  
  void a(boolean paramBoolean)
  {
    int i1 = c("gameBoxGrayStatus");
    if (i1 == 1) {
      this.jdField_e_of_type_Boolean = paramBoolean;
    }
    for (;;)
    {
      QLog.d("ApolloManager", 1, "upDateGameBoxUserStatus switch: " + i1 + ", oidb Status: " + paramBoolean);
      return;
      if (i1 == 2) {
        this.jdField_e_of_type_Boolean = true;
      } else {
        this.jdField_e_of_type_Boolean = false;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "checkApolloPanelJsonCfg begin..." + paramString + ",task:" + paramInt);
    }
    if ((paramBoolean) || (((paramInt & 0x1) == 1) && (!apdh.a(ApolloUtil.jdField_a_of_type_JavaLangString))))
    {
      a(paramInt);
      QLog.d("ApolloManager", 1, "checkApolloPanelJsonCfg download json  forceDownload is: " + paramBoolean);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    submsgtype0xdc.MsgBody localMsgBody = new submsgtype0xdc.MsgBody();
    for (;;)
    {
      int i1;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_msg_type.has()) {
          break label329;
        }
        i1 = localMsgBody.uint32_msg_type.get();
        if (!localMsgBody.minQqVer.has()) {
          break label334;
        }
        paramArrayOfByte = localMsgBody.minQqVer.get();
        if ((TextUtils.isEmpty(paramArrayOfByte)) || (aiyr.a("8.2.6", paramArrayOfByte) >= 0)) {
          break label334;
        }
        QLog.i("ApolloManager", 1, "decodeApolloBubblePushData push but cur version not support:" + paramArrayOfByte);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        label95:
        paramArrayOfByte.printStackTrace();
        label132:
        QLog.e("ApolloManager", 1, new Object[] { "[decodeApolloBubblePushData], errInfo->", paramArrayOfByte.getMessage() });
        return;
      }
      if (localMsgBody.rpt_msg_list.has())
      {
        paramArrayOfByte = localMsgBody.rpt_msg_list.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          a(i1, paramArrayOfByte);
        }
        QLog.i("ApolloManager", 1, "[decodeApolloBubblePushData], decode complete msgType:" + i1);
        return;
      }
      label329:
      label334:
      do
      {
        if ((i1 == 2) && (localMsgBody.rpt_msg_list_0x02.has()))
        {
          paramArrayOfByte = localMsgBody.rpt_msg_list_0x02.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
            break label132;
          }
          a(i1, paramArrayOfByte);
          break label132;
        }
        if ((i1 == 3) && (localMsgBody.rpt_msg_list.has()))
        {
          paramArrayOfByte = localMsgBody.rpt_msg_list.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
            break label132;
          }
          a(8, paramArrayOfByte);
          break label132;
        }
        if ((i1 != 201) || (!localMsgBody.rpt_msg_list_0x02.has())) {
          break label132;
        }
        paramArrayOfByte = localMsgBody.rpt_msg_list_0x02.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label132;
        }
        a(9, paramArrayOfByte);
        break label132;
        i1 = 0;
        break;
        if (i1 == 0) {
          break label95;
        }
      } while (i1 != 1);
    }
  }
  
  public boolean a(int paramInt, List<ApolloActionData> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if (paramList != null) {
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < paramList.size())
      {
        if (((ApolloActionData)paramList.get(i1)).actionId == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  protected boolean a(atmo paramatmo)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Atmp.a()) {
      if (paramatmo.getStatus() == 1000)
      {
        this.jdField_a_of_type_Atmp.b(paramatmo);
        if (paramatmo.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramatmo.getStatus() == 1001) || (paramatmo.getStatus() == 1002)) {
        return this.jdField_a_of_type_Atmp.a(paramatmo);
      }
    }
    QLog.e("ApolloManager", 2, "updateEntity em closed e=" + paramatmo.getTableName());
    return false;
  }
  
  boolean a(DrawerPushItem paramDrawerPushItem)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
      if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramDrawerPushItem.msg_id))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt)
  {
    return a(paramApolloActionData, paramInt, null);
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt, ajat paramajat)
  {
    if (paramApolloActionData == null) {}
    for (;;)
    {
      return false;
      if (azzz.b())
      {
        if (azzz.b() < 1048576L)
        {
          QLog.e("ApolloManager", 1, "1sdcardcheck,sdcard full .return. aid=" + paramApolloActionData.actionId);
          return false;
        }
      }
      else
      {
        QLog.e("ApolloManager", 1, "1sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionData.actionId);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download action res aid=" + paramApolloActionData.actionId);
      }
      Object localObject1;
      Object localObject2;
      int i1;
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action panelpic aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtil.a(paramApolloActionData, 1);
        localObject2 = ApolloUtil.a(paramApolloActionData, 0);
        if (!bace.a((String)localObject2))
        {
          localObject1 = new batm((String)localObject1, new File((String)localObject2));
          ((batm)localObject1).f = "apollo_res";
          ((batm)localObject1).jdField_b_of_type_Int = 1;
          ((batm)localObject1).n = true;
          ((batm)localObject1).q = true;
          ((batm)localObject1).r = true;
          i1 = bato.a((batm)localObject1, a());
          if (i1 != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + i1);
          }
        }
      }
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action gif aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtil.a(paramApolloActionData, 3);
        localObject2 = ApolloUtil.a(paramApolloActionData, 2);
        if (!bace.a((String)localObject2))
        {
          localObject1 = new batm((String)localObject1, new File((String)localObject2));
          ((batm)localObject1).f = "apollo_res";
          ((batm)localObject1).n = true;
          i1 = bato.a((batm)localObject1, a());
          if (i1 != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + i1);
          }
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action zip aid=" + paramApolloActionData.actionId);
        }
        localObject2 = ApolloUtil.a(paramApolloActionData, 5);
        localObject1 = ApolloUtil.a(paramApolloActionData, 4);
        if (!ApolloUtil.a(paramApolloActionData.actionId, paramApolloActionData.personNum))
        {
          localObject2 = new batm((String)localObject2, new File((String)localObject1));
          ((batm)localObject2).f = "apollo_res";
          ((batm)localObject2).jdField_b_of_type_Int = 1;
          ((batm)localObject2).n = true;
          ((batm)localObject2).q = true;
          ((batm)localObject2).r = true;
          paramInt = bato.a((batm)localObject2, a());
          if (paramInt != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + paramInt);
          }
        }
      }
      try
      {
        bace.a((String)localObject1, ApolloUtil.a(paramApolloActionData, 6), false);
        bace.d((String)localObject1);
        a(paramApolloActionData);
        if (paramajat != null) {
          if (!ApolloUtil.a(paramApolloActionData.actionId, paramApolloActionData.personNum))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ApolloManager", 2, "download finished, but rsc NOT complete.");
            return false;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "uncompresszip error" + localException.toString());
          }
        }
        paramajat.b(paramApolloActionData);
      }
    }
    return true;
  }
  
  public boolean a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {}
    label98:
    int i1;
    do
    {
      do
      {
        do
        {
          return false;
          if (!azzz.b()) {
            break;
          }
          if (azzz.b() >= 1048576L) {
            break label98;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ApolloManager", 2, "2sdcardcheck,sdcard full .return. aid=" + paramApolloActionPackage.packageId);
        return false;
      } while (!QLog.isColorLevel());
      QLog.e("ApolloManager", 2, "2sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionPackage.packageId);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download actionPackage tab pid=" + paramApolloActionPackage.packageId);
      }
      paramApolloActionPackage = new batm(ApolloUtil.b(paramApolloActionPackage), new File(ApolloUtil.a(paramApolloActionPackage)));
      paramApolloActionPackage.n = true;
      paramApolloActionPackage.f = "apollo_res";
      paramApolloActionPackage.jdField_b_of_type_Int = 1;
      paramApolloActionPackage.q = true;
      paramApolloActionPackage.r = true;
      i1 = bato.a(paramApolloActionPackage, a());
    } while (i1 != 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "ret:" + i1);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloVipFlag == 1;
    }
    return false;
  }
  
  public boolean a(String paramString, ApolloActionData paramApolloActionData)
  {
    int i2 = 0;
    if ((paramString == null) || (paramApolloActionData == null)) {
      bool2 = false;
    }
    do
    {
      for (;;)
      {
        return bool2;
        for (;;)
        {
          try
          {
            paramString = new JSONObject(paramString);
            bool1 = paramString.has("audio");
            if (!bool1) {
              continue;
            }
          }
          catch (Exception paramString)
          {
            Object localObject;
            int i1;
            boolean bool3;
            boolean bool1 = false;
            continue;
            bool2 = false;
            continue;
            i1 += 1;
            continue;
            i1 += 1;
            continue;
          }
          try
          {
            paramApolloActionData.hasSound = paramString.optJSONObject("audio").optBoolean("hasSound");
            bool2 = true;
            bool1 = bool2;
          }
          catch (Exception paramString)
          {
            bool1 = true;
            continue;
          }
          try
          {
            if (paramString.has("vibrate")) {
              bool1 = true;
            }
            bool2 = bool1;
            localObject = paramString.optJSONArray("vibrate");
            if (localObject != null)
            {
              bool2 = bool1;
              StringBuilder localStringBuilder = new StringBuilder(50);
              i1 = 0;
              bool2 = bool1;
              if (i1 < ((JSONArray)localObject).length())
              {
                bool2 = bool1;
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
                if (localJSONObject == null) {
                  continue;
                }
                bool2 = bool1;
                int i3 = localJSONObject.optInt("time");
                bool2 = bool1;
                int i4 = localJSONObject.optInt("duration");
                bool2 = bool1;
                localStringBuilder.append(i3).append(",").append(i4);
                bool2 = bool1;
                if (i1 >= ((JSONArray)localObject).length() - 1) {
                  continue;
                }
                bool2 = bool1;
                localStringBuilder.append(",");
                continue;
              }
              bool2 = bool1;
              paramApolloActionData.vibrate = localStringBuilder.toString();
            }
            bool2 = bool1;
            bool3 = paramString.has("bubbleText");
            if (!bool3) {
              continue;
            }
            bool1 = true;
          }
          catch (Exception paramString)
          {
            bool1 = bool2;
            continue;
            continue;
          }
          try
          {
            paramString = paramString.optJSONArray("bubbleText");
            if (paramString != null)
            {
              localObject = new StringBuilder(50);
              i1 = i2;
              if (i1 < paramString.length())
              {
                ((StringBuilder)localObject).append(paramString.getString(i1));
                if (i1 >= paramString.length() - 1) {
                  continue;
                }
                ((StringBuilder)localObject).append("@$");
                continue;
              }
              paramApolloActionData.bubbleText = ((StringBuilder)localObject).toString();
            }
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            if ((!paramApolloActionData.hasSound) && (TextUtils.isEmpty(paramApolloActionData.vibrate)))
            {
              bool2 = bool1;
              if (TextUtils.isEmpty(paramApolloActionData.bubbleText)) {
                break;
              }
            }
            QLog.d("ApolloManager", 2, "action id " + paramApolloActionData.actionId + ", name: " + paramApolloActionData.actionName + ", hasSound: " + paramApolloActionData.hasSound + ", vibrate=" + paramApolloActionData.vibrate + ", bubbleText =" + paramApolloActionData.bubbleText);
            return bool1;
          }
          catch (Exception paramString)
          {
            bool2 = bool1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloManager", 2, "parse action config.json error", paramString);
    return bool1;
  }
  
  public int b(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloStatus;
    }
    return 0;
  }
  
  public ApolloBaseInfo b(String paramString)
  {
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return ???;
      boolean bool = paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo != null)) {
        return this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
      }
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(paramString))
        {
          paramString = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
          return paramString;
        }
      }
      if ((0 == 0) && (!this.v))
      {
        ??? = (ApolloBaseInfo)this.jdField_a_of_type_Atmp.a(ApolloBaseInfo.class, paramString);
        if (bool) {
          this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = ((ApolloBaseInfo)???);
        }
        if (??? != null) {
          synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
          {
            this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, ???);
            ??? = ???;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloManager", 2, "unInit mApolloBaseInfoCache, find from db uin: " + ApolloUtil.d(paramString) + ", apollo status: " + ((ApolloBaseInfo)???).apolloStatus);
              return ???;
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(paramString))
        {
          ??? = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
          ??? = ???;
          if (??? == null)
          {
            ??? = new ApolloBaseInfo();
            ((ApolloBaseInfo)???).uin = paramString;
          }
          return ???;
        }
      }
      ??? = ???;
      try
      {
        if (!this.jdField_b_of_type_JavaUtilHashSet.contains(Long.valueOf(Long.parseLong(paramString)))) {
          break label406;
        }
        ??? = (ApolloBaseInfo)this.jdField_a_of_type_Atmp.a(ApolloBaseInfo.class, paramString);
        ??? = ???;
        if (??? == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, ???);
          ??? = ???;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloManager", 2, "mApolloBaseInfoCache unCache, mUnCacheUinSets contains, find from db uin: " + ApolloUtil.d(paramString) + ", apollo status: " + ((ApolloBaseInfo)???).apolloStatus);
          ??? = ???;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          ??? = ???;
          ??? = localNumberFormatException2;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        label390:
        break label390;
      }
      QLog.e("ApolloManager", 1, (Throwable)???, new Object[0]);
      ??? = ???;
      label406:
      ??? = ???;
      continue;
      ??? = null;
    }
  }
  
  public void b(int paramInt)
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_whiteList", paramInt).commit();
      i1 = baig.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      if (i1 != 0) {
        break label139;
      }
      jdField_c_of_type_Int = paramInt;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "update white list " + i1 + ", mWhiteUserStatus: " + jdField_c_of_type_Int + ", status: " + paramInt);
      }
      return;
      label139:
      if (1 == i1) {
        jdField_c_of_type_Int = 1;
      } else {
        jdField_c_of_type_Int = 0;
      }
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if ((!ApolloUtil.a(paramInt1, paramInt2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "start download action:" + paramInt1);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt1;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      aitw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, str);
    }
  }
  
  public void b(ajat paramajat)
  {
    if ((paramajat != null) && (this.jdField_a_of_type_Ajak != null)) {
      this.jdField_a_of_type_Ajak.b(paramajat);
    }
  }
  
  public void b(DrawerPushItem paramDrawerPushItem)
  {
    ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramDrawerPushItem.getTableName(), paramDrawerPushItem, 4, null);
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData != null)
    {
      Object localObject = new File(ApolloUtil.a(paramApolloActionData, 7));
      if (((File)localObject).exists()) {
        try
        {
          localObject = bace.a((File)localObject);
          if (new JSONObject((String)localObject).optLong("version") < paramApolloActionData.version)
          {
            boolean bool = apdh.c(ApolloUtil.a(paramApolloActionData, 6));
            URLDrawable.removeMemoryCacheByUrl(new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName).toString());
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "del old action res id:" + paramApolloActionData.actionId + ", ret: " + bool);
            }
          }
          else
          {
            a((String)localObject, paramApolloActionData);
            return;
          }
        }
        catch (Exception paramApolloActionData)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "checkActionVersion failed " + paramApolloActionData.toString());
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramString)))
        {
          localDrawerPushItem.show_sum = localDrawerPushItem.show_counts;
          this.jdField_a_of_type_JavaUtilList.remove(localDrawerPushItem);
          this.jdField_a_of_type_Atmp.b(localDrawerPushItem);
          if (QLog.isColorLevel()) {
            QLog.i("ApolloManager", 2, "remove bubble:" + localDrawerPushItem.msg_id);
          }
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ApolloManager", 2, "remove bubble failed:" + paramString);
    }
  }
  
  public void b(List<ApolloBaseInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (paramList.size() == 1)
      {
        a((ApolloBaseInfo)paramList.get(0));
        return;
      }
      Iterator localIterator = paramList.iterator();
      ApolloBaseInfo localApolloBaseInfo;
      while (localIterator.hasNext())
      {
        localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
        if (!TextUtils.isEmpty(localApolloBaseInfo.uin))
        {
          if (localApolloBaseInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localApolloBaseInfo;
          }
          synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
          {
            this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localApolloBaseInfo.uin, localApolloBaseInfo);
          }
        }
      }
      ??? = this.jdField_a_of_type_Atmp.a();
      ((atmr)???).a();
      try
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
          if (!TextUtils.isEmpty(localApolloBaseInfo.uin)) {
            a(localApolloBaseInfo);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((atmr)???).b();
        while ((QLog.isColorLevel()) && (paramList.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())))
        {
          paramList = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          QLog.d("ApolloManager", 2, "save apollo info vip flag: " + paramList.apolloVipFlag + ", level: " + paramList.apolloVipFlag + ", apollo status: " + paramList.apolloStatus + ", apollo local TS: " + paramList.apolloLocalTS + ", apollo svr TS:" + paramList.apolloServerTS + ", apollo upt TS:" + paramList.apolloUpdateTime);
          return;
          ((atmr)???).c();
          ((atmr)???).b();
        }
      }
      finally
      {
        ((atmr)???).b();
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "apollo json is parsing,return.");
      }
      return true;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Object localObject3 = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Object localObject1;
    int i1;
    label218:
    long l1;
    try
    {
      localObject1 = bace.b(new File(ApolloUtil.jdField_a_of_type_JavaLangString));
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("parseActionPanelJSon start file size:");
        if (localObject1 == null)
        {
          i1 = 0;
          QLog.d("ApolloManager", 2, i1 + " byte");
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label218;
        }
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("ApolloManager", 2, "read json fail e =" + localThrowable.toString());
          localObject1 = localObject3;
          continue;
          i1 = ((String)localObject1).length();
        }
      }
      l1 = System.currentTimeMillis();
    }
    for (;;)
    {
      int i2;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
          break label1233;
        }
        i1 = 1;
        localObject1 = new JSONObject((String)localObject1);
        localObject3 = ((JSONObject)localObject1).getJSONArray("tabList");
        i2 = 0;
        if (i2 < ((JSONArray)localObject3).length())
        {
          String str = ((JSONArray)localObject3).getString(i2);
          JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
          if ("actionInfo".equals(str))
          {
            a(localArrayList1, localArrayList2, localArrayList3, localJSONObject);
            if (!QLog.isColorLevel()) {
              break label1226;
            }
            QLog.d("ApolloManager", 2, "apollo json tablist :" + str);
            break label1226;
          }
          if (!"gameInfo".equals(str)) {
            continue;
          }
          continue;
        }
        b(((JSONObject)localObject1).optJSONObject("bubbleInfo"));
        if (((JSONObject)localObject1).has("Info3D"))
        {
          QLog.d("ApolloManager", 1, "parseActionPanelJSon parse info3d");
          localObject3 = ((JSONObject)localObject1).optJSONObject("Info3D");
          if (((JSONObject)localObject3).has("actionInfo")) {
            a(localArrayList1, localArrayList2, localArrayList3, ((JSONObject)localObject3).optJSONObject("actionInfo"));
          }
          if (((JSONObject)localObject3).has("appConfig")) {
            aifs.a(((JSONObject)localObject3).optJSONObject("appConfig"));
          }
          if (((JSONObject)localObject3).has("bubbleInfo"))
          {
            localObject3 = ((JSONObject)localObject3).optJSONObject("bubbleInfo");
            aift.a(a(), (JSONObject)localObject3);
          }
        }
        if (((JSONObject)localObject1).has("whiteFace")) {
          a(((JSONObject)localObject1).optJSONObject("whiteFace"), localArrayList4);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject3 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          ((aiyu)localObject3).a(false, localArrayList4);
          ((aiyu)localObject3).b();
          ((aiyu)localObject3).a(localArrayList1);
          ((aiyu)localObject3).b(1);
          ((aiyu)localObject3).c(localArrayList2);
          ((aiyu)localObject3).d();
          ((aiyu)localObject3).d(localArrayList3);
          if ((i1 == 0) && (!jdField_a_of_type_Boolean))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ApolloManager", 1, "parseActionPanelJSon request getUserApolloInfo~");
            }
            ((baot)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "refreshAction");
          }
          this.jdField_a_of_type_Ajak.a(Boolean.valueOf(true));
          m();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
          if (!((SharedPreferences)localObject3).getBoolean("8.2.6" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) {
            ((SharedPreferences)localObject3).edit().putBoolean("8.2.6" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
          }
          if (localObject1 != null)
          {
            i1 = (int)(((JSONObject)localObject1).optLong("timeStamp") / 1000L);
            ((SharedPreferences)localObject3).edit().putInt("apollo_json_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i1).commit();
            ((SharedPreferences)localObject3).edit().putInt("apollo_json_version", i1).commit();
          }
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("petConfig");
        if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_pet_sp", 0).edit().putString("pet_config", ((JSONArray)localObject1).toString()).commit();
          this.j = ((JSONArray)localObject1).toString();
          i2 = ((JSONArray)localObject1).length();
          i1 = 0;
          if (i1 < i2)
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i1);
            int i3 = ((JSONObject)localObject3).optInt("standUpAction", 0);
            int i4 = ((JSONObject)localObject3).optInt("getDownAction", 0);
            b(i3, 0);
            b(i4, 0);
            i1 += 1;
            continue;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          ((aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).l();
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloManager", 1, "parseActionPanelJSon failed", localException);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l1) + "ms");
        continue;
      }
      finally
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l1) + "ms");
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return true;
      label1226:
      i2 += 1;
      continue;
      label1233:
      i1 = 0;
    }
  }
  
  public boolean b(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return apdh.a(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public boolean b(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return false;
    }
    return apdh.a(ApolloUtil.a(paramApolloActionPackage));
  }
  
  public boolean b(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.isApolloGameWhiteUser();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ajak != null) {
      this.jdField_a_of_type_Ajak.a();
    }
  }
  
  public void c(int paramInt)
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_3dwhiteList", paramInt).commit();
      i1 = baig.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      if (i1 != 0) {
        break label137;
      }
      jdField_d_of_type_Int = paramInt;
    }
    for (;;)
    {
      QLog.d("ApolloManager", 1, new Object[] { "[update3dWhiteList] global=", Integer.valueOf(i1), ", s3dWhiteUserStatus=", Integer.valueOf(jdField_d_of_type_Int), ", status=", Integer.valueOf(paramInt) });
      return;
      label137:
      if (1 == i1) {
        jdField_d_of_type_Int = 1;
      } else {
        jdField_d_of_type_Int = 0;
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] previous3dFlag=", Integer.valueOf(paramInt1), ", new3dFlag=", Integer.valueOf(paramInt2) });
    if (((paramInt1 & 0x1) != (paramInt2 & 0x1)) || ((paramInt1 & 0x2) != (paramInt2 & 0x2)))
    {
      paramInt1 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.d("ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] currentStatus=", Integer.valueOf(paramInt1), ", is3dAvailable=", Boolean.valueOf(bool) });
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          aifr localaifr = (aifr)((WeakReference)localIterator.next()).get();
          if (localaifr != null) {
            localaifr.a(paramInt1, bool);
          }
        }
      }
    }
  }
  
  public void c(DrawerPushItem paramDrawerPushItem)
  {
    a(paramDrawerPushItem, true);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[updateLastShopTabInfo] tab=", paramString });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.k = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "sp_key_last_shop_tab";
    if (!TextUtils.isEmpty(paramString)) {
      localEditor.putString(str, this.k);
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.remove(str);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {}
    long l1;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    } while (l1 - localSharedPreferences.getLong("sp_key_apollo_check_action_time", 0L) <= 300L);
    akgx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    localSharedPreferences.edit().putLong("sp_key_apollo_check_action_time", l1).commit();
  }
  
  public void d(String paramString)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] predownloadStr=", paramString });
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.e("ApolloManager", 1, "[predownloadForGameCenter] mApp null");
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int i1;
      int i4;
      int i5;
      long l1;
      long l2;
      int i3;
      long l3;
      int i2;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("predownloadList");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break;
        }
        i1 = 0;
        if (i1 >= paramString.length()) {
          break;
        }
        localObject1 = paramString.getJSONObject(i1);
        i4 = ((JSONObject)localObject1).optInt("platform");
        i5 = ((JSONObject)localObject1).optInt("netType");
        l1 = ((JSONObject)localObject1).optLong("beginTime");
        l2 = ((JSONObject)localObject1).optLong("endTime");
        str1 = ((JSONObject)localObject1).optString("minQQVer");
        localObject2 = ((JSONObject)localObject1).optString("maxQQVer");
        i3 = mpl.a();
        l3 = NetConnInfoCenter.getServerTime();
        i2 = i3;
        if (i3 != 1) {
          break label514;
        }
        i2 = 10;
      }
      catch (Exception paramString)
      {
        Object localObject1;
        String str1;
        Object localObject2;
        String str2;
        QLog.e("ApolloManager", 1, "[predownloadForGameCenter] exception=", paramString);
        return;
      }
      if (aiyr.a("8.2.6", str1, (String)localObject2))
      {
        i2 = ((JSONObject)localObject1).optInt("type");
        str1 = ((JSONObject)localObject1).optString("downloadInfo");
        if (!TextUtils.isEmpty(str1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
          str2 = "sp_key_game_center_predownload_res_" + str1;
          i3 = ((SharedPreferences)localObject2).getInt(str2, -1);
          i4 = ((JSONObject)localObject1).optInt("configVer");
          boolean bool1;
          boolean bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] downloadInfo=", str1, ", downloadedVersion=", Integer.valueOf(i3), ", configVersion=", Integer.valueOf(i4) });
            break label551;
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] shouldDownload=", Boolean.valueOf(bool1), ", bid=", str1 });
            if (!bool1) {
              break label571;
            }
            ThreadManager.executeOnFileThread(new ApolloManager.21(this, str1, (SharedPreferences)localObject2, str2, i4));
            break label571;
            localObject1 = mol.a(str1);
            bool1 = bool2;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              continue;
            }
            localObject1 = new File((String)localObject1 + str1 + "/b.zip");
            bool1 = bool2;
            if (localObject1 == null) {
              continue;
            }
            bool1 = bool2;
            if (((File)localObject1).exists()) {
              continue;
            }
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] no zip file for bid:", str1 });
            bool1 = true;
            continue;
            label514:
            if ((i2 < i5) || (l3 < l1) || (l1 > l2)) {
              break label571;
            }
            if (i4 == 0) {
              continue;
            }
            if (i4 != 109) {
              break label571;
            }
            continue;
          }
          label551:
          if (i2 == 0)
          {
            bool2 = false;
            if (i4 <= i3) {
              continue;
            }
            bool1 = true;
            continue;
          }
        }
      }
      label571:
      i1 += 1;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ajak != null) {
      this.jdField_a_of_type_Ajak.a(Boolean.valueOf(true));
    }
  }
  
  public void e(int paramInt)
  {
    boolean bool = true;
    if (1 == (paramInt >> 10 & 0x1)) {}
    for (;;)
    {
      a(bool);
      return;
      bool = false;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ajak != null) {
      this.jdField_a_of_type_Ajak.a(Boolean.valueOf(true));
    }
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "pushApolloPanelGame gameId:", Integer.valueOf(paramInt) });
    }
    aiyu localaiyu = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    ApolloActionPackage localApolloActionPackage = localaiyu.a(100);
    if ((localApolloActionPackage != null) && (!localApolloActionPackage.isUpdate))
    {
      localApolloActionPackage.isUpdate = true;
      localaiyu.a(localApolloActionPackage);
    }
    ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, false);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(jdField_a_of_type_Int);
  }
  
  public boolean g()
  {
    boolean bool = false;
    if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_new_user_bar_showed" + aing.a().getCurrentAccountUin(), false)) || (this.i)) {
      bool = true;
    }
    return bool;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    akgx localakgx;
    do
    {
      return;
      localakgx = (akgx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(115);
    } while ((localakgx == null) || (!localakgx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    QLog.w("ApolloManager", 1, "config is done, then request update");
    ArrayList localArrayList = new ArrayList();
    localakgx.b(localArrayList);
    localakgx.a(localArrayList);
    localakgx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public boolean h()
  {
    boolean bool = false;
    if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_780_guide_showed" + aing.a().getCurrentAccountUin(), false)) || (this.m)) {
      bool = true;
    }
    return bool;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[removeAllS2CPushItem]");
    }
    ThreadManager.post(new ApolloManager.17(this), 5, null, true);
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return false;
      if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_white" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) || (this.g)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "isPlusWhiteList false");
    return false;
  }
  
  public void j()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList = null;
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_Aily != null;
  }
  
  public void k()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((aifp)localIterator.next()).a();
      }
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[checkCompat2DActionRsc]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      ApolloActionData localApolloActionData = ((aiyu)localObject).a(1450);
      if (localApolloActionData != null) {
        b(localApolloActionData.actionId, localApolloActionData.personNum);
      }
      localObject = ((aiyu)localObject).a(1454);
      if (localObject != null) {
        b(((ApolloActionData)localObject).actionId, ((ApolloActionData)localObject).personNum);
      }
    }
  }
  
  public void m()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject2 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localObject1 = ((aiyu)localObject2).d(400);
      if (((aiyu)localObject2).c(3000059) == null) {
        break label99;
      }
      if (localObject1 != null) {
        break label96;
      }
      localObject1 = new ArrayList();
      localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = 3000059;
      ((List)localObject1).add(localObject2);
    }
    label96:
    label99:
    for (;;)
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        a((List)localObject1, "apollo_key");
      }
      return;
      break;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "onDestroy.");
    }
    if (this.jdField_a_of_type_Aifq != null) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Aifq);
      this.jdField_a_of_type_Aifq = null;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "onDestroy. unregisterReceiver mBroadcastReceiver success");
      }
      this.w = false;
      ApolloUtil.c();
      jdField_c_of_type_Int = -1;
      jdField_d_of_type_Int = -1;
      this.jdField_a_of_type_Atmp.a();
      aitw.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      jdField_b_of_type_Boolean = false;
      com.tencent.mobileqq.apollo.view.ApolloPanel.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
        label133:
        jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        ApolloCmdChannel.checkNeedDestroy();
        if (this.jdField_a_of_type_Aify != null)
        {
          this.jdField_a_of_type_Aify.c();
          this.jdField_a_of_type_Aify = null;
        }
        ApolloGameStateMachine.d();
        ApolloGameUtil.a();
        this.jdField_a_of_type_Aife.b();
        ailn.a();
        aiyo.a();
        if (this.jdField_a_of_type_Aimr != null) {
          this.jdField_a_of_type_Aimr.b();
        }
        if (this.jdField_a_of_type_Aime != null)
        {
          this.jdField_a_of_type_Aime.e();
          this.jdField_a_of_type_Aime = null;
        }
        if (this.jdField_a_of_type_Aily != null)
        {
          this.jdField_a_of_type_Aily.c();
          this.jdField_a_of_type_Aily = null;
        }
        j();
        aind.a().a();
        aipp localaipp = aind.a().a();
        if (localaipp != null) {
          localaipp.a();
        }
        aixs.a().a();
        jdField_e_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_JavaUtilTimer != null)
        {
          this.jdField_a_of_type_JavaUtilTimer.cancel();
          this.jdField_a_of_type_JavaUtilTimer.purge();
          this.jdField_a_of_type_JavaUtilTimer = null;
        }
        return;
        localException1 = localException1;
        QLog.e("ApolloManager", 1, localException1, new Object[0]);
      }
      catch (Exception localException2)
      {
        break label133;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aifg
 * JD-Core Version:    0.7.0.1
 */