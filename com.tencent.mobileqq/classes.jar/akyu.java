import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.1;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class akyu
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<akyw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public akyu(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static akyo a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    akyo localakyo = null;
    while (localIterator.hasNext())
    {
      akyn localakyn = (akyn)((Map.Entry)localIterator.next()).getValue();
      if (!akyx.a(localakyn.jdField_b_of_type_Long))
      {
        localakyo = a(paramBoolean, paramPromotionConfigInfo.mUin, localakyn);
        if (localakyo != null) {
          return localakyo;
        }
      }
    }
    return localakyo;
  }
  
  static akyo a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, akyn paramakyn)
  {
    akyo localakyo = a(paramBoolean, paramPromotionConfigInfo.mUin, paramakyn);
    paramakyn = localakyo;
    if (localakyo == null)
    {
      paramakyn = localakyo;
      if (paramBoolean) {
        paramakyn = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramakyn;
  }
  
  public static akyo a(boolean paramBoolean, String paramString, akyn paramakyn)
  {
    paramakyn = paramakyn.a().entrySet().iterator();
    while (paramakyn.hasNext())
    {
      akyo localakyo = (akyo)((Map.Entry)paramakyn.next()).getValue();
      if (localakyo.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(akyx.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localakyo.e + "], index[" + localakyo.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localakyo.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(akyx.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localakyo.e + "], index[" + localakyo.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localakyo)) {
        return localakyo;
      }
    }
    return null;
  }
  
  private ArrayList<akyw> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, akyo paramakyo)
  {
    if ((a() == null) || (paramakyo == null))
    {
      a(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramakyo);
    paramakyo.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (ayxs)paramAppInterface.getManager(193);
    ((ayxs)localObject1).a(paramakyo.jdField_a_of_type_JavaLangString);
    ((ayxs)localObject1).a(paramakyo.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramakyo.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramakyo))
    {
      paramAppInterface = paramakyo.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramakyo.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramakyo + "], zipPath[" + (String)localObject1 + "]");
        paramakyo.a(2);
        paramString2.a(paramakyo.jdField_a_of_type_JavaLangString, paramakyo.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramakyo);
        return;
      }
      finally {}
    }
    Object localObject2 = paramakyo.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramakyo.jdField_a_of_type_Boolean = false;
        if (paramakyo.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramakyo + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramakyo.a(1);
      boolean bool = ((alxo)paramAppInterface.getManager(191)).a(paramakyo.jdField_a_of_type_JavaLangString, paramakyo.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramakyo, paramakyo.jdField_a_of_type_Alxr);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramakyo + "]");
      if (!bool) {
        paramString2.a(paramakyo.jdField_a_of_type_JavaLangString, paramakyo.jdField_b_of_type_JavaLangString, -4, null, paramakyo);
      }
    }
  }
  
  static boolean a(akyo paramakyo)
  {
    if (paramakyo.jdField_a_of_type_Int == 0)
    {
      String str = akyt.a(paramakyo);
      if (!new File(str + "entry.png").exists()) {
        if (QLog.isDevelopLevel()) {
          QLog.w("PromotionResDownload", 1, "文件不存在, path[" + str + "], name[" + "entry.png" + "]");
        }
      }
      do
      {
        do
        {
          return false;
          if (new File(str + "entry.json").exists()) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.w("PromotionResDownload", 1, "文件不存在, path[" + str + "], name[" + "entry.json" + "]");
        return false;
        paramakyo = akyt.b(paramakyo);
        if (new File(paramakyo + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramakyo + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramakyo.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, akyo paramakyo)
  {
    String str = paramakyo.d;
    if (bbmd.a(paramString, paramakyo.e, paramakyo.jdField_a_of_type_Int, paramakyo.jdField_b_of_type_JavaLangString, str)) {
      return a(paramakyo);
    }
    return false;
  }
  
  /* Error */
  alxr a(AppInterface paramAppInterface, akyo paramakyo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 218	akyo:jdField_a_of_type_Alxr	Lalxr;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 218	akyo:jdField_a_of_type_Alxr	Lalxr;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	akyo:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 265	akyv
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	akyo:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 268	akyv:<init>	(Lakyu;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 218	akyo:jdField_a_of_type_Alxr	Lalxr;
    //   41: aload_2
    //   42: getfield 218	akyo:jdField_a_of_type_Alxr	Lalxr;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	akyu
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramakyo	akyo
    //   22	13	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   18	46	49	finally
  }
  
  PromotionConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  }
  
  public void a(akyw paramakyw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramakyw);
      return;
    }
  }
  
  void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, ConfigInfo为空, callByPreDownload[" + paramBoolean + "], activatyid[" + paramString + "], index[" + paramInt + "]");
    }
    do
    {
      Object localObject2;
      for (;;)
      {
        return;
        if (!(paramAppInterface instanceof QQAppInterface))
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 不在主进程");
          return;
        }
        localObject2 = ((PromotionConfigInfo)localObject1).getItem(paramString);
        if (localObject2 == null)
        {
          a(paramString, paramInt, -3);
          return;
        }
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (akyn)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((akyn)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((akyo)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((akyo)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((akyo)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new ayxt((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (akyo)localObject1), 0L);
        paramBoolean = ((ayxs)paramAppInterface.getManager(193)).a(10074, "prd", paramString, 0, ((akyo)localObject1).jdField_a_of_type_JavaLangString, ((akyo)localObject1).jdField_c_of_type_JavaLangString, ((akyo)localObject1).jdField_b_of_type_Int, 0, true, (ayxp)localObject2);
        ((akyo)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((akyo)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.e());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((akyo)localObject1).e + "], index[" + ((akyo)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(ajya.a(2131708527), paramBoolean, paramAppInterface, ((akyo)localObject1).e, ((akyo)localObject1).jdField_a_of_type_Int, (akyo)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    while (paramPromotionConfigInfo.hasNext())
    {
      Iterator localIterator = ((akyn)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
      while (localIterator.hasNext()) {
        ((akyo)((Map.Entry)localIterator.next()).getValue()).a();
      }
    }
  }
  
  void a(String paramString, int paramInt1, int paramInt2)
  {
    b(paramString, paramInt1, paramInt2);
    BusinessCommonConfig.sendDownloadResultNotify(2, paramString, paramInt1, paramInt2);
  }
  
  void b()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((akyw)localIterator.next()).a();
    }
  }
  
  public void b(akyw paramakyw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramakyw);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((akyw)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyu
 * JD-Core Version:    0.7.0.1
 */