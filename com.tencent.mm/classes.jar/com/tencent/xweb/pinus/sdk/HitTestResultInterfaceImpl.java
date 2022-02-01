package com.tencent.xweb.pinus.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.ReflectMethod;

public class HitTestResultInterfaceImpl
  implements HitTestResultInterface
{
  private static final String TAG = "HitTestResultInterfaceImpl";
  private ReflectMethod getExtraMethod;
  private ReflectMethod getTypeMethod;
  private Object inner;
  
  public HitTestResultInterfaceImpl(Object paramObject)
  {
    this.inner = paramObject;
  }
  
  private ReflectMethod getGetExtraMethod()
  {
    try
    {
      AppMethodBeat.i(213449);
      ReflectMethod localReflectMethod2 = this.getExtraMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getExtra", new Class[0]);
        this.getExtraMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213449);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetTypeMethod()
  {
    try
    {
      AppMethodBeat.i(213460);
      ReflectMethod localReflectMethod2 = this.getTypeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getType", new Class[0]);
        this.getTypeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213460);
      return localReflectMethod1;
    }
    finally {}
  }
  
  public static void handleRuntimeError(Exception paramException) {}
  
  public String getExtra()
  {
    AppMethodBeat.i(213473);
    try
    {
      String str = (String)getGetExtraMethod().invoke(new Object[0]);
      AppMethodBeat.o(213473);
      return str;
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
  
  public int getType()
  {
    AppMethodBeat.i(213482);
    try
    {
      i = ((Integer)getGetTypeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(213482);
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
 * Qualified Name:     com.tencent.xweb.pinus.sdk.HitTestResultInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */