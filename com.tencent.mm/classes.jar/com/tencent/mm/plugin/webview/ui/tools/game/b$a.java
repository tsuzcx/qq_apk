package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.c;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a
  extends k.c
{
  private b$a(b paramb)
  {
    super(paramb);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(8676);
    ab.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
    if (this.vmy.foJ == null)
    {
      ab.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
      AppMethodBeat.o(8676);
      return;
    }
    try
    {
      this.vmy.viZ = d.a.F(paramIBinder);
      this.vmy.viZ.a(this.vmy.vsG, this.vmy.foJ.hashCode());
      this.vmy.dgW();
      this.vmy.a(this.vmy.viZ, this.vmy.voA);
      this.vmy.dfX();
      AppMethodBeat.o(8676);
      return;
    }
    catch (Exception paramComponentName)
    {
      ab.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
      AppMethodBeat.o(8676);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(8677);
    super.onServiceDisconnected(paramComponentName);
    AppMethodBeat.o(8677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.b.a
 * JD-Core Version:    0.7.0.1
 */