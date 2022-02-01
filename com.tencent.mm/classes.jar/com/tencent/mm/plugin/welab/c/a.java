package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String eHB()
  {
    AppMethodBeat.i(30250);
    String str = ab.aAv("discoverRecommendEntry").optString("labIcon");
    AppMethodBeat.o(30250);
    return str;
  }
  
  public final String eHC()
  {
    AppMethodBeat.i(30251);
    String str = ab.aAv("discoverRecommendEntry").optString("wording");
    if (bs.isNullOrNil(str))
    {
      str = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759102);
      AppMethodBeat.o(30251);
      return str;
    }
    AppMethodBeat.o(30251);
    return str;
  }
  
  public final void i(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(30249);
    if (!z.Uk(0))
    {
      ac.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
      AppMethodBeat.o(30249);
      return;
    }
    paramString = ab.aAv("discoverRecommendEntry").optString("wording");
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
      AppMethodBeat.o(30249);
      return;
    }
    ((h)g.ab(h.class)).a(com.tencent.mm.sdk.platformtools.ai.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30248);
        Intent localIntent = z.exm();
        localIntent.putExtra("ftsbizscene", 21);
        localIntent.putExtra("ftsQuery", paramString);
        localIntent.putExtra("title", paramString);
        localIntent.putExtra("isWebwx", paramString);
        localIntent.putExtra("ftscaneditable", false);
        Object localObject = z.f(21, false, 2);
        ((Map)localObject).put("query", paramString);
        ((Map)localObject).put("sceneActionType", "2");
        localIntent.putExtra("rawUrl", z.f((Map)localObject, 1));
        localObject = new nl();
        ((nl)localObject).dpR.scene = 0;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        d.b(paramActivity, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        com.tencent.mm.plugin.websearch.api.ai.cq(21, paramString);
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