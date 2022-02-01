import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager.1;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager.2;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.Manager;

public class afpn
  implements Manager
{
  public static String a;
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AppGuideTipsConfig jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Map<String, AppGuideTipsConfig> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AppGuideTipsManager";
  }
  
  public afpn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void a(MessageRecord paramMessageRecord, AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    paramAppGuideTipsConfig = new MessageForTimDouFuGuide(paramAppGuideTipsConfig);
    paramAppGuideTipsConfig.frienduin = str;
    paramAppGuideTipsConfig.time = l;
    paramAppGuideTipsConfig.istroop = paramMessageRecord.istroop;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramAppGuideTipsConfig, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, false, true, true);
  }
  
  private void b(MessageRecord paramMessageRecord, AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    int i = paramAppGuideTipsConfig.tipsMsg.indexOf(paramAppGuideTipsConfig.tipsHighLight);
    int j = paramAppGuideTipsConfig.tipsHighLight.length();
    paramMessageRecord = new avhz(str, (String)localObject, paramAppGuideTipsConfig.tipsMsg, paramMessageRecord.istroop, -5022, 2621441, l);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", paramAppGuideTipsConfig.tipsUrl);
    paramMessageRecord.a(i, i + j, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
    ((MessageForUniteGrayTip)localObject).appGuideTipsOpKey = paramAppGuideTipsConfig.opkey;
    avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("tim_is_office_user", 0);
  }
  
  public AppGuideTipsConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig == null) {
      c();
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.post(new AppGuideTipsManager.1(this), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "saveOfficeUserFlag: " + paramInt);
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("tim_is_office_user", paramInt).apply();
  }
  
  public void a(BaseChatPie paramBaseChatPie, MessageRecord paramMessageRecord)
  {
    if ((this.b) || (this.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig == null)) {
      break label22;
    }
    label22:
    while (aqvh.a(paramMessageRecord)) {
      return;
    }
    AppGuideTipsConfig localAppGuideTipsConfig = this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig;
    long l = NetConnInfoCenter.getServerTimeMillis();
    label92:
    boolean bool1;
    if ((!"0".equals(localAppGuideTipsConfig.switchKey)) && (l - localAppGuideTipsConfig.lastAddTime > localAppGuideTipsConfig.duration * 1000L) && (localAppGuideTipsConfig.addCount < localAppGuideTipsConfig.maxCount))
    {
      localAppGuideTipsConfig.allow = true;
      bool1 = false;
      if (localAppGuideTipsConfig.allow)
      {
        if (localAppGuideTipsConfig.msgTypeMap.isEmpty()) {
          break label283;
        }
        paramMessageRecord = (Boolean)localAppGuideTipsConfig.msgTypeMap.get(Integer.valueOf(paramMessageRecord.msgtype));
        if ((paramMessageRecord == null) || (!paramMessageRecord.booleanValue())) {
          break label277;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (!localAppGuideTipsConfig.aioTypes.isEmpty()) {
          bool2 = localAppGuideTipsConfig.aioTypes.contains(Integer.valueOf(paramBaseChatPie.getCurType()));
        }
      }
      if ((!bool2) || (!paramBaseChatPie.showTimTips())) {
        break;
      }
      localAppGuideTipsConfig.allow = false;
      localAppGuideTipsConfig.addCount += 1;
      localAppGuideTipsConfig.lastAddTime = l;
      b(localAppGuideTipsConfig);
      bdla.b(null, "dc00898", "", "", "0X8008947", "0X8008947", 0, 0, "", "", "", "");
      return;
      localAppGuideTipsConfig.allow = false;
      break label92;
      label277:
      bool1 = false;
      continue;
      label283:
      bool1 = true;
    }
  }
  
  public void a(AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    try
    {
      localEditor.putString("tim_gray_tips_switch", paramAppGuideTipsConfig.switchKey);
      localEditor.putInt("tim_gray_tips_total", paramAppGuideTipsConfig.maxCount);
      localEditor.putLong("tim_gray_tips_duration", paramAppGuideTipsConfig.duration);
      localEditor.putString("tim_gray_tips_url", paramAppGuideTipsConfig.tipsUrl);
      localEditor.putString("tim_gray_tips_txt", paramAppGuideTipsConfig.tipsMsg);
      localEditor.putString("tim_gray_tips_types", paramAppGuideTipsConfig.msgTypeStr);
      localEditor.putString("tim_tips_bar_aio_types", paramAppGuideTipsConfig.aioTypeStr);
      localEditor.apply();
      return;
    }
    catch (Exception paramAppGuideTipsConfig)
    {
      paramAppGuideTipsConfig.printStackTrace();
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("app_tail_id");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if (!aqvh.a(paramMessageRecord))
      {
        localObject = (AppGuideTipsConfig)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if (localObject == null) {
          break;
        }
        if (((AppGuideTipsConfig)localObject).allow)
        {
          Boolean localBoolean = (Boolean)((AppGuideTipsConfig)localObject).msgTypeMap.get(Integer.valueOf(paramMessageRecord.msgtype));
          if ((localBoolean == null) || (!localBoolean.booleanValue())) {}
        }
        for (int i = 1; i != 0; i = 0)
        {
          ((AppGuideTipsConfig)localObject).allow = false;
          ((AppGuideTipsConfig)localObject).addCount += 1;
          ((AppGuideTipsConfig)localObject).lastAddTime = System.currentTimeMillis();
          a((Entity)localObject);
          if ("1".equals(((AppGuideTipsConfig)localObject).tipsType))
          {
            a(paramMessageRecord, (AppGuideTipsConfig)localObject);
            return;
          }
          b(paramMessageRecord, (AppGuideTipsConfig)localObject);
          return;
        }
      }
    }
  }
  
  /* Error */
  public void a(java.util.List<AppGuideTipsConfig> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 400 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 50	afpn:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   20: invokevirtual 406	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   23: astore 4
    //   25: aload 4
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 411	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   32: aload_0
    //   33: getfield 32	afpn:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   36: invokeinterface 414 1 0
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 95	afpn:jdField_a_of_type_Boolean	Z
    //   46: iconst_0
    //   47: istore_2
    //   48: iload_2
    //   49: aload_1
    //   50: invokeinterface 400 1 0
    //   55: if_icmpge +67 -> 122
    //   58: aload_1
    //   59: iload_2
    //   60: invokeinterface 417 2 0
    //   65: checkcast 97	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   68: astore 4
    //   70: aload 4
    //   72: ifnull +234 -> 306
    //   75: aload_0
    //   76: getfield 50	afpn:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   79: ldc 97
    //   81: aload 4
    //   83: getfield 390	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   86: invokevirtual 421	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   89: checkcast 97	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   92: astore 5
    //   94: aload 5
    //   96: ifnull +210 -> 306
    //   99: aload 4
    //   101: aload 5
    //   103: getfield 258	com/tencent/mobileqq/data/AppGuideTipsConfig:addCount	I
    //   106: putfield 258	com/tencent/mobileqq/data/AppGuideTipsConfig:addCount	I
    //   109: aload 4
    //   111: aload 5
    //   113: getfield 250	com/tencent/mobileqq/data/AppGuideTipsConfig:lastAddTime	J
    //   116: putfield 250	com/tencent/mobileqq/data/AppGuideTipsConfig:lastAddTime	J
    //   119: goto +187 -> 306
    //   122: new 97	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   125: dup
    //   126: invokespecial 422	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   129: astore 4
    //   131: aload 4
    //   133: sipush 1001
    //   136: invokevirtual 425	com/tencent/mobileqq/data/AppGuideTipsConfig:setStatus	(I)V
    //   139: aload_0
    //   140: getfield 50	afpn:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   143: aload 4
    //   145: ldc_w 427
    //   148: iconst_1
    //   149: anewarray 105	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: ldc 240
    //   156: aastore
    //   157: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   160: pop
    //   161: iconst_0
    //   162: istore_2
    //   163: iload_2
    //   164: aload_1
    //   165: invokeinterface 400 1 0
    //   170: if_icmpge +30 -> 200
    //   173: aload_1
    //   174: iload_2
    //   175: invokeinterface 417 2 0
    //   180: checkcast 97	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   183: astore 4
    //   185: aload 4
    //   187: ifnull +126 -> 313
    //   190: aload_0
    //   191: aload 4
    //   193: invokevirtual 385	afpn:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   196: pop
    //   197: goto +116 -> 313
    //   200: aload_3
    //   201: invokevirtual 434	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   204: aload_3
    //   205: ifnull -192 -> 13
    //   208: aload_3
    //   209: invokevirtual 437	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   212: return
    //   213: astore 4
    //   215: aload_3
    //   216: astore_1
    //   217: aload 4
    //   219: astore_3
    //   220: aload_3
    //   221: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   224: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +33 -> 260
    //   230: getstatic 22	afpn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   233: iconst_2
    //   234: new 197	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 439
    //   244: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_3
    //   248: invokevirtual 442	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   251: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 445	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_1
    //   261: ifnull -248 -> 13
    //   264: aload_1
    //   265: invokevirtual 437	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   268: return
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: ifnull +7 -> 280
    //   276: aload_3
    //   277: invokevirtual 437	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: goto -11 -> 272
    //   286: astore 4
    //   288: aload_1
    //   289: astore_3
    //   290: aload 4
    //   292: astore_1
    //   293: goto -21 -> 272
    //   296: astore 4
    //   298: aload_3
    //   299: astore_1
    //   300: aload 4
    //   302: astore_3
    //   303: goto -83 -> 220
    //   306: iload_2
    //   307: iconst_1
    //   308: iadd
    //   309: istore_2
    //   310: goto -262 -> 48
    //   313: iload_2
    //   314: iconst_1
    //   315: iadd
    //   316: istore_2
    //   317: goto -154 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	afpn
    //   0	320	1	paramList	java.util.List<AppGuideTipsConfig>
    //   47	270	2	i	int
    //   15	288	3	localObject1	Object
    //   23	169	4	localObject2	Object
    //   213	5	4	localException1	Exception
    //   286	5	4	localObject3	Object
    //   296	5	4	localException2	Exception
    //   92	20	5	localAppGuideTipsConfig	AppGuideTipsConfig
    // Exception table:
    //   from	to	target	type
    //   16	25	213	java/lang/Exception
    //   16	25	269	finally
    //   28	46	282	finally
    //   48	70	282	finally
    //   75	94	282	finally
    //   99	119	282	finally
    //   122	161	282	finally
    //   163	185	282	finally
    //   190	197	282	finally
    //   200	204	282	finally
    //   220	260	286	finally
    //   28	46	296	java/lang/Exception
    //   48	70	296	java/lang/Exception
    //   75	94	296	java/lang/Exception
    //   99	119	296	java/lang/Exception
    //   122	161	296	java/lang/Exception
    //   163	185	296	java/lang/Exception
    //   190	197	296	java/lang/Exception
    //   200	204	296	java/lang/Exception
  }
  
  public boolean a(Entity paramEntity)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() <= 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        AppGuideTipsConfig localAppGuideTipsConfig = (AppGuideTipsConfig)localIterator.next();
        if (localAppGuideTipsConfig != null) {
          if ((!"0".equals(localAppGuideTipsConfig.switchKey)) && (l - localAppGuideTipsConfig.lastAddTime > localAppGuideTipsConfig.duration * 1000L) && (localAppGuideTipsConfig.addCount < localAppGuideTipsConfig.maxCount)) {
            localAppGuideTipsConfig.allow = true;
          } else {
            localAppGuideTipsConfig.allow = false;
          }
        }
      }
    }
  }
  
  public void b(AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "updateTimAIOTipsBarConfig, add count: ", Integer.valueOf(paramAppGuideTipsConfig.addCount) });
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("tim_gray_tips_count", paramAppGuideTipsConfig.addCount);
    localEditor.putLong("tim_gray_tips_time", paramAppGuideTipsConfig.lastAddTime);
    localEditor.apply();
  }
  
  public void c()
  {
    AppGuideTipsConfig localAppGuideTipsConfig = new AppGuideTipsConfig();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    localAppGuideTipsConfig.switchKey = ((SharedPreferences)localObject).getString("tim_gray_tips_switch", "0");
    localAppGuideTipsConfig.maxCount = ((SharedPreferences)localObject).getInt("tim_gray_tips_total", 0);
    localAppGuideTipsConfig.duration = ((SharedPreferences)localObject).getLong("tim_gray_tips_duration", 0L);
    localAppGuideTipsConfig.tipsUrl = ((SharedPreferences)localObject).getString("tim_gray_tips_url", "");
    localAppGuideTipsConfig.tipsMsg = ((SharedPreferences)localObject).getString("tim_gray_tips_txt", "");
    localAppGuideTipsConfig.msgTypeStr = ((SharedPreferences)localObject).getString("tim_gray_tips_types", "");
    localAppGuideTipsConfig.aioTypeStr = ((SharedPreferences)localObject).getString("tim_tips_bar_aio_types", "");
    localAppGuideTipsConfig.addCount = ((SharedPreferences)localObject).getInt("tim_gray_tips_count", 0);
    localAppGuideTipsConfig.lastAddTime = ((SharedPreferences)localObject).getLong("tim_gray_tips_time", 0L);
    int i;
    int j;
    if (!TextUtils.isEmpty(localAppGuideTipsConfig.msgTypeStr))
    {
      localObject = localAppGuideTipsConfig.msgTypeStr.split("\\|");
      if (localObject != null)
      {
        i = 0;
        for (;;)
        {
          if (i < localObject.length) {
            try
            {
              j = Integer.valueOf(localObject[i]).intValue();
              localAppGuideTipsConfig.msgTypeMap.put(Integer.valueOf(j), Boolean.valueOf(true));
              i += 1;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                localException1.printStackTrace();
              }
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(localAppGuideTipsConfig.aioTypeStr))
    {
      localObject = localAppGuideTipsConfig.aioTypeStr.split("\\|");
      if (localObject != null)
      {
        i = 0;
        for (;;)
        {
          if (i < localObject.length) {
            try
            {
              j = Integer.valueOf(localObject[i]).intValue();
              localAppGuideTipsConfig.aioTypes.add(Integer.valueOf(j));
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localException2.printStackTrace();
              }
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataAppGuideTipsConfig = localAppGuideTipsConfig;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "loadTimAIOTipsBarConfig, switch: ", localAppGuideTipsConfig.switchKey });
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearTimAIOGrayTipsBarConfig");
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().clear().apply();
  }
  
  public void e()
  {
    ThreadManager.executeOnSubThread(new AppGuideTipsManager.2(this));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpn
 * JD-Core Version:    0.7.0.1
 */