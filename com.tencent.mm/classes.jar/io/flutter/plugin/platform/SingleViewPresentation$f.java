package io.flutter.plugin.platform;

import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class SingleViewPresentation$f
  implements InvocationHandler
{
  private final WindowManager STH;
  SingleViewPresentation.b STI;
  
  SingleViewPresentation$f(WindowManager paramWindowManager, SingleViewPresentation.b paramb)
  {
    this.STH = paramWindowManager;
    this.STI = paramb;
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
        paramObject = paramMethod.invoke(this.STH, paramArrayOfObject);
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
    if (this.STI != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
      this.STI.addView(paramObject, paramMethod);
    }
    AppMethodBeat.o(9922);
    return null;
    if (this.STI != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      this.STI.removeView(paramObject);
    }
    AppMethodBeat.o(9922);
    return null;
    if (this.STI != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      paramObject.clearAnimation();
      this.STI.removeView(paramObject);
    }
    AppMethodBeat.o(9922);
    return null;
    if (this.STI != null)
    {
      paramObject = (View)paramArrayOfObject[0];
      paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
      this.STI.updateViewLayout(paramObject, paramMethod);
    }
    AppMethodBeat.o(9922);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.f
 * JD-Core Version:    0.7.0.1
 */