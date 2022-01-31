package com.tencent.mm.plugin.normsg.b;

import android.os.Handler.Callback;
import android.os.IInterface;
import android.os.Message;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.Map;

final class b$b
  implements Handler.Callback
{
  private final WeakReference<Object> mHF;
  private final Handler.Callback mHG;
  
  b$b(b paramb, Object paramObject, Handler.Callback paramCallback)
  {
    this.mHF = new WeakReference(paramObject);
    this.mHG = paramCallback;
  }
  
  private boolean l(Message paramMessage)
  {
    if (this.mHG != null) {
      return this.mHG.handleMessage(paramMessage);
    }
    return false;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = this.mHF.get();
    if (localObject1 == null)
    {
      y.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
      return l(paramMessage);
    }
    for (;;)
    {
      try
      {
        localView = (View)h.b(localObject1, "getView", null, new Object[0]);
        if (localView == null)
        {
          y.e("MicroMsg.AED", "cannot find root view, give up intercepting.");
          return l(paramMessage);
        }
        switch (paramMessage.what)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        Integer localInteger;
        b.a(this.mHC, localThrowable);
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
      y.w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", new Object[] { Integer.valueOf(paramMessage.what) });
      return l(paramMessage);
      localObject1 = (IInterface)h.f(paramMessage.obj, "arg1");
      continue;
      localObject1 = (IInterface)h.f(paramMessage.obj, "arg2");
      continue;
      localObject1 = (IInterface)paramMessage.obj;
    }
    if ((Proxy.isProxyClass(localObject1.getClass())) && ((Proxy.getInvocationHandler(localObject1) instanceof b.e)))
    {
      y.w("MicroMsg.AED", "reused callback, skip rest works.");
      return l(paramMessage);
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
        localInteger = (Integer)b.c(this.mHC).remove(((IInterface)localObject1).asBinder());
        if (localInteger != null) {
          break label787;
        }
        y.w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", new Object[] { localObject1.getClass().getName() });
        return l(paramMessage);
        if (paramMessage.what != 1022) {
          break label1200;
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
            localView = (View)h.b(localView, b.bpe(), h.b(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(i) });
            break;
            i = ((Integer)h.f(paramMessage.obj, "argi1")).intValue();
            continue;
            i = paramMessage.arg2;
            continue;
            i = ((Integer)h.f(paramMessage.obj, "argi2")).intValue();
            continue;
            i = paramMessage.arg1;
          }
          i = ((Integer)h.f(paramMessage.obj, "argi3")).intValue();
          continue;
          i = ((Integer)h.f(paramMessage.obj, "argi1")).intValue();
          continue;
          i = paramMessage.arg2;
          continue;
          i = ((Integer)h.f(paramMessage.obj, "argi2")).intValue();
        }
      }
      label787:
      j = paramMessage.what;
      switch (j)
      {
      }
      for (;;)
      {
        return l(paramMessage);
        switch (paramMessage.what)
        {
        case 1: 
        case 1020: 
          while (!b.a(this.mHC, j, localInteger.intValue(), localView))
          {
            h.b(localObject1, b.bpf(), h.b(new Class[] { Boolean.TYPE, Integer.TYPE }), new Object[] { Boolean.valueOf(false), Integer.valueOf(i) });
            return true;
            j = ((Integer)h.f(paramMessage.obj, "argi2")).intValue();
          }
          localObject1 = (IInterface)Proxy.newProxyInstance(b.boZ(), localObject1.getClass().getInterfaces(), new b.b.1(this, (IInterface)localObject1, localInteger, localView));
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