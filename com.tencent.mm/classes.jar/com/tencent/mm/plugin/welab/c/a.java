package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String fag()
  {
    AppMethodBeat.i(30250);
    String str = af.aHj("discoverRecommendEntry").optString("labIcon");
    AppMethodBeat.o(30250);
    return str;
  }
  
  public final String fah()
  {
    AppMethodBeat.i(30251);
    String str = af.aHj("discoverRecommendEntry").optString("wording");
    if (bu.isNullOrNil(str))
    {
      str = ak.getContext().getString(2131759102);
      AppMethodBeat.o(30251);
      return str;
    }
    AppMethodBeat.o(30251);
    return str;
  }
  
  public final void i(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(30249);
    if (!ad.WK(0))
    {
      ae.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
      AppMethodBeat.o(30249);
      return;
    }
    paramString = af.aHj("discoverRecommendEntry").optString("wording");
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
      AppMethodBeat.o(30249);
      return;
    }
    ((i)g.ab(i.class)).a(ak.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30248);
        Intent localIntent = ad.ePM();
        localIntent.putExtra("ftsbizscene", 21);
        localIntent.putExtra("ftsQuery", paramString);
        localIntent.putExtra("title", paramString);
        localIntent.putExtra("isWebwx", paramString);
        localIntent.putExtra("ftscaneditable", false);
        Object localObject = ad.f(21, false, 2);
        ((Map)localObject).put("query", paramString);
        ((Map)localObject).put("sceneActionType", "2");
        localIntent.putExtra("rawUrl", ad.e((Map)localObject, 1));
        localObject = new nu();
        ((nu)localObject).dCJ.scene = 0;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        d.b(paramActivity, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        am.cw(21, paramString);
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