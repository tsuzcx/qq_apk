package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class e
{
  private static final Map<String, Map<Integer, Object>> CFb;
  
  static
  {
    AppMethodBeat.i(80872);
    CFb = new HashMap();
    AppMethodBeat.o(80872);
  }
  
  public static void K(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80869);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80869);
      return;
    }
    Map localMap = (Map)CFb.get(paramString);
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      AppMethodBeat.o(80869);
      return;
    }
    CFb.put(paramString, paramMap);
    AppMethodBeat.o(80869);
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(188554);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188554);
      return;
    }
    TreeMap localTreeMap = new TreeMap(new Comparator() {});
    localTreeMap.putAll(paramf.cOV());
    localTreeMap.putAll(paramf.cOW());
    paramf = (Map)CFb.remove(paramString);
    paramString = localTreeMap;
    if (paramf != null)
    {
      paramf.putAll(localTreeMap);
      paramString = paramf;
    }
    if (paramString.containsKey(Integer.valueOf(b.CFm))) {}
    for (boolean bool = ((Boolean)paramString.remove(Integer.valueOf(b.CFm))).booleanValue();; bool = true)
    {
      paramString = bB(paramString);
      ac.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
      h.wUl.a(16142, paramString, bool, false);
      AppMethodBeat.o(188554);
      return;
    }
  }
  
  public static String bB(Map<Integer, Object> paramMap)
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
    public static int CFc = 21;
    public static int CFd = 22;
    public static int CFe = 23;
    public static int CFf = 24;
    public static int CFg = 25;
    public static int CFh = 26;
    public static int CFi = 27;
    public static int CFj = 28;
    public static int CFk = 29;
  }
  
  public static enum b
  {
    public static int CFA = 49;
    public static int CFB = 50;
    public static int CFC = 51;
    public static int CFm = 1000;
    public static int CFn = 30;
    public static int CFo = 31;
    public static int CFp = 32;
    public static int CFq = 33;
    public static int CFr = 34;
    public static int CFs = 38;
    public static int CFt = 39;
    public static int CFu = 40;
    public static int CFv = 41;
    public static int CFw = 42;
    public static int CFx = 43;
    public static int CFy = 44;
    public static int CFz = 45;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.e
 * JD-Core Version:    0.7.0.1
 */