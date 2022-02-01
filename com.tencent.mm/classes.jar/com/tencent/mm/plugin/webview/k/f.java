package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"toActivity", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/content/Context;", "webview-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  static final MMActivity lf(Context paramContext)
  {
    AppMethodBeat.i(295705);
    if (!(paramContext instanceof MMActivity)) {
      for (;;)
      {
        localContext = paramContext;
        if ((paramContext instanceof MMActivity)) {
          break;
        }
        localContext = paramContext;
        if (!(paramContext instanceof ContextWrapper)) {
          break;
        }
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
        s.s(paramContext, "baseContext.baseContext");
      }
    }
    Context localContext = paramContext;
    if ((localContext instanceof MMActivity))
    {
      paramContext = (MMActivity)localContext;
      AppMethodBeat.o(295705);
      return paramContext;
    }
    AppMethodBeat.o(295705);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.f
 * JD-Core Version:    0.7.0.1
 */