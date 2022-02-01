import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class akku
{
  private static final akku jdField_a_of_type_Akku = new akku();
  private Map<String, List<WeakReference<akkr>>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private int a(List<WeakReference<akkr>> paramList, akkr paramakkr)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        akkr localakkr = (akkr)((WeakReference)paramList.next()).get();
        if ((localakkr != null) && (localakkr == paramakkr)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static akku a()
  {
    return jdField_a_of_type_Akku;
  }
  
  public void a(int paramInt, String paramString, akkr paramakkr)
  {
    try
    {
      String str = adak.a(paramString, paramInt);
      List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList(2);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      if (a(paramString, paramakkr) < 0) {
        paramString.add(new WeakReference(paramakkr));
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
        paramString = adak.a(paramString, paramInt);
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = paramString.iterator();
          if (paramString.hasNext())
          {
            if ((akkr)((WeakReference)paramString.next()).get() == null) {
              continue;
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d(akmh.a, 2, "hasOtherInstance -->" + bool);
            }
            return bool;
          }
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b(int paramInt, String paramString, akkr paramakkr)
  {
    try
    {
      paramString = adak.a(paramString, paramInt);
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramakkr != null))
      {
        paramInt = a(paramString, paramakkr);
        if (paramInt >= 0) {
          paramString.remove(paramInt);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akku
 * JD-Core Version:    0.7.0.1
 */