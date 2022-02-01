package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;

public final class dr<M extends dq<M>, T>
{
  protected final Class<T> Th;
  protected final boolean Ti;
  public final int tag;
  protected final int type;
  
  private int J(Object paramObject)
  {
    int i = dz.bZ(this.tag);
    switch (this.type)
    {
    default: 
      i = this.type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      return do.b(i, (dw)paramObject);
    }
    return do.c(i, (dw)paramObject);
  }
  
  private void b(Object paramObject, do paramdo)
  {
    for (;;)
    {
      try
      {
        paramdo.bR(this.tag);
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
      int i = dz.bZ(this.tag);
      paramObject.a(paramdo);
      paramdo.ae(i, 4);
      return;
      paramdo.b((dw)paramObject);
      return;
    }
  }
  
  final int I(Object paramObject)
  {
    if (this.Ti)
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
          k = i + J(Array.get(paramObject, j));
        }
        j += 1;
      }
    }
    int k = J(paramObject);
    return k;
  }
  
  final void a(Object paramObject, do paramdo)
  {
    if (this.Ti)
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
    } while ((this.type == paramObject.type) && (this.Th == paramObject.Th) && (this.tag == paramObject.tag) && (this.Ti == paramObject.Ti));
    return false;
  }
  
  public final int hashCode()
  {
    int j = this.type;
    int k = this.Th.hashCode();
    int m = this.tag;
    if (this.Ti) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dr
 * JD-Core Version:    0.7.0.1
 */