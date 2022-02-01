package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String iDG()
  {
    AppMethodBeat.i(30253);
    String str = al.bix("discoverSearchEntry").optString("labIcon");
    AppMethodBeat.o(30253);
    return str;
  }
  
  public final String iDH()
  {
    AppMethodBeat.i(30254);
    String str = al.bix("discoverSearchEntry").optString("wording");
    if (Util.isNullOrNil(str))
    {
      str = MMApplicationContext.getContext().getString(R.l.find_friends_look);
      AppMethodBeat.o(30254);
      return str;
    }
    AppMethodBeat.o(30254);
    return str;
  }
  
  public final void p(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30252);
    if (!aj.asX(0))
    {
      Log.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
      AppMethodBeat.o(30252);
      return;
    }
    paramString = aj.ipS();
    paramString.putExtra("ftsbizscene", 20);
    Map localMap = aj.r(20, true, 0);
    paramString.putExtra("ftsneedkeyboard", true);
    paramString.putExtra("rawUrl", aj.bo(localMap));
    c.b(paramActivity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", paramString);
    AppMethodBeat.o(30252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.b
 * JD-Core Version:    0.7.0.1
 */