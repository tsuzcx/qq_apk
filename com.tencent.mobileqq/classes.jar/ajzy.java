import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager.1;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class ajzy
{
  public static volatile int a;
  private static volatile ajzy jdField_a_of_type_Ajzy;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, arpq> a;
  protected List<arpq> a;
  public boolean a;
  
  private ajzy()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 0;
  }
  
  public static ajzy a()
  {
    if (jdField_a_of_type_Ajzy == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ajzy == null) {
        jdField_a_of_type_Ajzy = new ajzy();
      }
      return jdField_a_of_type_Ajzy;
    }
  }
  
  public arpq a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      arpq localarpq = (arpq)localIterator.next();
      if (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong) {
        return localarpq;
      }
    }
    return null;
  }
  
  public List<arpq> a()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    for (;;)
    {
      arpq localarpq;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label266;
        }
        localarpq = (arpq)localIterator.next();
        if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nyv.jdField_a_of_type_Int)
        {
          bool = false;
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break label274;
          }
          bool = ((QQAppInterface)localAppRuntime).getNowLiveManager().a();
          break label274;
        }
        if ((localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (b()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
      }
      if (((localAppRuntime instanceof QQAppInterface)) && (anxo.a((QQAppInterface)localAppRuntime, localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList, " + localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + " is filtered");
        }
      }
      else if (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType != 1)
      {
        localList2.add(localarpq);
        continue;
        label266:
        anxo.a(localList2);
        return localList2;
        label274:
        if (!bool) {}
      }
    }
  }
  
  public List<arpq> a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, String.format(Locale.getDefault(), "reloadLebaItems [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), paramContext, paramQQAppInterface }));
    }
    ArrayList localArrayList1 = new ArrayList();
    List localList = paramQQAppInterface.getLebaResourceInfoList();
    ArrayList localArrayList2;
    if (localList != null)
    {
      paramContext = paramQQAppInterface.getLebaHelper().a;
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
            arpq localarpq = new arpq();
            try
            {
              localarpq.jdField_a_of_type_Long = localLebaPluginInfo.uiResId;
              localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo = localLebaPluginInfo;
              if (!anxo.a(localarpq)) {
                break label298;
              }
              this.jdField_a_of_type_JavaUtilHashMap.put(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName, localarpq);
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
                localArrayList2.add(localarpq);
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.a(bool1);
      }
      Collections.sort(localArrayList2, new anxq());
      paramContext = (bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (paramContext != null) {
        break label445;
      }
    }
    label445:
    for (paramContext = null;; paramContext = paramContext.a())
    {
      a(paramQQAppInterface, localArrayList2, paramContext);
      paramContext = a(paramQQAppInterface);
      anxo.a(localArrayList1, paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.mgr", 2, "reloadLebaItems, info.size=" + localList.size() + ", alldatasize=" + this.jdField_a_of_type_JavaUtilList.size() + ", pluginShowList=" + paramContext.size());
      }
      return localArrayList1;
    }
  }
  
  public List<arpq> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = a();
    StringBuffer localStringBuffer1;
    for (;;)
    {
      arpq localarpq;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        localStringBuffer1 = new StringBuffer("getLebaShowList,");
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localarpq = (arpq)localIterator.next();
        if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if ((localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (b())) {
          localStringBuffer1.append("hide leba kandian,");
        }
      }
      if (a(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        StringBuffer localStringBuffer2 = localStringBuffer1.append("isNowTabAdded");
        paramQQAppInterface.getNowLiveManager();
        localStringBuffer2.append(nyv.c).append("  isNowTabShow:").append(paramQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean).append("  isSDKAPISupportStory:").append(vzv.i()).append(",");
        if ((!paramQQAppInterface.getNowLiveManager().a()) || (localarpq.jdField_a_of_type_Byte == 1)) {}
      }
      else if (anxo.a(paramQQAppInterface, localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        localStringBuffer1.append(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId).append(" is filtered");
      }
      else
      {
        a(bool, localarpq, localArrayList);
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuffer1.append("alldatasize=").append(this.jdField_a_of_type_JavaUtilList.size()).append(", result").append(arpq.a(localArrayList));
      QLog.i("Q.lebatab.mgr", 2, localStringBuffer1.toString());
    }
    anxo.a(localArrayList);
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
        arpq localarpq = (arpq)((Iterator)localObject).next();
        if (localarpq != null) {
          if (localarpq.jdField_a_of_type_Byte == 0)
          {
            if (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
              bdla.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
            }
          }
          else if ((localarpq.jdField_a_of_type_Byte == 1) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
            bdla.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    a(paramQQAppInterface, paramLong1, paramBoolean, paramLong2, paramLong3, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2)
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
          break label293;
        }
        arpq localarpq = (arpq)localIterator.next();
        if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean1)
        {
          i = 0;
          localarpq.jdField_a_of_type_Byte = ((byte)i);
          if (paramLong3 == -9223372036854775808L)
          {
            localarpq.b = paramLong2;
            i = k;
            j = i;
            if (!QLog.isDevelopLevel()) {
              break label293;
            }
            QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, name = " + localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " status:" + paramBoolean1);
            if ((paramQQAppInterface != null) && (i == 1)) {
              ThreadManager.post(new LebaShowListManager.1(this, (bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH), paramLong1, paramBoolean1, paramLong3, paramLong2, paramBoolean2), 5, null, true);
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
        if (paramLong2 == localarpq.b)
        {
          localarpq.b = paramLong3;
          i = k;
        }
      }
      i = -2147483648;
      continue;
      label293:
      i = j;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<arpq> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList != null) {
        break label112;
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
          paramQQAppInterface = (aoch)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.RED_TOUCH_HANDLER);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.notifyUI(1, true, null);
          }
        }
        return;
        label112:
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
        arpq localarpq = (arpq)localIterator1.next();
        if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          continue;
        }
        long l = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
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
          localarpq.jdField_a_of_type_Byte = b;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.lebatab.mgr", 4, "updateAllLebaListFlag, name = " + localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " cCurFlag:" + localarpq.jdField_a_of_type_Byte);
          }
          localarpq.b = localAppSetting.modify_ts.get();
        }
      }
      byte b = 1;
    }
  }
  
  public void a(boolean paramBoolean, arpq paramarpq, List<arpq> paramList)
  {
    if (paramBoolean) {
      if ((paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.showInSimpleMode != 0) || (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L)) {
        paramList.add(paramarpq);
      }
    }
    while ((paramarpq.jdField_a_of_type_Byte != 0) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L)) {
      return;
    }
    paramList.add(paramarpq);
  }
  
  public boolean a()
  {
    return bdfk.a();
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == nyv.jdField_a_of_type_Int;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        arpq localarpq = (arpq)paramQQAppInterface.next();
        if ((localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong)) {
          return localarpq.jdField_a_of_type_Byte == 0;
        }
      }
    }
    return false;
  }
  
  public List<arpq> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        arpq localarpq = (arpq)localIterator.next();
        if ((localarpq != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 905L) && ((localarpq.jdField_a_of_type_Byte == 0) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L))) {
          localArrayList.add(localarpq);
        }
      }
    }
    return localList1;
  }
  
  public boolean b()
  {
    return bmhv.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzy
 * JD-Core Version:    0.7.0.1
 */