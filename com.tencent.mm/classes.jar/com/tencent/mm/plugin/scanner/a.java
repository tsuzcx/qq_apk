package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/AppBrandQRCodeScanReport;", "", "()V", "TAG", "", "lastExposeTime", "", "getLastExposeTime", "()J", "setLastExposeTime", "(J)V", "doUrlEncode", "url", "getReportCodeType", "", "codeType", "codeStr", "report", "", "sessionId", "scene", "appId", "isWebView", "", "pathWithQuery", "codeString", "isShowEntry", "isClick", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static long Ndw;
  public static final a OGI;
  
  static
  {
    AppMethodBeat.i(313361);
    OGI = new a();
    AppMethodBeat.o(313361);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt2, String paramString4, boolean paramBoolean2, boolean paramBoolean3, String paramString5)
  {
    AppMethodBeat.i(313353);
    if (!paramBoolean3)
    {
      long l = System.currentTimeMillis();
      if (l - Ndw < 1000L)
      {
        Log.d("MicroMsg.AppBrandQRCodeScanReport", "report 22688 repeat");
        AppMethodBeat.o(313353);
        return;
      }
      Ndw = l;
    }
    paramString3 = aUC(paramString3);
    paramString5 = aUC(paramString5);
    String str = aUC(paramString4);
    int i;
    label180:
    int j;
    if (k.cK(paramInt2, paramString4))
    {
      paramInt2 = 1;
      Log.d("MicroMsg.AppBrandQRCodeScanReport", "report 22688, sessionId=" + paramString1 + ", scene=" + paramInt1 + ", appId=" + paramString2 + " isClick=" + paramBoolean3 + ", isShowEntry=" + paramBoolean2 + ", isWebView=" + paramBoolean1 + ", reportCodeType=" + paramInt2 + ", codeString=" + paramString4);
      paramString4 = h.OAn;
      if (!paramBoolean1) {
        break label402;
      }
      i = 1;
      if (!paramBoolean3) {
        break label408;
      }
      j = 1;
      label188:
      if (!paramBoolean2) {
        break label414;
      }
    }
    label402:
    label408:
    label414:
    for (int k = 1;; k = 0)
    {
      paramString4.b(22688, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(i), paramString3, paramString5, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), str });
      AppMethodBeat.o(313353);
      return;
      if (k.cM(paramInt2, paramString4))
      {
        paramInt2 = 2;
        break;
      }
      if (k.cN(paramInt2, paramString4))
      {
        paramInt2 = 3;
        break;
      }
      if (k.cS(paramInt2, paramString4))
      {
        paramInt2 = 4;
        break;
      }
      if (k.cO(paramInt2, paramString4))
      {
        paramInt2 = 5;
        break;
      }
      if (k.cP(paramInt2, paramString4))
      {
        paramInt2 = 6;
        break;
      }
      if (k.cL(paramInt2, paramString4))
      {
        paramInt2 = 7;
        break;
      }
      if (k.cT(paramInt2, paramString4))
      {
        paramInt2 = 8;
        break;
      }
      paramInt2 = 0;
      break;
      i = 0;
      break label180;
      j = 0;
      break label188;
    }
  }
  
  private static String aUC(String paramString)
  {
    AppMethodBeat.i(313358);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        String str = URLEncoder.encode(paramString, "utf-8");
        AppMethodBeat.o(313358);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.e("MicroMsg.AppBrandQRCodeScanReport", "URLEncode fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    AppMethodBeat.o(313358);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a
 * JD-Core Version:    0.7.0.1
 */