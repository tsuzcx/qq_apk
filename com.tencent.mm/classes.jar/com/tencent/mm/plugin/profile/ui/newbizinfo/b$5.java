package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.1;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.e.l;
import java.util.Map;

final class b$5
  implements MenuItem.OnMenuItemClickListener
{
  b$5(b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(153581);
    b localb = this.pDl;
    String str1 = localb.contact.field_username;
    Intent localIntent = aa.cZp();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 19);
    localIntent.putExtra("ftsType", 2);
    paramMenuItem = aa.d(19, true, 2);
    paramMenuItem.put("userName", str1);
    localIntent.putExtra("rawUrl", aa.F(paramMenuItem));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsbizusername", str1);
    localIntent.putExtra(e.l.yVx, 13307);
    String str2 = e.l.yVy;
    paramMenuItem = com.tencent.mm.plugin.profile.c.cbF().Xk(str1);
    if (paramMenuItem != null) {}
    for (paramMenuItem = paramMenuItem.field_decryptUserName;; paramMenuItem = "")
    {
      int i = s.getSessionId();
      ab.d("MicroMsg.Kv13307", "getArgs username:%s scene::%s optype:%d opscene:%d decryptUserName:%s", new Object[] { str1, Integer.valueOf(3), Integer.valueOf(1302), Integer.valueOf(4), paramMenuItem });
      localIntent.putStringArrayListExtra(str2, new c.1(str1, paramMenuItem, String.valueOf(i)));
      localIntent.addFlags(67108864);
      d.b(localb.pDe, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(str1, 1301);
      AppMethodBeat.o(153581);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.5
 * JD-Core Version:    0.7.0.1
 */