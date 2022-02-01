package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long Dug = -1L;
  
  public static void Ci(long paramLong)
  {
    Dug = paramLong;
  }
  
  private static HashSet<String> M(JSONArray paramJSONArray)
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
  
  private static JSONArray aFj(String paramString)
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
  
  public static boolean aFk(String paramString)
  {
    AppMethodBeat.i(129659);
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = aFj(eJq());
      HashSet localHashSet = M((JSONArray)localObject2);
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
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBf, ((JSONArray)localObject1).toString());
        com.tencent.mm.kernel.g.ajC().ajl().fqc();
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
  
  public static boolean aFl(String paramString)
  {
    AppMethodBeat.i(129660);
    Object localObject = eJq();
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = M(aFj((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(129660);
      return true;
    }
    AppMethodBeat.o(129660);
    return false;
  }
  
  public static void av(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129667);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = new com.tencent.mm.plugin.walletlock.gesture.a.g();
      localg.DuH = paramLong1;
      localg.DuI = paramLong2;
      localai.set(al.a.IBi, com.tencent.mm.plugin.walletlock.gesture.a.e.bZ(localg.toByteArray()));
      localai.fqc();
    }
    AppMethodBeat.o(129667);
  }
  
  private static String eJq()
  {
    AppMethodBeat.i(129658);
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBf, null);
    AppMethodBeat.o(129658);
    return str;
  }
  
  public static void eJr()
  {
    AppMethodBeat.i(129661);
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { bt.flS() });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBf, null);
    com.tencent.mm.kernel.g.ajC().ajl().fqc();
    AppMethodBeat.o(129661);
  }
  
  public static boolean eJs()
  {
    AppMethodBeat.i(129662);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBe, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129662);
    return bool;
  }
  
  public static boolean eJt()
  {
    AppMethodBeat.i(129664);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBk, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129664);
    return bool;
  }
  
  public static boolean eJu()
  {
    AppMethodBeat.i(129666);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl();
    if (localObject == null) {
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
    }
    while (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DuH != -1L)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.e.a((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject);
      if (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DuI / 1000L < 30L)
      {
        av(((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DuH, ((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).DuI);
        AppMethodBeat.o(129666);
        return true;
        localObject = (String)((ai)localObject).get(al.a.IBi, null);
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g().ca(com.tencent.mm.plugin.walletlock.gesture.a.e.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = com.tencent.mm.kernel.g.ajC().ajl();
        if (localObject != null)
        {
          ((ai)localObject).set(al.a.IBi, null);
          ((ai)localObject).fqc();
        }
        AppMethodBeat.o(129666);
        return false;
      }
    }
    AppMethodBeat.o(129666);
    return false;
  }
  
  public static void eJv()
  {
    Dug = -1L;
  }
  
  public static long eJw()
  {
    return Dug;
  }
  
  public static void uD(boolean paramBoolean)
  {
    AppMethodBeat.i(129663);
    ad.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBe, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.ajC().ajl().fqc();
    AppMethodBeat.o(129663);
  }
  
  public static void uE(boolean paramBoolean)
  {
    AppMethodBeat.i(129665);
    ad.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBk, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.ajC().ajl().fqc();
    AppMethodBeat.o(129665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */