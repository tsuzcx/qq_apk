package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String eHB()
  {
    AppMethodBeat.i(30253);
    String str = ab.aAv("discoverSearchEntry").optString("labIcon");
    AppMethodBeat.o(30253);
    return str;
  }
  
  public final String eHC()
  {
    AppMethodBeat.i(30254);
    String str = ab.aAv("discoverSearchEntry").optString("wording");
    if (bs.isNullOrNil(str))
    {
      str = ai.getContext().getString(2131759102);
      AppMethodBeat.o(30254);
      return str;
    }
    AppMethodBeat.o(30254);
    return str;
  }
  
  public final void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30252);
    if (!z.Uk(0))
    {
      ac.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
      AppMethodBeat.o(30252);
      return;
    }
    paramString = z.exm();
    paramString.putExtra("ftsbizscene", 20);
    Map localMap = z.f(20, true, 0);
    paramString.putExtra("ftsneedkeyboard", true);
    paramString.putExtra("rawUrl", z.aV(localMap));
    d.b(paramActivity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", paramString);
    AppMethodBeat.o(30252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.b
 * JD-Core Version:    0.7.0.1
 */