package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import java.lang.reflect.Array;

public final class d<E>
{
  public int[] wEA;
  private final Class<? extends E> wEv;
  public int wEw;
  public E[] wEx;
  public int[] wEy;
  public int[] wEz;
  
  d(Class<? extends E> paramClass)
  {
    this.wEv = paramClass;
    this.wEw = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.wEv);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.wEx == null) || (this.wEx.length < i)))
    {
      this.wEx = ((Object[])Array.newInstance(this.wEv, i));
      this.wEy = new int[i];
      this.wEz = new int[i];
      this.wEA = new int[i];
    }
    this.wEw = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.wEx[this.wEw] = localObject;
        this.wEy[this.wEw] = j;
        this.wEz[this.wEw] = k;
        this.wEA[this.wEw] = m;
        this.wEw += 1;
      }
      paramInt += 1;
    }
  }
  
  public final E ga(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.wEw)
    {
      if ((this.wEy[i] < paramInt2) && (this.wEz[i] > paramInt1)) {
        return this.wEx[i];
      }
      i += 1;
    }
    return null;
  }
  
  public final boolean[] gb(int paramInt1, int paramInt2)
  {
    boolean[] arrayOfBoolean = new boolean[this.wEw];
    int i = 0;
    while (i < this.wEw)
    {
      if ((this.wEy[i] < paramInt2) && (this.wEz[i] > paramInt1)) {
        arrayOfBoolean[i] = true;
      }
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  public final E gc(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.wEw)
    {
      if ((this.wEy[i] == paramInt1) && (this.wEz[i] == paramInt2)) {
        return this.wEx[i];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */