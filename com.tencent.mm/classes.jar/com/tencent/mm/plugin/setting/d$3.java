package com.tencent.mm.plugin.setting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e.m;
import java.util.Map;

final class d$3
  implements q
{
  d$3(d paramd) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(73748);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.showtrustedfriends.wording");
      if (!Util.isNullOrNil(paramString))
      {
        paramMap = new Intent();
        paramMap.putExtra(e.m.Ozm, paramString);
        c.b(MMApplicationContext.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", paramMap);
      }
    }
    AppMethodBeat.o(73748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d.3
 * JD-Core Version:    0.7.0.1
 */