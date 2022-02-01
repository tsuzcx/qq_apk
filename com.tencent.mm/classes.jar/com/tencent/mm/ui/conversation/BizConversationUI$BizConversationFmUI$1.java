package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.Map;

final class BizConversationUI$BizConversationFmUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BizConversationUI$BizConversationFmUI$1(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38235);
    if (ai.afs(0)) {
      ((i)g.af(i.class)).a(MMApplicationContext.getContext(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38234);
          Intent localIntent = ai.fXX();
          localIntent.putExtra("title", BizConversationUI.BizConversationFmUI.1.this.Qbw.getString(2131761039));
          localIntent.putExtra("searchbar_tips", BizConversationUI.BizConversationFmUI.1.this.Qbw.getString(2131761039));
          localIntent.putExtra("KRightBtn", true);
          localIntent.putExtra("ftsneedkeyboard", true);
          localIntent.putExtra("publishIdPrefix", "bs");
          localIntent.putExtra("ftsType", 2);
          localIntent.putExtra("ftsbizscene", 11);
          Object localObject = ai.h(11, true, 2);
          String str = ai.afq(Util.safeParseInt((String)((Map)localObject).get("scene")));
          ((Map)localObject).put("sessionId", str);
          localIntent.putExtra("sessionId", str);
          localIntent.putExtra("rawUrl", ai.bd((Map)localObject));
          localIntent.putExtra("key_load_js_without_delay", true);
          localIntent.addFlags(67108864);
          str = null;
          localObject = str;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject = str;
            if (!ao.isDarkMode()) {
              localObject = ActivityOptions.makeSceneTransitionAnimation(BizConversationUI.BizConversationFmUI.1.this.Qbw.thisActivity(), new Pair[0]).toBundle();
            }
          }
          c.a(BizConversationUI.BizConversationFmUI.1.this.Qbw.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
          AppMethodBeat.o(38234);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(38235);
      return true;
      Log.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.1
 * JD-Core Version:    0.7.0.1
 */