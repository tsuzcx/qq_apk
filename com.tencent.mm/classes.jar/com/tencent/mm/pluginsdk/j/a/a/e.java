package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean N(String paramString, Map<String, String> paramMap)
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
  
  private static boolean O(String paramString, Map<String, String> paramMap)
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
    cvi localcvi = new cvi();
    localcvi.HnA = new cvl();
    if (bt.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.faN();; i = 0)
    {
      int j = i;
      if (bt.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.YA(i);
      }
      localcvi.HfH = k;
      localcvi.HnF = bt.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localcvi.FOh = bt.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localcvi.HnA.Url = str1;
      localcvi.HnA.HnK = bt.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localcvi.HnA.MD5 = str2;
      localcvi.HnA.HnN = ((String)paramMap.get(paramString + ".originalmd5"));
      localcvi.HnA.HnL = j;
      localcvi.HnA.HnM = null;
      localcvi.HnA.Gdx = null;
      localcvi.GJv = n;
      localcvi.GyM = i.b.EPV.dDp;
      localcvi.HnC = bt.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localcvi.HnD = ((String)paramMap.get(paramString + ".sampleID"));
      localcvi.HnE = bt.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localcvi.HnG = bt.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localcvi.EPM = 0;
      b.faE().b(m, localcvi, true);
      j.A(localcvi.HnC, 34L);
      AppMethodBeat.o(151953);
      return true;
    }
  }
  
  private static boolean P(String paramString, Map<String, String> paramMap)
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
    cvi localcvi = new cvi();
    localcvi.HfH = j;
    localcvi.HnA = new cvl();
    localcvi.HnA.HnK = bt.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localcvi.HnD = ((String)paramMap.get(paramString + ".sampleID"));
    localcvi.HnC = bt.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localcvi.GyM = i.b.EPX.dDp;
    b.faE().a(i, localcvi, true);
    j.A(localcvi.HnC, 40L);
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
    cvi localcvi = new cvi();
    localcvi.HnB = new cvk();
    localcvi.HfH = j;
    localcvi.HnB.HnJ = ((String)paramMap.get(paramString + ".resKey"));
    localcvi.HnB.HnI = bt.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localcvi.HnD = ((String)paramMap.get(paramString + ".sampleID"));
    localcvi.HnC = bt.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localcvi.GyM = i.b.EPW.dDp;
    localcvi.HnA = new cvl();
    localcvi.HnA.HnN = ((String)paramMap.get(paramString + ".originalmd5"));
    b.faE().a(i, localcvi, true, false);
    j.A(localcvi.HnC, 37L);
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
    if (i.b.YE(paramInt))
    {
      bool = P(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.YC(paramInt))
    {
      bool = O(paramString, paramMap);
      AppMethodBeat.o(151952);
      return bool;
    }
    if (i.b.YD(paramInt))
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
    if (N(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(151950);
      return;
    }
    boolean bool = l(paramString1, paramString2, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (N(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= l(paramString1, paramString2, paramMap);
    }
    i = i.b.aMb(paramString2);
    if (i.b.YC(i))
    {
      j.A(0L, 32L);
      if (!bool)
      {
        j.A(0L, 33L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.YD(i))
    {
      j.A(0L, 35L);
      if (!bool)
      {
        j.A(0L, 36L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.YE(i))
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
    int j = i.b.aMb(paramString2);
    if (N(str, paramMap))
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
      if (N(str, paramMap)) {
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