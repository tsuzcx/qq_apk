package com.tencent.mm.plugin.webview.luggage.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.teenmode.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/util/GameTeenModeUtils;", "", "()V", "isTeenModeForbidGameDownload", "", "showTeenModeToast", "", "context", "Landroid/content/Context;", "plugin-webview_release"})
public final class a
{
  public static final a PTs;
  
  static
  {
    AppMethodBeat.i(216412);
    PTs = new a();
    AppMethodBeat.o(216412);
  }
  
  public static final boolean gVm()
  {
    AppMethodBeat.i(216409);
    com.tencent.mm.kernel.c.a locala = h.ae(b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((b)locala).ZM();
    AppMethodBeat.o(216409);
    return bool;
  }
  
  public static final void ja(Context paramContext)
  {
    AppMethodBeat.i(216410);
    if (paramContext != null) {
      ((b)h.ae(b.class)).ir(paramContext);
    }
    AppMethodBeat.o(216410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */