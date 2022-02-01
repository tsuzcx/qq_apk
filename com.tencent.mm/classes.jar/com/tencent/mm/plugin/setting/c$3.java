package com.tencent.mm.plugin.setting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.k;
import java.util.Map;

final class c$3
  implements q
{
  c$3(c paramc) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(73748);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.showtrustedfriends.wording");
      if (!bt.isNullOrNil(paramString))
      {
        paramMap = new Intent();
        paramMap.putExtra(e.k.IUF, paramString);
        d.b(aj.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", paramMap);
      }
    }
    AppMethodBeat.o(73748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.3
 * JD-Core Version:    0.7.0.1
 */