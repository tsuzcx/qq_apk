package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  public static k BfO;
  private String BfP;
  private String bssid;
  boolean gPQ = false;
  private e kxf = null;
  private int networkType;
  private String sessionId;
  private String ssid;
  String wSh;
  
  static
  {
    AppMethodBeat.i(79943);
    BfO = new k();
    AppMethodBeat.o(79943);
  }
  
  private void m(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(79942);
    f localf = new f();
    localf.o("20adInfo", this.wSh + ",");
    localf.o("21optype", paramInt1 + ",");
    localf.o("22sessionId", this.sessionId + ",");
    localf.o("23currURL", this.BfP + ",");
    localf.o("24referURL", paramString + ",");
    localf.o("25errCode", paramInt2 + ",");
    localf.o("26networkType", this.networkType + ",");
    localf.o("27timeStamp", bt.eGO() + ",");
    localf.o("28ssid", this.ssid + ",");
    localf.o("29bssid", this.bssid + ",");
    ad.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.sessionId, this.BfP, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    h.vKh.f(13791, new Object[] { localf });
    if (this.kxf == null)
    {
      ad.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(79942);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", localf.toString());
    try
    {
      this.kxf.w(1295, paramString);
      AppMethodBeat.o(79942);
      return;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(79942);
    }
  }
  
  public final void Bx()
  {
    AppMethodBeat.i(187949);
    ad.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { this.wSh });
    if (bt.isNullOrNil(this.wSh))
    {
      AppMethodBeat.o(187949);
      return;
    }
    lI(2);
    AppMethodBeat.o(187949);
  }
  
  public final void TA(int paramInt)
  {
    AppMethodBeat.i(79939);
    ad.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.wSh });
    if (bt.isNullOrNil(this.wSh))
    {
      AppMethodBeat.o(79939);
      return;
    }
    m(3, "", paramInt);
    AppMethodBeat.o(79939);
  }
  
  public final void b(e parame)
  {
    this.kxf = parame;
  }
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(187948);
    ad.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, this.BfP, this.wSh });
    String str = this.BfP;
    this.BfP = paramString;
    if (bt.isNullOrNil(this.wSh))
    {
      AppMethodBeat.o(187948);
      return;
    }
    m(1, str, 0);
    AppMethodBeat.o(187948);
  }
  
  public final void close()
  {
    AppMethodBeat.i(79940);
    ad.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.wSh });
    this.gPQ = true;
    if (bt.isNullOrNil(this.wSh))
    {
      AppMethodBeat.o(79940);
      return;
    }
    lI(4);
    this.wSh = null;
    AppMethodBeat.o(79940);
  }
  
  public final void kg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79938);
    ad.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.wSh = paramString1;
    this.networkType = ax.baS();
    this.sessionId = ai.du(paramString2 + bt.eGO());
    this.ssid = ay.iA(aj.getContext());
    this.bssid = ay.iB(aj.getContext());
    this.gPQ = false;
    AppMethodBeat.o(79938);
  }
  
  final void lI(int paramInt)
  {
    AppMethodBeat.i(79941);
    m(paramInt, "", 0);
    AppMethodBeat.o(79941);
  }
  
  public final void setTraceId(String paramString)
  {
    AppMethodBeat.i(187947);
    String str3 = "";
    String str1 = str3;
    if (this.kxf != null) {}
    try
    {
      str1 = this.kxf.j(23, null).getString("config_info_username");
      kg(paramString, str1);
      AppMethodBeat.o(187947);
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