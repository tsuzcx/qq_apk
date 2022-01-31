package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.sdk.platformtools.y;

public class k$c
  implements ServiceConnection
{
  public k$c(k paramk) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.i("MicroMsg.MMWebViewClient", "onServiceConnected");
    if (this.rCv.dYF == null)
    {
      y.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
      return;
    }
    try
    {
      this.rCv.rsT = d.a.H(paramIBinder);
      this.rCv.rsT.a(this.rCv.rCu, this.rCv.dYF.hashCode());
      if (this.rCv.rCd != null) {
        this.rCv.rsT.a(this.rCv.rCd, this.rCv.dYF.hashCode());
      }
      this.rCv.a(this.rCv.rsT, this.rCv.rxH);
      this.rCv.cgP();
      this.rCv.cfO();
      return;
    }
    catch (Exception paramComponentName)
    {
      y.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
    if (!this.rCv.fyk.isFinishing())
    {
      y.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
      k.a(this.rCv);
      return;
    }
    this.rCv.rsT = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.c
 * JD-Core Version:    0.7.0.1
 */