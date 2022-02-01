package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  public static k EbJ;
  private String EbK;
  private String bssid;
  boolean hII = false;
  private e lvv = null;
  private int networkType;
  private String sessionId;
  private String ssid;
  String zuO;
  
  static
  {
    AppMethodBeat.i(79943);
    EbJ = new k();
    AppMethodBeat.o(79943);
  }
  
  private void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(79942);
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20adInfo", this.zuO + ",");
    localg.m("21optype", paramInt1 + ",");
    localg.m("22sessionId", this.sessionId + ",");
    localg.m("23currURL", this.EbK + ",");
    localg.m("24referURL", paramString + ",");
    localg.m("25errCode", paramInt2 + ",");
    localg.m("26networkType", this.networkType + ",");
    localg.m("27timeStamp", bt.flT() + ",");
    localg.m("28ssid", this.ssid + ",");
    localg.m("29bssid", this.bssid + ",");
    ad.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.sessionId, this.EbK, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    com.tencent.mm.plugin.report.service.g.yhR.f(13791, new Object[] { localg });
    if (this.lvv == null)
    {
      ad.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(79942);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", localg.toString());
    try
    {
      this.lvv.y(1295, paramString);
      AppMethodBeat.o(79942);
      return;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(79942);
    }
  }
  
  public final void CA()
  {
    AppMethodBeat.i(208024);
    ad.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { this.zuO });
    if (bt.isNullOrNil(this.zuO))
    {
      AppMethodBeat.o(208024);
      return;
    }
    ma(2);
    AppMethodBeat.o(208024);
  }
  
  public final void Xx(int paramInt)
  {
    AppMethodBeat.i(79939);
    ad.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.zuO });
    if (bt.isNullOrNil(this.zuO))
    {
      AppMethodBeat.o(79939);
      return;
    }
    o(3, "", paramInt);
    AppMethodBeat.o(79939);
  }
  
  public final void b(e parame)
  {
    this.lvv = parame;
  }
  
  public final void cD(String paramString)
  {
    AppMethodBeat.i(208023);
    ad.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, this.EbK, this.zuO });
    String str = this.EbK;
    this.EbK = paramString;
    if (bt.isNullOrNil(this.zuO))
    {
      AppMethodBeat.o(208023);
      return;
    }
    o(1, str, 0);
    AppMethodBeat.o(208023);
  }
  
  public final void close()
  {
    AppMethodBeat.i(79940);
    ad.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.zuO });
    this.hII = true;
    if (bt.isNullOrNil(this.zuO))
    {
      AppMethodBeat.o(79940);
      return;
    }
    ma(4);
    this.zuO = null;
    AppMethodBeat.o(79940);
  }
  
  public final void kY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79938);
    ad.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.zuO = paramString1;
    this.networkType = com.tencent.mm.plugin.webview.model.ay.blr();
    this.sessionId = ai.ee(paramString2 + bt.flT());
    this.ssid = com.tencent.mm.sdk.platformtools.ay.iV(aj.getContext());
    this.bssid = com.tencent.mm.sdk.platformtools.ay.iW(aj.getContext());
    this.hII = false;
    AppMethodBeat.o(79938);
  }
  
  final void ma(int paramInt)
  {
    AppMethodBeat.i(79941);
    o(paramInt, "", 0);
    AppMethodBeat.o(79941);
  }
  
  public final void setTraceId(String paramString)
  {
    AppMethodBeat.i(208022);
    String str3 = "";
    String str1 = str3;
    if (this.lvv != null) {}
    try
    {
      str1 = this.lvv.k(23, null).getString("config_info_username");
      kY(paramString, str1);
      AppMethodBeat.o(208022);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[] { localRemoteException });
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */