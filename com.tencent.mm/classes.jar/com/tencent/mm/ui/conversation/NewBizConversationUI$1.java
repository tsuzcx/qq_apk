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
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.Map;

final class NewBizConversationUI$1
  implements MenuItem.OnMenuItemClickListener
{
  NewBizConversationUI$1(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38661);
    if (ai.ang(0)) {
      ((i)h.ae(i.class)).a(MMApplicationContext.getContext(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38660);
          Intent localIntent = ai.gQI();
          localIntent.putExtra("title", NewBizConversationUI.1.this.XDT.getString(R.l.fts_search_biz_article));
          localIntent.putExtra("searchbar_tips", NewBizConversationUI.1.this.XDT.getString(R.l.fts_search_biz_article));
          localIntent.putExtra("KRightBtn", true);
          localIntent.putExtra("ftsneedkeyboard", true);
          localIntent.putExtra("publishIdPrefix", "bs");
          localIntent.putExtra("ftsType", 2);
          localIntent.putExtra("ftsbizscene", 11);
          Object localObject = ai.j(11, true, 2);
          String str = ai.ane(Util.safeParseInt((String)((Map)localObject).get("scene")));
          ((Map)localObject).put("sessionId", str);
          localIntent.putExtra("sessionId", str);
          localIntent.putExtra("rawUrl", ai.aX((Map)localObject));
          localIntent.putExtra("key_load_js_without_delay", true);
          localIntent.addFlags(67108864);
          str = null;
          localObject = str;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject = str;
            if (!ar.isDarkMode()) {
              localObject = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.1.this.XDT, new Pair[0]).toBundle();
            }
          }
          str = ak.biR("bizAccountTopSearch");
          if (!TextUtils.isEmpty(str)) {
            localIntent.putExtra("key_search_input_hint", str);
          }
          c.a(NewBizConversationUI.1.this.XDT, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
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