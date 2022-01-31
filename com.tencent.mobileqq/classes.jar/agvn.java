import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.1;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.2;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.3;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.4;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.5;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.ReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class agvn
{
  public static int a(int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).c();
      return a("conf_taskid_" + paramInt + "_" + (String)localObject, 0);
    }
    return 0;
  }
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = BaseApplicationImpl.sApplication.getSharedPreferences("spring_hb_report", 0).getInt(paramString, paramInt);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getValueFromSP] fail.", paramString);
    }
    return paramInt;
  }
  
  private static String a()
  {
    Date localDate = new Date(NetConnInfoCenter.getServerTimeMillis());
    return String.format("%s", new Object[] { new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(localDate) });
  }
  
  public static String a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return c(localQQAppInterface, "conf_content_md5" + paramInt + "_" + str);
    }
    return "";
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString)
  {
    return String.format("%s_%s_%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "res_cover_tag" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String a(AppInterface paramAppInterface, int paramInt)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "res_hit_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramInt);
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getHitReportTagFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String a(boolean paramBoolean, int paramInt)
  {
    return String.format("%s_%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
  }
  
  public static void a()
  {
    a(false);
  }
  
  public static void a(int paramInt)
  {
    try
    {
      QQAppInterface localQQAppInterface = agwj.a();
      if (localQQAppInterface == null) {
        return;
      }
      String str1 = c(localQQAppInterface);
      String str2 = String.valueOf(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, "lastAdcodeTag: " + str1 + " currAdcodeTag:" + str2);
      }
      if (!str1.equals(str2))
      {
        agvs.a(agvm.d, 1, paramInt, null, false);
        c(localQQAppInterface, str2);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, localException, new Object[0]);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).c();
      a("conf_taskid_" + paramInt1 + "_" + (String)localObject, paramInt2);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "" + paramInt3);
      localHashMap.put("ext2", "" + paramInt4);
      localHashMap.put("ext3", "" + paramInt5);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        localHashMap.put("ext4", "" + paramVarArgs[0]);
      }
      agvs.a(agvm.b, paramInt1, paramInt2, localHashMap, paramBoolean);
      return;
    }
    catch (Throwable paramVarArgs)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "configReport: " + paramVarArgs);
    }
  }
  
  private static void a(int paramInt, AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    Object localObject;
    String str;
    do
    {
      do
      {
        return;
      } while ((paramInt != 1) && (paramInt != 2));
      localObject = a(paramAppInterface, paramInt);
      str = a();
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, String.format("[reportResHitInner] lastTag=%s curTag=%s hitAction=%s", new Object[] { localObject, str, Integer.valueOf(paramInt) }));
      }
      if (!TextUtils.equals((CharSequence)localObject, str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportResHitInner] no need to report.");
    return;
    if (paramInt == 1) {
      a(true);
    }
    for (;;)
    {
      a(paramAppInterface, paramInt, str);
      return;
      if (paramInt != 2) {
        break;
      }
      localObject = b(BaseApplicationImpl.sApplication.getRuntime());
      if (localObject != null) {
        ThreadManagerV2.executeOnFileThread(new SpringHbMonitorReporter.1((agvo)localObject));
      }
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      c(localQQAppInterface, "conf_content_md5" + paramInt + "_" + str, paramString);
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new SpringHbMonitorReporter.4(paramString, paramInt2, paramInt1));
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    if (paramInt4 == 0) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] taskid == 0");
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[reportConfigCoverageDaily] fail.", paramAppInterface);
      return;
    }
    String str = d(paramAppInterface);
    paramString = a(paramInt3, paramInt5, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] currentCfgTags == " + paramString + " cfgTags: " + str);
    }
    if (a(str, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] no need to report " + paramInt3);
      }
    }
    else
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "" + paramInt3);
      localHashMap.put("ext2", "" + paramInt4);
      localHashMap.put("ext3", "" + paramInt5);
      agvs.a(agvm.b, paramInt1, paramInt2, localHashMap, paramBoolean);
      if (baip.a(str)) {}
      for (;;)
      {
        d(paramAppInterface, paramString);
        return;
        paramString = str + "|" + paramString;
      }
    }
  }
  
  private static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    try
    {
      c(paramAppInterface, "res_hit_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramInt, paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "saveHitReportTagToSp fail.", paramAppInterface);
    }
  }
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "res_cover_tag" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  public static void a(PreloadModule paramPreloadModule, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramPreloadModule == null) || (TextUtils.isEmpty(paramPreloadModule.name))) {}
    do
    {
      do
      {
        return;
      } while (!paramPreloadModule.name.equals("2020_red_packet"));
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportResPreload] result=" + paramInt1 + ",url=" + paramString);
      }
      paramPreloadModule = agwj.c(paramString);
      if (!TextUtils.isEmpty(paramPreloadModule))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", paramPreloadModule);
        localHashMap.put("ext2", a(539) + "");
        localHashMap.put("ext3", c(539) + "");
        localHashMap.put("ext4", paramInt2 + "");
        agvs.a(agvm.jdField_a_of_type_JavaLangString, 2, paramInt1, localHashMap);
      }
      if (paramInt1 == 0)
      {
        a();
        return;
      }
    } while (paramInt2 != 404);
    a(paramString, 1, true);
  }
  
  public static void a(SpringHbReportManager.ReportInfo paramReportInfo, QQAppInterface paramQQAppInterface)
  {
    if ((paramReportInfo == null) || (paramQQAppInterface == null)) {
      break label8;
    }
    label8:
    while ((!"sy.zhc.ym".equals(paramReportInfo.eventName)) || (paramReportInfo.action != 0)) {
      return;
    }
    paramReportInfo = (agtk)paramQQAppInterface.getManager(342);
    long l = System.currentTimeMillis();
    if ((paramReportInfo != null) && (paramReportInfo.a())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[tryReportResHit] check res hit,isTodayAct=" + bool + " ,entryManager=" + paramReportInfo + ",cost=" + (System.currentTimeMillis() - l));
      }
      if (!bool) {
        break;
      }
      a(1, paramQQAppInterface);
      a(2, paramQQAppInterface);
      return;
    }
  }
  
  private static void a(String paramString, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, String.format("[saveIntValueToSP] key=%s value=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      BaseApplicationImpl.sApplication.getSharedPreferences("spring_hb_report", 0).edit().putInt(paramString, paramInt).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[saveIntValueToSP] fail.", paramString);
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.excute(new SpringHbMonitorReporter.2(paramString, paramInt1, paramInt2), 16, null, true);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if (baip.a(paramString)) {
          break label472;
        }
        new StringBuilder().append(BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin()).append("").toString();
        localObject1 = paramString.split("\\|");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label472;
        }
        int k = localObject1.length;
        i = 0;
        if (i >= k) {
          break label466;
        }
        if (agsy.a(localObject1[i])) {
          break label473;
        }
        bool = false;
        localObject1 = agwj.a();
        if (localObject1 == null) {
          return;
        }
        if (paramBoolean)
        {
          localObject2 = new HashMap();
          ((Map)localObject2).put("ext1", "" + paramString);
          ((Map)localObject2).put("ext2", "" + paramInt1);
          ((Map)localObject2).put("ext3", "" + paramInt2);
          localObject3 = agvm.f;
          if (bool)
          {
            i = 0;
            agvs.a((String)localObject3, 2, i, (Map)localObject2, false);
          }
        }
        else
        {
          localObject3 = b((AppInterface)localObject1);
          localObject2 = a(bool, paramInt2);
          if (QLog.isColorLevel()) {
            QLog.i("springHb_report_SpringHbMonitorReporter", 2, String.format("[reportOfflinePakcageCoverage] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject3, localObject2, Boolean.valueOf(paramBoolean) }));
          }
          if (!TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2)) {
            break label336;
          }
          if (!QLog.isColorLevel()) {
            break label472;
          }
          QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportOfflinePakcageCoverage] no need to report.");
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("springHb_report_SpringHbMonitorReporter", 1, "reportOfflinePakcageCoverage: " + paramString);
        return;
      }
      int i = 1;
      continue;
      label336:
      Object localObject3 = new HashMap();
      ((Map)localObject3).put("ext1", "" + paramString);
      ((Map)localObject3).put("ext2", "" + paramInt1);
      ((Map)localObject3).put("ext3", "" + paramInt2);
      paramString = agvm.c;
      if (bool) {}
      for (paramInt1 = j;; paramInt1 = 1)
      {
        agvs.a(paramString, 1, paramInt1, (Map)localObject3, true);
        b((AppInterface)localObject1, (String)localObject2);
        return;
      }
      label466:
      boolean bool = true;
      continue;
      label472:
      return;
      label473:
      i += 1;
    }
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().post(new SpringHbMonitorReporter.5(paramString, paramInt));
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", paramString);
    agvs.a(agvm.jdField_a_of_type_JavaLangString, 4, paramInt, localHashMap);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[checkResCover] begin, isFromHitReport=" + paramBoolean);
    }
    ThreadManagerV2.executeOnFileThread(new SpringHbMonitorReporter.3(paramBoolean));
  }
  
  public static void a(boolean paramBoolean1, int paramInt, AppInterface paramAppInterface, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject1;
    if (paramBoolean2)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("ext1", paramInt + "");
      ((Map)localObject1).put("ext2", a(539) + "");
      ((Map)localObject1).put("ext3", c(539) + "");
      localObject2 = agvm.f;
      if (!paramBoolean1) {
        break label219;
      }
    }
    label219:
    for (int i = 0;; i = 1)
    {
      agvs.a((String)localObject2, 1, i, (Map)localObject1, false);
      localObject2 = a(paramAppInterface);
      localObject1 = a(paramBoolean1, c(539));
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, String.format("[reportResCover] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject2, localObject1, Boolean.valueOf(paramBoolean2) }));
      }
      if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportResCover] no need to report.");
      }
      return;
    }
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("ext1", paramInt + "");
    ((Map)localObject2).put("ext2", a(539) + "");
    ((Map)localObject2).put("ext3", c(539) + "");
    String str = agvm.jdField_a_of_type_JavaLangString;
    if (paramBoolean1) {}
    for (paramInt = j;; paramInt = 1)
    {
      agvs.a(str, 1, paramInt, (Map)localObject2, true);
      a(paramAppInterface, (String)localObject1);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = agwj.a();
    if (localObject == null) {
      return false;
    }
    localObject = (PreloadManager)((QQAppInterface)localObject).getManager(151);
    if (localObject != null)
    {
      localObject = ((PreloadManager)localObject).a("2020_red_packet");
      if (localObject != null)
      {
        Iterator localIterator = ((PreloadModule)localObject).getResList().iterator();
        while (localIterator.hasNext()) {
          if (TextUtils.equals(((PreloadResource)localIterator.next()).getResDownloadUrl((PreloadModule)localObject), paramString)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (baip.a(paramString1)) {
      return bool2;
    }
    paramString1 = paramString1.split("\\|");
    int j = paramString1.length;
    int i = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      if (paramString1[i].equals(paramString2)) {
        bool1 = true;
      }
      i += 1;
    }
  }
  
  @NonNull
  private static agvo b(AppRuntime paramAppRuntime)
  {
    agvo localagvo = new agvo(null);
    Object localObject = "";
    int k = 0;
    int m = -1;
    int j;
    int i;
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      localObject = (agtd)((QQAppInterface)paramAppRuntime).getManager(343);
      if (localObject == null) {
        break label232;
      }
      if (((agtd)localObject).a() != null)
      {
        paramAppRuntime = ((agtd)localObject).a().bids;
        j = ((agtd)localObject).a();
        i = ((agtd)localObject).b();
      }
    }
    for (;;)
    {
      localObject = paramAppRuntime;
      for (;;)
      {
        localagvo.jdField_a_of_type_JavaLangString = ((String)localObject);
        localagvo.b = i;
        localagvo.jdField_a_of_type_Int = j;
        return localagvo;
        paramAppRuntime = "";
        break;
        EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetHtmlOffline", null);
        paramAppRuntime = (AppRuntime)localObject;
        if (localEIPCResult != null)
        {
          paramAppRuntime = (AppRuntime)localObject;
          if (localEIPCResult.data != null) {
            paramAppRuntime = localEIPCResult.data.getString("bids");
          }
        }
        localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetcfgInfo", null);
        i = m;
        j = k;
        localObject = paramAppRuntime;
        if (localEIPCResult != null)
        {
          i = m;
          j = k;
          localObject = paramAppRuntime;
          if (localEIPCResult.data != null)
          {
            j = localEIPCResult.data.getInt("task_id");
            i = localEIPCResult.data.getInt("cfg_version");
            localObject = paramAppRuntime;
          }
        }
      }
      label232:
      i = -1;
      j = 0;
      paramAppRuntime = "";
    }
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "offline_cover_tag" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String b(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "offline_report_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramString);
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getOfflineTagFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String b(boolean paramBoolean, String paramString)
  {
    return String.format("%s_%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
  }
  
  private static void b(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "offline_cover_tag" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  private static void b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      c(paramAppInterface, "offline_report_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramString2, paramString1);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "saveOfflineTagToSP fail.", paramAppInterface);
    }
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
  }
  
  private static int c(int paramInt)
  {
    QQAppInterface localQQAppInterface = agwj.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    return alzw.a().a(paramInt, localQQAppInterface.getCurrentAccountUin());
  }
  
  private static String c(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "adcode_exception_tag" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String c(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramAppInterface = paramAppInterface.getApp().getSharedPreferences("spring_hb_report", 0).getString(paramString, "");
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getValueFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static void c(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "adcode_exception_tag" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  private static void c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      paramAppInterface.getApp().getSharedPreferences("spring_hb_report", 0).edit().putString(paramString1, paramString2).apply();
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[saveValueToSP] fail.", paramAppInterface);
    }
  }
  
  private static String d(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "cfg_cover_tag" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static void d(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "cfg_cover_tag" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("springHb_report_SpringHbMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agvn
 * JD-Core Version:    0.7.0.1
 */