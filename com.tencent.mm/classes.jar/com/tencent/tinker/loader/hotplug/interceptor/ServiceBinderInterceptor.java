package com.tencent.tinker.loader.hotplug.interceptor;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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
    //   1: putstatic 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   4: aconst_null
    //   5: putstatic 38	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sSCacheField	Ljava/lang/reflect/Field;
    //   8: aconst_null
    //   9: putstatic 40	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sGetServiceMethod	Ljava/lang/reflect/Method;
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +42 -> 62
    //   23: ldc 42
    //   25: invokestatic 48	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   28: astore_0
    //   29: aload_0
    //   30: putstatic 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   33: aload_0
    //   34: ldc 50
    //   36: invokestatic 56	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findField	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   39: putstatic 38	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sSCacheField	Ljava/lang/reflect/Field;
    //   42: getstatic 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sServiceManagerClazz	Ljava/lang/Class;
    //   45: ldc 58
    //   47: iconst_1
    //   48: anewarray 44	java/lang/Class
    //   51: dup
    //   52: iconst_0
    //   53: ldc 60
    //   55: aastore
    //   56: invokestatic 64	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   59: putstatic 40	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:sGetServiceMethod	Ljava/lang/reflect/Method;
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: astore_0
    //   67: ldc 20
    //   69: ldc 66
    //   71: iconst_1
    //   72: anewarray 68	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokestatic 74	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: goto -20 -> 62
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	16	0	localClass	Class
    //   66	12	0	localObject1	Object
    //   85	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	62	66	finally
    //   15	19	85	finally
    //   62	65	85	finally
    //   67	82	85	finally
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
  
  /* Error */
  private static <T> T createProxy(Class<?>[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: iconst_1
    //   3: iadd
    //   4: anewarray 44	java/lang/Class
    //   7: astore 4
    //   9: aload_0
    //   10: iconst_0
    //   11: aload 4
    //   13: iconst_0
    //   14: aload_0
    //   15: arraylength
    //   16: invokestatic 107	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   19: aload 4
    //   21: aload_0
    //   22: arraylength
    //   23: ldc 109
    //   25: aastore
    //   26: invokestatic 115	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: invokevirtual 119	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   32: aload 4
    //   34: aload_1
    //   35: invokestatic 125	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   38: astore_0
    //   39: aload_0
    //   40: areturn
    //   41: astore 5
    //   43: new 127	java/util/HashSet
    //   46: dup
    //   47: iconst_4
    //   48: invokespecial 130	java/util/HashSet:<init>	(I)V
    //   51: astore_0
    //   52: aload 4
    //   54: arraylength
    //   55: istore_3
    //   56: iconst_0
    //   57: istore_2
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmpge +24 -> 84
    //   63: aload_0
    //   64: aload 4
    //   66: iload_2
    //   67: aaload
    //   68: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   71: invokeinterface 139 2 0
    //   76: pop
    //   77: iload_2
    //   78: iconst_1
    //   79: iadd
    //   80: istore_2
    //   81: goto -23 -> 58
    //   84: aload_0
    //   85: invokeinterface 143 1 0
    //   90: iconst_1
    //   91: if_icmpne +28 -> 119
    //   94: aload_0
    //   95: invokeinterface 147 1 0
    //   100: invokeinterface 153 1 0
    //   105: checkcast 155	java/lang/ClassLoader
    //   108: astore_0
    //   109: aload_0
    //   110: aload 4
    //   112: aload_1
    //   113: invokestatic 125	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   116: astore_1
    //   117: aload_1
    //   118: areturn
    //   119: new 7	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$1
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 158	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$1:<init>	(Ljava/util/Set;)V
    //   127: astore_0
    //   128: goto -19 -> 109
    //   131: astore_1
    //   132: new 160	java/lang/RuntimeException
    //   135: dup
    //   136: ldc 162
    //   138: aload_0
    //   139: invokestatic 166	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 170	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: aload 5
    //   147: invokespecial 173	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramArrayOfClass	Class<?>[]
    //   0	151	1	paramInvocationHandler	InvocationHandler
    //   57	24	2	i	int
    //   55	6	3	j	int
    //   7	104	4	arrayOfClass	Class[]
    //   41	105	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   26	39	41	finally
    //   109	117	131	finally
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
    finally
    {
      Field localField;
      Object localObject3;
      for (;;)
      {
        localObject3 = ShareReflectUtil.findField(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton").get(null);
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface(paramIBinder.getInterfaceDescriptor());
      if ((localIInterface == null) || (!Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(localIInterface.getClass()))) {
        throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + paramIBinder + ", itf: " + localIInterface);
      }
      localField.set(localObject3, localIInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor
 * JD-Core Version:    0.7.0.1
 */