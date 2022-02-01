package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Integer> Cub;
  private static final Map<Integer, Integer> Cuc;
  private static final Map<Integer, Integer> Cud;
  private static final Map<String, Integer> Cue;
  
  static
  {
    AppMethodBeat.i(205395);
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
    Cub = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(-1), Integer.valueOf(4));
    localHashMap.put(Integer.valueOf(-2), Integer.valueOf(5));
    localHashMap.put(Integer.valueOf(-3), Integer.valueOf(6));
    localHashMap.put(Integer.valueOf(-4), Integer.valueOf(7));
    localHashMap.put(Integer.valueOf(-5), Integer.valueOf(8));
    localHashMap.put(Integer.valueOf(-6), Integer.valueOf(9));
    Cuc = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(0));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(1));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(2));
    Cud = Collections.unmodifiableMap(localHashMap);
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
    Cue = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(205395);
  }
  
  public static int Vg(int paramInt)
  {
    AppMethodBeat.i(205390);
    Integer localInteger2 = (Integer)Cub.get(Integer.valueOf(paramInt));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = (Integer)Cub.get(Integer.valueOf(-1));
    }
    paramInt = localInteger1.intValue();
    AppMethodBeat.o(205390);
    return paramInt;
  }
  
  public static int Vh(int paramInt)
  {
    AppMethodBeat.i(205391);
    Integer localInteger2 = (Integer)Cuc.get(Integer.valueOf(paramInt));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = (Integer)Cuc.get(Integer.valueOf(-1));
    }
    paramInt = localInteger1.intValue();
    AppMethodBeat.o(205391);
    return paramInt;
  }
  
  public static int Vi(int paramInt)
  {
    AppMethodBeat.i(205392);
    Integer localInteger2 = (Integer)Cud.get(Integer.valueOf(paramInt));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(-1);
    }
    paramInt = localInteger1.intValue();
    AppMethodBeat.o(205392);
    return paramInt;
  }
  
  public static void Vj(int paramInt)
  {
    AppMethodBeat.i(205394);
    h.wUl.idkeyStat(1061L, paramInt, 1L, false);
    AppMethodBeat.o(205394);
  }
  
  public static int aCK(String paramString)
  {
    AppMethodBeat.i(205393);
    Integer localInteger = (Integer)Cue.get(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = Integer.valueOf(-1);
    }
    int i = paramString.intValue();
    AppMethodBeat.o(205393);
    return i;
  }
  
  public static int zD(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.a
 * JD-Core Version:    0.7.0.1
 */