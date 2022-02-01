package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;

public final class a
  implements b
{
  private static boolean aXI(String paramString)
  {
    AppMethodBeat.i(272600);
    Object localObject = null;
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(272600);
        return false;
      }
      paramString = paramString.getQueryParameter("username");
      if ((Util.isNullOrNil(paramString)) || (!as.OS(paramString)))
      {
        AppMethodBeat.o(272600);
        return false;
      }
      boolean bool = "gh_e9a0a3cb9d1e@app".equals(paramString);
      AppMethodBeat.o(272600);
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
    AppMethodBeat.i(272599);
    paramVarArgs = (j)paramVarArgs;
    ((n)com.tencent.mm.kernel.h.ag(n.class)).updateTopHitsRank(paramVarArgs.BHY.BIw, paramVarArgs.olG, 0);
    if ((aXI(paramVarArgs.BPj.field_url)) && (!WeChatBrands.Business.Entries.DiscoveryGame.checkAvailable(paramView.getContext())))
    {
      AppMethodBeat.o(272599);
      return true;
    }
    if (((s)com.tencent.mm.kernel.h.ae(s.class)).s(paramVarArgs.BPj.field_url, null))
    {
      AppMethodBeat.o(272599);
      return true;
    }
    if (paramVarArgs.BPj.field_actionType == 2)
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramVarArgs.BPj.field_url);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(272599);
      return true;
    }
    if (!com.tencent.mm.plugin.search.a.a.aF(paramContext, paramVarArgs.BPj.field_featureId))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramVarArgs.BPj.field_updateUrl);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(272599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */