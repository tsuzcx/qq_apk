package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class BizConversationUI$a$1$1
  implements Runnable
{
  BizConversationUI$a$1$1(BizConversationUI.a.1 param1) {}
  
  public final void run()
  {
    Intent localIntent = aa.bZt();
    localIntent.putExtra("title", this.vPv.vPu.getString(R.l.fts_search_biz_article));
    localIntent.putExtra("searchbar_tips", this.vPv.vPu.getString(R.l.fts_search_biz_article));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("publishIdPrefix", "bs");
    localIntent.putExtra("ftsType", 2);
    localIntent.putExtra("ftsbizscene", 11);
    Object localObject = aa.b(11, true, 2);
    String str = aa.Bm(bk.ZR((String)((Map)localObject).get("scene")));
    ((Map)localObject).put("sessionId", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("rawUrl", aa.v((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localObject = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = ActivityOptions.makeSceneTransitionAnimation(this.vPv.vPu.thisActivity(), new Pair[0]).toBundle();
    }
    d.a(this.vPv.vPu.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */