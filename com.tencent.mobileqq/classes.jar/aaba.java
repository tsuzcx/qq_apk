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

public class aaba
  implements Handler.Callback
{
  private static aaba jdField_a_of_type_Aaba;
  public Handler a;
  public ArrayList<aaaz> a;
  
  static
  {
    if (!aaba.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private aaba()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  }
  
  public static aaba a()
  {
    if (jdField_a_of_type_Aaba == null) {}
    try
    {
      if (jdField_a_of_type_Aaba == null) {
        jdField_a_of_type_Aaba = new aaba();
      }
      return jdField_a_of_type_Aaba;
    }
    finally {}
  }
  
  private void a(aaaz paramaaaz, long paramLong)
  {
    if (paramaaaz.a())
    {
      double d = 100.0D * paramaaaz.jdField_a_of_type_Double;
      if (QLog.isColorLevel()) {
        QLog.i("reportToDenta", 2, "reportToDenta" + paramaaaz.jdField_a_of_type_JavaLangString + " " + d + " mem " + paramaaaz.jdField_a_of_type_Long);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuUsage", String.valueOf(d));
      localHashMap.put("memory", String.valueOf(paramaaaz.jdField_a_of_type_Long));
      localHashMap.put("scene", String.valueOf(paramaaaz.jdField_a_of_type_JavaLangString));
      localHashMap.put("duration", String.valueOf(paramLong));
      axrl.a(BaseApplicationImpl.getContext()).a("", "actScenePerf", true, 0L, 0L, localHashMap, "");
    }
  }
  
  public aaaz a(String paramString)
  {
    aaaz localaaaz2 = b(paramString);
    aaaz localaaaz1 = localaaaz2;
    if (localaaaz2 == null)
    {
      localaaaz1 = new aaaz();
      localaaaz1.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaaaz1);
    }
    return localaaaz1;
  }
  
  public void a()
  {
    if ((aaav.jdField_a_of_type_JavaUtilVector.size() > 0) || (aaav.b.size() > 0))
    {
      SceneReportRunnable localSceneReportRunnable = SceneReportRunnable.a(BaseApplicationImpl.processName);
      axrg.a().jdField_a_of_type_AndroidOsHandler.post(localSceneReportRunnable);
    }
  }
  
  public void a(String paramString)
  {
    if (!UnifiedMonitor.a().a()) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramString).sendToTarget();
  }
  
  public aaaz b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aaaz localaaaz = (aaaz)localIterator.next();
      if (TextUtils.equals(localaaaz.jdField_a_of_type_JavaLangString, paramString)) {
        return localaaaz;
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
            aaav.a().jdField_a_of_type_JavaLangString = paramMessage;
            localObject1 = aaav.a().a();
          } while (localObject1 == null);
          localObject2 = b(paramMessage);
          if ((!jdField_a_of_type_Boolean) && (localObject2 != null)) {
            throw new AssertionError();
          }
          localObject2 = a(paramMessage);
          l1 = System.currentTimeMillis();
          localaabd1 = new aabd();
          localaabd1.jdField_a_of_type_Double = ((aaay)localObject1).jdField_a_of_type_Long;
          localaabd1.jdField_b_of_type_Long = ((aaay)localObject1).f;
          localaabd1.jdField_a_of_type_JavaLangString = paramMessage;
          localaabd1.jdField_a_of_type_Long = l1;
          localaabd1.jdField_a_of_type_Int = 0;
          ((aaaz)localObject2).jdField_a_of_type_Aabd = localaabd1;
          aaav.b.add(localaabd1);
          ((aaaz)localObject2).a((aaay)localObject1);
          return false;
          paramMessage = (String)paramMessage.obj;
          localObject1 = b(paramMessage);
        } while (localObject1 == null);
        localObject2 = aaav.a().a();
      } while (localObject2 == null);
      aabd localaabd1 = ((aaaz)localObject1).jdField_a_of_type_Aabd;
      aabd localaabd2 = new aabd();
      localaabd2.jdField_a_of_type_JavaLangString = paramMessage;
      localaabd2.jdField_a_of_type_Double = ((aaay)localObject2).jdField_a_of_type_Long;
      localaabd2.jdField_b_of_type_Long = ((aaay)localObject2).f;
      localaabd2.jdField_b_of_type_Double = ((localaabd2.jdField_a_of_type_Double - localaabd1.jdField_a_of_type_Double) * 1000.0D);
      long l1 = localaabd2.jdField_b_of_type_Long;
      long l2 = localaabd1.jdField_b_of_type_Long;
      localaabd2.jdField_a_of_type_Long = localaabd1.jdField_a_of_type_Long;
      localaabd2.jdField_a_of_type_Int = 1;
      aaav.b.add(localaabd2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
      ((aaaz)localObject1).a((aaay)localObject2);
      a();
      a((aaaz)localObject1, l1 - l2);
      return false;
    }
    paramMessage = aaav.a().a();
    if (paramMessage != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((aaaz)((Iterator)localObject1).next()).a(paramMessage);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 5000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaba
 * JD-Core Version:    0.7.0.1
 */