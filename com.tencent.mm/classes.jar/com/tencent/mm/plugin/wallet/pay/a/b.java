package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static Map<String, Integer> HFA;
  private static Map<String, List<Integer>> HFy;
  private static Map<String, Boolean> HFz;
  
  static
  {
    AppMethodBeat.i(69261);
    HFy = new ConcurrentHashMap();
    HFz = new ConcurrentHashMap();
    HFA = new ConcurrentHashMap();
    AppMethodBeat.o(69261);
  }
  
  public static void aUR(String paramString)
  {
    AppMethodBeat.i(69253);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69253);
      return;
    }
    if (HFA.containsKey(paramString))
    {
      localInteger = (Integer)HFA.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      HFA.put(paramString, localInteger);
      AppMethodBeat.o(69253);
      return;
    }
  }
  
  public static void aUS(String paramString)
  {
    AppMethodBeat.i(69254);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69254);
      return;
    }
    HFA.remove(paramString);
    AppMethodBeat.o(69254);
  }
  
  private static boolean aUT(String paramString)
  {
    AppMethodBeat.i(69256);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69256);
      return false;
    }
    if (HFA.containsKey(paramString))
    {
      paramString = (Integer)HFA.get(paramString);
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
  
  public static void aUU(String paramString)
  {
    AppMethodBeat.i(69259);
    if ((!Util.isNullOrNil(paramString)) && (!HFy.containsKey(paramString))) {
      HFy.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(69259);
  }
  
  public static void aUV(String paramString)
  {
    AppMethodBeat.i(69260);
    if (!Util.isNullOrNil(paramString))
    {
      HFy.remove(paramString);
      HFz.remove(paramString);
    }
    AppMethodBeat.o(69260);
  }
  
  public static void cD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69258);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69258);
      return;
    }
    HFz.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(69258);
  }
  
  public static void fY(String paramString, int paramInt)
  {
    AppMethodBeat.i(69255);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69255);
      return;
    }
    if (!HFy.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      HFy.put(paramString, localObject);
      AppMethodBeat.o(69255);
      return;
    }
    Object localObject = (List)HFy.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    HFy.put(paramString, localObject);
    AppMethodBeat.o(69255);
  }
  
  public static void u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69257);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69257);
      return;
    }
    if ((HFy.containsKey(paramString)) && (((List)HFy.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      h.CyF.n(965L, 10L, 1L);
      h.CyF.n(965L, 30L, 1L);
      if (aUT(paramString)) {
        h.CyF.n(965L, 25L, 1L);
      }
      if (aUT(paramString)) {
        h.CyF.n(965L, 24L, 1L);
      }
      h.CyF.n(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      h.CyF.n(965L, 20L, 1L);
    }
    for (;;)
    {
      if (HFz.containsKey(paramString))
      {
        paramString = (Boolean)HFz.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            h.CyF.n(965L, 18L, 1L);
            AppMethodBeat.o(69257);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            h.CyF.n(965L, 11L, 1L);
            h.CyF.n(965L, 31L, 1L);
            if (!aUT(paramString)) {
              break;
            }
            h.CyF.n(965L, 26L, 1L);
            break;
            label260:
            h.CyF.n(965L, 21L, 1L);
            continue;
          }
          h.CyF.n(965L, 19L, 1L);
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