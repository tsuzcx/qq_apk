package com.tencent.mm.plugin.sns.ad.d;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.g.a;
import com.tencent.mm.plugin.sns.storage.ADXml.g.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n
{
  private static boolean a(SnsInfo paramSnsInfo, ADXml.g.a parama, List<PointF> paramList, List<List<PointF>> paramList1, String paramString, int paramInt)
  {
    AppMethodBeat.i(196545);
    boolean bool3 = false;
    bool1 = false;
    bool2 = bool3;
    try
    {
      long l1 = System.currentTimeMillis();
      bool2 = bool3;
      float f2 = parama.KjR;
      float f1 = 3.4028235E+38F;
      bool2 = bool3;
      parama = paramList1.iterator();
      for (;;)
      {
        bool2 = bool3;
        if (!parama.hasNext()) {
          break;
        }
        bool2 = bool3;
        float f3 = (float)a.K((List)parama.next(), paramList);
        bool2 = bool3;
        Log.d("GestureHelper", "current forwardSimilarity: ".concat(String.valueOf(f3)));
        bool2 = bool3;
        f1 = Math.min(f3, f1);
      }
      bool2 = bool3;
      long l2 = System.currentTimeMillis();
      bool2 = bool3;
      Log.i("GestureHelper", "forwardSimilarityMin: " + f1 + ", targetDistance = " + f2 + ", costTime = " + (l2 - l1));
      int i = 1;
      if (f1 <= f2)
      {
        i = 2;
        bool1 = true;
      }
      bool2 = bool1;
      h.IzE.a(16552, new Object[] { paramSnsInfo.getTimeLine().Id, "", paramString, Integer.valueOf((int)(100.0F * f1)), Integer.valueOf(i), Long.valueOf(Util.safeParseLong(paramSnsInfo.getAid())), paramSnsInfo.getAdInfo().uxInfo });
      bool2 = bool1;
      f.a(i, f1, f2, paramSnsInfo.getAdInfo().uxInfo, paramSnsInfo.getTimeLine().Id, paramInt);
    }
    catch (Throwable paramSnsInfo)
    {
      for (;;)
      {
        bool1 = bool2;
        Log.e("GestureHelper", paramSnsInfo.toString());
      }
    }
    AppMethodBeat.o(196545);
    return bool1;
  }
  
  public static boolean a(SnsInfo paramSnsInfo, List<PointF> paramList, ADXml.g.a parama, int paramInt)
  {
    AppMethodBeat.i(196538);
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    if ((parama == null) || (d.isEmpty(paramList)))
    {
      Log.e("GestureHelper", "gestureInfo is null or path is empty");
      AppMethodBeat.o(196538);
      return false;
    }
    boolean bool2 = bool3;
    float f1;
    List localList;
    String str;
    try
    {
      f1 = parama.KjR;
      bool2 = bool3;
      localList = a.kS(paramList);
      bool2 = bool3;
      str = t.hx(a.kQ(localList));
      if (parama == null) {}
      for (paramList = null;; paramList = null)
      {
        bool2 = bool3;
        if (d.isEmpty(paramList)) {
          break label268;
        }
        bool2 = bool3;
        bool1 = a(paramSnsInfo, parama, localList, paramList, str, paramInt);
        AppMethodBeat.o(196538);
        return bool1;
        bool2 = bool3;
        paramList = parama.KjT;
        bool2 = bool3;
        if (!d.isEmpty(paramList)) {
          break;
        }
      }
      bool2 = bool3;
      ArrayList localArrayList = new ArrayList();
      bool2 = bool3;
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        bool2 = bool3;
        if (!localIterator.hasNext()) {
          break;
        }
        bool2 = bool3;
        ADXml.g.b localb = (ADXml.g.b)localIterator.next();
        paramList = localArrayList;
        if (localb == null) {
          break;
        }
        paramList = localArrayList;
        bool2 = bool3;
        if (Util.isNullOrNil(localb.KjS)) {
          break;
        }
        bool2 = bool3;
        localArrayList.add(t.aZu(localb.KjS));
      }
      AppMethodBeat.o(196538);
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("GestureHelper", paramSnsInfo, "recog gesture error!", new Object[0]);
    }
    for (;;)
    {
      return bool2;
      label268:
      bool2 = bool3;
      paramList = t.aZu(parama.KjS);
      bool2 = bool3;
      if (!d.isEmpty(paramList))
      {
        bool2 = bool3;
        float f2 = (float)a.K(paramList, localList);
        bool2 = bool3;
        paramList = t.hx(paramList);
        bool2 = bool3;
        Log.i("GestureHelper", "forwardSimilarity: %f, targetDistance: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
        int i = 1;
        bool1 = bool4;
        if (f2 <= f1)
        {
          i = 2;
          bool1 = true;
        }
        bool2 = bool1;
        h.IzE.a(16552, new Object[] { paramSnsInfo.getTimeLine().Id, paramList, str, Integer.valueOf((int)(100.0F * f2)), Integer.valueOf(i), Long.valueOf(Util.safeParseLong(paramSnsInfo.getAid())), paramSnsInfo.getAdInfo().uxInfo });
        bool2 = bool1;
        f.a(i, f2, f1, paramSnsInfo.getAdInfo().uxInfo, paramSnsInfo.getTimeLine().Id, paramInt);
      }
      bool2 = bool1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(196531);
    try
    {
      paramString2 = t.aZu(paramString2);
      paramString1 = t.aZu(paramString1);
      if ((!d.isEmpty(paramString2)) && (!d.isEmpty(paramString1)))
      {
        double d = a.K(paramString2, a.kS(paramString1));
        Log.i("GestureHelper", "forwardSimilarity: %f", new Object[] { Double.valueOf(d) });
        if (d <= paramFloat)
        {
          AppMethodBeat.o(196531);
          return true;
        }
      }
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("GestureHelper", paramString1, "recog gesture error!", new Object[0]);
      AppMethodBeat.o(196531);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.n
 * JD-Core Version:    0.7.0.1
 */