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
  private static final Map<String, Map<Integer, Object>> XfX;
  
  static
  {
    AppMethodBeat.i(80872);
    XfX = new HashMap();
    AppMethodBeat.o(80872);
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(297016);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(297016);
      return;
    }
    TreeMap localTreeMap = new TreeMap(new Comparator() {});
    if (paramf != null)
    {
      Map localMap = paramf.fEU();
      if (localMap != null) {
        localTreeMap.putAll(localMap);
      }
      paramf = paramf.fEV();
      if (paramf != null) {
        localTreeMap.putAll(paramf);
      }
    }
    paramf = (Map)XfX.remove(paramString);
    paramString = localTreeMap;
    if (paramf != null)
    {
      paramf.putAll(localTreeMap);
      paramString = paramf;
    }
    if (paramString.containsKey(Integer.valueOf(b.Xgi))) {}
    for (boolean bool = ((Boolean)paramString.remove(Integer.valueOf(b.Xgi))).booleanValue();; bool = true)
    {
      paramString = cq(paramString);
      Log.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
      h.OAn.b(16142, paramString, bool, false);
      AppMethodBeat.o(297016);
      return;
    }
  }
  
  public static void ad(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80869);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80869);
      return;
    }
    Map localMap = (Map)XfX.get(paramString);
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      AppMethodBeat.o(80869);
      return;
    }
    XfX.put(paramString, paramMap);
    AppMethodBeat.o(80869);
  }
  
  public static String cq(Map<Integer, Object> paramMap)
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
    public static int XfY = 21;
    public static int XfZ = 22;
    public static int Xga = 23;
    public static int Xgb = 24;
    public static int Xgc = 25;
    public static int Xgd = 26;
    public static int Xge = 27;
    public static int Xgf = 28;
    public static int Xgg = 29;
  }
  
  public static enum b
  {
    public static int XgA = 53;
    public static int XgB = 54;
    public static int XgC = 55;
    public static int XgD = 56;
    public static int Xgi = 1000;
    public static int Xgj = 30;
    public static int Xgk = 31;
    public static int Xgl = 32;
    public static int Xgm = 33;
    public static int Xgn = 34;
    public static int Xgo = 38;
    public static int Xgp = 39;
    public static int Xgq = 40;
    public static int Xgr = 41;
    public static int Xgs = 42;
    public static int Xgt = 43;
    public static int Xgu = 44;
    public static int Xgv = 45;
    public static int Xgw = 49;
    public static int Xgx = 50;
    public static int Xgy = 51;
    public static int Xgz = 52;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.e
 * JD-Core Version:    0.7.0.1
 */