package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static Map<String, List<Integer>> BhQ;
  private static Map<String, Boolean> BhR;
  private static Map<String, Integer> BhS;
  
  static
  {
    AppMethodBeat.i(69261);
    BhQ = new ConcurrentHashMap();
    BhR = new ConcurrentHashMap();
    BhS = new ConcurrentHashMap();
    AppMethodBeat.o(69261);
  }
  
  public static void ayS(String paramString)
  {
    AppMethodBeat.i(69253);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69253);
      return;
    }
    if (BhS.containsKey(paramString))
    {
      localInteger = (Integer)BhS.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      BhS.put(paramString, localInteger);
      AppMethodBeat.o(69253);
      return;
    }
  }
  
  public static void ayT(String paramString)
  {
    AppMethodBeat.i(69254);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69254);
      return;
    }
    BhS.remove(paramString);
    AppMethodBeat.o(69254);
  }
  
  private static boolean ayU(String paramString)
  {
    AppMethodBeat.i(69256);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69256);
      return false;
    }
    if (BhS.containsKey(paramString))
    {
      paramString = (Integer)BhS.get(paramString);
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
  
  public static void ayV(String paramString)
  {
    AppMethodBeat.i(69259);
    if ((!bs.isNullOrNil(paramString)) && (!BhQ.containsKey(paramString))) {
      BhQ.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(69259);
  }
  
  public static void ayW(String paramString)
  {
    AppMethodBeat.i(69260);
    if (!bs.isNullOrNil(paramString))
    {
      BhQ.remove(paramString);
      BhR.remove(paramString);
    }
    AppMethodBeat.o(69260);
  }
  
  public static void bY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69258);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69258);
      return;
    }
    BhR.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(69258);
  }
  
  public static void eT(String paramString, int paramInt)
  {
    AppMethodBeat.i(69255);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69255);
      return;
    }
    if (!BhQ.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      BhQ.put(paramString, localObject);
      AppMethodBeat.o(69255);
      return;
    }
    Object localObject = (List)BhQ.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    BhQ.put(paramString, localObject);
    AppMethodBeat.o(69255);
  }
  
  public static void r(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69257);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69257);
      return;
    }
    if ((BhQ.containsKey(paramString)) && (((List)BhQ.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      h.wUl.n(965L, 10L, 1L);
      h.wUl.n(965L, 30L, 1L);
      if (ayU(paramString)) {
        h.wUl.n(965L, 25L, 1L);
      }
      if (ayU(paramString)) {
        h.wUl.n(965L, 24L, 1L);
      }
      h.wUl.n(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      h.wUl.n(965L, 20L, 1L);
    }
    for (;;)
    {
      if (BhR.containsKey(paramString))
      {
        paramString = (Boolean)BhR.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            h.wUl.n(965L, 18L, 1L);
            AppMethodBeat.o(69257);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            h.wUl.n(965L, 11L, 1L);
            h.wUl.n(965L, 31L, 1L);
            if (!ayU(paramString)) {
              break;
            }
            h.wUl.n(965L, 26L, 1L);
            break;
            label260:
            h.wUl.n(965L, 21L, 1L);
            continue;
          }
          h.wUl.n(965L, 19L, 1L);
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