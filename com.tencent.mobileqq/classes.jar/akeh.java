import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class akeh
{
  private static final akeh jdField_a_of_type_Akeh = new akeh();
  private Map<String, List<WeakReference<akee>>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private int a(List<WeakReference<akee>> paramList, akee paramakee)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        akee localakee = (akee)((WeakReference)paramList.next()).get();
        if ((localakee != null) && (localakee == paramakee)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static akeh a()
  {
    return jdField_a_of_type_Akeh;
  }
  
  public void a(int paramInt, String paramString, akee paramakee)
  {
    try
    {
      String str = acnh.a(paramString, paramInt);
      List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList(2);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      if (a(paramString, paramakee) < 0) {
        paramString.add(new WeakReference(paramakee));
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
        paramString = acnh.a(paramString, paramInt);
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = paramString.iterator();
          if (paramString.hasNext())
          {
            if ((akee)((WeakReference)paramString.next()).get() == null) {
              continue;
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d(akfu.a, 2, "hasOtherInstance -->" + bool);
            }
            return bool;
          }
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b(int paramInt, String paramString, akee paramakee)
  {
    try
    {
      paramString = acnh.a(paramString, paramInt);
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramakee != null))
      {
        paramInt = a(paramString, paramakee);
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
 * Qualified Name:     akeh
 * JD-Core Version:    0.7.0.1
 */