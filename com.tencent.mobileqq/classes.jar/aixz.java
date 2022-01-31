import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class aixz
  implements aiyd
{
  public QQAppInterface a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        return (QQAppInterface)localAppRuntime;
      }
    }
    return null;
  }
  
  public List<TraceData> a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return null;
    }
    return localQQAppInterface.getEntityManagerFactory().createEntityManager().a(TraceData.class);
  }
  
  public boolean a(List<TraceData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    Object localObject;
    atmr localatmr;
    TraceData localTraceData;
    try
    {
      localObject = a();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localatmr = ((atmp)localObject).a();
      localatmr.a();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localTraceData = (TraceData)paramList.next();
          if (localTraceData.getStatus() == 1000)
          {
            ((atmp)localObject).b(localTraceData);
            continue;
            return true;
          }
        }
      }
    }
    catch (Throwable paramList)
    {
      QLog.e("TraceReport", 1, paramList, new Object[0]);
    }
    for (;;)
    {
      ((atmp)localObject).a(localTraceData);
      break;
      localatmr.c();
      localatmr.b();
      ((atmp)localObject).a();
    }
  }
  
  public boolean b(List<TraceData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    Object localObject;
    atmr localatmr;
    try
    {
      localObject = a();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localatmr = ((atmp)localObject).a();
      localatmr.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ((atmp)localObject).b((TraceData)paramList.next());
        continue;
        return true;
      }
    }
    catch (Throwable paramList)
    {
      QLog.e("TraceReport", 1, paramList, new Object[0]);
    }
    for (;;)
    {
      localatmr.c();
      localatmr.b();
      ((atmp)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixz
 * JD-Core Version:    0.7.0.1
 */