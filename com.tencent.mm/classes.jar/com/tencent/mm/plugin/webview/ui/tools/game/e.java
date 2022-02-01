package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class e
{
  private static final Map<String, Map<Integer, Object>> BmU;
  
  static
  {
    AppMethodBeat.i(80872);
    BmU = new HashMap();
    AppMethodBeat.o(80872);
  }
  
  public static void J(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80869);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80869);
      return;
    }
    Map localMap = (Map)BmU.get(paramString);
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      AppMethodBeat.o(80869);
      return;
    }
    BmU.put(paramString, paramMap);
    AppMethodBeat.o(80869);
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(188110);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188110);
      return;
    }
    TreeMap localTreeMap = new TreeMap(new Comparator() {});
    localTreeMap.putAll(paramf.cBK());
    localTreeMap.putAll(paramf.cBL());
    paramf = (Map)BmU.remove(paramString);
    paramString = localTreeMap;
    if (paramf != null)
    {
      paramf.putAll(localTreeMap);
      paramString = paramf;
    }
    if (paramString.containsKey(Integer.valueOf(b.Bnf))) {}
    for (boolean bool = ((Boolean)paramString.remove(Integer.valueOf(b.Bnf))).booleanValue();; bool = true)
    {
      paramString = bw(paramString);
      ad.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
      h.vKh.a(16142, paramString, bool, false);
      AppMethodBeat.o(188110);
      return;
    }
  }
  
  public static String bw(Map<Integer, Object> paramMap)
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
    public static int BmV = 21;
    public static int BmW = 22;
    public static int BmX = 23;
    public static int BmY = 24;
    public static int BmZ = 25;
    public static int Bna = 26;
    public static int Bnb = 27;
    public static int Bnc = 28;
    public static int Bnd = 29;
  }
  
  public static enum b
  {
    public static int Bnf = 1000;
    public static int Bng = 30;
    public static int Bnh = 31;
    public static int Bni = 32;
    public static int Bnj = 33;
    public static int Bnk = 34;
    public static int Bnl = 38;
    public static int Bnm = 39;
    public static int Bnn = 40;
    public static int Bno = 41;
    public static int Bnp = 42;
    public static int Bnq = 43;
    public static int Bnr = 44;
    public static int Bns = 45;
    public static int Bnt = 49;
    public static int Bnu = 50;
    public static int Bnv = 51;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.e
 * JD-Core Version:    0.7.0.1
 */