package com.tencent.mm.ui.indicator;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int XIu;
  private int XIv;
  private int[] XIw;
  private int[] XIx;
  private int count;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218717);
    this.XIu = paramInt1;
    this.XIv = paramInt2;
    this.count = 100;
    this.XIw = axm(paramInt1);
    this.XIx = axm(paramInt2);
    AppMethodBeat.o(218717);
  }
  
  private static int[] axm(int paramInt)
  {
    AppMethodBeat.i(218725);
    int i = Color.alpha(paramInt);
    int j = Color.red(paramInt);
    int k = Color.green(paramInt);
    paramInt = Color.blue(paramInt);
    AppMethodBeat.o(218725);
    return new int[] { i, j, k, paramInt };
  }
  
  public final int getColor(int paramInt)
  {
    AppMethodBeat.i(218722);
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < this.XIx.length)
    {
      arrayOfInt[i] = ((int)(this.XIw[i] + (this.XIx[i] - this.XIw[i]) * 1.0D / this.count * paramInt));
      i += 1;
    }
    paramInt = Color.argb(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    AppMethodBeat.o(218722);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.indicator.a
 * JD-Core Version:    0.7.0.1
 */