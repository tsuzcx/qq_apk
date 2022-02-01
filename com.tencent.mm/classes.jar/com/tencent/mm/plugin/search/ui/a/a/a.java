package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.j;

public final class a
  implements b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(28080);
    paramVarArgs = (j)paramVarArgs;
    ((n)g.ad(n.class)).updateTopHitsRank(paramVarArgs.sxM.syk, paramVarArgs.jPN, 0);
    if (((o)g.ab(o.class)).Oy(paramVarArgs.sEC.field_url))
    {
      AppMethodBeat.o(28080);
      return true;
    }
    Intent localIntent;
    if (paramVarArgs.sEC.field_actionType == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramVarArgs.sEC.field_url);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(28080);
      return true;
    }
    if (!com.tencent.mm.plugin.search.a.a.ae(paramContext, paramVarArgs.sEC.field_featureId))
    {
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramVarArgs.sEC.field_updateUrl);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(28080);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */