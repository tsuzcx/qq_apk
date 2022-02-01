package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean O(String paramString, Map<String, String> paramMap)
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
  
  private static boolean P(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151953);
    ae.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
    String str1 = (String)paramMap.get(paramString + ".CDNUrl");
    int k = bu.getInt((String)paramMap.get(paramString + ".subType"), -1);
    int m = bu.getInt((String)paramMap.get(paramString + ".resType"), -1);
    String str2 = (String)paramMap.get(paramString + ".md5");
    int n = bu.getInt((String)paramMap.get(paramString + ".priority"), 0);
    if ((bu.isNullOrNil(str1)) || (bu.isNullOrNil(str2)) || (-1 == k) || (-1 == m) || (n < 0))
    {
      AppMethodBeat.o(151953);
      return false;
    }
    cwc localcwc = new cwc();
    localcwc.HHa = new cwf();
    if (bu.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.feB();; i = 0)
    {
      int j = i;
      if (bu.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.Zg(i);
      }
      localcwc.Hzh = k;
      localcwc.HHf = bu.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localcwc.GgG = bu.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localcwc.HHa.Url = str1;
      localcwc.HHa.HHk = bu.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localcwc.HHa.MD5 = str2;
      localcwc.HHa.HHn = ((String)paramMap.get(paramString + ".originalmd5"));
      localcwc.HHa.HHl = j;
      localcwc.HHa.HHm = null;
      localcwc.HHa.Gwe = null;
      localcwc.HcW = n;
      localcwc.GSm = i.b.Fiq.dEu;
      localcwc.HHc = bu.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localcwc.HHd = ((String)paramMap.get(paramString + ".sampleID"));
      localcwc.HHe = bu.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localcwc.HHg = bu.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localcwc.Fih = 0;
      b.fes().b(m, localcwc, true);
      j.A(localcwc.HHc, 34L);
      AppMethodBeat.o(151953);
      return true;
    }
  }
  
  private static boolean Q(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151955);
    ae.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
    int i = bu.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bu.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151955);
      return false;
    }
    cwc localcwc = new cwc();
    localcwc.Hzh = j;
    localcwc.HHa = new cwf();
    localcwc.HHa.HHk = bu.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localcwc.HHd = ((String)paramMap.get(paramString + ".sampleID"));
    localcwc.HHc = bu.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localcwc.GSm = i.b.Fis.dEu;
    b.fes().a(i, localcwc, true);
    j.A(localcwc.HHc, 40L);
    AppMethodBeat.o(151955);
    return true;
  }
  
  private static boolean b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(151954);
    ae.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
    int i = bu.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bu.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151954);
      return false;
    }
    cwc localcwc = new cwc();
    localcwc.HHb = new cwe();
    localcwc.Hzh = j;
    localcwc.HHb.HHj = ((String)paramMap.get(paramString + ".resKey"));
    localcwc.HHb.HHi = bu.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localcwc.HHd = ((String)paramMap.get(paramString + ".sampleID"));
    localcwc.HHc = bu.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localcwc.GSm = i.b.Fir.dEu;
    localcwc.HHa = new cwf();
    localcwc.HHa.HHn = ((String)paramMap.get(paramString + ".originalmd5"));
    b.fes().a(i, localcwc, true, false);
    j.A(localcwc.HHc, 37L);
    AppMethodBeat.o(151954);
    return true;
  }
  
  private static boolean f(int paramInt, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151952);
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(151952);
      return true;
    }
    boolean bool;
    if (i.b.Zk(paramInt))
    {
      bool = Q(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.Zi(paramInt))
    {
      bool = P(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.Zj(paramInt))
    {
      bool = b(paramString, paramMap, true);
      AppMethodBeat.o(151952);
      return bool;
    }
    AppMethodBeat.o(151952);
    return false;
  }
  
  static void k(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151950);
    if (O(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(151950);
      return;
    }
    boolean bool = l(paramString1, paramString2, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (O(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= l(paramString1, paramString2, paramMap);
    }
    i = i.b.aNx(paramString2);
    if (i.b.Zi(i))
    {
      j.A(0L, 32L);
      if (!bool)
      {
        j.A(0L, 33L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.Zj(i))
    {
      j.A(0L, 35L);
      if (!bool)
      {
        j.A(0L, 36L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.Zk(i))
    {
      j.A(0L, 38L);
      if (!bool) {
        j.A(0L, 39L);
      }
    }
    AppMethodBeat.o(151950);
  }
  
  private static boolean l(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151951);
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.aNx(paramString2);
    if (O(str, paramMap))
    {
      AppMethodBeat.o(151951);
      return true;
    }
    boolean bool = f(j, str, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format(Locale.US, "%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      if (O(str, paramMap)) {
        break;
      }
      bool |= f(j, str, paramMap);
    }
    AppMethodBeat.o(151951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.e
 * JD-Core Version:    0.7.0.1
 */