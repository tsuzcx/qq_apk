package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

public class ReflectMethod
{
  public static final String TAG = "ReflectMethod";
  protected Object[] mArguments;
  protected Class<?> mClass;
  protected Object mInstance;
  protected Method mMethod;
  protected String mName;
  protected Class<?>[] mParameterTypes;
  
  public ReflectMethod() {}
  
  public ReflectMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(154607);
    init(null, paramClass, paramString, paramVarArgs);
    AppMethodBeat.o(154607);
  }
  
  public ReflectMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(154606);
    init(paramObject, null, paramString, paramVarArgs);
    AppMethodBeat.o(154606);
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
    AppMethodBeat.i(154608);
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
      AppMethodBeat.o(154608);
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
      if (this.mMethod != null)
      {
        AppMethodBeat.o(154608);
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
          Log.e("ReflectMethod", "init error:".concat(String.valueOf(paramClass)));
          paramObject = paramObject.getSuperclass();
        }
      }
      AppMethodBeat.o(154608);
    }
    return false;
  }
  
  public Object invoke(Object... paramVarArgs)
  {
    AppMethodBeat.i(154609);
    if (this.mMethod == null)
    {
      paramVarArgs = new UnsupportedOperationException(toString());
      AppMethodBeat.o(154609);
      throw paramVarArgs;
    }
    try
    {
      paramVarArgs = this.mMethod.invoke(this.mInstance, paramVarArgs);
      AppMethodBeat.o(154609);
      return paramVarArgs;
    }
    catch (NullPointerException paramVarArgs)
    {
      paramVarArgs = new RejectedExecutionException(paramVarArgs);
      AppMethodBeat.o(154609);
      throw paramVarArgs;
    }
    catch (IllegalArgumentException paramVarArgs)
    {
      AppMethodBeat.o(154609);
      throw paramVarArgs;
    }
    catch (InvocationTargetException paramVarArgs)
    {
      paramVarArgs = new RuntimeException(paramVarArgs.getCause());
      AppMethodBeat.o(154609);
      throw paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      label52:
      break label52;
    }
  }
  
  public Object invokeWithArguments()
  {
    AppMethodBeat.i(154611);
    Object localObject = invoke(this.mArguments);
    AppMethodBeat.o(154611);
    return localObject;
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
    AppMethodBeat.i(154610);
    if (this.mMethod != null)
    {
      str1 = this.mMethod.toString();
      AppMethodBeat.o(154610);
      return str1;
    }
    String str1 = "";
    if (this.mClass != null) {
      str1 = "" + this.mClass.toString() + ".";
    }
    String str2 = str1;
    if (this.mName != null) {
      str2 = str1 + this.mName;
    }
    AppMethodBeat.o(154610);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.ReflectMethod
 * JD-Core Version:    0.7.0.1
 */