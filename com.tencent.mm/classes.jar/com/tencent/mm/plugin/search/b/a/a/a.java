package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.j;

public final class a
  implements b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(24405);
    paramVarArgs = (j)paramVarArgs;
    ((n)com.tencent.mm.kernel.g.G(n.class)).updateTopHitsRank(paramVarArgs.mRX.mSw, paramVarArgs.hrL, 0);
    if (((k)com.tencent.mm.kernel.g.E(k.class)).Dp(paramVarArgs.mZm.field_url))
    {
      AppMethodBeat.o(24405);
      return true;
    }
    Intent localIntent;
    if (paramVarArgs.mZm.field_actionType == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramVarArgs.mZm.field_url);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(24405);
      return true;
    }
    if (!com.tencent.mm.plugin.search.a.a.W(paramContext, paramVarArgs.mZm.field_featureId))
    {
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramVarArgs.mZm.field_updateUrl);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(24405);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.search.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */