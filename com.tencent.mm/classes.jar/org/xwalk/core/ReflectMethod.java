package org.xwalk.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

public class ReflectMethod
{
  private Object[] mArguments;
  private Class<?> mClass;
  private Object mInstance;
  private Method mMethod;
  private String mName;
  private Class<?>[] mParameterTypes;
  
  public ReflectMethod() {}
  
  public ReflectMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    init(null, paramClass, paramString, paramVarArgs);
  }
  
  public ReflectMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    init(paramObject, null, paramString, paramVarArgs);
  }
  
  public Object[] getArguments()
  {
    return this.mArguments;
  }
  
  public Object getInstance()
  {
    return this.mInstance;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean init(Object paramObject, Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    this.mInstance = paramObject;
    if (paramClass != null) {}
    for (;;)
    {
      this.mClass = paramClass;
      this.mName = paramString;
      this.mParameterTypes = paramVarArgs;
      this.mMethod = null;
      if (this.mClass != null) {
        break;
      }
      return false;
      if (paramObject != null) {
        paramClass = paramObject.getClass();
      } else {
        paramClass = null;
      }
    }
    try
    {
      this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
      if (this.mMethod != null) {
        return true;
      }
    }
    catch (NoSuchMethodException paramObject)
    {
      paramObject = this.mClass;
      while (paramObject != null) {
        try
        {
          this.mMethod = paramObject.getDeclaredMethod(this.mName, this.mParameterTypes);
          this.mMethod.setAccessible(true);
        }
        catch (NoSuchMethodException paramClass)
        {
          paramObject = paramObject.getSuperclass();
        }
      }
    }
    return false;
  }
  
  public Object invoke(Object... paramVarArgs)
  {
    if (this.mMethod == null) {
      throw new UnsupportedOperationException(toString());
    }
    try
    {
      paramVarArgs = this.mMethod.invoke(this.mInstance, paramVarArgs);
      return paramVarArgs;
    }
    catch (NullPointerException paramVarArgs)
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
    catch (IllegalAccessException paramVarArgs)
    {
      label35:
      break label35;
    }
  }
  
  public Object invokeWithArguments()
  {
    return invoke(this.mArguments);
  }
  
  public boolean isNull()
  {
    return this.mMethod == null;
  }
  
  public void setArguments(Object... paramVarArgs)
  {
    this.mArguments = paramVarArgs;
  }
  
  public String toString()
  {
    Object localObject;
    if (this.mMethod != null) {
      localObject = this.mMethod.toString();
    }
    String str;
    do
    {
      return localObject;
      str = "";
      if (this.mClass != null) {
        str = "" + this.mClass.toString() + ".";
      }
      localObject = str;
    } while (this.mName == null);
    return str + this.mName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.xwalk.core.ReflectMethod
 * JD-Core Version:    0.7.0.1
 */