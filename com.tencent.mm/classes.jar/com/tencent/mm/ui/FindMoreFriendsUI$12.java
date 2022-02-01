package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;

final class FindMoreFriendsUI$12
  implements t
{
  FindMoreFriendsUI$12(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(249117);
    if ((Util.nullAsNil(paramString).equals("lifeappreddot")) && (paramMap != null))
    {
      boolean bool = "1".equals(paramMap.get(".sysmsg.lifeappreddot"));
      Log.i("MicroMsg.FindMoreFriendsUI", "life around xml msg content, showRedDot: %s.", new Object[] { Boolean.valueOf(bool) });
      h.baE().ban().set(at.a.acXx, Boolean.valueOf(bool));
      if (bool)
      {
        paramString = (String)paramMap.get(".sysmsg.lifeappreddot.$type");
        parama = (String)paramMap.get(".sysmsg.lifeappreddot.$text");
        paramMap = (String)paramMap.get(".sysmsg.lifeappreddot.$imageurl");
        Log.d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, type: %s, text: %s, imgUrl: %s.", new Object[] { paramString, parama, paramMap });
        if (FindMoreFriendsUI.a(this.adyF, parama, paramMap))
        {
          h.baE().ban().set(at.a.acXz, paramString);
          h.baE().ban().set(at.a.acXA, parama);
          h.baE().ban().set(at.a.acXB, paramMap);
        }
        AppMethodBeat.o(249117);
        return;
      }
      FindMoreFriendsUI.a(this.adyF, FindMoreFriendsUI.a.adyV);
      h.baE().ban().set(at.a.acXz, "0");
      h.baE().ban().set(at.a.acXA, "");
      h.baE().ban().set(at.a.acXB, "");
    }
    AppMethodBeat.o(249117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.12
 * JD-Core Version:    0.7.0.1
 */