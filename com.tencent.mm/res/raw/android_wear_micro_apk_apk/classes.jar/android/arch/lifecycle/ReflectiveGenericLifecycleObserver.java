package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ReflectiveGenericLifecycleObserver
  implements a
{
  static final Map<Class, j> H = new HashMap();
  private final Object F;
  private final j G;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.F = paramObject;
    this.G = a(this.F.getClass());
  }
  
  private static j a(Class paramClass)
  {
    Object localObject1 = (j)H.get(paramClass);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = new HashMap();
    if (localObject2 != null)
    {
      localObject2 = a((Class)localObject2);
      if (localObject2 != null) {
        ((Map)localObject1).putAll(((j)localObject2).J);
      }
    }
    localObject2 = paramClass.getDeclaredMethods();
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject3 = a(arrayOfClass[i]).J.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        a((Map)localObject1, (k)((Map.Entry)localObject4).getKey(), (c)((Map.Entry)localObject4).getValue(), paramClass);
      }
      i += 1;
    }
    int k = localObject2.length;
    j = 0;
    if (j < k)
    {
      arrayOfClass = localObject2[j];
      localObject4 = (i)arrayOfClass.getAnnotation(i.class);
      if (localObject4 != null)
      {
        localObject3 = arrayOfClass.getParameterTypes();
        if (localObject3.length <= 0) {
          break label366;
        }
        if (!localObject3[0].isAssignableFrom(e.class)) {
          throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
        }
      }
    }
    label366:
    for (i = 1;; i = 0)
    {
      localObject4 = ((i)localObject4).h();
      if (localObject3.length > 1)
      {
        if (!localObject3[1].isAssignableFrom(c.class)) {
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        }
        if (localObject4 != c.ON_ANY) {
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        }
        i = 2;
      }
      if (localObject3.length > 2) {
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      a((Map)localObject1, new k(i, arrayOfClass), (c)localObject4, paramClass);
      j += 1;
      break;
      localObject1 = new j((Map)localObject1);
      H.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  private void a(List<k> paramList, e parame, c paramc)
  {
    int i;
    if (paramList != null) {
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        k localk = (k)paramList.get(i);
        try
        {
          switch (localk.K)
          {
          case 0: 
            localk.L.invoke(this.F, new Object[0]);
          }
        }
        catch (InvocationTargetException paramList)
        {
          throw new RuntimeException("Failed to call observer method", paramList.getCause());
          localk.L.invoke(this.F, new Object[] { parame });
        }
        catch (IllegalAccessException paramList)
        {
          throw new RuntimeException(paramList);
        }
        localk.L.invoke(this.F, new Object[] { parame, paramc });
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  private static void a(Map<k, c> paramMap, k paramk, c paramc, Class paramClass)
  {
    c localc = (c)paramMap.get(paramk);
    if ((localc != null) && (paramc != localc))
    {
      paramMap = paramk.L;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localc + ", new value " + paramc);
    }
    if (localc == null) {
      paramMap.put(paramk, paramc);
    }
  }
  
  public final void a(e parame, c paramc)
  {
    j localj = this.G;
    a((List)localj.I.get(paramc), parame, paramc);
    a((List)localj.I.get(c.ON_ANY), parame, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */