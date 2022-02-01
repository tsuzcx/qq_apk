package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static Map<String, List<Integer>> zPw;
  private static Map<String, Boolean> zPx;
  private static Map<String, Integer> zPy;
  
  static
  {
    AppMethodBeat.i(69261);
    zPw = new ConcurrentHashMap();
    zPx = new ConcurrentHashMap();
    zPy = new ConcurrentHashMap();
    AppMethodBeat.o(69261);
  }
  
  public static void atA(String paramString)
  {
    AppMethodBeat.i(69253);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69253);
      return;
    }
    if (zPy.containsKey(paramString))
    {
      localInteger = (Integer)zPy.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      zPy.put(paramString, localInteger);
      AppMethodBeat.o(69253);
      return;
    }
  }
  
  public static void atB(String paramString)
  {
    AppMethodBeat.i(69254);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69254);
      return;
    }
    zPy.remove(paramString);
    AppMethodBeat.o(69254);
  }
  
  private static boolean atC(String paramString)
  {
    AppMethodBeat.i(69256);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69256);
      return false;
    }
    if (zPy.containsKey(paramString))
    {
      paramString = (Integer)zPy.get(paramString);
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
  
  public static void atD(String paramString)
  {
    AppMethodBeat.i(69259);
    if ((!bt.isNullOrNil(paramString)) && (!zPw.containsKey(paramString))) {
      zPw.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(69259);
  }
  
  public static void atE(String paramString)
  {
    AppMethodBeat.i(69260);
    if (!bt.isNullOrNil(paramString))
    {
      zPw.remove(paramString);
      zPx.remove(paramString);
    }
    AppMethodBeat.o(69260);
  }
  
  public static void bR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69258);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69258);
      return;
    }
    zPx.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(69258);
  }
  
  public static void eL(String paramString, int paramInt)
  {
    AppMethodBeat.i(69255);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69255);
      return;
    }
    if (!zPw.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      zPw.put(paramString, localObject);
      AppMethodBeat.o(69255);
      return;
    }
    Object localObject = (List)zPw.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    zPw.put(paramString, localObject);
    AppMethodBeat.o(69255);
  }
  
  public static void r(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69257);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69257);
      return;
    }
    if ((zPw.containsKey(paramString)) && (((List)zPw.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      h.vKh.m(965L, 10L, 1L);
      h.vKh.m(965L, 30L, 1L);
      if (atC(paramString)) {
        h.vKh.m(965L, 25L, 1L);
      }
      if (atC(paramString)) {
        h.vKh.m(965L, 24L, 1L);
      }
      h.vKh.m(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      h.vKh.m(965L, 20L, 1L);
    }
    for (;;)
    {
      if (zPx.containsKey(paramString))
      {
        paramString = (Boolean)zPx.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            h.vKh.m(965L, 18L, 1L);
            AppMethodBeat.o(69257);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            h.vKh.m(965L, 11L, 1L);
            h.vKh.m(965L, 31L, 1L);
            if (!atC(paramString)) {
              break;
            }
            h.vKh.m(965L, 26L, 1L);
            break;
            label260:
            h.vKh.m(965L, 21L, 1L);
            continue;
          }
          h.vKh.m(965L, 19L, 1L);
        }
      }
    }
    AppMethodBeat.o(69257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b
 * JD-Core Version:    0.7.0.1
 */