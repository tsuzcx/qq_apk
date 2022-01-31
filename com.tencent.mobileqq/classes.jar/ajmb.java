import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ajmb
  implements ajmf
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
    aukp localaukp;
    TraceData localTraceData;
    try
    {
      localObject = a();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localaukp = ((aukn)localObject).a();
      localaukp.a();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localTraceData = (TraceData)paramList.next();
          if (localTraceData.getStatus() == 1000)
          {
            ((aukn)localObject).b(localTraceData);
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
      ((aukn)localObject).a(localTraceData);
      break;
      localaukp.c();
      localaukp.b();
      ((aukn)localObject).a();
    }
  }
  
  public boolean b(List<TraceData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    Object localObject;
    aukp localaukp;
    try
    {
      localObject = a();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localaukp = ((aukn)localObject).a();
      localaukp.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ((aukn)localObject).b((TraceData)paramList.next());
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
      localaukp.c();
      localaukp.b();
      ((aukn)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajmb
 * JD-Core Version:    0.7.0.1
 */