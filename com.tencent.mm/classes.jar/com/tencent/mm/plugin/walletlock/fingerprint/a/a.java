package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long DLL = -1L;
  
  public static void CG(long paramLong)
  {
    DLL = paramLong;
  }
  
  private static HashSet<String> N(JSONArray paramJSONArray)
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
      ae.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(129657);
    }
    return null;
  }
  
  private static JSONArray aGD(String paramString)
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
      ae.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129656);
    }
    return null;
  }
  
  public static boolean aGE(String paramString)
  {
    AppMethodBeat.i(129659);
    ae.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = aGD(eMY());
      HashSet localHashSet = N((JSONArray)localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        ae.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
        localObject1 = new JSONArray();
      }
      localObject2 = localHashSet;
      if (localHashSet == null)
      {
        ae.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
        localObject2 = new HashSet();
      }
      ae.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[] { ((JSONArray)localObject1).toString() });
      if (!((HashSet)localObject2).contains(paramString))
      {
        ae.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[] { paramString, Boolean.FALSE });
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fid", paramString);
        ((JSONArray)localObject1).put(localObject2);
        ae.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[] { ((JSONArray)localObject1).toString() });
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVE, ((JSONArray)localObject1).toString());
        com.tencent.mm.kernel.g.ajR().ajA().fuc();
        AppMethodBeat.o(129659);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(129659);
    }
    return false;
  }
  
  public static boolean aGF(String paramString)
  {
    AppMethodBeat.i(129660);
    Object localObject = eMY();
    ae.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = N(aGD((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(129660);
      return true;
    }
    AppMethodBeat.o(129660);
    return false;
  }
  
  public static void au(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129667);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = new com.tencent.mm.plugin.walletlock.gesture.a.g();
      localg.DMm = paramLong1;
      localg.DMn = paramLong2;
      localaj.set(am.a.IVH, com.tencent.mm.plugin.walletlock.gesture.a.e.cc(localg.toByteArray()));
      localaj.fuc();
    }
    AppMethodBeat.o(129667);
  }
  
  private static String eMY()
  {
    AppMethodBeat.i(129658);
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVE, null);
    AppMethodBeat.o(129658);
    return str;
  }
  
  public static void eMZ()
  {
    AppMethodBeat.i(129661);
    ae.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { bu.fpN() });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVE, null);
    com.tencent.mm.kernel.g.ajR().ajA().fuc();
    AppMethodBeat.o(129661);
  }
  
  public static boolean eNa()
  {
    AppMethodBeat.i(129662);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVD, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129662);
    return bool;
  }
  
  public static boolean eNb()
  {
    AppMethodBeat.i(129664);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVJ, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129664);
    return bool;
  }
  
  public static boolean eNc()
  {
    AppMethodBeat.i(129666);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA();
    if (localObject == null) {
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
    }
    while (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DMm != -1L)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.e.a((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject);
      if (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DMn / 1000L < 30L)
      {
        au(((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DMm, ((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DMn);
        AppMethodBeat.o(129666);
        return true;
        localObject = (String)((aj)localObject).get(am.a.IVH, null);
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g().cd(com.tencent.mm.plugin.walletlock.gesture.a.e.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = com.tencent.mm.kernel.g.ajR().ajA();
        if (localObject != null)
        {
          ((aj)localObject).set(am.a.IVH, null);
          ((aj)localObject).fuc();
        }
        AppMethodBeat.o(129666);
        return false;
      }
    }
    AppMethodBeat.o(129666);
    return false;
  }
  
  public static void eNd()
  {
    DLL = -1L;
  }
  
  public static long eNe()
  {
    return DLL;
  }
  
  public static void uL(boolean paramBoolean)
  {
    AppMethodBeat.i(129663);
    ae.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVD, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.ajR().ajA().fuc();
    AppMethodBeat.o(129663);
  }
  
  public static void uM(boolean paramBoolean)
  {
    AppMethodBeat.i(129665);
    ae.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVJ, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.ajR().ajA().fuc();
    AppMethodBeat.o(129665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */