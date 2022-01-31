package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long qPd = -1L;
  
  private static HashSet<String> D(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
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
      return localHashSet;
    }
    catch (Exception paramJSONArray)
    {
      y.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramJSONArray, "", new Object[0]);
    }
    return null;
  }
  
  public static void Q(long paramLong1, long paramLong2)
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.g localg = new com.tencent.mm.plugin.walletlock.gesture.a.g();
      localg.qPE = paramLong1;
      localg.qPF = paramLong2;
      localz.c(ac.a.uxR, com.tencent.mm.plugin.walletlock.gesture.a.e.ba(localg.toByteArray()));
      localz.mC(true);
    }
  }
  
  private static JSONArray QZ(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static boolean Ra(String paramString)
  {
    y.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[] { paramString });
    try
    {
      Object localObject2 = QZ(bXO());
      HashSet localHashSet = D((JSONArray)localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        y.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
        localObject1 = new JSONArray();
      }
      localObject2 = localHashSet;
      if (localHashSet == null)
      {
        y.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
        localObject2 = new HashSet();
      }
      y.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[] { ((JSONArray)localObject1).toString() });
      if (!((HashSet)localObject2).contains(paramString))
      {
        y.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[] { paramString, Boolean.valueOf(false) });
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fid", paramString);
        ((JSONArray)localObject1).put(localObject2);
        y.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[] { ((JSONArray)localObject1).toString() });
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxO, ((JSONArray)localObject1).toString());
        com.tencent.mm.kernel.g.DP().Dz().mC(true);
        return true;
      }
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.FingerprintInfoStorage", paramString, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean Rb(String paramString)
  {
    Object localObject = bXO();
    y.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[] { paramString, localObject });
    localObject = D(QZ((String)localObject));
    return (localObject != null) && (((HashSet)localObject).contains(paramString));
  }
  
  private static String bXO()
  {
    return (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxO, null);
  }
  
  public static void bXP()
  {
    y.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[] { bk.csb() });
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxO, null);
    com.tencent.mm.kernel.g.DP().Dz().mC(true);
  }
  
  public static boolean bXQ()
  {
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxN, Boolean.FALSE)).booleanValue();
  }
  
  public static boolean bXR()
  {
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxT, Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean bXS()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz();
    if (localObject == null) {
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
    }
    while (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).qPE != -1L)
    {
      com.tencent.mm.plugin.walletlock.gesture.a.e.a((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject);
      if (((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).qPF / 1000L < 30L)
      {
        Q(((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).qPE, ((com.tencent.mm.plugin.walletlock.gesture.a.g)localObject).qPF);
        return true;
        localObject = (String)((z)localObject).get(ac.a.uxR, null);
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.g().bb(com.tencent.mm.plugin.walletlock.gesture.a.e.Rc((String)localObject));
        }
      }
      else
      {
        localObject = com.tencent.mm.kernel.g.DP().Dz();
        if (localObject != null)
        {
          ((z)localObject).c(ac.a.uxR, null);
          ((z)localObject).mC(true);
        }
        return false;
      }
    }
    return false;
  }
  
  public static void bXT()
  {
    qPd = -1L;
  }
  
  public static long bXU()
  {
    return qPd;
  }
  
  public static void gM(long paramLong)
  {
    qPd = paramLong;
  }
  
  public static void kO(boolean paramBoolean)
  {
    y.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxN, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.DP().Dz().mC(true);
  }
  
  public static void kP(boolean paramBoolean)
  {
    y.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxT, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.DP().Dz().mC(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.a
 * JD-Core Version:    0.7.0.1
 */