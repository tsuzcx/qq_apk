package com.google.android.gms.internal;

public final class ds
  implements Cloneable
{
  private static final dt Ru = new dt();
  private boolean Rv = false;
  private int[] Rw;
  private dt[] Rx;
  private int e;
  
  ds()
  {
    this(10);
  }
  
  private ds(int paramInt)
  {
    paramInt = r(paramInt);
    this.Rw = new int[paramInt];
    this.Rx = new dt[paramInt];
    this.e = 0;
  }
  
  private int bC(int paramInt)
  {
    int i = 0;
    int j = this.e - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.Rw[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (m <= paramInt) {
          return j;
        }
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    return j;
  }
  
  private static int r(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  final void a(int paramInt, dt paramdt)
  {
    int i = bC(paramInt);
    if (i >= 0)
    {
      this.Rx[i] = paramdt;
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < this.e) && (this.Rx[i] == Ru))
    {
      this.Rw[i] = paramInt;
      this.Rx[i] = paramdt;
      return;
    }
    if (this.e >= this.Rw.length)
    {
      int j = r(this.e + 1);
      int[] arrayOfInt = new int[j];
      dt[] arrayOfdt = new dt[j];
      System.arraycopy(this.Rw, 0, arrayOfInt, 0, this.Rw.length);
      System.arraycopy(this.Rx, 0, arrayOfdt, 0, this.Rx.length);
      this.Rw = arrayOfInt;
      this.Rx = arrayOfdt;
    }
    if (this.e - i != 0)
    {
      System.arraycopy(this.Rw, i, this.Rw, i + 1, this.e - i);
      System.arraycopy(this.Rx, i, this.Rx, i + 1, this.e - i);
    }
    this.Rw[i] = paramInt;
    this.Rx[i] = paramdt;
    this.e += 1;
  }
  
  final dt bA(int paramInt)
  {
    paramInt = bC(paramInt);
    if ((paramInt < 0) || (this.Rx[paramInt] == Ru)) {
      return null;
    }
    return this.Rx[paramInt];
  }
  
  final dt bB(int paramInt)
  {
    return this.Rx[paramInt];
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
      if (this.e != paramObject.e) {
        return false;
      }
      Object localObject = this.Rw;
      int[] arrayOfInt = paramObject.Rw;
      int j = this.e;
      int i = 0;
      if (i < j) {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          label71:
          if (i != 0)
          {
            localObject = this.Rx;
            paramObject = paramObject.Rx;
            j = this.e;
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
    while (i < this.e)
    {
      j = (j * 31 + this.Rw[i]) * 31 + this.Rx[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return this.e == 0;
  }
  
  final int size()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ds
 * JD-Core Version:    0.7.0.1
 */