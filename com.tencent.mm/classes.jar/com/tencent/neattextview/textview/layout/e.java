package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E>
{
  private final Class<? extends E> Zdl;
  public int Zdm;
  public E[] Zdn;
  public int[] Zdo;
  public int[] Zdp;
  public int[] Zdq;
  
  e(Class<? extends E> paramClass)
  {
    this.Zdl = paramClass;
    this.Zdm = 0;
  }
  
  public final void a(Spanned paramSpanned, int paramInt)
  {
    AppMethodBeat.i(39760);
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramInt, this.Zdl);
    int i = arrayOfObject.length;
    if ((i > 0) && ((this.Zdn == null) || (this.Zdn.length < i)))
    {
      this.Zdn = ((Object[])Array.newInstance(this.Zdl, i));
      this.Zdo = new int[i];
      this.Zdp = new int[i];
      this.Zdq = new int[i];
    }
    this.Zdm = 0;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if (j != k)
      {
        int m = paramSpanned.getSpanFlags(localObject);
        this.Zdn[this.Zdm] = localObject;
        this.Zdo[this.Zdm] = j;
        this.Zdp[this.Zdm] = k;
        this.Zdq[this.Zdm] = m;
        this.Zdm += 1;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(39760);
  }
  
  public final E nG(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.Zdm)
    {
      if ((this.Zdo[i] < paramInt2) && (this.Zdp[i] > paramInt1)) {
        return this.Zdn[i];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.e
 * JD-Core Version:    0.7.0.1
 */