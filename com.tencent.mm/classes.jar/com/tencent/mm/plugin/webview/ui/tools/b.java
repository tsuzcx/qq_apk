package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final Map<Integer, Integer> uZV;
  private static final Map<Integer, Integer> uZW;
  private static final Map<Integer, Integer> uZX;
  private static final Map<String, Integer> uZY;
  
  static
  {
    AppMethodBeat.i(7347);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(-1), Integer.valueOf(5));
    localHashMap.put(Integer.valueOf(-2), Integer.valueOf(6));
    localHashMap.put(Integer.valueOf(-3), Integer.valueOf(7));
    localHashMap.put(Integer.valueOf(-4), Integer.valueOf(8));
    localHashMap.put(Integer.valueOf(-5), Integer.valueOf(9));
    localHashMap.put(Integer.valueOf(-6), Integer.valueOf(10));
    localHashMap.put(Integer.valueOf(-7), Integer.valueOf(11));
    localHashMap.put(Integer.valueOf(-8), Integer.valueOf(12));
    localHashMap.put(Integer.valueOf(-9), Integer.valueOf(13));
    localHashMap.put(Integer.valueOf(-10), Integer.valueOf(14));
    localHashMap.put(Integer.valueOf(-11), Integer.valueOf(15));
    localHashMap.put(Integer.valueOf(-12), Integer.valueOf(16));
    localHashMap.put(Integer.valueOf(-13), Integer.valueOf(17));
    localHashMap.put(Integer.valueOf(-14), Integer.valueOf(18));
    localHashMap.put(Integer.valueOf(-15), Integer.valueOf(19));
    uZV = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(-1), Integer.valueOf(4));
    localHashMap.put(Integer.valueOf(-2), Integer.valueOf(5));
    localHashMap.put(Integer.valueOf(-3), Integer.valueOf(6));
    localHashMap.put(Integer.valueOf(-4), Integer.valueOf(7));
    localHashMap.put(Integer.valueOf(-5), Integer.valueOf(8));
    localHashMap.put(Integer.valueOf(-6), Integer.valueOf(9));
    uZW = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(0));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(1));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(2));
    uZX = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put("imagePreview", Integer.valueOf(2));
    localHashMap.put("profile", Integer.valueOf(3));
    localHashMap.put("addContact", Integer.valueOf(4));
    localHashMap.put("shareTimeline", Integer.valueOf(7));
    localHashMap.put("scanQRCode", Integer.valueOf(8));
    localHashMap.put("hideOptionMenu", Integer.valueOf(10));
    localHashMap.put("getBrandWCPayRequest", Integer.valueOf(11));
    localHashMap.put("editAddress", Integer.valueOf(12));
    localHashMap.put("getLatestAddress", Integer.valueOf(13));
    localHashMap.put("jumpWCMall", Integer.valueOf(14));
    localHashMap.put("geoLocation", Integer.valueOf(15));
    localHashMap.put("openProductView", Integer.valueOf(16));
    localHashMap.put("openProductViewWithPid", Integer.valueOf(16));
    localHashMap.put("openLocation", Integer.valueOf(17));
    localHashMap.put("hideMenuItems", Integer.valueOf(19));
    localHashMap.put("connectToFreeWifi", Integer.valueOf(20));
    localHashMap.put("startRecord", Integer.valueOf(21));
    localHashMap.put("chooseImage", Integer.valueOf(22));
    localHashMap.put("scanCover", Integer.valueOf(23));
    localHashMap.put("openGameWebView", Integer.valueOf(28));
    uZY = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(7347);
  }
  
  public static int Kl(int paramInt)
  {
    AppMethodBeat.i(7343);
    Integer localInteger2 = (Integer)uZV.get(Integer.valueOf(paramInt));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = (Integer)uZV.get(Integer.valueOf(-1));
    }
    paramInt = localInteger1.intValue();
    AppMethodBeat.o(7343);
    return paramInt;
  }
  
  public static int Km(int paramInt)
  {
    AppMethodBeat.i(7344);
    Integer localInteger2 = (Integer)uZW.get(Integer.valueOf(paramInt));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = (Integer)uZW.get(Integer.valueOf(-1));
    }
    paramInt = localInteger1.intValue();
    AppMethodBeat.o(7344);
    return paramInt;
  }
  
  public static int Kn(int paramInt)
  {
    AppMethodBeat.i(7345);
    Integer localInteger2 = (Integer)uZX.get(Integer.valueOf(paramInt));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(-1);
    }
    paramInt = localInteger1.intValue();
    AppMethodBeat.o(7345);
    return paramInt;
  }
  
  public static void Ko(int paramInt)
  {
    AppMethodBeat.i(153174);
    h.qsU.idkeyStat(1061L, paramInt, 1L, false);
    AppMethodBeat.o(153174);
  }
  
  public static int ahY(String paramString)
  {
    AppMethodBeat.i(7346);
    Integer localInteger = (Integer)uZY.get(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = Integer.valueOf(-1);
    }
    int i = paramString.intValue();
    AppMethodBeat.o(7346);
    return i;
  }
  
  public static int np(long paramLong)
  {
    if (paramLong < 0L) {
      return -1;
    }
    if (paramLong <= 2000L) {
      return 1;
    }
    if (paramLong <= 6000L) {
      return 2;
    }
    if (paramLong <= 12000L) {
      return 3;
    }
    if (paramLong <= 60000L) {
      return 4;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */