package com.tencent.mm.ui.indicator;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int afwa;
  private int afwb;
  private int[] afwc;
  private int[] afwd;
  private int count;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249700);
    this.afwa = paramInt1;
    this.afwb = paramInt2;
    this.count = 100;
    this.afwc = aDW(paramInt1);
    this.afwd = aDW(paramInt2);
    AppMethodBeat.o(249700);
  }
  
  private static int[] aDW(int paramInt)
  {
    AppMethodBeat.i(249704);
    int i = Color.alpha(paramInt);
    int j = Color.red(paramInt);
    int k = Color.green(paramInt);
    paramInt = Color.blue(paramInt);
    AppMethodBeat.o(249704);
    return new int[] { i, j, k, paramInt };
  }
  
  public final int getColor(int paramInt)
  {
    AppMethodBeat.i(249710);
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < this.afwd.length)
    {
      arrayOfInt[i] = ((int)(this.afwc[i] + (this.afwd[i] - this.afwc[i]) * 1.0D / this.count * paramInt));
      i += 1;
    }
    paramInt = Color.argb(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    AppMethodBeat.o(249710);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.indicator.a
 * JD-Core Version:    0.7.0.1
 */