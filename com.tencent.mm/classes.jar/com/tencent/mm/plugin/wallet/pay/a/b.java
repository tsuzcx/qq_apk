package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static Map<String, List<Integer>> CZK;
  private static Map<String, Boolean> CZL;
  private static Map<String, Integer> CZM;
  
  static
  {
    AppMethodBeat.i(69261);
    CZK = new ConcurrentHashMap();
    CZL = new ConcurrentHashMap();
    CZM = new ConcurrentHashMap();
    AppMethodBeat.o(69261);
  }
  
  public static void aFt(String paramString)
  {
    AppMethodBeat.i(69253);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69253);
      return;
    }
    if (CZM.containsKey(paramString))
    {
      localInteger = (Integer)CZM.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      CZM.put(paramString, localInteger);
      AppMethodBeat.o(69253);
      return;
    }
  }
  
  public static void aFu(String paramString)
  {
    AppMethodBeat.i(69254);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69254);
      return;
    }
    CZM.remove(paramString);
    AppMethodBeat.o(69254);
  }
  
  private static boolean aFv(String paramString)
  {
    AppMethodBeat.i(69256);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69256);
      return false;
    }
    if (CZM.containsKey(paramString))
    {
      paramString = (Integer)CZM.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(69256);
        return false;
      }
      if (paramString.intValue() > 1)
      {
        AppMethodBeat.o(69256);
        return true;
      }
    }
    AppMethodBeat.o(69256);
    return false;
  }
  
  public static void aFw(String paramString)
  {
    AppMethodBeat.i(69259);
    if ((!bu.isNullOrNil(paramString)) && (!CZK.containsKey(paramString))) {
      CZK.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(69259);
  }
  
  public static void aFx(String paramString)
  {
    AppMethodBeat.i(69260);
    if (!bu.isNullOrNil(paramString))
    {
      CZK.remove(paramString);
      CZL.remove(paramString);
    }
    AppMethodBeat.o(69260);
  }
  
  public static void ck(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69258);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69258);
      return;
    }
    CZL.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(69258);
  }
  
  public static void fv(String paramString, int paramInt)
  {
    AppMethodBeat.i(69255);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69255);
      return;
    }
    if (!CZK.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      CZK.put(paramString, localObject);
      AppMethodBeat.o(69255);
      return;
    }
    Object localObject = (List)CZK.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    CZK.put(paramString, localObject);
    AppMethodBeat.o(69255);
  }
  
  public static void r(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69257);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69257);
      return;
    }
    if ((CZK.containsKey(paramString)) && (((List)CZK.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      g.yxI.n(965L, 10L, 1L);
      g.yxI.n(965L, 30L, 1L);
      if (aFv(paramString)) {
        g.yxI.n(965L, 25L, 1L);
      }
      if (aFv(paramString)) {
        g.yxI.n(965L, 24L, 1L);
      }
      g.yxI.n(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      g.yxI.n(965L, 20L, 1L);
    }
    for (;;)
    {
      if (CZL.containsKey(paramString))
      {
        paramString = (Boolean)CZL.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            g.yxI.n(965L, 18L, 1L);
            AppMethodBeat.o(69257);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            g.yxI.n(965L, 11L, 1L);
            g.yxI.n(965L, 31L, 1L);
            if (!aFv(paramString)) {
              break;
            }
            g.yxI.n(965L, 26L, 1L);
            break;
            label260:
            g.yxI.n(965L, 21L, 1L);
            continue;
          }
          g.yxI.n(965L, 19L, 1L);
        }
      }
    }
    AppMethodBeat.o(69257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b
 * JD-Core Version:    0.7.0.1
 */