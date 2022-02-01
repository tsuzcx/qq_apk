package com.tencent.mm.plugin.setting;

import android.content.Intent;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.br.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class d$3
  implements t
{
  d$3(d paramd) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(73748);
    if (paramMap != null)
    {
      if (!ab.bBX())
      {
        Log.i("MicroMsg.SubCoreSetting", "mWeChatServiceChooseListener, isWeChatUser = no.");
        AppMethodBeat.o(73748);
        return;
      }
      paramString = (String)paramMap.get(".sysmsg.showWCOpenService.deviceid");
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.SubCoreSetting", "mWeChatServiceChooseListener, deviceIdStr = null.");
        AppMethodBeat.o(73748);
        return;
      }
      paramString = new String(Base64.decode(paramString.getBytes(), 0));
      paramMap = new String(b.cX(q.aPg().getBytes()).axn(16).Op);
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals(paramMap)))
      {
        paramString = new Intent();
        c.b(MMApplicationContext.getContext(), "setting", ".ui.setting.SettingsManageFindOtherServiceUI", paramString);
        AppMethodBeat.o(73748);
        return;
      }
      Log.i("MicroMsg.SubCoreSetting", "mWeChatServiceChooseListener, decodeDeviceId = " + paramString + ", localDeviceId = " + paramMap);
    }
    AppMethodBeat.o(73748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d.3
 * JD-Core Version:    0.7.0.1
 */