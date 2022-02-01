package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class y
{
  private static final Map<String, Integer> BYG;
  
  static
  {
    AppMethodBeat.i(117657);
    BYG = new HashMap();
    AppMethodBeat.o(117657);
  }
  
  private static int Uh(int paramInt)
  {
    AppMethodBeat.i(117654);
    switch (paramInt)
    {
    default: 
      paramInt = z.Ul(0);
      AppMethodBeat.o(117654);
      return paramInt;
    case 201: 
      paramInt = z.exk();
      AppMethodBeat.o(117654);
      return paramInt;
    }
    paramInt = z.Ul(1);
    AppMethodBeat.o(117654);
    return paramInt;
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, int paramInt4)
  {
    AppMethodBeat.i(117652);
    a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramBoolean1, paramString4, paramBoolean2, paramString5, paramString6, paramInt4, false);
    AppMethodBeat.o(117652);
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, int paramInt4, boolean paramBoolean3)
  {
    AppMethodBeat.i(117653);
    int i;
    String str2;
    Object localObject;
    label61:
    int j;
    label69:
    long l;
    String str1;
    label109:
    int m;
    if (paramBoolean2)
    {
      i = 1;
      if ((paramInt1 == 1) || (paramInt1 == 10) || (paramInt1 == 12)) {
        i = 0;
      }
      str2 = bs.bG(paramString1, "");
      String str3 = bs.bG(paramString2, "");
      if (!TextUtils.isEmpty(paramString3)) {
        break label497;
      }
      localObject = "";
      if (!paramBoolean1) {
        break label504;
      }
      j = 1;
      String str4 = bs.bG(paramString4, "");
      l = System.currentTimeMillis();
      String str5 = doc();
      String str6 = bs.bG(paramString5, "");
      if (!TextUtils.isEmpty(paramString6)) {
        break label510;
      }
      str1 = "";
      m = Uh(paramInt2);
      if (!paramBoolean3) {
        break label517;
      }
      k = 1;
      label123:
      ac.i("MicroMsg.WebSearch.WebSearchActionTracer", "reporting 14904 %s ", new Object[] { v(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, str3, localObject, Integer.valueOf(paramInt3), Integer.valueOf(j), str4, Long.valueOf(l), str5, Integer.valueOf(i), str6, str1, Integer.valueOf(paramInt4), Integer.valueOf(m), Integer.valueOf(k) }) });
      localObject = e.wTc;
      str1 = bs.bG(paramString1, "");
      str2 = bs.bG(paramString2, "");
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = "";
      }
      if (!paramBoolean1) {
        break label523;
      }
      j = 1;
      label303:
      paramString3 = bs.bG(paramString4, "");
      l = System.currentTimeMillis();
      paramString4 = doc();
      paramString5 = bs.bG(paramString5, "");
      paramString2 = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramString2 = "";
      }
      m = Uh(paramInt2);
      if (!paramBoolean3) {
        break label529;
      }
    }
    label517:
    label523:
    label529:
    for (int k = 1;; k = 0)
    {
      ((e)localObject).f(14904, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str2, paramString1, Integer.valueOf(paramInt3), Integer.valueOf(j), paramString3, Long.valueOf(l), paramString4, Integer.valueOf(i), paramString5, paramString2, Integer.valueOf(paramInt4), Integer.valueOf(m), Integer.valueOf(k) });
      AppMethodBeat.o(117653);
      return;
      i = 2;
      break;
      label497:
      localObject = paramString3;
      break label61;
      label504:
      j = 0;
      break label69;
      label510:
      str1 = paramString6;
      break label109;
      k = 0;
      break label123;
      j = 0;
      break label303;
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean, String paramString4, String paramString5, int paramInt3)
  {
    AppMethodBeat.i(117644);
    a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramBoolean, paramString4, paramString5, paramInt3, "");
    AppMethodBeat.o(117644);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean, String paramString4, String paramString5, int paramInt3, String paramString6)
  {
    AppMethodBeat.i(117645);
    a(4, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramBoolean, paramString4, true, paramString5, paramString6, paramInt3);
    AppMethodBeat.o(117645);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, int paramInt3)
  {
    AppMethodBeat.i(117646);
    a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramBoolean1, paramString4, paramBoolean2, paramString5, paramInt3, "");
    AppMethodBeat.o(117646);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, int paramInt3, String paramString6)
  {
    AppMethodBeat.i(117647);
    a(7, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramBoolean1, paramString4, paramBoolean2, paramString5, paramString6, paramInt3);
    AppMethodBeat.o(117647);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(117650);
    a(10, paramInt1, paramString1, paramString2, "", 0, paramBoolean, "", true, paramString3, "", paramInt2);
    AppMethodBeat.o(117650);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt2, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(117649);
    a(12, paramInt1, paramString1, paramString2, "", 0, paramBoolean1, "", true, paramString3, paramString4, paramInt2, paramBoolean2);
    AppMethodBeat.o(117649);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt2, String paramString4, boolean paramBoolean2, String paramString5)
  {
    AppMethodBeat.i(117648);
    a(1, paramInt1, paramString1, paramString2, paramString5, 0, paramBoolean1, "", true, paramString3, paramString4, paramInt2, paramBoolean2);
    AppMethodBeat.o(117648);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(117651);
    a(14, paramInt1, paramString1, paramString2, "", 0, paramBoolean1, "", true, paramString3, "", paramInt2, paramBoolean2);
    AppMethodBeat.o(117651);
  }
  
  private static String doc()
  {
    AppMethodBeat.i(117655);
    Context localContext = ai.getContext();
    if (!ax.isConnected(localContext))
    {
      ac.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, not connected");
      AppMethodBeat.o(117655);
      return "fail";
    }
    ac.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, type = ".concat(String.valueOf(ax.getNetType(localContext))));
    if (ax.is2G(localContext))
    {
      ac.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 2g");
      AppMethodBeat.o(117655);
      return "2g";
    }
    if (ax.is3G(localContext))
    {
      ac.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 3g");
      AppMethodBeat.o(117655);
      return "3g";
    }
    if (ax.is4G(localContext))
    {
      ac.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 4g");
      AppMethodBeat.o(117655);
      return "4g";
    }
    if (ax.isWifi(localContext))
    {
      ac.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, wifi");
      AppMethodBeat.o(117655);
      return "wifi";
    }
    AppMethodBeat.o(117655);
    return "fail";
  }
  
  public static void exi() {}
  
  private static String v(Object... paramVarArgs)
  {
    AppMethodBeat.i(117656);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 15)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i]).replace(',', ' ')).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[15]));
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(117656);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.y
 * JD-Core Version:    0.7.0.1
 */