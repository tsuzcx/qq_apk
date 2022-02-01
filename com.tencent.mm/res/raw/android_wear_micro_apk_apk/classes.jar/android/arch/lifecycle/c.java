package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class c
{
  final int C;
  final Method D;
  
  c(int paramInt, Method paramMethod)
  {
    this.C = paramInt;
    this.D = paramMethod;
    this.D.setAccessible(true);
  }
  
  final void b(i parami, f paramf, Object paramObject)
  {
    try
    {
      switch (this.C)
      {
      case 0: 
        this.D.invoke(paramObject, new Object[0]);
        return;
      }
    }
    catch (InvocationTargetException parami)
    {
      throw new RuntimeException("Failed to call observer method", parami.getCause());
      this.D.invoke(paramObject, new Object[] { parami });
      return;
    }
    catch (IllegalAccessException parami)
    {
      throw new RuntimeException(parami);
    }
    this.D.invoke(paramObject, new Object[] { parami, paramf });
    return;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (c)paramObject;
    } while ((this.C == paramObject.C) && (this.D.getName().equals(paramObject.D.getName())));
    return false;
  }
  
  public final int hashCode()
  {
    return this.C * 31 + this.D.getName().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.c
 * JD-Core Version:    0.7.0.1
 */