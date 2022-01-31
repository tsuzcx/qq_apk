package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class NewBizConversationUI$1$1
  implements Runnable
{
  NewBizConversationUI$1$1(NewBizConversationUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(34531);
    Intent localIntent = aa.cZp();
    localIntent.putExtra("title", this.AlD.AlC.getString(2131300238));
    localIntent.putExtra("searchbar_tips", this.AlD.AlC.getString(2131300238));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("publishIdPrefix", "bs");
    localIntent.putExtra("ftsType", 2);
    localIntent.putExtra("ftsbizscene", 11);
    Object localObject = aa.d(11, true, 2);
    String str = aa.IZ(bo.apV((String)((Map)localObject).get("scene")));
    ((Map)localObject).put("sessionId", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("rawUrl", aa.F((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localObject = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = ActivityOptions.makeSceneTransitionAnimation(this.AlD.AlC, new Pair[0]).toBundle();
    }
    str = ac.agx("bizAccountTopSearch");
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("key_search_input_hint", str);
    }
    d.a(this.AlD.AlC, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
    AppMethodBeat.o(34531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.1.1
 * JD-Core Version:    0.7.0.1
 */