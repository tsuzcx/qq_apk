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
  private static Map<String, List<Integer>> VmC;
  private static Map<String, Boolean> VmD;
  private static Map<String, Integer> VmE;
  
  static
  {
    AppMethodBeat.i(69261);
    VmC = new ConcurrentHashMap();
    VmD = new ConcurrentHashMap();
    VmE = new ConcurrentHashMap();
    AppMethodBeat.o(69261);
  }
  
  public static void A(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69257);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69257);
      return;
    }
    if ((VmC.containsKey(paramString)) && (((List)VmC.get(paramString)).size() > 0))
    {
      if (paramInt != 1) {
        break label206;
      }
      h.OAn.p(965L, 10L, 1L);
      h.OAn.p(965L, 30L, 1L);
      if (bgi(paramString)) {
        h.OAn.p(965L, 25L, 1L);
      }
      if (bgi(paramString)) {
        h.OAn.p(965L, 24L, 1L);
      }
      h.OAn.p(965L, 29L, 1L);
      if (!paramBoolean) {
        break label260;
      }
      h.OAn.p(965L, 20L, 1L);
    }
    for (;;)
    {
      if (VmD.containsKey(paramString))
      {
        paramString = (Boolean)VmD.get(paramString);
        if (paramString != null)
        {
          if (paramString.booleanValue())
          {
            h.OAn.p(965L, 18L, 1L);
            AppMethodBeat.o(69257);
            return;
            label206:
            if (paramInt != 2) {
              break;
            }
            h.OAn.p(965L, 11L, 1L);
            h.OAn.p(965L, 31L, 1L);
            if (!bgi(paramString)) {
              break;
            }
            h.OAn.p(965L, 26L, 1L);
            break;
            label260:
            h.OAn.p(965L, 21L, 1L);
            continue;
          }
          h.OAn.p(965L, 19L, 1L);
        }
      }
    }
    AppMethodBeat.o(69257);
  }
  
  public static void bgg(String paramString)
  {
    AppMethodBeat.i(69253);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69253);
      return;
    }
    if (VmE.containsKey(paramString))
    {
      localInteger = (Integer)VmE.get(paramString);
      if (localInteger == null) {}
    }
    for (Integer localInteger = Integer.valueOf(localInteger.intValue() + 1);; localInteger = Integer.valueOf(1))
    {
      VmE.put(paramString, localInteger);
      AppMethodBeat.o(69253);
      return;
    }
  }
  
  public static void bgh(String paramString)
  {
    AppMethodBeat.i(69254);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69254);
      return;
    }
    VmE.remove(paramString);
    AppMethodBeat.o(69254);
  }
  
  private static boolean bgi(String paramString)
  {
    AppMethodBeat.i(69256);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69256);
      return false;
    }
    if (VmE.containsKey(paramString))
    {
      paramString = (Integer)VmE.get(paramString);
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
  
  public static void bgj(String paramString)
  {
    AppMethodBeat.i(69259);
    if ((!Util.isNullOrNil(paramString)) && (!VmC.containsKey(paramString))) {
      VmC.put(paramString, new ArrayList());
    }
    AppMethodBeat.o(69259);
  }
  
  public static void bgk(String paramString)
  {
    AppMethodBeat.i(69260);
    if (!Util.isNullOrNil(paramString))
    {
      VmC.remove(paramString);
      VmD.remove(paramString);
    }
    AppMethodBeat.o(69260);
  }
  
  public static void dz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69258);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69258);
      return;
    }
    VmD.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(69258);
  }
  
  public static void hE(String paramString, int paramInt)
  {
    AppMethodBeat.i(69255);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69255);
      return;
    }
    if (!VmC.containsKey(paramString))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      VmC.put(paramString, localObject);
      AppMethodBeat.o(69255);
      return;
    }
    Object localObject = (List)VmC.get(paramString);
    ((List)localObject).add(Integer.valueOf(paramInt));
    VmC.put(paramString, localObject);
    AppMethodBeat.o(69255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b
 * JD-Core Version:    0.7.0.1
 */