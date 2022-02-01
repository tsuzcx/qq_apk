package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E>
{
  private final Class<? extends E> JKD;
  public int JKE;
  public E[] JKF;
  public int[] JKG;
  public int[] JKH;
  public int[] JKI;
  
  e(Class<? extends E> paramClass)
  {
    this.JKD = paramClass;
    this.JKE = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    AppMethodBeat.i(39760);
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.JKD);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.JKF == null) || (this.JKF.length < i)))
    {
      this.JKF = ((Object[])Array.newInstance(this.JKD, i));
      this.JKG = new int[i];
      this.JKH = new int[i];
      this.JKI = new int[i];
    }
    this.JKE = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.JKF[this.JKE] = localObject;
        this.JKG[this.JKE] = j;
        this.JKH[this.JKE] = k;
        this.JKI[this.JKE] = m;
        this.JKE += 1;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(39760);
  }
  
  public final E ku(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.JKE)
    {
      if ((this.JKG[i] < paramInt2) && (this.JKH[i] > paramInt1)) {
        return this.JKF[i];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.e
 * JD-Core Version:    0.7.0.1
 */