package com.tencent.mm.plugin.normsg.b;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

final class b$c
  extends b.e
{
  private InvocationHandler phQ;
  
  b$c(b paramb, IInterface paramIInterface)
  {
    super(paramb, paramIInterface);
    AppMethodBeat.i(10399);
    this.phQ = new b.c.1(this);
    AppMethodBeat.o(10399);
  }
  
  public final IBinder asBinder()
  {
    AppMethodBeat.i(10401);
    Object localObject = b.bXB();
    InvocationHandler localInvocationHandler = this.phQ;
    localObject = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { IBinder.class }, localInvocationHandler);
    AppMethodBeat.o(10401);
    return localObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(10400);
    Object localObject6;
    if ((b.access$100().equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      localObject6 = paramArrayOfObject[1];
      try
      {
        if (!h.findClass(b.access$200()).isAssignableFrom(localObject6.getClass()))
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("mismatched conn class: " + localObject6.getClass() + ", give up intercepting.");
          AppMethodBeat.o(10400);
          throw localIllegalStateException;
        }
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
        b.a(this.phI, localThrowable);
        paramArrayOfObject[1] = localObject6;
      }
    }
    WeakReference localWeakReference;
    Object localObject4;
    for (;;)
    {
      paramObject = super.invoke(paramObject, paramMethod, paramArrayOfObject);
      AppMethodBeat.o(10400);
      return paramObject;
      localWeakReference = (WeakReference)h.g(localObject6, b.access$300());
      localObject4 = localWeakReference.get();
      if (localObject4 != null) {
        break;
      }
      ab.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
    }
    if (Build.VERSION.SDK_INT < 16) {}
    Object localObject3;
    for (Object localObject1 = localObject4;; localObject3 = h.g(h.b(localObject4, b.access$600(), null, new Object[0]), "mHandler")) {
      for (;;)
      {
        Object localObject5 = (Handler.Callback)h.g(localObject1, b.access$700());
        if (!(localObject5 instanceof b.b)) {
          h.b(localObject1, b.access$700(), new b.b(this.phI, localObject4, (Handler.Callback)localObject5));
        }
        synchronized (b.a(this.phI))
        {
          localObject5 = (IBinder)b.a(this.phI).get(localObject4);
          localObject1 = localObject5;
          if (localObject5 == null)
          {
            localObject1 = ((IInterface)localObject6).asBinder();
            localObject1 = new b.a(this.phI, localWeakReference.get(), (IBinder)localObject1);
            b.a(this.phI).put(localObject4, localObject1);
          }
          paramArrayOfObject[1] = ((IInterface)h.a(b.access$200() + "$Stub", "asInterface", h.b(new Class[] { IBinder.class }), new Object[] { localObject1 }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.c
 * JD-Core Version:    0.7.0.1
 */