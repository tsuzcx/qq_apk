package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.al.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

final class PluginWebSearch$7
  implements q
{
  PluginWebSearch$7(PluginWebSearch paramPluginWebSearch) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(168801);
    long l2;
    al localal;
    if ((paramMap != null) && (paramString != null) && (paramString.equals("mmsearch_reddot_new")))
    {
      int i = bu.aSB((String)paramMap.get(".sysmsg.mmsearch_reddot_new.entry"));
      if (i == 1)
      {
        ae.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramMap.toString() });
        int j = bu.aSB((String)paramMap.get(".sysmsg.mmsearch_reddot_new.clear"));
        parama = bu.x((String)paramMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
        int k = bu.aSB((String)paramMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
        int m = bu.aSB((String)paramMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
        long l1 = bu.aSC((String)paramMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
        int n = bu.aSB((String)paramMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
        int i1 = bu.aSB((String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
        String str1 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
        String str2 = (String)paramMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
        l2 = bu.aSC((String)paramMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
        localal = al.ePX();
        paramString = null;
        switch (i)
        {
        default: 
          paramMap = paramString;
          if (paramString == null) {
            paramMap = new al.a();
          }
          if (paramMap.timestamp < l2)
          {
            paramMap.id = parama;
            paramMap.DUu = k;
            paramMap.DUs = i;
            paramMap.DUt = m;
            paramMap.iMg = l1;
            paramMap.DTy = n;
            paramMap.type = i1;
            paramMap.text = str1;
            paramMap.dEM = str2;
            paramMap.timestamp = l2;
            paramMap.clear = j;
            paramMap.hZo = System.currentTimeMillis();
          }
          break;
        }
      }
    }
    for (;;)
    {
      localal.save();
      paramString = new su();
      a.IvT.l(paramString);
      AppMethodBeat.o(168801);
      return;
      paramString = localal.DUp;
      break;
      ae.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramMap.timestamp) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.7
 * JD-Core Version:    0.7.0.1
 */