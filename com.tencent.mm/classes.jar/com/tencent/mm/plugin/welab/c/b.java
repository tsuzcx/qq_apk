package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String dhr()
  {
    AppMethodBeat.i(26580);
    String str = ac.agv("discoverSearchEntry").optString("labIcon");
    AppMethodBeat.o(26580);
    return str;
  }
  
  public final String dhs()
  {
    AppMethodBeat.i(26581);
    String str = ac.agv("discoverSearchEntry").optString("wording");
    if (bo.isNullOrNil(str))
    {
      str = ah.getContext().getString(2131299915);
      AppMethodBeat.o(26581);
      return str;
    }
    AppMethodBeat.o(26581);
    return str;
  }
  
  public final void h(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(26579);
    if (!aa.Je(0))
    {
      ab.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
      AppMethodBeat.o(26579);
      return;
    }
    paramString = aa.cZp();
    paramString.putExtra("ftsbizscene", 20);
    Map localMap = aa.d(20, true, 0);
    paramString.putExtra("ftsneedkeyboard", true);
    paramString.putExtra("rawUrl", aa.F(localMap));
    d.b(paramActivity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", paramString);
    AppMethodBeat.o(26579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.b
 * JD-Core Version:    0.7.0.1
 */