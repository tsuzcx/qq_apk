package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class b$c
  implements InvocationHandler
{
  WeakReference<b.b> jRb;
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(141604);
    if (this.jRb == null)
    {
      Log.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
      AppMethodBeat.o(141604);
      return null;
    }
    paramObject = (b.b)this.jRb.get();
    if (paramObject == null)
    {
      Log.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
      AppMethodBeat.o(141604);
      return null;
    }
    boolean bool1 = bool2;
    if (paramArrayOfObject != null)
    {
      bool1 = bool2;
      if (paramArrayOfObject.length > 0)
      {
        bool1 = bool2;
        if ((paramArrayOfObject[0] instanceof Boolean)) {
          bool1 = ((Boolean)paramArrayOfObject[0]).booleanValue();
        }
      }
    }
    paramObject.eG(bool1);
    AppMethodBeat.o(141604);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.b.c
 * JD-Core Version:    0.7.0.1
 */