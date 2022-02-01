package com.tencent.mm.ui.widget.cedit.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class a<T>
{
  private Object agcE;
  private Method mMethod;
  
  public a(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(252113);
    this.agcE = paramObject;
    paramObject = paramObject.getClass();
    for (;;)
    {
      if (paramObject != Object.class) {}
      try
      {
        this.mMethod = paramObject.getDeclaredMethod(paramString, paramVarArgs);
        label35:
        paramObject = paramObject.getSuperclass();
        continue;
        if (this.mMethod == null) {
          new Throwable("MB ".concat(String.valueOf(paramString)));
        }
        AppMethodBeat.o(252113);
        return;
      }
      finally
      {
        break label35;
      }
    }
  }
  
  public a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(252123);
    try
    {
      paramString1 = Class.forName(paramString1);
      this.agcE = null;
      if (paramString1 == Object.class) {}
    }
    finally
    {
      try
      {
        for (;;)
        {
          this.mMethod = paramString1.getDeclaredMethod(paramString2, paramVarArgs);
          label35:
          paramString1 = paramString1.getSuperclass();
          continue;
          paramString1 = finally;
          paramString1 = null;
        }
        AppMethodBeat.o(252123);
        return;
      }
      finally
      {
        break label35;
      }
    }
  }
  
  public final T invoke(Object... paramVarArgs)
  {
    AppMethodBeat.i(252130);
    try
    {
      this.mMethod.setAccessible(true);
      paramVarArgs = this.mMethod.invoke(this.agcE, paramVarArgs);
      return paramVarArgs;
    }
    finally
    {
      AppMethodBeat.o(252130);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.a
 * JD-Core Version:    0.7.0.1
 */