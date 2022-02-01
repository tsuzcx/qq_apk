package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class ah
{
  private static final Map<String, Integer> PyM;
  
  static
  {
    AppMethodBeat.i(117657);
    PyM = new HashMap();
    AppMethodBeat.o(117657);
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
      str2 = Util.nullAs(paramString1, "");
      String str3 = Util.nullAs(paramString2, "");
      if (!TextUtils.isEmpty(paramString3)) {
        break label497;
      }
      localObject = "";
      if (!paramBoolean1) {
        break label504;
      }
      j = 1;
      String str4 = Util.nullAs(paramString4, "");
      l = System.currentTimeMillis();
      String str5 = chm();
      String str6 = Util.nullAs(paramString5, "");
      if (!TextUtils.isEmpty(paramString6)) {
        break label510;
      }
      str1 = "";
      m = and(paramInt2);
      if (!paramBoolean3) {
        break label517;
      }
      k = 1;
      label123:
      Log.i("MicroMsg.WebSearch.WebSearchActionTracer", "reporting 14904 %s ", new Object[] { u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, str3, localObject, Integer.valueOf(paramInt3), Integer.valueOf(j), str4, Long.valueOf(l), str5, Integer.valueOf(i), str6, str1, Integer.valueOf(paramInt4), Integer.valueOf(m), Integer.valueOf(k) }) });
      localObject = f.Iyx;
      str1 = Util.nullAs(paramString1, "");
      str2 = Util.nullAs(paramString2, "");
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = "";
      }
      if (!paramBoolean1) {
        break label523;
      }
      j = 1;
      label303:
      paramString3 = Util.nullAs(paramString4, "");
      l = System.currentTimeMillis();
      paramString4 = chm();
      paramString5 = Util.nullAs(paramString5, "");
      paramString2 = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramString2 = "";
      }
      m = and(paramInt2);
      if (!paramBoolean3) {
        break label529;
      }
    }
    label517:
    label523:
    label529:
    for (int k = 1;; k = 0)
    {
      ((f)localObject).a(14904, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str2, paramString1, Integer.valueOf(paramInt3), Integer.valueOf(j), paramString3, Long.valueOf(l), paramString4, Integer.valueOf(i), paramString5, paramString2, Integer.valueOf(paramInt4), Integer.valueOf(m), Integer.valueOf(k) });
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
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, boolean paramBoolean, String paramString5)
  {
    AppMethodBeat.i(211444);
    if ((paramInt1 == 3) || (paramInt1 == 20)) {
      a(301, paramInt1, paramString1, paramString2, paramString5, 0, true, "", true, paramString3, paramString4, paramInt2, paramBoolean);
    }
    AppMethodBeat.o(211444);
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
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(211441);
    a(207, paramInt1, paramString1, paramString2, paramString3, 0, true, paramString4, paramBoolean, paramString5, "", paramInt2);
    AppMethodBeat.o(211441);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(117650);
    a(10, paramInt1, paramString1, paramString2, "", 0, paramBoolean, "", true, paramString3, "", paramInt2);
    AppMethodBeat.o(117650);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt2, String paramString4, String paramString5)
  {
    AppMethodBeat.i(211443);
    if ((paramInt1 == 3) || (paramInt1 == 20)) {
      a(300, paramInt1, paramString1, paramString2, paramString5, 0, paramBoolean, "", true, paramString3, paramString4, paramInt2, false);
    }
    AppMethodBeat.o(211443);
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
    if (paramInt1 == 20) {
      a(214, paramInt1, paramString1, paramString2, "", 0, paramBoolean1, "", true, paramString3, "", paramInt2, paramBoolean2);
    }
    AppMethodBeat.o(117651);
  }
  
  private static int and(int paramInt)
  {
    AppMethodBeat.i(117654);
    switch (paramInt)
    {
    default: 
      paramInt = ai.anh(0);
      AppMethodBeat.o(117654);
      return paramInt;
    case 201: 
      paramInt = ai.gQG();
      AppMethodBeat.o(117654);
      return paramInt;
    }
    paramInt = ai.anh(1);
    AppMethodBeat.o(117654);
    return paramInt;
  }
  
  public static void b(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, boolean paramBoolean, String paramString5)
  {
    AppMethodBeat.i(211446);
    if ((paramInt1 == 3) || (paramInt1 == 20)) {
      a(302, paramInt1, paramString1, paramString2, paramString5, 0, true, "", true, paramString3, paramString4, paramInt2, paramBoolean);
    }
    AppMethodBeat.o(211446);
  }
  
  public static void c(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(211438);
    a(204, paramInt1, paramString1, paramString2, paramString3, 0, true, paramString4, true, null, "", paramInt2);
    AppMethodBeat.o(211438);
  }
  
  private static String chm()
  {
    AppMethodBeat.i(117655);
    Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected(localContext))
    {
      Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, not connected");
      AppMethodBeat.o(117655);
      return "fail";
    }
    Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, type = ".concat(String.valueOf(NetStatusUtil.getNetType(localContext))));
    if (NetStatusUtil.is2G(localContext))
    {
      Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 2g");
      AppMethodBeat.o(117655);
      return "2g";
    }
    if (NetStatusUtil.is3G(localContext))
    {
      Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 3g");
      AppMethodBeat.o(117655);
      return "3g";
    }
    if (NetStatusUtil.is4G(localContext))
    {
      Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 4g");
      AppMethodBeat.o(117655);
      return "4g";
    }
    if (NetStatusUtil.isWifi(localContext))
    {
      Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, wifi");
      AppMethodBeat.o(117655);
      return "wifi";
    }
    AppMethodBeat.o(117655);
    return "fail";
  }
  
  public static void gQE() {}
  
  private static String u(Object... paramVarArgs)
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ah
 * JD-Core Version:    0.7.0.1
 */