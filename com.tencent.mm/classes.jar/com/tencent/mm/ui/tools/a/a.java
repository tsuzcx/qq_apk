package com.tencent.mm.ui.tools.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static float a(List<PointF> paramList1, List<PointF> paramList2, int paramInt)
  {
    AppMethodBeat.i(107828);
    long l = System.currentTimeMillis();
    paramList1 = u(paramList1, paramInt);
    paramList2 = u(paramList2, paramInt);
    float f = d(fF(paramList1), fF(paramList2));
    ab.i("MicroMsg.GestureRecognizer", "computeSimilarity cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(107828);
    return f;
  }
  
  private static float d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(107825);
    if (paramArrayOfFloat1.length != paramArrayOfFloat2.length)
    {
      AppMethodBeat.o(107825);
      return -1.0F;
    }
    int i = 0;
    double d2 = 0.0D;
    double d1 = 0.0D;
    double d3 = 0.0D;
    while (i < paramArrayOfFloat1.length)
    {
      d3 += paramArrayOfFloat1[i] * paramArrayOfFloat2[i];
      double d4 = Math.pow(paramArrayOfFloat1[i], 2.0D);
      d2 += Math.pow(paramArrayOfFloat2[i], 2.0D);
      i += 1;
      d1 = d4 + d1;
    }
    float f = (float)(d3 / (Math.sqrt(d1) * Math.sqrt(d2)));
    AppMethodBeat.o(107825);
    return f;
  }
  
  private static float[] fF(List<PointF> paramList)
  {
    AppMethodBeat.i(107826);
    float[] arrayOfFloat = new float[paramList.size() * 2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    int i = 1;
    while (i < paramList.size())
    {
      arrayOfFloat[(i * 2)] = (((PointF)paramList.get(i)).x - ((PointF)paramList.get(i - 1)).x);
      arrayOfFloat[(i * 2 + 1)] = (((PointF)paramList.get(i)).y - ((PointF)paramList.get(i - 1)).y);
      i += 1;
    }
    AppMethodBeat.o(107826);
    return arrayOfFloat;
  }
  
  public static List<PointF> u(List<PointF> paramList, int paramInt)
  {
    AppMethodBeat.i(107824);
    if (paramInt <= 1)
    {
      ab.w("MicroMsg.GestureRecognizer", "sample count <= 1 !");
      AppMethodBeat.o(107824);
      return paramList;
    }
    if (paramInt == paramList.size())
    {
      ab.w("MicroMsg.GestureRecognizer", "sample count == path.size, no need resample!");
      AppMethodBeat.o(107824);
      return paramList;
    }
    double d1 = 0.0D;
    Object localObject1 = (PointF)paramList.get(0);
    int i = 1;
    Object localObject2;
    while (i < paramList.size())
    {
      localObject2 = (PointF)paramList.get(i);
      d1 += (float)Math.hypot(((PointF)localObject1).x - ((PointF)localObject2).x, ((PointF)localObject1).y - ((PointF)localObject2).y);
      localObject1 = (PointF)paramList.get(i);
      i += 1;
    }
    double d3 = d1 / (paramInt - 1);
    ab.i("MicroMsg.GestureRecognizer", "point count %d, interval %f", new Object[] { Integer.valueOf(paramList.size()), Double.valueOf(d3) });
    if ((paramList.size() <= 1) || (d3 < 1.0D)) {
      ab.w("MicroMsg.GestureRecognizer", "point count <= 1 or interval < 1, no need resample!");
    }
    for (localObject1 = paramList;; localObject1 = localObject2)
    {
      if (((List)localObject1).size() < paramInt)
      {
        ab.i("MicroMsg.GestureRecognizer", "sample result %d, sample count %d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramInt) });
        ((List)localObject1).add(new PointF(((PointF)paramList.get(paramList.size() - 1)).x, ((PointF)paramList.get(paramList.size() - 1)).y));
      }
      AppMethodBeat.o(107824);
      return localObject1;
      localObject2 = new ArrayList();
      double d2 = 0.0D;
      ((List)localObject2).add(new PointF(((PointF)paramList.get(0)).x, ((PointF)paramList.get(0)).y));
      localObject1 = (PointF)paramList.get(0);
      i = 1;
      while (i < paramList.size())
      {
        double d4 = ((PointF)paramList.get(i)).x - ((PointF)paramList.get(i - 1)).x;
        double d5 = ((PointF)paramList.get(i)).y - ((PointF)paramList.get(i - 1)).y;
        double d6 = (float)Math.hypot(d4, d5);
        d1 = d6 + d2;
        if (d1 >= d3)
        {
          if (d1 == d3) {
            localObject1 = new PointF(((PointF)paramList.get(i)).x, ((PointF)paramList.get(i)).y);
          }
          for (d1 = 0.0D;; d1 -= d3)
          {
            ((List)localObject2).add(localObject1);
            break;
            double d7 = (d3 - d2) / d6;
            localObject1 = new PointF((float)(((PointF)localObject1).x + d4 * d7), (float)(d7 * d5 + ((PointF)localObject1).y));
          }
        }
        localObject1 = (PointF)paramList.get(i);
        i += 1;
        d2 = d1;
      }
    }
  }
  
  public static float v(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(107827);
    int i = Math.min(paramList1.size(), paramList2.size());
    if (i < 20) {}
    for (;;)
    {
      float f = a(paramList1, paramList2, i);
      AppMethodBeat.o(107827);
      return f;
      i = 20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a.a
 * JD-Core Version:    0.7.0.1
 */