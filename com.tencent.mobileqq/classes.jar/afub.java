import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class afub
{
  private static final afub jdField_a_of_type_Afub = new afub();
  private Map<String, List<WeakReference<afty>>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private int a(List<WeakReference<afty>> paramList, afty paramafty)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        afty localafty = (afty)((WeakReference)paramList.next()).get();
        if ((localafty != null) && (localafty == paramafty)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static afub a()
  {
    return jdField_a_of_type_Afub;
  }
  
  public void a(int paramInt, String paramString, afty paramafty)
  {
    try
    {
      String str = akbm.a(paramString, paramInt);
      List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList(2);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      if (a(paramString, paramafty) < 0) {
        paramString.add(new WeakReference(paramafty));
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
        paramString = akbm.a(paramString, paramInt);
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = paramString.iterator();
          if (paramString.hasNext())
          {
            if ((afty)((WeakReference)paramString.next()).get() == null) {
              continue;
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d(afvn.a, 2, "hasOtherInstance -->" + bool);
            }
            return bool;
          }
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b(int paramInt, String paramString, afty paramafty)
  {
    try
    {
      paramString = akbm.a(paramString, paramInt);
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramafty != null))
      {
        paramInt = a(paramString, paramafty);
        if (paramInt >= 0) {
          paramString.remove(paramInt);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afub
 * JD-Core Version:    0.7.0.1
 */