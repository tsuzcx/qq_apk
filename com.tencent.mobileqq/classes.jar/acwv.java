import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acwv<T>
  implements acwu<T>
{
  private List<Class<? extends T>> a = new ArrayList();
  private List<T> b = new ArrayList();
  
  private T a(Class<? extends T> paramClass)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject.getClass().equals(paramClass)) {
        return localObject;
      }
    }
    return null;
  }
  
  private T b(Class<? extends T> paramClass)
  {
    try
    {
      paramClass = paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.e("ClassGeneratorImpl", 1, paramClass, new Object[0]);
    }
    return null;
  }
  
  public List<T> a()
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Class)localIterator.next();
        Object localObject2 = a((Class)localObject1);
        if (localObject2 != null)
        {
          localArrayList.add(localObject2);
          continue;
        }
        localObject1 = b((Class)localObject1);
      }
      finally {}
      if (localObject1 != null)
      {
        this.b.add(localObject1);
        localList.add(localObject1);
      }
    }
    return localList;
  }
  
  public void a(Class<? extends T> paramClass)
  {
    if (paramClass != null) {}
    try
    {
      if (!this.a.contains(paramClass)) {
        this.a.add(paramClass);
      }
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwv
 * JD-Core Version:    0.7.0.1
 */