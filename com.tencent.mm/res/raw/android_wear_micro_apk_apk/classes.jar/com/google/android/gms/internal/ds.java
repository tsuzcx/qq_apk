package com.google.android.gms.internal;

public final class ds
  implements Cloneable
{
  private static final dt Tj = new dt();
  private boolean Tk = false;
  private int[] Tl;
  private dt[] Tm;
  private int m;
  
  ds()
  {
    this(10);
  }
  
  private ds(int paramInt)
  {
    paramInt = B(paramInt);
    this.Tl = new int[paramInt];
    this.Tm = new dt[paramInt];
    this.m = 0;
  }
  
  private static int B(int paramInt)
  {
    return bW(paramInt * 4) / 4;
  }
  
  private static int bW(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int bX(int paramInt)
  {
    int i = 0;
    int j = this.m - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int n = this.Tl[k];
      if (n < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (n <= paramInt) {
          return j;
        }
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    return j;
  }
  
  final void a(int paramInt, dt paramdt)
  {
    int i = bX(paramInt);
    if (i >= 0)
    {
      this.Tm[i] = paramdt;
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < this.m) && (this.Tm[i] == Tj))
    {
      this.Tl[i] = paramInt;
      this.Tm[i] = paramdt;
      return;
    }
    Object localObject;
    if (this.m >= this.Tl.length)
    {
      int j = B(this.m + 1);
      localObject = new int[j];
      dt[] arrayOfdt = new dt[j];
      System.arraycopy(this.Tl, 0, localObject, 0, this.Tl.length);
      System.arraycopy(this.Tm, 0, arrayOfdt, 0, this.Tm.length);
      this.Tl = ((int[])localObject);
      this.Tm = arrayOfdt;
    }
    if (this.m - i != 0)
    {
      localObject = this.Tl;
      System.arraycopy(localObject, i, localObject, i + 1, this.m - i);
      localObject = this.Tm;
      System.arraycopy(localObject, i, localObject, i + 1, this.m - i);
    }
    this.Tl[i] = paramInt;
    this.Tm[i] = paramdt;
    this.m += 1;
  }
  
  final dt bU(int paramInt)
  {
    paramInt = bX(paramInt);
    if ((paramInt < 0) || (this.Tm[paramInt] == Tj)) {
      return null;
    }
    return this.Tm[paramInt];
  }
  
  final dt bV(int paramInt)
  {
    return this.Tm[paramInt];
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    label131:
    label138:
    label141:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof ds)) {
        return false;
      }
      paramObject = (ds)paramObject;
      if (this.m != paramObject.m) {
        return false;
      }
      Object localObject = this.Tl;
      int[] arrayOfInt = paramObject.Tl;
      int j = this.m;
      int i = 0;
      if (i < j) {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          label71:
          if (i != 0)
          {
            localObject = this.Tm;
            paramObject = paramObject.Tm;
            j = this.m;
            i = 0;
            label93:
            if (i >= j) {
              break label138;
            }
            if (localObject[i].equals(paramObject[i])) {
              break label131;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label141;
        }
        return false;
        i += 1;
        break;
        i = 1;
        break label71;
        i += 1;
        break label93;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 17;
    int i = 0;
    while (i < this.m)
    {
      j = (j * 31 + this.Tl[i]) * 31 + this.Tm[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return this.m == 0;
  }
  
  final int size()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ds
 * JD-Core Version:    0.7.0.1
 */