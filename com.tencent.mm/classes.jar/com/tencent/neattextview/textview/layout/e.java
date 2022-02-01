package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E>
{
  private final Class<? extends E> Mbq;
  public int Mbr;
  public E[] Mbs;
  public int[] Mbt;
  public int[] Mbu;
  public int[] Mbv;
  
  e(Class<? extends E> paramClass)
  {
    this.Mbq = paramClass;
    this.Mbr = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    AppMethodBeat.i(39760);
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.Mbq);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.Mbs == null) || (this.Mbs.length < i)))
    {
      this.Mbs = ((Object[])Array.newInstance(this.Mbq, i));
      this.Mbt = new int[i];
      this.Mbu = new int[i];
      this.Mbv = new int[i];
    }
    this.Mbr = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.Mbs[this.Mbr] = localObject;
        this.Mbt[this.Mbr] = j;
        this.Mbu[this.Mbr] = k;
        this.Mbv[this.Mbr] = m;
        this.Mbr += 1;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(39760);
  }
  
  public final E kQ(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.Mbr)
    {
      if ((this.Mbt[i] < paramInt2) && (this.Mbu[i] > paramInt1)) {
        return this.Mbs[i];
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