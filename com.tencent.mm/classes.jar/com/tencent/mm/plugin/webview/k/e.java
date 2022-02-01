package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"toActivity", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/content/Context;", "webview-sdk_release"})
public final class e
{
  static final MMActivity jf(Context paramContext)
  {
    AppMethodBeat.i(206826);
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
        p.j(localContext, "baseContext.baseContext");
      }
    }
    Context localContext = paramContext;
    if (!(paramContext instanceof MMActivity)) {
      localContext = null;
    }
    paramContext = (MMActivity)localContext;
    AppMethodBeat.o(206826);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.e
 * JD-Core Version:    0.7.0.1
 */