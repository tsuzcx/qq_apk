package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class LazyReflectMethod
  extends ReflectMethod
{
  boolean mInited = false;
  
  public LazyReflectMethod() {}
  
  public LazyReflectMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    super(paramClass, paramString, paramVarArgs);
  }
  
  public LazyReflectMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    super(paramObject, paramString, paramVarArgs);
  }
  
  protected boolean doInit()
  {
    AppMethodBeat.i(205044);
    if (this.mClass == null)
    {
      AppMethodBeat.o(205044);
      return false;
    }
    boolean bool;
    if ((this.mInited) && (this.mMethod != null))
    {
      bool = this.mInited;
      AppMethodBeat.o(205044);
      return bool;
    }
    try
    {
      if (this.mInited)
      {
        bool = this.mInited;
        return bool;
      }
      try
      {
        this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
        this.mInited = true;
        if (this.mMethod != null)
        {
          AppMethodBeat.o(205044);
          return true;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Class localClass = this.mClass;
        while (localClass != null) {
          try
          {
            this.mMethod = localClass.getDeclaredMethod(this.mName, this.mParameterTypes);
            this.mMethod.setAccessible(true);
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            localClass = localClass.getSuperclass();
          }
        }
      }
      AppMethodBeat.o(205044);
    }
    finally
    {
      AppMethodBeat.o(205044);
    }
    return false;
  }
  
  public boolean init(Object paramObject, Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(205043);
    this.mInstance = paramObject;
    if (paramClass != null) {}
    for (;;)
    {
      this.mClass = paramClass;
      this.mName = paramString;
      this.mParameterTypes = paramVarArgs;
      this.mMethod = null;
      this.mInited = false;
      AppMethodBeat.o(205043);
      return true;
      if (paramObject != null) {
        paramClass = paramObject.getClass();
      } else {
        paramClass = null;
      }
    }
  }
  
  public Object invoke(Object... paramVarArgs)
  {
    AppMethodBeat.i(205045);
    doInit();
    paramVarArgs = super.invoke(paramVarArgs);
    AppMethodBeat.o(205045);
    return paramVarArgs;
  }
  
  public boolean isNull()
  {
    AppMethodBeat.i(205046);
    doInit();
    boolean bool = super.isNull();
    AppMethodBeat.o(205046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.LazyReflectMethod
 * JD-Core Version:    0.7.0.1
 */