package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class FindMoreFriendsUI$2
  implements o
{
  FindMoreFriendsUI$2(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(29208);
    if ((bo.nullAsNil(paramString).equals("lifeappreddot")) && (paramMap != null))
    {
      boolean bool = "1".equals(paramMap.get(".sysmsg.lifeappreddot"));
      ab.i("MicroMsg.FindMoreFriendsUI", "life around xml msg content, showRedDot: %s.", new Object[] { Boolean.valueOf(bool) });
      g.RL().Ru().set(ac.a.yKQ, Boolean.valueOf(bool));
      if (bool)
      {
        paramString = (String)paramMap.get(".sysmsg.lifeappreddot.$type");
        parama = (String)paramMap.get(".sysmsg.lifeappreddot.$text");
        paramMap = (String)paramMap.get(".sysmsg.lifeappreddot.$imageurl");
        ab.d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, type: %s, text: %s, imgUrl: %s.", new Object[] { paramString, parama, paramMap });
        if (FindMoreFriendsUI.a(this.yWI, parama, paramMap))
        {
          g.RL().Ru().set(ac.a.yKS, paramString);
          g.RL().Ru().set(ac.a.yKT, parama);
          g.RL().Ru().set(ac.a.yKU, paramMap);
        }
        AppMethodBeat.o(29208);
        return;
      }
      FindMoreFriendsUI.a(this.yWI, FindMoreFriendsUI.a.yWW);
      g.RL().Ru().set(ac.a.yKS, "0");
      g.RL().Ru().set(ac.a.yKT, "");
      g.RL().Ru().set(ac.a.yKU, "");
    }
    AppMethodBeat.o(29208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.2
 * JD-Core Version:    0.7.0.1
 */