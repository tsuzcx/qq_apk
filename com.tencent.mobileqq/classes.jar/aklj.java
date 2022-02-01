import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.11;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.12;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.13;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.14;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.15;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.16;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.3;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.7;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.8;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletAioElem;
import tencent.im.oidb.cmd0x438.oidb_0x438.RedBagInfo;
import tencent.im.oidb.cmd0x438.oidb_0x438.ReqInfo;

public class aklj
  implements Manager
{
  public int a;
  private aklh jdField_a_of_type_Aklh;
  private aklr jdField_a_of_type_Aklr;
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler = new aklk(this, Looper.getMainLooper());
  private anti jdField_a_of_type_Anti;
  private antj jdField_a_of_type_Antj = new antj(this.jdField_a_of_type_AndroidOsHandler);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected Object a;
  public String a;
  public HashMap<String, akli> a;
  public List<akls> a;
  public Map<Integer, List<Pair<String, String>>> a;
  public boolean a;
  private final Object b;
  public HashMap<String, List<String>> b;
  public List<akls> b;
  public boolean b;
  public HashMap<String, List<String>> c;
  private List<String> c;
  public boolean c;
  public HashMap<String, String> d;
  public boolean d;
  public HashMap<String, MessageForFoldMsgGrayTips> e;
  public boolean e;
  public HashMap<String, MessageForFoldMsgGrayTips> f;
  private boolean f;
  public HashMap<String, String> g;
  private boolean g;
  public HashMap<String, String> h;
  private boolean h;
  private HashMap<String, String> jdField_i_of_type_JavaUtilHashMap;
  private boolean jdField_i_of_type_Boolean;
  private HashMap<String, String> jdField_j_of_type_JavaUtilHashMap;
  private boolean jdField_j_of_type_Boolean;
  
  public aklj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 10;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_g_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_h_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Aklh = new aklh(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Antj);
    this.jdField_a_of_type_Anti = ((anti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(76));
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new QQHashMap(1008, 0, 100);
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    c();
    try
    {
      paramQQAppInterface = new IntentFilter();
      this.jdField_a_of_type_Aklr = new aklr(this, null);
      paramQQAppInterface.addAction("grap_idiom_hb_result_action");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aklr, paramQQAppInterface);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("PasswdRedBagManager", 1, "regist RedPacketRefreshReceiver throw an excepion" + paramQQAppInterface);
    }
  }
  
  private akli a(SessionInfo paramSessionInfo, String paramString, Object[] paramArrayOfObject)
  {
    if (bgsp.a(paramString))
    {
      paramArrayOfObject = null;
      return paramArrayOfObject;
    }
    paramSessionInfo = a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_";
    Object localObject3 = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    Object localObject5;
    Object localObject4;
    if (localObject3 != null) {
      for (;;)
      {
        try
        {
          if (((List)localObject3).isEmpty()) {
            break;
          }
          localObject3 = ((List)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject3).next();
          localObject4 = paramSessionInfo + (String)localObject5;
          if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject4))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + (String)localObject4);
            continue;
          }
          localObject5 = (akli)this.jdField_a_of_type_JavaUtilHashMap.get(localObject5);
        }
        finally {}
        if (localObject5 != null) {
          ((List)localObject2).add(localObject5);
        } else if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + (String)localObject4);
        }
      }
    }
    localObject3 = new ArrayList();
    int m;
    int k;
    if (paramString.trim().length() > 1)
    {
      localObject4 = paramString.trim().substring(0, 1);
      if ((paramString.trim().length() == 4) || (a(paramString)))
      {
        localObject5 = ChnToSpell.a((String)localObject4);
        if ((localObject5 != null) && (localObject5.length > 0))
        {
          m = localObject5.length;
          k = 0;
        }
      }
    }
    for (;;)
    {
      Object localObject6;
      if (k < m)
      {
        localObject6 = localObject5[k];
        if (!bgsp.a((String)localObject6))
        {
          localObject6 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(((String)localObject6).trim());
          if ((localObject6 != null) && (!((List)localObject6).isEmpty())) {
            ((List)localObject3).addAll((Collection)localObject6);
          }
        }
      }
      else
      {
        if (b((String)localObject4))
        {
          localObject4 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(localObject4);
          if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
            ((List)localObject3).addAll((Collection)localObject4);
          }
        }
        paramString = paramString.trim();
        k = paramString.length();
        if (k > 1)
        {
          boolean bool1 = this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(k));
          boolean bool2 = this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(0));
          if ((bool1) || (bool2))
          {
            localObject4 = new ArrayList();
            if (bool2)
            {
              localObject5 = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
              if (localObject5 != null) {
                ((List)localObject4).addAll((Collection)localObject5);
              }
            }
            if (bool1)
            {
              localObject5 = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(k));
              if (localObject5 != null) {
                ((List)localObject4).addAll((Collection)localObject5);
              }
            }
            if (((List)localObject4).size() > 0)
            {
              localObject5 = new LinkedList();
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject6 = (Pair)((Iterator)localObject4).next();
                if ((!TextUtils.isEmpty((CharSequence)((Pair)localObject6).second)) && (paramString.contains((CharSequence)((Pair)localObject6).second))) {
                  ((List)localObject5).add(((Pair)localObject6).first);
                }
              }
              if (((List)localObject5).size() > 0) {
                ((List)localObject3).addAll((Collection)localObject5);
              }
            }
          }
        }
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          paramString = ((List)localObject3).iterator();
          while (paramString.hasNext())
          {
            localObject4 = (String)paramString.next();
            localObject3 = paramSessionInfo + (String)localObject4;
            if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject3))
            {
              if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + (String)localObject3);
              }
            }
            else
            {
              localObject4 = (akli)this.jdField_a_of_type_JavaUtilHashMap.get(localObject4);
              if (localObject4 != null) {
                ((List)localObject2).add(localObject4);
              } else if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + (String)localObject3);
              }
            }
          }
        }
        if (!((List)localObject2).isEmpty())
        {
          Collections.sort((List)localObject2, new akll(this));
          localObject2 = ((List)localObject2).iterator();
          paramString = null;
          while (((Iterator)localObject2).hasNext())
          {
            paramSessionInfo = (akli)((Iterator)localObject2).next();
            paramArrayOfObject[1] = Long.valueOf(paramSessionInfo.jdField_c_of_type_JavaLangString);
            if (4 == paramSessionInfo.jdField_a_of_type_Int)
            {
              paramArrayOfObject[2] = null;
              paramArrayOfObject[3] = null;
            }
            for (;;)
            {
              if (!paramSessionInfo.jdField_a_of_type_Boolean) {
                break label1056;
              }
              if ((4 != paramSessionInfo.jdField_a_of_type_Int) || (paramSessionInfo.jdField_b_of_type_Boolean) || (paramSessionInfo.a()) || (paramString != null)) {
                break;
              }
              paramString = paramSessionInfo;
              break;
              if ((!paramSessionInfo.jdField_c_of_type_Boolean) && (paramSessionInfo.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
              {
                paramArrayOfObject[2] = paramSessionInfo.jdField_a_of_type_JavaLangString;
                paramArrayOfObject[3] = paramSessionInfo.jdField_b_of_type_JavaLangString;
              }
            }
            label1056:
            if (paramSessionInfo.jdField_b_of_type_Boolean)
            {
              paramArrayOfObject[0] = Integer.valueOf(2);
            }
            else if ((paramSessionInfo.jdField_c_of_type_Boolean) || (paramSessionInfo.jdField_a_of_type_Long < NetConnInfoCenter.getServerTimeMillis() / 1000L))
            {
              if (!paramSessionInfo.jdField_c_of_type_Boolean) {
                b(paramSessionInfo.jdField_a_of_type_JavaLangString);
              }
              paramArrayOfObject[0] = Integer.valueOf(3);
            }
            else
            {
              if (4 != paramSessionInfo.jdField_a_of_type_Int) {
                paramSessionInfo.jdField_a_of_type_Boolean = true;
              }
              paramArrayOfObject[0] = Integer.valueOf(1);
            }
          }
        }
        for (;;)
        {
          paramArrayOfObject = paramSessionInfo;
          if (paramSessionInfo != null) {
            break;
          }
          return paramString;
          paramSessionInfo = null;
          continue;
          paramString = null;
          paramSessionInfo = null;
        }
      }
      k += 1;
    }
  }
  
  private String a(akli paramakli)
  {
    if (paramakli == null) {
      return "";
    }
    String str = "";
    if (bgsp.a(paramakli.e)) {
      str = paramakli.d;
    }
    while (bgsp.a(str))
    {
      return "";
      String[] arrayOfString = paramakli.e.trim().split("_");
      if (arrayOfString.length == 2)
      {
        str = arrayOfString[0];
        if (paramakli.a() == 2) {
          str = arrayOfString[1];
        }
      }
    }
    return str.trim();
  }
  
  public static String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "getLastIdiomPinyin|password: " + paramString);
    }
    if ((bgsp.a(paramString)) || (!paramString.contains("_"))) {
      return "";
    }
    paramString = paramString.split("_");
    if (paramString.length != 2) {
      return "";
    }
    return paramString[1];
  }
  
  /* Error */
  private void a(akli paramakli)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: getfield 352	akli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: astore 7
    //   9: aload_1
    //   10: getfield 364	akli:d	Ljava/lang/String;
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 132	aklj:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: aload 7
    //   21: aload_1
    //   22: invokevirtual 380	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: aload_1
    //   27: getfield 334	akli:jdField_a_of_type_Int	I
    //   30: ifne +161 -> 191
    //   33: aload_0
    //   34: getfield 121	aklj:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   37: aload 8
    //   39: invokevirtual 219	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 221	java/util/List
    //   45: astore 6
    //   47: aload 6
    //   49: ifnonnull +617 -> 666
    //   52: new 298	java/util/LinkedList
    //   55: dup
    //   56: invokespecial 299	java/util/LinkedList:<init>	()V
    //   59: astore 6
    //   61: aload_0
    //   62: getfield 121	aklj:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   65: aload 8
    //   67: aload 6
    //   69: invokevirtual 380	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload_0
    //   74: getfield 48	aklj:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   77: astore 8
    //   79: aload 8
    //   81: monitorenter
    //   82: aload 6
    //   84: invokeinterface 296 1 0
    //   89: istore 5
    //   91: iconst_0
    //   92: istore_2
    //   93: iload 4
    //   95: istore_3
    //   96: iload_2
    //   97: iload 5
    //   99: if_icmpge +58 -> 157
    //   102: aload 6
    //   104: iload_2
    //   105: invokeinterface 383 2 0
    //   110: checkcast 240	java/lang/String
    //   113: astore 9
    //   115: aload 9
    //   117: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +550 -> 670
    //   123: aload_0
    //   124: getfield 132	aklj:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   127: aload 9
    //   129: invokevirtual 219	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 255	akli
    //   135: astore 9
    //   137: aload 9
    //   139: ifnull +531 -> 670
    //   142: aload 9
    //   144: getfield 343	akli:jdField_a_of_type_Long	J
    //   147: aload_1
    //   148: getfield 343	akli:jdField_a_of_type_Long	J
    //   151: lcmp
    //   152: ifge +518 -> 670
    //   155: iload_2
    //   156: istore_3
    //   157: aload 6
    //   159: iload_3
    //   160: aload 7
    //   162: invokeinterface 386 3 0
    //   167: aload 8
    //   169: monitorexit
    //   170: return
    //   171: astore_1
    //   172: invokestatic 389	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   175: ifeq -8 -> 167
    //   178: aload_1
    //   179: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   182: goto -15 -> 167
    //   185: astore_1
    //   186: aload 8
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    //   191: aload_1
    //   192: getfield 334	akli:jdField_a_of_type_Int	I
    //   195: iconst_4
    //   196: if_icmpne +473 -> 669
    //   199: aload_1
    //   200: invokevirtual 369	akli:a	()I
    //   203: ifeq +19 -> 222
    //   206: aload_1
    //   207: invokevirtual 369	akli:a	()I
    //   210: iconst_1
    //   211: if_icmpeq +11 -> 222
    //   214: aload_1
    //   215: invokevirtual 369	akli:a	()I
    //   218: iconst_3
    //   219: if_icmpne +198 -> 417
    //   222: aload_1
    //   223: getfield 362	akli:e	Ljava/lang/String;
    //   226: invokestatic 394	aklj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   229: ldc_w 396
    //   232: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   235: astore 8
    //   237: aload 8
    //   239: arraylength
    //   240: istore 4
    //   242: iconst_0
    //   243: istore_3
    //   244: iload_3
    //   245: iload 4
    //   247: if_icmpge +422 -> 669
    //   250: aload 8
    //   252: iload_3
    //   253: aaload
    //   254: astore 9
    //   256: aload_0
    //   257: getfield 123	aklj:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   260: aload 9
    //   262: invokevirtual 219	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast 221	java/util/List
    //   268: astore 6
    //   270: aload 6
    //   272: ifnonnull +391 -> 663
    //   275: new 298	java/util/LinkedList
    //   278: dup
    //   279: invokespecial 299	java/util/LinkedList:<init>	()V
    //   282: astore 6
    //   284: aload_0
    //   285: getfield 123	aklj:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   288: aload 9
    //   290: aload 6
    //   292: invokevirtual 380	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: aload_0
    //   297: getfield 48	aklj:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   300: astore 9
    //   302: aload 9
    //   304: monitorenter
    //   305: aload 6
    //   307: invokeinterface 296 1 0
    //   312: istore 5
    //   314: iconst_0
    //   315: istore_2
    //   316: iload_2
    //   317: iload 5
    //   319: if_icmpge +339 -> 658
    //   322: aload 6
    //   324: iload_2
    //   325: invokeinterface 383 2 0
    //   330: checkcast 240	java/lang/String
    //   333: astore 10
    //   335: aload 10
    //   337: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifne +337 -> 677
    //   343: aload_0
    //   344: getfield 132	aklj:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   347: aload 10
    //   349: invokevirtual 219	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   352: checkcast 255	akli
    //   355: astore 10
    //   357: aload 10
    //   359: ifnull +318 -> 677
    //   362: aload 10
    //   364: getfield 343	akli:jdField_a_of_type_Long	J
    //   367: aload_1
    //   368: getfield 343	akli:jdField_a_of_type_Long	J
    //   371: lcmp
    //   372: ifge +305 -> 677
    //   375: aload 6
    //   377: iload_2
    //   378: aload 7
    //   380: invokeinterface 386 3 0
    //   385: aload 9
    //   387: monitorexit
    //   388: iload_3
    //   389: iconst_1
    //   390: iadd
    //   391: istore_3
    //   392: goto -148 -> 244
    //   395: astore 6
    //   397: invokestatic 389	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   400: ifeq -15 -> 385
    //   403: aload 6
    //   405: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   408: goto -23 -> 385
    //   411: astore_1
    //   412: aload 9
    //   414: monitorexit
    //   415: aload_1
    //   416: athrow
    //   417: aload_1
    //   418: invokevirtual 369	akli:a	()I
    //   421: iconst_2
    //   422: if_icmpne +247 -> 669
    //   425: aload_1
    //   426: invokevirtual 399	akli:a	()Ljava/util/List;
    //   429: invokeinterface 229 1 0
    //   434: astore 8
    //   436: aload 8
    //   438: invokeinterface 234 1 0
    //   443: ifeq +226 -> 669
    //   446: aload 8
    //   448: invokeinterface 238 1 0
    //   453: checkcast 285	java/lang/Integer
    //   456: invokevirtual 402	java/lang/Integer:intValue	()I
    //   459: istore_2
    //   460: aload_0
    //   461: getfield 125	aklj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   464: iload_2
    //   465: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: invokeinterface 293 2 0
    //   473: checkcast 221	java/util/List
    //   476: astore 6
    //   478: aload 6
    //   480: ifnonnull +175 -> 655
    //   483: new 298	java/util/LinkedList
    //   486: dup
    //   487: invokespecial 299	java/util/LinkedList:<init>	()V
    //   490: astore 6
    //   492: aload_0
    //   493: getfield 125	aklj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   496: iload_2
    //   497: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aload 6
    //   502: invokeinterface 403 3 0
    //   507: pop
    //   508: aload_0
    //   509: getfield 48	aklj:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   512: astore 9
    //   514: aload 9
    //   516: monitorenter
    //   517: aload 6
    //   519: invokeinterface 296 1 0
    //   524: istore_3
    //   525: iconst_0
    //   526: istore_2
    //   527: iload_2
    //   528: iload_3
    //   529: if_icmpge +121 -> 650
    //   532: aload 6
    //   534: iload_2
    //   535: invokeinterface 383 2 0
    //   540: checkcast 301	android/util/Pair
    //   543: getfield 317	android/util/Pair:first	Ljava/lang/Object;
    //   546: checkcast 240	java/lang/String
    //   549: astore 10
    //   551: aload 10
    //   553: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   556: ifne +71 -> 627
    //   559: aload_0
    //   560: getfield 132	aklj:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   563: aload 10
    //   565: invokevirtual 219	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   568: checkcast 255	akli
    //   571: astore 10
    //   573: aload 10
    //   575: ifnull +52 -> 627
    //   578: aload 10
    //   580: getfield 343	akli:jdField_a_of_type_Long	J
    //   583: aload_1
    //   584: getfield 343	akli:jdField_a_of_type_Long	J
    //   587: lcmp
    //   588: ifge +39 -> 627
    //   591: aload 6
    //   593: iload_2
    //   594: new 301	android/util/Pair
    //   597: dup
    //   598: aload 7
    //   600: aload_1
    //   601: getfield 362	akli:e	Ljava/lang/String;
    //   604: invokestatic 394	aklj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   607: invokespecial 406	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   610: invokeinterface 386 3 0
    //   615: aload 9
    //   617: monitorexit
    //   618: goto -182 -> 436
    //   621: astore_1
    //   622: aload 9
    //   624: monitorexit
    //   625: aload_1
    //   626: athrow
    //   627: iload_2
    //   628: iconst_1
    //   629: iadd
    //   630: istore_2
    //   631: goto -104 -> 527
    //   634: astore 6
    //   636: invokestatic 389	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   639: ifeq -24 -> 615
    //   642: aload 6
    //   644: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   647: goto -32 -> 615
    //   650: iconst_0
    //   651: istore_2
    //   652: goto -61 -> 591
    //   655: goto -147 -> 508
    //   658: iconst_0
    //   659: istore_2
    //   660: goto -285 -> 375
    //   663: goto -367 -> 296
    //   666: goto -593 -> 73
    //   669: return
    //   670: iload_2
    //   671: iconst_1
    //   672: iadd
    //   673: istore_2
    //   674: goto -581 -> 93
    //   677: iload_2
    //   678: iconst_1
    //   679: iadd
    //   680: istore_2
    //   681: goto -365 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	aklj
    //   0	684	1	paramakli	akli
    //   92	589	2	k	int
    //   95	435	3	m	int
    //   1	247	4	n	int
    //   89	231	5	i1	int
    //   45	331	6	localObject1	Object
    //   395	9	6	localThrowable1	Throwable
    //   476	116	6	localObject2	Object
    //   634	9	6	localThrowable2	Throwable
    //   7	592	7	str	String
    //   13	434	8	localObject3	Object
    //   333	246	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   82	91	171	java/lang/Throwable
    //   102	137	171	java/lang/Throwable
    //   142	155	171	java/lang/Throwable
    //   157	167	171	java/lang/Throwable
    //   82	91	185	finally
    //   102	137	185	finally
    //   142	155	185	finally
    //   157	167	185	finally
    //   167	170	185	finally
    //   172	182	185	finally
    //   186	189	185	finally
    //   305	314	395	java/lang/Throwable
    //   322	357	395	java/lang/Throwable
    //   362	375	395	java/lang/Throwable
    //   375	385	395	java/lang/Throwable
    //   305	314	411	finally
    //   322	357	411	finally
    //   362	375	411	finally
    //   375	385	411	finally
    //   385	388	411	finally
    //   397	408	411	finally
    //   412	415	411	finally
    //   517	525	621	finally
    //   532	573	621	finally
    //   578	591	621	finally
    //   591	615	621	finally
    //   615	618	621	finally
    //   622	625	621	finally
    //   636	647	621	finally
    //   517	525	634	java/lang/Throwable
    //   532	573	634	java/lang/Throwable
    //   578	591	634	java/lang/Throwable
    //   591	615	634	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    aklj localaklj = (aklj)paramQQAppInterface.getManager(125);
    if (!localaklj.jdField_b_of_type_Boolean)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "redbag_fold_msg_config_version"))
      {
        localaklj.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_msg_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT);
        localaklj.jdField_a_of_type_Int = paramQQAppInterface.getInt(str + "_" + "redbag_fold_msg_num", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT);
        localaklj.jdField_d_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX);
        localaklj.jdField_e_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_with_redbagid", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("getFoldSwitch, first init, switch: %s, num: %d, indexSwitch: %s, indexWithId: %s ", new Object[] { Boolean.valueOf(localaklj.jdField_c_of_type_Boolean), Integer.valueOf(localaklj.jdField_a_of_type_Int), Boolean.valueOf(localaklj.jdField_d_of_type_Boolean), Boolean.valueOf(localaklj.jdField_e_of_type_Boolean) }));
      }
    }
    localaklj.jdField_b_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    bool6 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    i2 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    bool5 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    bool4 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    int i9 = 0;
    i1 = 0;
    int i10 = 0;
    i8 = 0;
    int i11 = 0;
    n = 0;
    i7 = 0;
    int i12 = 0;
    k = 0;
    i3 = i11;
    i4 = i12;
    i5 = i10;
    i6 = i9;
    bool1 = bool4;
    bool2 = bool5;
    m = i2;
    bool3 = bool6;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.split("\\|");
          i3 = i11;
          i4 = i12;
          i5 = i10;
          i6 = i9;
          bool1 = bool4;
          bool2 = bool5;
          m = i2;
          bool3 = bool6;
          if (paramString != null)
          {
            i10 = paramString.length;
            i8 = 0;
            i3 = 0;
            n = 0;
            bool1 = bool4;
            i1 = 0;
            bool3 = bool6;
            m = i2;
            bool2 = bool5;
            i2 = i3;
            if (i8 >= i10) {
              continue;
            }
            arrayOfString1 = paramString[i8];
          }
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString1;
        String[] arrayOfString2;
        label246:
        k = i8;
        i3 = n;
        i4 = i7;
        i5 = k;
        i6 = i1;
        bool1 = bool4;
        bool2 = bool5;
        m = i2;
        bool3 = bool6;
        if (QLog.isColorLevel())
        {
          QLog.e("msgFold", 2, "updatePasswdMsgFodConfig error " + paramString.getMessage());
          bool3 = bool6;
          m = i2;
          bool2 = bool5;
          bool1 = bool4;
          i6 = i1;
          i5 = k;
          i4 = i7;
          i3 = n;
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("received RedBagFoldMsgConfig remote version: %d, msgFoldSwitch: %s, msgFoldNum: %s, msgFoldIndexSwitch: %s, msgFoldIndexWithId: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool3), Integer.valueOf(m), Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        }
        if ((i5 == 0) || (i6 == 0) || (i3 == 0) || (i4 == 0))
        {
          bool1 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
          k = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
          bool2 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
          bool3 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
          paramString = (aklj)paramQQAppInterface.getManager(125);
          paramString.jdField_b_of_type_Boolean = true;
          paramString.jdField_c_of_type_Boolean = bool1;
          paramString.jdField_a_of_type_Int = k;
          paramString.jdField_d_of_type_Boolean = bool2;
          paramString.jdField_e_of_type_Boolean = bool3;
          bgsg.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), paramInt, bool1, k, bool2, bool3);
          return;
        }
        i3 = n;
        i4 = k;
        i5 = i1;
        i6 = i2;
        continue;
        if (i1 != 1) {
          continue;
        }
        bool2 = true;
        m = 1;
        bool4 = bool2;
        continue;
      }
      try
      {
        if (!arrayOfString1.contains("msgfold_switch")) {
          continue;
        }
        arrayOfString2 = arrayOfString1.split("=");
        if ((arrayOfString2 == null) || (arrayOfString2.length != 2)) {
          continue;
        }
        i3 = Integer.valueOf(arrayOfString2[1].trim()).intValue();
        if ((i3 != 1) && (i3 != 0)) {
          continue;
        }
        if (i3 != 1) {
          continue;
        }
        bool3 = true;
        i2 = 1;
      }
      catch (Exception paramString)
      {
        i7 = k;
        k = i1;
        i1 = i2;
        bool4 = bool1;
        bool5 = bool2;
        i2 = m;
        bool6 = bool3;
        continue;
      }
    }
    i4 = i1;
    i3 = m;
    i7 = n;
    i6 = i1;
    bool5 = bool2;
    i5 = m;
    for (;;)
    {
      try
      {
        if (arrayOfString1.contains("msgfold_num"))
        {
          i7 = n;
          i6 = i1;
          bool5 = bool2;
          i5 = m;
          arrayOfString2 = arrayOfString1.split("=");
          i4 = i1;
          i3 = m;
          if (arrayOfString2 != null)
          {
            i4 = i1;
            i3 = m;
            i7 = n;
            i6 = i1;
            bool5 = bool2;
            i5 = m;
            if (arrayOfString2.length == 2)
            {
              i7 = n;
              i6 = i1;
              bool5 = bool2;
              i5 = m;
              i9 = Integer.valueOf(arrayOfString2[1].trim()).intValue();
              i4 = i1;
              i3 = m;
              if (i9 >= 0)
              {
                i4 = 1;
                i3 = i9;
              }
            }
          }
        }
        m = n;
        bool4 = bool2;
        i7 = n;
        i6 = i4;
        bool5 = bool2;
        i5 = i3;
        if (arrayOfString1.contains("Index_switch"))
        {
          i7 = n;
          i6 = i4;
          bool5 = bool2;
          i5 = i3;
          arrayOfString2 = arrayOfString1.split("=");
          m = n;
          bool4 = bool2;
          if (arrayOfString2 != null)
          {
            m = n;
            bool4 = bool2;
            i7 = n;
            i6 = i4;
            bool5 = bool2;
            i5 = i3;
            if (arrayOfString2.length == 2)
            {
              i7 = n;
              i6 = i4;
              bool5 = bool2;
              i5 = i3;
              i1 = Integer.valueOf(arrayOfString2[1].trim()).intValue();
              if (i1 == 1) {
                break label1101;
              }
              m = n;
              bool4 = bool2;
              if (i1 == 0) {
                break label1101;
              }
            }
          }
        }
        i7 = m;
        i6 = i4;
        bool5 = bool4;
        i5 = i3;
        if (!arrayOfString1.contains("with_redbagid")) {
          continue;
        }
        i7 = m;
        i6 = i4;
        bool5 = bool4;
        i5 = i3;
        arrayOfString1 = arrayOfString1.split("=");
        if (arrayOfString1 == null) {
          continue;
        }
        i7 = m;
        i6 = i4;
        bool5 = bool4;
        i5 = i3;
        if (arrayOfString1.length != 2) {
          continue;
        }
        i7 = m;
        i6 = i4;
        bool5 = bool4;
        i5 = i3;
        n = Integer.valueOf(arrayOfString1[1].trim()).intValue();
        if ((n != 1) && (n != 0)) {
          continue;
        }
        if (n != 1) {
          continue;
        }
        bool1 = true;
        k = 1;
      }
      catch (Exception paramString)
      {
        n = i7;
        i1 = i2;
        i7 = k;
        k = i6;
        bool4 = bool1;
        i2 = i5;
        bool6 = bool3;
        continue;
        bool4 = bool3;
        bool3 = bool1;
        k = m;
        bool1 = bool4;
        continue;
        continue;
      }
      i8 += 1;
      n = m;
      i1 = i4;
      bool2 = bool4;
      m = i3;
      break;
      bool3 = false;
      break label246;
      bool2 = false;
      break label1110;
      bool1 = false;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      a(false);
      if ((paramBoolean) && ((paramInt == 1) || (paramInt == 3000))) {
        akrp.a(paramString2, paramInt, paramString1);
      }
      paramString2 = (akli)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while ((paramString2 == null) || (paramString2.jdField_a_of_type_Boolean == paramBoolean));
    paramString2.jdField_a_of_type_Boolean = paramBoolean;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.15(this, paramString1, paramBoolean));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((aklj)paramQQAppInterface.getManager(125)).jdField_c_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return (paramInt == 1) && (!((HotChatManager)paramQQAppInterface.getManager(60)).b(paramString));
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if ((!bgsp.a(paramString)) && (paramString.trim().length() > 1) && (paramString.trim().matches("[a-zA-Z]+"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PasswdRedBagManager", 2, "isEnglishWords: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  private boolean a(String paramString1, String paramString2, akli paramakli)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    String str;
    do
    {
      do
      {
        return false;
        paramString1 = paramString1.trim();
      } while ((TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 1));
      str = paramString1.substring(0, 1);
    } while ((TextUtils.isEmpty(paramString2)) || (!paramString2.contains(str)) || (!paramakli.a(paramString1.length())));
    return true;
  }
  
  public static String b(String paramString)
  {
    if ((bgsp.a(paramString)) || (!paramString.contains("_"))) {
      return "";
    }
    paramString = paramString.split("_");
    if (paramString.length <= 1) {
      return "";
    }
    return paramString[0];
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((aklj)paramQQAppInterface.getManager(125)).jdField_d_of_type_Boolean;
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.trim().length() > 0) && (paramString.matches("[一-龥]"));
  }
  
  private boolean b(String paramString1, String paramString2, akli paramakli)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return false;
      paramString1 = paramString1.trim();
    } while ((TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 1) || (!paramString1.contains(paramString2)) || (!paramakli.a(paramString1.length())));
    return true;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 10002: 
    case 10004: 
    case 10008: 
      return 3;
    }
    return 2;
  }
  
  public akli a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    a(false);
    return (akli)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public Bitmap a(String paramString, @DrawableRes int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (BaseApplicationImpl.sImageCache != null) {}
    label145:
    for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get(paramString);; localBitmap1 = null) {
      if (localBitmap1 == null) {
        try
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
          localObject1 = localBitmap2;
          localObject2 = localObject1;
          if (localObject1 != null) {}
          Object localObject3;
          return localBitmap1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject2 = Bitmap.createScaledBitmap(localObject1, bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), bggq.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), true);
              if (localObject2 == null) {
                break label145;
              }
              if (BaseApplicationImpl.sImageCache != null) {
                BaseApplicationImpl.sImageCache.put(paramString, localObject2);
              }
              return localObject2;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              continue;
            }
            catch (Exception localException2)
            {
              continue;
            }
            localException1 = localException1;
            localException1.printStackTrace();
            localObject3 = localObject1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            localObject1 = localObject3;
            localObject3 = localOutOfMemoryError2;
            localObject3.printStackTrace();
            localObject3 = localObject1;
          }
        }
      }
    }
  }
  
  public MessageRecord a(List<MessageRecord> paramList, MessageForFoldMsg paramMessageForFoldMsg, LinkedHashSet<String> arg3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((QLog.isColorLevel()) && (bgso.a()) && (paramList.size() > 0))
    {
      localObject1 = new StringBuilder(paramList.size() * 48 + 64);
      ((StringBuilder)localObject1).append("getFoldGrayTipsFormAIOList before insert,aioList size=").append(paramList.size()).append(":");
      if (paramBoolean2)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
        ((Lock)localObject2).lock();
        try
        {
          localObject3 = paramList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
          }
        }
        finally
        {
          ((Lock)localObject2).unlock();
        }
        QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (this.jdField_e_of_type_JavaUtilHashMap == null) {
        this.jdField_e_of_type_JavaUtilHashMap = new HashMap();
      }
      if (this.jdField_f_of_type_JavaUtilHashMap == null) {
        this.jdField_f_of_type_JavaUtilHashMap = new HashMap();
      }
      localObject1 = paramMessageForFoldMsg.frienduin + paramMessageForFoldMsg.istroop + paramMessageForFoldMsg.redBagId;
      localObject2 = paramMessageForFoldMsg.frienduin + paramMessageForFoldMsg.istroop + paramMessageForFoldMsg.redBagIndex;
      if ((!paramBoolean1) || (!this.jdField_f_of_type_JavaUtilHashMap.containsKey(localObject2))) {
        break label592;
      }
      localObject3 = (MessageForFoldMsgGrayTips)this.jdField_f_of_type_JavaUtilHashMap.get(localObject2);
      ((MessageForFoldMsgGrayTips)localObject3).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, ???, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
      if (this.jdField_e_of_type_JavaUtilHashMap.containsKey(localObject1)) {
        a(paramList, (String)localObject2, (String)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramBoolean2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("update foldmsg graytips, index mode, uin: %s, type: %d, redBagId: %s, index: %s, num: %d", new Object[] { ((MessageForFoldMsgGrayTips)localObject3).frienduin, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject3).istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject3).foldMsgCount) }));
      }
      paramList = null;
    }
    label1200:
    label1216:
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BC", "0X80064BC", 0, 0, "", "", "", "");
      return paramList;
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject3).time).append(",").append(((MessageRecord)localObject3).shmsgseq).append(",").append(((MessageRecord)localObject3).msgtype).append(") ");
      }
      break;
      label592:
      if ((paramBoolean1) && (this.jdField_e_of_type_JavaUtilHashMap.containsKey(localObject1)))
      {
        paramList = (MessageForFoldMsgGrayTips)this.jdField_e_of_type_JavaUtilHashMap.get(localObject1);
        paramList.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, ???, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
        if (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex))
        {
          this.jdField_e_of_type_JavaUtilHashMap.remove(localObject1);
          this.jdField_f_of_type_JavaUtilHashMap.put(localObject2, paramList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("update foldmsg graytips, id mode, uin: %s, type: %d, redBagId: %s, index: %s,  num: %d", new Object[] { paramList.frienduin, Integer.valueOf(paramList.istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(paramList.foldMsgCount) }));
        }
        paramList = null;
      }
      else
      {
        localObject1 = (MessageForFoldMsgGrayTips)bbzh.a(-5011);
        bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
        ((MessageForFoldMsgGrayTips)localObject1).shmsgseq = paramMessageForFoldMsg.shmsgseq;
        ((MessageForFoldMsgGrayTips)localObject1).time = paramMessageForFoldMsg.time;
        ((MessageForFoldMsgGrayTips)localObject1).foldMsgCount = paramInt;
        ((MessageForFoldMsgGrayTips)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.mPasswdRedBagSender, ???, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
        for (;;)
        {
          synchronized (this.jdField_b_of_type_JavaLangObject)
          {
            if (a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex)) {
              break;
            }
            if (paramBoolean2)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
              ((Lock)localObject2).lock();
              try
              {
                acwh.c(paramList, (MessageRecord)localObject1, true);
                ((Lock)localObject2).unlock();
                a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, (MessageForFoldMsgGrayTips)localObject1);
                if ((!QLog.isColorLevel()) || (!bgso.a()) || (paramList == null) || (paramList.size() <= 0)) {
                  break label1216;
                }
                ??? = new StringBuilder(paramList.size() * 48 + 64);
                ???.append("getFoldGrayTipsFormAIOList after insert,isNeedMsgListLock=").append(paramBoolean2);
                ???.append(",aioList size=").append(paramList.size()).append(":");
                paramMessageForFoldMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
                paramMessageForFoldMsg.lock();
                try
                {
                  paramList = paramList.iterator();
                  if (!paramList.hasNext()) {
                    break label1200;
                  }
                  localObject2 = (MessageRecord)paramList.next();
                  ???.append("(").append(((MessageRecord)localObject2).time).append(",").append(((MessageRecord)localObject2).shmsgseq).append(",").append(((MessageRecord)localObject2).msgtype).append(") ");
                  continue;
                  paramList = finally;
                }
                finally
                {
                  paramMessageForFoldMsg.unlock();
                }
                paramList = finally;
              }
              finally {}
            }
          }
          acwh.c(paramList, (MessageRecord)localObject1, true);
        }
        QLog.i("msgFold", 1, "filter repeat msg:" + paramMessageForFoldMsg.redBagId + "_" + paramMessageForFoldMsg.redBagIndex);
        return null;
        paramMessageForFoldMsg.unlock();
        QLog.d("msgFold", 2, ???.toString());
        paramList = (List<MessageRecord>)localObject1;
      }
    }
  }
  
  public Boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int k = 0;
    if (this.jdField_a_of_type_Int == 0) {
      return Boolean.valueOf(true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt);
    if (localObject == null) {
      return Boolean.valueOf(false);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt);
    paramString1 = (String)localObject;
    if (localList != null)
    {
      paramString1 = (String)localObject;
      if (((List)localObject).size() < localList.size()) {
        paramString1 = localList;
      }
    }
    int m = paramString1.size() - 1;
    while (m > 0)
    {
      localObject = (MessageRecord)paramString1.get(m);
      paramInt = k;
      if ((localObject instanceof MessageForFoldMsg))
      {
        localObject = (MessageForFoldMsg)localObject;
        if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(((MessageForFoldMsg)localObject).redBagId)))
        {
          paramInt = k;
          if (!TextUtils.isEmpty(paramString3))
          {
            paramInt = k;
            if (!paramString3.equals(((MessageForFoldMsg)localObject).redBagIndex)) {}
          }
        }
        else
        {
          k += 1;
          if (!((MessageForFoldMsg)localObject).foldFlag)
          {
            paramInt = k;
            if (k < this.jdField_a_of_type_Int) {}
          }
          else
          {
            return Boolean.valueOf(true);
          }
        }
      }
      m -= 1;
      k = paramInt;
    }
    return Boolean.valueOf(false);
  }
  
  public String a()
  {
    f();
    if (this.jdField_c_of_type_JavaUtilList.size() == 0) {
      return null;
    }
    int k = new Random(System.currentTimeMillis()).nextInt(this.jdField_c_of_type_JavaUtilList.size());
    return (String)this.jdField_c_of_type_JavaUtilList.get(k);
  }
  
  public void a()
  {
    if ((this.jdField_i_of_type_JavaUtilHashMap == null) || (this.jdField_i_of_type_JavaUtilHashMap.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_Aklh.a(1);
      Iterator localIterator = this.jdField_i_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        akls localakls = new akls();
        localakls.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localakls.jdField_a_of_type_Int = 1;
        localakls.b = Long.parseLong((String)this.jdField_i_of_type_JavaUtilHashMap.get(localObject));
        int k = localList.indexOf(localakls);
        if (k != -1)
        {
          localObject = (akls)localList.get(k);
          if (localakls.b <= ((akls)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localakls.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localakls.b);
          localArrayList.add(localObject);
          this.jdField_a_of_type_JavaUtilList.add(localakls);
        }
      }
      this.jdField_i_of_type_JavaUtilHashMap.clear();
    } while (this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_Anti.a(0, localArrayList);
  }
  
  public void a(akli paramakli, String paramString)
  {
    if (paramakli != null) {}
    for (;;)
    {
      int k;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramString = paramString.split("-");
        int m = paramString.length;
        k = 0;
        if (k < m)
        {
          CharSequence localCharSequence = paramString[k];
          if (TextUtils.isEmpty(localCharSequence)) {
            break label179;
          }
          List localList = (List)this.jdField_c_of_type_JavaUtilHashMap.get(localCharSequence);
          if ((localList != null) && (!localList.isEmpty()))
          {
            Iterator localIterator = localList.iterator();
            if (localIterator.hasNext())
            {
              if (!((String)localIterator.next()).equals(paramakli.jdField_a_of_type_JavaLangString)) {
                continue;
              }
              localIterator.remove();
            }
          }
          if (((localList != null) && (!localList.isEmpty())) || (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(localCharSequence))) {
            break label179;
          }
          this.jdField_c_of_type_JavaUtilHashMap.remove(localCharSequence);
        }
      }
      a(paramakli);
      return;
      label179:
      k += 1;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((bgsp.a(paramString1)) || (bgsp.a(paramString2))) {}
    label14:
    do
    {
      do
      {
        do
        {
          break label14;
          do
          {
            return;
          } while (!(paramContext instanceof FragmentActivity));
          paramContext = (FragmentActivity)paramContext;
        } while (paramContext.getChatFragment() == null);
        paramContext = paramContext.getChatFragment().a();
      } while (paramContext == null);
      paramContext = (agmv)paramContext.a(27);
    } while (paramContext == null);
    paramContext.a(paramString2, paramString1);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    ThreadManagerV2.excute(new PasswdRedBagManager.3(this, paramSessionInfo), 16, null, true);
  }
  
  public void a(SessionInfo paramSessionInfo, akli paramakli, long paramLong, int paramInt)
  {
    a(paramSessionInfo, paramakli, paramLong, 32, "", 0, paramInt, null);
  }
  
  public void a(SessionInfo paramSessionInfo, akli paramakli, long paramLong, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    a(paramSessionInfo, paramakli, paramLong, paramInt1, "", 0, paramInt2, paramBundle);
  }
  
  public void a(SessionInfo paramSessionInfo, akli paramakli, long paramLong, int paramInt, Bundle paramBundle)
  {
    a(paramSessionInfo, paramakli, paramLong, 524288, "", 0, paramInt, paramBundle);
  }
  
  public void a(SessionInfo paramSessionInfo, akli paramakli, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if ((paramSessionInfo == null) || (paramakli == null)) {}
    String str2;
    do
    {
      return;
      d();
      str2 = (String)this.jdField_d_of_type_JavaUtilHashMap.get(a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_" + paramakli.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty(str2));
    int k;
    Object localObject;
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 2) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002))
    {
      k = 1;
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localObject = String.valueOf(paramakli.jdField_c_of_type_JavaLangString);
      if (k != 0) {
        if (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString)) {
          break label412;
        }
      }
    }
    label412:
    for (String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;; str1 = this.jdField_a_of_type_JavaLangString)
    {
      localObject = akwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
      k = ((Bundle)localObject).getInt("groupType");
      localObject = ((Bundle)localObject).getString("name");
      paramakli = paramakli.jdField_a_of_type_JavaLangString;
      paramSessionInfo = akwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, k, (String)localObject, paramakli, str2, str1, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", null, paramInt1, 0, paramString, paramInt2, paramInt3, paramBundle);
      paramString = new Bundle();
      paramString.putString("json", paramSessionInfo.toString());
      paramString.putString("callbackSn", "0");
      paramSessionInfo = paramakli;
      if (paramakli != null)
      {
        paramSessionInfo = paramakli;
        if (paramakli.length() > 4) {
          paramSessionInfo = "****" + paramakli.substring(4);
        }
      }
      VACDReportUtil.a(paramLong, null, "open", "groupType=" + k + "&msgType=6&redId=" + paramSessionInfo, 0, null);
      paramString.putLong("vacreport_key_seq", paramLong);
      paramSessionInfo = new Intent(this.jdField_a_of_type_AndroidContentContext, PayBridgeActivity.class);
      paramSessionInfo.putExtras(paramString);
      paramSessionInfo.addFlags(268435456);
      paramSessionInfo.putExtra("pay_requestcode", 5);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramSessionInfo);
      return;
      k = 0;
      break;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      akxm.a().a(new aklm(this, paramArrayList, paramSessionInfo));
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    akli localakli;
    do
    {
      return;
      a(false);
      localakli = (akli)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localakli == null) || (localakli.jdField_b_of_type_Boolean));
    localakli.jdField_b_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.13(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = anni.a(2131706664);
    if (paramInt == 8) {
      str = "匿名不能抢K歌红包哦";
    }
    for (;;)
    {
      ((bfuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81)).a(paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
      return;
      if (paramInt == 9) {
        str = anni.a(2131706667);
      } else if (paramInt == 10) {
        str = anni.a(2131706663);
      } else if (paramInt == 11) {
        str = anni.a(2131706670);
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = paramString1 + paramInt + paramString3;
      if ((this.jdField_f_of_type_JavaUtilHashMap != null) && (!this.jdField_f_of_type_JavaUtilHashMap.containsKey(paramString2)))
      {
        this.jdField_f_of_type_JavaUtilHashMap.put(paramString2, paramMessageForFoldMsgGrayTips);
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagIndex: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString2));
        paramString3 = paramString1 + paramInt + paramString2;
      } while ((this.jdField_e_of_type_JavaUtilHashMap == null) || (this.jdField_e_of_type_JavaUtilHashMap.containsKey(paramString3)));
      this.jdField_e_of_type_JavaUtilHashMap.put(paramString3, paramMessageForFoldMsgGrayTips);
    } while (!QLog.isColorLevel());
    QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagId: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
  }
  
  public void a(String paramString, SessionInfo paramSessionInfo, akli paramakli, long paramLong, int paramInt)
  {
    long l1 = akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "idiom_match_in_phone", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (l1 != 0L)
    {
      bool1 = bool2;
      if (l1 > l2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "openSolitaireRedBagByIdiom|isServerAvailable: " + bool1);
    }
    if (bool1) {
      akxm.a().a(new aklo(this, paramakli, paramString, paramSessionInfo, paramLong, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if ((bgsp.a(paramString2)) || (bgsp.a(paramString1)) || (bgsp.a(paramString3))) {
      return;
    }
    a(paramString1, paramString3, paramString4, paramInt2, paramString5);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("PasswdRedBagManager", 2, "<<<setPasswdRedBagLastedWord start<<< |redBagId: " + paramString1 + " lastedWord: " + paramString2 + " lastPinyin: " + paramString3);
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          boolean bool = TextUtils.isEmpty(paramString2);
          if (!bool) {}
        }
        else
        {
          return;
        }
        a(false);
        akli localakli = (akli)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagManager", 2, "setPasswdRedBagLastedWord|passwdRedBagInfo: " + localakli);
        }
        if (localakli != null) {
          if (TextUtils.isEmpty(paramString3))
          {
            if (localakli.a() == 3) {
              a(paramString1);
            }
          }
          else {
            try
            {
              JSONObject localJSONObject = this.jdField_a_of_type_Aklh.a(localakli.f);
              if (localJSONObject != null)
              {
                int k = localJSONObject.optInt("key_extstr_idiomseq");
                if (QLog.isColorLevel()) {
                  QLog.d("PasswdRedBagManager", 2, "oldSeq: " + k + " newSeq: " + paramInt + " extObj: " + localJSONObject.toString() + " lastpassword: " + localakli.e);
                }
                if (paramInt > k)
                {
                  localJSONObject.put("key_extstr_idiomseq", paramInt);
                  akli.a(localJSONObject, paramString4);
                  localakli.f = localJSONObject.toString();
                  paramString2 = paramString2.trim() + "_" + paramString3.trim();
                  if (QLog.isColorLevel()) {
                    QLog.d("PasswdRedBagManager", 2, "finalLastWord: " + paramString2);
                  }
                  paramString3 = a(localakli.e);
                  localakli.e = paramString2;
                  a(localakli, paramString3);
                  ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.16(this, paramString1, paramString2, localJSONObject));
                }
              }
            }
            catch (Throwable paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, paramString6, paramString7, paramBoolean1, paramBoolean2, paramInt, "", "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString8, String paramString9)
  {
    if ((akli)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) == null)
    {
      paramString2 = new akli(paramString1, paramString2, paramString4, paramLong, new bdnt(paramString3, 5, 16).toString(), paramBoolean1, paramBoolean2, false, paramInt, paramString8, paramString9);
      a(paramString2);
      a(true, paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_b_of_type_JavaLangString);
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.11(this, paramString2));
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString5);
    paramString2.append("_");
    paramString2.append(paramString6);
    paramString2.append("_");
    paramString2.append(paramString1);
    if (TextUtils.isEmpty((String)this.jdField_d_of_type_JavaUtilHashMap.get(paramString2.toString())))
    {
      this.jdField_d_of_type_JavaUtilHashMap.put(paramString2.toString(), paramString7);
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.12(this, paramString5, paramString6, paramString1, paramString7));
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      bcst.b(localQQAppInterface, "CliOper", "", "", "0X8006115", "0X8006115", 0, 0, "", str, paramString, "0");
      return;
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (this.jdField_i_of_type_JavaUtilHashMap == null) {
      this.jdField_i_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_i_of_type_JavaUtilHashMap.putAll(paramHashMap);
  }
  
  public void a(HashSet<String> paramHashSet)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.addAll(paramHashSet);
    a(paramHashSet);
  }
  
  public void a(List<MessageRecord> paramList, MessageForFoldMsg paramMessageForFoldMsg)
  {
    if ((paramMessageForFoldMsg.isSend()) && (!paramMessageForFoldMsg.foldFlag) && (paramMessageForFoldMsg.msgtype == -2006)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagId))) {
      a(true, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
    }
    if ((TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagId)) && (this.jdField_g_of_type_JavaUtilHashMap.containsKey(paramMessageForFoldMsg.redBagId))) {
      paramMessageForFoldMsg.redBagIndex = ((String)this.jdField_g_of_type_JavaUtilHashMap.get(paramMessageForFoldMsg.redBagId));
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(paramMessageForFoldMsg.senderuin);
    a(paramList, paramMessageForFoldMsg, localLinkedHashSet, 1, true, false);
  }
  
  public void a(List<MessageRecord> paramList, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    MessageForFoldMsgGrayTips localMessageForFoldMsgGrayTips = (MessageForFoldMsgGrayTips)this.jdField_f_of_type_JavaUtilHashMap.get(paramString1);
    paramString2 = (MessageForFoldMsgGrayTips)this.jdField_e_of_type_JavaUtilHashMap.get(paramString2);
    this.jdField_e_of_type_JavaUtilHashMap.remove(paramString1);
    localMessageForFoldMsgGrayTips.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2.frienduin, paramString2.foldUinList, paramString2.foldMsgCount, paramString2.redBagId, paramString2.redBagIndex);
    if (paramBoolean)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a().a(paramString3, paramInt);
      paramString1.lock();
    }
    for (;;)
    {
      try
      {
        paramList.remove(paramString2);
        paramString1.unlock();
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, new Object[] { "update foldmsg graytips, index mode merge,", ",mst.time=", Long.valueOf(paramString2.time), ".msg.shmsgseq=", Long.valueOf(paramString2.shmsgseq), ",msg.type=", Integer.valueOf(paramString2.msgtype), ",isNeedMsgListLock=", Boolean.valueOf(paramBoolean) });
        }
        return;
      }
      finally
      {
        paramString1.unlock();
      }
      paramList.remove(paramString2);
    }
  }
  
  public void a(Set<String> paramSet)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_a_of_type_JavaLangString, 0).edit();
      if (Build.VERSION.SDK_INT >= 11) {
        localEditor.putStringSet("key_passwd_configs", paramSet);
      }
      for (;;)
      {
        localEditor.commit();
        return;
        localEditor.putInt("key_passwd_configs_count", paramSet.size());
        paramSet = paramSet.iterator();
        int k = 0;
        while (paramSet.hasNext())
        {
          String str = (String)paramSet.next();
          localEditor.putString("key_passwd_configs_" + k, str);
          k += 1;
        }
      }
      return;
    }
    catch (Throwable paramSet)
    {
      paramSet.printStackTrace();
    }
  }
  
  public void a(BusinessObserver paramBusinessObserver, int paramInt1, int paramInt2)
  {
    akxm.a().a(new aklq(this, paramInt2, paramInt1, paramBusinessObserver));
  }
  
  public void a(im_msg_body.QQWalletAioBody paramQQWalletAioBody, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2)
  {
    a(paramQQWalletAioBody.bytes_billno.get().toStringUtf8(), paramQQWalletAioBody.string_index.get().toStringUtf8(), paramQQWalletAioBody.receiver.bytes_title.get().toStringUtf8(), String.valueOf(paramLong2), paramLong3 + 90000L, String.valueOf(paramInt1), String.valueOf(paramLong1), paramQQWalletAioBody.bytes_authkey.get().toStringUtf8(), false, false, paramInt2, paramString1, paramString2);
  }
  
  public void a(oidb_0x438.RedBagInfo paramRedBagInfo)
  {
    a(paramRedBagInfo.string_redbag_id.get().toStringUtf8(), paramRedBagInfo.string_index.get().toStringUtf8(), paramRedBagInfo.string_password.get().toStringUtf8(), String.valueOf(paramRedBagInfo.uint64_creator_uin.get()), paramRedBagInfo.uint64_expire_time.get(), String.valueOf(paramRedBagInfo.uint32_source.get()), String.valueOf(paramRedBagInfo.uint64_code.get()), paramRedBagInfo.string_authkey.get().toStringUtf8(), false, false, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (a()) {
          e();
        }
        if (!paramBoolean) {
          break label157;
        }
        boolean bool = this.jdField_f_of_type_Boolean;
        if (!bool) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "loadRedBagInfoToCache sync=" + paramBoolean + ",isNeedSyncLoadRedBagInfo=" + this.jdField_f_of_type_Boolean + ",isNeedLoadRedBagInfo=" + this.jdField_g_of_type_Boolean);
        }
        Iterator localIterator = this.jdField_a_of_type_Aklh.a().iterator();
        if (localIterator.hasNext())
        {
          akli localakli = (akli)localIterator.next();
          a(localakli);
          a(false, localakli.jdField_a_of_type_JavaLangString, localakli.jdField_b_of_type_JavaLangString);
          continue;
        }
        this.jdField_f_of_type_Boolean = false;
      }
      finally {}
      continue;
      label157:
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "loadRedBagInfoToCache sync=" + paramBoolean + ",isNeedSyncLoadRedBagInfo=" + this.jdField_f_of_type_Boolean + ",isNeedLoadRedBagInfo=" + this.jdField_g_of_type_Boolean);
        }
        ThreadManager.post(new PasswdRedBagManager.9(this), 8, null, false);
        this.jdField_g_of_type_Boolean = false;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      a(false);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (!this.jdField_g_of_type_JavaUtilHashMap.containsKey(paramString1)) {
        this.jdField_g_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      }
    } while (this.jdField_h_of_type_JavaUtilHashMap.containsKey(paramString2));
    this.jdField_h_of_type_JavaUtilHashMap.put(paramString2, paramString1);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool = false;
    String str = paramString1 + paramInt + paramString2;
    paramString1 = paramString1 + paramInt + paramString3;
    if ((!TextUtils.isEmpty(paramString2)) && (this.jdField_e_of_type_JavaUtilHashMap != null) && (this.jdField_e_of_type_JavaUtilHashMap.containsKey(str)))
    {
      paramInt = 1;
      if ((TextUtils.isEmpty(paramString3)) || (this.jdField_f_of_type_JavaUtilHashMap == null) || (!this.jdField_f_of_type_JavaUtilHashMap.containsKey(paramString1))) {
        break label128;
      }
    }
    label128:
    for (int k = 1;; k = 0)
    {
      if ((paramInt != 0) || (k != 0)) {
        bool = true;
      }
      return bool;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a(String paramString, akli paramakli)
  {
    if ((bgsp.a(paramString)) || (paramakli == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              str = a(paramakli.e);
              if (paramakli.a() != 0) {
                break;
              }
              if (paramString.trim().length() >= 4)
              {
                paramString = ChnToSpell.a(paramString.trim().substring(0, 1));
                if ((paramString != null) && (paramString.length != 0))
                {
                  int m = paramString.length;
                  int k = 0;
                  while (k < m)
                  {
                    paramakli = paramString[k];
                    if ((!bgsp.a(str)) && (paramakli.equals(str.trim()))) {
                      return true;
                    }
                    k += 1;
                  }
                }
              }
            }
            if (paramakli.a() != 1) {
              break;
            }
          } while (!a(paramString));
          paramString = paramString.trim().substring(0, 1);
        } while ((bgsp.a(paramString)) || (!paramString.equalsIgnoreCase(str)));
        return true;
        if (paramakli.a() != 2) {
          break;
        }
      } while (!b(paramString, str, paramakli));
      return true;
    } while ((paramakli.a() != 3) || (!a(paramString, str, paramakli)));
    return true;
  }
  
  public Object[] a(SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfObject;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.charAt(0));
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString.length());
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagByPassword, passwd = " + ((StringBuilder)localObject).toString());
    }
    long l = SystemClock.uptimeMillis();
    a(false);
    d();
    akli localakli;
    try
    {
      localObject = a(paramSessionInfo, paramString, arrayOfObject);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagByPassword, selectPasswdRedBagInfo = null");
        }
        return arrayOfObject;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("PasswdRedBagManager", 2, QLog.getStackTraceString(localThrowable));
        localakli = null;
      }
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByPwd", "msgType=6", 0, null, l);
      if (localakli.jdField_a_of_type_Int != 0) {
        break label327;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("PasswdRedBagManager", 2, "----word hb----" + localakli.jdField_a_of_type_JavaLangString);
    }
    if ((!bgsp.a(paramString)) && (localakli != null) && (!bgsp.a(localakli.d)) && (paramString.trim().equals(localakli.d.trim())))
    {
      a(localakli.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      a(paramSessionInfo, localakli, l, paramInt);
    }
    for (;;)
    {
      return arrayOfObject;
      label327:
      if (4 == localakli.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PasswdRedBagManager", 2, "----word chain hb----" + localakli.jdField_a_of_type_JavaLangString);
        }
        if (a(paramString, localakli)) {
          a(paramString.trim(), paramSessionInfo, localakli, l, paramInt);
        }
      }
    }
  }
  
  public Object[] a(String paramString1, SessionInfo paramSessionInfo, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagById, id = " + paramString2);
    }
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return arrayOfObject;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendById", "msgType=6", 0, null);
    a(false);
    d();
    akli localakli = (akli)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    if (localakli == null)
    {
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "no redid");
      return arrayOfObject;
    }
    arrayOfObject[1] = Long.valueOf(localakli.jdField_c_of_type_JavaLangString);
    if (4 == localakli.jdField_a_of_type_Int)
    {
      arrayOfObject[2] = null;
      arrayOfObject[3] = null;
    }
    while (4 != localakli.jdField_a_of_type_Int) {
      if (localakli.jdField_a_of_type_Boolean)
      {
        VACDReportUtil.endReport(l, "pwd.end", "", -1, "opened");
        return arrayOfObject;
        if ((!localakli.jdField_c_of_type_Boolean) && (localakli.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
        {
          arrayOfObject[2] = paramString2;
          arrayOfObject[3] = localakli.jdField_b_of_type_JavaLangString;
        }
      }
      else
      {
        if (localakli.jdField_b_of_type_Boolean)
        {
          arrayOfObject[0] = Integer.valueOf(2);
          VACDReportUtil.endReport(l, "pwd.end", "", -1, "finish");
          return arrayOfObject;
        }
        if ((localakli.jdField_c_of_type_Boolean) || (localakli.jdField_a_of_type_Long < NetConnInfoCenter.getServerTimeMillis() / 1000L))
        {
          if (!localakli.jdField_c_of_type_Boolean) {
            b(paramString2);
          }
          if (4 != localakli.jdField_a_of_type_Int)
          {
            arrayOfObject[0] = Integer.valueOf(3);
            VACDReportUtil.endReport(l, "pwd.end", "", -1, "overdue");
            return arrayOfObject;
          }
        }
      }
    }
    if (!bgsp.a(paramString1))
    {
      if ((localakli.jdField_a_of_type_Int != 0) || (bgsp.a(localakli.d)) || (!paramString1.equals(localakli.d))) {
        break label436;
      }
      a(localakli.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      a(paramSessionInfo, localakli, l, paramInt);
    }
    for (;;)
    {
      arrayOfObject[0] = Integer.valueOf(1);
      return arrayOfObject;
      label436:
      if ((4 != localakli.jdField_a_of_type_Int) || (!a(paramString1, localakli)) || (localakli.jdField_b_of_type_Boolean) || (localakli.a())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PasswdRedBagManager", 2, "----成语接龙红包----" + localakli.jdField_a_of_type_JavaLangString);
      }
      a(paramString1.trim(), paramSessionInfo, localakli, l, paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagById| 根据输入文字进行匹配");
    }
    return a(paramSessionInfo, paramString1.trim(), paramInt);
  }
  
  public void b()
  {
    if ((this.jdField_j_of_type_JavaUtilHashMap == null) || (this.jdField_j_of_type_JavaUtilHashMap.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_b_of_type_JavaUtilList.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_Aklh.a(2);
      Iterator localIterator = this.jdField_j_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        akls localakls = new akls();
        localakls.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localakls.jdField_a_of_type_Int = 2;
        localakls.b = Long.parseLong((String)this.jdField_j_of_type_JavaUtilHashMap.get(localObject));
        int k = localList.indexOf(localakls);
        if (k != -1)
        {
          localObject = (akls)localList.get(k);
          if (localakls.b <= ((akls)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localakls.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localakls.b);
          localArrayList.add(localObject);
          this.jdField_b_of_type_JavaUtilList.add(localakls);
        }
      }
      this.jdField_j_of_type_JavaUtilHashMap.clear();
    } while (this.jdField_b_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_Anti.a(1, localArrayList);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    akli localakli;
    do
    {
      return;
      a(false);
      localakli = (akli)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localakli == null) || (localakli.jdField_c_of_type_Boolean));
    localakli.jdField_c_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.14(this, paramString));
  }
  
  public void b(String paramString, int paramInt)
  {
    String str = anni.a(2131706668);
    if (paramInt == 8) {
      str = "禁言不能抢K歌红包哦";
    }
    for (;;)
    {
      ((bfuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81)).a(paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
      return;
      if (paramInt == 9) {
        str = anni.a(2131706665);
      } else if (paramInt == 10) {
        str = anni.a(2131706666);
      } else if (paramInt == 11) {
        str = anni.a(2131706669);
      }
    }
  }
  
  public void b(HashMap<String, String> paramHashMap)
  {
    if (this.jdField_j_of_type_JavaUtilHashMap == null) {
      this.jdField_j_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_j_of_type_JavaUtilHashMap.putAll(paramHashMap);
  }
  
  public void c()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_a_of_type_JavaLangString, 0);
      if (localSharedPreferences.getBoolean("key_db_update", true))
      {
        ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.7(this));
        localSharedPreferences.edit().putBoolean("key_db_update", false);
        localSharedPreferences.edit().commit();
      }
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.8(this));
      return;
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006116", "0X8006116", 0, 0, "", "0", paramString, "0");
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1261	aklj:a	()Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 1263	aklj:e	()V
    //   13: aload_0
    //   14: getfield 149	aklj:jdField_h_of_type_Boolean	Z
    //   17: ifeq +12 -> 29
    //   20: aload_0
    //   21: getfield 558	aklj:jdField_i_of_type_Boolean	Z
    //   24: istore_1
    //   25: iload_1
    //   26: ifeq +6 -> 32
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 558	aklj:jdField_i_of_type_Boolean	Z
    //   37: new 1384	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$10
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 1385	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$10:<init>	(Laklj;)V
    //   45: bipush 32
    //   47: aconst_null
    //   48: iconst_1
    //   49: invokestatic 1386	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   52: goto -23 -> 29
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	aklj
    //   24	2	1	bool	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	55	finally
    //   13	25	55	finally
    //   32	52	55	finally
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Aklh = new aklh(this);
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_d_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
  }
  
  public void f()
  {
    int k = 0;
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_a_of_type_JavaLangString, 0);
        if (Build.VERSION.SDK_INT < 11) {
          continue;
        }
        localObject = ((SharedPreferences)localObject).getStringSet("key_passwd_configs", new HashSet());
        if ((localObject != null) && (((Set)localObject).size() > 0)) {
          this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int m;
        localThrowable.printStackTrace();
        continue;
      }
      this.jdField_j_of_type_Boolean = true;
      return;
      m = ((SharedPreferences)localObject).getInt("key_passwd_configs_count", 0);
      if (m > 0) {
        if (k < m)
        {
          this.jdField_c_of_type_JavaUtilList.add(((SharedPreferences)localObject).getString("key_passwd_configs_" + k, ""));
          k += 1;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Antj.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Antj);
    this.jdField_a_of_type_Aklh.a();
    if ((this.jdField_a_of_type_Aklr != null) && (this.jdField_a_of_type_AndroidContentContext != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aklr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklj
 * JD-Core Version:    0.7.0.1
 */