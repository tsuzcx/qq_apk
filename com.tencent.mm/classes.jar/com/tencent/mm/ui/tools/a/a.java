package com.tencent.mm.ui.tools.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static double X(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(251041);
    try
    {
      paramList1 = oi(paramList1);
      paramList2 = oi(paramList2);
      paramList1 = oj(paramList1);
      paramList2 = oj(paramList2);
      double d2 = 0.0D;
      double d1 = 0.0D;
      int j = paramList1.size();
      int k = paramList2.size();
      int i = 0;
      while ((i < j) && (i < k))
      {
        float f1 = ((Float)paramList1.get(i)).floatValue();
        float f2 = ((Float)paramList2.get(i)).floatValue();
        float f3 = ((Float)paramList1.get(i + 1)).floatValue();
        d2 += ((Float)paramList2.get(i + 1)).floatValue() * f3 + f1 * f2;
        f1 = ((Float)paramList1.get(i)).floatValue();
        f2 = ((Float)paramList2.get(i + 1)).floatValue();
        f3 = ((Float)paramList1.get(i + 1)).floatValue();
        d1 += f1 * f2 - ((Float)paramList2.get(i)).floatValue() * f3;
        i += 2;
      }
      if (d2 != 0.0D)
      {
        double d3 = Math.atan(d1 / d2);
        double d4 = Math.cos(d3);
        d1 = Math.acos(Math.sin(d3) * d1 + d2 * d4);
        AppMethodBeat.o(251041);
        return d1;
      }
      Log.e("MicroMsg.GestureRecognizer.ToIos", "devide a but a == 0");
      AppMethodBeat.o(251041);
      return 1.570796326794897D;
    }
    finally
    {
      Log.e("MicroMsg.GestureRecognizer.ToIos", paramList1.toString());
      AppMethodBeat.o(251041);
    }
    return 0.0D;
  }
  
  private static float a(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(182570);
    float f = (float)Math.hypot(paramPointF1.x - paramPointF2.x, paramPointF1.y - paramPointF2.y);
    AppMethodBeat.o(182570);
    return f;
  }
  
  public static List<PointF> oi(List<PointF> paramList)
  {
    AppMethodBeat.i(251035);
    double d1 = 0.0D;
    try
    {
      PointF localPointF1 = (PointF)paramList.get(0);
      int j = paramList.size();
      int i = 1;
      while (i < j)
      {
        d1 += a(localPointF1, (PointF)paramList.get(i));
        localPointF1 = (PointF)paramList.get(i);
        i += 1;
      }
      double d2 = d1 / 200.0D;
      d1 = 0.0D;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new PointF(((PointF)paramList.get(0)).x, ((PointF)paramList.get(0)).y));
      localPointF1 = (PointF)paramList.get(0);
      j = paramList.size();
      i = 1;
      while (i < j)
      {
        PointF localPointF2 = (PointF)paramList.get(i);
        double d3 = a(localPointF1, localPointF2);
        if (d1 + d3 >= d2)
        {
          if (d3 > 0.0D)
          {
            d1 = (d2 - d1) / d3;
            d3 = localPointF1.x;
            double d4 = localPointF2.x - localPointF1.x;
            double d5 = localPointF1.y;
            double d6 = localPointF2.y - localPointF1.y;
            localPointF1 = new PointF((float)(d3 + d4 * d1), (float)(d1 * d6 + d5));
            localArrayList.add(localPointF1);
            d1 = 0.0D;
          }
        }
        else
        {
          d1 += d3;
          localPointF1 = (PointF)paramList.get(i);
          i += 1;
        }
      }
      AppMethodBeat.o(251035);
      return localArrayList;
    }
    finally
    {
      Log.e("MicroMsg.GestureRecognizer.ToIos", paramList.toString());
      paramList = new ArrayList();
      AppMethodBeat.o(251035);
    }
    return paramList;
  }
  
  private static List<Float> oj(List<PointF> paramList)
  {
    AppMethodBeat.i(251039);
    double d2 = 0.0D;
    double d1 = 0.0D;
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (PointF)paramList.get(i);
      d2 += ((PointF)localObject).x;
      d1 += ((PointF)localObject).y;
      i += 1;
    }
    d2 /= j;
    d1 /= j;
    Object localObject = new PointF((float)d2, (float)d1);
    i = 0;
    PointF localPointF;
    while (i < j)
    {
      localPointF = (PointF)paramList.get(i);
      localPointF.x -= ((PointF)localObject).x;
      localPointF.y -= ((PointF)localObject).y;
      i += 1;
    }
    double d4 = 1.7976931348623157E+308D;
    double d3 = -1.797693134862316E+308D;
    d2 = 1.7976931348623157E+308D;
    i = 0;
    d1 = -1.797693134862316E+308D;
    while (i < j)
    {
      localObject = (PointF)paramList.get(i);
      d4 = Math.min(d4, ((PointF)localObject).x);
      d3 = Math.max(d3, ((PointF)localObject).x);
      d2 = Math.min(d2, ((PointF)localObject).y);
      d1 = Math.max(d1, ((PointF)localObject).y);
      i += 1;
    }
    localObject = new a((byte)0);
    d4 = d3 - d4;
    d1 -= d2;
    d3 = Math.max(d4, d1);
    if (Math.min(d4, d1) / d3 < 0.2000000029802322D) {}
    for (i = 1;; i = 0)
    {
      d2 = ((a)localObject).afLY / d4;
      d1 = ((a)localObject).afLZ / d1;
      if (i != 0)
      {
        d2 = ((a)localObject).afLY / d3;
        d1 = ((a)localObject).afLZ / d3;
      }
      i = 0;
      while (i < j)
      {
        localObject = (PointF)paramList.get(i);
        ((PointF)localObject).x = ((float)(((PointF)localObject).x * d2));
        ((PointF)localObject).y = ((float)(((PointF)localObject).y * d1));
        i += 1;
      }
    }
    localObject = (PointF)paramList.get(0);
    d1 = Math.atan2(((PointF)localObject).y, ((PointF)localObject).x);
    d2 = 0.7853981633974483D * Math.floor((0.3926990816987241D + d1) / 0.7853981633974483D) - d1;
    d1 = Math.cos(d2);
    d2 = Math.sin(d2);
    i = 0;
    while (i < j)
    {
      localObject = (PointF)paramList.get(i);
      ((PointF)localObject).x = ((float)(((PointF)localObject).x * d1 - ((PointF)localObject).y * d2));
      ((PointF)localObject).y = ((float)(((PointF)localObject).x * d2 + ((PointF)localObject).y * d1));
      i += 1;
    }
    localObject = new ArrayList();
    d1 = 0.0D;
    i = 0;
    while (i < j)
    {
      localPointF = (PointF)paramList.get(i);
      ((List)localObject).add(Float.valueOf(localPointF.x));
      ((List)localObject).add(Float.valueOf(localPointF.y));
      d1 += Math.pow(localPointF.x, 2.0D) + Math.pow(localPointF.y, 2.0D);
      i += 1;
    }
    d1 = Math.sqrt(d1);
    j = ((List)localObject).size();
    i = 0;
    while (i < j)
    {
      ((List)localObject).set(i, Float.valueOf((float)(((Float)((List)localObject).get(i)).floatValue() / d1 + 0.0001D)));
      i += 1;
    }
    AppMethodBeat.o(251039);
    return localObject;
  }
  
  public static List<PointF> ok(List<PointF> paramList)
  {
    AppMethodBeat.i(251043);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(251043);
      return localArrayList;
    }
    int k = paramList.size();
    localArrayList.add((PointF)paramList.get(0));
    int i = localArrayList.size() - 1;
    int j = 1;
    if (j < k)
    {
      if (((PointF)paramList.get(j)).equals(localArrayList.get(i))) {
        break label154;
      }
      localArrayList.add((PointF)paramList.get(j));
      i = localArrayList.size() - 1;
    }
    label154:
    for (;;)
    {
      j += 1;
      break;
      Log.i("MicroMsg.GestureRecognizer", localArrayList.toString());
      AppMethodBeat.o(251043);
      return localArrayList;
    }
  }
  
  static final class a
  {
    double afLY = 150.0D;
    double afLZ = 150.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a.a
 * JD-Core Version:    0.7.0.1
 */