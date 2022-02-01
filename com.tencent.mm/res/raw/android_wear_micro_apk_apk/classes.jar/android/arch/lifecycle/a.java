package android.arch.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class a
{
  static a v = new a();
  private final Map<Class, b> w = new HashMap();
  private final Map<Class, Boolean> z = new HashMap();
  
  private b a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = c((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((b)localObject1).B);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = c(localObject1[i]).B.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (c)((Map.Entry)localObject3).getKey(), (f)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod != null) {}
    boolean bool;
    for (;;)
    {
      int k = paramArrayOfMethod.length;
      j = 0;
      bool = false;
      if (j >= k) {
        break label339;
      }
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (r)((Method)localObject1).getAnnotation(r.class);
      if (localObject3 == null) {
        break label379;
      }
      localObject2 = ((Method)localObject1).getParameterTypes();
      if (localObject2.length <= 0) {
        break label382;
      }
      if (localObject2[0].isAssignableFrom(i.class)) {
        break;
      }
      throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
      paramArrayOfMethod = b(paramClass);
    }
    label339:
    label379:
    label382:
    for (i = 1;; i = 0)
    {
      localObject3 = ((r)localObject3).p();
      if (localObject2.length > 1)
      {
        if (!localObject2[1].isAssignableFrom(f.class)) {
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        }
        if (localObject3 != f.ON_ANY) {
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        }
        i = 2;
      }
      if (localObject2.length > 2) {
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      a(localHashMap, new c(i, (Method)localObject1), (f)localObject3, paramClass);
      bool = true;
      for (;;)
      {
        j += 1;
        break;
        paramArrayOfMethod = new b(localHashMap);
        this.w.put(paramClass, paramArrayOfMethod);
        this.z.put(paramClass, Boolean.valueOf(bool));
        return paramArrayOfMethod;
      }
    }
  }
  
  private static void a(Map<c, f> paramMap, c paramc, f paramf, Class paramClass)
  {
    f localf = (f)paramMap.get(paramc);
    if ((localf != null) && (paramf != localf))
    {
      paramMap = paramc.D;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localf + ", new value " + paramf);
    }
    if (localf == null) {
      paramMap.put(paramc, paramf);
    }
  }
  
  private static Method[] b(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  final boolean a(Class paramClass)
  {
    if (this.z.containsKey(paramClass)) {
      return ((Boolean)this.z.get(paramClass)).booleanValue();
    }
    Method[] arrayOfMethod = b(paramClass);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      if ((r)arrayOfMethod[i].getAnnotation(r.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    this.z.put(paramClass, Boolean.FALSE);
    return false;
  }
  
  final b c(Class paramClass)
  {
    b localb = (b)this.w.get(paramClass);
    if (localb != null) {
      return localb;
    }
    return a(paramClass, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.a
 * JD-Core Version:    0.7.0.1
 */