package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PointWithIndex
{
  public int index;
  public PointF point;
  
  public PointWithIndex(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(83941);
    this.point = new PointF(paramFloat1, paramFloat2);
    this.index = paramInt;
    AppMethodBeat.o(83941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.PointWithIndex
 * JD-Core Version:    0.7.0.1
 */