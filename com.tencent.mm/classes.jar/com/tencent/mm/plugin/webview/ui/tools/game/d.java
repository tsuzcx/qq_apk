package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class d
{
  private static final Map<String, Map<Integer, Object>> EiL;
  
  static
  {
    AppMethodBeat.i(80872);
    EiL = new HashMap();
    AppMethodBeat.o(80872);
  }
  
  public static void L(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80869);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80869);
      return;
    }
    Map localMap = (Map)EiL.get(paramString);
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      AppMethodBeat.o(80869);
      return;
    }
    EiL.put(paramString, paramMap);
    AppMethodBeat.o(80869);
  }
  
  public static void a(String paramString, e parame)
  {
    AppMethodBeat.i(208224);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(208224);
      return;
    }
    TreeMap localTreeMap = new TreeMap(new Comparator() {});
    localTreeMap.putAll(parame.cXy());
    localTreeMap.putAll(parame.cXz());
    parame = (Map)EiL.remove(paramString);
    paramString = localTreeMap;
    if (parame != null)
    {
      parame.putAll(localTreeMap);
      paramString = parame;
    }
    if (paramString.containsKey(Integer.valueOf(b.EiW))) {}
    for (boolean bool = ((Boolean)paramString.remove(Integer.valueOf(b.EiW))).booleanValue();; bool = true)
    {
      paramString = bE(paramString);
      ad.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
      g.yhR.a(16142, paramString, bool, false);
      AppMethodBeat.o(208224);
      return;
    }
  }
  
  public static String bE(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80871);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(80871);
      return "";
    }
    int j = ((Integer)Collections.max(paramMap.keySet())).intValue();
    int i = ((Integer)Collections.min(paramMap.keySet())).intValue();
    j = Math.min(j, 200);
    StringBuffer localStringBuffer = new StringBuffer();
    while (i <= j)
    {
      Object localObject = paramMap.get(Integer.valueOf(i));
      if (localObject != null) {
        localStringBuffer.append(localObject);
      }
      localStringBuffer.append(",");
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(80871);
    return paramMap;
  }
  
  public static enum a
  {
    public static int EiM = 21;
    public static int EiN = 22;
    public static int EiO = 23;
    public static int EiP = 24;
    public static int EiQ = 25;
    public static int EiR = 26;
    public static int EiS = 27;
    public static int EiT = 28;
    public static int EiU = 29;
  }
  
  public static enum b
  {
    public static int EiW = 1000;
    public static int EiX = 30;
    public static int EiY = 31;
    public static int EiZ = 32;
    public static int Eja = 33;
    public static int Ejb = 34;
    public static int Ejc = 38;
    public static int Ejd = 39;
    public static int Eje = 40;
    public static int Ejf = 41;
    public static int Ejg = 42;
    public static int Ejh = 43;
    public static int Eji = 44;
    public static int Ejj = 45;
    public static int Ejk = 49;
    public static int Ejl = 50;
    public static int Ejm = 51;
    public static int Ejn = 52;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.d
 * JD-Core Version:    0.7.0.1
 */