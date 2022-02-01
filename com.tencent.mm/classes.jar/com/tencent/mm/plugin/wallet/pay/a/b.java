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
  private static Map<String, List<Integer>> Oxr;
  private static Map<String, Boolean> Oxs;
  private static Map<String, Integer> Oxt;
  
  static
  {
    AppMethodBeat.i(69261);
    Oxr = new ConcurrentHashMap();
    Oxs = new ConcurrentHashMap();
    Oxt = new ConcurrentHashMap();
    AppMethodBeat.o(69261);
  }
  
  public static void bgA(String paramString)
  {
    AppMethodBeat.i(69253);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69253);
      return;
    }
    if (Oxt.containsKey(paramString))
    {
      localInteger = (Integer)Oxt.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      Oxt.put(paramString, localInteger);
      AppMethodBeat.o(69253);
      return;
    }
  }
  
  public static void bgB(String paramString)
  {
    AppMethodBeat.i(69254);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69254);
      return;
    }
    Oxt.remove(paramString);
    AppMethodBeat.o(69254);
  }
  
  private static boolean bgC(String paramString)
  {
    AppMethodBeat.i(69256);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69256);
      return false;
    }
    if (Oxt.containsKey(paramString))
    {
      paramString = (Integer)Oxt.get(paramString);
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
  
  public static void bgD(String paramString)
  {
    AppMethodBeat.i(69259);
    if ((!Util.isNullOrNil(paramString)) && (!Oxr.containsKey(paramString))) {
      Oxr.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(69259);
  }
  
  public static void bgE(String paramString)
  {
    AppMethodBeat.i(69260);
    if (!Util.isNullOrNil(paramString))
    {
      Oxr.remove(paramString);
      Oxs.remove(paramString);
    }
    AppMethodBeat.o(69260);
  }
  
  public static void cR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69258);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69258);
      return;
    }
    Oxs.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(69258);
  }
  
  public static void gH(String paramString, int paramInt)
  {
    AppMethodBeat.i(69255);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69255);
      return;
    }
    if (!Oxr.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      Oxr.put(paramString, localObject);
      AppMethodBeat.o(69255);
      return;
    }
    Object localObject = (List)Oxr.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    Oxr.put(paramString, localObject);
    AppMethodBeat.o(69255);
  }
  
  public static void y(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69257);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69257);
      return;
    }
    if ((Oxr.containsKey(paramString)) && (((List)Oxr.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      h.IzE.p(965L, 10L, 1L);
      h.IzE.p(965L, 30L, 1L);
      if (bgC(paramString)) {
        h.IzE.p(965L, 25L, 1L);
      }
      if (bgC(paramString)) {
        h.IzE.p(965L, 24L, 1L);
      }
      h.IzE.p(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      h.IzE.p(965L, 20L, 1L);
    }
    for (;;)
    {
      if (Oxs.containsKey(paramString))
      {
        paramString = (Boolean)Oxs.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            h.IzE.p(965L, 18L, 1L);
            AppMethodBeat.o(69257);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            h.IzE.p(965L, 11L, 1L);
            h.IzE.p(965L, 31L, 1L);
            if (!bgC(paramString)) {
              break;
            }
            h.IzE.p(965L, 26L, 1L);
            break;
            label260:
            h.IzE.p(965L, 21L, 1L);
            continue;
          }
          h.IzE.p(965L, 19L, 1L);
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