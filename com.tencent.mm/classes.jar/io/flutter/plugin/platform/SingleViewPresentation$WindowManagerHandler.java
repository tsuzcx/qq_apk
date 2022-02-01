package io.flutter.plugin.platform;

import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class SingleViewPresentation$WindowManagerHandler
  implements InvocationHandler
{
  private static final String TAG = "PlatformViewsController";
  private final WindowManager delegate;
  SingleViewPresentation.FakeWindowViewGroup fakeWindowRootView;
  
  SingleViewPresentation$WindowManagerHandler(WindowManager paramWindowManager, SingleViewPresentation.FakeWindowViewGroup paramFakeWindowViewGroup)
  {
    this.delegate = paramWindowManager;
    this.fakeWindowRootView = paramFakeWindowViewGroup;
  }
  
  private void addView(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(189912);
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
      AppMethodBeat.o(189912);
      return;
    }
    View localView = (View)paramArrayOfObject[0];
    paramArrayOfObject = (WindowManager.LayoutParams)paramArrayOfObject[1];
    this.fakeWindowRootView.addView(localView, paramArrayOfObject);
    AppMethodBeat.o(189912);
  }
  
  private void removeView(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(189919);
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
      AppMethodBeat.o(189919);
      return;
    }
    paramArrayOfObject = (View)paramArrayOfObject[0];
    this.fakeWindowRootView.removeView(paramArrayOfObject);
    AppMethodBeat.o(189919);
  }
  
  private void removeViewImmediate(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(189929);
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
      AppMethodBeat.o(189929);
      return;
    }
    paramArrayOfObject = (View)paramArrayOfObject[0];
    paramArrayOfObject.clearAnimation();
    this.fakeWindowRootView.removeView(paramArrayOfObject);
    AppMethodBeat.o(189929);
  }
  
  private void updateViewLayout(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(189941);
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
      AppMethodBeat.o(189941);
      return;
    }
    View localView = (View)paramArrayOfObject[0];
    paramArrayOfObject = (WindowManager.LayoutParams)paramArrayOfObject[1];
    this.fakeWindowRootView.updateViewLayout(localView, paramArrayOfObject);
    AppMethodBeat.o(189941);
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(189947);
    WindowManager localWindowManager = (WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, this);
    AppMethodBeat.o(189947);
    return localWindowManager;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
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
        paramObject = paramMethod.invoke(this.delegate, paramArrayOfObject);
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
    addView(paramArrayOfObject);
    AppMethodBeat.o(9922);
    return null;
    removeView(paramArrayOfObject);
    AppMethodBeat.o(9922);
    return null;
    removeViewImmediate(paramArrayOfObject);
    AppMethodBeat.o(9922);
    return null;
    updateViewLayout(paramArrayOfObject);
    AppMethodBeat.o(9922);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.WindowManagerHandler
 * JD-Core Version:    0.7.0.1
 */