package com.tencent.mm.plugin.sns.ad.d;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.g.a;
import com.tencent.mm.plugin.sns.storage.ADXml.g.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class q
{
  private static void a(int paramInt1, float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(309994);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("result", paramInt1);
      localJSONObject2.put("score", paramFloat1);
      localJSONObject2.put("targetScore", paramFloat2);
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("uxinfo", paramString1);
      localJSONObject1.put("snsId", paramString2);
      localJSONObject1.put("scene", paramInt2);
      m.lU("16552", localJSONObject1.toString());
      AppMethodBeat.o(309994);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("GestureHelper", "gestureCgiReport exp=" + paramString1.toString());
      AppMethodBeat.o(309994);
    }
  }
  
  private static boolean a(SnsInfo paramSnsInfo, ADXml.g.a parama, List<PointF> paramList, List<List<PointF>> paramList1, String paramString, int paramInt)
  {
    AppMethodBeat.i(309985);
    boolean bool3 = false;
    bool1 = false;
    bool2 = bool3;
    try
    {
      long l1 = System.currentTimeMillis();
      bool2 = bool3;
      float f2 = parama.TG;
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
        float f3 = (float)a.X((List)parama.next(), paramList);
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
      h.OAn.b(16552, new Object[] { paramSnsInfo.getTimeLine().Id, "", paramString, Integer.valueOf((int)(100.0F * f1)), Integer.valueOf(i), Long.valueOf(Util.safeParseLong(paramSnsInfo.getAid())), paramSnsInfo.getAdInfo().uxInfo });
      bool2 = bool1;
      a(i, f1, f2, paramSnsInfo.getAdInfo().uxInfo, paramSnsInfo.getTimeLine().Id, paramInt);
    }
    finally
    {
      for (;;)
      {
        bool1 = bool2;
        Log.e("GestureHelper", paramSnsInfo.toString());
      }
    }
    AppMethodBeat.o(309985);
    return bool1;
  }
  
  public static boolean a(SnsInfo paramSnsInfo, List<PointF> paramList, ADXml.g.a parama, int paramInt)
  {
    AppMethodBeat.i(309977);
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    if ((parama == null) || (d.isEmpty(paramList)))
    {
      Log.e("GestureHelper", "gestureInfo is null or path is empty");
      AppMethodBeat.o(309977);
      return false;
    }
    boolean bool2 = bool3;
    float f1;
    List localList;
    String str;
    try
    {
      f1 = parama.TG;
      bool2 = bool3;
      localList = a.ok(paramList);
      bool2 = bool3;
      str = t.ky(a.oi(localList));
      if (parama == null) {}
      for (paramList = null;; paramList = null)
      {
        bool2 = bool3;
        if (d.isEmpty(paramList)) {
          break label269;
        }
        bool2 = bool3;
        bool1 = a(paramSnsInfo, parama, localList, paramList, str, paramInt);
        AppMethodBeat.o(309977);
        return bool1;
        bool2 = bool3;
        paramList = parama.QHP;
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
        if (Util.isNullOrNil(localb.QHO)) {
          break;
        }
        bool2 = bool3;
        localArrayList.add(t.aXF(localb.QHO));
      }
      AppMethodBeat.o(309977);
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("GestureHelper", paramSnsInfo, "recog gesture error!", new Object[0]);
    }
    for (;;)
    {
      return bool2;
      label269:
      bool2 = bool3;
      paramList = t.aXF(parama.QHO);
      bool2 = bool3;
      if (!d.isEmpty(paramList))
      {
        bool2 = bool3;
        float f2 = (float)a.X(paramList, localList);
        bool2 = bool3;
        paramList = t.ky(paramList);
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
        h.OAn.b(16552, new Object[] { paramSnsInfo.getTimeLine().Id, paramList, str, Integer.valueOf((int)(100.0F * f2)), Integer.valueOf(i), Long.valueOf(Util.safeParseLong(paramSnsInfo.getAid())), paramSnsInfo.getAdInfo().uxInfo });
        bool2 = bool1;
        a(i, f2, f1, paramSnsInfo.getAdInfo().uxInfo, paramSnsInfo.getTimeLine().Id, paramInt);
      }
      bool2 = bool1;
    }
  }
  
  public static boolean b(String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(309958);
    try
    {
      paramString2 = t.aXF(paramString2);
      paramString1 = t.aXF(paramString1);
      if ((!d.isEmpty(paramString2)) && (!d.isEmpty(paramString1)))
      {
        double d = a.X(paramString2, a.ok(paramString1));
        Log.i("GestureHelper", "forwardSimilarity: %f", new Object[] { Double.valueOf(d) });
        if (d <= paramFloat)
        {
          AppMethodBeat.o(309958);
          return true;
        }
      }
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("GestureHelper", paramString1, "recog gesture error!", new Object[0]);
      AppMethodBeat.o(309958);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.q
 * JD-Core Version:    0.7.0.1
 */