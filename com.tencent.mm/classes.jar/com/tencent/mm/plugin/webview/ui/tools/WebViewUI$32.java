package com.tencent.mm.plugin.webview.ui.tools;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$32
  implements ServiceConnection
{
  WebViewUI$32(WebViewUI paramWebViewUI) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(7854);
    ab.i("MicroMsg.WebViewUI", "edw onServiceConnected");
    if (this.vgz.pOd == null)
    {
      ab.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
      AppMethodBeat.o(7854);
      return;
    }
    this.vgz.igU = d.a.F(paramIBinder);
    try
    {
      this.vgz.igU.a(this.vgz.uWu, this.vgz.hashCode());
      if (this.vgz.igU == null)
      {
        bool = true;
        ab.i("MicroMsg.WebViewUI", "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
        m.vdm.igU = this.vgz.igU;
        if (!bo.isNullOrNil(this.vgz.getIntent().getStringExtra("ad_info")))
        {
          localm = m.vdm;
          str = this.vgz.getIntent().getStringExtra("ad_info");
          paramIBinder = "";
          paramComponentName = paramIBinder;
          if (localm.igU == null) {}
        }
      }
    }
    catch (Exception paramComponentName)
    {
      try
      {
        for (;;)
        {
          m localm;
          String str;
          paramComponentName = localm.igU.i(23, null).getString("config_info_username");
          localm.hx(str, paramComponentName);
          if (this.vgz.igU != null) {
            break;
          }
          ab.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
          this.vgz.finish();
          AppMethodBeat.o(7854);
          return;
          paramComponentName = paramComponentName;
          ab.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
        }
        boolean bool = false;
      }
      catch (RemoteException paramComponentName)
      {
        for (;;)
        {
          ab.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[] { paramComponentName });
          paramComponentName = paramIBinder;
        }
        this.vgz.aMf();
        AppMethodBeat.o(7854);
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(7855);
    ab.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
    if (((this.vgz.vfK) && (WebViewUI.vfJ <= 0)) || ((!this.vgz.vfK) && (WebViewUI.vfJ <= 1))) {
      c.c(this.vgz.igU);
    }
    if ((!this.vgz.vfK) && (!WebViewUI.a(this.vgz)) && (!this.vgz.isFinishing()))
    {
      ab.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
      WebViewUI.b(this.vgz);
      AppMethodBeat.o(7855);
      return;
    }
    this.vgz.igU = null;
    AppMethodBeat.o(7855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.32
 * JD-Core Version:    0.7.0.1
 */