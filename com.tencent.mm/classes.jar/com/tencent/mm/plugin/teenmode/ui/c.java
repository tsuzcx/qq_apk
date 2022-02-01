package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.a.a;
import com.tencent.mm.plugin.teenmode.a.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/BizOutLinkAuthorizationFiller;", "Lcom/tencent/mm/plugin/teenmode/ui/BizAuthorizationFiller;", "()V", "getBizTypeDesc", "", "context", "Landroid/content/Context;", "onFill", "", "state", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$State;", "holder", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$Holder;", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  public final void a(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(279010);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null)
    {
      AppMethodBeat.o(279010);
      return;
    }
    paramContext = parama.SYp;
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getContext())
    {
      Context localContext = paramContext;
      if (paramContext == null) {
        localContext = MMApplicationContext.getContext();
      }
      s.s(localContext, "context");
      b(localContext, paramb, parama);
      a(localContext, paramb, parama, false);
      AppMethodBeat.o(279010);
      return;
    }
  }
  
  public final String gV(Context paramContext)
  {
    AppMethodBeat.i(279000);
    s.u(paramContext, "context");
    paramContext = paramContext.getString(a.g.webview_teen_mode_out_link_desc);
    s.s(paramContext, "context.getString(R.stri…_teen_mode_out_link_desc)");
    AppMethodBeat.o(279000);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.c
 * JD-Core Version:    0.7.0.1
 */