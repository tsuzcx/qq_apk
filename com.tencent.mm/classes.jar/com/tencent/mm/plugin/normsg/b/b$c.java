package com.tencent.mm.plugin.normsg.b;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

final class b$c
  extends b.e
{
  private InvocationHandler mHK = new InvocationHandler()
  {
    public final Object invoke(Object arg1, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      Object localObject;
      synchronized (b.c.this.mHC)
      {
        localObject = paramAnonymousMethod.getName();
        if (b.aGi().equals(localObject))
        {
          paramAnonymousMethod = b.b(b.c.this.mHC);
          return paramAnonymousMethod;
        }
      }
      for (;;)
      {
        int j;
        int i;
        i += 1;
      }
    }
  };
  
  b$c(b paramb, IInterface paramIInterface)
  {
    super(paramb, paramIInterface);
  }
  
  public final IBinder asBinder()
  {
    ClassLoader localClassLoader = b.boZ();
    InvocationHandler localInvocationHandler = this.mHK;
    return (IBinder)Proxy.newProxyInstance(localClassLoader, new Class[] { IBinder.class }, localInvocationHandler);
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject6;
    if ((b.access$100().equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      localObject6 = paramArrayOfObject[1];
      try
      {
        if (!h.findClass(b.BG()).isAssignableFrom(localObject6.getClass())) {
          throw new IllegalStateException("mismatched conn class: " + localObject6.getClass() + ", give up intercepting.");
        }
      }
      catch (Throwable localThrowable)
      {
        y.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
        b.a(this.mHC, localThrowable);
        paramArrayOfObject[1] = localObject6;
      }
    }
    WeakReference localWeakReference;
    Object localObject4;
    for (;;)
    {
      return super.invoke(paramObject, paramMethod, paramArrayOfObject);
      localWeakReference = (WeakReference)h.f(localObject6, b.access$300());
      localObject4 = localWeakReference.get();
      if (localObject4 != null) {
        break;
      }
      y.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
    }
    if (Build.VERSION.SDK_INT < 16) {}
    Object localObject3;
    for (Object localObject1 = localObject4;; localObject3 = h.f(h.b(localObject4, b.access$600(), null, new Object[0]), "mHandler")) {
      for (;;)
      {
        Object localObject5 = (Handler.Callback)h.f(localObject1, b.access$700());
        if (!(localObject5 instanceof b.b)) {
          h.b(localObject1, b.access$700(), new b.b(this.mHC, localObject4, (Handler.Callback)localObject5));
        }
        synchronized (b.a(this.mHC))
        {
          localObject5 = (IBinder)b.a(this.mHC).get(localObject4);
          localObject1 = localObject5;
          if (localObject5 == null)
          {
            localObject1 = ((IInterface)localObject6).asBinder();
            localObject1 = new b.a(this.mHC, localWeakReference.get(), (IBinder)localObject1);
            b.a(this.mHC).put(localObject4, localObject1);
          }
          paramArrayOfObject[1] = ((IInterface)h.a(b.BG() + "$Stub", "asInterface", h.b(new Class[] { IBinder.class }), new Object[] { localObject1 }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.c
 * JD-Core Version:    0.7.0.1
 */