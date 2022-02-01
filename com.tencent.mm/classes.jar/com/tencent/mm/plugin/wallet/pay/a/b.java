package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static Map<String, List<Integer>> CIe;
  private static Map<String, Boolean> CIf;
  private static Map<String, Integer> CIg;
  
  static
  {
    AppMethodBeat.i(69261);
    CIe = new ConcurrentHashMap();
    CIf = new ConcurrentHashMap();
    CIg = new ConcurrentHashMap();
    AppMethodBeat.o(69261);
  }
  
  public static void aEa(String paramString)
  {
    AppMethodBeat.i(69253);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69253);
      return;
    }
    if (CIg.containsKey(paramString))
    {
      localInteger = (Integer)CIg.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      CIg.put(paramString, localInteger);
      AppMethodBeat.o(69253);
      return;
    }
  }
  
  public static void aEb(String paramString)
  {
    AppMethodBeat.i(69254);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69254);
      return;
    }
    CIg.remove(paramString);
    AppMethodBeat.o(69254);
  }
  
  private static boolean aEc(String paramString)
  {
    AppMethodBeat.i(69256);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69256);
      return false;
    }
    if (CIg.containsKey(paramString))
    {
      paramString = (Integer)CIg.get(paramString);
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
  
  public static void aEd(String paramString)
  {
    AppMethodBeat.i(69259);
    if ((!bt.isNullOrNil(paramString)) && (!CIe.containsKey(paramString))) {
      CIe.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(69259);
  }
  
  public static void aEe(String paramString)
  {
    AppMethodBeat.i(69260);
    if (!bt.isNullOrNil(paramString))
    {
      CIe.remove(paramString);
      CIf.remove(paramString);
    }
    AppMethodBeat.o(69260);
  }
  
  public static void cg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69258);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69258);
      return;
    }
    CIf.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(69258);
  }
  
  public static void fm(String paramString, int paramInt)
  {
    AppMethodBeat.i(69255);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69255);
      return;
    }
    if (!CIe.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      CIe.put(paramString, localObject);
      AppMethodBeat.o(69255);
      return;
    }
    Object localObject = (List)CIe.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    CIe.put(paramString, localObject);
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
    if ((CIe.containsKey(paramString)) && (((List)CIe.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      g.yhR.n(965L, 10L, 1L);
      g.yhR.n(965L, 30L, 1L);
      if (aEc(paramString)) {
        g.yhR.n(965L, 25L, 1L);
      }
      if (aEc(paramString)) {
        g.yhR.n(965L, 24L, 1L);
      }
      g.yhR.n(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      g.yhR.n(965L, 20L, 1L);
    }
    for (;;)
    {
      if (CIf.containsKey(paramString))
      {
        paramString = (Boolean)CIf.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            g.yhR.n(965L, 18L, 1L);
            AppMethodBeat.o(69257);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            g.yhR.n(965L, 11L, 1L);
            g.yhR.n(965L, 31L, 1L);
            if (!aEc(paramString)) {
              break;
            }
            g.yhR.n(965L, 26L, 1L);
            break;
            label260:
            g.yhR.n(965L, 21L, 1L);
            continue;
          }
          g.yhR.n(965L, 19L, 1L);
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