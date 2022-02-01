package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean M(String paramString, Map<String, String> paramMap)
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
  
  private static boolean N(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151953);
    ac.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
    String str1 = (String)paramMap.get(paramString + ".CDNUrl");
    int k = bs.getInt((String)paramMap.get(paramString + ".subType"), -1);
    int m = bs.getInt((String)paramMap.get(paramString + ".resType"), -1);
    String str2 = (String)paramMap.get(paramString + ".md5");
    int n = bs.getInt((String)paramMap.get(paramString + ".priority"), 0);
    if ((bs.isNullOrNil(str1)) || (bs.isNullOrNil(str2)) || (-1 == k) || (-1 == m) || (n < 0))
    {
      AppMethodBeat.o(151953);
      return false;
    }
    cqd localcqd = new cqd();
    localcqd.FDn = new cqg();
    if (bs.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.eLQ();; i = 0)
    {
      int j = i;
      if (bs.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.WE(i);
      }
      localcqd.FvC = k;
      localcqd.FDs = bs.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localcqd.Eha = bs.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localcqd.FDn.Url = str1;
      localcqd.FDn.FDx = bs.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localcqd.FDn.MD5 = str2;
      localcqd.FDn.FDA = ((String)paramMap.get(paramString + ".originalmd5"));
      localcqd.FDn.FDy = j;
      localcqd.FDn.FDz = null;
      localcqd.FDn.Ewb = null;
      localcqd.EZW = n;
      localcqd.EPB = i.b.DkT.drx;
      localcqd.FDp = bs.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localcqd.FDq = ((String)paramMap.get(paramString + ".sampleID"));
      localcqd.FDr = bs.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localcqd.FDt = bs.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localcqd.DkK = 0;
      b.eLH().b(m, localcqd, true);
      j.A(localcqd.FDp, 34L);
      AppMethodBeat.o(151953);
      return true;
    }
  }
  
  private static boolean O(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151955);
    ac.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
    int i = bs.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bs.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151955);
      return false;
    }
    cqd localcqd = new cqd();
    localcqd.FvC = j;
    localcqd.FDn = new cqg();
    localcqd.FDn.FDx = bs.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localcqd.FDq = ((String)paramMap.get(paramString + ".sampleID"));
    localcqd.FDp = bs.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localcqd.EPB = i.b.DkV.drx;
    b.eLH().a(i, localcqd, true);
    j.A(localcqd.FDp, 40L);
    AppMethodBeat.o(151955);
    return true;
  }
  
  private static boolean b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(151954);
    ac.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
    int i = bs.getInt((String)paramMap.get(paramString + ".resType"), -1);
    int j = bs.getInt((String)paramMap.get(paramString + ".subType"), -1);
    if ((-1 == i) || (-1 == j))
    {
      AppMethodBeat.o(151954);
      return false;
    }
    cqd localcqd = new cqd();
    localcqd.FDo = new cqf();
    localcqd.FvC = j;
    localcqd.FDo.FDw = ((String)paramMap.get(paramString + ".resKey"));
    localcqd.FDo.FDv = bs.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localcqd.FDq = ((String)paramMap.get(paramString + ".sampleID"));
    localcqd.FDp = bs.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localcqd.EPB = i.b.DkU.drx;
    localcqd.FDn = new cqg();
    localcqd.FDn.FDA = ((String)paramMap.get(paramString + ".originalmd5"));
    b.eLH().a(i, localcqd, true, false);
    j.A(localcqd.FDp, 37L);
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
    if (i.b.WI(paramInt))
    {
      bool = O(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.WG(paramInt))
    {
      bool = N(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.WH(paramInt))
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
    if (M(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(151950);
      return;
    }
    boolean bool = l(paramString1, paramString2, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (M(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= l(paramString1, paramString2, paramMap);
    }
    i = i.b.aGB(paramString2);
    if (i.b.WG(i))
    {
      j.A(0L, 32L);
      if (!bool)
      {
        j.A(0L, 33L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.WH(i))
    {
      j.A(0L, 35L);
      if (!bool)
      {
        j.A(0L, 36L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.WI(i))
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
    int j = i.b.aGB(paramString2);
    if (M(str, paramMap))
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
      if (M(str, paramMap)) {
        break;
      }
      bool |= e(j, str, paramMap);
    }
    AppMethodBeat.o(151951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.e
 * JD-Core Version:    0.7.0.1
 */