package com.tencent.mm.ui.indicator;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int QkY;
  private int QkZ;
  private int[] Qla;
  private int[] Qlb;
  private int count;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205314);
    this.QkY = paramInt1;
    this.QkZ = paramInt2;
    this.count = 100;
    this.Qla = aoi(paramInt1);
    this.Qlb = aoi(paramInt2);
    AppMethodBeat.o(205314);
  }
  
  private static int[] aoi(int paramInt)
  {
    AppMethodBeat.i(205316);
    int i = Color.alpha(paramInt);
    int j = Color.red(paramInt);
    int k = Color.green(paramInt);
    paramInt = Color.blue(paramInt);
    AppMethodBeat.o(205316);
    return new int[] { i, j, k, paramInt };
  }
  
  public final int getColor(int paramInt)
  {
    AppMethodBeat.i(205315);
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < this.Qlb.length)
    {
      arrayOfInt[i] = ((int)(this.Qla[i] + (this.Qlb[i] - this.Qla[i]) * 1.0D / this.count * paramInt));
      i += 1;
    }
    paramInt = Color.argb(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    AppMethodBeat.o(205315);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.indicator.a
 * JD-Core Version:    0.7.0.1
 */