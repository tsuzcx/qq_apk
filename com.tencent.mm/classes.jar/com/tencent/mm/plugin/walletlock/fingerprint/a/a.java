package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long BTM = -1L;
  
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
      ac.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(129657);
    }
    return null;
  }
  
  public static boolean aAa(String paramString)
  {
    AppMethodBeat.i(129659);
    ac.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = azZ(evk());
      HashSet localHashSet = L((JSONArray)localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        ac.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
        localObject1 = new JSONArray();
      }
      localObject2 = localHashSet;
      if (localHashSet == null)
      {
        ac.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
        localObject2 = new HashSet();
      }
      ac.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[] { ((JSONArray)localObject1).toString() });
      if (!((HashSet)localObject2).contains(paramString))
      {
        ac.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[] { paramString, Boolean.FALSE });
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fid", paramString);
        ((JSONArray)localObject1).put(localObject2);
        ac.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[] { ((JSONArray)localObject1).toString() });
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOK, ((JSONArray)localObject1).toString());
        com.tencent.mm.kernel.g.agR().agA().faa();
        AppMethodBeat.o(129659);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129659);
    }
    return false;
  }
  
  public static boolean aAb(String paramString)
  {
    AppMethodBeat.i(129660);
    Object localObject = evk();
    ac.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = L(azZ((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(129660);
      return true;
    }
    AppMethodBeat.o(129660);
    return false;
  }
  
  public static void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129667);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = new com.tencent.mm.plugin.walletlock.gesture.a.g();
      localg.BUn = paramLong1;
      localg.BUo = paramLong2;
      localae.set(ah.a.GON, com.tencent.mm.plugin.walletlock.gesture.a.e.bS(localg.toByteArray()));
      localae.faa();
    }
    AppMethodBeat.o(129667);
  }
  
  private static JSONArray azZ(String paramString)
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
      ac.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129656);
    }
    return null;
  }
  
  private static String evk()
  {
    AppMethodBeat.i(129658);
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOK, null);
    AppMethodBeat.o(129658);
    return str;
  }
  
  public static void evl()
  {
    AppMethodBeat.i(129661);
    ac.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { bs.eWi() });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOK, null);
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(129661);
  }
  
  public static boolean evm()
  {
    AppMethodBeat.i(129662);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOJ, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129662);
    return bool;
  }
  
  public static boolean evn()
  {
    AppMethodBeat.i(129664);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOP, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129664);
    return bool;
  }
  
  public static boolean evo()
  {
    AppMethodBeat.i(129666);
    Object localObject = com.tencent.mm.kernel.g.agR().agA();
    if (localObject == null) {
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
    }
    while (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).BUn != -1L)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.e.a((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject);
      if (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).BUo / 1000L < 30L)
      {
        aq(((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).BUn, ((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).BUo);
        AppMethodBeat.o(129666);
        return true;
        localObject = (String)((ae)localObject).get(ah.a.GON, null);
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g().bT(com.tencent.mm.plugin.walletlock.gesture.a.e.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = com.tencent.mm.kernel.g.agR().agA();
        if (localObject != null)
        {
          ((ae)localObject).set(ah.a.GON, null);
          ((ae)localObject).faa();
        }
        AppMethodBeat.o(129666);
        return false;
      }
    }
    AppMethodBeat.o(129666);
    return false;
  }
  
  public static void evp()
  {
    BTM = -1L;
  }
  
  public static long evq()
  {
    return BTM;
  }
  
  public static void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(129663);
    ac.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOJ, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(129663);
  }
  
  public static void tU(boolean paramBoolean)
  {
    AppMethodBeat.i(129665);
    ac.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOP, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(129665);
  }
  
  public static void zw(long paramLong)
  {
    BTM = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */