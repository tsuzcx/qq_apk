package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String esh()
  {
    AppMethodBeat.i(30253);
    String str = ac.ave("discoverSearchEntry").optString("labIcon");
    AppMethodBeat.o(30253);
    return str;
  }
  
  public final String esi()
  {
    AppMethodBeat.i(30254);
    String str = ac.ave("discoverSearchEntry").optString("wording");
    if (bt.isNullOrNil(str))
    {
      str = aj.getContext().getString(2131759102);
      AppMethodBeat.o(30254);
      return str;
    }
    AppMethodBeat.o(30254);
    return str;
  }
  
  public final void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30252);
    if (!aa.Sa(0))
    {
      ad.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
      AppMethodBeat.o(30252);
      return;
    }
    paramString = aa.ehS();
    paramString.putExtra("ftsbizscene", 20);
    Map localMap = aa.f(20, true, 0);
    paramString.putExtra("ftsneedkeyboard", true);
    paramString.putExtra("rawUrl", aa.aR(localMap));
    d.b(paramActivity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", paramString);
    AppMethodBeat.o(30252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.b
 * JD-Core Version:    0.7.0.1
 */