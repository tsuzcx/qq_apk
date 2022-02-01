package mqq.app.api.impl;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ModelUtils
{
  public static final String TAG = "ModelUtils";
  
  public static Object mapToObject(Map<String, Object> paramMap, Class<?> paramClass)
  {
    localObject1 = null;
    if (paramMap == null) {
      return null;
    }
    try
    {
      Object localObject2 = paramClass.newInstance();
      localObject1 = localObject2;
      Field[] arrayOfField = localObject2.getClass().getDeclaredFields();
      localObject1 = localObject2;
      int j = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        Field localField = arrayOfField[i];
        localObject1 = localObject2;
        int k = localField.getModifiers();
        localObject1 = localObject2;
        if (!Modifier.isStatic(k))
        {
          localObject1 = localObject2;
          if (!Modifier.isFinal(k))
          {
            localObject1 = localObject2;
            localField.setAccessible(true);
            localObject1 = localObject2;
            if (paramMap.containsKey(localField.getName()))
            {
              localObject1 = localObject2;
              localField.set(localObject2, paramMap.get(localField.getName()));
            }
            else
            {
              localObject1 = localObject2;
              QLog.e("ModelUtils", 1, String.format("mapToObject, %s.%s is null", new Object[] { paramClass.getSimpleName(), localField.getName() }));
            }
          }
        }
        i += 1;
      }
      return localObject1;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static Map objectToMap(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    localHashMap = new HashMap();
    try
    {
      Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        localField.setAccessible(true);
        localHashMap.put(localField.getName(), localField.get(paramObject));
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.api.impl.ModelUtils
 * JD-Core Version:    0.7.0.1
 */