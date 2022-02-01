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

public final class e
{
  private static final Map<String, Map<Integer, Object>> QnJ;
  
  static
  {
    AppMethodBeat.i(80872);
    QnJ = new HashMap();
    AppMethodBeat.o(80872);
  }
  
  public static void U(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80869);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80869);
      return;
    }
    Map localMap = (Map)QnJ.get(paramString);
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      AppMethodBeat.o(80869);
      return;
    }
    QnJ.put(paramString, paramMap);
    AppMethodBeat.o(80869);
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(257973);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(257973);
      return;
    }
    TreeMap localTreeMap = new TreeMap(new Comparator() {});
    if (paramf != null)
    {
      localTreeMap.putAll(paramf.ewY());
      localTreeMap.putAll(paramf.ewZ());
    }
    paramf = (Map)QnJ.remove(paramString);
    paramString = localTreeMap;
    if (paramf != null)
    {
      paramf.putAll(localTreeMap);
      paramString = paramf;
    }
    if (paramString.containsKey(Integer.valueOf(b.QnU))) {}
    for (boolean bool = ((Boolean)paramString.remove(Integer.valueOf(b.QnU))).booleanValue();; bool = true)
    {
      paramString = bW(paramString);
      Log.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
      h.IzE.b(16142, paramString, bool, false);
      AppMethodBeat.o(257973);
      return;
    }
  }
  
  public static String bW(Map<Integer, Object> paramMap)
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
    public static int QnK = 21;
    public static int QnL = 22;
    public static int QnM = 23;
    public static int QnN = 24;
    public static int QnO = 25;
    public static int QnP = 26;
    public static int QnQ = 27;
    public static int QnR = 28;
    public static int QnS = 29;
  }
  
  public static enum b
  {
    public static int QnU = 1000;
    public static int QnV = 30;
    public static int QnW = 31;
    public static int QnX = 32;
    public static int QnY = 33;
    public static int QnZ = 34;
    public static int Qoa = 38;
    public static int Qob = 39;
    public static int Qoc = 40;
    public static int Qod = 41;
    public static int Qoe = 42;
    public static int Qof = 43;
    public static int Qog = 44;
    public static int Qoh = 45;
    public static int Qoi = 49;
    public static int Qoj = 50;
    public static int Qok = 51;
    public static int Qol = 52;
    public static int Qom = 53;
    public static int Qon = 54;
    public static int Qoo = 55;
    public static int Qop = 56;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.e
 * JD-Core Version:    0.7.0.1
 */