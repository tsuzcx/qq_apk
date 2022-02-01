package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
{
  public static m Qer;
  private String Qes;
  private String bssid;
  boolean lwF = false;
  private int networkType;
  private e pGC = null;
  private String sessionId;
  private String ssid;
  String traceid;
  
  static
  {
    AppMethodBeat.i(79943);
    Qer = new m();
    AppMethodBeat.o(79943);
  }
  
  private void s(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(79942);
    n localn = new n();
    localn.m("20adInfo", this.traceid + ",");
    localn.m("21optype", paramInt1 + ",");
    localn.m("22sessionId", this.sessionId + ",");
    localn.m("23currURL", this.Qes + ",");
    localn.m("24referURL", paramString + ",");
    localn.m("25errCode", paramInt2 + ",");
    localn.m("26networkType", this.networkType + ",");
    localn.m("27timeStamp", Util.nowMilliSecond() + ",");
    localn.m("28ssid", this.ssid + ",");
    localn.m("29bssid", this.bssid + ",");
    Log.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.sessionId, this.Qes, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    h.IzE.a(13791, new Object[] { localn });
    if (this.pGC == null)
    {
      Log.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(79942);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", localn.toString());
    try
    {
      this.pGC.z(1295, paramString);
      AppMethodBeat.o(79942);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(79942);
    }
  }
  
  public final void OR()
  {
    AppMethodBeat.i(216400);
    Log.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { this.traceid });
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(216400);
      return;
    }
    rE(2);
    AppMethodBeat.o(216400);
  }
  
  public final void a(e parame)
  {
    this.pGC = parame;
  }
  
  public final void aoB(int paramInt)
  {
    AppMethodBeat.i(79939);
    Log.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.traceid });
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(79939);
      return;
    }
    s(3, "", paramInt);
    AppMethodBeat.o(79939);
  }
  
  public final void close()
  {
    AppMethodBeat.i(79940);
    Log.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.traceid });
    this.lwF = true;
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(79940);
      return;
    }
    rE(4);
    this.traceid = null;
    AppMethodBeat.o(79940);
  }
  
  public final void dv(String paramString)
  {
    AppMethodBeat.i(216399);
    Log.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, this.Qes, this.traceid });
    String str = this.Qes;
    this.Qes = paramString;
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(216399);
      return;
    }
    s(1, str, 0);
    AppMethodBeat.o(216399);
  }
  
  public final String getTraceId()
  {
    return this.traceid;
  }
  
  public final void mF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79938);
    Log.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.traceid = paramString1;
    this.networkType = ba.bTg();
    this.sessionId = MD5Util.getMD5String(paramString2 + Util.nowMilliSecond());
    this.ssid = ConnectivityCompat.Companion.getFormattedWiFiSsid();
    this.bssid = ConnectivityCompat.Companion.getFormattedWiFiBssid();
    this.lwF = false;
    AppMethodBeat.o(79938);
  }
  
  final void rE(int paramInt)
  {
    AppMethodBeat.i(79941);
    s(paramInt, "", 0);
    AppMethodBeat.o(79941);
  }
  
  public final void setTraceId(String paramString)
  {
    AppMethodBeat.i(216396);
    String str3 = "";
    String str1 = str3;
    if (this.pGC != null) {}
    try
    {
      str1 = this.pGC.l(23, null).getString("config_info_username");
      mF(paramString, str1);
      AppMethodBeat.o(216396);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[] { localRemoteException });
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */