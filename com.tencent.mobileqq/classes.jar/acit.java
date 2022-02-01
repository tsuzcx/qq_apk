import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.Foreground;

public class acit
  implements Handler.Callback
{
  public static int a;
  private static acit jdField_a_of_type_Acit;
  public static ArrayList<String> a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Vector<acho> jdField_a_of_type_JavaUtilVector = new Vector();
  public boolean a;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private acit()
  {
    this.jdField_a_of_type_Boolean = MagnifierSDK.a().a().b();
    a(aafp.a());
  }
  
  public static acit a()
  {
    if (jdField_a_of_type_Acit == null) {}
    try
    {
      if (jdField_a_of_type_Acit == null) {
        jdField_a_of_type_Acit = new acit();
      }
      return jdField_a_of_type_Acit;
    }
    finally {}
  }
  
  private void a(int paramInt, aafm paramaafm)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext()) {
        ((acho)localIterator.next()).a(paramInt, paramaafm);
      }
    }
  }
  
  private void c()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    long l3 = (100 - MagnifierSDK.a().a().jdField_a_of_type_Int) * Runtime.getRuntime().maxMemory() / 100L;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump  calculateSharpMemory heapSize= ", Long.valueOf(l1 - l2) });
    }
    if (jdField_a_of_type_Int == 0) {}
  }
  
  public void a()
  {
    if (MagnifierSDK.a().a().jdField_a_of_type_Aafl.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext()) {
        ((acho)localIterator.next()).a(paramLong);
      }
    }
  }
  
  public void a(acho paramacho)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramacho);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, aafl paramaafl, int paramInt)
  {
    aafm localaafm = paramaafl.a(paramInt);
    if ((localaafm != null) && (paramLong1 >= localaafm.jdField_a_of_type_Int * paramLong2 / 100L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryReporter", 2, "onNeedTrimMemory|maxHeap=" + paramLong2 / 1024L / 1024L + ",totalSize=" + paramLong1 / 1024L / 84L);
      }
      paramaafl.jdField_a_of_type_Int = localaafm.b;
      a(paramInt, localaafm);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    jdField_a_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump setDumpReported = ", Integer.valueOf(jdField_a_of_type_Int) });
    }
  }
  
  public void b(acho paramacho)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(paramacho);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (Foreground.sCountResume > 0) {}
    for (boolean bool = true;; bool = false) {
      switch (paramMessage.what)
      {
      default: 
        return true;
      }
    }
    c();
    aafp.a().a(bool);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramMessage = this.jdField_a_of_type_AndroidOsHandler;
    if (bool) {}
    for (long l1 = 5000L;; l1 = 30000L)
    {
      paramMessage.sendEmptyMessageDelayed(1, l1);
      break;
    }
    l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().maxMemory();
    paramMessage = MagnifierSDK.a().a().jdField_a_of_type_Aafl;
    aafp.a().b();
    int i;
    if (a(l1, l2, paramMessage, 1)) {
      i = paramMessage.jdField_a_of_type_Int * 1000;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      int j = i;
      if (!bool)
      {
        j = i;
        if (i >= 30000) {
          j = i * 2;
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, j);
      break;
      if (a(l1, l2, paramMessage, 2)) {
        i = paramMessage.jdField_a_of_type_Int * 1000;
      } else if (a(l1, l2, paramMessage, 3)) {
        i = paramMessage.jdField_a_of_type_Int * 1000;
      } else {
        i = 30000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acit
 * JD-Core Version:    0.7.0.1
 */