package com.tencent.mm.plugin.setting;

import android.content.Intent;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.e.g;
import java.util.Map;

final class c$3
  implements o
{
  c$3(c paramc) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.showtrustedfriends.wording");
      if (!bk.bl(paramString))
      {
        paramMap = new Intent();
        paramMap.putExtra(e.g.uHU, paramString);
        d.b(ae.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.3
 * JD-Core Version:    0.7.0.1
 */