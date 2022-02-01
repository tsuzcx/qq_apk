package io.flutter.a.c;

import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class h$e
  implements InvocationHandler
{
  private final WindowManager Jcx;
  h.b Jcy;
  
  h$e(WindowManager paramWindowManager, h.b paramb)
  {
    this.Jcx = paramWindowManager;
    this.Jcy = paramb;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(9922);
    paramObject = paramMethod.getName();
    int i = -1;
    switch (paramObject.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      }
      try
      {
        paramObject = paramMethod.invoke(this.Jcx, paramArrayOfObject);
        AppMethodBeat.o(9922);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        paramObject = paramObject.getCause();
        AppMethodBeat.o(9922);
        throw paramObject;
      }
      if (paramObject.equals("addView"))
      {
        i = 0;
        continue;
        if (paramObject.equals("removeView"))
        {
          i = 1;
          continue;
          if (paramObject.equals("removeViewImmediate"))
          {
            i = 2;
            continue;
            if (paramObject.equals("updateViewLayout")) {
              i = 3;
            }
          }
        }
      }
    }
    if (this.Jcy != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
      this.Jcy.addView(paramObject, paramMethod);
    }
    AppMethodBeat.o(9922);
    return null;
    if (this.Jcy != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      this.Jcy.removeView(paramObject);
    }
    AppMethodBeat.o(9922);
    return null;
    if (this.Jcy != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      paramObject.clearAnimation();
      this.Jcy.removeView(paramObject);
    }
    AppMethodBeat.o(9922);
    return null;
    if (this.Jcy != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
      this.Jcy.updateViewLayout(paramObject, paramMethod);
    }
    AppMethodBeat.o(9922);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.a.c.h.e
 * JD-Core Version:    0.7.0.1
 */