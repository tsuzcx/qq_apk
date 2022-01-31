package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.b
{
  public final String chj()
  {
    return ac.Ru("discoverSearchEntry").optString("labIcon");
  }
  
  public final String chk()
  {
    String str2 = ac.Ru("discoverSearchEntry").optString("wording");
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = ae.getContext().getString(R.l.find_friends_look);
    }
    return str1;
  }
  
  public final void f(Activity paramActivity, String paramString)
  {
    if (!aa.Br(0))
    {
      y.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
      return;
    }
    paramString = aa.bZt();
    paramString.putExtra("ftsbizscene", 20);
    Map localMap = aa.b(20, true, 0);
    paramString.putExtra("ftsneedkeyboard", true);
    paramString.putExtra("rawUrl", aa.v(localMap));
    d.b(paramActivity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b.b
 * JD-Core Version:    0.7.0.1
 */