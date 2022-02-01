package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.Map;

final class AddMoreFriendsUI$1
  implements Runnable
{
  AddMoreFriendsUI$1(AddMoreFriendsUI paramAddMoreFriendsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29194);
    Intent localIntent = aj.ipS();
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsType", 1);
    localIntent.putExtra("ftsbizscene", 9);
    Object localObject = aj.r(9, true, 0);
    String str = aj.asV(Util.safeParseInt((String)((Map)localObject).get("scene")));
    ((Map)localObject).put("sessionId", str);
    ((Map)localObject).put("subSessionId", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localIntent.putExtra("rawUrl", aj.bo((Map)localObject));
    str = null;
    localObject = str;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = str;
      if (!aw.isDarkMode()) {
        localObject = ActivityOptions.makeSceneTransitionAnimation(this.SIv, new Pair[0]).toBundle();
      }
    }
    c.a(this.SIv, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
    AppMethodBeat.o(29194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.1
 * JD-Core Version:    0.7.0.1
 */