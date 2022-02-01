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
import java.util.Map;
import java.util.Set;

public class ServiceBinderInterceptor
  extends Interceptor<IBinder>
{
  private static final String TAG = "Tinker.SvcBndrIntrcptr";
  private static Method sGetServiceMethod;
  private static Field sSCacheField;
  private static Class<?> sServiceManagerClazz = null;
  private final Context mBaseContext;
  private final BinderInvocationHandler mBinderInvocationHandler;
  private final String mServiceName;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 38	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   4: aconst_null
    //   5: putstatic 40	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sSCacheField	Ljava/lang/reflect/Field;
    //   8: aconst_null
    //   9: putstatic 42	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sGetServiceMethod	Ljava/lang/reflect/Method;
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 38	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +42 -> 62
    //   23: ldc 44
    //   25: invokestatic 50	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   28: astore_0
    //   29: aload_0
    //   30: putstatic 38	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   33: aload_0
    //   34: ldc 52
    //   36: invokestatic 58	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findField	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   39: putstatic 40	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sSCacheField	Ljava/lang/reflect/Field;
    //   42: getstatic 38	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   45: ldc 60
    //   47: iconst_1
    //   48: anewarray 46	java/lang/Class
    //   51: dup
    //   52: iconst_0
    //   53: ldc 62
    //   55: aastore
    //   56: invokestatic 66	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   59: putstatic 42	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sGetServiceMethod	Ljava/lang/reflect/Method;
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: astore_0
    //   67: ldc 20
    //   69: ldc 68
    //   71: iconst_1
    //   72: anewarray 70	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokestatic 76	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: goto -20 -> 62
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	16	0	localClass	Class
    //   66	12	0	localThrowable	Throwable
    //   85	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	62	66	java/lang/Throwable
    //   15	19	85	finally
    //   23	62	85	finally
    //   62	65	85	finally
    //   67	82	85	finally
    //   86	89	85	finally
  }
  
  public ServiceBinderInterceptor(Context paramContext, String paramString, BinderInvocationHandler paramBinderInvocationHandler)
  {
    while ((paramContext != null) && ((paramContext instanceof ContextWrapper))) {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    this.mBaseContext = paramContext;
    this.mServiceName = paramString;
    this.mBinderInvocationHandler = paramBinderInvocationHandler;
  }
  
  private static <T> T createProxy(Class<?>[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
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
              Iterator localIterator = this.val$uniqueCls.iterator();
              Object localObject1 = null;
              while (localIterator.hasNext())
              {
                Object localObject2 = (ClassLoader)localIterator.next();
                try
                {
                  localObject2 = ((ClassLoader)localObject2).loadClass(paramAnonymousString);
                  localObject1 = localObject2;
                }
                catch (Throwable localThrowable)
                {
                  label46:
                  break label46;
                }
                if (localObject1 != null) {
                  return localObject1;
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
  
  private static void fixAMSBinderCache(IBinder paramIBinder)
  {
    try
    {
      Object localObject1 = ShareReflectUtil.findField(Class.forName("android.app.ActivityManagerNative"), "gDefault").get(null);
      localField = ShareReflectUtil.findField(localObject1, "mInstance");
      localIInterface = (IInterface)localField.get(localObject1);
      if ((localIInterface == null) || (Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(localIInterface.getClass()))) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Field localField;
      Object localObject2;
      for (;;)
      {
        localObject2 = ShareReflectUtil.findField(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton").get(null);
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface(paramIBinder.getInterfaceDescriptor());
      if ((localIInterface == null) || (!Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(localIInterface.getClass()))) {
        throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + paramIBinder + ", itf: " + localIInterface);
      }
      localField.set(localObject2, localIInterface);
    }
  }
  
  private static void fixPMSBinderCache(Context paramContext, IBinder paramIBinder)
  {
    Field localField = ShareReflectUtil.findField(Class.forName("android.app.ActivityThread"), "sPackageManager");
    IInterface localIInterface = (IInterface)localField.get(null);
    if ((localIInterface != null) && (!Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(localIInterface.getClass())))
    {
      localIInterface = paramIBinder.queryLocalInterface(paramIBinder.getInterfaceDescriptor());
      if ((localIInterface == null) || (!Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(localIInterface.getClass()))) {
        throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + paramIBinder + ", itf: " + localIInterface);
      }
      localField.set(null, localIInterface);
    }
    localField = ShareReflectUtil.findField(Class.forName("android.app.ApplicationPackageManager"), "mPM");
    paramContext = paramContext.getPackageManager();
    localIInterface = (IInterface)localField.get(paramContext);
    if ((localIInterface != null) && (!Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(localIInterface.getClass())))
    {
      localIInterface = paramIBinder.queryLocalInterface(paramIBinder.getInterfaceDescriptor());
      if ((localIInterface == null) || (!Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(localIInterface.getClass()))) {
        throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + paramIBinder + ", itf: " + localIInterface);
      }
      localField.set(paramContext, localIInterface);
    }
  }
  
  private static Class<?>[] getAllInterfacesThroughDeriveChain(Class<?> paramClass)
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
  
  protected IBinder decorate(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      throw new IllegalStateException("target is null.");
    }
    if (Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(paramIBinder.getClass())) {
      return paramIBinder;
    }
    return (IBinder)createProxy(getAllInterfacesThroughDeriveChain(paramIBinder.getClass()), new FakeClientBinderHandler(paramIBinder, this.mBinderInvocationHandler));
  }
  
  protected IBinder fetchTarget()
  {
    return (IBinder)sGetServiceMethod.invoke(null, new Object[] { this.mServiceName });
  }
  
  protected void inject(IBinder paramIBinder)
  {
    ((Map)sSCacheField.get(null)).put(this.mServiceName, paramIBinder);
    if ("activity".equals(this.mServiceName)) {
      fixAMSBinderCache(paramIBinder);
    }
    while (!"package".equals(this.mServiceName)) {
      return;
    }
    fixPMSBinderCache(this.mBaseContext, paramIBinder);
  }
  
  public static abstract interface BinderInvocationHandler
  {
    public abstract Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
  }
  
  static class FakeClientBinderHandler
    implements InvocationHandler
  {
    private final ServiceBinderInterceptor.BinderInvocationHandler mBinderInvocationHandler;
    private final IBinder mOriginalClientBinder;
    
    FakeClientBinderHandler(IBinder paramIBinder, ServiceBinderInterceptor.BinderInvocationHandler paramBinderInvocationHandler)
    {
      this.mOriginalClientBinder = paramIBinder;
      this.mBinderInvocationHandler = paramBinderInvocationHandler;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if ("queryLocalInterface".equals(paramMethod.getName()))
      {
        paramMethod = this.mOriginalClientBinder.getInterfaceDescriptor();
        if (paramMethod.equals("android.app.IActivityManager")) {}
        for (paramMethod = "android.app.ActivityManagerNative";; paramMethod = paramMethod + "$Stub")
        {
          paramMethod = (IInterface)ShareReflectUtil.findMethod(Class.forName(paramMethod), "asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { this.mOriginalClientBinder });
          paramObject = new ServiceBinderInterceptor.FakeInterfaceHandler(paramMethod, (IBinder)paramObject, this.mBinderInvocationHandler);
          return ServiceBinderInterceptor.createProxy(ServiceBinderInterceptor.access$000(paramMethod.getClass()), paramObject);
        }
      }
      return paramMethod.invoke(this.mOriginalClientBinder, paramArrayOfObject);
    }
  }
  
  static class FakeInterfaceHandler
    implements InvocationHandler
  {
    private final ServiceBinderInterceptor.BinderInvocationHandler mBinderInvocationHandler;
    private final IBinder mOriginalClientBinder;
    private final IInterface mOriginalInterface;
    
    FakeInterfaceHandler(IInterface paramIInterface, IBinder paramIBinder, ServiceBinderInterceptor.BinderInvocationHandler paramBinderInvocationHandler)
    {
      this.mOriginalInterface = paramIInterface;
      this.mOriginalClientBinder = paramIBinder;
      this.mBinderInvocationHandler = paramBinderInvocationHandler;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if ("asBinder".equals(paramMethod.getName())) {
        return this.mOriginalClientBinder;
      }
      return this.mBinderInvocationHandler.invoke(this.mOriginalInterface, paramMethod, paramArrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor
 * JD-Core Version:    0.7.0.1
 */