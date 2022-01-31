package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
{
  public static m vdm;
  private String bssid;
  private String cpW;
  boolean fon = false;
  com.tencent.mm.plugin.webview.stub.d igU = null;
  private int networkType;
  String rpu;
  private String ssid;
  String vdn;
  
  static
  {
    AppMethodBeat.i(7712);
    vdm = new m();
    AppMethodBeat.o(7712);
  }
  
  public final void Kx(int paramInt)
  {
    AppMethodBeat.i(7708);
    ab.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[] { this.rpu });
    if (bo.isNullOrNil(this.rpu))
    {
      AppMethodBeat.o(7708);
      return;
    }
    i(3, "", paramInt);
    AppMethodBeat.o(7708);
  }
  
  public final void close()
  {
    AppMethodBeat.i(7709);
    ab.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[] { this.rpu });
    this.fon = true;
    if (bo.isNullOrNil(this.rpu))
    {
      AppMethodBeat.o(7709);
      return;
    }
    kS(4);
    this.rpu = null;
    AppMethodBeat.o(7709);
  }
  
  public final void hx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7707);
    ab.i("MicroMsg.WebViewReportUtil", "setting traceid " + paramString1 + ",usename " + paramString2);
    this.rpu = paramString1;
    this.networkType = as.aDS();
    this.cpW = ag.cE(paramString2 + bo.aoy());
    this.ssid = at.gX(ah.getContext());
    this.bssid = at.gY(ah.getContext());
    this.fon = false;
    AppMethodBeat.o(7707);
  }
  
  final void i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(7711);
    com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
    locald.k("20adInfo", this.rpu + ",");
    locald.k("21optype", paramInt1 + ",");
    locald.k("22sessionId", this.cpW + ",");
    locald.k("23currURL", this.vdn + ",");
    locald.k("24referURL", paramString + ",");
    locald.k("25errCode", paramInt2 + ",");
    locald.k("26networkType", this.networkType + ",");
    locald.k("27timeStamp", bo.aoy() + ",");
    locald.k("28ssid", this.ssid + ",");
    locald.k("29bssid", this.bssid + ",");
    ab.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[] { Integer.valueOf(paramInt1), this.cpW, this.vdn, paramString, Integer.valueOf(paramInt2), Integer.valueOf(this.networkType) });
    h.qsU.e(13791, new Object[] { locald });
    if (this.igU == null)
    {
      ab.e("MicroMsg.WebViewReportUtil", "report invoker null");
      AppMethodBeat.o(7711);
      return;
    }
    paramString = new Bundle();
    paramString.putString("ad_report_data_str", locald.toString());
    try
    {
      this.igU.v(1295, paramString);
      AppMethodBeat.o(7711);
      return;
    }
    catch (RemoteException paramString)
    {
      ab.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[] { paramString });
      AppMethodBeat.o(7711);
    }
  }
  
  final void kS(int paramInt)
  {
    AppMethodBeat.i(7710);
    i(paramInt, "", 0);
    AppMethodBeat.o(7710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */