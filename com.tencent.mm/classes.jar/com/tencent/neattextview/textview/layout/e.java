package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E>
{
  private final Class<? extends E> LEm;
  public int LEn;
  public E[] LEo;
  public int[] LEp;
  public int[] LEq;
  public int[] LEr;
  
  e(Class<? extends E> paramClass)
  {
    this.LEm = paramClass;
    this.LEn = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    AppMethodBeat.i(39760);
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.LEm);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.LEo == null) || (this.LEo.length < i)))
    {
      this.LEo = ((Object[])Array.newInstance(this.LEm, i));
      this.LEp = new int[i];
      this.LEq = new int[i];
      this.LEr = new int[i];
    }
    this.LEn = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.LEo[this.LEn] = localObject;
        this.LEp[this.LEn] = j;
        this.LEq[this.LEn] = k;
        this.LEr[this.LEn] = m;
        this.LEn += 1;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(39760);
  }
  
  public final E kJ(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.LEn)
    {
      if ((this.LEp[i] < paramInt2) && (this.LEq[i] > paramInt1)) {
        return this.LEo[i];
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