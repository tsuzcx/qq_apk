package com.tencent.xweb.pinus.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.ReflectMethod;

public class WebResourceErrorInterfaceImpl
  implements WebResourceErrorInterface
{
  private static final String TAG = "WebResourceErrorInterfaceImpl";
  private ReflectMethod getDescriptionMethod;
  private ReflectMethod getErrorCodeMethod;
  private Object inner;
  
  public WebResourceErrorInterfaceImpl(Object paramObject)
  {
    this.inner = paramObject;
  }
  
  private ReflectMethod getGetDescriptionMethod()
  {
    try
    {
      AppMethodBeat.i(213436);
      ReflectMethod localReflectMethod2 = this.getDescriptionMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDescription", new Class[0]);
        this.getDescriptionMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213436);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetErrorCodeMethod()
  {
    try
    {
      AppMethodBeat.i(213428);
      ReflectMethod localReflectMethod2 = this.getErrorCodeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getErrorCode", new Class[0]);
        this.getErrorCodeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213428);
      return localReflectMethod1;
    }
    finally {}
  }
  
  public static void handleRuntimeError(Exception paramException) {}
  
  public CharSequence getDescription()
  {
    AppMethodBeat.i(213464);
    try
    {
      CharSequence localCharSequence = (CharSequence)getGetDescriptionMethod().invoke(new Object[0]);
      AppMethodBeat.o(213464);
      return localCharSequence;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public int getErrorCode()
  {
    AppMethodBeat.i(213454);
    try
    {
      i = ((Integer)getGetErrorCodeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(213454);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebResourceErrorInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */