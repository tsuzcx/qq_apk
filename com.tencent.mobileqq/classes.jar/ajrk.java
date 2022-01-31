import android.os.Looper;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RoamSettingManager.1;
import com.tencent.mobileqq.app.RoamSettingManager.2;
import com.tencent.mobileqq.app.RoamSettingManager.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class ajrk
  implements Manager
{
  public atmp a;
  public QQHashMap<String, RoamSetting> a;
  RoamSetting a;
  public Lock a;
  public boolean a;
  public QQHashMap<String, RoamSetting> b;
  
  public ajrk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new QQHashMap(1003, 0, 60);
    this.b = new QQHashMap(1004, 0, 60);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    a();
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = Integer.parseInt(paramString);
      if ((i == -2) || (i == -1) || (i == 1) || (i == 2) || (i == 3) || (i == 4)) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("RoamSettingManager", 1, paramString + "");
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)this.jdField_a_of_type_Atmp.a(RoamSetting.class, "setting_revision"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = null;
      return 0;
    }
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "parse revision.value exception, revision.value=" + this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
        }
        int i = 0;
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    RoamSetting localRoamSetting2 = a(paramString);
    RoamSetting localRoamSetting1 = localRoamSetting2;
    if (localRoamSetting2 == null)
    {
      localRoamSetting1 = localRoamSetting2;
      if (!TextUtils.isEmpty(paramString))
      {
        localRoamSetting1 = new RoamSetting(paramString, Integer.toString(paramInt));
        a(localRoamSetting1);
      }
    }
    return RoamSetting.getIntValue(localRoamSetting1, paramInt);
  }
  
  /* Error */
  public RoamSetting a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 49	ajrk:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 139 1 0
    //   15: aload_1
    //   16: invokestatic 143	bahr:a	(Ljava/lang/String;)I
    //   19: istore_2
    //   20: iload_2
    //   21: iconst_1
    //   22: if_icmpne +106 -> 128
    //   25: aload_0
    //   26: getfield 44	ajrk:b	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   29: aload_1
    //   30: invokevirtual 147	com/tencent/commonsdk/cache/QQHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 89	com/tencent/mobileqq/data/RoamSetting
    //   36: astore_3
    //   37: aload_3
    //   38: astore 4
    //   40: aload_3
    //   41: ifnonnull +75 -> 116
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 21	ajrk:jdField_a_of_type_Boolean	Z
    //   51: ifne +65 -> 116
    //   54: aload_0
    //   55: getfield 35	ajrk:jdField_a_of_type_Atmp	Latmp;
    //   58: ldc 89
    //   60: aload_1
    //   61: invokevirtual 96	atmp:a	(Ljava/lang/Class;Ljava/lang/String;)Latmo;
    //   64: checkcast 89	com/tencent/mobileqq/data/RoamSetting
    //   67: astore_1
    //   68: aload_1
    //   69: astore 4
    //   71: aload_1
    //   72: ifnull +44 -> 116
    //   75: aload_1
    //   76: astore 4
    //   78: aload_1
    //   79: getfield 150	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   82: ifnull +34 -> 116
    //   85: aload_1
    //   86: astore 4
    //   88: aload_1
    //   89: getfield 100	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   92: ifnull +24 -> 116
    //   95: iload_2
    //   96: iconst_1
    //   97: if_icmpne +46 -> 143
    //   100: aload_0
    //   101: getfield 44	ajrk:b	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   104: aload_1
    //   105: getfield 150	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   108: aload_1
    //   109: invokevirtual 154	com/tencent/commonsdk/cache/QQHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_1
    //   114: astore 4
    //   116: aload_0
    //   117: getfield 49	ajrk:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   120: invokeinterface 157 1 0
    //   125: aload 4
    //   127: areturn
    //   128: aload_0
    //   129: getfield 42	ajrk:jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   132: aload_1
    //   133: invokevirtual 147	com/tencent/commonsdk/cache/QQHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 89	com/tencent/mobileqq/data/RoamSetting
    //   139: astore_3
    //   140: goto -103 -> 37
    //   143: aload_0
    //   144: getfield 42	ajrk:jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   147: aload_1
    //   148: getfield 150	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   151: aload_1
    //   152: invokevirtual 154	com/tencent/commonsdk/cache/QQHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_1
    //   157: astore 4
    //   159: goto -43 -> 116
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 49	ajrk:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   167: invokeinterface 157 1 0
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	ajrk
    //   0	174	1	paramString	String
    //   19	79	2	i	int
    //   36	104	3	localRoamSetting	RoamSetting
    //   38	120	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	20	162	finally
    //   25	37	162	finally
    //   47	68	162	finally
    //   78	85	162	finally
    //   88	95	162	finally
    //   100	113	162	finally
    //   128	140	162	finally
    //   143	156	162	finally
  }
  
  public RoamSetting a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    RoamSetting localRoamSetting = a(paramString1);
    if (localRoamSetting == null)
    {
      localRoamSetting = new RoamSetting(paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        if (bahr.a(paramString1) == 1)
        {
          if (a(paramString2))
          {
            this.b.put(localRoamSetting.path, localRoamSetting);
            return localRoamSetting;
            if (paramString2.equals(localRoamSetting.value)) {
              return null;
            }
            localRoamSetting.value = paramString2;
            break;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("RoamSettingManager", 2, "isTroopRoamSettingLegal false. path:" + paramString1 + ", value:" + paramString2);
          continue;
        }
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(localRoamSetting.path, localRoamSetting);
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new RoamSettingManager.1(this), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting != null)
    {
      localObject = Integer.toString(paramInt);
      if (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value = ((String)localObject);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting);
      return;
      localObject = new RoamSetting();
      ((RoamSetting)localObject).path = "setting_revision";
      ((RoamSetting)localObject).value = Integer.toString(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)localObject);
    }
  }
  
  public void a(RoamSetting paramRoamSetting)
  {
    if ((paramRoamSetting == null) || (paramRoamSetting.path == null) || (paramRoamSetting.value == null)) {
      return;
    }
    int j = bahr.a(paramRoamSetting.path);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    if (j == 1) {}
    for (;;)
    {
      try
      {
        if (a(paramRoamSetting.value))
        {
          this.b.put(paramRoamSetting.path, paramRoamSetting);
          i = 1;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if ((j == 1) && (i == 0)) {
            break;
          }
          if (Looper.myLooper() == Looper.getMainLooper()) {
            break label182;
          }
          a(paramRoamSetting);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label199;
        }
        QLog.e("RoamSettingManager", 2, "isTroopRoamSettingLegal false. path:" + paramRoamSetting.path + ", value:" + paramRoamSetting.value);
        i = 0;
        continue;
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(paramRoamSetting.path, paramRoamSetting);
        i = 1;
        continue;
        ThreadManagerV2.excute(new RoamSettingManager.2(this, paramRoamSetting), 32, null, false);
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label182:
      return;
      label199:
      int i = 0;
    }
  }
  
  public void a(String paramString)
  {
    RoamSetting localRoamSetting = a(paramString);
    if ((localRoamSetting == null) || (localRoamSetting.path == null) || (localRoamSetting.value == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (bahr.a(paramString) == 1) {
        this.b.remove(localRoamSetting.path);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
          break;
        }
        ThreadManager.post(new RoamSettingManager.3(this, localRoamSetting), 5, null, false);
        return;
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.remove(localRoamSetting.path);
      }
      b(localRoamSetting);
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(List<RoamSetting> paramList)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      atmr localatmr = this.jdField_a_of_type_Atmp.a();
      localObject1 = localatmr;
      localObject2 = localatmr;
      localatmr.a();
      if (paramList != null)
      {
        int i = 0;
        for (;;)
        {
          localObject1 = localatmr;
          localObject2 = localatmr;
          if (i >= paramList.size()) {
            break;
          }
          localObject1 = localatmr;
          localObject2 = localatmr;
          a((atmo)paramList.get(i));
          i += 1;
        }
      }
      localObject1 = localatmr;
      localObject2 = localatmr;
      localatmr.c();
      return;
    }
    catch (Exception paramList)
    {
      localObject2 = localObject1;
      paramList.printStackTrace();
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.w("RoamSettingManager", 2, "insert write exception: " + paramList.getMessage());
      }
      return;
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.b();
      }
    }
  }
  
  public boolean a(atmo paramatmo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Atmp.a())
    {
      if (paramatmo.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_Atmp.b(paramatmo);
      bool1 = bool2;
      if (paramatmo.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramatmo.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramatmo.getStatus() != 1002);
    return this.jdField_a_of_type_Atmp.a(paramatmo);
  }
  
  public boolean b(atmo paramatmo)
  {
    if (this.jdField_a_of_type_Atmp.a()) {
      return this.jdField_a_of_type_Atmp.b(paramatmo);
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.clear();
    }
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap != null) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.clear();
    }
    if ((this.jdField_a_of_type_Atmp != null) && (this.jdField_a_of_type_Atmp.a())) {
      this.jdField_a_of_type_Atmp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajrk
 * JD-Core Version:    0.7.0.1
 */