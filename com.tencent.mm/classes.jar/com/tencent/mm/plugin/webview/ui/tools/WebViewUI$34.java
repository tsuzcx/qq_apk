package com.tencent.mm.plugin.webview.ui.tools;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.modelcache.o.a;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$34
  implements ServiceConnection
{
  WebViewUI$34(WebViewUI paramWebViewUI) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.i("MicroMsg.WebViewUI", "edw onServiceConnected");
    if (this.rpH.niQ == null)
    {
      y.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
      return;
    }
    this.rpH.gGn = d.a.H(paramIBinder);
    try
    {
      this.rpH.gGn.a(this.rpH.rgh, this.rpH.hashCode());
      if (this.rpH.gGn == null)
      {
        bool = true;
        y.i("MicroMsg.WebViewUI", "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
        h.rnm.gGn = this.rpH.gGn;
        if (!bk.bl(this.rpH.getIntent().getStringExtra("ad_info")))
        {
          localh = h.rnm;
          str = this.rpH.getIntent().getStringExtra("ad_info");
          paramIBinder = "";
          paramComponentName = paramIBinder;
          if (localh.gGn == null) {}
        }
      }
    }
    catch (Exception paramComponentName)
    {
      try
      {
        for (;;)
        {
          h localh;
          String str;
          paramComponentName = localh.gGn.f(23, null).getString("config_info_username");
          localh.fA(str, paramComponentName);
          if (this.rpH.gGn != null) {
            break;
          }
          y.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
          this.rpH.finish();
          return;
          paramComponentName = paramComponentName;
          y.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
        }
        boolean bool = false;
      }
      catch (RemoteException paramComponentName)
      {
        for (;;)
        {
          y.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[] { paramComponentName });
          paramComponentName = paramIBinder;
        }
        this.rpH.aoX();
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
    if (((this.rpH.roY) && (WebViewUI.ceD() <= 0)) || ((!this.rpH.roY) && (WebViewUI.ceD() <= 1)))
    {
      c.d(this.rpH.gGn);
      paramComponentName = o.a.ccx();
      int i = 0;
      while (i < paramComponentName.rhs.size())
      {
        paramComponentName.rhs.valueAt(i);
        i += 1;
      }
      paramComponentName.rhs.clear();
      paramComponentName.rht.clear();
    }
    if ((!this.rpH.roY) && (!WebViewUI.C(this.rpH)) && (!this.rpH.isFinishing()))
    {
      y.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
      WebViewUI.D(this.rpH);
      return;
    }
    this.rpH.gGn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.34
 * JD-Core Version:    0.7.0.1
 */