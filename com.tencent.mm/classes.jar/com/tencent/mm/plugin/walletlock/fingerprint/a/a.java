package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long Ppf = -1L;
  
  public static void Cv(boolean paramBoolean)
  {
    AppMethodBeat.i(129663);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    h.aHG().aHp().set(ar.a.Vsg, Boolean.valueOf(paramBoolean));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(129663);
  }
  
  public static void Cw(boolean paramBoolean)
  {
    AppMethodBeat.i(129665);
    Log.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    h.aHG().aHp().set(ar.a.Vsm, Boolean.valueOf(paramBoolean));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(129665);
  }
  
  public static void Ts(long paramLong)
  {
    Ppf = paramLong;
  }
  
  private static HashSet<String> U(JSONArray paramJSONArray)
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
  
  public static void aR(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129667);
    ao localao = h.aHG().aHp();
    if (localao != null)
    {
      g localg = new g();
      localg.PpG = paramLong1;
      localg.PpH = paramLong2;
      localao.set(ar.a.Vsk, e.cK(localg.toByteArray()));
      localao.hxT();
    }
    AppMethodBeat.o(129667);
  }
  
  private static JSONArray bhM(String paramString)
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
  
  public static boolean bhN(String paramString)
  {
    AppMethodBeat.i(129659);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = bhM(gNn());
      HashSet localHashSet = U((JSONArray)localObject2);
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
        h.aHG().aHp().set(ar.a.Vsh, ((JSONArray)localObject1).toString());
        h.aHG().aHp().hxT();
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
  
  public static boolean bhO(String paramString)
  {
    AppMethodBeat.i(129660);
    Object localObject = gNn();
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = U(bhM((String)localObject));
    if ((localObject != null) && (((HashSet)localObject).contains(paramString)))
    {
      AppMethodBeat.o(129660);
      return true;
    }
    AppMethodBeat.o(129660);
    return false;
  }
  
  private static String gNn()
  {
    AppMethodBeat.i(129658);
    String str = (String)h.aHG().aHp().get(ar.a.Vsh, null);
    AppMethodBeat.o(129658);
    return str;
  }
  
  public static void gNo()
  {
    AppMethodBeat.i(129661);
    Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { Util.getStack() });
    h.aHG().aHp().set(ar.a.Vsh, null);
    h.aHG().aHp().hxT();
    AppMethodBeat.o(129661);
  }
  
  public static boolean gNp()
  {
    AppMethodBeat.i(129662);
    boolean bool = ((Boolean)h.aHG().aHp().get(ar.a.Vsg, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129662);
    return bool;
  }
  
  public static boolean gNq()
  {
    AppMethodBeat.i(129664);
    boolean bool = ((Boolean)h.aHG().aHp().get(ar.a.Vsm, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129664);
    return bool;
  }
  
  public static boolean gNr()
  {
    AppMethodBeat.i(129666);
    Object localObject = h.aHG().aHp();
    if (localObject == null) {
      localObject = new g();
    }
    while (((g)localObject).PpG != -1L)
    {
      e.a((g)localObject);
      if (((g)localObject).PpH / 1000L < 30L)
      {
        aR(((g)localObject).PpG, ((g)localObject).PpH);
        AppMethodBeat.o(129666);
        return true;
        localObject = (String)((ao)localObject).get(ar.a.Vsk, null);
        if (localObject == null) {
          localObject = new g();
        } else {
          localObject = new g().cL(e.stringToBytes((String)localObject));
        }
      }
      else
      {
        localObject = h.aHG().aHp();
        if (localObject != null)
        {
          ((ao)localObject).set(ar.a.Vsk, null);
          ((ao)localObject).hxT();
        }
        AppMethodBeat.o(129666);
        return false;
      }
    }
    AppMethodBeat.o(129666);
    return false;
  }
  
  public static void gNs()
  {
    Ppf = -1L;
  }
  
  public static long gNt()
  {
    return Ppf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */