package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  public static l Jhd;
  private String Jhe;
  private String bssid;
  boolean iGD = false;
  private e mHh = null;
  private int networkType;
  private String sessionId;
  private String ssid;
  String traceid;
  
  static
  {
    AppMethodBeat.i(79943);
    Jhd = new l();
    AppMethodBeat.o(79943);
  }
  
  private void q(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(79942);
    m localm = new m();
    localm.n("20adInfo", this.traceid + ",");
    localm.n("21optype", paramInt1 + ",");
    localm.n("22sessionId", this.sessionId + ",");
    localm.n("23currURL", this.Jhe + ",");
    localm.n("24referURL", paramString + ",");
    localm.n("25errCode", paramInt2 + ",");
    localm.n("26networkType", this.networkType + ",");
    localm.n("27timeStamp", Util.nowMilliSecond() + ",");
    localm.n("28ssid", this.ssid + ",");
    localm.n("29bssid", this.bssid + ",");
    Log.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.sessionId, this.Jhe, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    h.CyF.a(13791, new Object[] { localm });
    if (this.mHh == null)
    {
      Log.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(79942);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", localm.toString());
    try
    {
      this.mHh.x(1295, paramString);
      AppMethodBeat.o(79942);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(79942);
    }
  }
  
  public final void LZ()
  {
    AppMethodBeat.i(211101);
    Log.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { this.traceid });
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(211101);
      return;
    }
    pl(2);
    AppMethodBeat.o(211101);
  }
  
  public final void agL(int paramInt)
  {
    AppMethodBeat.i(79939);
    Log.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.traceid });
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(79939);
      return;
    }
    q(3, "", paramInt);
    AppMethodBeat.o(79939);
  }
  
  public final void b(e parame)
  {
    this.mHh = parame;
  }
  
  public final void cV(String paramString)
  {
    AppMethodBeat.i(211100);
    Log.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, this.Jhe, this.traceid });
    String str = this.Jhe;
    this.Jhe = paramString;
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(211100);
      return;
    }
    q(1, str, 0);
    AppMethodBeat.o(211100);
  }
  
  public final void close()
  {
    AppMethodBeat.i(79940);
    Log.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.traceid });
    this.iGD = true;
    if (Util.isNullOrNil(this.traceid))
    {
      AppMethodBeat.o(79940);
      return;
    }
    pl(4);
    this.traceid = null;
    AppMethodBeat.o(79940);
  }
  
  public final void me(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79938);
    Log.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.traceid = paramString1;
    this.networkType = az.bHy();
    this.sessionId = MD5Util.getMD5String(paramString2 + Util.nowMilliSecond());
    this.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
    this.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
    this.iGD = false;
    AppMethodBeat.o(79938);
  }
  
  final void pl(int paramInt)
  {
    AppMethodBeat.i(79941);
    q(paramInt, "", 0);
    AppMethodBeat.o(79941);
  }
  
  public final void setTraceId(String paramString)
  {
    AppMethodBeat.i(211099);
    String str3 = "";
    String str1 = str3;
    if (this.mHh != null) {}
    try
    {
      str1 = this.mHh.j(23, null).getString("config_info_username");
      me(paramString, str1);
      AppMethodBeat.o(211099);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */