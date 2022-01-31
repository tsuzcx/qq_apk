package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean G(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(79506);
    if ((paramMap.get(paramString) == null) && (paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(79506);
      return true;
    }
    AppMethodBeat.o(79506);
    return false;
  }
  
  private static boolean H(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(79510);
    ab.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
    String str1 = (String)paramMap.get(paramString + ".CDNUrl");
    int k = bo.getInt((String)paramMap.get(paramString + ".subType"), -1);
    int m = bo.getInt((String)paramMap.get(paramString + ".resType"), -1);
    String str2 = (String)paramMap.get(paramString + ".md5");
    int n = bo.getInt((String)paramMap.get(paramString + ".priority"), 0);
    if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)) || (-1 == k) || (-1 == m) || (n < 0))
    {
      AppMethodBeat.o(79510);
      return false;
    }
    bvd localbvd = new bvd();
    localbvd.xIN = new bvg();
    if (bo.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.dmk();; i = 0)
    {
      int j = i;
      if (bo.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.LH(i);
      }
      localbvd.xCa = k;
      localbvd.xIS = bo.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localbvd.wCO = bo.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localbvd.xIN.Url = str1;
      localbvd.xIN.xIX = bo.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localbvd.xIN.wQr = str2;
      localbvd.xIN.xJa = ((String)paramMap.get(paramString + ".originalmd5"));
      localbvd.xIN.xIY = j;
      localbvd.xIN.xIZ = null;
      localbvd.xIN.wPX = null;
      localbvd.xkR = n;
      localbvd.xbZ = i.b.vNC.bsY;
      localbvd.xIP = bo.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localbvd.xIQ = ((String)paramMap.get(paramString + ".sampleID"));
      localbvd.xIR = bo.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localbvd.xIT = bo.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localbvd.vNt = 0;
      b.c.dmg().b(m, localbvd, true);
      j.B(localbvd.xIP, 34L);
      AppMethodBeat.o(79510);
      return true;
    }
  }
  
  private static boolean I(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(79512);
    ab.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
    int i = bo.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bo.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(79512);
      return false;
    }
    bvd localbvd = new bvd();
    localbvd.xCa = j;
    localbvd.xIN = new bvg();
    localbvd.xIN.xIX = bo.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localbvd.xIQ = ((String)paramMap.get(paramString + ".sampleID"));
    localbvd.xIP = bo.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localbvd.xbZ = i.b.vNE.bsY;
    b.c.dmg().a(i, localbvd, true);
    j.B(localbvd.xIP, 40L);
    AppMethodBeat.o(79512);
    return true;
  }
  
  private static boolean c(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(79511);
    ab.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
    int i = bo.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bo.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(79511);
      return false;
    }
    bvd localbvd = new bvd();
    localbvd.xIO = new bvf();
    localbvd.xCa = j;
    localbvd.xIO.xIW = ((String)paramMap.get(paramString + ".resKey"));
    localbvd.xIO.xIV = bo.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localbvd.xIQ = ((String)paramMap.get(paramString + ".sampleID"));
    localbvd.xIP = bo.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localbvd.xbZ = i.b.vND.bsY;
    localbvd.xIN = new bvg();
    localbvd.xIN.xJa = ((String)paramMap.get(paramString + ".originalmd5"));
    b.c.dmg().a(i, localbvd, true, false);
    j.B(localbvd.xIP, 37L);
    AppMethodBeat.o(79511);
    return true;
  }
  
  private static boolean d(int paramInt, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(79509);
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(79509);
      return true;
    }
    boolean bool;
    if (i.b.LL(paramInt))
    {
      bool = I(paramString, paramMap);
      AppMethodBeat.o(79509);
      return bool;
    }
    if (i.b.LJ(paramInt))
    {
      bool = H(paramString, paramMap);
      AppMethodBeat.o(79509);
      return bool;
    }
    if (i.b.LK(paramInt))
    {
      bool = c(paramString, paramMap, true);
      AppMethodBeat.o(79509);
      return bool;
    }
    AppMethodBeat.o(79509);
    return false;
  }
  
  static void k(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(79507);
    if (G(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(79507);
      return;
    }
    boolean bool = l(paramString1, paramString2, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (G(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= l(paramString1, paramString2, paramMap);
    }
    i = i.b.alJ(paramString2);
    if (i.b.LJ(i))
    {
      j.B(0L, 32L);
      if (!bool)
      {
        j.B(0L, 33L);
        AppMethodBeat.o(79507);
      }
    }
    else if (i.b.LK(i))
    {
      j.B(0L, 35L);
      if (!bool)
      {
        j.B(0L, 36L);
        AppMethodBeat.o(79507);
      }
    }
    else if (i.b.LL(i))
    {
      j.B(0L, 38L);
      if (!bool) {
        j.B(0L, 39L);
      }
    }
    AppMethodBeat.o(79507);
  }
  
  private static boolean l(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(79508);
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.alJ(paramString2);
    if (G(str, paramMap))
    {
      AppMethodBeat.o(79508);
      return true;
    }
    boolean bool = d(j, str, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format(Locale.US, "%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      if (G(str, paramMap)) {
        break;
      }
      bool |= d(j, str, paramMap);
    }
    AppMethodBeat.o(79508);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.e
 * JD-Core Version:    0.7.0.1
 */