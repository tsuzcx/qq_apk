import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.Foreground;

public class ajzo
  implements Handler.Callback
{
  public static int a;
  private static ajzo jdField_a_of_type_Ajzo;
  public static ArrayList<String> a;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Vector<ajzp> jdField_a_of_type_JavaUtilVector;
  public boolean a;
  private long b = System.currentTimeMillis();
  private long c;
  private long d;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private ajzo()
  {
    float f1 = ajlz.a().b;
    float f2 = ajlz.a().c;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("memory_reporter", 0);
    if (localSharedPreferences.contains("sp_key_last_shot_time")) {
      localSharedPreferences.edit().clear().commit();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(a(), 0);
    this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_key_last_shot_time", 0L);
    if (Math.abs(System.currentTimeMillis() - this.d) >= 86400000L)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_report", false)) {
        e();
      }
      if (f1 >= Math.random())
      {
        a();
        this.jdField_a_of_type_Boolean = true;
        this.d = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_key_last_shot_time", this.d).putBoolean("key_need_report", true).commit();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_a_of_type_JavaUtilVector = new Vector();
      a(xfz.a());
      return;
      a();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static ajzo a()
  {
    if (jdField_a_of_type_Ajzo == null) {}
    try
    {
      if (jdField_a_of_type_Ajzo == null) {
        jdField_a_of_type_Ajzo = new ajzo();
      }
      return jdField_a_of_type_Ajzo;
    }
    finally {}
  }
  
  private String a()
  {
    return "memory_reporter_" + BaseApplicationImpl.sProcessId;
  }
  
  static void a()
  {
    if (QLog.getUIN_REPORTLOG_LEVEL() < 2) {
      QLog.setUIN_REPORTLOG_LEVEL(2);
    }
  }
  
  private void a(int paramInt, xfw paramxfw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext()) {
        ((ajzp)localIterator.next()).a(paramInt, paramxfw);
      }
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext()) {
        ((ajzp)localIterator.next()).a(paramLong);
      }
    }
  }
  
  private void d()
  {
    long l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l2 = (100 - ajlz.a().jdField_a_of_type_Int) * Runtime.getRuntime().maxMemory() / 100L;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump  calculateSharpMemory heapSize= ", Long.valueOf(l1) });
    }
    if ((jdField_a_of_type_Int != 0) || (l1 > l2))
    {
      a(l1);
      if (this.jdField_a_of_type_Boolean)
      {
        InitMagnifierSDK.a(this.jdField_a_of_type_AndroidOsHandler, l1);
        if ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_report", false)) && (l1 > this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_use_heap", 0L)) && (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) > 120000L))
        {
          localObject = UnifiedMonitor.a();
          if (localObject == null) {
            break label294;
          }
        }
      }
    }
    label294:
    for (Object localObject = (String)((HashMap)localObject).get("act");; localObject = null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_use_heap", l1).putString("key_act_name", (String)localObject).putBoolean("key_clear_flag", ajlz.a().jdField_a_of_type_Xfv.jdField_a_of_type_Boolean).commit();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Boolean) && (System.currentTimeMillis() - this.c > 86400000L))
      {
        f();
        if (QLog.isColorLevel()) {
          QLog.d("MemoryReporter", 2, "login over 24 hours, report again");
        }
      }
      if ((this.jdField_a_of_type_Boolean) && (System.currentTimeMillis() - this.d > 86400000L)) {
        e();
      }
      return;
    }
  }
  
  private void e()
  {
    if (("0".equals(AppSetting.g())) || (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_report", false))) {
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_act_name", "");
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_clear_flag", false);
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_use_heap", -1L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_threshold", -1L);
    long l1 = l2;
    if (l2 == -1L)
    {
      l1 = babp.d();
      localEditor.putLong("key_threshold", l1);
    }
    l2 = this.d;
    long l4 = this.d;
    long l5 = Runtime.getRuntime().maxMemory();
    int i;
    if (l3 != -1L)
    {
      i = 1;
      if (!bool) {
        break label239;
      }
    }
    label239:
    for (int j = 1;; j = 0)
    {
      InitMagnifierSDK.a(l2, l4 + 86400000L, str, l3, l5, l1, -1L, i, j);
      localEditor.remove("key_use_heap").remove("key_act_name").remove("key_clear_flag").remove("key_need_report").commit();
      return;
      i = 0;
      break;
    }
  }
  
  private void f()
  {
    StringBuffer localStringBuffer = new StringBuffer(512);
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      ajjj localajjj = (ajjj)((QQAppInterface)localObject).getManager(51);
      int i;
      if (localajjj != null)
      {
        i = localajjj.a();
        localStringBuffer.append("fc=");
        localStringBuffer.append(i);
        localStringBuffer.append("&");
      }
      localObject = (ajhh)((QQAppInterface)localObject).getManager(53);
      if (localObject != null)
      {
        i = ((ajhh)localObject).a().size();
        localStringBuffer.append("dc=");
        localStringBuffer.append(i);
        localStringBuffer.append("&");
        i = ((ajhh)localObject).b();
        localStringBuffer.append("dmc=");
        localStringBuffer.append(i);
        localStringBuffer.append("&");
      }
    }
    InitMagnifierSDK.a(this.jdField_a_of_type_AndroidOsHandler, -1L, -1L, "-1", localStringBuffer.toString());
    this.c = System.currentTimeMillis();
  }
  
  public void a(ajzp paramajzp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramajzp);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, xfv paramxfv, int paramInt)
  {
    xfw localxfw = paramxfv.a(paramInt);
    if ((localxfw != null) && (paramLong1 >= localxfw.jdField_a_of_type_Int * paramLong2 / 100L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryReporter", 2, "onNeedTrimMemory|maxHeap=" + paramLong2 / 1024L / 1024L + ",totalSize=" + paramLong1 / 1024L / 84L);
      }
      paramxfv.jdField_a_of_type_Int = localxfw.b;
      a(paramInt, localxfw);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
    c();
  }
  
  public void b(ajzp paramajzp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(paramajzp);
      return;
    }
  }
  
  public void c()
  {
    if (ajlz.a().jdField_a_of_type_Xfv.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
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
    d();
    xfz.a().a(bool);
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
    paramMessage = ajlz.a().jdField_a_of_type_Xfv;
    xfz.a().c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzo
 * JD-Core Version:    0.7.0.1
 */