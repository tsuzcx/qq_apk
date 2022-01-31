package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class AddMoreFriendsUI$1
  implements Runnable
{
  AddMoreFriendsUI$1(AddMoreFriendsUI paramAddMoreFriendsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(25504);
    Intent localIntent = aa.cZp();
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsType", 1);
    localIntent.putExtra("ftsbizscene", 9);
    Object localObject = aa.d(9, true, 0);
    String str = aa.IZ(bo.apV((String)((Map)localObject).get("scene")));
    ((Map)localObject).put("sessionId", str);
    ((Map)localObject).put("subSessionId", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localIntent.putExtra("rawUrl", aa.F((Map)localObject));
    localObject = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = ActivityOptions.makeSceneTransitionAnimation(this.sZu, new Pair[0]).toBundle();
    }
    d.a(this.sZu, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
    AppMethodBeat.o(25504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.1
 * JD-Core Version:    0.7.0.1
 */