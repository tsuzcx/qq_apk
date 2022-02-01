package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;

public final class e
{
  private static boolean U(String paramString, Map<String, String> paramMap)
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
  
  private static boolean V(String paramString, Map<String, String> paramMap)
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
    dov localdov = new dov();
    localdov.MSk = new doy();
    if (Util.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {}
    for (int i = i.a.gnL();; i = 0)
    {
      int j = i;
      if (Util.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        j = i.a.ahS(i);
      }
      localdov.MJT = k;
      localdov.MSp = Util.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localdov.Lbj = Util.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localdov.MSk.Url = str1;
      localdov.MSk.MSu = Util.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localdov.MSk.MD5 = str2;
      localdov.MSk.MSy = ((String)paramMap.get(paramString + ".originalmd5"));
      localdov.MSk.MSv = j;
      localdov.MSk.MSw = null;
      localdov.MSk.MSx = null;
      localdov.MhZ = n;
      localdov.LWr = i.b.JZk.cSx;
      localdov.MSm = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localdov.MSn = ((String)paramMap.get(paramString + ".sampleID"));
      localdov.MSo = Util.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localdov.MSq = Util.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localdov.JZb = 0;
      b.gnC().b(m, localdov, true);
      j.F(localdov.MSm, 34L);
      AppMethodBeat.o(151953);
      return true;
    }
  }
  
  private static boolean W(String paramString, Map<String, String> paramMap)
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
    dov localdov = new dov();
    localdov.MJT = j;
    localdov.MSk = new doy();
    localdov.MSk.MSu = Util.getInt((String)paramMap.get(paramString + ".resVer"), 0);
    localdov.MSn = ((String)paramMap.get(paramString + ".sampleID"));
    localdov.MSm = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localdov.LWr = i.b.JZm.cSx;
    b.gnC().a(i, localdov, true);
    j.F(localdov.MSm, 40L);
    AppMethodBeat.o(151955);
    return true;
  }
  
  private static boolean a(int paramInt, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(223824);
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      AppMethodBeat.o(223824);
      return true;
    }
    if (i.b.ahW(paramInt))
    {
      paramBoolean = W(paramString, paramMap);
      AppMethodBeat.o(223824);
      return paramBoolean;
    }
    if (i.b.ahU(paramInt))
    {
      paramBoolean = V(paramString, paramMap);
      AppMethodBeat.o(223824);
      return paramBoolean;
    }
    if (i.b.ahV(paramInt))
    {
      paramBoolean = b(paramString, paramMap, paramBoolean);
      AppMethodBeat.o(223824);
      return paramBoolean;
    }
    AppMethodBeat.o(223824);
    return false;
  }
  
  private static boolean b(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(223823);
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.bdZ(paramString2);
    if (U(str, paramMap))
    {
      AppMethodBeat.o(223823);
      return true;
    }
    paramBoolean = a(j, str, paramMap, true) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format(Locale.US, "%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      if (U(str, paramMap)) {
        break;
      }
      paramBoolean |= a(j, str, paramMap, true);
    }
    AppMethodBeat.o(223823);
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
    dov localdov = new dov();
    localdov.MSl = new dox();
    localdov.MJT = j;
    localdov.MSl.MSt = ((String)paramMap.get(paramString + ".resKey"));
    localdov.MSl.MSs = Util.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
    localdov.MSn = ((String)paramMap.get(paramString + ".sampleID"));
    localdov.MSm = Util.getInt((String)paramMap.get(paramString + ".reportID"), 0);
    localdov.LWr = i.b.JZl.cSx;
    localdov.MSk = new doy();
    localdov.MSk.MSy = ((String)paramMap.get(paramString + ".originalmd5"));
    paramString = b.gnC();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(i, localdov, true, paramBoolean);
      j.F(localdov.MSm, 37L);
      AppMethodBeat.o(151954);
      return true;
    }
  }
  
  static void j(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(151950);
    if (U(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      AppMethodBeat.o(151950);
      return;
    }
    boolean bool = b(paramString1, paramString2, paramMap, true) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (U(String.format(Locale.US, "%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= b(paramString1, paramString2, paramMap, true);
    }
    i = i.b.bdZ(paramString2);
    if (i.b.ahU(i))
    {
      j.F(0L, 32L);
      if (!bool)
      {
        j.F(0L, 33L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.ahV(i))
    {
      j.F(0L, 35L);
      if (!bool)
      {
        j.F(0L, 36L);
        AppMethodBeat.o(151950);
      }
    }
    else if (i.b.ahW(i))
    {
      j.F(0L, 38L);
      if (!bool) {
        j.F(0L, 39L);
      }
    }
    AppMethodBeat.o(151950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.e
 * JD-Core Version:    0.7.0.1
 */