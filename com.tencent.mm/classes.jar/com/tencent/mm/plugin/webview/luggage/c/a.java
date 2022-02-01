package com.tencent.mm.plugin.webview.luggage.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.teenmode.a.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/util/GameTeenModeUtils;", "", "()V", "isTeenModeForbidGameDownload", "", "showTeenModeToast", "", "context", "Landroid/content/Context;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a WKe;
  
  static
  {
    AppMethodBeat.i(295969);
    WKe = new a();
    AppMethodBeat.o(295969);
  }
  
  public static final boolean iuX()
  {
    AppMethodBeat.i(295966);
    boolean bool = ((d)h.ax(d.class)).aBu();
    AppMethodBeat.o(295966);
    return bool;
  }
  
  public static final void kQ(Context paramContext)
  {
    AppMethodBeat.i(295967);
    if (paramContext != null) {
      ((d)h.ax(d.class)).kg(paramContext);
    }
    AppMethodBeat.o(295967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */