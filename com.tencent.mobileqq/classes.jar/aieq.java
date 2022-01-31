import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class aieq
{
  public static volatile int a;
  private static volatile aieq jdField_a_of_type_Aieq;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, aozs> a;
  protected List<aozs> a;
  public boolean a;
  
  private aieq()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 0;
  }
  
  public static aieq a()
  {
    if (jdField_a_of_type_Aieq == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aieq == null) {
        jdField_a_of_type_Aieq = new aieq();
      }
      return jdField_a_of_type_Aieq;
    }
  }
  
  public aozs a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      aozs localaozs = (aozs)localIterator.next();
      if (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong) {
        return localaozs;
      }
    }
    return null;
  }
  
  public List<aozs> a()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    for (;;)
    {
      aozs localaozs;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label265;
        }
        localaozs = (aozs)localIterator.next();
        if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nga.jdField_a_of_type_Int)
        {
          bool = false;
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break label273;
          }
          bool = ((QQAppInterface)localAppRuntime).a().a();
          break label273;
        }
        if ((localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (bkbq.k()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
      }
      if (((localAppRuntime instanceof QQAppInterface)) && (alvr.a((QQAppInterface)localAppRuntime, localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList, " + localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + " is filtered");
        }
      }
      else if (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType != 1)
      {
        localList2.add(localaozs);
        continue;
        label265:
        alvr.a(localList2);
        return localList2;
        label273:
        if (!bool) {}
      }
    }
  }
  
  public List<aozs> a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, String.format(Locale.getDefault(), "reloadLebaItems [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), paramContext, paramQQAppInterface }));
    }
    ArrayList localArrayList1 = new ArrayList();
    List localList = paramQQAppInterface.a();
    ArrayList localArrayList2;
    if (localList != null)
    {
      paramContext = paramQQAppInterface.a().a;
      if ((paramContext == null) && (QLog.isDevelopLevel())) {
        QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeopleChecker is null");
      }
      Object localObject = new ArrayList(localList);
      localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      boolean bool1 = false;
      while (((Iterator)localObject).hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)((Iterator)localObject).next();
        if (localLebaPluginInfo != null) {
          if ((localLebaPluginInfo.uiResId == 770L) && (paramContext != null) && (!paramContext.jdField_a_of_type_Boolean))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeople entry switch is off ");
            }
          }
          else
          {
            boolean bool2 = bool1;
            if (localLebaPluginInfo.uiResId == 770L) {
              bool2 = true;
            }
            aozs localaozs = new aozs();
            try
            {
              localaozs.jdField_a_of_type_Long = localLebaPluginInfo.uiResId;
              localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo = localLebaPluginInfo;
              if (!alvr.a(localaozs)) {
                break label298;
              }
              this.jdField_a_of_type_JavaUtilHashMap.put(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName, localaozs);
              bool1 = bool2;
            }
            catch (Exception localException)
            {
              bool1 = bool2;
            }
            if (QLog.isColorLevel())
            {
              bool1 = bool2;
              if (localException != null)
              {
                QLog.d("Q.lebatab.mgr", 2, localException.toString());
                bool1 = bool2;
                continue;
                label298:
                localArrayList2.add(localaozs);
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.a(bool1);
      }
      Collections.sort(localArrayList2, new alvs());
      paramContext = (axlx)paramQQAppInterface.getManager(36);
      if (paramContext != null) {
        break label442;
      }
    }
    label442:
    for (paramContext = null;; paramContext = paramContext.a())
    {
      a(paramQQAppInterface, localArrayList2, paramContext);
      paramContext = a(paramQQAppInterface);
      alvr.a(localArrayList1, paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.mgr", 2, "reloadLebaItems, info.size=" + localList.size() + ", alldatasize=" + this.jdField_a_of_type_JavaUtilList.size() + ", pluginShowList=" + paramContext.size());
      }
      return localArrayList1;
    }
  }
  
  public List<aozs> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = azmk.a();
    for (;;)
    {
      aozs localaozs;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localaozs = (aozs)localIterator.next();
        if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if ((localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (bkbq.k()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "hide leba kandian");
        }
      }
      StringBuilder localStringBuilder;
      if (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nga.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("getLebaShowList isNowTabAdded:");
          paramQQAppInterface.a();
          QLog.d("Q.qqstory.fourTab", 2, nga.c + "  isNowTabShow:" + paramQQAppInterface.a().jdField_a_of_type_Boolean + "  isSDKAPISupportStory:" + ulu.i());
        }
        if ((!paramQQAppInterface.a().a()) || (localaozs.jdField_a_of_type_Byte == 1)) {}
      }
      else if (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nga.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("getLebaShowList isNowTabAdded:");
          paramQQAppInterface.a();
          QLog.d("Q.qqstory.fourTab", 2, nga.c + "  isNowTabShow:" + paramQQAppInterface.a().jdField_a_of_type_Boolean + "  isSDKAPISupportStory:" + ulu.i());
        }
        if ((!paramQQAppInterface.a().a()) || (localaozs.jdField_a_of_type_Byte == 1)) {}
      }
      else if (alvr.a(paramQQAppInterface, localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaShowList, " + localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + " is filtered");
        }
      }
      else if (bool)
      {
        if (((localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.showInSimpleMode != 0)) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L)) {
          localArrayList.add(localaozs);
        }
      }
      else if ((localaozs.jdField_a_of_type_Byte == 0) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L))
      {
        localArrayList.add(localaozs);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.mgr", 2, "alldatasize=" + this.jdField_a_of_type_JavaUtilList.size() + ", result" + aozs.a(localArrayList));
    }
    alvr.a(localArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aozs localaozs = (aozs)((Iterator)localObject).next();
        if (localaozs != null) {
          if (localaozs.jdField_a_of_type_Byte == 0)
          {
            if (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
              azqs.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
            }
          }
          else if ((localaozs.jdField_a_of_type_Byte == 1) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
            azqs.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    int i = 1;
    int k = 1;
    for (;;)
    {
      int j;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        j = i;
        if (!localIterator.hasNext()) {
          break label290;
        }
        aozs localaozs = (aozs)localIterator.next();
        if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean)
        {
          i = 0;
          localaozs.jdField_a_of_type_Byte = ((byte)i);
          if (paramLong3 == -9223372036854775808L)
          {
            localaozs.b = paramLong2;
            i = k;
            j = i;
            if (!QLog.isDevelopLevel()) {
              break label290;
            }
            QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, name = " + localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " status:" + paramBoolean);
            if ((paramQQAppInterface != null) && (i == 1)) {
              ThreadManager.post(new LebaShowListManager.1(this, (axlx)paramQQAppInterface.getManager(36), paramLong1, paramBoolean, paramLong3, paramLong2), 5, null, true);
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + i);
            }
          }
        }
        else
        {
          i = 1;
          continue;
        }
        if (paramLong2 == localaozs.b)
        {
          localaozs.b = paramLong3;
          i = k;
        }
      }
      i = -2147483648;
      continue;
      label290:
      i = j;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<aozs> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList != null) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (paramList != null) {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
        a(paramList1);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (ambk)paramQQAppInterface.a(31);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.notifyUI(1, true, null);
          }
        }
        return;
        label111:
        i = paramList.size();
      }
    }
  }
  
  public void a(List<BusinessInfoCheckUpdate.AppSetting> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        aozs localaozs = (aozs)localIterator1.next();
        if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          continue;
        }
        long l = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        if (l == 0L) {
          continue;
        }
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator2.next();
        if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
          continue;
        }
        if (localAppSetting.setting.get())
        {
          b = 0;
          localaozs.jdField_a_of_type_Byte = b;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.lebatab.mgr", 4, "updateAllLebaListFlag, name = " + localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " cCurFlag:" + localaozs.jdField_a_of_type_Byte);
          }
          localaozs.b = localAppSetting.modify_ts.get();
        }
      }
      byte b = 1;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        aozs localaozs = (aozs)paramQQAppInterface.next();
        if ((localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong)) {
          return localaozs.jdField_a_of_type_Byte == 0;
        }
      }
    }
    return false;
  }
  
  public List<aozs> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aozs localaozs = (aozs)localIterator.next();
        if ((localaozs != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 905L) && ((localaozs.jdField_a_of_type_Byte == 0) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L))) {
          localArrayList.add(localaozs);
        }
      }
    }
    return localList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aieq
 * JD-Core Version:    0.7.0.1
 */