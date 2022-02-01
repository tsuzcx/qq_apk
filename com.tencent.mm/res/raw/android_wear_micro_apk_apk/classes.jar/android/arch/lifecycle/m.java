package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m
{
  private static Map<Class, Integer> W = new HashMap();
  private static Map<Class, List<Constructor<? extends d>>> X = new HashMap();
  
  private static d a(Constructor<? extends d> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (d)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  static GenericLifecycleObserver c(Object paramObject)
  {
    if ((paramObject instanceof FullLifecycleObserver)) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject);
    }
    if ((paramObject instanceof GenericLifecycleObserver)) {
      return (GenericLifecycleObserver)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (e((Class)localObject) == 2)
    {
      localObject = (List)X.get(localObject);
      if (((List)localObject).size() == 1) {
        return new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
      }
      d[] arrayOfd = new d[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfd[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfd);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static Constructor<? extends d> d(Class<?> paramClass)
  {
    for (;;)
    {
      try
      {
        localObject = paramClass.getPackage();
        String str = paramClass.getCanonicalName();
        if (localObject != null)
        {
          localObject = ((Package)localObject).getName();
          if (((String)localObject).isEmpty())
          {
            str = str.replace(".", "_") + "_LifecycleAdapter";
            if (((String)localObject).isEmpty())
            {
              localObject = str;
              paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
              if (paramClass.isAccessible()) {
                break label146;
              }
              paramClass.setAccessible(true);
              return paramClass;
            }
          }
          else
          {
            str = str.substring(((String)localObject).length() + 1);
            continue;
          }
          localObject = (String)localObject + "." + str;
          continue;
          return paramClass;
        }
      }
      catch (ClassNotFoundException paramClass)
      {
        return null;
      }
      catch (NoSuchMethodException paramClass)
      {
        throw new RuntimeException(paramClass);
      }
      label146:
      Object localObject = "";
    }
  }
  
  private static int e(Class<?> paramClass)
  {
    if (W.containsKey(paramClass)) {
      return ((Integer)W.get(paramClass)).intValue();
    }
    int i = f(paramClass);
    W.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static int f(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = d(paramClass);
    if (localObject1 != null)
    {
      X.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (a.v.a(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (g((Class)localObject2))
    {
      if (e((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)X.get(localObject2));
    }
    localObject2 = paramClass.getInterfaces();
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      Class localClass = localObject2[i];
      if (!g(localClass)) {
        break label197;
      }
      if (e(localClass) == 1) {
        return 1;
      }
      if (localObject1 != null) {
        break label194;
      }
      localObject1 = new ArrayList();
      label148:
      ((List)localObject1).addAll((Collection)X.get(localClass));
    }
    label194:
    label197:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 != null)
      {
        X.put(paramClass, localObject1);
        return 2;
      }
      return 1;
      break label148;
    }
  }
  
  private static boolean g(Class<?> paramClass)
  {
    return (paramClass != null) && (h.class.isAssignableFrom(paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.m
 * JD-Core Version:    0.7.0.1
 */