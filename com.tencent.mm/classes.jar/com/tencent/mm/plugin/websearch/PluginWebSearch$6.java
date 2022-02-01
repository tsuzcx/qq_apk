package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.a.wl;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.ar.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class PluginWebSearch$6
  implements t
{
  PluginWebSearch$6(PluginWebSearch paramPluginWebSearch)
  {
    AppMethodBeat.i(168798);
    AppMethodBeat.o(168798);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(116516);
    long l2;
    ar localar;
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 1)
      {
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        int j = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        parama = Util.safeFormatString((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        int k = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        int m = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        long l1 = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        int n = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        int i1 = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        String str1 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
        String str2 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
        l2 = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        localar = ar.iqh();
        paramString = null;
        switch (i)
        {
        default: 
          paramMap = paramString;
          if (paramString == null) {
            paramMap = new ar.a();
          }
          if (paramMap.timestamp < l2)
          {
            paramMap.id = parama;
            paramMap.WpP = k;
            paramMap.WpN = i;
            paramMap.WpO = m;
            paramMap.pwJ = l1;
            paramMap.WoG = n;
            paramMap.type = i1;
            paramMap.text = str1;
            paramMap.icon = str2;
            paramMap.timestamp = l2;
            paramMap.clear = j;
            paramMap.oDh = System.currentTimeMillis();
          }
          break;
        }
      }
    }
    for (;;)
    {
      localar.sz();
      new wl().publish();
      AppMethodBeat.o(116516);
      return;
      paramString = localar.WpK;
      break;
      Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramMap.timestamp) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.6
 * JD-Core Version:    0.7.0.1
 */