package com.tencent.tinker.loader.hotplug.interceptor;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ServiceBinderInterceptor
  extends Interceptor<IBinder>
{
  private static Class<?> BuF = null;
  private static Field BuG = null;
  private static Method BuH = null;
  private final Context BuD;
  private final BinderInvocationHandler BuE;
  private final String bNw;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 35	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuF	Ljava/lang/Class;
    //   4: aconst_null
    //   5: putstatic 37	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuG	Ljava/lang/reflect/Field;
    //   8: aconst_null
    //   9: putstatic 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuH	Ljava/lang/reflect/Method;
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 35	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuF	Ljava/lang/Class;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +42 -> 62
    //   23: ldc 41
    //   25: invokestatic 47	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   28: astore_0
    //   29: aload_0
    //   30: putstatic 35	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuF	Ljava/lang/Class;
    //   33: aload_0
    //   34: ldc 49
    //   36: invokestatic 55	com/tencent/tinker/loader/shareutil/ShareReflectUtil:g	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   39: putstatic 37	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuG	Ljava/lang/reflect/Field;
    //   42: getstatic 35	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuF	Ljava/lang/Class;
    //   45: ldc 57
    //   47: iconst_1
    //   48: anewarray 43	java/lang/Class
    //   51: dup
    //   52: iconst_0
    //   53: ldc 59
    //   55: aastore
    //   56: invokestatic 63	com/tencent/tinker/loader/shareutil/ShareReflectUtil:d	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   59: putstatic 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:BuH	Ljava/lang/reflect/Method;
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    //   72: astore_0
    //   73: goto -11 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	16	0	localClass	Class
    //   66	5	0	localObject	Object
    //   72	1	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   15	19	66	finally
    //   23	62	66	finally
    //   62	65	66	finally
    //   67	70	66	finally
    //   23	62	72	java/lang/Throwable
  }
  
  public ServiceBinderInterceptor(Context paramContext, String paramString, BinderInvocationHandler paramBinderInvocationHandler)
  {
    while ((paramContext != null) && ((paramContext instanceof ContextWrapper))) {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    this.BuD = paramContext;
    this.bNw = paramString;
    this.BuE = paramBinderInvocationHandler;
  }
  
  private static <T> T a(Class<?>[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
  {
    Class[] arrayOfClass = new Class[paramArrayOfClass.length + 1];
    System.arraycopy(paramArrayOfClass, 0, arrayOfClass, 0, paramArrayOfClass.length);
    arrayOfClass[paramArrayOfClass.length] = Interceptor.ITinkerHotplugProxy.class;
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
              Iterator localIterator = this.BuI.iterator();
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
  
  private static Class<?>[] aD(Class<?> paramClass)
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
  
  public static abstract interface BinderInvocationHandler
  {
    public abstract Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
  }
  
  static class FakeClientBinderHandler
    implements InvocationHandler
  {
    private final ServiceBinderInterceptor.BinderInvocationHandler BuE;
    private final IBinder BuJ;
    
    FakeClientBinderHandler(IBinder paramIBinder, ServiceBinderInterceptor.BinderInvocationHandler paramBinderInvocationHandler)
    {
      this.BuJ = paramIBinder;
      this.BuE = paramBinderInvocationHandler;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if ("queryLocalInterface".equals(paramMethod.getName()))
      {
        paramMethod = this.BuJ.getInterfaceDescriptor();
        if (paramMethod.equals("android.app.IActivityManager")) {}
        for (paramMethod = "android.app.ActivityManagerNative";; paramMethod = paramMethod + "$Stub")
        {
          paramMethod = (IInterface)ShareReflectUtil.d(Class.forName(paramMethod), "asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { this.BuJ });
          paramObject = new ServiceBinderInterceptor.FakeInterfaceHandler(paramMethod, (IBinder)paramObject, this.BuE);
          return ServiceBinderInterceptor.b(ServiceBinderInterceptor.aE(paramMethod.getClass()), paramObject);
        }
      }
      return paramMethod.invoke(this.BuJ, paramArrayOfObject);
    }
  }
  
  static class FakeInterfaceHandler
    implements InvocationHandler
  {
    private final ServiceBinderInterceptor.BinderInvocationHandler BuE;
    private final IBinder BuJ;
    private final IInterface BuK;
    
    FakeInterfaceHandler(IInterface paramIInterface, IBinder paramIBinder, ServiceBinderInterceptor.BinderInvocationHandler paramBinderInvocationHandler)
    {
      this.BuK = paramIInterface;
      this.BuJ = paramIBinder;
      this.BuE = paramBinderInvocationHandler;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if ("asBinder".equals(paramMethod.getName())) {
        return this.BuJ;
      }
      return this.BuE.invoke(this.BuK, paramMethod, paramArrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor
 * JD-Core Version:    0.7.0.1
 */