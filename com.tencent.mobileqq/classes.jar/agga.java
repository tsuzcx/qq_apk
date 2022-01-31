import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class agga
{
  private static final agga jdField_a_of_type_Agga = new agga();
  private Map<String, List<WeakReference<agfx>>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private int a(List<WeakReference<agfx>> paramList, agfx paramagfx)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        agfx localagfx = (agfx)((WeakReference)paramList.next()).get();
        if ((localagfx != null) && (localagfx == paramagfx)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static agga a()
  {
    return jdField_a_of_type_Agga;
  }
  
  public void a(int paramInt, String paramString, agfx paramagfx)
  {
    try
    {
      String str = akpy.a(paramString, paramInt);
      List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList(2);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      if (a(paramString, paramagfx) < 0) {
        paramString.add(new WeakReference(paramagfx));
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
        paramString = akpy.a(paramString, paramInt);
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = paramString.iterator();
          if (paramString.hasNext())
          {
            if ((agfx)((WeakReference)paramString.next()).get() == null) {
              continue;
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d(aghm.a, 2, "hasOtherInstance -->" + bool);
            }
            return bool;
          }
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b(int paramInt, String paramString, agfx paramagfx)
  {
    try
    {
      paramString = akpy.a(paramString, paramInt);
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramagfx != null))
      {
        paramInt = a(paramString, paramagfx);
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
 * Qualified Name:     agga
 * JD-Core Version:    0.7.0.1
 */