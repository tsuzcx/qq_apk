package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public class k$c
  implements ServiceConnection
{
  protected k$c(k paramk) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(9967);
    ab.i("MicroMsg.MMWebViewClient", "onServiceConnected");
    if (this.vsH.foJ == null)
    {
      ab.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
      AppMethodBeat.o(9967);
      return;
    }
    try
    {
      this.vsH.viZ = d.a.F(paramIBinder);
      this.vsH.viZ.a(new k.d(new WeakReference(this.vsH.vsG)), this.vsH.foJ.hashCode());
      if (this.vsH.vsp != null) {
        this.vsH.viZ.a(this.vsH.vsp, this.vsH.foJ.hashCode());
      }
      this.vsH.dgW();
      this.vsH.dfX();
      this.vsH.a(this.vsH.viZ, this.vsH.voA);
      AppMethodBeat.o(9967);
      return;
    }
    catch (Exception paramComponentName)
    {
      ab.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
      AppMethodBeat.o(9967);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(9968);
    ab.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
    if (!this.vsH.gQx.isFinishing())
    {
      ab.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
      k.a(this.vsH);
      AppMethodBeat.o(9968);
      return;
    }
    this.vsH.viZ = null;
    AppMethodBeat.o(9968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.c
 * JD-Core Version:    0.7.0.1
 */