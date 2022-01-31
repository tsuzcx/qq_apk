package com.tencent.mm.z;

import android.graphics.PointF;
import java.util.List;

public final class c$a
{
  public float[] dHX;
  public float[] dHY;
  public int dHZ;
  
  public c$a(List<PointF> paramList)
  {
    Object localObject;
    this.dHZ = localObject.size();
    this.dHX = new float[this.dHZ];
    this.dHY = new float[this.dHZ];
    int i = 0;
    while (i < this.dHZ)
    {
      this.dHX[i] = ((PointF)localObject.get(i)).x;
      this.dHY[i] = ((PointF)localObject.get(i)).y;
      i += 1;
    }
    new StringBuilder("lasso size:").append(this.dHZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.c.a
 * JD-Core Version:    0.7.0.1
 */