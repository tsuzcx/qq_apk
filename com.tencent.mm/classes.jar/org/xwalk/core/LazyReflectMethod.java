package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class LazyReflectMethod
  extends ReflectMethod
{
  public static final String TAG = "LazyReflectMethod";
  private boolean mInited = false;
  
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
    AppMethodBeat.i(187720);
    if (this.mClass == null)
    {
      AppMethodBeat.o(187720);
      return false;
    }
    if ((this.mInited) && (this.mMethod != null))
    {
      AppMethodBeat.o(187720);
      return true;
    }
    try
    {
      if (this.mInited) {
        return true;
      }
      try
      {
        this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
        this.mInited = true;
        if (this.mMethod != null)
        {
          AppMethodBeat.o(187720);
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
            Log.e("LazyReflectMethod", "doInit error:" + localNoSuchMethodException2.getLocalizedMessage());
            localClass = localClass.getSuperclass();
          }
        }
      }
      AppMethodBeat.o(187720);
    }
    finally
    {
      AppMethodBeat.o(187720);
    }
    return false;
  }
  
  public boolean init(Object paramObject, Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(187710);
    this.mInstance = paramObject;
    if (paramClass != null) {}
    for (;;)
    {
      this.mClass = paramClass;
      this.mName = paramString;
      this.mParameterTypes = paramVarArgs;
      this.mMethod = null;
      this.mInited = false;
      AppMethodBeat.o(187710);
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
    AppMethodBeat.i(187725);
    doInit();
    paramVarArgs = super.invoke(paramVarArgs);
    AppMethodBeat.o(187725);
    return paramVarArgs;
  }
  
  public boolean isNull()
  {
    AppMethodBeat.i(187732);
    doInit();
    boolean bool = super.isNull();
    AppMethodBeat.o(187732);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.LazyReflectMethod
 * JD-Core Version:    0.7.0.1
 */