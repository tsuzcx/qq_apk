package com.tencent.mm.y;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class c$a
{
  float[] eFB;
  float[] eFC;
  int eFD;
  
  public c$a(List<PointF> paramList)
  {
    AppMethodBeat.i(116273);
    Object localObject;
    this.eFD = localObject.size();
    this.eFB = new float[this.eFD];
    this.eFC = new float[this.eFD];
    int i = 0;
    while (i < this.eFD)
    {
      this.eFB[i] = ((PointF)localObject.get(i)).x;
      this.eFC[i] = ((PointF)localObject.get(i)).y;
      i += 1;
    }
    new StringBuilder("lasso size:").append(this.eFD);
    AppMethodBeat.o(116273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.y.c.a
 * JD-Core Version:    0.7.0.1
 */