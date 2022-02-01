package com.tencent.mm.plugin.webview.k;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"TAG", "", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "canDebug", "", "showToast", "", "content", "tag", "webview-sdk_release"})
public final class h
{
  static final aw bBL()
  {
    AppMethodBeat.i(82933);
    aw localaw = aw.aKT("__webcompt_command");
    k.g(localaw, "MultiProcessMMKV.getMMKV(\"__webcompt_command\")");
    AppMethodBeat.o(82933);
    return localaw;
  }
  
  static final boolean eyK()
  {
    AppMethodBeat.i(82935);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || ((ac.getLogLevel() == 0) && (bt.eWo())))
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
    if (eyK()) {
      ap.f((Runnable)new a(paramString));
    }
    ac.i("WebComptCommand", paramString);
    AppMethodBeat.o(82934);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(82932);
      Toast.makeText(ai.getContext(), (CharSequence)this.gAl, 0).show();
      AppMethodBeat.o(82932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.h
 * JD-Core Version:    0.7.0.1
 */