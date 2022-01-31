package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class z
{
  private static int Bl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return aa.Bs(0);
    case 201: 
      return -1;
    }
    return aa.Bs(1);
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, int paramInt4)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramBoolean1, paramString4, paramBoolean2, paramString5, paramString6, paramInt4, false);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, int paramInt4, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean2)
    {
      i = 1;
      if ((paramInt1 == 1) || (paramInt1 == 10) || (paramInt1 == 12)) {
        i = 0;
      }
      localObject2 = new Object[16];
      localObject2[0] = Integer.valueOf(paramInt1);
      localObject2[1] = Integer.valueOf(paramInt2);
      localObject2[2] = bk.aM(paramString1, "");
      localObject2[3] = bk.aM(paramString2, "");
      if (!TextUtils.isEmpty(paramString3)) {
        break label288;
      }
      localObject1 = "";
      label83:
      localObject2[4] = localObject1;
      localObject2[5] = Integer.valueOf(paramInt3);
      if (!paramBoolean1) {
        break label295;
      }
      j = 1;
      label106:
      localObject2[6] = Integer.valueOf(j);
      localObject2[7] = bk.aM(paramString4, "");
      localObject2[8] = Long.valueOf(System.currentTimeMillis());
      localObject2[9] = bZp();
      localObject2[10] = Integer.valueOf(i);
      localObject2[11] = bk.aM(paramString5, "");
      if (!TextUtils.isEmpty(paramString6)) {
        break label301;
      }
      localObject1 = "";
      label181:
      localObject2[12] = localObject1;
      localObject2[13] = Integer.valueOf(paramInt4);
      localObject2[14] = Integer.valueOf(Bl(paramInt2));
      if (!paramBoolean3) {
        break label308;
      }
    }
    label288:
    label295:
    label301:
    label308:
    for (int j = 1;; j = 0)
    {
      localObject2[15] = Integer.valueOf(j);
      localObject1 = new StringBuilder();
      j = 0;
      while (j < 15)
      {
        ((StringBuilder)localObject1).append(String.valueOf(localObject2[j]).replace(',', ' ')).append(',');
        j += 1;
      }
      i = 2;
      break;
      localObject1 = paramString3;
      break label83;
      j = 0;
      break label106;
      localObject1 = paramString6;
      break label181;
    }
    ((StringBuilder)localObject1).append(String.valueOf(localObject2[15]));
    y.i("MicroMsg.WebSearch.WebSearchActionTracer", "reporting 14904 %s ", new Object[] { ((StringBuilder)localObject1).toString() });
    Object localObject1 = f.nEG;
    Object localObject2 = bk.aM(paramString1, "");
    String str = bk.aM(paramString2, "");
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "";
    }
    long l;
    int m;
    if (paramBoolean1)
    {
      j = 1;
      paramString3 = bk.aM(paramString4, "");
      l = System.currentTimeMillis();
      paramString4 = bZp();
      paramString5 = bk.aM(paramString5, "");
      paramString2 = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramString2 = "";
      }
      m = Bl(paramInt2);
      if (!paramBoolean3) {
        break label579;
      }
    }
    label579:
    for (int k = 1;; k = 0)
    {
      ((f)localObject1).f(14904, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject2, str, paramString1, Integer.valueOf(paramInt3), Integer.valueOf(j), paramString3, Long.valueOf(l), paramString4, Integer.valueOf(i), paramString5, paramString2, Integer.valueOf(paramInt4), Integer.valueOf(m), Integer.valueOf(k) });
      return;
      j = 0;
      break;
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean, String paramString4, String paramString5, int paramInt3, String paramString6)
  {
    a(4, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramBoolean, paramString4, true, paramString5, paramString6, paramInt3);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, int paramInt3)
  {
    a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramBoolean1, paramString4, paramBoolean2, paramString5, paramInt3, "");
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, int paramInt3, String paramString6)
  {
    a(7, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramBoolean1, paramString4, paramBoolean2, paramString5, paramString6, paramInt3);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt2)
  {
    a(10, paramInt1, paramString1, paramString2, "", 0, paramBoolean, "", true, paramString3, "", paramInt2);
  }
  
  private static String bZp()
  {
    Context localContext = ae.getContext();
    if (!aq.isConnected(localContext))
    {
      y.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, not connected");
      return "fail";
    }
    int i = aq.getNetType(localContext);
    y.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, type = " + i);
    if (aq.is2G(localContext))
    {
      y.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 2g");
      return "2g";
    }
    if (aq.is3G(localContext))
    {
      y.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 3g");
      return "3g";
    }
    if (aq.is4G(localContext))
    {
      y.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 4g");
      return "4g";
    }
    if (aq.isWifi(localContext))
    {
      y.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, wifi");
      return "wifi";
    }
    return "fail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.z
 * JD-Core Version:    0.7.0.1
 */