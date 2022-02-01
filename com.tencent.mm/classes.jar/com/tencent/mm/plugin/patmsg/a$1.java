package com.tencent.mm.plugin.patmsg;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class a$1
  implements q
{
  a$1(a parama) {}
  
  public final void onNewXmlReceived(String paramString, final Map<String, String> paramMap, final h.a parama)
  {
    AppMethodBeat.i(206912);
    if ("pat".equals(paramString)) {
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206911);
          String str1 = (String)paramMap.get(".sysmsg.pat.fromusername");
          String str2 = (String)paramMap.get(".sysmsg.pat.chatusername");
          String str3 = (String)paramMap.get(".sysmsg.pat.pattedusername");
          String str4 = (String)paramMap.get(".sysmsg.pat.template");
          Log.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", new Object[] { str1, str2, str3, str4 });
          if (!((PluginPatMsg)g.ah(PluginPatMsg.class)).isPatEnable())
          {
            AppMethodBeat.o(206911);
            return;
          }
          if (((l)g.af(l.class)).eiy().Hd(parama.heO.Brn))
          {
            Log.w("MicroMsg.PatMsgExtension", "ignore insert, msg %d should be deleted!", new Object[] { Long.valueOf(parama.heO.Brn) });
            AppMethodBeat.o(206911);
            return;
          }
          a.b(str2, str1, str3, str4, parama.heO.CreateTime, parama.heO.Brn);
          AppMethodBeat.o(206911);
        }
      }, "HandlePatMsg");
    }
    AppMethodBeat.o(206912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.1
 * JD-Core Version:    0.7.0.1
 */