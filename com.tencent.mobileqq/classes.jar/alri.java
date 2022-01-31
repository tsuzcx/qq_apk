import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqMessageQueue;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class alri
{
  public static int a;
  private static AbstractUnifiedMonitor.ThreadMonitorCallback a;
  
  static
  {
    jdField_a_of_type_Int = 100;
    jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = new alrj();
  }
  
  public static void a()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(0)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(0);
    UnifiedMonitor.a().setMonitoredThread(0, Looper.getMainLooper().getThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    alrk localalrk = new alrk(0);
    localalrk.a(i, false);
    Looper.getMainLooper().setMessageLogging(localalrk);
    MqqMessageQueue.getSubMainThreadQueue().setMessageLogging(localalrk);
  }
  
  public static void b()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(14)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(14);
    UnifiedMonitor.a().setMonitoredThread(14, Looper.getMainLooper().getThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    alrk localalrk = new alrk(14);
    localalrk.a(i, false);
    Looper.getMainLooper().setMessageLogging(localalrk);
  }
  
  public static void c()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(4)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(4);
    UnifiedMonitor.a().setMonitoredThread(4, ThreadManager.getSubThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    alyx localalyx = new alyx(4, "SubLooper");
    localalyx.a(i, false);
    ThreadManager.getSubThreadLooper().setMessageLogging(localalyx);
  }
  
  public static void d()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(18)) {
      return;
    }
    Object localObject1 = MsfCore.sCore;
    if (localObject1 == null)
    {
      QLog.e("MagnifierSDK_QAPM", 1, "msf core hasnot init");
      return;
    }
    Object localObject2 = ((MsfCore)localObject1).getNetworkHandlerThread();
    if (localObject2 == null)
    {
      QLog.e("MagnifierSDK_QAPM", 1, "network thread hasnot init");
      return;
    }
    localObject1 = ((HandlerThread)localObject2).getLooper();
    if (localObject1 == null)
    {
      QLog.e("MagnifierSDK_QAPM", 1, "network thread has not start");
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(18);
    UnifiedMonitor.a().setMonitoredThread(18, (Thread)localObject2, jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    localObject2 = new alyx(18, "msf-network");
    ((alyx)localObject2).a(i, false);
    ((Looper)localObject1).setMessageLogging((Printer)localObject2);
  }
  
  public static void e()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(13)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(13);
    UnifiedMonitor.a().setMonitoredThread(13, ThreadManager.getRecentThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    alyx localalyx = new alyx(13, "RecentLooper");
    localalyx.a(i, false);
    ThreadManager.getRecentThreadLooper().setMessageLogging(localalyx);
  }
  
  public static void f()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(5)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(5);
    UnifiedMonitor.a().setMonitoredThread(5, ThreadManager.getFileThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    alyx localalyx = new alyx(5, "FileLooper");
    localalyx.a(i, false);
    ThreadManager.getFileThreadLooper().setMessageLogging(localalyx);
  }
  
  public static void g()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(6))
    {
      com.tencent.mobileqq.app.ThreadExcutor.sLooperMonitorSwitch = false;
      return;
    }
    com.tencent.mobileqq.app.ThreadExcutor.sLooperMonitorSwitch = true;
    com.tencent.mobileqq.app.ThreadExcutor.sThreshTime = UnifiedMonitor.a().getThreshold(6);
  }
  
  public static void h()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(19)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(19);
    UnifiedMonitor.a().setMonitoredThread(19, Looper.getMainLooper().getThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    alrk localalrk = new alrk(19);
    localalrk.a(i, false);
    Looper.getMainLooper().setMessageLogging(localalrk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alri
 * JD-Core Version:    0.7.0.1
 */