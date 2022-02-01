package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.aj.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class PluginWebSearch$7
  implements p
{
  PluginWebSearch$7(PluginWebSearch paramPluginWebSearch) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(168801);
    long l2;
    aj localaj;
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = bt.aGh((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 1)
      {
        ad.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        int j = bt.aGh((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        parama = bt.u((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        int k = bt.aGh((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        int m = bt.aGh((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        long l1 = bt.aGi((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        int n = bt.aGh((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        int i1 = bt.aGh((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        String str1 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
        String str2 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
        l2 = bt.aGi((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        localaj = aj.eid();
        paramString = null;
        switch (i)
        {
        default: 
          paramMap = paramString;
          if (paramString == null) {
            paramMap = new aj.a();
          }
          if (paramMap.timestamp < l2)
          {
            paramMap.id = parama;
            paramMap.AHk = k;
            paramMap.AHi = i;
            paramMap.AHj = m;
            paramMap.hPv = l1;
            paramMap.AGn = n;
            paramMap.type = i1;
            paramMap.text = str1;
            paramMap.dub = str2;
            paramMap.timestamp = l2;
            paramMap.clear = j;
            paramMap.hdo = System.currentTimeMillis();
          }
          break;
        }
      }
    }
    for (;;)
    {
      localaj.save();
      paramString = new rx();
      a.ESL.l(paramString);
      AppMethodBeat.o(168801);
      return;
      paramString = localaj.AHf;
      break;
      ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramMap.timestamp) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.7
 * JD-Core Version:    0.7.0.1
 */