package org.xwalk.core;

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
    init(null, paramClass, paramString);
  }
  
  public ReflectField(Object paramObject, String paramString)
  {
    init(paramObject, null, paramString);
  }
  
  public Object get()
  {
    if (this.mField == null) {
      throw new UnsupportedOperationException(toString());
    }
    try
    {
      Object localObject = this.mField.get(this.mInstance);
      return localObject;
    }
    catch (NullPointerException localNullPointerException)
    {
      throw new RejectedExecutionException(localNullPointerException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw localIllegalArgumentException;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      throw new RuntimeException(localExceptionInInitializerError);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label34:
      break label34;
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
      if (this.mField != null) {
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
    }
    return false;
  }
  
  public boolean isNull()
  {
    return this.mField == null;
  }
  
  public String toString()
  {
    Object localObject;
    if (this.mField != null) {
      localObject = this.mField.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.ReflectField
 * JD-Core Version:    0.7.0.1
 */