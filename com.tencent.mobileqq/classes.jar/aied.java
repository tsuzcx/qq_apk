import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class aied
{
  private static final aied jdField_a_of_type_Aied = new aied();
  private Map<String, List<WeakReference<aiea>>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private int a(List<WeakReference<aiea>> paramList, aiea paramaiea)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        aiea localaiea = (aiea)((WeakReference)paramList.next()).get();
        if ((localaiea != null) && (localaiea == paramaiea)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static aied a()
  {
    return jdField_a_of_type_Aied;
  }
  
  public void a(int paramInt, String paramString, aiea paramaiea)
  {
    try
    {
      String str = abot.a(paramString, paramInt);
      List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList(2);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      if (a(paramString, paramaiea) < 0) {
        paramString.add(new WeakReference(paramaiea));
      }
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = abot.a(paramString, paramInt);
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = paramString.iterator();
          if (paramString.hasNext())
          {
            if ((aiea)((WeakReference)paramString.next()).get() == null) {
              continue;
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d(aifp.a, 2, "hasOtherInstance -->" + bool);
            }
            return bool;
          }
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b(int paramInt, String paramString, aiea paramaiea)
  {
    try
    {
      paramString = abot.a(paramString, paramInt);
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramaiea != null))
      {
        paramInt = a(paramString, paramaiea);
        if (paramInt >= 0) {
          paramString.remove(paramInt);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aied
 * JD-Core Version:    0.7.0.1
 */