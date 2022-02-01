package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.qw;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements b
{
  public final String iDG()
  {
    AppMethodBeat.i(30250);
    String str = al.bix("discoverRecommendEntry").optString("labIcon");
    AppMethodBeat.o(30250);
    return str;
  }
  
  public final String iDH()
  {
    AppMethodBeat.i(30251);
    String str = al.bix("discoverRecommendEntry").optString("wording");
    if (Util.isNullOrNil(str))
    {
      str = MMApplicationContext.getContext().getString(R.l.find_friends_look);
      AppMethodBeat.o(30251);
      return str;
    }
    AppMethodBeat.o(30251);
    return str;
  }
  
  public final void p(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(30249);
    if (!aj.asX(0))
    {
      Log.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
      AppMethodBeat.o(30249);
      return;
    }
    paramString = al.bix("discoverRecommendEntry").optString("wording");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
      AppMethodBeat.o(30249);
      return;
    }
    ((i)h.ax(i.class)).a(MMApplicationContext.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30248);
        Intent localIntent = aj.ipS();
        localIntent.putExtra("ftsbizscene", 21);
        localIntent.putExtra("ftsQuery", paramString);
        localIntent.putExtra("title", paramString);
        localIntent.putExtra("isWebwx", paramString);
        localIntent.putExtra("ftscaneditable", false);
        Object localObject = aj.r(21, false, 2);
        ((Map)localObject).put("query", paramString);
        ((Map)localObject).put("sceneActionType", "2");
        localIntent.putExtra("rawUrl", aj.h((Map)localObject, 1));
        localObject = new qw();
        ((qw)localObject).hTT.scene = 0;
        ((qw)localObject).publish();
        c.b(paramActivity, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        as.dE(21, paramString);
        AppMethodBeat.o(30248);
      }
    });
    AppMethodBeat.o(30249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.a
 * JD-Core Version:    0.7.0.1
 */