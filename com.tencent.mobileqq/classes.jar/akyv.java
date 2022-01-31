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

public class akyv
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<akyx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public akyv(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static akyp a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    akyp localakyp = null;
    while (localIterator.hasNext())
    {
      akyo localakyo = (akyo)((Map.Entry)localIterator.next()).getValue();
      if (!akyy.a(localakyo.jdField_b_of_type_Long))
      {
        localakyp = a(paramBoolean, paramPromotionConfigInfo.mUin, localakyo);
        if (localakyp != null) {
          return localakyp;
        }
      }
    }
    return localakyp;
  }
  
  static akyp a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, akyo paramakyo)
  {
    akyp localakyp = a(paramBoolean, paramPromotionConfigInfo.mUin, paramakyo);
    paramakyo = localakyp;
    if (localakyp == null)
    {
      paramakyo = localakyp;
      if (paramBoolean) {
        paramakyo = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramakyo;
  }
  
  public static akyp a(boolean paramBoolean, String paramString, akyo paramakyo)
  {
    paramakyo = paramakyo.a().entrySet().iterator();
    while (paramakyo.hasNext())
    {
      akyp localakyp = (akyp)((Map.Entry)paramakyo.next()).getValue();
      if (localakyp.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(akyy.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localakyp.e + "], index[" + localakyp.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localakyp.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(akyy.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localakyp.e + "], index[" + localakyp.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localakyp)) {
        return localakyp;
      }
    }
    return null;
  }
  
  private ArrayList<akyx> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, akyp paramakyp)
  {
    if ((a() == null) || (paramakyp == null))
    {
      a(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramakyp);
    paramakyp.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (ayxq)paramAppInterface.getManager(193);
    ((ayxq)localObject1).a(paramakyp.jdField_a_of_type_JavaLangString);
    ((ayxq)localObject1).a(paramakyp.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramakyp.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramakyp))
    {
      paramAppInterface = paramakyp.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramakyp.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramakyp + "], zipPath[" + (String)localObject1 + "]");
        paramakyp.a(2);
        paramString2.a(paramakyp.jdField_a_of_type_JavaLangString, paramakyp.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramakyp);
        return;
      }
      finally {}
    }
    Object localObject2 = paramakyp.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramakyp.jdField_a_of_type_Boolean = false;
        if (paramakyp.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramakyp + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramakyp.a(1);
      boolean bool = ((alxp)paramAppInterface.getManager(191)).a(paramakyp.jdField_a_of_type_JavaLangString, paramakyp.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramakyp, paramakyp.jdField_a_of_type_Alxs);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramakyp + "]");
      if (!bool) {
        paramString2.a(paramakyp.jdField_a_of_type_JavaLangString, paramakyp.jdField_b_of_type_JavaLangString, -4, null, paramakyp);
      }
    }
  }
  
  static boolean a(akyp paramakyp)
  {
    if (paramakyp.jdField_a_of_type_Int == 0)
    {
      String str = akyu.a(paramakyp);
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
        paramakyp = akyu.b(paramakyp);
        if (new File(paramakyp + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramakyp + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramakyp.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, akyp paramakyp)
  {
    String str = paramakyp.d;
    if (bblp.a(paramString, paramakyp.e, paramakyp.jdField_a_of_type_Int, paramakyp.jdField_b_of_type_JavaLangString, str)) {
      return a(paramakyp);
    }
    return false;
  }
  
  /* Error */
  alxs a(AppInterface paramAppInterface, akyp paramakyp)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 218	akyp:jdField_a_of_type_Alxs	Lalxs;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 218	akyp:jdField_a_of_type_Alxs	Lalxs;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	akyp:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 265	akyw
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	akyp:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 268	akyw:<init>	(Lakyv;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 218	akyp:jdField_a_of_type_Alxs	Lalxs;
    //   41: aload_2
    //   42: getfield 218	akyp:jdField_a_of_type_Alxs	Lalxs;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	akyv
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramakyp	akyp
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
  
  public void a(akyx paramakyx)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramakyx);
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
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (akyo)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((akyo)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((akyp)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((akyp)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((akyp)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new ayxr((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (akyp)localObject1), 0L);
        paramBoolean = ((ayxq)paramAppInterface.getManager(193)).a(10074, "prd", paramString, 0, ((akyp)localObject1).jdField_a_of_type_JavaLangString, ((akyp)localObject1).jdField_c_of_type_JavaLangString, ((akyp)localObject1).jdField_b_of_type_Int, 0, true, (ayxn)localObject2);
        ((akyp)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((akyp)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.e());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((akyp)localObject1).e + "], index[" + ((akyp)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(ajyc.a(2131708516), paramBoolean, paramAppInterface, ((akyp)localObject1).e, ((akyp)localObject1).jdField_a_of_type_Int, (akyp)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    while (paramPromotionConfigInfo.hasNext())
    {
      Iterator localIterator = ((akyo)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
      while (localIterator.hasNext()) {
        ((akyp)((Map.Entry)localIterator.next()).getValue()).a();
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
      ((akyx)localIterator.next()).a();
    }
  }
  
  public void b(akyx paramakyx)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramakyx);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((akyx)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyv
 * JD-Core Version:    0.7.0.1
 */