package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class d
{
  private static final Map<String, Map<Integer, Object>> EAP;
  
  static
  {
    AppMethodBeat.i(80872);
    EAP = new HashMap();
    AppMethodBeat.o(80872);
  }
  
  public static void M(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80869);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80869);
      return;
    }
    Map localMap = (Map)EAP.get(paramString);
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      AppMethodBeat.o(80869);
      return;
    }
    EAP.put(paramString, paramMap);
    AppMethodBeat.o(80869);
  }
  
  public static void a(String paramString, e parame)
  {
    AppMethodBeat.i(198405);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(198405);
      return;
    }
    TreeMap localTreeMap = new TreeMap(new Comparator() {});
    localTreeMap.putAll(parame.dai());
    localTreeMap.putAll(parame.daj());
    parame = (Map)EAP.remove(paramString);
    paramString = localTreeMap;
    if (parame != null)
    {
      parame.putAll(localTreeMap);
      paramString = parame;
    }
    if (paramString.containsKey(Integer.valueOf(b.EBa))) {}
    for (boolean bool = ((Boolean)paramString.remove(Integer.valueOf(b.EBa))).booleanValue();; bool = true)
    {
      paramString = bK(paramString);
      ae.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
      g.yxI.a(16142, paramString, bool, false);
      AppMethodBeat.o(198405);
      return;
    }
  }
  
  public static String bK(Map<Integer, Object> paramMap)
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
    public static int EAQ = 21;
    public static int EAR = 22;
    public static int EAS = 23;
    public static int EAT = 24;
    public static int EAU = 25;
    public static int EAV = 26;
    public static int EAW = 27;
    public static int EAX = 28;
    public static int EAY = 29;
  }
  
  public static enum b
  {
    public static int EBa = 1000;
    public static int EBb = 30;
    public static int EBc = 31;
    public static int EBd = 32;
    public static int EBe = 33;
    public static int EBf = 34;
    public static int EBg = 38;
    public static int EBh = 39;
    public static int EBi = 40;
    public static int EBj = 41;
    public static int EBk = 42;
    public static int EBl = 43;
    public static int EBm = 44;
    public static int EBn = 45;
    public static int EBo = 49;
    public static int EBp = 50;
    public static int EBq = 51;
    public static int EBr = 52;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.d
 * JD-Core Version:    0.7.0.1
 */