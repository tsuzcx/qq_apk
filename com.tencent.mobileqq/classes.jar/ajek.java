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

public class ajek
{
  public static volatile int a;
  private static volatile ajek jdField_a_of_type_Ajek;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, aqmf> a;
  protected List<aqmf> a;
  public boolean a;
  
  private ajek()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 0;
  }
  
  public static ajek a()
  {
    if (jdField_a_of_type_Ajek == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ajek == null) {
        jdField_a_of_type_Ajek = new ajek();
      }
      return jdField_a_of_type_Ajek;
    }
  }
  
  public aqmf a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      aqmf localaqmf = (aqmf)localIterator.next();
      if (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong) {
        return localaqmf;
      }
    }
    return null;
  }
  
  public List<aqmf> a()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    for (;;)
    {
      aqmf localaqmf;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label266;
        }
        localaqmf = (aqmf)localIterator.next();
        if ((localaqmf == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nru.jdField_a_of_type_Int)
        {
          bool = false;
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break label274;
          }
          bool = ((QQAppInterface)localAppRuntime).getNowLiveManager().a();
          break label274;
        }
        if ((localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (b()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
      }
      if (((localAppRuntime instanceof QQAppInterface)) && (amvb.a((QQAppInterface)localAppRuntime, localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList, " + localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + " is filtered");
        }
      }
      else if (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType != 1)
      {
        localList2.add(localaqmf);
        continue;
        label266:
        amvb.a(localList2);
        return localList2;
        label274:
        if (!bool) {}
      }
    }
  }
  
  public List<aqmf> a(Context paramContext, QQAppInterface paramQQAppInterface)
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
            aqmf localaqmf = new aqmf();
            try
            {
              localaqmf.jdField_a_of_type_Long = localLebaPluginInfo.uiResId;
              localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo = localLebaPluginInfo;
              if (!amvb.a(localaqmf)) {
                break label298;
              }
              this.jdField_a_of_type_JavaUtilHashMap.put(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName, localaqmf);
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
                localArrayList2.add(localaqmf);
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.a(bool1);
      }
      Collections.sort(localArrayList2, new amvd());
      paramContext = (azvi)paramQQAppInterface.getManager(36);
      if (paramContext != null) {
        break label442;
      }
    }
    label442:
    for (paramContext = null;; paramContext = paramContext.a())
    {
      a(paramQQAppInterface, localArrayList2, paramContext);
      paramContext = a(paramQQAppInterface);
      amvb.a(localArrayList1, paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.mgr", 2, "reloadLebaItems, info.size=" + localList.size() + ", alldatasize=" + this.jdField_a_of_type_JavaUtilList.size() + ", pluginShowList=" + paramContext.size());
      }
      return localArrayList1;
    }
  }
  
  public List<aqmf> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = a();
    StringBuffer localStringBuffer1;
    for (;;)
    {
      aqmf localaqmf;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        localStringBuffer1 = new StringBuffer("getLebaShowList,");
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localaqmf = (aqmf)localIterator.next();
        if ((localaqmf == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if ((localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (b())) {
          localStringBuffer1.append("hide leba kandian,");
        }
      }
      if (a(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        StringBuffer localStringBuffer2 = localStringBuffer1.append("isNowTabAdded");
        paramQQAppInterface.getNowLiveManager();
        localStringBuffer2.append(nru.c).append("  isNowTabShow:").append(paramQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean).append("  isSDKAPISupportStory:").append(vla.i()).append(",");
        if ((!paramQQAppInterface.getNowLiveManager().a()) || (localaqmf.jdField_a_of_type_Byte == 1)) {}
      }
      else if (amvb.a(paramQQAppInterface, localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        localStringBuffer1.append(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId).append(" is filtered");
      }
      else
      {
        a(bool, localaqmf, localArrayList);
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuffer1.append("alldatasize=").append(this.jdField_a_of_type_JavaUtilList.size()).append(", result").append(aqmf.a(localArrayList));
      QLog.i("Q.lebatab.mgr", 2, localStringBuffer1.toString());
    }
    amvb.a(localArrayList);
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
        aqmf localaqmf = (aqmf)((Iterator)localObject).next();
        if (localaqmf != null) {
          if (localaqmf.jdField_a_of_type_Byte == 0)
          {
            if (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
              bcef.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
            }
          }
          else if ((localaqmf.jdField_a_of_type_Byte == 1) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
            bcef.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
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
          break label292;
        }
        aqmf localaqmf = (aqmf)localIterator.next();
        if ((localaqmf == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean1)
        {
          i = 0;
          localaqmf.jdField_a_of_type_Byte = ((byte)i);
          if (paramLong3 == -9223372036854775808L)
          {
            localaqmf.b = paramLong2;
            i = k;
            j = i;
            if (!QLog.isDevelopLevel()) {
              break label292;
            }
            QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, name = " + localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " status:" + paramBoolean1);
            if ((paramQQAppInterface != null) && (i == 1)) {
              ThreadManager.post(new LebaShowListManager.1(this, (azvi)paramQQAppInterface.getManager(36), paramLong1, paramBoolean1, paramLong3, paramLong2, paramBoolean2), 5, null, true);
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
        if (paramLong2 == localaqmf.b)
        {
          localaqmf.b = paramLong3;
          i = k;
        }
      }
      i = -2147483648;
      continue;
      label292:
      i = j;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<aqmf> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
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
          paramQQAppInterface = (amzs)paramQQAppInterface.getBusinessHandler(31);
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
        aqmf localaqmf = (aqmf)localIterator1.next();
        if ((localaqmf == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          continue;
        }
        long l = localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
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
          localaqmf.jdField_a_of_type_Byte = b;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.lebatab.mgr", 4, "updateAllLebaListFlag, name = " + localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " cCurFlag:" + localaqmf.jdField_a_of_type_Byte);
          }
          localaqmf.b = localAppSetting.modify_ts.get();
        }
      }
      byte b = 1;
    }
  }
  
  public void a(boolean paramBoolean, aqmf paramaqmf, List<aqmf> paramList)
  {
    if (paramBoolean) {
      if ((paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.showInSimpleMode != 0) || (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L)) {
        paramList.add(paramaqmf);
      }
    }
    while ((paramaqmf.jdField_a_of_type_Byte != 0) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L)) {
      return;
    }
    paramList.add(paramaqmf);
  }
  
  public boolean a()
  {
    return bbyp.a();
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == nru.jdField_a_of_type_Int;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        aqmf localaqmf = (aqmf)paramQQAppInterface.next();
        if ((localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong)) {
          return localaqmf.jdField_a_of_type_Byte == 0;
        }
      }
    }
    return false;
  }
  
  public List<aqmf> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aqmf localaqmf = (aqmf)localIterator.next();
        if ((localaqmf != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 905L) && ((localaqmf.jdField_a_of_type_Byte == 0) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L))) {
          localArrayList.add(localaqmf);
        }
      }
    }
    return localList1;
  }
  
  public boolean b()
  {
    return bkwm.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajek
 * JD-Core Version:    0.7.0.1
 */