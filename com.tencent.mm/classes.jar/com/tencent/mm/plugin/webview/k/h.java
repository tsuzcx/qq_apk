package com.tencent.mm.plugin.webview.k;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"TAG", "", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "canDebug", "", "showToast", "", "content", "tag", "webview-sdk_release"})
public final class h
{
  static final ax bFO()
  {
    AppMethodBeat.i(82933);
    ax localax = ax.aQz("__webcompt_command");
    p.g(localax, "MultiProcessMMKV.getMMKV(\"__webcompt_command\")");
    AppMethodBeat.o(82933);
    return localax;
  }
  
  static final boolean eNz()
  {
    AppMethodBeat.i(82935);
    if ((i.IS_FLAVOR_RED) || (i.DEBUG) || ((ad.getLogLevel() == 0) && (bu.flY())))
    {
      AppMethodBeat.o(82935);
      return true;
    }
    AppMethodBeat.o(82935);
    return false;
  }
  
  static final void showToast(String paramString)
  {
    AppMethodBeat.i(82934);
    if (eNz()) {
      aq.f((Runnable)new a(paramString));
    }
    ad.i("WebComptCommand", paramString);
    AppMethodBeat.o(82934);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(82932);
      Toast.makeText(aj.getContext(), (CharSequence)this.fKu, 0).show();
      AppMethodBeat.o(82932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.h
 * JD-Core Version:    0.7.0.1
 */