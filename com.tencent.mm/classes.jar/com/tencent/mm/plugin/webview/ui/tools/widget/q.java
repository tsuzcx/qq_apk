package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"toActivity", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/content/Context;", "plugin-webview_release"})
public final class q
{
  static final MMActivity hh(Context paramContext)
  {
    AppMethodBeat.i(82757);
    if (!(paramContext instanceof MMActivity))
    {
      localContext = paramContext;
      for (;;)
      {
        paramContext = localContext;
        if ((localContext instanceof MMActivity)) {
          break;
        }
        paramContext = localContext;
        if (!(localContext instanceof ContextWrapper)) {
          break;
        }
        localContext = ((ContextWrapper)localContext).getBaseContext();
        p.g(localContext, "baseContext.baseContext");
      }
    }
    Context localContext = paramContext;
    if (!(paramContext instanceof MMActivity)) {
      localContext = null;
    }
    paramContext = (MMActivity)localContext;
    AppMethodBeat.o(82757);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.q
 * JD-Core Version:    0.7.0.1
 */