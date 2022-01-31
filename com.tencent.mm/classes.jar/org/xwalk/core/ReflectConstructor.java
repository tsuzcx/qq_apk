package org.xwalk.core;

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
    init(paramClass, paramVarArgs);
  }
  
  public boolean init(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    this.mClass = paramClass;
    this.mParameterTypes = paramVarArgs;
    this.mConstructor = null;
    if (this.mClass == null) {}
    for (;;)
    {
      return false;
      try
      {
        this.mConstructor = this.mClass.getConstructor(this.mParameterTypes);
        if (this.mConstructor == null) {
          continue;
        }
        return true;
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
      }
    }
  }
  
  public boolean isNull()
  {
    return this.mConstructor == null;
  }
  
  public Object newInstance(Object... paramVarArgs)
  {
    if (this.mConstructor == null) {
      throw new UnsupportedOperationException(toString());
    }
    try
    {
      paramVarArgs = this.mConstructor.newInstance(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw new RejectedExecutionException(paramVarArgs);
    }
    catch (InstantiationException paramVarArgs)
    {
      throw new RejectedExecutionException(paramVarArgs);
    }
    catch (IllegalArgumentException paramVarArgs)
    {
      throw paramVarArgs;
    }
    catch (InvocationTargetException paramVarArgs)
    {
      throw new RuntimeException(paramVarArgs.getCause());
    }
  }
  
  public String toString()
  {
    String str;
    if (this.mConstructor != null) {
      str = this.mConstructor.toString();
    }
    do
    {
      return str;
      str = "";
    } while (this.mClass == null);
    return "" + this.mClass.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.ReflectConstructor
 * JD-Core Version:    0.7.0.1
 */