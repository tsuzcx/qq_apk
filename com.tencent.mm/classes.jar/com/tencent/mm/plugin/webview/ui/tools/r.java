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

public final class r
{
  public static r WWq;
  public String WWr;
  private String bssid;
  private int networkType;
  boolean ooe = false;
  public e sLC = null;
  private String sessionId;
  private String ssid;
  public String traceid;
  
  static
  {
    AppMethodBeat.i(79943);
    WWq = new r();
    AppMethodBeat.o(79943);
  }
  
  public final void auu(int paramInt)
  {
    AppMethodBeat.i(79939);
    Log.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.traceid });
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(79939);
      return;
    }
    x(3, "", paramInt);
    AppMethodBeat.o(79939);
  }
  
  public final void close()
  {
    AppMethodBeat.i(79940);
    Log.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.traceid });
    this.ooe = true;
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(79940);
      return;
    }
    rG(4);
    this.traceid = null;
    AppMethodBeat.o(79940);
  }
  
  public final String getTraceId()
  {
    return this.traceid;
  }
  
  public final void ow(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79938);
    Log.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.traceid = paramString1;
    this.networkType = ba.ctm();
    this.sessionId = MD5Util.getMD5String(paramString2 + Util.nowMilliSecond());
    this.ssid = ConnectivityCompat.Companion.getFormattedWiFiSsid();
    this.bssid = ConnectivityCompat.Companion.getFormattedWiFiBssid();
    this.ooe = false;
    AppMethodBeat.o(79938);
  }
  
  public final void rG(int paramInt)
  {
    AppMethodBeat.i(79941);
    x(paramInt, "", 0);
    AppMethodBeat.o(79941);
  }
  
  public final void x(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(79942);
    n localn = new n();
    localn.s("20adInfo", this.traceid + ",");
    localn.s("21optype", paramInt1 + ",");
    localn.s("22sessionId", this.sessionId + ",");
    localn.s("23currURL", this.WWr + ",");
    localn.s("24referURL", paramString + ",");
    localn.s("25errCode", paramInt2 + ",");
    localn.s("26networkType", this.networkType + ",");
    localn.s("27timeStamp", Util.nowMilliSecond() + ",");
    localn.s("28ssid", this.ssid + ",");
    localn.s("29bssid", this.bssid + ",");
    Log.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.sessionId, this.WWr, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    h.OAn.b(13791, new Object[] { localn });
    if (this.sLC == null)
    {
      Log.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(79942);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", localn.toString());
    try
    {
      this.sLC.C(1295, paramString);
      AppMethodBeat.o(79942);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(79942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */