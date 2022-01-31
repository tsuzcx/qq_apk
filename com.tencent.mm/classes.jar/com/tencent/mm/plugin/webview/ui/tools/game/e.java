package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<Integer, Map<Integer, Object>> vmF;
  
  static
  {
    AppMethodBeat.i(8701);
    vmF = new HashMap();
    AppMethodBeat.o(8701);
  }
  
  public static String aJ(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(8700);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(8700);
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
    AppMethodBeat.o(8700);
    return paramMap;
  }
  
  public static void aiM(String paramString)
  {
    AppMethodBeat.i(8699);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8699);
      return;
    }
    paramString = (Map)vmF.remove(Integer.valueOf(paramString.hashCode()));
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(8699);
      return;
    }
    boolean bool = ((Boolean)paramString.remove(Integer.valueOf(e.b.vmQ))).booleanValue();
    paramString = aJ(paramString);
    ab.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
    h.qsU.a(16142, paramString, bool, false);
    AppMethodBeat.o(8699);
  }
  
  public static void z(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(8698);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8698);
      return;
    }
    vmF.put(Integer.valueOf(paramString.hashCode()), paramMap);
    AppMethodBeat.o(8698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.e
 * JD-Core Version:    0.7.0.1
 */