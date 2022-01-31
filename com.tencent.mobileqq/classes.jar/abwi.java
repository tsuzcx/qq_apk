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

public class abwi
  implements Handler.Callback
{
  private static abwi jdField_a_of_type_Abwi;
  public Handler a;
  public ArrayList<abwh> a;
  
  static
  {
    if (!abwi.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private abwi()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getMonitorThreadLooper(), this);
  }
  
  public static abwi a()
  {
    if (jdField_a_of_type_Abwi == null) {}
    try
    {
      if (jdField_a_of_type_Abwi == null) {
        jdField_a_of_type_Abwi = new abwi();
      }
      return jdField_a_of_type_Abwi;
    }
    finally {}
  }
  
  private void a(abwh paramabwh, long paramLong)
  {
    if (paramabwh.a())
    {
      double d = 100.0D * paramabwh.jdField_a_of_type_Double;
      if (QLog.isColorLevel()) {
        QLog.i("reportToDenta", 2, "reportToDenta" + paramabwh.jdField_a_of_type_JavaLangString + " " + d + " mem " + paramabwh.jdField_a_of_type_Long);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuUsage", String.valueOf(d));
      localHashMap.put("memory", String.valueOf(paramabwh.jdField_a_of_type_Long));
      localHashMap.put("scene", String.valueOf(paramabwh.jdField_a_of_type_JavaLangString));
      localHashMap.put("duration", String.valueOf(paramLong));
      azri.a(BaseApplicationImpl.getContext()).a("", "actScenePerf", true, 0L, 0L, localHashMap, "");
    }
  }
  
  public abwh a(String paramString)
  {
    abwh localabwh2 = b(paramString);
    abwh localabwh1 = localabwh2;
    if (localabwh2 == null)
    {
      localabwh1 = new abwh();
      localabwh1.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localabwh1);
    }
    return localabwh1;
  }
  
  public void a()
  {
    if ((abwd.jdField_a_of_type_JavaUtilVector.size() > 0) || (abwd.b.size() > 0))
    {
      SceneReportRunnable localSceneReportRunnable = SceneReportRunnable.a(BaseApplicationImpl.processName);
      azrd.a().jdField_a_of_type_AndroidOsHandler.post(localSceneReportRunnable);
    }
  }
  
  public void a(String paramString)
  {
    if (!UnifiedMonitor.a().a()) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramString).sendToTarget();
  }
  
  public abwh b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      abwh localabwh = (abwh)localIterator.next();
      if (TextUtils.equals(localabwh.jdField_a_of_type_JavaLangString, paramString)) {
        return localabwh;
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
            abwd.a().jdField_a_of_type_JavaLangString = paramMessage;
            localObject1 = abwd.a().a();
          } while (localObject1 == null);
          localObject2 = b(paramMessage);
          if ((!jdField_a_of_type_Boolean) && (localObject2 != null)) {
            throw new AssertionError();
          }
          localObject2 = a(paramMessage);
          l1 = System.currentTimeMillis();
          localabwl1 = new abwl();
          localabwl1.jdField_a_of_type_Double = ((abwg)localObject1).jdField_a_of_type_Long;
          localabwl1.jdField_b_of_type_Long = ((abwg)localObject1).f;
          localabwl1.jdField_a_of_type_JavaLangString = paramMessage;
          localabwl1.jdField_a_of_type_Long = l1;
          localabwl1.jdField_a_of_type_Int = 0;
          ((abwh)localObject2).jdField_a_of_type_Abwl = localabwl1;
          abwd.b.add(localabwl1);
          ((abwh)localObject2).a((abwg)localObject1);
          return false;
          paramMessage = (String)paramMessage.obj;
          if (MagnifierSDK.a())
          {
            QAPM.endScene(paramMessage, QAPM.ModeResource);
            return false;
          }
          localObject1 = b(paramMessage);
        } while (localObject1 == null);
        localObject2 = abwd.a().a();
      } while (localObject2 == null);
      abwl localabwl1 = ((abwh)localObject1).jdField_a_of_type_Abwl;
      abwl localabwl2 = new abwl();
      localabwl2.jdField_a_of_type_JavaLangString = paramMessage;
      localabwl2.jdField_a_of_type_Double = ((abwg)localObject2).jdField_a_of_type_Long;
      localabwl2.jdField_b_of_type_Long = ((abwg)localObject2).f;
      localabwl2.jdField_b_of_type_Double = ((localabwl2.jdField_a_of_type_Double - localabwl1.jdField_a_of_type_Double) * 1000.0D);
      long l1 = localabwl2.jdField_b_of_type_Long;
      long l2 = localabwl1.jdField_b_of_type_Long;
      localabwl2.jdField_a_of_type_Long = localabwl1.jdField_a_of_type_Long;
      localabwl2.jdField_a_of_type_Int = 1;
      abwd.b.add(localabwl2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
      ((abwh)localObject1).a((abwg)localObject2);
      a();
      a((abwh)localObject1, l1 - l2);
      return false;
    }
    paramMessage = abwd.a().a();
    if (paramMessage != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((abwh)((Iterator)localObject1).next()).a(paramMessage);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 5000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwi
 * JD-Core Version:    0.7.0.1
 */