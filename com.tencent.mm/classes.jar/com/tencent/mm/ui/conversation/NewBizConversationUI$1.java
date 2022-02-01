package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.Map;

final class NewBizConversationUI$1
  implements MenuItem.OnMenuItemClickListener
{
  NewBizConversationUI$1(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38661);
    if (aj.asX(0)) {
      ((i)h.ax(i.class)).a(MMApplicationContext.getContext(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38660);
          Intent localIntent = aj.ipS();
          localIntent.putExtra("title", NewBizConversationUI.1.this.afrx.getString(R.l.fts_search_biz_article));
          localIntent.putExtra("searchbar_tips", NewBizConversationUI.1.this.afrx.getString(R.l.fts_search_biz_article));
          localIntent.putExtra("KRightBtn", true);
          localIntent.putExtra("ftsneedkeyboard", true);
          localIntent.putExtra("publishIdPrefix", "bs");
          localIntent.putExtra("ftsType", 2);
          localIntent.putExtra("ftsbizscene", 11);
          Object localObject = aj.r(11, true, 2);
          String str = aj.asV(Util.safeParseInt((String)((Map)localObject).get("scene")));
          ((Map)localObject).put("sessionId", str);
          localIntent.putExtra("sessionId", str);
          localIntent.putExtra("rawUrl", aj.bo((Map)localObject));
          localIntent.putExtra("key_load_js_without_delay", true);
          localIntent.addFlags(67108864);
          str = null;
          localObject = str;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject = str;
            if (!aw.isDarkMode()) {
              localObject = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.1.this.afrx, new Pair[0]).toBundle();
            }
          }
          str = al.biz("bizAccountTopSearch");
          if (!TextUtils.isEmpty(str)) {
            localIntent.putExtra("key_search_input_hint", str);
          }
          c.a(NewBizConversationUI.1.this.afrx, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
          AppMethodBeat.o(38660);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(38661);
      return true;
      Log.e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.1
 * JD-Core Version:    0.7.0.1
 */