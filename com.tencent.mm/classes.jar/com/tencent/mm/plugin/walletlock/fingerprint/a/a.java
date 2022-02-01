package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long ABr = -1L;
  
  private static HashSet<String> L(JSONArray paramJSONArray)
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
      ad.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(129657);
    }
    return null;
  }
  
  public static void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129667);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = new com.tencent.mm.plugin.walletlock.gesture.a.g();
      localg.ABS = paramLong1;
      localg.ABT = paramLong2;
      localab.set(ae.a.FqX, com.tencent.mm.plugin.walletlock.gesture.a.e.bT(localg.toByteArray()));
      localab.eKy();
    }
    AppMethodBeat.o(129667);
  }
  
  private static JSONArray auI(String paramString)
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
      ad.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129656);
    }
    return null;
  }
  
  public static boolean auJ(String paramString)
  {
    AppMethodBeat.i(129659);
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = auI(efQ());
      HashSet localHashSet = L((JSONArray)localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        ad.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
        localObject1 = new JSONArray();
      }
      localObject2 = localHashSet;
      if (localHashSet == null)
      {
        ad.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
        localObject2 = new HashSet();
      }
      ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[] { ((JSONArray)localObject1).toString() });
      if (!((HashSet)localObject2).contains(paramString))
      {
        ad.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[] { paramString, Boolean.FALSE });
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fid", paramString);
        ((JSONArray)localObject1).put(localObject2);
        ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[] { ((JSONArray)localObject1).toString() });
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqU, ((JSONArray)localObject1).toString());
        com.tencent.mm.kernel.g.afB().afk().eKy();
        AppMethodBeat.o(129659);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129659);
    }
    return false;
  }
  
  public static boolean auK(String paramString)
  {
    AppMethodBeat.i(129660);
    Object localObject = efQ();
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = L(auI((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(129660);
      return true;
    }
    AppMethodBeat.o(129660);
    return false;
  }
  
  private static String efQ()
  {
    AppMethodBeat.i(129658);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqU, null);
    AppMethodBeat.o(129658);
    return str;
  }
  
  public static void efR()
  {
    AppMethodBeat.i(129661);
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { bt.eGN() });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqU, null);
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(129661);
  }
  
  public static boolean efS()
  {
    AppMethodBeat.i(129662);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqT, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129662);
    return bool;
  }
  
  public static boolean efT()
  {
    AppMethodBeat.i(129664);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqZ, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129664);
    return bool;
  }
  
  public static boolean efU()
  {
    AppMethodBeat.i(129666);
    Object localObject = com.tencent.mm.kernel.g.afB().afk();
    if (localObject == null) {
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
    }
    while (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).ABS != -1L)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.e.a((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject);
      if (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).ABT / 1000L < 30L)
      {
        ar(((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).ABS, ((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).ABT);
        AppMethodBeat.o(129666);
        return true;
        localObject = (String)((ab)localObject).get(ae.a.FqX, null);
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g().bU(com.tencent.mm.plugin.walletlock.gesture.a.e.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = com.tencent.mm.kernel.g.afB().afk();
        if (localObject != null)
        {
          ((ab)localObject).set(ae.a.FqX, null);
          ((ab)localObject).eKy();
        }
        AppMethodBeat.o(129666);
        return false;
      }
    }
    AppMethodBeat.o(129666);
    return false;
  }
  
  public static void efV()
  {
    ABr = -1L;
  }
  
  public static long efW()
  {
    return ABr;
  }
  
  public static void sS(boolean paramBoolean)
  {
    AppMethodBeat.i(129663);
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqT, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(129663);
  }
  
  public static void sT(boolean paramBoolean)
  {
    AppMethodBeat.i(129665);
    ad.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqZ, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(129665);
  }
  
  public static void uT(long paramLong)
  {
    ABr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */