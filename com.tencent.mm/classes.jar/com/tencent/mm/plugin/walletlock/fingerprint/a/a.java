package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long uEk = -1L;
  
  private static HashSet<String> J(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(51452);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(51452);
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
      AppMethodBeat.o(51452);
      return localHashSet;
    }
    catch (Exception paramJSONArray)
    {
      ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(51452);
    }
    return null;
  }
  
  public static void ae(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(51462);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = new com.tencent.mm.plugin.walletlock.gesture.a.g();
      localg.uEM = paramLong1;
      localg.uEN = paramLong2;
      localz.set(ac.a.yIb, com.tencent.mm.plugin.walletlock.gesture.a.e.bB(localg.toByteArray()));
      localz.dww();
    }
    AppMethodBeat.o(51462);
  }
  
  private static JSONArray afX(String paramString)
  {
    AppMethodBeat.i(51451);
    if (paramString == null)
    {
      AppMethodBeat.o(51451);
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      AppMethodBeat.o(51451);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(51451);
    }
    return null;
  }
  
  public static boolean afY(String paramString)
  {
    AppMethodBeat.i(51454);
    ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = afX(cXw());
      HashSet localHashSet = J((JSONArray)localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        ab.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
        localObject1 = new JSONArray();
      }
      localObject2 = localHashSet;
      if (localHashSet == null)
      {
        ab.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
        localObject2 = new HashSet();
      }
      ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[] { ((JSONArray)localObject1).toString() });
      if (!((HashSet)localObject2).contains(paramString))
      {
        ab.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[] { paramString, Boolean.FALSE });
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fid", paramString);
        ((JSONArray)localObject1).put(localObject2);
        ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[] { ((JSONArray)localObject1).toString() });
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHY, ((JSONArray)localObject1).toString());
        com.tencent.mm.kernel.g.RL().Ru().dww();
        AppMethodBeat.o(51454);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(51454);
    }
    return false;
  }
  
  public static boolean afZ(String paramString)
  {
    AppMethodBeat.i(51455);
    Object localObject = cXw();
    ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = J(afX((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(51455);
      return true;
    }
    AppMethodBeat.o(51455);
    return false;
  }
  
  public static boolean cXA()
  {
    AppMethodBeat.i(51461);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru();
    if (localObject == null) {
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
    }
    while (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).uEM != -1L)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.e.a((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject);
      if (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).uEN / 1000L < 30L)
      {
        ae(((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).uEM, ((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).uEN);
        AppMethodBeat.o(51461);
        return true;
        localObject = (String)((z)localObject).get(ac.a.yIb, null);
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g().bC(com.tencent.mm.plugin.walletlock.gesture.a.e.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = com.tencent.mm.kernel.g.RL().Ru();
        if (localObject != null)
        {
          ((z)localObject).set(ac.a.yIb, null);
          ((z)localObject).dww();
        }
        AppMethodBeat.o(51461);
        return false;
      }
    }
    AppMethodBeat.o(51461);
    return false;
  }
  
  public static void cXB()
  {
    uEk = -1L;
  }
  
  public static long cXC()
  {
    return uEk;
  }
  
  private static String cXw()
  {
    AppMethodBeat.i(51453);
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHY, null);
    AppMethodBeat.o(51453);
    return str;
  }
  
  public static void cXx()
  {
    AppMethodBeat.i(51456);
    ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { bo.dtY() });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHY, null);
    com.tencent.mm.kernel.g.RL().Ru().dww();
    AppMethodBeat.o(51456);
  }
  
  public static boolean cXy()
  {
    AppMethodBeat.i(51457);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHX, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(51457);
    return bool;
  }
  
  public static boolean cXz()
  {
    AppMethodBeat.i(51459);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yId, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(51459);
    return bool;
  }
  
  public static void nX(boolean paramBoolean)
  {
    AppMethodBeat.i(51458);
    ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHX, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.RL().Ru().dww();
    AppMethodBeat.o(51458);
  }
  
  public static void nY(boolean paramBoolean)
  {
    AppMethodBeat.i(51460);
    ab.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yId, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.RL().Ru().dww();
    AppMethodBeat.o(51460);
  }
  
  public static void ni(long paramLong)
  {
    uEk = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */