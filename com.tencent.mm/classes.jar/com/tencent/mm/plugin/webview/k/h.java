package com.tencent.mm.plugin.webview.k;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"TAG", "", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "canDebug", "", "showToast", "", "content", "tag", "webview-sdk_release"})
public final class h
{
  static final ay bGK()
  {
    AppMethodBeat.i(82933);
    ay localay = ay.aRW("__webcompt_command");
    p.g(localay, "MultiProcessMMKV.getMMKV(\"__webcompt_command\")");
    AppMethodBeat.o(82933);
    return localay;
  }
  
  static final boolean eRk()
  {
    AppMethodBeat.i(82935);
    if ((j.IS_FLAVOR_RED) || (j.DEBUG) || ((ae.getLogLevel() == 0) && (bv.fpT())))
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
    if (eRk()) {
      ar.f((Runnable)new a(paramString));
    }
    ae.i("WebComptCommand", paramString);
    AppMethodBeat.o(82934);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(82932);
      Toast.makeText(ak.getContext(), (CharSequence)this.fMx, 0).show();
      AppMethodBeat.o(82932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.h
 * JD-Core Version:    0.7.0.1
 */