package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E>
{
  private final Class<? extends E> ahbP;
  public int ahbQ;
  public E[] ahbR;
  public int[] ahbS;
  public int[] ahbT;
  public int[] ahbU;
  
  e(Class<? extends E> paramClass)
  {
    this.ahbP = paramClass;
    this.ahbQ = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    AppMethodBeat.i(39760);
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.ahbP);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.ahbR == null) || (this.ahbR.length < i)))
    {
      this.ahbR = ((Object[])Array.newInstance(this.ahbP, i));
      this.ahbS = new int[i];
      this.ahbT = new int[i];
      this.ahbU = new int[i];
    }
    this.ahbQ = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.ahbR[this.ahbQ] = localObject;
        this.ahbS[this.ahbQ] = j;
        this.ahbT[this.ahbQ] = k;
        this.ahbU[this.ahbQ] = m;
        this.ahbQ += 1;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(39760);
  }
  
  public final E pD(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.ahbQ)
    {
      if ((this.ahbS[i] < paramInt2) && (this.ahbT[i] > paramInt1)) {
        return this.ahbR[i];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.e
 * JD-Core Version:    0.7.0.1
 */