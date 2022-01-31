package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static Map<String, List<Integer>> tVj;
  private static Map<String, Boolean> tVk;
  private static Map<String, Integer> tVl;
  
  static
  {
    AppMethodBeat.i(45918);
    tVj = new ConcurrentHashMap();
    tVk = new ConcurrentHashMap();
    tVl = new ConcurrentHashMap();
    AppMethodBeat.o(45918);
  }
  
  public static void aeW(String paramString)
  {
    AppMethodBeat.i(45910);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45910);
      return;
    }
    if (tVl.containsKey(paramString))
    {
      localInteger = (Integer)tVl.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      tVl.put(paramString, localInteger);
      AppMethodBeat.o(45910);
      return;
    }
  }
  
  public static void aeX(String paramString)
  {
    AppMethodBeat.i(45911);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45911);
      return;
    }
    tVl.remove(paramString);
    AppMethodBeat.o(45911);
  }
  
  private static boolean aeY(String paramString)
  {
    AppMethodBeat.i(45913);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45913);
      return false;
    }
    if (tVl.containsKey(paramString))
    {
      paramString = (Integer)tVl.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(45913);
        return false;
      }
      if (paramString.intValue() > 1)
      {
        AppMethodBeat.o(45913);
        return true;
      }
    }
    AppMethodBeat.o(45913);
    return false;
  }
  
  public static void aeZ(String paramString)
  {
    AppMethodBeat.i(45916);
    if ((!bo.isNullOrNil(paramString)) && (!tVj.containsKey(paramString))) {
      tVj.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(45916);
  }
  
  public static void afa(String paramString)
  {
    AppMethodBeat.i(45917);
    if (!bo.isNullOrNil(paramString))
    {
      tVj.remove(paramString);
      tVk.remove(paramString);
    }
    AppMethodBeat.o(45917);
  }
  
  public static void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(45915);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45915);
      return;
    }
    tVk.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(45915);
  }
  
  public static void dD(String paramString, int paramInt)
  {
    AppMethodBeat.i(45912);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45912);
      return;
    }
    if (!tVj.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      tVj.put(paramString, localObject);
      AppMethodBeat.o(45912);
      return;
    }
    Object localObject = (List)tVj.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    tVj.put(paramString, localObject);
    AppMethodBeat.o(45912);
  }
  
  public static void r(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(45914);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45914);
      return;
    }
    if ((tVj.containsKey(paramString)) && (((List)tVj.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      h.qsU.j(965L, 10L, 1L);
      h.qsU.j(965L, 30L, 1L);
      if (aeY(paramString)) {
        h.qsU.j(965L, 25L, 1L);
      }
      if (aeY(paramString)) {
        h.qsU.j(965L, 24L, 1L);
      }
      h.qsU.j(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      h.qsU.j(965L, 20L, 1L);
    }
    for (;;)
    {
      if (tVk.containsKey(paramString))
      {
        paramString = (Boolean)tVk.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            h.qsU.j(965L, 18L, 1L);
            AppMethodBeat.o(45914);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            h.qsU.j(965L, 11L, 1L);
            h.qsU.j(965L, 31L, 1L);
            if (!aeY(paramString)) {
              break;
            }
            h.qsU.j(965L, 26L, 1L);
            break;
            label260:
            h.qsU.j(965L, 21L, 1L);
            continue;
          }
          h.qsU.j(965L, 19L, 1L);
        }
      }
    }
    AppMethodBeat.o(45914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b
 * JD-Core Version:    0.7.0.1
 */