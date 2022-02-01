package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public final class k
{
  public static k EtK;
  private String EtL;
  private String bssid;
  boolean hLB = false;
  private e lzT = null;
  private int networkType;
  private String sessionId;
  private String ssid;
  String zMj;
  
  static
  {
    AppMethodBeat.i(79943);
    EtK = new k();
    AppMethodBeat.o(79943);
  }
  
  private void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(79942);
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20adInfo", this.zMj + ",");
    localg.m("21optype", paramInt1 + ",");
    localg.m("22sessionId", this.sessionId + ",");
    localg.m("23currURL", this.EtL + ",");
    localg.m("24referURL", paramString + ",");
    localg.m("25errCode", paramInt2 + ",");
    localg.m("26networkType", this.networkType + ",");
    localg.m("27timeStamp", bu.fpO() + ",");
    localg.m("28ssid", this.ssid + ",");
    localg.m("29bssid", this.bssid + ",");
    ae.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.sessionId, this.EtL, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    com.tencent.mm.plugin.report.service.g.yxI.f(13791, new Object[] { localg });
    if (this.lzT == null)
    {
      ae.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(79942);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", localg.toString());
    try
    {
      this.lzT.y(1295, paramString);
      AppMethodBeat.o(79942);
      return;
    }
    catch (RemoteException paramString)
    {
      ae.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(79942);
    }
  }
  
  public final void CD()
  {
    AppMethodBeat.i(198201);
    ae.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { this.zMj });
    if (bu.isNullOrNil(this.zMj))
    {
      AppMethodBeat.o(198201);
      return;
    }
    md(2);
    AppMethodBeat.o(198201);
  }
  
  public final void Yd(int paramInt)
  {
    AppMethodBeat.i(79939);
    ae.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.zMj });
    if (bu.isNullOrNil(this.zMj))
    {
      AppMethodBeat.o(79939);
      return;
    }
    o(3, "", paramInt);
    AppMethodBeat.o(79939);
  }
  
  public final void b(e parame)
  {
    this.lzT = parame;
  }
  
  public final void cE(String paramString)
  {
    AppMethodBeat.i(198200);
    ae.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, this.EtL, this.zMj });
    String str = this.EtL;
    this.EtL = paramString;
    if (bu.isNullOrNil(this.zMj))
    {
      AppMethodBeat.o(198200);
      return;
    }
    o(1, str, 0);
    AppMethodBeat.o(198200);
  }
  
  public final void close()
  {
    AppMethodBeat.i(79940);
    ae.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.zMj });
    this.hLB = true;
    if (bu.isNullOrNil(this.zMj))
    {
      AppMethodBeat.o(79940);
      return;
    }
    md(4);
    this.zMj = null;
    AppMethodBeat.o(79940);
  }
  
  public final void lf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79938);
    ae.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.zMj = paramString1;
    this.networkType = ay.bma();
    this.sessionId = aj.ej(paramString2 + bu.fpO());
    this.ssid = az.ja(ak.getContext());
    this.bssid = az.jb(ak.getContext());
    this.hLB = false;
    AppMethodBeat.o(79938);
  }
  
  final void md(int paramInt)
  {
    AppMethodBeat.i(79941);
    o(paramInt, "", 0);
    AppMethodBeat.o(79941);
  }
  
  public final void setTraceId(String paramString)
  {
    AppMethodBeat.i(198199);
    String str3 = "";
    String str1 = str3;
    if (this.lzT != null) {}
    try
    {
      str1 = this.lzT.k(23, null).getString("config_info_username");
      lf(paramString, str1);
      AppMethodBeat.o(198199);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[] { localRemoteException });
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */