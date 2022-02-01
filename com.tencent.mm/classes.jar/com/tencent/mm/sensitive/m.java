package com.tencent.mm.sensitive;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/SystemServiceBinderHooker;", "", "serviceName", "", "serviceClass", "hookCallback", "Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;)V", "TAG", "binderProxyHandler", "Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$BinderProxyHandler;", "mDelegateServiceBinder", "Landroid/os/IBinder;", "mHookCallback", "mOriginServiceBinder", "mServiceClass", "mServiceName", "doHook", "Lkotlin/Pair;", "", "doUnHook", "getDelegateProxy", "BinderProxyHandler", "HookCallback", "ServiceBinderInvokeHandler", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  private final String TAG = "SystemServiceBinderHooker";
  private b acuo;
  a acup;
  private String eUk;
  private IBinder eUm;
  private IBinder eUn;
  private String mServiceName;
  
  public m(String paramString1, String paramString2, b paramb)
  {
    this.mServiceName = paramString1;
    this.eUk = paramString2;
    this.acuo = paramb;
  }
  
  public final r<Boolean, String> iTK()
  {
    AppMethodBeat.i(240888);
    Log.i(this.TAG, "doHook: serviceName:" + this.mServiceName + ", serviceClsName:" + this.eUk);
    try
    {
      this.acup = new a(this.mServiceName, this.eUk, this.acuo);
      localObject4 = this.acup;
      s.checkNotNull(localObject4);
      localObject5 = Class.forName("android.os.ServiceManager");
      Object localObject1 = ((Class)localObject5).getClassLoader();
      if (localObject1 != null) {
        break label170;
      }
      localObject1 = new IllegalStateException(s.X("Can not get ClassLoader of ", ((Class)localObject5).getName()));
      AppMethodBeat.o(240888);
      throw ((Throwable)localObject1);
    }
    finally
    {
      Log.e(this.TAG, s.X("#doHook exp: ", localObject2.getMessage()), new Object[0]);
      Object localObject5 = Boolean.FALSE;
      localObject4 = localObject2.getMessage();
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      localObject3 = new r(localObject5, localObject3);
    }
    AppMethodBeat.o(240888);
    return localObject3;
    label170:
    Object localObject4 = (InvocationHandler)localObject4;
    Object localObject3 = Proxy.newProxyInstance((ClassLoader)localObject3, new Class[] { IBinder.class }, (InvocationHandler)localObject4);
    if (localObject3 == null)
    {
      localObject3 = new NullPointerException("null cannot be cast to non-null type android.os.IBinder");
      AppMethodBeat.o(240888);
      throw ((Throwable)localObject3);
    }
    localObject4 = (IBinder)localObject3;
    localObject3 = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
    ((Field)localObject3).setAccessible(true);
    localObject3 = ((Field)localObject3).get(null);
    if (an.hI(localObject3)) {}
    for (localObject3 = (Map)localObject3;; localObject3 = null)
    {
      if (localObject3 != null)
      {
        ((Map)localObject3).remove(this.mServiceName);
        ((Map)localObject3).put(this.mServiceName, localObject4);
      }
      this.eUn = ((IBinder)localObject4);
      localObject3 = this.acup;
      s.checkNotNull(localObject3);
      this.eUm = ((a)localObject3).acur;
      localObject3 = new r(Boolean.TRUE, "");
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$BinderProxyHandler;", "Ljava/lang/reflect/InvocationHandler;", "serviceName", "", "serviceClass", "callback", "Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;)V", "mServiceManagerProxy", "", "getMServiceManagerProxy", "()Ljava/lang/Object;", "originBinder", "Landroid/os/IBinder;", "getOriginBinder", "()Landroid/os/IBinder;", "createProxyBinder", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements InvocationHandler
  {
    public static final m.a.a acuq;
    final IBinder acur;
    final Object eUp;
    
    static
    {
      AppMethodBeat.i(240957);
      acuq = new m.a.a((byte)0);
      AppMethodBeat.o(240957);
    }
    
    public a(String paramString1, String paramString2, m.b paramb)
    {
      AppMethodBeat.i(240953);
      Object localObject2 = Class.forName("android.os.ServiceManager");
      Object localObject1 = ((Class)localObject2).getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(null);
      if (an.hI(localObject1))
      {
        localObject1 = (Map)localObject1;
        if (localObject1 != null) {
          ((Map)localObject1).remove(paramString1);
        }
        if (localObject1 != null) {
          break label165;
        }
      }
      label165:
      for (localObject1 = null;; localObject1 = Boolean.valueOf(((Map)localObject1).containsKey(paramString1)))
      {
        Log.i("getCurrentBinder", "isContaints " + paramString1 + " : " + localObject1);
        localObject1 = ((Class)localObject2).getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { paramString1 });
        if (localObject1 != null) {
          break label181;
        }
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.os.IBinder");
        AppMethodBeat.o(240953);
        throw paramString1;
        localObject1 = null;
        break;
      }
      label181:
      this.acur = ((IBinder)localObject1);
      Object localObject3 = this.acur;
      localObject1 = Class.forName(paramString2);
      Class localClass = Class.forName(s.X(paramString2, "$Stub"));
      localObject2 = localClass.getClassLoader();
      if (localObject2 == null)
      {
        paramString1 = new IllegalStateException("get service manager ClassLoader fail!");
        AppMethodBeat.o(240953);
        throw paramString1;
      }
      localObject3 = localClass.getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { localObject3 });
      s.s(localObject3, "originManagerService");
      paramString1 = (InvocationHandler)new m.c(paramString1, paramString2, paramb, localObject3);
      paramString1 = Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class, IInterface.class, localObject1 }, paramString1);
      s.s(paramString1, "if (classLoader == null)…rvice))\n                }");
      this.eUp = paramString1;
      AppMethodBeat.o(240953);
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(240960);
      s.u(paramObject, "proxy");
      s.u(paramMethod, "method");
      if (s.p("queryLocalInterface", paramMethod.getName()))
      {
        paramObject = this.eUp;
        AppMethodBeat.o(240960);
        return paramObject;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
      paramObject = a.a.d(this.acur, paramMethod, paramArrayOfObject);
      AppMethodBeat.o(240960);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;", "", "afterServiceMethodRealCall", "", "var2", "Ljava/lang/reflect/Method;", "methodReturnValue", "onServiceMethodIntercept", "Lkotlin/Pair;", "", "var1", "var3", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Lkotlin/Pair;", "onServiceMethodInvoke", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(Method paramMethod, Object paramObject);
    
    public abstract void e(Method paramMethod);
    
    public abstract r<Boolean, Object> f(Method paramMethod);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$ServiceBinderInvokeHandler;", "Ljava/lang/reflect/InvocationHandler;", "serviceName", "", "serviceClassName", "callback", "Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;", "originManagerService", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;Ljava/lang/Object;)V", "getCallback", "()Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;", "getOriginManagerService", "()Ljava/lang/Object;", "getServiceClassName", "()Ljava/lang/String;", "getServiceName", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "reHook", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements InvocationHandler
  {
    private final String acus;
    private final m.b acut;
    private final Object acuu;
    private final String serviceName;
    
    public c(String paramString1, String paramString2, m.b paramb, Object paramObject)
    {
      AppMethodBeat.i(240935);
      this.serviceName = paramString1;
      this.acus = paramString2;
      this.acut = paramb;
      this.acuu = paramObject;
      AppMethodBeat.o(240935);
    }
    
    private final void iTL()
    {
      AppMethodBeat.i(240942);
      Log.i("SystemServiceBinderHooker", "[DeadObjectException]: re hook");
      new m(this.serviceName, this.acus, this.acut).iTK();
      AppMethodBeat.o(240942);
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(240950);
      paramObject = this.acut;
      if (paramObject != null) {
        paramObject.e(paramMethod);
      }
      paramObject = this.acut;
      int i;
      if (paramObject == null)
      {
        paramObject = null;
        if (paramObject == null) {
          break label100;
        }
        if (((Boolean)paramObject.bsC).booleanValue()) {
          break label88;
        }
        i = 1;
        label52:
        if (i == 0) {
          break label94;
        }
      }
      label88:
      label94:
      for (Object localObject = paramObject;; localObject = null)
      {
        if (localObject == null) {
          break label100;
        }
        paramObject = paramObject.bsD;
        AppMethodBeat.o(240950);
        return paramObject;
        paramObject = paramObject.f(paramMethod);
        break;
        i = 0;
        break label52;
      }
      label100:
      localObject = (c)this;
      try
      {
        paramObject = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
        paramObject = a.a.d(((c)localObject).acuu, paramMethod, paramArrayOfObject);
        paramArrayOfObject = ((c)localObject).acut;
        if (paramArrayOfObject != null) {
          paramArrayOfObject.a(paramMethod, paramObject);
        }
        AppMethodBeat.o(240950);
        return paramObject;
      }
      catch (RemoteException paramArrayOfObject)
      {
        paramObject = com.tencent.mm.sensitive.d.a.acvx;
        if (paramMethod == null) {
          paramObject = "";
        }
        for (;;)
        {
          com.tencent.mm.sensitive.d.a.pC(paramObject, s.X("[RemoteException]: ", paramArrayOfObject));
          Log.i("SystemServiceBinderHooker", s.X("[DeadObjectException]: ", paramArrayOfObject.getMessage()));
          ((c)localObject).iTL();
          paramObject = new RemoteException(s.X("Sensitive hooker catch RemoteException:", paramArrayOfObject.getMessage()));
          AppMethodBeat.o(240950);
          throw paramObject;
          paramMethod = paramMethod.getName();
          paramObject = paramMethod;
          if (paramMethod == null) {
            paramObject = "";
          }
        }
      }
      catch (InvocationTargetException paramArrayOfObject)
      {
        paramObject = com.tencent.mm.sensitive.d.a.acvx;
        if (paramMethod == null) {
          paramObject = "";
        }
        for (;;)
        {
          com.tencent.mm.sensitive.d.a.pC(paramObject, "[InvocationTargetException]: " + paramArrayOfObject + ",targetException:" + paramArrayOfObject.getTargetException());
          Log.i("SystemServiceBinderHooker", s.X("catch InvocationTargetException: ", paramArrayOfObject.getMessage()));
          ((c)localObject).iTL();
          if (!(paramArrayOfObject.getTargetException() instanceof RemoteException)) {
            break;
          }
          Log.i("SystemServiceBinderHooker", s.X("catch InvocationTargetException target is RemoteException: ", paramArrayOfObject.getMessage()));
          paramObject = new RemoteException(s.X("Sensitive hooker catch InvocationTargetException-RemoteException:", paramArrayOfObject.getMessage()));
          AppMethodBeat.o(240950);
          throw paramObject;
          paramMethod = paramMethod.getName();
          paramObject = paramMethod;
          if (paramMethod == null) {
            paramObject = "";
          }
        }
        paramObject = new Throwable(s.X("Sensitive hooker catch InvocationTargetException: ", paramArrayOfObject.getTargetException().getMessage()), paramArrayOfObject.getTargetException().getCause());
        AppMethodBeat.o(240950);
        throw paramObject;
      }
      finally
      {
        paramObject = com.tencent.mm.sensitive.d.a.acvx;
        if (paramMethod != null) {
          break label443;
        }
      }
      paramObject = "";
      for (;;)
      {
        com.tencent.mm.sensitive.d.a.pC(paramObject, s.X("[Throwable]: ", paramArrayOfObject.getMessage()));
        paramObject = new Throwable(s.X("Sensitive hooker catch Throwable: ", paramArrayOfObject.getMessage()), paramArrayOfObject.getCause());
        AppMethodBeat.o(240950);
        throw paramObject;
        label443:
        paramMethod = paramMethod.getName();
        paramObject = paramMethod;
        if (paramMethod == null) {
          paramObject = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sensitive.m
 * JD-Core Version:    0.7.0.1
 */