package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.protocal.protobuf.dyt;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean X(String paramString, Map<String, String> paramMap)
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
  
  private static boolean Y(String paramString, Map<String, String> paramMap)
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
    dyr localdyr = new dyr();
    localdyr.Uer = new dyu();
    if (Util.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.his();; i = 0)
    {
      int j = i;
      if (Util.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.apS(i);
      }
      localdyr.TVM = k;
      localdyr.Uew = Util.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localdyr.Scv = Util.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localdyr.Uer.Url = str1;
      localdyr.Uer.UeB = Util.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localdyr.Uer.MD5 = str2;
      localdyr.Uer.UeF = ((String)paramMap.get(paramString + ".originalmd5"));
      localdyr.Uer.UeC = j;
      localdyr.Uer.UeD = null;
      localdyr.Uer.UeE = null;
      localdyr.TrM = n;
      localdyr.Tfy = i.b.QZN.cUP;
      localdyr.Uet = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localdyr.Ueu = ((String)paramMap.get(paramString + ".sampleID"));
      localdyr.Uev = Util.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localdyr.Uex = Util.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localdyr.QZD = 0;
      b.hii().b(m, localdyr, true);
      j.F(localdyr.Uet, 34L);
      AppMethodBeat.o(151953);
      return true;
    }
  }
  
  private static boolean Z(String paramString, Map<String, String> paramMap)
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
    dyr localdyr = new dyr();
    localdyr.TVM = j;
    localdyr.Uer = new dyu();
    localdyr.Uer.UeB = Util.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localdyr.Ueu = ((String)paramMap.get(paramString + ".sampleID"));
    localdyr.Uet = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localdyr.Tfy = i.b.QZP.cUP;
    b.hii().a(i, localdyr, true);
    j.F(localdyr.Uet, 40L);
    AppMethodBeat.o(151955);
    return true;
  }
  
  private static boolean a(int paramInt, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(195852);
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(195852);
      return true;
    }
    if (i.b.apW(paramInt))
    {
      paramBoolean = Z(paramString, paramMap);
      AppMethodBeat.o(195852);
      return paramBoolean;
    }
    if (i.b.apU(paramInt))
    {
      paramBoolean = Y(paramString, paramMap);
      AppMethodBeat.o(195852);
      return paramBoolean;
    }
    if (i.b.apV(paramInt))
    {
      paramBoolean = b(paramString, paramMap, paramBoolean);
      AppMethodBeat.o(195852);
      return paramBoolean;
    }
    AppMethodBeat.o(195852);
    return false;
  }
  
  private static boolean b(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(195847);
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.bqv(paramString2);
    if (X(str, paramMap))
    {
      AppMethodBeat.o(195847);
      return true;
    }
    paramBoolean = a(j, str, paramMap, true) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format(Locale.US, "%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      if (X(str, paramMap)) {
        break;
      }
      paramBoolean |= a(j, str, paramMap, true);
    }
    AppMethodBeat.o(195847);
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
    dyr localdyr = new dyr();
    localdyr.Ues = new dyt();
    localdyr.TVM = j;
    localdyr.Ues.UeA = ((String)paramMap.get(paramString + ".resKey"));
    localdyr.Ues.Uez = Util.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localdyr.Ueu = ((String)paramMap.get(paramString + ".sampleID"));
    localdyr.Uet = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localdyr.Tfy = i.b.QZO.cUP;
    localdyr.Uer = new dyu();
    localdyr.Uer.UeF = ((String)paramMap.get(paramString + ".originalmd5"));
    paramString = b.hii();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(i, localdyr, true, paramBoolean);
      j.F(localdyr.Uet, 37L);
      AppMethodBeat.o(151954);
      return true;
    }
  }
  
  static void j(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151950);
    if (X(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(151950);
      return;
    }
    boolean bool = b(paramString1, paramString2, paramMap, true) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (X(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= b(paramString1, paramString2, paramMap, true);
    }
    i = i.b.bqv(paramString2);
    if (i.b.apU(i))
    {
      j.F(0L, 32L);
      if (!bool)
      {
        j.F(0L, 33L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.apV(i))
    {
      j.F(0L, 35L);
      if (!bool)
      {
        j.F(0L, 36L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.apW(i))
    {
      j.F(0L, 38L);
      if (!bool) {
        j.F(0L, 39L);
      }
    }
    AppMethodBeat.o(151950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.e
 * JD-Core Version:    0.7.0.1
 */