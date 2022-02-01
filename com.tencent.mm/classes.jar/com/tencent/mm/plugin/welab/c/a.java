package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.om;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements b
{
  public final String gjl()
  {
    AppMethodBeat.i(30250);
    String str = ak.aXe("discoverRecommendEntry").optString("labIcon");
    AppMethodBeat.o(30250);
    return str;
  }
  
  public final String gjm()
  {
    AppMethodBeat.i(30251);
    String str = ak.aXe("discoverRecommendEntry").optString("wording");
    if (Util.isNullOrNil(str))
    {
      str = MMApplicationContext.getContext().getString(2131759435);
      AppMethodBeat.o(30251);
      return str;
    }
    AppMethodBeat.o(30251);
    return str;
  }
  
  public final void m(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(30249);
    if (!ai.afs(0))
    {
      Log.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
      AppMethodBeat.o(30249);
      return;
    }
    paramString = ak.aXe("discoverRecommendEntry").optString("wording");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
      AppMethodBeat.o(30249);
      return;
    }
    ((i)g.af(i.class)).a(MMApplicationContext.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30248);
        Intent localIntent = ai.fXX();
        localIntent.putExtra("ftsbizscene", 21);
        localIntent.putExtra("ftsQuery", paramString);
        localIntent.putExtra("title", paramString);
        localIntent.putExtra("isWebwx", paramString);
        localIntent.putExtra("ftscaneditable", false);
        Object localObject = ai.h(21, false, 2);
        ((Map)localObject).put("query", paramString);
        ((Map)localObject).put("sceneActionType", "2");
        localIntent.putExtra("rawUrl", ai.g((Map)localObject, 1));
        localObject = new om();
        ((om)localObject).dUz.scene = 0;
        EventCenter.instance.publish((IEvent)localObject);
        c.b(paramActivity, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        ar.cO(21, paramString);
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