import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.scenetracker.SceneReportRunnable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class aaaw
  implements Handler.Callback
{
  private static aaaw jdField_a_of_type_Aaaw;
  public Handler a;
  public ArrayList<aaav> a;
  
  static
  {
    if (!aaaw.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private aaaw()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  }
  
  public static aaaw a()
  {
    if (jdField_a_of_type_Aaaw == null) {}
    try
    {
      if (jdField_a_of_type_Aaaw == null) {
        jdField_a_of_type_Aaaw = new aaaw();
      }
      return jdField_a_of_type_Aaaw;
    }
    finally {}
  }
  
  private void a(aaav paramaaav, long paramLong)
  {
    if (paramaaav.a())
    {
      double d = 100.0D * paramaaav.jdField_a_of_type_Double;
      if (QLog.isColorLevel()) {
        QLog.i("reportToDenta", 2, "reportToDenta" + paramaaav.jdField_a_of_type_JavaLangString + " " + d + " mem " + paramaaav.jdField_a_of_type_Long);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuUsage", String.valueOf(d));
      localHashMap.put("memory", String.valueOf(paramaaav.jdField_a_of_type_Long));
      localHashMap.put("scene", String.valueOf(paramaaav.jdField_a_of_type_JavaLangString));
      localHashMap.put("duration", String.valueOf(paramLong));
      axrn.a(BaseApplicationImpl.getContext()).a("", "actScenePerf", true, 0L, 0L, localHashMap, "");
    }
  }
  
  public aaav a(String paramString)
  {
    aaav localaaav2 = b(paramString);
    aaav localaaav1 = localaaav2;
    if (localaaav2 == null)
    {
      localaaav1 = new aaav();
      localaaav1.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaaav1);
    }
    return localaaav1;
  }
  
  public void a()
  {
    if ((aaar.jdField_a_of_type_JavaUtilVector.size() > 0) || (aaar.b.size() > 0))
    {
      SceneReportRunnable localSceneReportRunnable = SceneReportRunnable.a(BaseApplicationImpl.processName);
      axri.a().jdField_a_of_type_AndroidOsHandler.post(localSceneReportRunnable);
    }
  }
  
  public void a(String paramString)
  {
    if (!UnifiedMonitor.a().a()) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramString).sendToTarget();
  }
  
  public aaav b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aaav localaaav = (aaav)localIterator.next();
      if (TextUtils.equals(localaaav.jdField_a_of_type_JavaLangString, paramString)) {
        return localaaav;
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
            aaar.a().jdField_a_of_type_JavaLangString = paramMessage;
            localObject1 = aaar.a().a();
          } while (localObject1 == null);
          localObject2 = b(paramMessage);
          if ((!jdField_a_of_type_Boolean) && (localObject2 != null)) {
            throw new AssertionError();
          }
          localObject2 = a(paramMessage);
          l1 = System.currentTimeMillis();
          localaaaz1 = new aaaz();
          localaaaz1.jdField_a_of_type_Double = ((aaau)localObject1).jdField_a_of_type_Long;
          localaaaz1.jdField_b_of_type_Long = ((aaau)localObject1).f;
          localaaaz1.jdField_a_of_type_JavaLangString = paramMessage;
          localaaaz1.jdField_a_of_type_Long = l1;
          localaaaz1.jdField_a_of_type_Int = 0;
          ((aaav)localObject2).jdField_a_of_type_Aaaz = localaaaz1;
          aaar.b.add(localaaaz1);
          ((aaav)localObject2).a((aaau)localObject1);
          return false;
          paramMessage = (String)paramMessage.obj;
          localObject1 = b(paramMessage);
        } while (localObject1 == null);
        localObject2 = aaar.a().a();
      } while (localObject2 == null);
      aaaz localaaaz1 = ((aaav)localObject1).jdField_a_of_type_Aaaz;
      aaaz localaaaz2 = new aaaz();
      localaaaz2.jdField_a_of_type_JavaLangString = paramMessage;
      localaaaz2.jdField_a_of_type_Double = ((aaau)localObject2).jdField_a_of_type_Long;
      localaaaz2.jdField_b_of_type_Long = ((aaau)localObject2).f;
      localaaaz2.jdField_b_of_type_Double = ((localaaaz2.jdField_a_of_type_Double - localaaaz1.jdField_a_of_type_Double) * 1000.0D);
      long l1 = localaaaz2.jdField_b_of_type_Long;
      long l2 = localaaaz1.jdField_b_of_type_Long;
      localaaaz2.jdField_a_of_type_Long = localaaaz1.jdField_a_of_type_Long;
      localaaaz2.jdField_a_of_type_Int = 1;
      aaar.b.add(localaaaz2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
      ((aaav)localObject1).a((aaau)localObject2);
      a();
      a((aaav)localObject1, l1 - l2);
      return false;
    }
    paramMessage = aaar.a().a();
    if (paramMessage != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((aaav)((Iterator)localObject1).next()).a(paramMessage);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 5000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaw
 * JD-Core Version:    0.7.0.1
 */