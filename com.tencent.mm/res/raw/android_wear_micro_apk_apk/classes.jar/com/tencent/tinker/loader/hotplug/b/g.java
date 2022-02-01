package com.tencent.tinker.loader.hotplug.b;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class g
  extends e<IBinder>
{
  private static Class<?> apj = null;
  private static Field apk = null;
  private static Method apl = null;
  private final Context apg;
  private final String aph;
  private final h api;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 26	com/tencent/tinker/loader/hotplug/b/g:apj	Ljava/lang/Class;
    //   4: aconst_null
    //   5: putstatic 28	com/tencent/tinker/loader/hotplug/b/g:apk	Ljava/lang/reflect/Field;
    //   8: aconst_null
    //   9: putstatic 30	com/tencent/tinker/loader/hotplug/b/g:apl	Ljava/lang/reflect/Method;
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 26	com/tencent/tinker/loader/hotplug/b/g:apj	Ljava/lang/Class;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +42 -> 62
    //   23: ldc 32
    //   25: invokestatic 38	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   28: astore_0
    //   29: aload_0
    //   30: putstatic 26	com/tencent/tinker/loader/hotplug/b/g:apj	Ljava/lang/Class;
    //   33: aload_0
    //   34: ldc 40
    //   36: invokestatic 46	com/tencent/tinker/loader/a/h:a	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   39: putstatic 28	com/tencent/tinker/loader/hotplug/b/g:apk	Ljava/lang/reflect/Field;
    //   42: getstatic 26	com/tencent/tinker/loader/hotplug/b/g:apj	Ljava/lang/Class;
    //   45: ldc 48
    //   47: iconst_1
    //   48: anewarray 34	java/lang/Class
    //   51: dup
    //   52: iconst_0
    //   53: ldc 50
    //   55: aastore
    //   56: invokestatic 53	com/tencent/tinker/loader/a/h:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   59: putstatic 30	com/tencent/tinker/loader/hotplug/b/g:apl	Ljava/lang/reflect/Method;
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: astore_0
    //   67: ldc 55
    //   69: ldc 57
    //   71: aload_0
    //   72: invokestatic 63	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   75: pop
    //   76: goto -14 -> 62
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	16	0	localClass	Class
    //   66	6	0	localThrowable	Throwable
    //   79	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	62	66	java/lang/Throwable
    //   15	19	79	finally
    //   23	62	79	finally
    //   62	65	79	finally
    //   67	76	79	finally
    //   80	83	79	finally
  }
  
  public g(Context paramContext, String paramString, h paramh)
  {
    while ((paramContext != null) && ((paramContext instanceof ContextWrapper))) {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    this.apg = paramContext;
    this.aph = paramString;
    this.api = paramh;
  }
  
  private static <T> T a(Class<?>[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
  {
    Class[] arrayOfClass = new Class[paramArrayOfClass.length + 1];
    System.arraycopy(paramArrayOfClass, 0, arrayOfClass, 0, paramArrayOfClass.length);
    arrayOfClass[paramArrayOfClass.length] = f.class;
    try
    {
      paramArrayOfClass = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), arrayOfClass, paramInvocationHandler);
      return paramArrayOfClass;
    }
    catch (Throwable localThrowable)
    {
      paramArrayOfClass = new HashSet(4);
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfClass.add(arrayOfClass[i].getClassLoader());
        i += 1;
      }
      if (paramArrayOfClass.size() == 1) {}
      for (paramArrayOfClass = (ClassLoader)paramArrayOfClass.iterator().next();; paramArrayOfClass = new ClassLoader()
          {
            protected final Class<?> loadClass(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              Iterator localIterator = g.this.iterator();
              while (localIterator.hasNext())
              {
                Class localClass = ((ClassLoader)localIterator.next()).loadClass(paramAnonymousString);
                if (localClass != null) {
                  return localClass;
                }
              }
              throw new ClassNotFoundException("cannot find class: ".concat(String.valueOf(paramAnonymousString)));
            }
          }) {
        try
        {
          paramInvocationHandler = Proxy.newProxyInstance(paramArrayOfClass, arrayOfClass, paramInvocationHandler);
          return paramInvocationHandler;
        }
        catch (Throwable paramInvocationHandler)
        {
          throw new RuntimeException("cl: ".concat(String.valueOf(paramArrayOfClass)), localThrowable);
        }
      }
    }
  }
  
  private static Class<?>[] i(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    HashSet localHashSet = new HashSet(10);
    while (!Object.class.equals(paramClass))
    {
      localHashSet.addAll(Arrays.asList(paramClass.getInterfaces()));
      paramClass = paramClass.getSuperclass();
    }
    return (Class[])localHashSet.toArray(new Class[localHashSet.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.g
 * JD-Core Version:    0.7.0.1
 */