package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean a(int paramInt, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(245043);
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(245043);
      return true;
    }
    if (i.b.awa(paramInt))
    {
      paramBoolean = ai(paramString, paramMap);
      AppMethodBeat.o(245043);
      return paramBoolean;
    }
    if (i.b.avY(paramInt))
    {
      paramBoolean = ah(paramString, paramMap);
      AppMethodBeat.o(245043);
      return paramBoolean;
    }
    if (i.b.avZ(paramInt))
    {
      paramBoolean = b(paramString, paramMap, paramBoolean);
      AppMethodBeat.o(245043);
      return paramBoolean;
    }
    AppMethodBeat.o(245043);
    return false;
  }
  
  private static boolean ag(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151949);
    if ((paramMap.get(paramString) == null) && (paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(151949);
      return true;
    }
    AppMethodBeat.o(151949);
    return false;
  }
  
  private static boolean ah(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151953);
    Log.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
    String str1 = (String)paramMap.get(paramString + ".CDNUrl");
    int k = Util.getInt((String)paramMap.get(paramString + ".subType"), -1);
    int m = Util.getInt((String)paramMap.get(paramString + ".resType"), -1);
    String str2 = (String)paramMap.get(paramString + ".md5");
    int n = Util.getInt((String)paramMap.get(paramString + ".priority"), 0);
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)) || (-1 == k) || (-1 == m) || (n < 0))
    {
      AppMethodBeat.o(151953);
      return false;
    }
    erv localerv = new erv();
    localerv.abvF = new ery();
    if (Util.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.iJr();; i = 0)
    {
      int j = i;
      if (Util.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.avW(i);
      }
      localerv.abmA = k;
      localerv.abvJ = Util.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localerv.Zan = Util.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localerv.abvF.Url = str1;
      localerv.abvF.abvO = Util.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localerv.abvF.MD5 = str2;
      localerv.abvF.abvS = ((String)paramMap.get(paramString + ".originalmd5"));
      localerv.abvF.abvP = j;
      localerv.abvF.abvQ = null;
      localerv.abvF.abvR = null;
      localerv.aaFY = n;
      localerv.aasS = i.b.XVR.eQp;
      localerv.xKa = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localerv.abvH = ((String)paramMap.get(paramString + ".sampleID"));
      localerv.abvI = Util.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localerv.abvK = Util.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localerv.XVH = 0;
      b.iJf().b(m, localerv, true);
      j.ac(localerv.xKa, 34L);
      AppMethodBeat.o(151953);
      return true;
    }
  }
  
  private static boolean ai(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151955);
    Log.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
    int i = Util.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = Util.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151955);
      return false;
    }
    erv localerv = new erv();
    localerv.abmA = j;
    localerv.abvF = new ery();
    localerv.abvF.abvO = Util.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localerv.abvH = ((String)paramMap.get(paramString + ".sampleID"));
    localerv.xKa = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localerv.aasS = i.b.XVT.eQp;
    b.iJf().a(i, localerv, true);
    j.ac(localerv.xKa, 40L);
    AppMethodBeat.o(151955);
    return true;
  }
  
  private static boolean b(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(245040);
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.bqj(paramString2);
    if (ag(str, paramMap))
    {
      AppMethodBeat.o(245040);
      return true;
    }
    paramBoolean = a(j, str, paramMap, true) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format(Locale.US, "%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      if (ag(str, paramMap)) {
        break;
      }
      paramBoolean |= a(j, str, paramMap, true);
    }
    AppMethodBeat.o(245040);
    return paramBoolean;
  }
  
  private static boolean b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(151954);
    Log.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
    int i = Util.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = Util.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151954);
      return false;
    }
    erv localerv = new erv();
    localerv.abvG = new erx();
    localerv.abmA = j;
    localerv.abvG.abvN = ((String)paramMap.get(paramString + ".resKey"));
    localerv.abvG.abvM = Util.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localerv.abvH = ((String)paramMap.get(paramString + ".sampleID"));
    localerv.xKa = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localerv.aasS = i.b.XVS.eQp;
    localerv.abvF = new ery();
    localerv.abvF.abvS = ((String)paramMap.get(paramString + ".originalmd5"));
    paramString = b.iJf();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(i, localerv, true, paramBoolean);
      j.ac(localerv.xKa, 37L);
      AppMethodBeat.o(151954);
      return true;
    }
  }
  
  static void k(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151950);
    if (ag(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(151950);
      return;
    }
    boolean bool = b(paramString1, paramString2, paramMap, true) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (ag(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= b(paramString1, paramString2, paramMap, true);
    }
    i = i.b.bqj(paramString2);
    if (i.b.avY(i))
    {
      j.ac(0L, 32L);
      if (!bool)
      {
        j.ac(0L, 33L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.avZ(i))
    {
      j.ac(0L, 35L);
      if (!bool)
      {
        j.ac(0L, 36L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.awa(i))
    {
      j.ac(0L, 38L);
      if (!bool) {
        j.ac(0L, 39L);
      }
    }
    AppMethodBeat.o(151950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.e
 * JD-Core Version:    0.7.0.1
 */