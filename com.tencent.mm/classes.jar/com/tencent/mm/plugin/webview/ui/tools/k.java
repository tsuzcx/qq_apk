package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class k
{
  public static k Cya;
  private String Cyb;
  private String bssid;
  boolean hqq = false;
  private e kYt = null;
  private int networkType;
  private String sessionId;
  private String ssid;
  String yeN;
  
  static
  {
    AppMethodBeat.i(79943);
    Cya = new k();
    AppMethodBeat.o(79943);
  }
  
  private void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(79942);
    f localf = new f();
    localf.n("20adInfo", this.yeN + ",");
    localf.n("21optype", paramInt1 + ",");
    localf.n("22sessionId", this.sessionId + ",");
    localf.n("23currURL", this.Cyb + ",");
    localf.n("24referURL", paramString + ",");
    localf.n("25errCode", paramInt2 + ",");
    localf.n("26networkType", this.networkType + ",");
    localf.n("27timeStamp", bs.eWj() + ",");
    localf.n("28ssid", this.ssid + ",");
    localf.n("29bssid", this.bssid + ",");
    ac.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.sessionId, this.Cyb, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    h.wUl.f(13791, new Object[] { localf });
    if (this.kYt == null)
    {
      ac.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(79942);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", localf.toString());
    try
    {
      this.kYt.x(1295, paramString);
      AppMethodBeat.o(79942);
      return;
    }
    catch (RemoteException paramString)
    {
      ac.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(79942);
    }
  }
  
  public final void Bb()
  {
    AppMethodBeat.i(188380);
    ac.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { this.yeN });
    if (bs.isNullOrNil(this.yeN))
    {
      AppMethodBeat.o(188380);
      return;
    }
    lA(2);
    AppMethodBeat.o(188380);
  }
  
  public final void VI(int paramInt)
  {
    AppMethodBeat.i(79939);
    ac.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.yeN });
    if (bs.isNullOrNil(this.yeN))
    {
      AppMethodBeat.o(79939);
      return;
    }
    o(3, "", paramInt);
    AppMethodBeat.o(79939);
  }
  
  public final void b(e parame)
  {
    this.kYt = parame;
  }
  
  public final void bK(String paramString)
  {
    AppMethodBeat.i(188379);
    ac.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, this.Cyb, this.yeN });
    String str = this.Cyb;
    this.Cyb = paramString;
    if (bs.isNullOrNil(this.yeN))
    {
      AppMethodBeat.o(188379);
      return;
    }
    o(1, str, 0);
    AppMethodBeat.o(188379);
  }
  
  public final void close()
  {
    AppMethodBeat.i(79940);
    ac.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.yeN });
    this.hqq = true;
    if (bs.isNullOrNil(this.yeN))
    {
      AppMethodBeat.o(79940);
      return;
    }
    lA(4);
    this.yeN = null;
    AppMethodBeat.o(79940);
  }
  
  public final void kC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79938);
    ac.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.yeN = paramString1;
    this.networkType = com.tencent.mm.plugin.webview.model.ax.bhK();
    this.sessionId = ah.dg(paramString2 + bs.eWj());
    this.ssid = com.tencent.mm.sdk.platformtools.ax.iL(ai.getContext());
    this.bssid = com.tencent.mm.sdk.platformtools.ax.iM(ai.getContext());
    this.hqq = false;
    AppMethodBeat.o(79938);
  }
  
  final void lA(int paramInt)
  {
    AppMethodBeat.i(79941);
    o(paramInt, "", 0);
    AppMethodBeat.o(79941);
  }
  
  public final void setTraceId(String paramString)
  {
    AppMethodBeat.i(188378);
    String str3 = "";
    String str1 = str3;
    if (this.kYt != null) {}
    try
    {
      str1 = this.kYt.k(23, null).getString("config_info_username");
      kC(paramString, str1);
      AppMethodBeat.o(188378);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[] { localRemoteException });
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */