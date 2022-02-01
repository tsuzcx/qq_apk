package com.google.android.gms.a;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class d<T>
  extends b
{
  private final T Nq;
  
  private d(T paramT)
  {
    this.Nq = paramT;
  }
  
  public static <T> a F(T paramT)
  {
    return new d(paramT);
  }
  
  public static <T> T a(a parama)
  {
    if ((parama instanceof d)) {
      return ((d)parama).Nq;
    }
    IBinder localIBinder = parama.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    parama = null;
    int k = arrayOfField.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      if (localField.isSynthetic()) {
        break label169;
      }
      j += 1;
      parama = localField;
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      if (j == 1)
      {
        if (!parama.isAccessible())
        {
          parama.setAccessible(true);
          try
          {
            parama = parama.get(localIBinder);
            return parama;
          }
          catch (NullPointerException parama)
          {
            throw new IllegalArgumentException("Binder object is null.", parama);
          }
          catch (IllegalAccessException parama)
          {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", parama);
          }
        }
        throw new IllegalArgumentException("IObjectWrapper declared field not private!");
      }
      i = arrayOfField.length;
      throw new IllegalArgumentException(64 + "Unexpected number of IObjectWrapper declared fields: " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.a.d
 * JD-Core Version:    0.7.0.1
 */