package com.tencent.mm.plugin.webview.ui.tools;

import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class h
{
  public static h rnm = new h();
  private String bIB;
  private String bssid;
  boolean dYj = false;
  com.tencent.mm.plugin.webview.stub.d gGn = null;
  private int networkType;
  String oAk;
  String rnn;
  private String ssid;
  
  public final void CD(int paramInt)
  {
    y.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.oAk });
    if (bk.bl(this.oAk)) {
      return;
    }
    f(3, "", paramInt);
  }
  
  public final void close()
  {
    y.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.oAk });
    this.dYj = true;
    if (bk.bl(this.oAk)) {
      return;
    }
    jdMethod_if(4);
    this.oAk = null;
  }
  
  final void f(int paramInt1, String paramString, int paramInt2)
  {
    com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
    locald.j("20adInfo", this.oAk + ",");
    locald.j("21optype", paramInt1 + ",");
    locald.j("22sessionId", this.bIB + ",");
    locald.j("23currURL", this.rnn + ",");
    locald.j("24referURL", paramString + ",");
    locald.j("25errCode", paramInt2 + ",");
    locald.j("26networkType", this.networkType + ",");
    locald.j("27timeStamp", bk.UY() + ",");
    locald.j("28ssid", this.ssid + ",");
    locald.j("29bssid", this.bssid + ",");
    y.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.bIB, this.rnn, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    com.tencent.mm.plugin.report.service.h.nFQ.f(13791, new Object[] { locald });
    if (this.gGn == null)
    {
      y.e("MicroMsg.WebViewReportUtil", "report invoker null");
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", locald.toString());
    try
    {
      this.gGn.r(1295, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      y.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
    }
  }
  
  public final void fA(String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.oAk = paramString1;
    this.networkType = an.ccb();
    this.bIB = ad.bB(paramString2 + bk.UY());
    paramString1 = aq.getWifiInfo(ae.getContext());
    if (paramString1 == null) {
      this.ssid = "";
    }
    for (this.bssid = "";; this.bssid = paramString1.getBSSID())
    {
      this.dYj = false;
      return;
      this.ssid = paramString1.getSSID();
    }
  }
  
  final void jdMethod_if(int paramInt)
  {
    f(paramInt, "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */