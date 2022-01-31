package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E>
{
  private final Class<? extends E> BbZ;
  public int Bca;
  public E[] Bcb;
  public int[] Bcc;
  public int[] Bcd;
  public int[] Bce;
  
  e(Class<? extends E> paramClass)
  {
    this.BbZ = paramClass;
    this.Bca = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    AppMethodBeat.i(3258);
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.BbZ);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.Bcb == null) || (this.Bcb.length < i)))
    {
      this.Bcb = ((Object[])Array.newInstance(this.BbZ, i));
      this.Bcc = new int[i];
      this.Bcd = new int[i];
      this.Bce = new int[i];
    }
    this.Bca = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.Bcb[this.Bca] = localObject;
        this.Bcc[this.Bca] = j;
        this.Bcd[this.Bca] = k;
        this.Bce[this.Bca] = m;
        this.Bca += 1;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(3258);
  }
  
  public final E ik(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.Bca)
    {
      if ((this.Bcc[i] < paramInt2) && (this.Bcd[i] > paramInt1)) {
        return this.Bcb[i];
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