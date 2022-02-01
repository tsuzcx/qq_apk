import android.os.Looper;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class aidu
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, List<Object>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private ArrayMap<String, Boolean> b = new ArrayMap();
  
  private int a(String paramString, int paramInt, List<Object> paramList)
  {
    a();
    if ((paramString == null) || (paramInt <= 0) || (paramList == null)) {
      return -1;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      if (((localObject instanceof String)) && (((String)localObject).equals(paramString))) {
        return i + paramInt;
      }
      i += 1;
    }
    return -1;
  }
  
  private void a(int paramInt, String paramString, List<Object> paramList)
  {
    a();
    if ((paramString == null) || (paramInt < 0) || (paramList == null)) {}
    do
    {
      return;
      paramString = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString);
    } while (paramString == null);
    int i = paramString.size();
    while ((i > 0) && (paramInt < paramList.size()))
    {
      paramList.remove(paramInt);
      i -= 1;
    }
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (paramString.size() + paramInt);
  }
  
  private void b(int paramInt, String paramString, List<Object> paramList)
  {
    a();
    if ((paramString == null) || (paramInt < 0) || (paramList == null)) {}
    do
    {
      return;
      paramString = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString);
    } while (paramString == null);
    paramList.addAll(paramInt, paramString);
    this.jdField_a_of_type_Int -= paramString.size();
  }
  
  public int a()
  {
    a();
    return this.jdField_a_of_type_Int;
  }
  
  public List<Object> a(String paramString)
  {
    a();
    return (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString);
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new RuntimeException("This method must be called on UI thread");
    }
  }
  
  public void a(List<Object> paramList, int paramInt)
  {
    a();
    if ((paramList == null) || (paramInt <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        if (((localObject instanceof String)) && (this.b.get((String)localObject) != null) && (!((Boolean)this.b.get((String)localObject)).booleanValue()) && (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject) != null)) {
          paramList.addAll(i + paramInt, (Collection)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject));
        }
        i += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Object> paramList)
  {
    a();
    if ((paramList == null) || (paramInt <= 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
      Object localObject2 = null;
      int i = 0;
      Object localObject3;
      if (i < paramList.size())
      {
        localObject3 = paramList.get(i);
        if ((localObject3 instanceof String))
        {
          localObject2 = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject3);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put((String)localObject3, localObject1);
          }
        }
        for (;;)
        {
          i += 1;
          localObject2 = localObject1;
          break;
          localObject1 = localObject2;
          if (localObject2 != null) {
            if ((!(localObject3 instanceof aidw)) && (localObject3 != aicx.b) && (!(localObject3 instanceof asuo)))
            {
              localObject1 = localObject2;
              if (localObject3 != asua.c) {}
            }
            else
            {
              ((List)localObject2).add(localObject3);
              localObject1 = localObject2;
            }
          }
        }
      }
      this.jdField_a_of_type_Int = 0;
      if (!paramBoolean) {
        break;
      }
      Object localObject1 = this.b.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (Boolean)((Map.Entry)localObject3).getValue();
        if ((localObject3 != null) && (!((Boolean)localObject3).booleanValue())) {
          a(a((String)localObject2, paramInt, paramList), (String)localObject2, paramList);
        }
      }
    }
    this.b.clear();
  }
  
  public boolean a(String paramString)
  {
    a();
    paramString = (Boolean)this.b.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt, List<Object> paramList)
  {
    boolean bool2 = true;
    a();
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString) == null) {
      return false;
    }
    if (this.b.get(paramString) != null) {}
    for (boolean bool1 = ((Boolean)this.b.get(paramString)).booleanValue();; bool1 = true)
    {
      ArrayMap localArrayMap = this.b;
      if (!bool1)
      {
        localArrayMap.put(paramString, Boolean.valueOf(bool2));
        paramInt = a(paramString, paramInt, paramList);
        if (bool1) {
          break label99;
        }
        b(paramInt, paramString, paramList);
      }
      for (;;)
      {
        return bool1;
        bool2 = false;
        break;
        label99:
        a(paramInt, paramString, paramList);
      }
    }
  }
  
  public boolean a(List<Object> paramList, int paramInt)
  {
    a();
    boolean bool2;
    if ((this.b.isEmpty()) || (paramList == null))
    {
      bool2 = false;
      return bool2;
    }
    int i = 0;
    boolean bool1 = false;
    label29:
    if (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      if ((!(localObject instanceof String)) || (this.b.get((String)localObject) == null) || (((Boolean)this.b.get((String)localObject)).booleanValue()) || (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject) == null)) {
        break label155;
      }
      paramList.addAll(i + paramInt, (Collection)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject));
      bool1 = true;
    }
    label155:
    for (;;)
    {
      i += 1;
      break label29;
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.b.clear();
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidu
 * JD-Core Version:    0.7.0.1
 */