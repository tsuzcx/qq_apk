package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long Iva = -1L;
  
  public static void LU(long paramLong)
  {
    Iva = paramLong;
  }
  
  private static HashSet<String> S(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(129657);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(129657);
      return null;
    }
    try
    {
      HashSet localHashSet = new HashSet();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localHashSet.add(paramJSONArray.getJSONObject(i).getString("fid"));
        i += 1;
      }
      AppMethodBeat.o(129657);
      return localHashSet;
    }
    catch (Exception paramJSONArray)
    {
      Log.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(129657);
    }
    return null;
  }
  
  public static void aB(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129667);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = new com.tencent.mm.plugin.walletlock.gesture.a.g();
      localg.IvB = paramLong1;
      localg.IvC = paramLong2;
      localao.set(ar.a.OdZ, com.tencent.mm.plugin.walletlock.gesture.a.e.bytesToString(localg.toByteArray()));
      localao.gBI();
    }
    AppMethodBeat.o(129667);
  }
  
  private static JSONArray aWf(String paramString)
  {
    AppMethodBeat.i(129656);
    if (paramString == null)
    {
      AppMethodBeat.o(129656);
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      AppMethodBeat.o(129656);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129656);
    }
    return null;
  }
  
  public static boolean aWg(String paramString)
  {
    AppMethodBeat.i(129659);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = aWf(fUH());
      HashSet localHashSet = S((JSONArray)localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Log.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
        localObject1 = new JSONArray();
      }
      localObject2 = localHashSet;
      if (localHashSet == null)
      {
        Log.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
        localObject2 = new HashSet();
      }
      Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[] { ((JSONArray)localObject1).toString() });
      if (!((HashSet)localObject2).contains(paramString))
      {
        Log.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[] { paramString, Boolean.FALSE });
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fid", paramString);
        ((JSONArray)localObject1).put(localObject2);
        Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[] { ((JSONArray)localObject1).toString() });
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdW, ((JSONArray)localObject1).toString());
        com.tencent.mm.kernel.g.aAh().azQ().gBI();
        AppMethodBeat.o(129659);
        return true;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129659);
    }
    return false;
  }
  
  public static boolean aWh(String paramString)
  {
    AppMethodBeat.i(129660);
    Object localObject = fUH();
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = S(aWf((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(129660);
      return true;
    }
    AppMethodBeat.o(129660);
    return false;
  }
  
  private static String fUH()
  {
    AppMethodBeat.i(129658);
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdW, null);
    AppMethodBeat.o(129658);
    return str;
  }
  
  public static void fUI()
  {
    AppMethodBeat.i(129661);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { Util.getStack() });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdW, null);
    com.tencent.mm.kernel.g.aAh().azQ().gBI();
    AppMethodBeat.o(129661);
  }
  
  public static boolean fUJ()
  {
    AppMethodBeat.i(129662);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdV, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129662);
    return bool;
  }
  
  public static boolean fUK()
  {
    AppMethodBeat.i(129664);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oeb, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129664);
    return bool;
  }
  
  public static boolean fUL()
  {
    AppMethodBeat.i(129666);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ();
    if (localObject == null) {
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
    }
    while (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).IvB != -1L)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.e.a((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject);
      if (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).IvC / 1000L < 30L)
      {
        aB(((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).IvB, ((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).IvC);
        AppMethodBeat.o(129666);
        return true;
        localObject = (String)((ao)localObject).get(ar.a.OdZ, null);
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g().cu(com.tencent.mm.plugin.walletlock.gesture.a.e.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = com.tencent.mm.kernel.g.aAh().azQ();
        if (localObject != null)
        {
          ((ao)localObject).set(ar.a.OdZ, null);
          ((ao)localObject).gBI();
        }
        AppMethodBeat.o(129666);
        return false;
      }
    }
    AppMethodBeat.o(129666);
    return false;
  }
  
  public static void fUM()
  {
    Iva = -1L;
  }
  
  public static long fUN()
  {
    return Iva;
  }
  
  public static void yA(boolean paramBoolean)
  {
    AppMethodBeat.i(129663);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdV, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.aAh().azQ().gBI();
    AppMethodBeat.o(129663);
  }
  
  public static void yB(boolean paramBoolean)
  {
    AppMethodBeat.i(129665);
    Log.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oeb, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.aAh().azQ().gBI();
    AppMethodBeat.o(129665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */