import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqMessageQueue;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class ajzu
{
  public static int a;
  private static AbstractUnifiedMonitor.ThreadMonitorCallback a;
  
  static
  {
    jdField_a_of_type_Int = 100;
    jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = new ajzv();
  }
  
  public static void a()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(0)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(0);
    UnifiedMonitor.a().setMonitoredThread(0, Looper.getMainLooper().getThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    ajzw localajzw = new ajzw(0);
    localajzw.a(i, false);
    Looper.getMainLooper().setMessageLogging(localajzw);
    MqqMessageQueue.getSubMainThreadQueue().setMessageLogging(localajzw);
  }
  
  public static void b()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(14)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(14);
    UnifiedMonitor.a().setMonitoredThread(14, Looper.getMainLooper().getThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    ajzw localajzw = new ajzw(14);
    localajzw.a(i, false);
    Looper.getMainLooper().setMessageLogging(localajzw);
  }
  
  public static void c()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(4)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(4);
    UnifiedMonitor.a().setMonitoredThread(4, ThreadManager.getSubThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    akhh localakhh = new akhh(4, "SubLooper");
    localakhh.a(i, false);
    ThreadManager.getSubThreadLooper().setMessageLogging(localakhh);
  }
  
  public static void d()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(18)) {
      return;
    }
    Object localObject1 = MsfCore.sCore;
    if (localObject1 == null)
    {
      QLog.e("AutoMonitor", 1, "msf core hasnot init");
      return;
    }
    Object localObject2 = ((MsfCore)localObject1).getNetworkHandlerThread();
    if (localObject2 == null)
    {
      QLog.e("AutoMonitor", 1, "network thread hasnot init");
      return;
    }
    localObject1 = ((HandlerThread)localObject2).getLooper();
    if (localObject1 == null)
    {
      QLog.e("AutoMonitor", 1, "network thread has not start");
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(18);
    UnifiedMonitor.a().setMonitoredThread(18, (Thread)localObject2, jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    localObject2 = new akhh(18, "msf-network");
    ((akhh)localObject2).a(i, false);
    ((Looper)localObject1).setMessageLogging((Printer)localObject2);
  }
  
  public static void e()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(13)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(13);
    UnifiedMonitor.a().setMonitoredThread(13, ThreadManager.getRecentThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    akhh localakhh = new akhh(13, "RecentLooper");
    localakhh.a(i, false);
    ThreadManager.getRecentThreadLooper().setMessageLogging(localakhh);
  }
  
  public static void f()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(5)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(5);
    UnifiedMonitor.a().setMonitoredThread(5, ThreadManager.getFileThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    akhh localakhh = new akhh(5, "FileLooper");
    localakhh.a(i, false);
    ThreadManager.getFileThreadLooper().setMessageLogging(localakhh);
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
    ajzw localajzw = new ajzw(19);
    localajzw.a(i, false);
    Looper.getMainLooper().setMessageLogging(localajzw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzu
 * JD-Core Version:    0.7.0.1
 */