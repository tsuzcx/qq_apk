package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.walletlock.gesture.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long WfO = -1L;
  
  public static void Ia(boolean paramBoolean)
  {
    AppMethodBeat.i(129663);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    h.baE().ban().set(at.a.acTL, Boolean.valueOf(paramBoolean));
    h.baE().ban().iZy();
    AppMethodBeat.o(129663);
  }
  
  public static void Ib(boolean paramBoolean)
  {
    AppMethodBeat.i(129665);
    Log.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    h.baE().ban().set(at.a.acTR, Boolean.valueOf(paramBoolean));
    h.baE().ban().iZy();
    AppMethodBeat.o(129665);
  }
  
  private static HashSet<String> Z(JSONArray paramJSONArray)
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
  
  public static void bD(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129667);
    aq localaq = h.baE().ban();
    if (localaq != null)
    {
      i locali = new i();
      locali.Wgt = paramLong1;
      locali.Wgu = paramLong2;
      localaq.set(at.a.acTP, g.cN(locali.toByteArray()));
      localaq.iZy();
    }
    AppMethodBeat.o(129667);
  }
  
  private static JSONArray bhv(String paramString)
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
  
  public static boolean bhw(String paramString)
  {
    AppMethodBeat.i(129659);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = bhv(imC());
      HashSet localHashSet = Z((JSONArray)localObject2);
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
        h.baE().ban().set(at.a.acTM, ((JSONArray)localObject1).toString());
        h.baE().ban().iZy();
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
  
  public static boolean bhx(String paramString)
  {
    AppMethodBeat.i(129660);
    Object localObject = imC();
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = Z(bhv((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(129660);
      return true;
    }
    AppMethodBeat.o(129660);
    return false;
  }
  
  private static String imC()
  {
    AppMethodBeat.i(129658);
    String str = (String)h.baE().ban().get(at.a.acTM, null);
    AppMethodBeat.o(129658);
    return str;
  }
  
  public static void imD()
  {
    AppMethodBeat.i(129661);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { Util.getStack() });
    h.baE().ban().set(at.a.acTM, null);
    h.baE().ban().iZy();
    AppMethodBeat.o(129661);
  }
  
  public static boolean imE()
  {
    AppMethodBeat.i(129662);
    boolean bool = ((Boolean)h.baE().ban().get(at.a.acTL, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129662);
    return bool;
  }
  
  public static boolean imF()
  {
    AppMethodBeat.i(129664);
    boolean bool = ((Boolean)h.baE().ban().get(at.a.acTR, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129664);
    return bool;
  }
  
  public static boolean imG()
  {
    AppMethodBeat.i(129666);
    Object localObject = h.baE().ban();
    if (localObject == null) {
      localObject = new i();
    }
    while (((i)localObject).Wgt != -1L)
    {
      g.a((i)localObject);
      if (((i)localObject).Wgu / 1000L < 30L)
      {
        bD(((i)localObject).Wgt, ((i)localObject).Wgu);
        AppMethodBeat.o(129666);
        return true;
        localObject = (String)((aq)localObject).get(at.a.acTP, null);
        if (localObject == null) {
          localObject = new i();
        } else {
          localObject = new i().cO(g.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = h.baE().ban();
        if (localObject != null)
        {
          ((aq)localObject).set(at.a.acTP, null);
          ((aq)localObject).iZy();
        }
        AppMethodBeat.o(129666);
        return false;
      }
    }
    AppMethodBeat.o(129666);
    return false;
  }
  
  public static void imH()
  {
    WfO = -1L;
  }
  
  public static long imI()
  {
    return WfO;
  }
  
  public static void xB(long paramLong)
  {
    WfO = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */