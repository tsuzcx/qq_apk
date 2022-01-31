package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class NewBizConversationUI$1$1
  implements Runnable
{
  NewBizConversationUI$1$1(NewBizConversationUI.1 param1) {}
  
  public final void run()
  {
    Intent localIntent = aa.bZt();
    localIntent.putExtra("title", this.vTH.vTG.getString(R.l.fts_search_biz_article));
    localIntent.putExtra("searchbar_tips", this.vTH.vTG.getString(R.l.fts_search_biz_article));
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
      localObject = ActivityOptions.makeSceneTransitionAnimation(this.vTH.vTG, new Pair[0]).toBundle();
    }
    str = ac.Rw("bizAccountTopSearch");
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("key_search_input_hint", str);
    }
    d.a(this.vTH.vTG, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.1.1
 * JD-Core Version:    0.7.0.1
 */