package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.j;

public final class a
  implements b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    paramVarArgs = (j)paramVarArgs;
    ((n)com.tencent.mm.kernel.g.t(n.class)).updateTopHitsRank(paramVarArgs.kwi.kwG, paramVarArgs.fYx, 0);
    if (((e)com.tencent.mm.kernel.g.r(e.class)).uW(paramVarArgs.kDq.field_url)) {}
    do
    {
      return true;
      if (paramVarArgs.kDq.field_actionType == 2)
      {
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramVarArgs.kDq.field_url);
        d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
        return true;
      }
    } while (com.tencent.mm.plugin.search.a.a.J(paramContext, paramVarArgs.kDq.field_featureId));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramVarArgs.kDq.field_updateUrl);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.search.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */