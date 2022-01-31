package com.tencent.mm.plugin.setting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.i;
import java.util.Map;

final class c$3
  implements o
{
  c$3(c paramc) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(126827);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.showtrustedfriends.wording");
      if (!bo.isNullOrNil(paramString))
      {
        paramMap = new Intent();
        paramMap.putExtra(e.i.yVh, paramString);
        d.b(ah.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", paramMap);
      }
    }
    AppMethodBeat.o(126827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.3
 * JD-Core Version:    0.7.0.1
 */