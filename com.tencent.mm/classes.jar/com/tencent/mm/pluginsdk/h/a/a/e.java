package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean L(String paramString, Map<String, String> paramMap)
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
  
  private static boolean M(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151953);
    ad.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
    String str1 = (String)paramMap.get(paramString + ".CDNUrl");
    int k = bt.getInt((String)paramMap.get(paramString + ".subType"), -1);
    int m = bt.getInt((String)paramMap.get(paramString + ".resType"), -1);
    String str2 = (String)paramMap.get(paramString + ".md5");
    int n = bt.getInt((String)paramMap.get(paramString + ".priority"), 0);
    if ((bt.isNullOrNil(str1)) || (bt.isNullOrNil(str2)) || (-1 == k) || (-1 == m) || (n < 0))
    {
      AppMethodBeat.o(151953);
      return false;
    }
    ckw localckw = new ckw();
    localckw.Egn = new ckz();
    if (bt.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.eww();; i = 0)
    {
      int j = i;
      if (bt.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.Uu(i);
      }
      localckw.DYI = k;
      localckw.Egs = bt.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localckw.COp = bt.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localckw.Egn.Url = str1;
      localckw.Egn.Egx = bt.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localckw.Egn.MD5 = str2;
      localckw.Egn.EgA = ((String)paramMap.get(paramString + ".originalmd5"));
      localckw.Egn.Egy = j;
      localckw.Egn.Egz = null;
      localckw.Egn.DcU = null;
      localckw.DEB = n;
      localckw.Dus = i.b.BSD.dtM;
      localckw.Egp = bt.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localckw.Egq = ((String)paramMap.get(paramString + ".sampleID"));
      localckw.Egr = bt.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localckw.Egt = bt.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localckw.BSu = 0;
      b.ewn().b(m, localckw, true);
      j.D(localckw.Egp, 34L);
      AppMethodBeat.o(151953);
      return true;
    }
  }
  
  private static boolean N(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151955);
    ad.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
    int i = bt.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bt.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151955);
      return false;
    }
    ckw localckw = new ckw();
    localckw.DYI = j;
    localckw.Egn = new ckz();
    localckw.Egn.Egx = bt.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localckw.Egq = ((String)paramMap.get(paramString + ".sampleID"));
    localckw.Egp = bt.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localckw.Dus = i.b.BSF.dtM;
    b.ewn().a(i, localckw, true);
    j.D(localckw.Egp, 40L);
    AppMethodBeat.o(151955);
    return true;
  }
  
  private static boolean b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(151954);
    ad.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
    int i = bt.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bt.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151954);
      return false;
    }
    ckw localckw = new ckw();
    localckw.Ego = new cky();
    localckw.DYI = j;
    localckw.Ego.Egw = ((String)paramMap.get(paramString + ".resKey"));
    localckw.Ego.Egv = bt.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localckw.Egq = ((String)paramMap.get(paramString + ".sampleID"));
    localckw.Egp = bt.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localckw.Dus = i.b.BSE.dtM;
    localckw.Egn = new ckz();
    localckw.Egn.EgA = ((String)paramMap.get(paramString + ".originalmd5"));
    b.ewn().a(i, localckw, true, false);
    j.D(localckw.Egp, 37L);
    AppMethodBeat.o(151954);
    return true;
  }
  
  private static boolean e(int paramInt, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151952);
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(151952);
      return true;
    }
    boolean bool;
    if (i.b.Uy(paramInt))
    {
      bool = N(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.Uw(paramInt))
    {
      bool = M(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.Ux(paramInt))
    {
      bool = b(paramString, paramMap, true);
      AppMethodBeat.o(151952);
      return bool;
    }
    AppMethodBeat.o(151952);
    return false;
  }
  
  static void i(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151950);
    if (L(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(151950);
      return;
    }
    boolean bool = j(paramString1, paramString2, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (L(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= j(paramString1, paramString2, paramMap);
    }
    i = i.b.aBj(paramString2);
    if (i.b.Uw(i))
    {
      j.D(0L, 32L);
      if (!bool)
      {
        j.D(0L, 33L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.Ux(i))
    {
      j.D(0L, 35L);
      if (!bool)
      {
        j.D(0L, 36L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.Uy(i))
    {
      j.D(0L, 38L);
      if (!bool) {
        j.D(0L, 39L);
      }
    }
    AppMethodBeat.o(151950);
  }
  
  private static boolean j(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151951);
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.aBj(paramString2);
    if (L(str, paramMap))
    {
      AppMethodBeat.o(151951);
      return true;
    }
    boolean bool = e(j, str, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format(Locale.US, "%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      if (L(str, paramMap)) {
        break;
      }
      bool |= e(j, str, paramMap);
    }
    AppMethodBeat.o(151951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.e
 * JD-Core Version:    0.7.0.1
 */