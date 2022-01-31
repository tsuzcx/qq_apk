import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.scenetracker.SceneReportRunnable;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class abrt
  implements Handler.Callback
{
  private static abrt jdField_a_of_type_Abrt;
  public Handler a;
  public ArrayList<abrs> a;
  
  static
  {
    if (!abrt.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private abrt()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getMonitorThreadLooper(), this);
  }
  
  public static abrt a()
  {
    if (jdField_a_of_type_Abrt == null) {}
    try
    {
      if (jdField_a_of_type_Abrt == null) {
        jdField_a_of_type_Abrt = new abrt();
      }
      return jdField_a_of_type_Abrt;
    }
    finally {}
  }
  
  private void a(abrs paramabrs, long paramLong)
  {
    if (paramabrs.a())
    {
      double d = 100.0D * paramabrs.jdField_a_of_type_Double;
      if (QLog.isColorLevel()) {
        QLog.i("reportToDenta", 2, "reportToDenta" + paramabrs.jdField_a_of_type_JavaLangString + " " + d + " mem " + paramabrs.jdField_a_of_type_Long);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuUsage", String.valueOf(d));
      localHashMap.put("memory", String.valueOf(paramabrs.jdField_a_of_type_Long));
      localHashMap.put("scene", String.valueOf(paramabrs.jdField_a_of_type_JavaLangString));
      localHashMap.put("duration", String.valueOf(paramLong));
      azmz.a(BaseApplicationImpl.getContext()).a("", "actScenePerf", true, 0L, 0L, localHashMap, "");
    }
  }
  
  public abrs a(String paramString)
  {
    abrs localabrs2 = b(paramString);
    abrs localabrs1 = localabrs2;
    if (localabrs2 == null)
    {
      localabrs1 = new abrs();
      localabrs1.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localabrs1);
    }
    return localabrs1;
  }
  
  public void a()
  {
    if ((abro.jdField_a_of_type_JavaUtilVector.size() > 0) || (abro.b.size() > 0))
    {
      SceneReportRunnable localSceneReportRunnable = SceneReportRunnable.a(BaseApplicationImpl.processName);
      azmu.a().jdField_a_of_type_AndroidOsHandler.post(localSceneReportRunnable);
    }
  }
  
  public void a(String paramString)
  {
    if (!UnifiedMonitor.a().a()) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramString).sendToTarget();
  }
  
  public abrs b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      abrs localabrs = (abrs)localIterator.next();
      if (TextUtils.equals(localabrs.jdField_a_of_type_JavaLangString, paramString)) {
        return localabrs;
      }
    }
    return null;
  }
  
  public void b(String paramString)
  {
    if (!UnifiedMonitor.a().a()) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramString).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return false;
            paramMessage = (String)paramMessage.obj;
            if (MagnifierSDK.a())
            {
              QAPM.beginScene(paramMessage, QAPM.ModeResource);
              return false;
            }
            abro.a().jdField_a_of_type_JavaLangString = paramMessage;
            localObject1 = abro.a().a();
          } while (localObject1 == null);
          localObject2 = b(paramMessage);
          if ((!jdField_a_of_type_Boolean) && (localObject2 != null)) {
            throw new AssertionError();
          }
          localObject2 = a(paramMessage);
          l1 = System.currentTimeMillis();
          localabrw1 = new abrw();
          localabrw1.jdField_a_of_type_Double = ((abrr)localObject1).jdField_a_of_type_Long;
          localabrw1.jdField_b_of_type_Long = ((abrr)localObject1).f;
          localabrw1.jdField_a_of_type_JavaLangString = paramMessage;
          localabrw1.jdField_a_of_type_Long = l1;
          localabrw1.jdField_a_of_type_Int = 0;
          ((abrs)localObject2).jdField_a_of_type_Abrw = localabrw1;
          abro.b.add(localabrw1);
          ((abrs)localObject2).a((abrr)localObject1);
          return false;
          paramMessage = (String)paramMessage.obj;
          if (MagnifierSDK.a())
          {
            QAPM.endScene(paramMessage, QAPM.ModeResource);
            return false;
          }
          localObject1 = b(paramMessage);
        } while (localObject1 == null);
        localObject2 = abro.a().a();
      } while (localObject2 == null);
      abrw localabrw1 = ((abrs)localObject1).jdField_a_of_type_Abrw;
      abrw localabrw2 = new abrw();
      localabrw2.jdField_a_of_type_JavaLangString = paramMessage;
      localabrw2.jdField_a_of_type_Double = ((abrr)localObject2).jdField_a_of_type_Long;
      localabrw2.jdField_b_of_type_Long = ((abrr)localObject2).f;
      localabrw2.jdField_b_of_type_Double = ((localabrw2.jdField_a_of_type_Double - localabrw1.jdField_a_of_type_Double) * 1000.0D);
      long l1 = localabrw2.jdField_b_of_type_Long;
      long l2 = localabrw1.jdField_b_of_type_Long;
      localabrw2.jdField_a_of_type_Long = localabrw1.jdField_a_of_type_Long;
      localabrw2.jdField_a_of_type_Int = 1;
      abro.b.add(localabrw2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
      ((abrs)localObject1).a((abrr)localObject2);
      a();
      a((abrs)localObject1, l1 - l2);
      return false;
    }
    paramMessage = abro.a().a();
    if (paramMessage != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((abrs)((Iterator)localObject1).next()).a(paramMessage);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 5000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrt
 * JD-Core Version:    0.7.0.1
 */