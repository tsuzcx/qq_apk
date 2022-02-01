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

public class akgr
{
  public static volatile int a;
  private static volatile akgr jdField_a_of_type_Akgr;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, arsh> a;
  protected List<arsh> a;
  public boolean a;
  
  private akgr()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 0;
  }
  
  public static akgr a()
  {
    if (jdField_a_of_type_Akgr == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Akgr == null) {
        jdField_a_of_type_Akgr = new akgr();
      }
      return jdField_a_of_type_Akgr;
    }
  }
  
  public arsh a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      arsh localarsh = (arsh)localIterator.next();
      if (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong) {
        return localarsh;
      }
    }
    return null;
  }
  
  public List<arsh> a()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    for (;;)
    {
      arsh localarsh;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label266;
        }
        localarsh = (arsh)localIterator.next();
        if ((localarsh == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nql.jdField_a_of_type_Int)
        {
          bool = false;
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break label274;
          }
          bool = ((QQAppInterface)localAppRuntime).a().a();
          break label274;
        }
        if ((localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (b()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
      }
      if (((localAppRuntime instanceof QQAppInterface)) && (aoaz.a((QQAppInterface)localAppRuntime, localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList, " + localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + " is filtered");
        }
      }
      else if (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType != 1)
      {
        localList2.add(localarsh);
        continue;
        label266:
        aoaz.a(localList2);
        return localList2;
        label274:
        if (!bool) {}
      }
    }
  }
  
  public List<arsh> a(Context paramContext, QQAppInterface paramQQAppInterface)
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
            arsh localarsh = new arsh();
            try
            {
              localarsh.jdField_a_of_type_Long = localLebaPluginInfo.uiResId;
              localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo = localLebaPluginInfo;
              if (!aoaz.a(localarsh)) {
                break label298;
              }
              this.jdField_a_of_type_JavaUtilHashMap.put(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName, localarsh);
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
                localArrayList2.add(localarsh);
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.a(bool1);
      }
      Collections.sort(localArrayList2, new aoba());
      paramContext = (bbav)paramQQAppInterface.getManager(36);
      if (paramContext != null) {
        break label442;
      }
    }
    label442:
    for (paramContext = null;; paramContext = paramContext.a())
    {
      a(paramQQAppInterface, localArrayList2, paramContext);
      paramContext = a(paramQQAppInterface);
      aoaz.a(localArrayList1, paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.mgr", 2, "reloadLebaItems, info.size=" + localList.size() + ", alldatasize=" + this.jdField_a_of_type_JavaUtilList.size() + ", pluginShowList=" + paramContext.size());
      }
      return localArrayList1;
    }
  }
  
  public List<arsh> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = a();
    StringBuffer localStringBuffer1;
    for (;;)
    {
      arsh localarsh;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        localStringBuffer1 = new StringBuffer("getLebaShowList,");
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localarsh = (arsh)localIterator.next();
        if ((localarsh == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 905L)) {
          continue;
        }
        if ((localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1130L) && (b())) {
          localStringBuffer1.append("hide leba kandian,");
        }
      }
      if (a(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        StringBuffer localStringBuffer2 = localStringBuffer1.append("isNowTabAdded");
        paramQQAppInterface.a();
        localStringBuffer2.append(nql.c).append("  isNowTabShow:").append(paramQQAppInterface.a().jdField_a_of_type_Boolean).append("  isSDKAPISupportStory:").append(wjb.i()).append(",");
        if ((!paramQQAppInterface.a().a()) || (localarsh.jdField_a_of_type_Byte == 1)) {}
      }
      else if (aoaz.a(paramQQAppInterface, localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        localStringBuffer1.append(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId).append(" is filtered");
      }
      else
      {
        a(bool, localarsh, localArrayList);
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuffer1.append("alldatasize=").append(this.jdField_a_of_type_JavaUtilList.size()).append(", result").append(arsh.a(localArrayList));
      QLog.i("Q.lebatab.mgr", 2, localStringBuffer1.toString());
    }
    aoaz.a(localArrayList);
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
        arsh localarsh = (arsh)((Iterator)localObject).next();
        if (localarsh != null) {
          if (localarsh.jdField_a_of_type_Byte == 0)
          {
            if (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
              bdll.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
            }
          }
          else if ((localarsh.jdField_a_of_type_Byte == 1) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
            bdll.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), "", "");
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
        arsh localarsh = (arsh)localIterator.next();
        if ((localarsh == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean)
        {
          i = 0;
          localarsh.jdField_a_of_type_Byte = ((byte)i);
          if (paramLong3 == -9223372036854775808L)
          {
            localarsh.b = paramLong2;
            i = k;
            j = i;
            if (!QLog.isDevelopLevel()) {
              break label290;
            }
            QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, name = " + localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " status:" + paramBoolean);
            if ((paramQQAppInterface != null) && (i == 1)) {
              ThreadManager.post(new LebaShowListManager.1(this, (bbav)paramQQAppInterface.getManager(36), paramLong1, paramBoolean, paramLong3, paramLong2), 5, null, true);
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
        if (paramLong2 == localarsh.b)
        {
          localarsh.b = paramLong3;
          i = k;
        }
      }
      i = -2147483648;
      continue;
      label290:
      i = j;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<arsh> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
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
          paramQQAppInterface = (aogd)paramQQAppInterface.a(31);
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
        arsh localarsh = (arsh)localIterator1.next();
        if ((localarsh == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          continue;
        }
        long l = localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
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
          localarsh.jdField_a_of_type_Byte = b;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.lebatab.mgr", 4, "updateAllLebaListFlag, name = " + localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + " cCurFlag:" + localarsh.jdField_a_of_type_Byte);
          }
          localarsh.b = localAppSetting.modify_ts.get();
        }
      }
      byte b = 1;
    }
  }
  
  public void a(boolean paramBoolean, arsh paramarsh, List<arsh> paramList)
  {
    if (paramBoolean) {
      if ((paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.showInSimpleMode != 0) || (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L)) {
        paramList.add(paramarsh);
      }
    }
    while ((paramarsh.jdField_a_of_type_Byte != 0) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L)) {
      return;
    }
    paramList.add(paramarsh);
  }
  
  public boolean a()
  {
    return bdgb.a();
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == nql.jdField_a_of_type_Int;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        arsh localarsh = (arsh)paramQQAppInterface.next();
        if ((localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == paramLong)) {
          return localarsh.jdField_a_of_type_Byte == 0;
        }
      }
    }
    return false;
  }
  
  public List<arsh> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        arsh localarsh = (arsh)localIterator.next();
        if ((localarsh != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 905L) && ((localarsh.jdField_a_of_type_Byte == 0) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 0L))) {
          localArrayList.add(localarsh);
        }
      }
    }
    return localList1;
  }
  
  public boolean b()
  {
    return bnrf.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgr
 * JD-Core Version:    0.7.0.1
 */