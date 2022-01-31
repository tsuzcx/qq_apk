package com.tencent.mm.plugin.normsg.b;

import android.os.Handler.Callback;
import android.os.IInterface;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.Map;

final class b$b
  implements Handler.Callback
{
  private final WeakReference<Object> phL;
  private final Handler.Callback phM;
  
  b$b(b paramb, Object paramObject, Handler.Callback paramCallback)
  {
    AppMethodBeat.i(10395);
    this.phL = new WeakReference(paramObject);
    this.phM = paramCallback;
    AppMethodBeat.o(10395);
  }
  
  private boolean r(Message paramMessage)
  {
    AppMethodBeat.i(10397);
    if (this.phM != null)
    {
      boolean bool = this.phM.handleMessage(paramMessage);
      AppMethodBeat.o(10397);
      return bool;
    }
    AppMethodBeat.o(10397);
    return false;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(10396);
    Object localObject1 = this.phL.get();
    boolean bool;
    if (localObject1 == null)
    {
      ab.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
      bool = r(paramMessage);
      AppMethodBeat.o(10396);
      return bool;
    }
    for (;;)
    {
      try
      {
        localView = (View)h.b(localObject1, "getView", null, new Object[0]);
        if (localView == null)
        {
          ab.e("MicroMsg.AED", "cannot find root view, give up intercepting.");
          bool = r(paramMessage);
          AppMethodBeat.o(10396);
          return bool;
        }
        switch (paramMessage.what)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        Integer localInteger;
        b.a(this.phI, localThrowable);
        continue;
        h.b(paramMessage.obj, "arg2", localThrowable);
        continue;
        paramMessage.obj = localThrowable;
        continue;
        Object localObject2 = null;
        continue;
        View localView = null;
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        int j = 0;
        continue;
        continue;
      }
      if (localObject1 != null) {
        continue;
      }
      ab.w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", new Object[] { Integer.valueOf(paramMessage.what) });
      bool = r(paramMessage);
      AppMethodBeat.o(10396);
      return bool;
      localObject1 = (IInterface)h.g(paramMessage.obj, "arg1");
      continue;
      localObject1 = (IInterface)h.g(paramMessage.obj, "arg2");
      continue;
      localObject1 = (IInterface)paramMessage.obj;
    }
    if ((Proxy.isProxyClass(localObject1.getClass())) && ((Proxy.getInvocationHandler(localObject1) instanceof b.e)))
    {
      ab.w("MicroMsg.AED", "reused callback, skip rest works.");
      bool = r(paramMessage);
      AppMethodBeat.o(10396);
      return bool;
    }
    switch (paramMessage.what)
    {
    case 1022: 
      switch (paramMessage.what)
      {
      }
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 1020: 
    case 1021: 
    case 1023: 
      for (;;)
      {
        localInteger = (Integer)b.c(this.phI).remove(((IInterface)localObject1).asBinder());
        if (localInteger != null) {
          break label847;
        }
        ab.w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", new Object[] { localObject1.getClass().getName() });
        bool = r(paramMessage);
        AppMethodBeat.o(10396);
        return bool;
        if (paramMessage.what != 1022) {
          break label1276;
        }
        i = paramMessage.arg1;
        localView = localView.findViewById(i);
        break;
        switch (paramMessage.what)
        {
        case 2: 
        case 4: 
        case 1020: 
        case 1023: 
        case 1: 
        case 3: 
        case 6: 
        case 5: 
        case 1021: 
          for (;;)
          {
            localView = (View)h.b(localView, b.bXH(), h.b(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(i) });
            break;
            i = ((Integer)h.g(paramMessage.obj, "argi1")).intValue();
            continue;
            i = paramMessage.arg2;
            continue;
            i = ((Integer)h.g(paramMessage.obj, "argi2")).intValue();
            continue;
            i = paramMessage.arg1;
          }
          i = ((Integer)h.g(paramMessage.obj, "argi3")).intValue();
          continue;
          i = ((Integer)h.g(paramMessage.obj, "argi1")).intValue();
          continue;
          i = paramMessage.arg2;
          continue;
          i = ((Integer)h.g(paramMessage.obj, "argi2")).intValue();
        }
      }
      label847:
      j = paramMessage.what;
      switch (j)
      {
      }
      for (;;)
      {
        bool = r(paramMessage);
        AppMethodBeat.o(10396);
        return bool;
        switch (paramMessage.what)
        {
        case 1: 
        case 1020: 
          while (!b.a(this.phI, j, localInteger.intValue(), localView))
          {
            h.b(localObject1, b.bXI(), h.b(new Class[] { Boolean.TYPE, Integer.TYPE }), new Object[] { Boolean.FALSE, Integer.valueOf(i) });
            AppMethodBeat.o(10396);
            return true;
            j = ((Integer)h.g(paramMessage.obj, "argi2")).intValue();
          }
          localObject1 = (IInterface)Proxy.newProxyInstance(b.bXB(), localObject1.getClass().getInterfaces(), new b.b.1(this, (IInterface)localObject1, localInteger, localView));
          switch (paramMessage.what)
          {
          case 1: 
          case 2: 
          case 3: 
          case 5: 
          case 6: 
          case 1020: 
            h.b(paramMessage.obj, "arg1", localObject1);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.b
 * JD-Core Version:    0.7.0.1
 */