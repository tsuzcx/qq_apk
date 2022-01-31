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

public class akkj
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<akkl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public akkj(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static akkd a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    akkd localakkd = null;
    while (localIterator.hasNext())
    {
      akkc localakkc = (akkc)((Map.Entry)localIterator.next()).getValue();
      if (!akkm.a(localakkc.jdField_b_of_type_Long))
      {
        localakkd = a(paramBoolean, paramPromotionConfigInfo.mUin, localakkc);
        if (localakkd != null) {
          return localakkd;
        }
      }
    }
    return localakkd;
  }
  
  static akkd a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, akkc paramakkc)
  {
    akkd localakkd = a(paramBoolean, paramPromotionConfigInfo.mUin, paramakkc);
    paramakkc = localakkd;
    if (localakkd == null)
    {
      paramakkc = localakkd;
      if (paramBoolean) {
        paramakkc = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramakkc;
  }
  
  public static akkd a(boolean paramBoolean, String paramString, akkc paramakkc)
  {
    paramakkc = paramakkc.a().entrySet().iterator();
    while (paramakkc.hasNext())
    {
      akkd localakkd = (akkd)((Map.Entry)paramakkc.next()).getValue();
      if (localakkd.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(akkm.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localakkd.e + "], index[" + localakkd.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localakkd.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(akkm.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localakkd.e + "], index[" + localakkd.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localakkd)) {
        return localakkd;
      }
    }
    return null;
  }
  
  private ArrayList<akkl> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, akkd paramakkd)
  {
    if ((a() == null) || (paramakkd == null))
    {
      a(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramakkd);
    paramakkd.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (axxj)paramAppInterface.getManager(193);
    ((axxj)localObject1).a(paramakkd.jdField_a_of_type_JavaLangString);
    ((axxj)localObject1).a(paramakkd.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramakkd.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramakkd))
    {
      paramAppInterface = paramakkd.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramakkd.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramakkd + "], zipPath[" + (String)localObject1 + "]");
        paramakkd.a(2);
        paramString2.a(paramakkd.jdField_a_of_type_JavaLangString, paramakkd.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramakkd);
        return;
      }
      finally {}
    }
    Object localObject2 = paramakkd.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramakkd.jdField_a_of_type_Boolean = false;
        if (paramakkd.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramakkd + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramakkd.a(1);
      boolean bool = ((aljb)paramAppInterface.getManager(191)).a(paramakkd.jdField_a_of_type_JavaLangString, paramakkd.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramakkd, paramakkd.jdField_a_of_type_Alje);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramakkd + "]");
      if (!bool) {
        paramString2.a(paramakkd.jdField_a_of_type_JavaLangString, paramakkd.jdField_b_of_type_JavaLangString, -4, null, paramakkd);
      }
    }
  }
  
  static boolean a(akkd paramakkd)
  {
    if (paramakkd.jdField_a_of_type_Int == 0)
    {
      String str = akki.a(paramakkd);
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
        paramakkd = akki.b(paramakkd);
        if (new File(paramakkd + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramakkd + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramakkd.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, akkd paramakkd)
  {
    String str = paramakkd.d;
    if (bakf.a(paramString, paramakkd.e, paramakkd.jdField_a_of_type_Int, paramakkd.jdField_b_of_type_JavaLangString, str)) {
      return a(paramakkd);
    }
    return false;
  }
  
  /* Error */
  alje a(AppInterface paramAppInterface, akkd paramakkd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 218	akkd:jdField_a_of_type_Alje	Lalje;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 218	akkd:jdField_a_of_type_Alje	Lalje;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	akkd:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 265	akkk
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	akkd:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 268	akkk:<init>	(Lakkj;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 218	akkd:jdField_a_of_type_Alje	Lalje;
    //   41: aload_2
    //   42: getfield 218	akkd:jdField_a_of_type_Alje	Lalje;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	akkj
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramakkd	akkd
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
  
  public void a(akkl paramakkl)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramakkl);
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
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (akkc)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((akkc)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((akkd)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((akkd)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((akkd)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new axxk((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (akkd)localObject1), 0L);
        paramBoolean = ((axxj)paramAppInterface.getManager(193)).a(10074, "prd", paramString, 0, ((akkd)localObject1).jdField_a_of_type_JavaLangString, ((akkd)localObject1).jdField_c_of_type_JavaLangString, ((akkd)localObject1).jdField_b_of_type_Int, 0, true, (axxg)localObject2);
        ((akkd)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((akkd)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.e());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((akkd)localObject1).e + "], index[" + ((akkd)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(ajjy.a(2131642731), paramBoolean, paramAppInterface, ((akkd)localObject1).e, ((akkd)localObject1).jdField_a_of_type_Int, (akkd)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    while (paramPromotionConfigInfo.hasNext())
    {
      Iterator localIterator = ((akkc)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
      while (localIterator.hasNext()) {
        ((akkd)((Map.Entry)localIterator.next()).getValue()).a();
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
      ((akkl)localIterator.next()).a();
    }
  }
  
  public void b(akkl paramakkl)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramakkl);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((akkl)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akkj
 * JD-Core Version:    0.7.0.1
 */