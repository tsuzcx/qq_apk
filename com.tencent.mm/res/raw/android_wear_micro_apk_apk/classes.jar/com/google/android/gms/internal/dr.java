package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;

public final class dr<M extends dq<M>, T>
{
  protected final Class<T> Rs;
  protected final boolean Rt;
  public final int tag;
  protected final int type;
  
  private int A(Object paramObject)
  {
    int i = dz.bE(this.tag);
    switch (this.type)
    {
    default: 
      i = this.type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      paramObject = (dw)paramObject;
      return do.bw(i) * 2 + paramObject.kj();
    }
    return do.b(i, (dw)paramObject);
  }
  
  private void b(Object paramObject, do paramdo)
  {
    for (;;)
    {
      try
      {
        paramdo.bx(this.tag);
        switch (this.type)
        {
        case 10: 
          i = this.type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramObject = (dw)paramObject;
      int i = dz.bE(this.tag);
      paramObject.a(paramdo);
      paramdo.ac(i, 4);
      return;
      paramdo.b((dw)paramObject);
      return;
    }
  }
  
  final void a(Object paramObject, do paramdo)
  {
    if (this.Rt)
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        Object localObject = Array.get(paramObject, i);
        if (localObject != null) {
          b(localObject, paramdo);
        }
        i += 1;
      }
    }
    b(paramObject, paramdo);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof dr)) {
        return false;
      }
      paramObject = (dr)paramObject;
    } while ((this.type == paramObject.type) && (this.Rs == paramObject.Rs) && (this.tag == paramObject.tag) && (this.Rt == paramObject.Rt));
    return false;
  }
  
  public final int hashCode()
  {
    int j = this.type;
    int k = this.Rs.hashCode();
    int m = this.tag;
    if (this.Rt) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
  
  final int z(Object paramObject)
  {
    if (this.Rt)
    {
      int m = Array.getLength(paramObject);
      int j = 0;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = i;
        if (Array.get(paramObject, j) != null) {
          k = i + A(Array.get(paramObject, j));
        }
        j += 1;
      }
    }
    int k = A(paramObject);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dr
 * JD-Core Version:    0.7.0.1
 */