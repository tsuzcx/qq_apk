package com.tencent.mm.plugin.setting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.p;
import java.util.Map;

final class d$4
  implements t
{
  d$4(d paramd) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(298489);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.showtrustedfriends.wording");
      if (!Util.isNullOrNil(paramString))
      {
        paramMap = new Intent();
        paramMap.putExtra(f.p.adwJ, paramString);
        c.b(MMApplicationContext.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", paramMap);
      }
    }
    AppMethodBeat.o(298489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d.4
 * JD-Core Version:    0.7.0.1
 */