package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class d
{
  private static final Map<String, Map<Integer, Object>> Jqm;
  
  static
  {
    AppMethodBeat.i(80872);
    Jqm = new HashMap();
    AppMethodBeat.o(80872);
  }
  
  public static void S(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80869);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80869);
      return;
    }
    Map localMap = (Map)Jqm.get(paramString);
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      AppMethodBeat.o(80869);
      return;
    }
    Jqm.put(paramString, paramMap);
    AppMethodBeat.o(80869);
  }
  
  public static void a(String paramString, e parame)
  {
    AppMethodBeat.i(211314);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211314);
      return;
    }
    TreeMap localTreeMap = new TreeMap(new Comparator() {});
    localTreeMap.putAll(parame.dTR());
    localTreeMap.putAll(parame.dTS());
    parame = (Map)Jqm.remove(paramString);
    paramString = localTreeMap;
    if (parame != null)
    {
      parame.putAll(localTreeMap);
      paramString = parame;
    }
    if (paramString.containsKey(Integer.valueOf(b.Jqx))) {}
    for (boolean bool = ((Boolean)paramString.remove(Integer.valueOf(b.Jqx))).booleanValue();; bool = true)
    {
      paramString = bP(paramString);
      Log.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
      h.CyF.a(16142, paramString, bool, false);
      AppMethodBeat.o(211314);
      return;
    }
  }
  
  public static String bP(Map<Integer, Object> paramMap)
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
    public static int Jqn = 21;
    public static int Jqo = 22;
    public static int Jqp = 23;
    public static int Jqq = 24;
    public static int Jqr = 25;
    public static int Jqs = 26;
    public static int Jqt = 27;
    public static int Jqu = 28;
    public static int Jqv = 29;
  }
  
  public static enum b
  {
    public static int JqA = 32;
    public static int JqB = 33;
    public static int JqC = 34;
    public static int JqD = 38;
    public static int JqE = 39;
    public static int JqF = 40;
    public static int JqG = 41;
    public static int JqH = 42;
    public static int JqI = 43;
    public static int JqJ = 44;
    public static int JqK = 45;
    public static int JqL = 49;
    public static int JqM = 50;
    public static int JqN = 51;
    public static int JqO = 52;
    public static int JqP = 53;
    public static int JqQ = 54;
    public static int JqR = 55;
    public static int JqS = 56;
    public static int Jqx = 1000;
    public static int Jqy = 30;
    public static int Jqz = 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.d
 * JD-Core Version:    0.7.0.1
 */