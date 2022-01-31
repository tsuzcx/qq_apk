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

public class aiab
{
  public static volatile int a;
  private static volatile aiab jdField_a_of_type_Aiab;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, aovj> a;
  protected List<aovj> a;
  public boolean a;
  
  private aiab()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 0;
  }
  
  public static aiab a()
  {
    if (jdField_a_of_type_Aiab == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aiab == null) {
        jdField_a_of_type_Aiab = new aiab();
      }
      return jdField_a_of_type_Aiab;
    }
  }
  
  public aovj a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      aovj localaovj = (aovj)localIterator.next();
      if (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong) {
        return localaovj;
      }
    }
    return null;
  }
  
  public List<aovj> a()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    for (;;)
    {
      aovj localaovj;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label265;
        }
        localaovj = (aovj)localIterator.next();
        if ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nga.jdField_a_of_type_Int)
        {
          bool = false;
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break label273;
          }
          bool = ((QQAppInterface)localAppRuntime).a().a();
          break label273;
        }
        if ((localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (bjxj.k()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
      }
      if (((localAppRuntime instanceof QQAppInterface)) && (alrc.a((QQAppInterface)localAppRuntime, localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList, " + localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + " is filtered");
        }
      }
      else if (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType != 1)
      {
        localList2.add(localaovj);
        continue;
        label265:
        alrc.a(localList2);
        return localList2;
        label273:
        if (!bool) {}
      }
    }
  }
  
  public List<aovj> a(Context paramContext, QQAppInterface paramQQAppInterface)
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
            aovj localaovj = new aovj();
            try
            {
              localaovj.jdField_a_of_type_Long = localLebaPluginInfo.uiResId;
              localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo = localLebaPluginInfo;
              if (!alrc.a(localaovj)) {
                break label298;
              }
              this.jdField_a_of_type_JavaUtilHashMap.put(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName, localaovj);
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
                localArrayList2.add(localaovj);
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.a(bool1);
      }
      Collections.sort(localArrayList2, new alrd());
      paramContext = (axho)paramQQAppInterface.getManager(36);
      if (paramContext != null) {
        break label442;
      }
    }
    label442:
    for (paramContext = null;; paramContext = paramContext.a())
    {
      a(paramQQAppInterface, localArrayList2, paramContext);
      paramContext = a(paramQQAppInterface);
      alrc.a(localArrayList1, paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.mgr", 2, "reloadLebaItems, info.size=" + localList.size() + ", alldatasize=" + this.jdField_a_of_type_JavaUtilList.size() + ", pluginShowList=" + paramContext.size());
      }
      return localArrayList1;
    }
  }
  
  public List<aovj> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = azib.a();
    for (;;)
    {
      aovj localaovj;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localaovj = (aovj)localIterator.next();
        if ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if ((localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (bjxj.k()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "hide leba kandian");
        }
      }
      StringBuilder localStringBuilder;
      if (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nga.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("getLebaShowList isNowTabAdded:");
          paramQQAppInterface.a();
          QLog.d("Q.qqstory.fourTab", 2, nga.c + "  isNowTabShow:" + paramQQAppInterface.a().jdField_a_of_type_Boolean + "  isSDKAPISupportStory:" + uhl.i());
        }
        if ((!paramQQAppInterface.a().a()) || (localaovj.jdField_a_of_type_Byte == 1)) {}
      }
      else if (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nga.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("getLebaShowList isNowTabAdded:");
          paramQQAppInterface.a();
          QLog.d("Q.qqstory.fourTab", 2, nga.c + "  isNowTabShow:" + paramQQAppInterface.a().jdField_a_of_type_Boolean + "  isSDKAPISupportStory:" + uhl.i());
        }
        if ((!paramQQAppInterface.a().a()) || (localaovj.jdField_a_of_type_Byte == 1)) {}
      }
      else if (alrc.a(paramQQAppInterface, localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaShowList, " + localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + " is filtered");
        }
      }
      else if (bool)
      {
        if (((localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.showInSimpleMode != 0)) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L)) {
          localArrayList.add(localaovj);
        }
      }
      else if ((localaovj.jdField_a_of_type_Byte == 0) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L))
      {
        localArrayList.add(localaovj);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.mgr", 2, "alldatasize=" + this.jdField_a_of_type_JavaUtilList.size() + ", result" + aovj.a(localArrayList));
    }
    alrc.a(localArrayList);
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
        aovj localaovj = (aovj)((Iterator)localObject).next();
        if (localaovj != null) {
          if (localaovj.jdField_a_of_type_Byte == 0)
          {
            if (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
              azmj.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
            }
          }
          else if ((localaovj.jdField_a_of_type_Byte == 1) && (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
            azmj.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
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
        aovj localaovj = (aovj)localIterator.next();
        if ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean)
        {
          i = 0;
          localaovj.jdField_a_of_type_Byte = ((byte)i);
          if (paramLong3 == -9223372036854775808L)
          {
            localaovj.b = paramLong2;
            i = k;
            j = i;
            if (!QLog.isDevelopLevel()) {
              break label290;
            }
            QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, name = " + localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " status:" + paramBoolean);
            if ((paramQQAppInterface != null) && (i == 1)) {
              ThreadManager.post(new LebaShowListManager.1(this, (axho)paramQQAppInterface.getManager(36), paramLong1, paramBoolean, paramLong3, paramLong2), 5, null, true);
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
        if (paramLong2 == localaovj.b)
        {
          localaovj.b = paramLong3;
          i = k;
        }
      }
      i = -2147483648;
      continue;
      label290:
      i = j;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<aovj> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
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
          paramQQAppInterface = (alwv)paramQQAppInterface.a(31);
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
        aovj localaovj = (aovj)localIterator1.next();
        if ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          continue;
        }
        long l = localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
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
          localaovj.jdField_a_of_type_Byte = b;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.lebatab.mgr", 4, "updateAllLebaListFlag, name = " + localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " cCurFlag:" + localaovj.jdField_a_of_type_Byte);
          }
          localaovj.b = localAppSetting.modify_ts.get();
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
        aovj localaovj = (aovj)paramQQAppInterface.next();
        if ((localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong)) {
          return localaovj.jdField_a_of_type_Byte == 0;
        }
      }
    }
    return false;
  }
  
  public List<aovj> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aovj localaovj = (aovj)localIterator.next();
        if ((localaovj != null) && (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 905L) && ((localaovj.jdField_a_of_type_Byte == 0) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L))) {
          localArrayList.add(localaovj);
        }
      }
    }
    return localList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiab
 * JD-Core Version:    0.7.0.1
 */