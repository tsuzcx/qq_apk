package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.RejectedExecutionException;

class ReflectConstructor
{
  private Class<?> mClass;
  private Constructor<?> mConstructor;
  private Class<?>[] mParameterTypes;
  
  public ReflectConstructor() {}
  
  public ReflectConstructor(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(154602);
    init(paramClass, paramVarArgs);
    AppMethodBeat.o(154602);
  }
  
  public boolean init(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(154603);
    this.mClass = paramClass;
    this.mParameterTypes = paramVarArgs;
    this.mConstructor = null;
    if (this.mClass == null)
    {
      AppMethodBeat.o(154603);
      return false;
    }
    try
    {
      this.mConstructor = this.mClass.getConstructor(this.mParameterTypes);
      if (this.mConstructor != null)
      {
        AppMethodBeat.o(154603);
        return true;
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        try
        {
          this.mConstructor = this.mClass.getDeclaredConstructor(this.mParameterTypes);
          this.mConstructor.setAccessible(true);
        }
        catch (NoSuchMethodException paramClass) {}
      }
      AppMethodBeat.o(154603);
    }
    return false;
  }
  
  public boolean isNull()
  {
    return this.mConstructor == null;
  }
  
  public Object newInstance(Object... paramVarArgs)
  {
    AppMethodBeat.i(154604);
    if (this.mConstructor == null)
    {
      paramVarArgs = new UnsupportedOperationException(toString());
      AppMethodBeat.o(154604);
      throw paramVarArgs;
    }
    try
    {
      paramVarArgs = this.mConstructor.newInstance(paramVarArgs);
      AppMethodBeat.o(154604);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      paramVarArgs = new RejectedExecutionException(paramVarArgs);
      AppMethodBeat.o(154604);
      throw paramVarArgs;
    }
    catch (InstantiationException paramVarArgs)
    {
      paramVarArgs = new RejectedExecutionException(paramVarArgs);
      AppMethodBeat.o(154604);
      throw paramVarArgs;
    }
    catch (IllegalArgumentException paramVarArgs)
    {
      AppMethodBeat.o(154604);
      throw paramVarArgs;
    }
    catch (InvocationTargetException paramVarArgs)
    {
      paramVarArgs = new RuntimeException(paramVarArgs.getCause());
      AppMethodBeat.o(154604);
      throw paramVarArgs;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(154605);
    if (this.mConstructor != null)
    {
      str = this.mConstructor.toString();
      AppMethodBeat.o(154605);
      return str;
    }
    String str = "";
    if (this.mClass != null) {
      str = "" + this.mClass.toString();
    }
    AppMethodBeat.o(154605);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.ReflectConstructor
 * JD-Core Version:    0.7.0.1
 */