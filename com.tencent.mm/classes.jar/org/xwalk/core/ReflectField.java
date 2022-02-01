package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.concurrent.RejectedExecutionException;

public class ReflectField
{
  private Class<?> mClass;
  private Field mField;
  private Object mInstance;
  private String mName;
  
  public ReflectField() {}
  
  public ReflectField(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(157216);
    init(null, paramClass, paramString);
    AppMethodBeat.o(157216);
  }
  
  public ReflectField(Object paramObject, String paramString)
  {
    AppMethodBeat.i(157215);
    init(paramObject, null, paramString);
    AppMethodBeat.o(157215);
  }
  
  public Object get()
  {
    AppMethodBeat.i(157218);
    Object localObject;
    if (this.mField == null)
    {
      localObject = new UnsupportedOperationException(toString());
      AppMethodBeat.o(157218);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.mField.get(this.mInstance);
      AppMethodBeat.o(157218);
      return localObject;
    }
    catch (NullPointerException localNullPointerException)
    {
      RejectedExecutionException localRejectedExecutionException = new RejectedExecutionException(localNullPointerException);
      AppMethodBeat.o(157218);
      throw localRejectedExecutionException;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(157218);
      throw localIllegalArgumentException;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      RuntimeException localRuntimeException = new RuntimeException(localExceptionInInitializerError);
      AppMethodBeat.o(157218);
      throw localRuntimeException;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label51:
      break label51;
    }
  }
  
  public Object getInstance()
  {
    return this.mInstance;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean init(Object paramObject, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(157217);
    this.mInstance = paramObject;
    if (paramClass != null) {}
    for (;;)
    {
      this.mClass = paramClass;
      this.mName = paramString;
      this.mField = null;
      if (this.mClass != null) {
        break;
      }
      AppMethodBeat.o(157217);
      return false;
      if (paramObject != null) {
        paramClass = paramObject.getClass();
      } else {
        paramClass = null;
      }
    }
    try
    {
      this.mField = this.mClass.getField(this.mName);
      if (this.mField != null)
      {
        AppMethodBeat.o(157217);
        return true;
      }
    }
    catch (NoSuchFieldException paramObject)
    {
      paramObject = this.mClass;
      while (paramObject != null) {
        try
        {
          this.mField = paramObject.getDeclaredField(this.mName);
          this.mField.setAccessible(true);
        }
        catch (NoSuchFieldException paramClass)
        {
          paramObject = paramObject.getSuperclass();
        }
      }
      AppMethodBeat.o(157217);
    }
    return false;
  }
  
  public boolean isNull()
  {
    return this.mField == null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(157219);
    if (this.mField != null)
    {
      str1 = this.mField.toString();
      AppMethodBeat.o(157219);
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
    AppMethodBeat.o(157219);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.ReflectField
 * JD-Core Version:    0.7.0.1
 */