package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String esh()
  {
    AppMethodBeat.i(30250);
    String str = ac.ave("discoverRecommendEntry").optString("labIcon");
    AppMethodBeat.o(30250);
    return str;
  }
  
  public final String esi()
  {
    AppMethodBeat.i(30251);
    String str = ac.ave("discoverRecommendEntry").optString("wording");
    if (bt.isNullOrNil(str))
    {
      str = aj.getContext().getString(2131759102);
      AppMethodBeat.o(30251);
      return str;
    }
    AppMethodBeat.o(30251);
    return str;
  }
  
  public final void i(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(30249);
    if (!aa.Sa(0))
    {
      ad.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
      AppMethodBeat.o(30249);
      return;
    }
    paramString = ac.ave("discoverRecommendEntry").optString("wording");
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
      AppMethodBeat.o(30249);
      return;
    }
    ((i)g.ab(i.class)).a(aj.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30248);
        Intent localIntent = aa.ehS();
        localIntent.putExtra("ftsbizscene", 21);
        localIntent.putExtra("ftsQuery", paramString);
        localIntent.putExtra("title", paramString);
        localIntent.putExtra("isWebwx", paramString);
        localIntent.putExtra("ftscaneditable", false);
        Object localObject = aa.f(21, false, 2);
        ((Map)localObject).put("query", paramString);
        ((Map)localObject).put("sceneActionType", "2");
        localIntent.putExtra("rawUrl", aa.f((Map)localObject, 1));
        localObject = new nc();
        ((nc)localObject).dsg.scene = 0;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        d.b(paramActivity, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        ak.cn(21, paramString);
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