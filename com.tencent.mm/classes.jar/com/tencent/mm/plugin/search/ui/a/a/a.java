package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;

public final class a
  implements b
{
  private static boolean aVr(String paramString)
  {
    AppMethodBeat.i(262359);
    Object localObject = null;
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(262359);
        return false;
      }
      paramString = paramString.getQueryParameter("username");
      if ((Util.isNullOrNil(paramString)) || (!au.Hh(paramString)))
      {
        AppMethodBeat.o(262359);
        return false;
      }
      boolean bool = "gh_e9a0a3cb9d1e@app".equals(paramString);
      AppMethodBeat.o(262359);
      return bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(262363);
    paramVarArgs = (com.tencent.mm.plugin.fts.ui.b.j)paramVarArgs;
    ((n)h.az(n.class)).updateTopHitsRank(paramVarArgs.FWt.Hte, paramVarArgs.rpp, 0);
    if (aVr(paramVarArgs.HAY.field_url))
    {
      if (((d)h.ax(d.class)).aBu())
      {
        ((d)h.ax(d.class)).kg(paramContext);
        AppMethodBeat.o(262363);
        return true;
      }
      if (!WeChatBrands.Business.Entries.DiscoveryGame.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(262363);
        return true;
      }
    }
    if (((u)h.ax(u.class)).s(paramVarArgs.HAY.field_url, null))
    {
      AppMethodBeat.o(262363);
      return true;
    }
    if (paramVarArgs.HAY.field_actionType == 2)
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramVarArgs.HAY.field_url);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(262363);
      return true;
    }
    if (!com.tencent.mm.plugin.search.a.a.aS(paramContext, paramVarArgs.HAY.field_featureId))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramVarArgs.HAY.field_updateUrl);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(262363);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */