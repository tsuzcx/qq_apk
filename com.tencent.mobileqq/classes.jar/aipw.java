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
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
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

public class aipw
  implements Manager
{
  public int a;
  private aipu jdField_a_of_type_Aipu;
  private aiqe jdField_a_of_type_Aiqe;
  private alwl jdField_a_of_type_Alwl;
  private alwm jdField_a_of_type_Alwm = new alwm(this.jdField_a_of_type_AndroidOsHandler);
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler = new aipx(this, Looper.getMainLooper());
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected Object a;
  public String a;
  public HashMap<String, aipv> a;
  public List<aiqf> a;
  public boolean a;
  private final Object b;
  public HashMap<String, List<String>> b;
  public List<aiqf> b;
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
  
  public aipw(QQAppInterface paramQQAppInterface)
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
    this.jdField_a_of_type_Aipu = new aipu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwm);
    this.jdField_a_of_type_Alwl = ((alwl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(76));
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
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
      this.jdField_a_of_type_Aiqe = new aiqe(this, null);
      paramQQAppInterface.addAction("grap_idiom_hb_result_action");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aiqe, paramQQAppInterface);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("PasswdRedBagManager", 1, "regist RedPacketRefreshReceiver throw an excepion" + paramQQAppInterface);
    }
  }
  
  private aipv a(SessionInfo paramSessionInfo, String paramString, Object[] paramArrayOfObject)
  {
    if (bdje.a(paramString))
    {
      paramString = null;
      return paramString;
    }
    String str = a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_";
    Iterator localIterator = null;
    paramSessionInfo = null;
    Object localObject2 = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    Object localObject3;
    if (localObject2 != null) {
      for (;;)
      {
        Object localObject4;
        try
        {
          if (((List)localObject2).isEmpty()) {
            break;
          }
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject4 = (String)((Iterator)localObject2).next();
          localObject3 = str + (String)localObject4;
          if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject3))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + (String)localObject3);
            continue;
          }
          localObject4 = (aipv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject4);
        }
        finally {}
        if (localObject4 != null) {
          localArrayList.add(localObject4);
        } else if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + (String)localObject3);
        }
      }
    }
    localObject2 = new ArrayList();
    int m;
    int k;
    if ((a(paramString)) || (paramString.trim().length() == 4))
    {
      paramString = ChnToSpell.a(paramString.trim().substring(0, 1));
      if ((paramString != null) && (paramString.length > 0))
      {
        m = paramString.length;
        k = 0;
      }
    }
    for (;;)
    {
      if (k < m)
      {
        localObject3 = paramString[k];
        if (!bdje.a((String)localObject3))
        {
          localObject3 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(((String)localObject3).trim());
          if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
            ((List)localObject2).addAll((Collection)localObject3);
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          paramString = ((List)localObject2).iterator();
          while (paramString.hasNext())
          {
            localObject3 = (String)paramString.next();
            localObject2 = str + (String)localObject3;
            if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + (String)localObject2);
              }
            }
            else
            {
              localObject3 = (aipv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
              if (localObject3 != null) {
                localArrayList.add(localObject3);
              } else if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + (String)localObject2);
              }
            }
          }
        }
        paramString = localIterator;
        if (!localArrayList.isEmpty())
        {
          Collections.sort(localArrayList, new aipy(this));
          localIterator = localArrayList.iterator();
          for (;;)
          {
            paramString = paramSessionInfo;
            if (!localIterator.hasNext()) {
              break label839;
            }
            paramString = (aipv)localIterator.next();
            paramArrayOfObject[1] = Long.valueOf(paramString.jdField_c_of_type_JavaLangString);
            if (4 == paramString.jdField_a_of_type_Int)
            {
              paramArrayOfObject[2] = null;
              paramArrayOfObject[3] = null;
            }
            for (;;)
            {
              if (!paramString.jdField_a_of_type_Boolean) {
                break label740;
              }
              if ((4 != paramString.jdField_a_of_type_Int) || (paramString.jdField_b_of_type_Boolean) || (paramString.a()) || (paramSessionInfo != null)) {
                break;
              }
              paramSessionInfo = paramString;
              break;
              if ((!paramString.jdField_c_of_type_Boolean) && (paramString.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
              {
                paramArrayOfObject[2] = paramString.jdField_a_of_type_JavaLangString;
                paramArrayOfObject[3] = paramString.jdField_b_of_type_JavaLangString;
              }
            }
            label740:
            if (paramString.jdField_b_of_type_Boolean)
            {
              paramArrayOfObject[0] = Integer.valueOf(2);
            }
            else
            {
              if ((!paramString.jdField_c_of_type_Boolean) && (paramString.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L)) {
                break;
              }
              if (!paramString.jdField_c_of_type_Boolean) {
                b(paramString.jdField_a_of_type_JavaLangString);
              }
              paramArrayOfObject[0] = Integer.valueOf(3);
            }
          }
          if (4 != paramString.jdField_a_of_type_Int) {
            paramString.jdField_a_of_type_Boolean = true;
          }
          paramArrayOfObject[0] = Integer.valueOf(1);
          paramArrayOfObject = paramSessionInfo;
          paramSessionInfo = paramString;
        }
        for (;;)
        {
          paramString = paramSessionInfo;
          if (paramSessionInfo != null) {
            break;
          }
          return paramArrayOfObject;
          label839:
          paramSessionInfo = null;
          paramArrayOfObject = paramString;
        }
      }
      k += 1;
    }
  }
  
  private String a(aipv paramaipv)
  {
    if (paramaipv == null) {
      return "";
    }
    String str = "";
    if (bdje.a(paramaipv.e)) {
      paramaipv = paramaipv.d;
    }
    while (bdje.a(paramaipv))
    {
      return "";
      String[] arrayOfString = paramaipv.e.trim().split("_");
      paramaipv = str;
      if (arrayOfString.length == 2) {
        paramaipv = arrayOfString[0];
      }
    }
    return paramaipv.trim();
  }
  
  /* Error */
  private void a(aipv paramaipv)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: getfield 313	aipv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: astore 7
    //   9: aload_1
    //   10: getfield 330	aipv:d	Ljava/lang/String;
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 128	aipw:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: aload 7
    //   21: aload_1
    //   22: invokevirtual 341	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: aload_1
    //   27: getfield 295	aipv:jdField_a_of_type_Int	I
    //   30: ifne +161 -> 191
    //   33: aload_0
    //   34: getfield 119	aipw:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   37: aload 8
    //   39: invokevirtual 215	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 217	java/util/List
    //   45: astore 6
    //   47: aload 6
    //   49: ifnonnull +326 -> 375
    //   52: new 343	java/util/LinkedList
    //   55: dup
    //   56: invokespecial 344	java/util/LinkedList:<init>	()V
    //   59: astore 6
    //   61: aload_0
    //   62: getfield 119	aipw:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   65: aload 8
    //   67: aload 6
    //   69: invokevirtual 341	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload_0
    //   74: getfield 46	aipw:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   77: astore 8
    //   79: aload 8
    //   81: monitorenter
    //   82: aload 6
    //   84: invokeinterface 347 1 0
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
    //   105: invokeinterface 350 2 0
    //   110: checkcast 236	java/lang/String
    //   113: astore 9
    //   115: aload 9
    //   117: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +259 -> 379
    //   123: aload_0
    //   124: getfield 128	aipw:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   127: aload 9
    //   129: invokevirtual 215	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 251	aipv
    //   135: astore 9
    //   137: aload 9
    //   139: ifnull +240 -> 379
    //   142: aload 9
    //   144: getfield 304	aipv:jdField_a_of_type_Long	J
    //   147: aload_1
    //   148: getfield 304	aipv:jdField_a_of_type_Long	J
    //   151: lcmp
    //   152: ifge +227 -> 379
    //   155: iload_2
    //   156: istore_3
    //   157: aload 6
    //   159: iload_3
    //   160: aload 7
    //   162: invokeinterface 358 3 0
    //   167: aload 8
    //   169: monitorexit
    //   170: return
    //   171: astore_1
    //   172: invokestatic 361	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   175: ifeq -8 -> 167
    //   178: aload_1
    //   179: invokevirtual 364	java/lang/Throwable:printStackTrace	()V
    //   182: goto -15 -> 167
    //   185: astore_1
    //   186: aload 8
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    //   191: aload_1
    //   192: getfield 295	aipv:jdField_a_of_type_Int	I
    //   195: iconst_4
    //   196: if_icmpne +182 -> 378
    //   199: aload_0
    //   200: aload_1
    //   201: getfield 328	aipv:e	Ljava/lang/String;
    //   204: invokevirtual 367	aipw:a	(Ljava/lang/String;)Ljava/lang/String;
    //   207: astore 8
    //   209: aload_0
    //   210: getfield 121	aipw:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   213: aload 8
    //   215: invokevirtual 215	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: checkcast 217	java/util/List
    //   221: astore 6
    //   223: aload 6
    //   225: ifnonnull +147 -> 372
    //   228: new 343	java/util/LinkedList
    //   231: dup
    //   232: invokespecial 344	java/util/LinkedList:<init>	()V
    //   235: astore 6
    //   237: aload_0
    //   238: getfield 121	aipw:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   241: aload 8
    //   243: aload 6
    //   245: invokevirtual 341	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   248: pop
    //   249: aload_0
    //   250: getfield 46	aipw:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   253: astore 8
    //   255: aload 8
    //   257: monitorenter
    //   258: aload 6
    //   260: invokeinterface 347 1 0
    //   265: istore_3
    //   266: iconst_0
    //   267: istore_2
    //   268: iload_2
    //   269: iload_3
    //   270: if_icmpge +97 -> 367
    //   273: aload 6
    //   275: iload_2
    //   276: invokeinterface 350 2 0
    //   281: checkcast 236	java/lang/String
    //   284: astore 9
    //   286: aload 9
    //   288: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +55 -> 346
    //   294: aload_0
    //   295: getfield 128	aipw:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   298: aload 9
    //   300: invokevirtual 215	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast 251	aipv
    //   306: astore 9
    //   308: aload 9
    //   310: ifnull +36 -> 346
    //   313: aload 9
    //   315: getfield 304	aipv:jdField_a_of_type_Long	J
    //   318: aload_1
    //   319: getfield 304	aipv:jdField_a_of_type_Long	J
    //   322: lcmp
    //   323: ifge +23 -> 346
    //   326: aload 6
    //   328: iload_2
    //   329: aload 7
    //   331: invokeinterface 358 3 0
    //   336: aload 8
    //   338: monitorexit
    //   339: return
    //   340: astore_1
    //   341: aload 8
    //   343: monitorexit
    //   344: aload_1
    //   345: athrow
    //   346: iload_2
    //   347: iconst_1
    //   348: iadd
    //   349: istore_2
    //   350: goto -82 -> 268
    //   353: astore_1
    //   354: invokestatic 361	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   357: ifeq -21 -> 336
    //   360: aload_1
    //   361: invokevirtual 364	java/lang/Throwable:printStackTrace	()V
    //   364: goto -28 -> 336
    //   367: iconst_0
    //   368: istore_2
    //   369: goto -43 -> 326
    //   372: goto -123 -> 249
    //   375: goto -302 -> 73
    //   378: return
    //   379: iload_2
    //   380: iconst_1
    //   381: iadd
    //   382: istore_2
    //   383: goto -290 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	aipw
    //   0	386	1	paramaipv	aipv
    //   92	291	2	k	int
    //   95	176	3	m	int
    //   1	93	4	n	int
    //   89	11	5	i1	int
    //   45	282	6	localObject1	Object
    //   7	323	7	str	String
    //   113	201	9	localObject3	Object
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
    //   258	266	340	finally
    //   273	308	340	finally
    //   313	326	340	finally
    //   326	336	340	finally
    //   336	339	340	finally
    //   341	344	340	finally
    //   354	364	340	finally
    //   258	266	353	java/lang/Throwable
    //   273	308	353	java/lang/Throwable
    //   313	326	353	java/lang/Throwable
    //   326	336	353	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    aipw localaipw = (aipw)paramQQAppInterface.getManager(125);
    if (!localaipw.jdField_b_of_type_Boolean)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "redbag_fold_msg_config_version"))
      {
        localaipw.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_msg_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT);
        localaipw.jdField_a_of_type_Int = paramQQAppInterface.getInt(str + "_" + "redbag_fold_msg_num", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT);
        localaipw.jdField_d_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX);
        localaipw.jdField_e_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_with_redbagid", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("getFoldSwitch, first init, switch: %s, num: %d, indexSwitch: %s, indexWithId: %s ", new Object[] { Boolean.valueOf(localaipw.jdField_c_of_type_Boolean), Integer.valueOf(localaipw.jdField_a_of_type_Int), Boolean.valueOf(localaipw.jdField_d_of_type_Boolean), Boolean.valueOf(localaipw.jdField_e_of_type_Boolean) }));
      }
    }
    localaipw.jdField_b_of_type_Boolean = true;
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
          paramString = (aipw)paramQQAppInterface.getManager(125);
          paramString.jdField_b_of_type_Boolean = true;
          paramString.jdField_c_of_type_Boolean = bool1;
          paramString.jdField_a_of_type_Int = k;
          paramString.jdField_d_of_type_Boolean = bool2;
          paramString.jdField_e_of_type_Boolean = bool3;
          bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), paramInt, bool1, k, bool2, bool3);
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
        aivh.a(paramString2, paramInt, paramString1);
      }
      paramString2 = (aipv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while ((paramString2 == null) || (paramString2.jdField_a_of_type_Boolean == paramBoolean));
    paramString2.jdField_a_of_type_Boolean = paramBoolean;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.15(this, paramString1, paramBoolean));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((aipw)paramQQAppInterface.getManager(125)).jdField_c_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return (paramInt == 1) && (!((HotChatManager)paramQQAppInterface.getManager(60)).b(paramString));
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if ((!bdje.a(paramString)) && (paramString.trim().length() > 1) && (paramString.trim().matches("[a-zA-Z]+"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PasswdRedBagManager", 2, "isEnglishWords: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((aipw)paramQQAppInterface.getManager(125)).jdField_d_of_type_Boolean;
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
  
  public aipv a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    a(false);
    return (aipv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
              localObject2 = Bitmap.createScaledBitmap(localObject1, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), bcwh.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), true);
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
    if ((QLog.isColorLevel()) && (bdjd.a()) && (paramList.size() > 0))
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BC", "0X80064BC", 0, 0, "", "", "", "");
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
        localObject1 = (MessageForFoldMsgGrayTips)ayvw.a(-5011);
        ayvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
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
                abot.c(paramList, (MessageRecord)localObject1, true);
                ((Lock)localObject2).unlock();
                a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, (MessageForFoldMsgGrayTips)localObject1);
                if ((!QLog.isColorLevel()) || (!bdjd.a()) || (paramList == null) || (paramList.size() <= 0)) {
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
          abot.c(paramList, (MessageRecord)localObject1, true);
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
  
  public String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "getLastIdiomPinyin|password: " + paramString);
    }
    if ((bdje.a(paramString)) || (!paramString.contains("_"))) {
      return "";
    }
    paramString = paramString.split("_");
    if (paramString.length != 2) {
      return "";
    }
    return paramString[1];
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
      List localList = this.jdField_a_of_type_Aipu.a(1);
      Iterator localIterator = this.jdField_i_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        aiqf localaiqf = new aiqf();
        localaiqf.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localaiqf.jdField_a_of_type_Int = 1;
        localaiqf.b = Long.parseLong((String)this.jdField_i_of_type_JavaUtilHashMap.get(localObject));
        int k = localList.indexOf(localaiqf);
        if (k != -1)
        {
          localObject = (aiqf)localList.get(k);
          if (localaiqf.b <= ((aiqf)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localaiqf.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localaiqf.b);
          localArrayList.add(localObject);
          this.jdField_a_of_type_JavaUtilList.add(localaiqf);
        }
      }
      this.jdField_i_of_type_JavaUtilHashMap.clear();
    } while (this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_Alwl.a(0, localArrayList);
  }
  
  public void a(aipv paramaipv, String paramString)
  {
    if (paramaipv != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      List localList = (List)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
      if ((localList != null) && (!localList.isEmpty()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if (((String)localIterator.next()).equals(paramaipv.jdField_a_of_type_JavaLangString)) {
            localIterator.remove();
          }
        }
      }
      if (((localList == null) || (localList.isEmpty())) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))) {
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
      }
      a(paramaipv);
      return;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((bdje.a(paramString1)) || (bdje.a(paramString2))) {}
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
      paramContext = (afbe)paramContext.a(27);
    } while (paramContext == null);
    paramContext.a(paramString2, paramString1);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    ThreadManagerV2.excute(new PasswdRedBagManager.3(this, paramSessionInfo), 16, null, true);
  }
  
  public void a(SessionInfo paramSessionInfo, aipv paramaipv, long paramLong, int paramInt)
  {
    a(paramSessionInfo, paramaipv, paramLong, 32, "", 0, paramInt, null);
  }
  
  public void a(SessionInfo paramSessionInfo, aipv paramaipv, long paramLong, int paramInt, Bundle paramBundle)
  {
    a(paramSessionInfo, paramaipv, paramLong, 524288, "", 0, paramInt, paramBundle);
  }
  
  public void a(SessionInfo paramSessionInfo, aipv paramaipv, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if ((paramSessionInfo == null) || (paramaipv == null)) {}
    String str2;
    do
    {
      return;
      d();
      str2 = (String)this.jdField_d_of_type_JavaUtilHashMap.get(a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_" + paramaipv.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty(str2));
    int k;
    Object localObject;
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 2) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002))
    {
      k = 1;
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localObject = String.valueOf(paramaipv.jdField_c_of_type_JavaLangString);
      if (k != 0) {
        if (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString)) {
          break label412;
        }
      }
    }
    label412:
    for (String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;; str1 = this.jdField_a_of_type_JavaLangString)
    {
      localObject = ajae.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
      k = ((Bundle)localObject).getInt("groupType");
      localObject = ((Bundle)localObject).getString("name");
      paramaipv = paramaipv.jdField_a_of_type_JavaLangString;
      paramSessionInfo = ajae.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, k, (String)localObject, paramaipv, str2, str1, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", null, paramInt1, 0, paramString, paramInt2, paramInt3, paramBundle);
      paramString = new Bundle();
      paramString.putString("json", paramSessionInfo.toString());
      paramString.putString("callbackSn", "0");
      paramSessionInfo = paramaipv;
      if (paramaipv != null)
      {
        paramSessionInfo = paramaipv;
        if (paramaipv.length() > 4) {
          paramSessionInfo = "****" + paramaipv.substring(4);
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
      ajat.a().a(new aipz(this, paramArrayList, paramSessionInfo));
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    aipv localaipv;
    do
    {
      return;
      a(false);
      localaipv = (aipv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localaipv == null) || (localaipv.jdField_b_of_type_Boolean));
    localaipv.jdField_b_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.13(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = alpo.a(2131708275);
    if (paramInt == 8) {
      str = "匿名不能抢K歌红包哦";
    }
    for (;;)
    {
      ((bclk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81)).a(paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
      return;
      if (paramInt == 9) {
        str = alpo.a(2131708278);
      } else if (paramInt == 10) {
        str = alpo.a(2131708274);
      } else if (paramInt == 11) {
        str = alpo.a(2131708281);
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
  
  public void a(String paramString, SessionInfo paramSessionInfo, aipv paramaipv, long paramLong, int paramInt)
  {
    long l1 = aiqz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "idiom_match_in_phone", 0L);
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
      ajat.a().a(new aiqb(this, paramaipv, paramString, paramSessionInfo, paramLong, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    if ((bdje.a(paramString2)) || (bdje.a(paramString1)) || (bdje.a(paramString3)) || (bdje.a(paramString4))) {
      return;
    }
    a(paramString1, paramString3, paramString4, paramInt2);
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +49 -> 54
    //   8: ldc 171
    //   10: iconst_2
    //   11: new 173	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 984
    //   21: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 986
    //   31: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 988
    //   41: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 520	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_1
    //   55: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +21 -> 79
    //   61: aload_2
    //   62: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifne +14 -> 79
    //   68: aload_3
    //   69: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: istore 6
    //   74: iload 6
    //   76: ifeq +6 -> 82
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: iconst_0
    //   84: invokevirtual 478	aipw:a	(Z)V
    //   87: aload_0
    //   88: getfield 128	aipw:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   91: aload_1
    //   92: invokevirtual 215	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 251	aipv
    //   98: astore 7
    //   100: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +30 -> 133
    //   106: ldc 171
    //   108: iconst_2
    //   109: new 173	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 990
    //   119: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 7
    //   124: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 7
    //   135: ifnull -56 -> 79
    //   138: aload_0
    //   139: getfield 106	aipw:jdField_a_of_type_Aipu	Laipu;
    //   142: aload 7
    //   144: getfield 992	aipv:f	Ljava/lang/String;
    //   147: invokevirtual 995	aipu:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   150: astore 8
    //   152: aload 8
    //   154: ifnull -75 -> 79
    //   157: aload 8
    //   159: ldc_w 997
    //   162: invokevirtual 1000	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   165: istore 5
    //   167: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +69 -> 239
    //   173: ldc 171
    //   175: iconst_2
    //   176: new 173	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 1002
    //   186: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 5
    //   191: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 1004
    //   197: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload 4
    //   202: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: ldc_w 1006
    //   208: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 8
    //   213: invokevirtual 861	org/json/JSONObject:toString	()Ljava/lang/String;
    //   216: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 1008
    //   222: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 7
    //   227: getfield 328	aipv:e	Ljava/lang/String;
    //   230: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: iload 4
    //   241: iload 5
    //   243: if_icmple -164 -> 79
    //   246: aload 8
    //   248: ldc_w 997
    //   251: iload 4
    //   253: invokevirtual 1011	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload 7
    //   259: aload 8
    //   261: invokevirtual 861	org/json/JSONObject:toString	()Ljava/lang/String;
    //   264: putfield 992	aipv:f	Ljava/lang/String;
    //   267: new 173	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   274: aload_2
    //   275: invokevirtual 260	java/lang/String:trim	()Ljava/lang/String;
    //   278: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 210
    //   283: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_3
    //   287: invokevirtual 260	java/lang/String:trim	()Ljava/lang/String;
    //   290: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore_2
    //   297: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +29 -> 329
    //   303: ldc 171
    //   305: iconst_2
    //   306: new 173	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 1013
    //   316: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_2
    //   320: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 7
    //   331: aload_2
    //   332: putfield 328	aipv:e	Ljava/lang/String;
    //   335: aload_0
    //   336: aload 7
    //   338: aload_0
    //   339: aload 7
    //   341: getfield 328	aipv:e	Ljava/lang/String;
    //   344: invokevirtual 367	aipw:a	(Ljava/lang/String;)Ljava/lang/String;
    //   347: invokevirtual 1015	aipw:a	(Laipv;Ljava/lang/String;)V
    //   350: invokestatic 488	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   353: new 1017	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$16
    //   356: dup
    //   357: aload_0
    //   358: aload_1
    //   359: aload_2
    //   360: aload 8
    //   362: invokespecial 1020	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$16:<init>	(Laipw;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   365: invokevirtual 499	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   368: pop
    //   369: goto -290 -> 79
    //   372: astore_1
    //   373: aload_1
    //   374: invokevirtual 364	java/lang/Throwable:printStackTrace	()V
    //   377: goto -298 -> 79
    //   380: astore_1
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_1
    //   384: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	aipw
    //   0	385	1	paramString1	String
    //   0	385	2	paramString2	String
    //   0	385	3	paramString3	String
    //   0	385	4	paramInt	int
    //   165	79	5	k	int
    //   72	3	6	bool	boolean
    //   98	242	7	localaipv	aipv
    //   150	211	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   138	152	372	java/lang/Throwable
    //   157	239	372	java/lang/Throwable
    //   246	329	372	java/lang/Throwable
    //   329	369	372	java/lang/Throwable
    //   2	54	380	finally
    //   54	74	380	finally
    //   82	133	380	finally
    //   138	152	380	finally
    //   157	239	380	finally
    //   246	329	380	finally
    //   329	369	380	finally
    //   373	377	380	finally
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, paramString6, paramString7, paramBoolean1, paramBoolean2, paramInt, "", "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString8, String paramString9)
  {
    if ((aipv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) == null)
    {
      paramString2 = new aipv(paramString1, paramString2, paramString4, paramLong, new baig(paramString3, 5, 16).toString(), paramBoolean1, paramBoolean2, false, paramInt, paramString8, paramString9);
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
      azmj.b(localQQAppInterface, "CliOper", "", "", "0X8006115", "0X8006115", 0, 0, "", str, paramString, "0");
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
    ajat.a().a(new aiqd(this, paramInt2, paramInt1, paramBusinessObserver));
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
        Iterator localIterator = this.jdField_a_of_type_Aipu.a().iterator();
        if (localIterator.hasNext())
        {
          aipv localaipv = (aipv)localIterator.next();
          a(localaipv);
          a(false, localaipv.jdField_a_of_type_JavaLangString, localaipv.jdField_b_of_type_JavaLangString);
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
  
  public boolean a(String paramString, aipv paramaipv)
  {
    if ((bdje.a(paramString)) || (paramaipv == null)) {}
    String str;
    do
    {
      do
      {
        for (;;)
        {
          return false;
          str = a(paramaipv.e);
          if (paramaipv.a() != 0) {
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
                paramaipv = paramString[k];
                if ((!bdje.a(str)) && (paramaipv.equals(str.trim()))) {
                  return true;
                }
                k += 1;
              }
            }
          }
        }
      } while ((paramaipv.a() != 1) || (!a(paramString)));
      paramString = paramString.trim().substring(0, 1);
    } while ((bdje.a(paramString)) || (!paramString.equalsIgnoreCase(str)));
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
    aipv localaipv;
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
        localaipv = null;
      }
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByPwd", "msgType=6", 0, null, l);
      if (localaipv.jdField_a_of_type_Int != 0) {
        break label327;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("PasswdRedBagManager", 2, "----word hb----" + localaipv.jdField_a_of_type_JavaLangString);
    }
    if ((!bdje.a(paramString)) && (localaipv != null) && (!bdje.a(localaipv.d)) && (paramString.trim().equals(localaipv.d.trim())))
    {
      a(localaipv.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      a(paramSessionInfo, localaipv, l, paramInt);
    }
    for (;;)
    {
      return arrayOfObject;
      label327:
      if (4 == localaipv.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PasswdRedBagManager", 2, "----word chain hb----" + localaipv.jdField_a_of_type_JavaLangString);
        }
        if (a(paramString, localaipv)) {
          a(paramString.trim(), paramSessionInfo, localaipv, l, paramInt);
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
    aipv localaipv = (aipv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    if (localaipv == null)
    {
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "no redid");
      return arrayOfObject;
    }
    arrayOfObject[1] = Long.valueOf(localaipv.jdField_c_of_type_JavaLangString);
    if (4 == localaipv.jdField_a_of_type_Int)
    {
      arrayOfObject[2] = null;
      arrayOfObject[3] = null;
    }
    while (4 != localaipv.jdField_a_of_type_Int) {
      if (localaipv.jdField_a_of_type_Boolean)
      {
        VACDReportUtil.endReport(l, "pwd.end", "", -1, "opened");
        return arrayOfObject;
        if ((!localaipv.jdField_c_of_type_Boolean) && (localaipv.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
        {
          arrayOfObject[2] = paramString2;
          arrayOfObject[3] = localaipv.jdField_b_of_type_JavaLangString;
        }
      }
      else
      {
        if (localaipv.jdField_b_of_type_Boolean)
        {
          arrayOfObject[0] = Integer.valueOf(2);
          VACDReportUtil.endReport(l, "pwd.end", "", -1, "finish");
          return arrayOfObject;
        }
        if ((localaipv.jdField_c_of_type_Boolean) || (localaipv.jdField_a_of_type_Long < NetConnInfoCenter.getServerTimeMillis() / 1000L))
        {
          if (!localaipv.jdField_c_of_type_Boolean) {
            b(paramString2);
          }
          if (4 != localaipv.jdField_a_of_type_Int)
          {
            arrayOfObject[0] = Integer.valueOf(3);
            VACDReportUtil.endReport(l, "pwd.end", "", -1, "overdue");
            return arrayOfObject;
          }
        }
      }
    }
    if (!bdje.a(paramString1))
    {
      if ((localaipv.jdField_a_of_type_Int != 0) || (bdje.a(localaipv.d)) || (!paramString1.equals(localaipv.d))) {
        break label436;
      }
      a(localaipv.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      a(paramSessionInfo, localaipv, l, paramInt);
    }
    for (;;)
    {
      arrayOfObject[0] = Integer.valueOf(1);
      return arrayOfObject;
      label436:
      if ((4 != localaipv.jdField_a_of_type_Int) || (!a(paramString1, localaipv)) || (localaipv.jdField_b_of_type_Boolean) || (localaipv.a())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PasswdRedBagManager", 2, "----成语接龙红包----" + localaipv.jdField_a_of_type_JavaLangString);
      }
      a(paramString1.trim(), paramSessionInfo, localaipv, l, paramInt);
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
      List localList = this.jdField_a_of_type_Aipu.a(2);
      Iterator localIterator = this.jdField_j_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        aiqf localaiqf = new aiqf();
        localaiqf.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localaiqf.jdField_a_of_type_Int = 2;
        localaiqf.b = Long.parseLong((String)this.jdField_j_of_type_JavaUtilHashMap.get(localObject));
        int k = localList.indexOf(localaiqf);
        if (k != -1)
        {
          localObject = (aiqf)localList.get(k);
          if (localaiqf.b <= ((aiqf)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localaiqf.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localaiqf.b);
          localArrayList.add(localObject);
          this.jdField_b_of_type_JavaUtilList.add(localaiqf);
        }
      }
      this.jdField_j_of_type_JavaUtilHashMap.clear();
    } while (this.jdField_b_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_Alwl.a(1, localArrayList);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    aipv localaipv;
    do
    {
      return;
      a(false);
      localaipv = (aipv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localaipv == null) || (localaipv.jdField_c_of_type_Boolean));
    localaipv.jdField_c_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.14(this, paramString));
  }
  
  public void b(String paramString, int paramInt)
  {
    String str = alpo.a(2131708279);
    if (paramInt == 8) {
      str = "禁言不能抢K歌红包哦";
    }
    for (;;)
    {
      ((bclk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81)).a(paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
      return;
      if (paramInt == 9) {
        str = alpo.a(2131708276);
      } else if (paramInt == 10) {
        str = alpo.a(2131708277);
      } else if (paramInt == 11) {
        str = alpo.a(2131708280);
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
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006116", "0X8006116", 0, 0, "", "0", paramString, "0");
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1219	aipw:a	()Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 1221	aipw:e	()V
    //   13: aload_0
    //   14: getfield 145	aipw:jdField_h_of_type_Boolean	Z
    //   17: ifeq +12 -> 29
    //   20: aload_0
    //   21: getfield 522	aipw:jdField_i_of_type_Boolean	Z
    //   24: istore_1
    //   25: iload_1
    //   26: ifeq +6 -> 32
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 522	aipw:jdField_i_of_type_Boolean	Z
    //   37: new 1342	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$10
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 1343	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$10:<init>	(Laipw;)V
    //   45: bipush 32
    //   47: aconst_null
    //   48: iconst_1
    //   49: invokestatic 1344	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   52: goto -23 -> 29
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	aipw
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
    this.jdField_a_of_type_Aipu = new aipu(this);
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
    this.jdField_a_of_type_Alwm.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwm);
    this.jdField_a_of_type_Aipu.a();
    if ((this.jdField_a_of_type_Aiqe != null) && (this.jdField_a_of_type_AndroidContentContext != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aiqe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipw
 * JD-Core Version:    0.7.0.1
 */