package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.util.Map;

final class BizConversationUI$BizConversationFmUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BizConversationUI$BizConversationFmUI$1(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38235);
    if (com.tencent.mm.plugin.websearch.api.ad.Wd(0)) {
      ((i)g.ab(i.class)).a(aj.getContext(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38234);
          Intent localIntent = com.tencent.mm.plugin.websearch.api.ad.eMd();
          localIntent.putExtra("title", BizConversationUI.BizConversationFmUI.1.this.Ksc.getString(2131759718));
          localIntent.putExtra("searchbar_tips", BizConversationUI.BizConversationFmUI.1.this.Ksc.getString(2131759718));
          localIntent.putExtra("KRightBtn", true);
          localIntent.putExtra("ftsneedkeyboard", true);
          localIntent.putExtra("publishIdPrefix", "bs");
          localIntent.putExtra("ftsType", 2);
          localIntent.putExtra("ftsbizscene", 11);
          Object localObject = com.tencent.mm.plugin.websearch.api.ad.f(11, true, 2);
          String str = com.tencent.mm.plugin.websearch.api.ad.Wb(bt.aRe((String)((Map)localObject).get("scene")));
          ((Map)localObject).put("sessionId", str);
          localIntent.putExtra("sessionId", str);
          localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.ad.aY((Map)localObject));
          localIntent.putExtra("key_load_js_without_delay", true);
          localIntent.addFlags(67108864);
          str = null;
          localObject = str;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject = str;
            if (!al.isDarkMode()) {
              localObject = ActivityOptions.makeSceneTransitionAnimation(BizConversationUI.BizConversationFmUI.1.this.Ksc.thisActivity(), new Pair[0]).toBundle();
            }
          }
          d.a(BizConversationUI.BizConversationFmUI.1.this.Ksc.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
          AppMethodBeat.o(38234);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(38235);
      return true;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.1
 * JD-Core Version:    0.7.0.1
 */