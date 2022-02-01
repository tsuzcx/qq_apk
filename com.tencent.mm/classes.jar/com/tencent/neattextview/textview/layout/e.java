package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E>
{
  private final Class<? extends E> IiS;
  public int IiT;
  public E[] IiU;
  public int[] IiV;
  public int[] IiW;
  public int[] IiX;
  
  e(Class<? extends E> paramClass)
  {
    this.IiS = paramClass;
    this.IiT = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    AppMethodBeat.i(39760);
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.IiS);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.IiU == null) || (this.IiU.length < i)))
    {
      this.IiU = ((Object[])Array.newInstance(this.IiS, i));
      this.IiV = new int[i];
      this.IiW = new int[i];
      this.IiX = new int[i];
    }
    this.IiT = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.IiU[this.IiT] = localObject;
        this.IiV[this.IiT] = j;
        this.IiW[this.IiT] = k;
        this.IiX[this.IiT] = m;
        this.IiT += 1;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(39760);
  }
  
  public final E kh(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.IiT)
    {
      if ((this.IiV[i] < paramInt2) && (this.IiW[i] > paramInt1)) {
        return this.IiU[i];
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